package com.tencent.mm.plugin.gallery.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.kernel.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.n.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.s.e;
import com.tencent.mm.plugin.report.service.h;
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

public final class d
{
  private static final String[] xsA;
  private static final String[] xsB;
  public static final int xsC;
  public static final int xsD;
  public static final int xsE;
  public static final ArrayList<Integer> xsF;
  public static final ArrayList<Integer> xsG;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(173791);
    xsA = new String[] { "Pictures/Screenshots", "DCIM/Screenshots", "Screenshot" };
    xsB = new String[] { "DCIM/Video screenshots", "DCIM/Screen recordings", "DCIM/ScreenRecorder", "Movies/Screenrecords" };
    xsC = com.tencent.mm.loader.j.b.aKV().substring(0, com.tencent.mm.loader.j.b.aKV().length() - 1).toLowerCase().hashCode();
    xsD = azj("DCIM/Camera");
    xsE = azj("download");
    xsF = new ArrayList(xsA.length);
    xsG = new ArrayList(xsB.length);
    String[] arrayOfString = xsA;
    int k = arrayOfString.length;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      xsF.add(Integer.valueOf(azj(str)));
      i += 1;
    }
    arrayOfString = xsB;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      xsG.add(Integer.valueOf(azj(str)));
      i += 1;
    }
    AppMethodBeat.o(173791);
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(111745);
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZB, false);
    boolean bool2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZC, false);
    if (com.tencent.mm.kernel.g.aAf().azp()) {}
    for (int j = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Ogd, 0);; j = 0)
    {
      int i;
      if ((j == 1) || (bool1))
      {
        i = 1;
        label81:
        if ((j != 1) && (!bool2)) {
          break label217;
        }
      }
      label217:
      for (j = 1;; j = 0) {
        switch (paramInt1)
        {
        case 5: 
        case 6: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        case 21: 
        default: 
          if ((paramInt2 != 0) && (paramInt3 > 1)) {
            break label732;
          }
          paramContext = paramContext.getString(2131755976);
          AppMethodBeat.o(111745);
          return paramContext;
          i = 0;
          break label81;
        }
      }
      if ((i != 0) && (at(paramArrayList)))
      {
        paramContext = paramContext.getString(2131761115) + "(" + paramInt2 + "/" + paramInt3 + ")";
        AppMethodBeat.o(111745);
        return paramContext;
      }
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(2131761112);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(2131761112) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(2131761112);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(2131761112) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      if ((!Util.isNullOrNil(paramString)) && (paramString.equals("album_business_bubble_media_by_coordinate")))
      {
        if ((paramInt2 == 0) || (paramInt3 <= 1))
        {
          paramContext = paramContext.getString(2131755916);
          AppMethodBeat.o(111745);
          return paramContext;
        }
        paramContext = paramContext.getString(2131755916) + "(" + paramInt2 + "/" + paramInt3 + ")";
        AppMethodBeat.o(111745);
        return paramContext;
      }
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(2131761112);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(2131761112) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      if ((j != 0) && (at(paramArrayList)))
      {
        paramContext = paramContext.getString(2131761115) + "(" + paramInt2 + "/" + paramInt3 + ")";
        AppMethodBeat.o(111745);
        return paramContext;
      }
      if ((paramInt2 == 0) || (paramInt3 <= 1))
      {
        paramContext = paramContext.getString(2131761112);
        AppMethodBeat.o(111745);
        return paramContext;
      }
      paramContext = paramContext.getString(2131761112) + "(" + paramInt2 + "/" + paramInt3 + ")";
      AppMethodBeat.o(111745);
      return paramContext;
      label732:
      paramContext = paramContext.getString(2131761102, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
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
  
  public static int aqo()
  {
    AppMethodBeat.i(173786);
    int i = c.aqo();
    AppMethodBeat.o(173786);
    return i;
  }
  
  public static int aqp()
  {
    AppMethodBeat.i(173785);
    int i = c.aqp();
    AppMethodBeat.o(173785);
    return i;
  }
  
  public static int aqq()
  {
    AppMethodBeat.i(173784);
    int i = c.aqq();
    AppMethodBeat.o(173784);
    return i;
  }
  
  public static boolean at(ArrayList<GalleryItem.MediaItem> paramArrayList)
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
  
  public static int azh(String paramString)
  {
    AppMethodBeat.i(173788);
    PInt localPInt = new PInt();
    u.a(paramString, localPInt, new PInt());
    int i = localPInt.value;
    AppMethodBeat.o(173788);
    return i;
  }
  
  public static String azi(String paramString)
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
  
  public static int azj(String paramString)
  {
    AppMethodBeat.i(173790);
    int i = (Environment.getExternalStorageDirectory().toString() + "/" + paramString).toLowerCase().hashCode();
    AppMethodBeat.o(173790);
    return i;
  }
  
  public static void bw(int paramInt, String paramString)
  {
    AppMethodBeat.i(111742);
    h.CyF.kvStat(paramInt, paramString);
    AppMethodBeat.o(111742);
  }
  
  public static void c(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(111743);
    if (EventCenter.instance != null)
    {
      kz localkz = new kz();
      localkz.dQb.dQc = Boolean.valueOf(paramBoolean1);
      localkz.dQb.imagePath = paramString1;
      localkz.dQb.dQd = 0;
      localkz.dQb.toUser = paramString2;
      localkz.dQb.dQe = Boolean.valueOf(paramBoolean2);
      EventCenter.instance.publish(localkz);
    }
    AppMethodBeat.o(111743);
  }
  
  public static boolean dSA()
  {
    AppMethodBeat.i(173789);
    boolean bool = false;
    switch (com.tencent.mm.plugin.gallery.model.e.dQK().mcq)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(173789);
      return bool;
      bool = dSy();
      continue;
      bool = dSz();
    }
  }
  
  public static boolean dSB()
  {
    AppMethodBeat.i(257762);
    if (MMApplicationContext.getContext().getApplicationInfo().targetSdkVersion >= 29)
    {
      AppMethodBeat.o(257762);
      return true;
    }
    AppMethodBeat.o(257762);
    return false;
  }
  
  public static void dSa()
  {
    AppMethodBeat.i(173783);
    com.tencent.mm.plugin.report.service.g.Wm(19);
    AppMethodBeat.o(173783);
  }
  
  public static boolean dSx()
  {
    AppMethodBeat.i(173787);
    com.tencent.mm.kernel.g.aAi();
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      AppMethodBeat.o(173787);
      return false;
    }
    boolean bool = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.NZV, true);
    AppMethodBeat.o(173787);
    return bool;
  }
  
  public static boolean dSy()
  {
    AppMethodBeat.i(111746);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZB, false);
    if ((com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Ogd, 0) == 1) || (bool))
    {
      AppMethodBeat.o(111746);
      return true;
    }
    AppMethodBeat.o(111746);
    return false;
  }
  
  public static boolean dSz()
  {
    AppMethodBeat.i(111747);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZC, false);
    if ((com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.Ogd, 0) == 1) || (bool))
    {
      AppMethodBeat.o(111747);
      return true;
    }
    AppMethodBeat.o(111747);
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.a.d
 * JD-Core Version:    0.7.0.1
 */