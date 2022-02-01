package com.tencent.mm.plugin.gallery.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mv;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.plugin.gallery.model.t.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private static final String[] HRg;
  private static final String[] HRh;
  public static final int HRi;
  public static final int HRj;
  public static final int HRk;
  public static final ArrayList<Integer> HRl;
  public static final ArrayList<Integer> HRm;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(173791);
    HRg = new String[] { "Pictures/Screenshots", "DCIM/Screenshots", "Screenshot" };
    HRh = new String[] { "DCIM/Video screenshots", "DCIM/Screen recordings", "DCIM/ScreenRecorder", "Movies/Screenrecords" };
    HRi = com.tencent.mm.loader.i.b.bmL().substring(0, com.tencent.mm.loader.i.b.bmL().length() - 1).toLowerCase().hashCode();
    HRj = aFj("DCIM/Camera");
    HRk = aFj("download");
    HRl = new ArrayList(HRg.length);
    HRm = new ArrayList(HRh.length);
    String[] arrayOfString = HRg;
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      HRl.add(Integer.valueOf(aFj(str)));
      i += 1;
    }
    arrayOfString = HRh;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      HRm.add(Integer.valueOf(aFj(str)));
      i += 1;
    }
    AppMethodBeat.o(173791);
  }
  
  public static String WW(int paramInt)
  {
    AppMethodBeat.i(289296);
    String str = "";
    if (paramInt > 3600) {
      str = String.format("%d小时", new Object[] { Integer.valueOf(paramInt / 60 / 60) });
    }
    for (;;)
    {
      AppMethodBeat.o(289296);
      return str;
      if (paramInt > 60) {
        str = String.format("%d分钟", new Object[] { Integer.valueOf(paramInt / 60) });
      } else if (paramInt > 0) {
        str = String.format("%d秒", new Object[] { Integer.valueOf(paramInt) });
      }
    }
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111745);
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWw, false);
    boolean bool2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWx, false);
    if (com.tencent.mm.kernel.h.baC().aZN()) {}
    for (int j = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acWc, 0);; j = 0)
    {
      int i;
      if ((j == 1) || (bool1))
      {
        i = 1;
        label81:
        if ((j != 1) && (!bool2)) {
          break label226;
        }
      }
      label226:
      for (j = 1;; j = 0) {
        switch (paramInt1)
        {
        default: 
          if ((paramInt2 != 0) && (paramInt3 > 1)) {
            break label768;
          }
          paramContext = paramContext.getString(b.i.app_send);
          AppMethodBeat.o(111745);
          return paramContext;
          i = 0;
          break label81;
        }
      }
      paramContext = paramContext.getString(b.i.gallery_pic_timeline_send);
      AppMethodBeat.o(111745);
      return paramContext;
      if ((i != 0) && (aN(paramArrayList)))
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
      if ((j != 0) && (aN(paramArrayList)))
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
      label768:
      paramContext = paramContext.getString(b.i.gallery_pic_chatting_send, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      AppMethodBeat.o(111745);
      return paramContext;
    }
  }
  
  public static String a(String paramString, t.e parame, int paramInt)
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
  
  public static String a(String paramString, t.e parame, long paramLong)
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
  
  public static int aFh(String paramString)
  {
    AppMethodBeat.i(173788);
    PInt localPInt = new PInt();
    ab.a(paramString, localPInt, new PInt());
    int i = localPInt.value;
    AppMethodBeat.o(173788);
    return i;
  }
  
  public static String aFi(String paramString)
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
  
  public static int aFj(String paramString)
  {
    AppMethodBeat.i(173790);
    int i = (Environment.getExternalStorageDirectory().toString() + "/" + paramString).toLowerCase().hashCode();
    AppMethodBeat.o(173790);
    return i;
  }
  
  public static boolean aN(ArrayList<GalleryItem.MediaItem> paramArrayList)
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
  
  public static int aRh()
  {
    AppMethodBeat.i(173786);
    int i = com.tencent.mm.k.c.aRh();
    AppMethodBeat.o(173786);
    return i;
  }
  
  public static int aRi()
  {
    AppMethodBeat.i(173785);
    int i = com.tencent.mm.k.c.aRi();
    AppMethodBeat.o(173785);
    return i;
  }
  
  public static long aRj()
  {
    AppMethodBeat.i(289281);
    long l = com.tencent.mm.k.c.aRj();
    AppMethodBeat.o(289281);
    return l;
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111743);
    if (EventCenter.instance != null)
    {
      mv localmv = new mv();
      localmv.hOV.hOW = Boolean.valueOf(paramBoolean1);
      localmv.hOV.imagePath = paramString1;
      localmv.hOV.hOX = 0;
      localmv.hOV.toUser = paramString2;
      localmv.hOV.hOY = Boolean.valueOf(paramBoolean2);
      localmv.publish();
    }
    AppMethodBeat.o(111743);
  }
  
  public static void bZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(111742);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(paramInt, paramString);
    AppMethodBeat.o(111742);
  }
  
  public static boolean fBS()
  {
    AppMethodBeat.i(173787);
    com.tencent.mm.kernel.h.baF();
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      AppMethodBeat.o(173787);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acPr, true);
    AppMethodBeat.o(173787);
    return bool;
  }
  
  public static boolean fBT()
  {
    AppMethodBeat.i(111746);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWw, false);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acWc, 0) == 1) || (bool))
    {
      AppMethodBeat.o(111746);
      return true;
    }
    AppMethodBeat.o(111746);
    return false;
  }
  
  public static boolean fBU()
  {
    AppMethodBeat.i(111747);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWx, false);
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acWc, 0) == 1) || (bool))
    {
      AppMethodBeat.o(111747);
      return true;
    }
    AppMethodBeat.o(111747);
    return false;
  }
  
  public static boolean fBV()
  {
    AppMethodBeat.i(173789);
    boolean bool = false;
    switch (e.fAn().sfB)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(173789);
      return bool;
      bool = fBT();
      continue;
      bool = fBU();
    }
  }
  
  public static boolean fBW()
  {
    AppMethodBeat.i(289335);
    if (MMApplicationContext.getContext().getApplicationInfo().targetSdkVersion >= 29)
    {
      AppMethodBeat.o(289335);
      return true;
    }
    AppMethodBeat.o(289335);
    return false;
  }
  
  public static void fBx()
  {
    AppMethodBeat.i(173783);
    g.ahx(19);
    AppMethodBeat.o(173783);
  }
  
  public static void m(List<?> paramList, int paramInt1, int paramInt2)
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
  
  public static String rz(long paramLong)
  {
    AppMethodBeat.i(289291);
    String str = "";
    if (paramLong >= 1073741824L) {
      str = String.format("%dG", new Object[] { Long.valueOf(paramLong / 1024L / 1024L / 1024L) });
    }
    for (;;)
    {
      AppMethodBeat.o(289291);
      return str;
      if (paramLong >= 1048576L) {
        str = String.format("%dM", new Object[] { Long.valueOf(paramLong / 1024L / 1024L) });
      } else if (paramLong > 0L) {
        str = String.format("%dK", new Object[] { Long.valueOf(paramLong / 1024L) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.b.h
 * JD-Core Version:    0.7.0.1
 */