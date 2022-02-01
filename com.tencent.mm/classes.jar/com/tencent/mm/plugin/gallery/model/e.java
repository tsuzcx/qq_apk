package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;

public final class e
{
  private static int bQb = 0;
  private static volatile e sJC;
  public static boolean sJv = false;
  public static boolean sJw = false;
  public static boolean sJx = false;
  public static boolean sJy = false;
  private o rXK;
  private ArrayList<Bundle> sJA;
  private HashMap<Integer, Boolean> sJB;
  private SparseArray<GalleryItem.a> sJD;
  private c sJr;
  private g sJs;
  private ArrayList<GalleryItem.MediaItem> sJt;
  private LinkedHashSet<GalleryItem.MediaItem> sJu;
  private HashSet<GalleryItem.MediaItem> sJz;
  
  static
  {
    sJC = null;
  }
  
  private e()
  {
    AppMethodBeat.i(111261);
    this.sJt = null;
    this.sJu = new LinkedHashSet();
    this.sJz = new HashSet();
    this.sJA = new ArrayList();
    this.sJB = new HashMap();
    this.sJD = new SparseArray();
    if (this.rXK == null) {
      this.rXK = new o();
    }
    if (this.sJs == null) {
      this.sJs = new g();
    }
    if (this.sJr == null) {
      this.sJr = new c();
    }
    Object localObject = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaK, "");
    ac.i("MicroMsg.GalleryCore", "localAlbumName: %s.", new Object[] { localObject });
    try
    {
      localObject = new com.tencent.mm.ab.i((String)localObject).tX("localAlbumName");
      int i = 0;
      while (i < ((com.tencent.mm.ab.f)localObject).length())
      {
        com.tencent.mm.ab.i locali = ((com.tencent.mm.ab.f)localObject).mk(i);
        GalleryItem.a locala = new GalleryItem.a();
        locala.key = locali.optString("key");
        locala.path = locali.optString("path");
        locala.sKf = locali.optString("default");
        locala.sKg = com.tencent.mm.plugin.gallery.a.d.agL(locala.path);
        ac.d("MicroMsg.GalleryCore", "albumName info: %s.", new Object[] { locala });
        this.sJD.put(locala.sKg, locala);
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
  
  public static void FO(int paramInt)
  {
    AppMethodBeat.i(111271);
    cMr().sJB.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(111271);
  }
  
  public static void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111275);
    int j = cMt().kxr;
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ac.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[] { Integer.valueOf(j) });
      com.tencent.mm.plugin.gallery.a.d.bi(14205, i + "," + i + "," + paramArrayOfInt[0] + "," + paramArrayOfInt[1] + "," + paramArrayOfInt[2] + "," + paramArrayOfInt[3] + "," + paramBoolean1 + "," + paramBoolean2 + "," + sJv + "," + sJw + "," + sJx + "," + sJy);
      sJv = false;
      sJw = false;
      sJx = false;
      sJy = false;
      AppMethodBeat.o(111275);
      return;
      i = 1;
      continue;
      if ((!bs.isNullOrNil(paramString)) && (paramString.equals(ai.getContext().getString(2131758845))))
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
  
  public static void ab(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111270);
    cMr().sJt = paramArrayList;
    AppMethodBeat.o(111270);
  }
  
  public static GalleryItem.MediaItem ags(String paramString)
  {
    AppMethodBeat.i(111260);
    paramString = GalleryItem.MediaItem.a(0, 0L, paramString, "", "");
    if (cMr().sJt != null)
    {
      int i = cMr().sJt.indexOf(paramString);
      if (i >= 0)
      {
        paramString = (GalleryItem.MediaItem)cMr().sJt.get(i);
        AppMethodBeat.o(111260);
        return paramString;
      }
    }
    AppMethodBeat.o(111260);
    return null;
  }
  
  public static int cMA()
  {
    AppMethodBeat.i(111273);
    int i = cMr().sJB.size();
    AppMethodBeat.o(111273);
    return i;
  }
  
  public static void cMB()
  {
    AppMethodBeat.i(111276);
    bQb += 1;
    ac.i("MicroMsg.GalleryCore", "pennqin, refGallery %d.", new Object[] { Integer.valueOf(bQb) });
    AppMethodBeat.o(111276);
  }
  
  public static boolean cMC()
  {
    AppMethodBeat.i(111277);
    if (bQb > 0) {
      bQb -= 1;
    }
    ac.i("MicroMsg.GalleryCore", "pennqin, defGallery %d.", new Object[] { Integer.valueOf(bQb) });
    if (bQb == 0)
    {
      if ((sJC != null) && (sJC.sJs != null) && (sJC.sJr != null))
      {
        if (bQb != 0) {
          ac.w("MicroMsg.GalleryCore", "oh, ref count not right!!! Maybe because quick enter/back.");
        }
      }
      else
      {
        AppMethodBeat.o(111277);
        return true;
      }
      d locald;
      if (cMr().sJr != null)
      {
        ??? = p.sKH;
        ??? = p.cNd();
        ((p)???).sKD.clear();
        ((p)???).sKE.clear();
        cMs().cMn();
        sJC.sJr.b(null);
        locald = sJC.sJr.sIY;
        if (locald.sJm != null)
        {
          locald.sJm.a(new d.4(locald));
          locald.sJm = null;
        }
      }
      for (;;)
      {
        synchronized (locald.lock)
        {
          if (locald.sJn != null)
          {
            f localf = locald.sJn;
            localf.cME();
            localf.cMF();
            ai.getContext().getSharedPreferences(ai.eUX(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", localf.sJI).apply();
            locald.sJn = null;
          }
          sJC.sJr = null;
          sJC.rXK = null;
          if (sJC.sJs != null)
          {
            ??? = sJC.sJs.cML();
            if (??? != null)
            {
              ((ao)???).removeCallbacksAndMessages(null);
              sJC.sJs.cMM().removeCallbacksAndMessages(null);
              ??? = sJC.sJs.cMN();
              if (??? == null) {
                break label533;
              }
              ((ao)???).removeCallbacksAndMessages(null);
              ??? = sJC.sJs.cMO();
              if (??? == null) {
                break label545;
              }
              ((ao)???).removeCallbacksAndMessages(null);
              ??? = sJC.sJs;
              if (((g)???).sJK != null)
              {
                ((g)???).sJK.quit();
                ((g)???).sJK = null;
              }
              ((g)???).sJM = null;
              ((g)???).gox = null;
              if (((g)???).sJN != null)
              {
                ((g)???).sJN.shutdown();
                ((g)???).sJN = null;
              }
              if (((g)???).sJO != null)
              {
                ((g)???).sJO.shutdown();
                ((g)???).sJO = null;
              }
              if (((g)???).sJP != null)
              {
                ((g)???).sJP.shutdown();
                ((g)???).sJP = null;
              }
              if (((g)???).sJQ != null)
              {
                ((g)???).sJQ.quit();
                ((g)???).sJQ = null;
              }
              ((g)???).sJR = null;
              if (((g)???).sJJ != null)
              {
                ((g)???).sJJ.quit();
                ((g)???).sJJ = null;
              }
              ((g)???).sJL = null;
              sJC.sJs = null;
            }
          }
          else
          {
            sJC = null;
            ac.i("MicroMsg.GalleryCore", "stopServices: finish.");
          }
        }
        ac.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
        continue;
        label533:
        ac.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
        continue;
        label545:
        ac.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
      }
    }
    AppMethodBeat.o(111277);
    return false;
  }
  
  public static SparseArray<GalleryItem.a> cMq()
  {
    AppMethodBeat.i(173729);
    SparseArray localSparseArray = cMr().sJD;
    AppMethodBeat.o(173729);
    return localSparseArray;
  }
  
  private static e cMr()
  {
    AppMethodBeat.i(111262);
    if (sJC == null) {
      sJC = new e();
    }
    e locale = sJC;
    AppMethodBeat.o(111262);
    return locale;
  }
  
  public static c cMs()
  {
    AppMethodBeat.i(111263);
    if (cMr().sJr == null) {
      cMr().sJr = new c();
    }
    c localc = cMr().sJr;
    AppMethodBeat.o(111263);
    return localc;
  }
  
  public static o cMt()
  {
    AppMethodBeat.i(111264);
    if (cMr().rXK == null) {
      cMr().rXK = new o();
    }
    o localo = cMr().rXK;
    AppMethodBeat.o(111264);
    return localo;
  }
  
  public static g cMu()
  {
    AppMethodBeat.i(111265);
    if (cMr().sJs == null) {
      cMr().sJs = new g();
    }
    g localg = cMr().sJs;
    AppMethodBeat.o(111265);
    return localg;
  }
  
  public static ArrayList<GalleryItem.MediaItem> cMv()
  {
    AppMethodBeat.i(210015);
    ArrayList localArrayList = cMr().sJt;
    AppMethodBeat.o(210015);
    return localArrayList;
  }
  
  public static HashSet<GalleryItem.MediaItem> cMw()
  {
    AppMethodBeat.i(111267);
    HashSet localHashSet = cMr().sJz;
    AppMethodBeat.o(111267);
    return localHashSet;
  }
  
  public static ArrayList<Bundle> cMx()
  {
    AppMethodBeat.i(111268);
    ArrayList localArrayList = cMr().sJA;
    AppMethodBeat.o(111268);
    return localArrayList;
  }
  
  public static LinkedHashSet<GalleryItem.MediaItem> cMy()
  {
    AppMethodBeat.i(111269);
    LinkedHashSet localLinkedHashSet = cMr().sJu;
    AppMethodBeat.o(111269);
    return localLinkedHashSet;
  }
  
  public static void cMz()
  {
    AppMethodBeat.i(111272);
    cMr().sJB.clear();
    AppMethodBeat.o(111272);
  }
  
  public static void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111274);
    ac.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
    int i;
    if (cMt().kxr == 3) {
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
      if (cMr().sJz != null)
      {
        j = cMr().sJz.size();
        ac.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
        if (j > 0) {
          com.tencent.mm.plugin.gallery.a.d.bi(13858, i + "," + paramInt + "," + j + ",0");
        }
        ac.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.gallery.a.d.cOa()) });
        Iterator localIterator = cMr().sJA.iterator();
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
            ac.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", new Object[] { str });
            com.tencent.mm.vfs.i.deleteFile(str);
            com.tencent.mm.sdk.f.b.k(str, ai.getContext());
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
          ac.i("MicroMsg.GalleryCore", "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(k) });
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
        com.tencent.mm.plugin.gallery.a.d.bi(13857, paramInt);
        break label180;
        if (cMt().kxr != 4) {
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