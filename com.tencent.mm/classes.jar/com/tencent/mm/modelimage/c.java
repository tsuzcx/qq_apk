package com.tencent.mm.modelimage;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class c
{
  public static boolean NN(String paramString)
  {
    AppMethodBeat.i(238969);
    if (y.bEl(paramString) <= bJx())
    {
      AppMethodBeat.o(238969);
      return true;
    }
    AppMethodBeat.o(238969);
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, PBool paramPBool, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(238971);
    boolean bool = false;
    if (BitmapUtil.createThumbNailMayUseOpt(paramPBool.value, paramString1, paramInt2, paramInt1, Bitmap.CompressFormat.JPEG, paramInt3, paramString2, null, paramInt4) == 1) {
      bool = true;
    }
    if ((!bool) && (paramPBool.value))
    {
      paramPBool.value = false;
      if (BitmapUtil.createThumbNailMayUseOpt(false, paramString1, paramInt2, paramInt1, Bitmap.CompressFormat.JPEG, paramInt3, paramString2, null, paramInt4) == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(238971);
      return bool;
    }
  }
  
  public static void bF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238972);
    ((com.tencent.mm.plugin.emoji.c.c)h.ax(com.tencent.mm.plugin.emoji.c.c.class)).gG(paramString1, paramString2);
    AppMethodBeat.o(238972);
  }
  
  public static int bJx()
  {
    AppMethodBeat.i(238961);
    int i = ((a)h.ax(a.class)).aRC().getInt("C2CImgCompressFileSize", 102400);
    Log.i("MicroMsg.C2CImageUtil", "bigImgCompressFileSize: %s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(238961);
    return i;
  }
  
  public static int bJy()
  {
    AppMethodBeat.i(238965);
    try
    {
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        i = Util.getInt(((a)h.ax(a.class)).aRC().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        Log.i("MicroMsg.C2CImageUtil", "genBigImg CompressPicLevel-level:%d", new Object[] { Integer.valueOf(i) });
        int j;
        if (i > 10)
        {
          j = i;
          if (i <= 100) {}
        }
        else
        {
          j = 70;
        }
        AppMethodBeat.o(238965);
        return j;
        if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
          i = Util.getInt(((a)h.ax(a.class)).aRC().getValue("CompressPicLevelFor2G"), 40);
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
          i = Util.getInt(((a)h.ax(a.class)).aRC().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = Util.getInt(((a)h.ax(a.class)).aRC().getValue("CompressPicLevelFor4G"), 60);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  public static Point bJz()
  {
    k = 1080;
    AppMethodBeat.i(238968);
    Point localPoint = new Point(0, 1080);
    for (;;)
    {
      try
      {
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          str = ((a)h.ax(a.class)).aRC().getValue("CompressResolutionForWifi");
          j = str.indexOf("*");
          if (-1 == j) {
            continue;
          }
          i = Util.getInt(str.substring(0, j), 0);
        }
      }
      catch (Exception localException1)
      {
        String str;
        int i = 0;
        int j = 1080;
        continue;
        if (j >= 2160)
        {
          i = 0;
          j = k;
          continue;
        }
        if ((j <= 0) && (i > 3240))
        {
          j = 0;
          i = 1620;
          continue;
        }
        j = 1080;
        i = 0;
        continue;
      }
      try
      {
        j = Util.getInt(str.substring(j + 1), 1080);
        if ((i > 0) || (j > 0)) {
          continue;
        }
        i = 0;
        j = k;
      }
      catch (Exception localException2)
      {
        continue;
        continue;
      }
      localPoint.x = i;
      localPoint.y = j;
      AppMethodBeat.o(238968);
      return localPoint;
      if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
        str = ((a)h.ax(a.class)).aRC().getValue("CompressResolutionFor2G");
      } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
        str = ((a)h.ax(a.class)).aRC().getValue("CompressResolutionFor3G");
      } else {
        str = ((a)h.ax(a.class)).aRC().getValue("CompressResolutionFor4G");
      }
    }
  }
  
  public static final class a
  {
    int height;
    int oFY;
    int oFZ;
    float scale;
    int width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.c
 * JD-Core Version:    0.7.0.1
 */