package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;

public final class e
{
  public static boolean HGS = false;
  public static boolean HGT = false;
  public static boolean HGU = false;
  public static boolean HGV = false;
  private static volatile e HGZ = null;
  private static int HHa = 0;
  private q GzD;
  private c HGO;
  private g HGP;
  private ArrayList<GalleryItem.MediaItem> HGQ;
  private LinkedHashSet<GalleryItem.MediaItem> HGR;
  private HashSet<GalleryItem.MediaItem> HGW;
  private ArrayList<Bundle> HGX;
  private HashMap<Integer, Boolean> HGY;
  private SparseArray<GalleryItem.a> HHb;
  
  private e()
  {
    AppMethodBeat.i(111261);
    this.HGQ = null;
    this.HGR = new LinkedHashSet();
    this.HGW = new HashSet();
    this.HGX = new ArrayList();
    this.HGY = new HashMap();
    this.HHb = new SparseArray();
    if (this.GzD == null) {
      this.GzD = new q();
    }
    if (this.HGP == null) {
      this.HGP = new g();
    }
    if (this.HGO == null) {
      this.HGO = new c();
    }
    Object localObject = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znR, "");
    Log.i("MicroMsg.GalleryCore", "localAlbumName: %s.", new Object[] { localObject });
    try
    {
      localObject = new i((String)localObject).Fr("localAlbumName");
      int i = 0;
      while (i < ((com.tencent.mm.ad.f)localObject).length())
      {
        i locali = ((com.tencent.mm.ad.f)localObject).su(i);
        GalleryItem.a locala = new GalleryItem.a();
        locala.key = locali.optString("key");
        locala.path = locali.optString("path");
        locala.HHF = locali.optString("default");
        locala.HHG = com.tencent.mm.plugin.gallery.b.h.aFj(locala.path);
        Log.d("MicroMsg.GalleryCore", "albumName info: %s.", new Object[] { locala });
        this.HHb.put(locala.HHG, locala);
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
  
  public static void Ww(int paramInt)
  {
    AppMethodBeat.i(111271);
    fAl().HGY.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(111271);
  }
  
  public static void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111275);
    int j = fAn().sfB;
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      Log.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[] { Integer.valueOf(j) });
      com.tencent.mm.plugin.gallery.b.h.bZ(14205, i + "," + i + "," + paramArrayOfInt[0] + "," + paramArrayOfInt[1] + "," + paramArrayOfInt[2] + "," + paramArrayOfInt[3] + "," + paramBoolean1 + "," + paramBoolean2 + "," + HGS + "," + HGT + "," + HGU + "," + HGV);
      HGS = false;
      HGT = false;
      HGU = false;
      HGV = false;
      AppMethodBeat.o(111275);
      return;
      i = 1;
      continue;
      if ((!Util.isNullOrNil(paramString)) && (paramString.equals(MMApplicationContext.getContext().getString(b.i.favorite))))
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
  
  public static GalleryItem.MediaItem aEQ(String paramString)
  {
    AppMethodBeat.i(111260);
    paramString = GalleryItem.MediaItem.a(0, 0L, paramString, "", "");
    if (fAl().HGQ != null)
    {
      int i = fAl().HGQ.indexOf(paramString);
      if (i >= 0)
      {
        paramString = (GalleryItem.MediaItem)fAl().HGQ.get(i);
        AppMethodBeat.o(111260);
        return paramString;
      }
    }
    AppMethodBeat.o(111260);
    return null;
  }
  
  public static void aJ(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111270);
    fAl().HGQ = paramArrayList;
    AppMethodBeat.o(111270);
  }
  
  public static SparseArray<GalleryItem.a> fAk()
  {
    AppMethodBeat.i(173729);
    SparseArray localSparseArray = fAl().HHb;
    AppMethodBeat.o(173729);
    return localSparseArray;
  }
  
  private static e fAl()
  {
    AppMethodBeat.i(111262);
    if (HGZ == null) {
      HGZ = new e();
    }
    e locale = HGZ;
    AppMethodBeat.o(111262);
    return locale;
  }
  
  public static c fAm()
  {
    AppMethodBeat.i(111263);
    if (fAl().HGO == null) {
      fAl().HGO = new c();
    }
    c localc = fAl().HGO;
    AppMethodBeat.o(111263);
    return localc;
  }
  
  public static q fAn()
  {
    AppMethodBeat.i(111264);
    if (fAl().GzD == null) {
      fAl().GzD = new q();
    }
    q localq = fAl().GzD;
    AppMethodBeat.o(111264);
    return localq;
  }
  
  public static g fAo()
  {
    AppMethodBeat.i(111265);
    if (fAl().HGP == null) {
      fAl().HGP = new g();
    }
    g localg = fAl().HGP;
    AppMethodBeat.o(111265);
    return localg;
  }
  
  public static ArrayList<GalleryItem.MediaItem> fAp()
  {
    AppMethodBeat.i(369821);
    ArrayList localArrayList = fAl().HGQ;
    AppMethodBeat.o(369821);
    return localArrayList;
  }
  
  public static HashSet<GalleryItem.MediaItem> fAq()
  {
    AppMethodBeat.i(111267);
    HashSet localHashSet = fAl().HGW;
    AppMethodBeat.o(111267);
    return localHashSet;
  }
  
  public static ArrayList<Bundle> fAr()
  {
    AppMethodBeat.i(111268);
    ArrayList localArrayList = fAl().HGX;
    AppMethodBeat.o(111268);
    return localArrayList;
  }
  
  public static LinkedHashSet<GalleryItem.MediaItem> fAs()
  {
    AppMethodBeat.i(111269);
    LinkedHashSet localLinkedHashSet = fAl().HGR;
    AppMethodBeat.o(111269);
    return localLinkedHashSet;
  }
  
  public static void fAt()
  {
    AppMethodBeat.i(111272);
    fAl().HGY.clear();
    AppMethodBeat.o(111272);
  }
  
  public static int fAu()
  {
    AppMethodBeat.i(111273);
    int i = fAl().HGY.size();
    AppMethodBeat.o(111273);
    return i;
  }
  
  public static void fAv()
  {
    AppMethodBeat.i(111276);
    HHa += 1;
    Log.i("MicroMsg.GalleryCore", "pennqin, refGallery %d.", new Object[] { Integer.valueOf(HHa) });
    AppMethodBeat.o(111276);
  }
  
  public static boolean fAw()
  {
    AppMethodBeat.i(111277);
    if (HHa > 0) {
      HHa -= 1;
    }
    Log.i("MicroMsg.GalleryCore", "pennqin, defGallery %d.", new Object[] { Integer.valueOf(HHa) });
    if (HHa == 0)
    {
      if ((HGZ != null) && (HGZ.HGP != null) && (HGZ.HGO != null))
      {
        if (HHa != 0) {
          Log.w("MicroMsg.GalleryCore", "oh, ref count not right!!! Maybe because quick enter/back.");
        }
      }
      else
      {
        AppMethodBeat.o(111277);
        return true;
      }
      d locald;
      if (fAl().HGO != null)
      {
        ??? = r.HIe;
        ??? = r.fAT();
        ((r)???).HIf.clear();
        ((r)???).HIg.clear();
        fAm().fAh();
        HGZ.HGO.b(null);
        locald = HGZ.HGO.HGv;
        if (locald.HGJ != null)
        {
          locald.HGJ.a(new d.4(locald));
          locald.HGJ = null;
        }
      }
      for (;;)
      {
        synchronized (locald.lock)
        {
          if (locald.HGK != null)
          {
            f localf = locald.HGK;
            localf.fAy();
            localf.fAz();
            MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", localf.HHg).apply();
            locald.HGK = null;
          }
          HGZ.HGO = null;
          HGZ.GzD = null;
          if (HGZ.HGP != null)
          {
            ??? = HGZ.HGP.fAF();
            if (??? != null)
            {
              ((MMHandler)???).removeCallbacksAndMessages(null);
              HGZ.HGP.fAG().removeCallbacksAndMessages(null);
              ??? = HGZ.HGP.fAH();
              if (??? == null) {
                break label533;
              }
              ((MMHandler)???).removeCallbacksAndMessages(null);
              ??? = HGZ.HGP.fAI();
              if (??? == null) {
                break label545;
              }
              ((MMHandler)???).removeCallbacksAndMessages(null);
              ??? = HGZ.HGP;
              if (((g)???).HHi != null)
              {
                ((g)???).HHi.quit();
                ((g)???).HHi = null;
              }
              ((g)???).HHk = null;
              ((g)???).mRi = null;
              if (((g)???).HHm != null)
              {
                ((g)???).HHm.shutdown();
                ((g)???).HHm = null;
              }
              if (((g)???).HHn != null)
              {
                ((g)???).HHn.shutdown();
                ((g)???).HHn = null;
              }
              if (((g)???).HHo != null)
              {
                ((g)???).HHo.shutdown();
                ((g)???).HHo = null;
              }
              if (((g)???).HHp != null)
              {
                ((g)???).HHp.quit();
                ((g)???).HHp = null;
              }
              ((g)???).HHq = null;
              if (((g)???).HHh != null)
              {
                ((g)???).HHh.quit();
                ((g)???).HHh = null;
              }
              ((g)???).HHj = null;
              HGZ.HGP = null;
            }
          }
          else
          {
            HGZ = null;
            Log.i("MicroMsg.GalleryCore", "stopServices: finish.");
          }
        }
        Log.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
        continue;
        label533:
        Log.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
        continue;
        label545:
        Log.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
      }
    }
    AppMethodBeat.o(111277);
    return false;
  }
  
  public static void j(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111274);
    Log.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
    int i;
    if (fAn().sfB == 3) {
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
      if (fAl().HGW != null)
      {
        j = fAl().HGW.size();
        Log.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
        if (j > 0) {
          com.tencent.mm.plugin.gallery.b.h.bZ(13858, i + "," + paramInt + "," + j + ",0");
        }
        Log.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.gallery.b.h.fBS()) });
        Iterator localIterator = fAl().HGX.iterator();
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
            Log.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", new Object[] { str });
            y.deleteFile(str);
            AndroidMediaUtil.refreshMediaScanner(str, MMApplicationContext.getContext());
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
          Log.i("MicroMsg.GalleryCore", "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt), Integer.valueOf(m), Integer.valueOf(k) });
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
        com.tencent.mm.plugin.gallery.b.h.bZ(13857, paramInt);
        break label180;
        if (fAn().sfB != 4) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.e
 * JD-Core Version:    0.7.0.1
 */