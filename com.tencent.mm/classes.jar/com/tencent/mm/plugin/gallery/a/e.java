package com.tencent.mm.plugin.gallery.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.lq;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.s.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static final String[] CeZ;
  private static final String[] Cfa;
  public static final int Cfb;
  public static final int Cfc;
  public static final int Cfd;
  public static final ArrayList<Integer> Cfe;
  public static final ArrayList<Integer> Cff;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(173791);
    CeZ = new String[] { "Pictures/Screenshots", "DCIM/Screenshots", "Screenshot" };
    Cfa = new String[] { "DCIM/Video screenshots", "DCIM/Screen recordings", "DCIM/ScreenRecorder", "Movies/Screenrecords" };
    Cfb = com.tencent.mm.loader.j.b.aSX().substring(0, com.tencent.mm.loader.j.b.aSX().length() - 1).toLowerCase().hashCode();
    Cfc = aIJ("DCIM/Camera");
    Cfd = aIJ("download");
    Cfe = new ArrayList(CeZ.length);
    Cff = new ArrayList(Cfa.length);
    String[] arrayOfString = CeZ;
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      Cfe.add(Integer.valueOf(aIJ(str)));
      i += 1;
    }
    arrayOfString = Cfa;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      Cff.add(Integer.valueOf(aIJ(str)));
      i += 1;
    }
    AppMethodBeat.o(173791);
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111745);
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGB, false);
    boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGC, false);
    if (com.tencent.mm.kernel.h.aHE().aGM()) {}
    for (int j = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vut, 0);; j = 0)
    {
      int i;
      if ((j == 1) || (bool1))
      {
        i = 1;
        label81:
        if ((j != 1) && (!bool2)) {
          break label218;
        }
      }
      label218:
      for (j = 1;; j = 0) {
        switch (paramInt1)
        {
        default: 
          if ((paramInt2 != 0) && (paramInt3 > 1)) {
            break label745;
          }
          paramContext = paramContext.getString(b.i.app_send);
          AppMethodBeat.o(111745);
          return paramContext;
          i = 0;
          break label81;
        }
      }
      if ((i != 0) && (az(paramArrayList)))
      {
        paramContext = paramContext.getString(b.i.gallery_pic_video_generate_video) + "(" + paramInt2 + "/" + paramInt3 + ")";
        AppMethodBeat.o(111745);
        return paramContext;
      }
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(b.i.gallery_pic_timeline_send);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(b.i.gallery_pic_timeline_send) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(b.i.gallery_pic_timeline_send);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(b.i.gallery_pic_timeline_send) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      if ((!Util.isNullOrNil(paramString)) && (paramString.equals("album_business_bubble_media_by_coordinate")))
      {
        if ((paramInt2 == 0) || (paramInt3 <= 1))
        {
          paramContext = paramContext.getString(b.i.app_nextstep);
          AppMethodBeat.o(111745);
          return paramContext;
        }
        paramContext = paramContext.getString(b.i.app_nextstep) + "(" + paramInt2 + "/" + paramInt3 + ")";
        AppMethodBeat.o(111745);
        return paramContext;
      }
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(b.i.gallery_pic_timeline_send);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(b.i.gallery_pic_timeline_send) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      if ((j != 0) && (az(paramArrayList)))
      {
        paramContext = paramContext.getString(b.i.gallery_pic_video_generate_video) + "(" + paramInt2 + "/" + paramInt3 + ")";
        AppMethodBeat.o(111745);
        return paramContext;
      }
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(b.i.gallery_pic_timeline_send);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(b.i.gallery_pic_timeline_send) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      label745:
      paramContext = paramContext.getString(b.i.gallery_pic_chatting_send, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(111745);
      return paramContext;
    }
  }
  
  public static String a(String paramString, s.e parame, int paramInt)
  {
    AppMethodBeat.i(179480);
    if (paramString == null)
    {
      paramString = new NullPointerException("getDecodeTaskKey filePath is null!!!");
      AppMethodBeat.o(179480);
      throw paramString;
    }
    String str = paramString.concat("#*$");
    if (parame != null)
    {
      paramString = parame.id;
      parame = str.concat(paramString);
      if (-1 != paramInt) {
        break label75;
      }
    }
    label75:
    for (paramString = "";; paramString = String.valueOf(paramInt))
    {
      paramString = parame.concat(paramString);
      AppMethodBeat.o(179480);
      return paramString;
      paramString = "";
      break;
    }
  }
  
  public static String a(String paramString, s.e parame, long paramLong)
  {
    AppMethodBeat.i(179482);
    if (paramString == null)
    {
      paramString = new NullPointerException("getCacheKey filePath is null!!!");
      AppMethodBeat.o(179482);
      throw paramString;
    }
    String str = paramString.concat("#*$");
    if (parame != null) {}
    for (paramString = parame.id;; paramString = "")
    {
      paramString = str.concat(paramString).concat(String.valueOf(paramLong));
      AppMethodBeat.o(179482);
      return paramString;
    }
  }
  
  public static int aIH(String paramString)
  {
    AppMethodBeat.i(173788);
    PInt localPInt = new PInt();
    y.a(paramString, localPInt, new PInt());
    int i = localPInt.value;
    AppMethodBeat.o(173788);
    return i;
  }
  
  public static String aII(String paramString)
  {
    AppMethodBeat.i(179481);
    if (paramString == null)
    {
      paramString = new NullPointerException("getFilePathFromKey key is null!!!");
      AppMethodBeat.o(179481);
      throw paramString;
    }
    int i = paramString.indexOf("#*$");
    if (i <= 0)
    {
      paramString = new NullPointerException("getFilePathFromKey end <= 0!!!");
      AppMethodBeat.o(179481);
      throw paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(179481);
    return paramString;
  }
  
  public static int aIJ(String paramString)
  {
    AppMethodBeat.i(173790);
    int i = (Environment.getExternalStorageDirectory().toString() + "/" + paramString).toLowerCase().hashCode();
    AppMethodBeat.o(173790);
    return i;
  }
  
  public static int awH()
  {
    AppMethodBeat.i(173786);
    int i = c.awH();
    AppMethodBeat.o(173786);
    return i;
  }
  
  public static int awI()
  {
    AppMethodBeat.i(173785);
    int i = c.awI();
    AppMethodBeat.o(173785);
    return i;
  }
  
  public static long awJ()
  {
    AppMethodBeat.i(244301);
    long l = c.awJ();
    AppMethodBeat.o(244301);
    return l;
  }
  
  public static boolean az(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111744);
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      AppMethodBeat.o(111744);
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    int k = 0;
    int j = 0;
    GalleryItem.MediaItem localMediaItem;
    label67:
    int m;
    int n;
    int i1;
    if (paramArrayList.hasNext())
    {
      localMediaItem = (GalleryItem.MediaItem)paramArrayList.next();
      if (localMediaItem.getType() == 1)
      {
        j = 1;
        if (k != 0)
        {
          m = i;
          n = k;
          i1 = j;
          if (j != 0) {}
        }
        else
        {
          if (i <= 1) {
            break label148;
          }
          i1 = j;
          n = k;
          m = i;
        }
      }
    }
    for (;;)
    {
      if (((n != 0) && (i1 != 0)) || (m > 1))
      {
        AppMethodBeat.o(111744);
        return true;
        if (localMediaItem.getType() != 2) {
          break label151;
        }
        i += 1;
        k = 1;
        break label67;
      }
      AppMethodBeat.o(111744);
      return false;
      label148:
      break;
      label151:
      break label67;
      m = i;
      n = k;
      i1 = j;
    }
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111743);
    if (EventCenter.instance != null)
    {
      lq locallq = new lq();
      locallq.fJs.fJt = Boolean.valueOf(paramBoolean1);
      locallq.fJs.imagePath = paramString1;
      locallq.fJs.fJu = 0;
      locallq.fJs.toUser = paramString2;
      locallq.fJs.fJv = Boolean.valueOf(paramBoolean2);
      EventCenter.instance.publish(locallq);
    }
    AppMethodBeat.o(111743);
  }
  
  public static void bt(int paramInt, String paramString)
  {
    AppMethodBeat.i(111742);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(paramInt, paramString);
    AppMethodBeat.o(111742);
  }
  
  public static void e(List<?> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111741);
    int i = paramInt1;
    if (paramInt1 > paramInt2)
    {
      while (paramInt1 > paramInt2)
      {
        Collections.swap(paramList, paramInt1, paramInt1 - 1);
        paramInt1 -= 1;
      }
      AppMethodBeat.o(111741);
      return;
    }
    while (i < paramInt2)
    {
      Collections.swap(paramList, i, i + 1);
      i += 1;
    }
    AppMethodBeat.o(111741);
  }
  
  public static void euB()
  {
    AppMethodBeat.i(173783);
    g.adb(19);
    AppMethodBeat.o(173783);
  }
  
  public static boolean euZ()
  {
    AppMethodBeat.i(173787);
    com.tencent.mm.kernel.h.aHH();
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      AppMethodBeat.o(173787);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VnW, true);
    AppMethodBeat.o(173787);
    return bool;
  }
  
  public static boolean eva()
  {
    AppMethodBeat.i(111746);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGB, false);
    if ((com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vut, 0) == 1) || (bool))
    {
      AppMethodBeat.o(111746);
      return true;
    }
    AppMethodBeat.o(111746);
    return false;
  }
  
  public static boolean evb()
  {
    AppMethodBeat.i(111747);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGC, false);
    if ((com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vut, 0) == 1) || (bool))
    {
      AppMethodBeat.o(111747);
      return true;
    }
    AppMethodBeat.o(111747);
    return false;
  }
  
  public static boolean evc()
  {
    AppMethodBeat.i(173789);
    boolean bool = false;
    switch (com.tencent.mm.plugin.gallery.model.e.etl().pag)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(173789);
      return bool;
      bool = eva();
      continue;
      bool = evb();
    }
  }
  
  public static boolean evd()
  {
    AppMethodBeat.i(244309);
    if (MMApplicationContext.getContext().getApplicationInfo().targetSdkVersion >= 29)
    {
      AppMethodBeat.o(244309);
      return true;
    }
    AppMethodBeat.o(244309);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.e
 * JD-Core Version:    0.7.0.1
 */