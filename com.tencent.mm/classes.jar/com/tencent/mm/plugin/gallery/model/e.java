package com.tencent.mm.plugin.gallery.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;

public final class e
{
  private static int ckU = 0;
  public static boolean xik = false;
  public static boolean xil = false;
  public static boolean xim = false;
  public static boolean xin = false;
  private static volatile e xir = null;
  private o wmZ;
  private c xig;
  private g xih;
  private ArrayList<GalleryItem.MediaItem> xii;
  private LinkedHashSet<GalleryItem.MediaItem> xij;
  private HashSet<GalleryItem.MediaItem> xio;
  private ArrayList<Bundle> xip;
  private HashMap<Integer, Boolean> xiq;
  private SparseArray<GalleryItem.a> xis;
  
  private e()
  {
    AppMethodBeat.i(111261);
    this.xii = null;
    this.xij = new LinkedHashSet();
    this.xio = new HashSet();
    this.xip = new ArrayList();
    this.xiq = new HashMap();
    this.xis = new SparseArray();
    if (this.wmZ == null) {
      this.wmZ = new o();
    }
    if (this.xih == null) {
      this.xih = new g();
    }
    if (this.xig == null) {
      this.xig = new c();
    }
    Object localObject = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.skL, "");
    Log.i("MicroMsg.GalleryCore", "localAlbumName: %s.", new Object[] { localObject });
    try
    {
      localObject = new i((String)localObject).FI("localAlbumName");
      int i = 0;
      while (i < ((com.tencent.mm.ab.f)localObject).length())
      {
        i locali = ((com.tencent.mm.ab.f)localObject).pZ(i);
        GalleryItem.a locala = new GalleryItem.a();
        locala.key = locali.optString("key");
        locala.path = locali.optString("path");
        locala.xiU = locali.optString("default");
        locala.xiV = com.tencent.mm.plugin.gallery.a.d.azj(locala.path);
        Log.d("MicroMsg.GalleryCore", "albumName info: %s.", new Object[] { locala });
        this.xis.put(locala.xiV, locala);
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
  
  public static void NA(int paramInt)
  {
    AppMethodBeat.i(111271);
    dQI().xiq.put(Integer.valueOf(paramInt), Boolean.TRUE);
    AppMethodBeat.o(111271);
  }
  
  public static void a(String paramString, int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111275);
    int j = dQK().mcq;
    int i;
    switch (j)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      Log.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", new Object[] { Integer.valueOf(j) });
      com.tencent.mm.plugin.gallery.a.d.bw(14205, i + "," + i + "," + paramArrayOfInt[0] + "," + paramArrayOfInt[1] + "," + paramArrayOfInt[2] + "," + paramArrayOfInt[3] + "," + paramBoolean1 + "," + paramBoolean2 + "," + xik + "," + xil + "," + xim + "," + xin);
      xik = false;
      xil = false;
      xim = false;
      xin = false;
      AppMethodBeat.o(111275);
      return;
      i = 1;
      continue;
      if ((!Util.isNullOrNil(paramString)) && (paramString.equals(MMApplicationContext.getContext().getString(2131759168))))
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
  
  public static void ao(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111270);
    dQI().xii = paramArrayList;
    AppMethodBeat.o(111270);
  }
  
  public static GalleryItem.MediaItem ayS(String paramString)
  {
    AppMethodBeat.i(111260);
    paramString = GalleryItem.MediaItem.a(0, 0L, paramString, "", "");
    if (dQI().xii != null)
    {
      int i = dQI().xii.indexOf(paramString);
      if (i >= 0)
      {
        paramString = (GalleryItem.MediaItem)dQI().xii.get(i);
        AppMethodBeat.o(111260);
        return paramString;
      }
    }
    AppMethodBeat.o(111260);
    return null;
  }
  
  public static SparseArray<GalleryItem.a> dQH()
  {
    AppMethodBeat.i(173729);
    SparseArray localSparseArray = dQI().xis;
    AppMethodBeat.o(173729);
    return localSparseArray;
  }
  
  private static e dQI()
  {
    AppMethodBeat.i(111262);
    if (xir == null) {
      xir = new e();
    }
    e locale = xir;
    AppMethodBeat.o(111262);
    return locale;
  }
  
  public static c dQJ()
  {
    AppMethodBeat.i(111263);
    if (dQI().xig == null) {
      dQI().xig = new c();
    }
    c localc = dQI().xig;
    AppMethodBeat.o(111263);
    return localc;
  }
  
  public static o dQK()
  {
    AppMethodBeat.i(111264);
    if (dQI().wmZ == null) {
      dQI().wmZ = new o();
    }
    o localo = dQI().wmZ;
    AppMethodBeat.o(111264);
    return localo;
  }
  
  public static g dQL()
  {
    AppMethodBeat.i(111265);
    if (dQI().xih == null) {
      dQI().xih = new g();
    }
    g localg = dQI().xih;
    AppMethodBeat.o(111265);
    return localg;
  }
  
  public static ArrayList<GalleryItem.MediaItem> dQM()
  {
    AppMethodBeat.i(258738);
    ArrayList localArrayList = dQI().xii;
    AppMethodBeat.o(258738);
    return localArrayList;
  }
  
  public static HashSet<GalleryItem.MediaItem> dQN()
  {
    AppMethodBeat.i(111267);
    HashSet localHashSet = dQI().xio;
    AppMethodBeat.o(111267);
    return localHashSet;
  }
  
  public static ArrayList<Bundle> dQO()
  {
    AppMethodBeat.i(111268);
    ArrayList localArrayList = dQI().xip;
    AppMethodBeat.o(111268);
    return localArrayList;
  }
  
  public static LinkedHashSet<GalleryItem.MediaItem> dQP()
  {
    AppMethodBeat.i(111269);
    LinkedHashSet localLinkedHashSet = dQI().xij;
    AppMethodBeat.o(111269);
    return localLinkedHashSet;
  }
  
  public static void dQQ()
  {
    AppMethodBeat.i(111272);
    dQI().xiq.clear();
    AppMethodBeat.o(111272);
  }
  
  public static int dQR()
  {
    AppMethodBeat.i(111273);
    int i = dQI().xiq.size();
    AppMethodBeat.o(111273);
    return i;
  }
  
  public static void dQS()
  {
    AppMethodBeat.i(111276);
    ckU += 1;
    Log.i("MicroMsg.GalleryCore", "pennqin, refGallery %d.", new Object[] { Integer.valueOf(ckU) });
    AppMethodBeat.o(111276);
  }
  
  public static boolean dQT()
  {
    AppMethodBeat.i(111277);
    if (ckU > 0) {
      ckU -= 1;
    }
    Log.i("MicroMsg.GalleryCore", "pennqin, defGallery %d.", new Object[] { Integer.valueOf(ckU) });
    if (ckU == 0)
    {
      if ((xir != null) && (xir.xih != null) && (xir.xig != null))
      {
        if (ckU != 0) {
          Log.w("MicroMsg.GalleryCore", "oh, ref count not right!!! Maybe because quick enter/back.");
        }
      }
      else
      {
        AppMethodBeat.o(111277);
        return true;
      }
      d locald;
      if (dQI().xig != null)
      {
        ??? = p.xjw;
        ??? = p.dRt();
        ((p)???).xjs.clear();
        ((p)???).xjt.clear();
        dQJ().dQE();
        xir.xig.b(null);
        locald = xir.xig.xhN;
        if (locald.xib != null)
        {
          locald.xib.a(new d.4(locald));
          locald.xib = null;
        }
      }
      for (;;)
      {
        synchronized (locald.lock)
        {
          if (locald.xic != null)
          {
            f localf = locald.xic;
            localf.dQV();
            localf.dQW();
            MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", localf.xix).apply();
            locald.xic = null;
          }
          xir.xig = null;
          xir.wmZ = null;
          if (xir.xih != null)
          {
            ??? = xir.xih.dRc();
            if (??? != null)
            {
              ((MMHandler)???).removeCallbacksAndMessages(null);
              xir.xih.dRd().removeCallbacksAndMessages(null);
              ??? = xir.xih.dRe();
              if (??? == null) {
                break label533;
              }
              ((MMHandler)???).removeCallbacksAndMessages(null);
              ??? = xir.xih.dRf();
              if (??? == null) {
                break label545;
              }
              ((MMHandler)???).removeCallbacksAndMessages(null);
              ??? = xir.xih;
              if (((g)???).xiz != null)
              {
                ((g)???).xiz.quit();
                ((g)???).xiz = null;
              }
              ((g)???).xiB = null;
              ((g)???).hAk = null;
              if (((g)???).xiC != null)
              {
                ((g)???).xiC.shutdown();
                ((g)???).xiC = null;
              }
              if (((g)???).xiD != null)
              {
                ((g)???).xiD.shutdown();
                ((g)???).xiD = null;
              }
              if (((g)???).xiE != null)
              {
                ((g)???).xiE.shutdown();
                ((g)???).xiE = null;
              }
              if (((g)???).xiF != null)
              {
                ((g)???).xiF.quit();
                ((g)???).xiF = null;
              }
              ((g)???).xiG = null;
              if (((g)???).xiy != null)
              {
                ((g)???).xiy.quit();
                ((g)???).xiy = null;
              }
              ((g)???).xiA = null;
              xir.xih = null;
            }
          }
          else
          {
            xir = null;
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
  
  public static void g(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111274);
    Log.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1) });
    int i;
    if (dQK().mcq == 3) {
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
      if (dQI().xio != null)
      {
        j = dQI().xio.size();
        Log.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(j) });
        if (j > 0) {
          com.tencent.mm.plugin.gallery.a.d.bw(13858, i + "," + paramInt + "," + j + ",0");
        }
        Log.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.gallery.a.d.dSx()) });
        Iterator localIterator = dQI().xip.iterator();
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
            s.deleteFile(str);
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
        com.tencent.mm.plugin.gallery.a.d.bw(13857, paramInt);
        break label180;
        if (dQK().mcq != 4) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.e
 * JD-Core Version:    0.7.0.1
 */