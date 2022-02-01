package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
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
  private static int bSt = 0;
  public static boolean rAD = false;
  public static boolean rAE = false;
  public static boolean rAF = false;
  public static boolean rAG = false;
  private static volatile e rAK = null;
  private o qXi;
  private g rAA;
  private ArrayList<GalleryItem.MediaItem> rAB;
  private LinkedHashSet<GalleryItem.MediaItem> rAC;
  private HashSet<GalleryItem.MediaItem> rAH;
  private ArrayList<Bundle> rAI;
  private HashMap<Integer, Boolean> rAJ;
  private SparseArray<GalleryItem.a> rAL;
  private c rAz;
  
  private e()
  {
    AppMethodBeat.i(111261);
    this.rAB = null;
    this.rAC = new LinkedHashSet();
    this.rAH = new HashSet();
    this.rAI = new ArrayList();
    this.rAJ = new HashMap();
    this.rAL = new SparseArray();
    if (this.qXi == null) {
      this.qXi = new o();
    }
    if (this.rAA == null) {
      this.rAA = new g();
    }
    if (this.rAz == null) {
      this.rAz = new c();
    }
    Object localObject = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pww, "");
    ad.i("MicroMsg.GalleryCore", "localAlbumName: %s.", new Object[] { localObject });
    try
    {
      localObject = new com.tencent.mm.ac.i((String)localObject).qI("localAlbumName");
      int i = 0;
      while (i < ((com.tencent.mm.ac.f)localObject).length())
      {
        com.tencent.mm.ac.i locali = ((com.tencent.mm.ac.f)localObject).ml(i);
        GalleryItem.a locala = new GalleryItem.a();
        locala.key = locali.optString("key");
        locala.path = locali.optString("path");
        locala.rBn = locali.optString("default");
        locala.rBo = com.tencent.mm.plugin.gallery.a.d.abT(locala.path);
        ad.d("MicroMsg.GalleryCore", "albumName info: %s.", new Object[] { locala });
        this.rAL.put(locala.rBo, locala);
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
  
  public static void DS(int paramInt)
  {
    AppMethodBeat.i(111271);
    czf().rAJ.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(111271);
  }
  
  public static void Q(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111270);
    czf().rAB = paramArrayList;
    AppMethodBeat.o(111270);
  }
  
  public static void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111275);
    int j = czh().jWF;
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ad.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[] { Integer.valueOf(j) });
      com.tencent.mm.plugin.gallery.a.d.bd(14205, i + "," + i + "," + paramArrayOfInt[0] + "," + paramArrayOfInt[1] + "," + paramArrayOfInt[2] + "," + paramArrayOfInt[3] + "," + paramBoolean1 + "," + paramBoolean2 + "," + rAD + "," + rAE + "," + rAF + "," + rAG);
      rAD = false;
      rAE = false;
      rAF = false;
      rAG = false;
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
  
  public static GalleryItem.MediaItem abA(String paramString)
  {
    AppMethodBeat.i(111260);
    paramString = GalleryItem.MediaItem.a(0, 0L, paramString, "", "");
    if (czf().rAB != null)
    {
      int i = czf().rAB.indexOf(paramString);
      if (i >= 0)
      {
        paramString = (GalleryItem.MediaItem)czf().rAB.get(i);
        AppMethodBeat.o(111260);
        return paramString;
      }
    }
    AppMethodBeat.o(111260);
    return null;
  }
  
  public static SparseArray<GalleryItem.a> cze()
  {
    AppMethodBeat.i(173729);
    SparseArray localSparseArray = czf().rAL;
    AppMethodBeat.o(173729);
    return localSparseArray;
  }
  
  private static e czf()
  {
    AppMethodBeat.i(111262);
    if (rAK == null) {
      rAK = new e();
    }
    e locale = rAK;
    AppMethodBeat.o(111262);
    return locale;
  }
  
  public static c czg()
  {
    AppMethodBeat.i(111263);
    if (czf().rAz == null) {
      czf().rAz = new c();
    }
    c localc = czf().rAz;
    AppMethodBeat.o(111263);
    return localc;
  }
  
  public static o czh()
  {
    AppMethodBeat.i(111264);
    if (czf().qXi == null) {
      czf().qXi = new o();
    }
    o localo = czf().qXi;
    AppMethodBeat.o(111264);
    return localo;
  }
  
  public static g czi()
  {
    AppMethodBeat.i(111265);
    if (czf().rAA == null) {
      czf().rAA = new g();
    }
    g localg = czf().rAA;
    AppMethodBeat.o(111265);
    return localg;
  }
  
  public static ArrayList<GalleryItem.MediaItem> czj()
  {
    AppMethodBeat.i(200772);
    ArrayList localArrayList = czf().rAB;
    AppMethodBeat.o(200772);
    return localArrayList;
  }
  
  public static HashSet<GalleryItem.MediaItem> czk()
  {
    AppMethodBeat.i(111267);
    HashSet localHashSet = czf().rAH;
    AppMethodBeat.o(111267);
    return localHashSet;
  }
  
  public static ArrayList<Bundle> czl()
  {
    AppMethodBeat.i(111268);
    ArrayList localArrayList = czf().rAI;
    AppMethodBeat.o(111268);
    return localArrayList;
  }
  
  public static LinkedHashSet<GalleryItem.MediaItem> czm()
  {
    AppMethodBeat.i(111269);
    LinkedHashSet localLinkedHashSet = czf().rAC;
    AppMethodBeat.o(111269);
    return localLinkedHashSet;
  }
  
  public static void czn()
  {
    AppMethodBeat.i(111272);
    czf().rAJ.clear();
    AppMethodBeat.o(111272);
  }
  
  public static int czo()
  {
    AppMethodBeat.i(111273);
    int i = czf().rAJ.size();
    AppMethodBeat.o(111273);
    return i;
  }
  
  public static void czp()
  {
    AppMethodBeat.i(111276);
    bSt += 1;
    ad.i("MicroMsg.GalleryCore", "pennqin, refGallery %d.", new Object[] { Integer.valueOf(bSt) });
    AppMethodBeat.o(111276);
  }
  
  public static boolean czq()
  {
    AppMethodBeat.i(111277);
    if (bSt > 0) {
      bSt -= 1;
    }
    ad.i("MicroMsg.GalleryCore", "pennqin, defGallery %d.", new Object[] { Integer.valueOf(bSt) });
    if (bSt == 0)
    {
      if ((rAK != null) && (rAK.rAA != null) && (rAK.rAz != null))
      {
        if (bSt != 0) {
          ad.w("MicroMsg.GalleryCore", "oh, ref count not right!!! Maybe because quick enter/back.");
        }
      }
      else
      {
        AppMethodBeat.o(111277);
        return true;
      }
      d locald;
      if (czf().rAz != null)
      {
        ??? = p.rBO;
        ??? = p.czR();
        ((p)???).rBK.clear();
        ((p)???).rBL.clear();
        czg().czb();
        rAK.rAz.b(null);
        locald = rAK.rAz.rAg;
        if (locald.rAu != null)
        {
          locald.rAu.a(new d.4(locald));
          locald.rAu = null;
        }
      }
      for (;;)
      {
        synchronized (locald.lock)
        {
          if (locald.rAv != null)
          {
            f localf = locald.rAv;
            localf.czs();
            localf.czt();
            aj.getContext().getSharedPreferences(aj.eFD(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", localf.rAQ).apply();
            locald.rAv = null;
          }
          rAK.rAz = null;
          rAK.qXi = null;
          if (rAK.rAA != null)
          {
            ??? = rAK.rAA.czz();
            if (??? != null)
            {
              ((ap)???).removeCallbacksAndMessages(null);
              rAK.rAA.czA().removeCallbacksAndMessages(null);
              ??? = rAK.rAA.czB();
              if (??? == null) {
                break label533;
              }
              ((ap)???).removeCallbacksAndMessages(null);
              ??? = rAK.rAA.czC();
              if (??? == null) {
                break label545;
              }
              ((ap)???).removeCallbacksAndMessages(null);
              ??? = rAK.rAA;
              if (((g)???).rAS != null)
              {
                ((g)???).rAS.quit();
                ((g)???).rAS = null;
              }
              ((g)???).rAU = null;
              ((g)???).gAC = null;
              if (((g)???).rAV != null)
              {
                ((g)???).rAV.shutdown();
                ((g)???).rAV = null;
              }
              if (((g)???).rAW != null)
              {
                ((g)???).rAW.shutdown();
                ((g)???).rAW = null;
              }
              if (((g)???).rAX != null)
              {
                ((g)???).rAX.shutdown();
                ((g)???).rAX = null;
              }
              if (((g)???).rAY != null)
              {
                ((g)???).rAY.quit();
                ((g)???).rAY = null;
              }
              ((g)???).rAZ = null;
              if (((g)???).rAR != null)
              {
                ((g)???).rAR.quit();
                ((g)???).rAR = null;
              }
              ((g)???).rAT = null;
              rAK.rAA = null;
            }
          }
          else
          {
            rAK = null;
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
  
  public static void e(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111274);
    ad.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
    int i;
    if (czh().jWF == 3) {
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
      if (czf().rAH != null)
      {
        j = czf().rAH.size();
        ad.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
        if (j > 0) {
          com.tencent.mm.plugin.gallery.a.d.bd(13858, i + "," + paramInt + "," + j + ",0");
        }
        ad.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.gallery.a.d.cAR()) });
        Iterator localIterator = czf().rAI.iterator();
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
        com.tencent.mm.plugin.gallery.a.d.bd(13857, paramInt);
        break label180;
        if (czh().jWF != 4) {
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