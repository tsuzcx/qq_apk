package com.tencent.mm.plugin.gallery.a;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.s.e;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static final String[] ubm;
  private static final String[] ubn;
  public static final int ubo;
  public static final int ubp;
  public static final int ubq;
  public static final ArrayList<Integer> ubr;
  public static final ArrayList<Integer> ubs;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(173791);
    ubm = new String[] { "Pictures/Screenshots", "DCIM/Screenshots", "Screenshot" };
    ubn = new String[] { "DCIM/Video screenshots", "DCIM/Screen recordings", "DCIM/ScreenRecorder", "Movies/Screenrecords" };
    ubo = com.tencent.mm.loader.j.b.asv().substring(0, com.tencent.mm.loader.j.b.asv().length() - 1).toLowerCase().hashCode();
    ubp = amg("DCIM/Camera");
    ubq = amg("download");
    ubr = new ArrayList(ubm.length);
    ubs = new ArrayList(ubn.length);
    String[] arrayOfString = ubm;
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      ubr.add(Integer.valueOf(amg(str)));
      i += 1;
    }
    arrayOfString = ubn;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      ubs.add(Integer.valueOf(amg(str)));
      i += 1;
    }
    AppMethodBeat.o(173791);
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111745);
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGn, false);
    boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGo, false);
    if (com.tencent.mm.kernel.g.ajP().aiZ()) {}
    for (int j = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.IXH, 0);; j = 0)
    {
      int i;
      if ((j == 1) || (bool1))
      {
        i = 1;
        label81:
        if ((j != 1) && (!bool2)) {
          break label193;
        }
      }
      label193:
      for (j = 1;; j = 0) {
        switch (paramInt1)
        {
        default: 
          if ((paramInt2 != 0) && (paramInt3 > 1)) {
            break label708;
          }
          paramContext = paramContext.getString(2131755884);
          AppMethodBeat.o(111745);
          return paramContext;
          i = 0;
          break label81;
        }
      }
      if ((i != 0) && (af(paramArrayList)))
      {
        paramContext = paramContext.getString(2131759788) + "(" + paramInt2 + "/" + paramInt3 + ")";
        AppMethodBeat.o(111745);
        return paramContext;
      }
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(2131759785);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(2131759785) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(2131759785);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(2131759785) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      if ((!bu.isNullOrNil(paramString)) && (paramString.equals("album_business_bubble_media_by_coordinate")))
      {
        if ((paramInt2 == 0) || (paramInt3 <= 1))
        {
          paramContext = paramContext.getString(2131755830);
          AppMethodBeat.o(111745);
          return paramContext;
        }
        paramContext = paramContext.getString(2131755830) + "(" + paramInt2 + "/" + paramInt3 + ")";
        AppMethodBeat.o(111745);
        return paramContext;
      }
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(2131759785);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(2131759785) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      if ((j != 0) && (af(paramArrayList)))
      {
        paramContext = paramContext.getString(2131759788) + "(" + paramInt2 + "/" + paramInt3 + ")";
        AppMethodBeat.o(111745);
        return paramContext;
      }
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(2131759785);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(2131759785) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      label708:
      paramContext = paramContext.getString(2131759775, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
  
  public static int acp()
  {
    AppMethodBeat.i(173786);
    int i = com.tencent.mm.n.b.acp();
    AppMethodBeat.o(173786);
    return i;
  }
  
  public static int acq()
  {
    AppMethodBeat.i(173785);
    int i = com.tencent.mm.n.b.acq();
    AppMethodBeat.o(173785);
    return i;
  }
  
  public static int acr()
  {
    AppMethodBeat.i(173784);
    int i = com.tencent.mm.n.b.acr();
    AppMethodBeat.o(173784);
    return i;
  }
  
  public static boolean af(ArrayList<GalleryItem.MediaItem> paramArrayList)
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
    label65:
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
            break label144;
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
          break label147;
        }
        i += 1;
        k = 1;
        break label65;
      }
      AppMethodBeat.o(111744);
      return false;
      label144:
      break;
      label147:
      break label65;
      m = i;
      n = k;
      i1 = j;
    }
  }
  
  public static int ame(String paramString)
  {
    AppMethodBeat.i(173788);
    PInt localPInt = new PInt();
    u.a(paramString, localPInt, new PInt());
    int i = localPInt.value;
    AppMethodBeat.o(173788);
    return i;
  }
  
  public static String amf(String paramString)
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
  
  public static int amg(String paramString)
  {
    AppMethodBeat.i(173790);
    int i = (Environment.getExternalStorageDirectory().toString() + "/" + paramString).toLowerCase().hashCode();
    AppMethodBeat.o(173790);
    return i;
  }
  
  public static void bk(int paramInt, String paramString)
  {
    AppMethodBeat.i(111742);
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(paramInt, paramString);
    AppMethodBeat.o(111742);
  }
  
  public static void c(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111743);
    if (com.tencent.mm.sdk.b.a.IvT != null)
    {
      kk localkk = new kk();
      localkk.dyu.dyv = Boolean.valueOf(paramBoolean1);
      localkk.dyu.imagePath = paramString1;
      localkk.dyu.dyw = 0;
      localkk.dyu.toUser = paramString2;
      localkk.dyu.dyx = Boolean.valueOf(paramBoolean2);
      com.tencent.mm.sdk.b.a.IvT.l(localkk);
    }
    AppMethodBeat.o(111743);
  }
  
  public static void cYF()
  {
    AppMethodBeat.i(173783);
    f.OQ(19);
    AppMethodBeat.o(173783);
  }
  
  public static boolean cYY()
  {
    AppMethodBeat.i(173787);
    com.tencent.mm.kernel.g.ajS();
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      AppMethodBeat.o(173787);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IRT, true);
    AppMethodBeat.o(173787);
    return bool;
  }
  
  public static boolean cYZ()
  {
    AppMethodBeat.i(111746);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGn, false);
    if ((com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.IXH, 0) == 1) || (bool))
    {
      AppMethodBeat.o(111746);
      return true;
    }
    AppMethodBeat.o(111746);
    return false;
  }
  
  public static boolean cZa()
  {
    AppMethodBeat.i(111747);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGo, false);
    if ((com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.IXH, 0) == 1) || (bool))
    {
      AppMethodBeat.o(111747);
      return true;
    }
    AppMethodBeat.o(111747);
    return false;
  }
  
  public static boolean cZb()
  {
    AppMethodBeat.i(173789);
    boolean bool = false;
    switch (com.tencent.mm.plugin.gallery.model.e.cXr().kXg)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(173789);
      return bool;
      bool = cYZ();
      continue;
      bool = cZa();
    }
  }
  
  public static void swap(List<?> paramList, int paramInt1, int paramInt2)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.d
 * JD-Core Version:    0.7.0.1
 */