package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;

public final class e
{
  public static boolean BUA = false;
  private static volatile e BUE = null;
  private static int BUF = 0;
  public static boolean BUx = false;
  public static boolean BUy = false;
  public static boolean BUz = false;
  private o AYc;
  private HashSet<GalleryItem.MediaItem> BUB;
  private ArrayList<Bundle> BUC;
  private HashMap<Integer, Boolean> BUD;
  private SparseArray<GalleryItem.a> BUG;
  private c BUt;
  private g BUu;
  private ArrayList<GalleryItem.MediaItem> BUv;
  private LinkedHashSet<GalleryItem.MediaItem> BUw;
  
  private e()
  {
    AppMethodBeat.i(111261);
    this.BUv = null;
    this.BUw = new LinkedHashSet();
    this.BUB = new HashSet();
    this.BUC = new ArrayList();
    this.BUD = new HashMap();
    this.BUG = new SparseArray();
    if (this.AYc == null) {
      this.AYc = new o();
    }
    if (this.BUu == null) {
      this.BUu = new g();
    }
    if (this.BUt == null) {
      this.BUt = new c();
    }
    Object localObject = ((b)h.ae(b.class)).a(b.a.vVn, "");
    Log.i("MicroMsg.GalleryCore", "localAlbumName: %s.", new Object[] { localObject });
    try
    {
      localObject = new i((String)localObject).MI("localAlbumName");
      int i = 0;
      while (i < ((com.tencent.mm.ad.f)localObject).length())
      {
        i locali = ((com.tencent.mm.ad.f)localObject).sy(i);
        GalleryItem.a locala = new GalleryItem.a();
        locala.key = locali.optString("key");
        locala.path = locali.optString("path");
        locala.BVh = locali.optString("default");
        locala.BVi = com.tencent.mm.plugin.gallery.a.e.aIJ(locala.path);
        Log.d("MicroMsg.GalleryCore", "albumName info: %s.", new Object[] { locala });
        this.BUG.put(locala.BVi, locala);
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
  
  public static void SO(int paramInt)
  {
    AppMethodBeat.i(111271);
    etj().BUD.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(111271);
  }
  
  public static void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111275);
    int j = etl().pag;
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      Log.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[] { Integer.valueOf(j) });
      com.tencent.mm.plugin.gallery.a.e.bt(14205, i + "," + i + "," + paramArrayOfInt[0] + "," + paramArrayOfInt[1] + "," + paramArrayOfInt[2] + "," + paramArrayOfInt[3] + "," + paramBoolean1 + "," + paramBoolean2 + "," + BUx + "," + BUy + "," + BUz + "," + BUA);
      BUx = false;
      BUy = false;
      BUz = false;
      BUA = false;
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
  
  public static GalleryItem.MediaItem aIs(String paramString)
  {
    AppMethodBeat.i(111260);
    paramString = GalleryItem.MediaItem.a(0, 0L, paramString, "", "");
    if (etj().BUv != null)
    {
      int i = etj().BUv.indexOf(paramString);
      if (i >= 0)
      {
        paramString = (GalleryItem.MediaItem)etj().BUv.get(i);
        AppMethodBeat.o(111260);
        return paramString;
      }
    }
    AppMethodBeat.o(111260);
    return null;
  }
  
  public static void au(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111270);
    etj().BUv = paramArrayList;
    AppMethodBeat.o(111270);
  }
  
  public static SparseArray<GalleryItem.a> eti()
  {
    AppMethodBeat.i(173729);
    SparseArray localSparseArray = etj().BUG;
    AppMethodBeat.o(173729);
    return localSparseArray;
  }
  
  private static e etj()
  {
    AppMethodBeat.i(111262);
    if (BUE == null) {
      BUE = new e();
    }
    e locale = BUE;
    AppMethodBeat.o(111262);
    return locale;
  }
  
  public static c etk()
  {
    AppMethodBeat.i(111263);
    if (etj().BUt == null) {
      etj().BUt = new c();
    }
    c localc = etj().BUt;
    AppMethodBeat.o(111263);
    return localc;
  }
  
  public static o etl()
  {
    AppMethodBeat.i(111264);
    if (etj().AYc == null) {
      etj().AYc = new o();
    }
    o localo = etj().AYc;
    AppMethodBeat.o(111264);
    return localo;
  }
  
  public static g etm()
  {
    AppMethodBeat.i(111265);
    if (etj().BUu == null) {
      etj().BUu = new g();
    }
    g localg = etj().BUu;
    AppMethodBeat.o(111265);
    return localg;
  }
  
  public static ArrayList<GalleryItem.MediaItem> etn()
  {
    AppMethodBeat.i(292883);
    ArrayList localArrayList = etj().BUv;
    AppMethodBeat.o(292883);
    return localArrayList;
  }
  
  public static HashSet<GalleryItem.MediaItem> eto()
  {
    AppMethodBeat.i(111267);
    HashSet localHashSet = etj().BUB;
    AppMethodBeat.o(111267);
    return localHashSet;
  }
  
  public static ArrayList<Bundle> etp()
  {
    AppMethodBeat.i(111268);
    ArrayList localArrayList = etj().BUC;
    AppMethodBeat.o(111268);
    return localArrayList;
  }
  
  public static LinkedHashSet<GalleryItem.MediaItem> etq()
  {
    AppMethodBeat.i(111269);
    LinkedHashSet localLinkedHashSet = etj().BUw;
    AppMethodBeat.o(111269);
    return localLinkedHashSet;
  }
  
  public static void etr()
  {
    AppMethodBeat.i(111272);
    etj().BUD.clear();
    AppMethodBeat.o(111272);
  }
  
  public static int ets()
  {
    AppMethodBeat.i(111273);
    int i = etj().BUD.size();
    AppMethodBeat.o(111273);
    return i;
  }
  
  public static void ett()
  {
    AppMethodBeat.i(111276);
    BUF += 1;
    Log.i("MicroMsg.GalleryCore", "pennqin, refGallery %d.", new Object[] { Integer.valueOf(BUF) });
    AppMethodBeat.o(111276);
  }
  
  public static boolean etu()
  {
    AppMethodBeat.i(111277);
    if (BUF > 0) {
      BUF -= 1;
    }
    Log.i("MicroMsg.GalleryCore", "pennqin, defGallery %d.", new Object[] { Integer.valueOf(BUF) });
    if (BUF == 0)
    {
      if ((BUE != null) && (BUE.BUu != null) && (BUE.BUt != null))
      {
        if (BUF != 0) {
          Log.w("MicroMsg.GalleryCore", "oh, ref count not right!!! Maybe because quick enter/back.");
        }
      }
      else
      {
        AppMethodBeat.o(111277);
        return true;
      }
      d locald;
      if (etj().BUt != null)
      {
        ??? = p.BVL;
        ??? = p.etV();
        ((p)???).BVH.clear();
        ((p)???).BVI.clear();
        etk().etf();
        BUE.BUt.b(null);
        locald = BUE.BUt.BUa;
        if (locald.BUo != null)
        {
          locald.BUo.a(new d.4(locald));
          locald.BUo = null;
        }
      }
      for (;;)
      {
        synchronized (locald.lock)
        {
          if (locald.BUp != null)
          {
            f localf = locald.BUp;
            localf.etw();
            localf.etx();
            MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", localf.BUL).apply();
            locald.BUp = null;
          }
          BUE.BUt = null;
          BUE.AYc = null;
          if (BUE.BUu != null)
          {
            ??? = BUE.BUu.etD();
            if (??? != null)
            {
              ((MMHandler)???).removeCallbacksAndMessages(null);
              BUE.BUu.etE().removeCallbacksAndMessages(null);
              ??? = BUE.BUu.etF();
              if (??? == null) {
                break label533;
              }
              ((MMHandler)???).removeCallbacksAndMessages(null);
              ??? = BUE.BUu.etG();
              if (??? == null) {
                break label545;
              }
              ((MMHandler)???).removeCallbacksAndMessages(null);
              ??? = BUE.BUu;
              if (((g)???).BUN != null)
              {
                ((g)???).BUN.quit();
                ((g)???).BUN = null;
              }
              ((g)???).BUP = null;
              ((g)???).knk = null;
              if (((g)???).BUQ != null)
              {
                ((g)???).BUQ.shutdown();
                ((g)???).BUQ = null;
              }
              if (((g)???).BUR != null)
              {
                ((g)???).BUR.shutdown();
                ((g)???).BUR = null;
              }
              if (((g)???).BUS != null)
              {
                ((g)???).BUS.shutdown();
                ((g)???).BUS = null;
              }
              if (((g)???).BUT != null)
              {
                ((g)???).BUT.quit();
                ((g)???).BUT = null;
              }
              ((g)???).BUU = null;
              if (((g)???).BUM != null)
              {
                ((g)???).BUM.quit();
                ((g)???).BUM = null;
              }
              ((g)???).BUO = null;
              BUE.BUu = null;
            }
          }
          else
          {
            BUE = null;
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
  
  public static void i(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111274);
    Log.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
    int i;
    if (etl().pag == 3) {
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
      if (etj().BUB != null)
      {
        j = etj().BUB.size();
        Log.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
        if (j > 0) {
          com.tencent.mm.plugin.gallery.a.e.bt(13858, i + "," + paramInt + "," + j + ",0");
        }
        Log.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.gallery.a.e.euZ()) });
        Iterator localIterator = etj().BUC.iterator();
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
            u.deleteFile(str);
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
        com.tencent.mm.plugin.gallery.a.e.bt(13857, paramInt);
        break label180;
        if (etl().pag != 4) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.e
 * JD-Core Version:    0.7.0.1
 */