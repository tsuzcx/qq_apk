package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaUtils;", "", "()V", "DEFAULT_IMAGE_COMPRESS_QUALITY", "", "TAG", "", "doCompressImage", "srcPath", "doRotate", "shouldRotate", "", "imageFile", "imageFiles", "", "plugin-appbrand-integration_release"})
public final class r
{
  public static final r pcx;
  
  static
  {
    AppMethodBeat.i(275743);
    pcx = new r();
    AppMethodBeat.o(275743);
  }
  
  public static final String ahY(String paramString)
  {
    AppMethodBeat.i(275730);
    p.k(paramString, "srcPath");
    String str = u.n(com.tencent.mm.loader.j.b.aSX() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
    if (str == null) {
      p.iCn();
    }
    p.j(str, "VFSFileOp.exportExternal…illis() + \".jpg\", true)!!");
    long l;
    try
    {
      Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap1 == null)
      {
        Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(275730);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom");
        try
        {
          Bitmap localBitmap2 = BitmapUtil.decodeFile(paramString, null);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom retry, oom again");
          Object localObject1 = null;
        }
        catch (Exception localException1)
        {
          Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
          Object localObject2 = null;
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        try
        {
          Bitmap localBitmap3 = BitmapUtil.decodeFile(paramString, null);
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
          Object localObject3 = null;
        }
      }
    }
    catch (Exception localException3)
    {
      Object localObject4;
      for (;;)
      {
        Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
        localObject4 = null;
      }
      localObject4.recycle();
      l = Util.nowMilliSecond();
    }
    try
    {
      boolean bool = f.fb(str, paramString);
      Log.i("MicroMsg.MediaUtils", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(Util.nowMilliSecond() - l), paramString, Long.valueOf(u.bBQ(paramString)), str, Long.valueOf(new q(str).length()) });
      if (bool) {
        paramString = str;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      for (;;)
      {
        Log.e("MicroMsg.MediaUtils", "compressImage, oom");
      }
    }
    AppMethodBeat.o(275730);
    return paramString;
  }
  
  public static final String ahZ(String paramString)
  {
    AppMethodBeat.i(275733);
    p.k(paramString, "srcPath");
    Object localObject1 = Exif.fromFile(paramString);
    p.j(localObject1, "exif");
    int i = ((Exif)localObject1).getOrientationInDegree();
    if (i != 0) {
      for (;;)
      {
        try
        {
          localOptions = new BitmapFactory.Options();
          localObject1 = MMBitmapFactory.decodeFile(paramString, localOptions);
          if (localObject1 == null)
          {
            Log.e("MicroMsg.MediaUtils", "rotate image, get null bmp");
            AppMethodBeat.o(275733);
            return paramString;
          }
          localBitmap = BitmapUtil.rotate((Bitmap)localObject1, i % 360);
          localObject2 = new StringBuilder().append(com.tencent.mm.loader.j.b.aSJ()).append("microMsg.tmp.").append(System.currentTimeMillis());
          if (f.a(localOptions))
          {
            localObject1 = ".jpg";
            localObject2 = (String)localObject1;
            if (!f.a(localOptions)) {
              continue;
            }
            localObject1 = Bitmap.CompressFormat.JPEG;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          BitmapFactory.Options localOptions;
          Bitmap localBitmap;
          Object localObject2;
          continue;
          AppMethodBeat.o(275733);
          return paramString;
        }
        catch (NullPointerException localNullPointerException)
        {
          continue;
        }
        try
        {
          BitmapUtil.saveBitmapToImage(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
          if (f.a(localOptions)) {
            com.tencent.mm.plugin.appbrand.l.b.dt(paramString, (String)localObject2);
          }
          paramString = (String)localObject2;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MediaUtils", "rotate image, exception occurred when saving | %s", new Object[] { localException });
          u.deleteFile((String)localObject2);
          continue;
        }
        AppMethodBeat.o(275733);
        return paramString;
        localObject1 = ".png";
        continue;
        localObject1 = Bitmap.CompressFormat.PNG;
      }
    }
  }
  
  public static final boolean aid(String paramString)
  {
    AppMethodBeat.i(275739);
    p.k(paramString, "imageFile");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(275739);
      return false;
    }
    paramString = Exif.fromFile(paramString);
    p.j(paramString, "Exif.fromFile(imageFile)");
    if (paramString.getOrientationInDegree() != 0)
    {
      AppMethodBeat.o(275739);
      return true;
    }
    AppMethodBeat.o(275739);
    return false;
  }
  
  public static final boolean bC(List<String> paramList)
  {
    AppMethodBeat.i(275736);
    p.k(paramList, "imageFiles");
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(275736);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Exif localExif = Exif.fromFile((String)paramList.next());
      p.j(localExif, "Exif.fromFile(path)");
      if (localExif.getOrientationInDegree() != 0)
      {
        AppMethodBeat.o(275736);
        return true;
      }
    }
    AppMethodBeat.o(275736);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.r
 * JD-Core Version:    0.7.0.1
 */