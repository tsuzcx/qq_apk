package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;

public final class e
{
  private static int cao = 0;
  public static boolean tQX = false;
  public static boolean tQY = false;
  public static boolean tQZ = false;
  public static boolean tRa = false;
  private static volatile e tRe = null;
  private c tQT;
  private g tQU;
  private ArrayList<GalleryItem.MediaItem> tQV;
  private LinkedHashSet<GalleryItem.MediaItem> tQW;
  private HashSet<GalleryItem.MediaItem> tRb;
  private ArrayList<Bundle> tRc;
  private HashMap<Integer, Boolean> tRd;
  private SparseArray<GalleryItem.a> tRf;
  private o tfS;
  
  private e()
  {
    AppMethodBeat.i(111261);
    this.tQV = null;
    this.tQW = new LinkedHashSet();
    this.tRb = new HashSet();
    this.tRc = new ArrayList();
    this.tRd = new HashMap();
    this.tRf = new SparseArray();
    if (this.tfS == null) {
      this.tfS = new o();
    }
    if (this.tQU == null) {
      this.tQU = new g();
    }
    if (this.tQT == null) {
      this.tQT = new c();
    }
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNN, "");
    ae.i("MicroMsg.GalleryCore", "localAlbumName: %s.", new Object[] { localObject });
    try
    {
      localObject = new i((String)localObject).xw("localAlbumName");
      int i = 0;
      while (i < ((com.tencent.mm.ab.f)localObject).length())
      {
        i locali = ((com.tencent.mm.ab.f)localObject).mM(i);
        GalleryItem.a locala = new GalleryItem.a();
        locala.key = locali.optString("key");
        locala.path = locali.optString("path");
        locala.tRH = locali.optString("default");
        locala.tRI = com.tencent.mm.plugin.gallery.a.d.amg(locala.path);
        ae.d("MicroMsg.GalleryCore", "albumName info: %s.", new Object[] { locala });
        this.tRf.put(locala.tRI, locala);
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
  
  public static void HA(int paramInt)
  {
    AppMethodBeat.i(111271);
    cXp().tRd.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(111271);
  }
  
  public static void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111275);
    int j = cXr().kXg;
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ae.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[] { Integer.valueOf(j) });
      com.tencent.mm.plugin.gallery.a.d.bk(14205, i + "," + i + "," + paramArrayOfInt[0] + "," + paramArrayOfInt[1] + "," + paramArrayOfInt[2] + "," + paramArrayOfInt[3] + "," + paramBoolean1 + "," + paramBoolean2 + "," + tQX + "," + tQY + "," + tQZ + "," + tRa);
      tQX = false;
      tQY = false;
      tQZ = false;
      tRa = false;
      AppMethodBeat.o(111275);
      return;
      i = 1;
      continue;
      if ((!bu.isNullOrNil(paramString)) && (paramString.equals(ak.getContext().getString(2131758845))))
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
    cXp().tQV = paramArrayList;
    AppMethodBeat.o(111270);
  }
  
  public static GalleryItem.MediaItem alO(String paramString)
  {
    AppMethodBeat.i(111260);
    paramString = GalleryItem.MediaItem.a(0, 0L, paramString, "", "");
    if (cXp().tQV != null)
    {
      int i = cXp().tQV.indexOf(paramString);
      if (i >= 0)
      {
        paramString = (GalleryItem.MediaItem)cXp().tQV.get(i);
        AppMethodBeat.o(111260);
        return paramString;
      }
    }
    AppMethodBeat.o(111260);
    return null;
  }
  
  public static boolean cXA()
  {
    AppMethodBeat.i(111277);
    if (cao > 0) {
      cao -= 1;
    }
    ae.i("MicroMsg.GalleryCore", "pennqin, defGallery %d.", new Object[] { Integer.valueOf(cao) });
    if (cao == 0)
    {
      if ((tRe != null) && (tRe.tQU != null) && (tRe.tQT != null))
      {
        if (cao != 0) {
          ae.w("MicroMsg.GalleryCore", "oh, ref count not right!!! Maybe because quick enter/back.");
        }
      }
      else
      {
        AppMethodBeat.o(111277);
        return true;
      }
      d locald;
      if (cXp().tQT != null)
      {
        ??? = p.tSj;
        ??? = p.cYa();
        ((p)???).tSf.clear();
        ((p)???).tSg.clear();
        cXq().cXl();
        tRe.tQT.b(null);
        locald = tRe.tQT.tQA;
        if (locald.tQO != null)
        {
          locald.tQO.a(new d.4(locald));
          locald.tQO = null;
        }
      }
      for (;;)
      {
        synchronized (locald.lock)
        {
          if (locald.tQP != null)
          {
            f localf = locald.tQP;
            localf.cXC();
            localf.cXD();
            ak.getContext().getSharedPreferences(ak.fow(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", localf.tRk).apply();
            locald.tQP = null;
          }
          tRe.tQT = null;
          tRe.tfS = null;
          if (tRe.tQU != null)
          {
            ??? = tRe.tQU.cXJ();
            if (??? != null)
            {
              ((aq)???).removeCallbacksAndMessages(null);
              tRe.tQU.cXK().removeCallbacksAndMessages(null);
              ??? = tRe.tQU.cXL();
              if (??? == null) {
                break label533;
              }
              ((aq)???).removeCallbacksAndMessages(null);
              ??? = tRe.tQU.cXM();
              if (??? == null) {
                break label545;
              }
              ((aq)???).removeCallbacksAndMessages(null);
              ??? = tRe.tQU;
              if (((g)???).tRm != null)
              {
                ((g)???).tRm.quit();
                ((g)???).tRm = null;
              }
              ((g)???).tRo = null;
              ((g)???).gKO = null;
              if (((g)???).tRp != null)
              {
                ((g)???).tRp.shutdown();
                ((g)???).tRp = null;
              }
              if (((g)???).tRq != null)
              {
                ((g)???).tRq.shutdown();
                ((g)???).tRq = null;
              }
              if (((g)???).tRr != null)
              {
                ((g)???).tRr.shutdown();
                ((g)???).tRr = null;
              }
              if (((g)???).tRs != null)
              {
                ((g)???).tRs.quit();
                ((g)???).tRs = null;
              }
              ((g)???).tRt = null;
              if (((g)???).tRl != null)
              {
                ((g)???).tRl.quit();
                ((g)???).tRl = null;
              }
              ((g)???).tRn = null;
              tRe.tQU = null;
            }
          }
          else
          {
            tRe = null;
            ae.i("MicroMsg.GalleryCore", "stopServices: finish.");
          }
        }
        ae.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
        continue;
        label533:
        ae.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
        continue;
        label545:
        ae.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
      }
    }
    AppMethodBeat.o(111277);
    return false;
  }
  
  public static SparseArray<GalleryItem.a> cXo()
  {
    AppMethodBeat.i(173729);
    SparseArray localSparseArray = cXp().tRf;
    AppMethodBeat.o(173729);
    return localSparseArray;
  }
  
  private static e cXp()
  {
    AppMethodBeat.i(111262);
    if (tRe == null) {
      tRe = new e();
    }
    e locale = tRe;
    AppMethodBeat.o(111262);
    return locale;
  }
  
  public static c cXq()
  {
    AppMethodBeat.i(111263);
    if (cXp().tQT == null) {
      cXp().tQT = new c();
    }
    c localc = cXp().tQT;
    AppMethodBeat.o(111263);
    return localc;
  }
  
  public static o cXr()
  {
    AppMethodBeat.i(111264);
    if (cXp().tfS == null) {
      cXp().tfS = new o();
    }
    o localo = cXp().tfS;
    AppMethodBeat.o(111264);
    return localo;
  }
  
  public static g cXs()
  {
    AppMethodBeat.i(111265);
    if (cXp().tQU == null) {
      cXp().tQU = new g();
    }
    g localg = cXp().tQU;
    AppMethodBeat.o(111265);
    return localg;
  }
  
  public static ArrayList<GalleryItem.MediaItem> cXt()
  {
    AppMethodBeat.i(224175);
    ArrayList localArrayList = cXp().tQV;
    AppMethodBeat.o(224175);
    return localArrayList;
  }
  
  public static HashSet<GalleryItem.MediaItem> cXu()
  {
    AppMethodBeat.i(111267);
    HashSet localHashSet = cXp().tRb;
    AppMethodBeat.o(111267);
    return localHashSet;
  }
  
  public static ArrayList<Bundle> cXv()
  {
    AppMethodBeat.i(111268);
    ArrayList localArrayList = cXp().tRc;
    AppMethodBeat.o(111268);
    return localArrayList;
  }
  
  public static LinkedHashSet<GalleryItem.MediaItem> cXw()
  {
    AppMethodBeat.i(111269);
    LinkedHashSet localLinkedHashSet = cXp().tQW;
    AppMethodBeat.o(111269);
    return localLinkedHashSet;
  }
  
  public static void cXx()
  {
    AppMethodBeat.i(111272);
    cXp().tRd.clear();
    AppMethodBeat.o(111272);
  }
  
  public static int cXy()
  {
    AppMethodBeat.i(111273);
    int i = cXp().tRd.size();
    AppMethodBeat.o(111273);
    return i;
  }
  
  public static void cXz()
  {
    AppMethodBeat.i(111276);
    cao += 1;
    ae.i("MicroMsg.GalleryCore", "pennqin, refGallery %d.", new Object[] { Integer.valueOf(cao) });
    AppMethodBeat.o(111276);
  }
  
  public static void f(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111274);
    ae.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
    int i;
    if (cXr().kXg == 3) {
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
      if (cXp().tRb != null)
      {
        j = cXp().tRb.size();
        ae.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
        if (j > 0) {
          com.tencent.mm.plugin.gallery.a.d.bk(13858, i + "," + paramInt + "," + j + ",0");
        }
        ae.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.gallery.a.d.cYY()) });
        Iterator localIterator = cXp().tRc.iterator();
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
            ae.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", new Object[] { str });
            com.tencent.mm.vfs.o.deleteFile(str);
            com.tencent.mm.sdk.f.b.k(str, ak.getContext());
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
          ae.i("MicroMsg.GalleryCore", "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(k) });
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
        com.tencent.mm.plugin.gallery.a.d.bk(13857, paramInt);
        break label180;
        if (cXr().kXg != 4) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.e
 * JD-Core Version:    0.7.0.1
 */