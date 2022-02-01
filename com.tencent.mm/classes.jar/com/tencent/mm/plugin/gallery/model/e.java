package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;

public final class e
{
  private static int cao = 0;
  public static boolean tGg = false;
  public static boolean tGh = false;
  public static boolean tGi = false;
  public static boolean tGj = false;
  private static volatile e tGn = null;
  private o sUE;
  private c tGc;
  private g tGd;
  private ArrayList<GalleryItem.MediaItem> tGe;
  private LinkedHashSet<GalleryItem.MediaItem> tGf;
  private HashSet<GalleryItem.MediaItem> tGk;
  private ArrayList<Bundle> tGl;
  private HashMap<Integer, Boolean> tGm;
  private SparseArray<GalleryItem.a> tGo;
  
  private e()
  {
    AppMethodBeat.i(111261);
    this.tGe = null;
    this.tGf = new LinkedHashSet();
    this.tGk = new HashSet();
    this.tGl = new ArrayList();
    this.tGm = new HashMap();
    this.tGo = new SparseArray();
    if (this.sUE == null) {
      this.sUE = new o();
    }
    if (this.tGd == null) {
      this.tGd = new g();
    }
    if (this.tGc == null) {
      this.tGc = new c();
    }
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGh, "");
    ad.i("MicroMsg.GalleryCore", "localAlbumName: %s.", new Object[] { localObject });
    try
    {
      localObject = new com.tencent.mm.ac.i((String)localObject).wN("localAlbumName");
      int i = 0;
      while (i < ((com.tencent.mm.ac.f)localObject).length())
      {
        com.tencent.mm.ac.i locali = ((com.tencent.mm.ac.f)localObject).mJ(i);
        GalleryItem.a locala = new GalleryItem.a();
        locala.key = locali.optString("key");
        locala.path = locali.optString("path");
        locala.tGQ = locali.optString("default");
        locala.tGR = com.tencent.mm.plugin.gallery.a.d.ali(locala.path);
        ad.d("MicroMsg.GalleryCore", "albumName info: %s.", new Object[] { locala });
        this.tGo.put(locala.tGR, locala);
        i += 1;
      }
      AppMethodBeat.o(111261);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(111261);
    }
  }
  
  public static void Hd(int paramInt)
  {
    AppMethodBeat.i(111271);
    cUK().tGm.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(111271);
  }
  
  public static void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111275);
    int j = cUM().kTx;
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ad.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[] { Integer.valueOf(j) });
      com.tencent.mm.plugin.gallery.a.d.bl(14205, i + "," + i + "," + paramArrayOfInt[0] + "," + paramArrayOfInt[1] + "," + paramArrayOfInt[2] + "," + paramArrayOfInt[3] + "," + paramBoolean1 + "," + paramBoolean2 + "," + tGg + "," + tGh + "," + tGi + "," + tGj);
      tGg = false;
      tGh = false;
      tGi = false;
      tGj = false;
      AppMethodBeat.o(111275);
      return;
      i = 1;
      continue;
      if ((!bt.isNullOrNil(paramString)) && (paramString.equals(aj.getContext().getString(2131758845))))
      {
        i = 6;
      }
      else
      {
        i = 2;
        continue;
        i = 3;
      }
    }
  }
  
  public static void aa(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111270);
    cUK().tGe = paramArrayList;
    AppMethodBeat.o(111270);
  }
  
  public static GalleryItem.MediaItem akQ(String paramString)
  {
    AppMethodBeat.i(111260);
    paramString = GalleryItem.MediaItem.a(0, 0L, paramString, "", "");
    if (cUK().tGe != null)
    {
      int i = cUK().tGe.indexOf(paramString);
      if (i >= 0)
      {
        paramString = (GalleryItem.MediaItem)cUK().tGe.get(i);
        AppMethodBeat.o(111260);
        return paramString;
      }
    }
    AppMethodBeat.o(111260);
    return null;
  }
  
  public static SparseArray<GalleryItem.a> cUJ()
  {
    AppMethodBeat.i(173729);
    SparseArray localSparseArray = cUK().tGo;
    AppMethodBeat.o(173729);
    return localSparseArray;
  }
  
  private static e cUK()
  {
    AppMethodBeat.i(111262);
    if (tGn == null) {
      tGn = new e();
    }
    e locale = tGn;
    AppMethodBeat.o(111262);
    return locale;
  }
  
  public static c cUL()
  {
    AppMethodBeat.i(111263);
    if (cUK().tGc == null) {
      cUK().tGc = new c();
    }
    c localc = cUK().tGc;
    AppMethodBeat.o(111263);
    return localc;
  }
  
  public static o cUM()
  {
    AppMethodBeat.i(111264);
    if (cUK().sUE == null) {
      cUK().sUE = new o();
    }
    o localo = cUK().sUE;
    AppMethodBeat.o(111264);
    return localo;
  }
  
  public static g cUN()
  {
    AppMethodBeat.i(111265);
    if (cUK().tGd == null) {
      cUK().tGd = new g();
    }
    g localg = cUK().tGd;
    AppMethodBeat.o(111265);
    return localg;
  }
  
  public static ArrayList<GalleryItem.MediaItem> cUO()
  {
    AppMethodBeat.i(221184);
    ArrayList localArrayList = cUK().tGe;
    AppMethodBeat.o(221184);
    return localArrayList;
  }
  
  public static HashSet<GalleryItem.MediaItem> cUP()
  {
    AppMethodBeat.i(111267);
    HashSet localHashSet = cUK().tGk;
    AppMethodBeat.o(111267);
    return localHashSet;
  }
  
  public static ArrayList<Bundle> cUQ()
  {
    AppMethodBeat.i(111268);
    ArrayList localArrayList = cUK().tGl;
    AppMethodBeat.o(111268);
    return localArrayList;
  }
  
  public static LinkedHashSet<GalleryItem.MediaItem> cUR()
  {
    AppMethodBeat.i(111269);
    LinkedHashSet localLinkedHashSet = cUK().tGf;
    AppMethodBeat.o(111269);
    return localLinkedHashSet;
  }
  
  public static void cUS()
  {
    AppMethodBeat.i(111272);
    cUK().tGm.clear();
    AppMethodBeat.o(111272);
  }
  
  public static int cUT()
  {
    AppMethodBeat.i(111273);
    int i = cUK().tGm.size();
    AppMethodBeat.o(111273);
    return i;
  }
  
  public static void cUU()
  {
    AppMethodBeat.i(111276);
    cao += 1;
    ad.i("MicroMsg.GalleryCore", "pennqin, refGallery %d.", new Object[] { Integer.valueOf(cao) });
    AppMethodBeat.o(111276);
  }
  
  public static boolean cUV()
  {
    AppMethodBeat.i(111277);
    if (cao > 0) {
      cao -= 1;
    }
    ad.i("MicroMsg.GalleryCore", "pennqin, defGallery %d.", new Object[] { Integer.valueOf(cao) });
    if (cao == 0)
    {
      if ((tGn != null) && (tGn.tGd != null) && (tGn.tGc != null))
      {
        if (cao != 0) {
          ad.w("MicroMsg.GalleryCore", "oh, ref count not right!!! Maybe because quick enter/back.");
        }
      }
      else
      {
        AppMethodBeat.o(111277);
        return true;
      }
      d locald;
      if (cUK().tGc != null)
      {
        ??? = p.tHs;
        ??? = p.cVv();
        ((p)???).tHo.clear();
        ((p)???).tHp.clear();
        cUL().cUG();
        tGn.tGc.b(null);
        locald = tGn.tGc.tFJ;
        if (locald.tFX != null)
        {
          locald.tFX.a(new d.4(locald));
          locald.tFX = null;
        }
      }
      for (;;)
      {
        synchronized (locald.lock)
        {
          if (locald.tFY != null)
          {
            f localf = locald.tFY;
            localf.cUX();
            localf.cUY();
            aj.getContext().getSharedPreferences(aj.fkC(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", localf.tGt).apply();
            locald.tFY = null;
          }
          tGn.tGc = null;
          tGn.sUE = null;
          if (tGn.tGd != null)
          {
            ??? = tGn.tGd.cVe();
            if (??? != null)
            {
              ((ap)???).removeCallbacksAndMessages(null);
              tGn.tGd.cVf().removeCallbacksAndMessages(null);
              ??? = tGn.tGd.cVg();
              if (??? == null) {
                break label533;
              }
              ((ap)???).removeCallbacksAndMessages(null);
              ??? = tGn.tGd.cVh();
              if (??? == null) {
                break label545;
              }
              ((ap)???).removeCallbacksAndMessages(null);
              ??? = tGn.tGd;
              if (((g)???).tGv != null)
              {
                ((g)???).tGv.quit();
                ((g)???).tGv = null;
              }
              ((g)???).tGx = null;
              ((g)???).gIf = null;
              if (((g)???).tGy != null)
              {
                ((g)???).tGy.shutdown();
                ((g)???).tGy = null;
              }
              if (((g)???).tGz != null)
              {
                ((g)???).tGz.shutdown();
                ((g)???).tGz = null;
              }
              if (((g)???).tGA != null)
              {
                ((g)???).tGA.shutdown();
                ((g)???).tGA = null;
              }
              if (((g)???).tGB != null)
              {
                ((g)???).tGB.quit();
                ((g)???).tGB = null;
              }
              ((g)???).tGC = null;
              if (((g)???).tGu != null)
              {
                ((g)???).tGu.quit();
                ((g)???).tGu = null;
              }
              ((g)???).tGw = null;
              tGn.tGd = null;
            }
          }
          else
          {
            tGn = null;
            ad.i("MicroMsg.GalleryCore", "stopServices: finish.");
          }
        }
        ad.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
        continue;
        label533:
        ad.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
        continue;
        label545:
        ad.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
      }
    }
    AppMethodBeat.o(111277);
    return false;
  }
  
  public static void f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111274);
    ad.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
    int i;
    if (cUM().kTx == 3) {
      i = 1;
    }
    for (;;)
    {
      int j;
      label64:
      Object localObject;
      label180:
      label324:
      int k;
      if (cUK().tGk != null)
      {
        j = cUK().tGk.size();
        ad.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
        if (j > 0) {
          com.tencent.mm.plugin.gallery.a.d.bl(13858, i + "," + paramInt + "," + j + ",0");
        }
        ad.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.gallery.a.d.cWt()) });
        Iterator localIterator = cUK().tGl.iterator();
        int n;
        int i1;
        int i2;
        int i3;
        boolean bool1;
        int m;
        boolean bool2;
        label332:
        do
        {
          if (!localIterator.hasNext()) {
            break label571;
          }
          localObject = (Bundle)localIterator.next();
          String str = ((Bundle)localObject).getString("after_photo_edit");
          if (!paramBoolean2)
          {
            ad.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", new Object[] { str });
            com.tencent.mm.vfs.i.deleteFile(str);
            com.tencent.mm.sdk.f.b.k(str, aj.getContext());
          }
          n = ((Bundle)localObject).getInt("report_info_emotion_count");
          i1 = ((Bundle)localObject).getInt("report_info_text_count");
          i2 = ((Bundle)localObject).getInt("report_info_mosaic_count");
          i3 = ((Bundle)localObject).getInt("report_info_doodle_count");
          bool1 = ((Bundle)localObject).getBoolean("report_info_iscrop");
          m = ((Bundle)localObject).getInt("report_info_undo_count");
          bool2 = ((Bundle)localObject).getBoolean("report_info_is_rotation");
          if (!bool1) {
            break;
          }
          paramInt = 1;
          if (!bool2) {
            break label555;
          }
          k = 1;
          ad.i("MicroMsg.GalleryCore", "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(k) });
        } while (j <= 0);
        localObject = new StringBuilder().append(i).append(",").append(paramBoolean1).append(",").append(n).append(",").append(i1).append(",").append(i2).append(",").append(i3).append(",");
        if (!bool1) {
          break label561;
        }
        paramInt = 1;
        label480:
        localObject = ((StringBuilder)localObject).append(paramInt).append(",").append(m).append(",2");
        if (!bool2) {
          break label566;
        }
      }
      label555:
      label561:
      label566:
      for (paramInt = 1;; paramInt = 0)
      {
        com.tencent.mm.plugin.gallery.a.d.bl(13857, paramInt);
        break label180;
        if (cUM().kTx != 4) {
          break label578;
        }
        i = 2;
        break;
        j = 0;
        break label64;
        paramInt = 0;
        break label324;
        k = 0;
        break label332;
        paramInt = 0;
        break label480;
      }
      label571:
      AppMethodBeat.o(111274);
      return;
      label578:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.e
 * JD-Core Version:    0.7.0.1
 */