package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaUtils;", "", "()V", "DEFAULT_IMAGE_COMPRESS_QUALITY", "", "TAG", "", "doCompressImage", "srcPath", "doRotate", "shouldRotate", "", "imageFile", "imageFiles", "", "plugin-appbrand-integration_release"})
public final class r
{
  public static final r kVK;
  
  static
  {
    AppMethodBeat.i(189151);
    kVK = new r();
    AppMethodBeat.o(189151);
  }
  
  public static final String PX(String paramString)
  {
    AppMethodBeat.i(189147);
    p.h(paramString, "srcPath");
    String str = i.k(com.tencent.mm.loader.j.b.asg() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
    long l;
    try
    {
      Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap1 == null)
      {
        ad.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(189147);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        ad.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom");
        try
        {
          Bitmap localBitmap2 = g.decodeFile(paramString, null);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          ad.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom retry, oom again");
          Object localObject1 = null;
        }
        catch (Exception localException1)
        {
          ad.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
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
          Bitmap localBitmap3 = g.decodeFile(paramString, null);
        }
        catch (Exception localException2)
        {
          ad.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
          Object localObject3 = null;
        }
      }
    }
    catch (Exception localException3)
    {
      Object localObject4;
      for (;;)
      {
        ad.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
        localObject4 = null;
      }
      localObject4.recycle();
      l = bt.flT();
    }
    try
    {
      boolean bool = c.es(str, paramString);
      ad.i("MicroMsg.MediaUtils", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(bt.flT() - l), paramString, Long.valueOf(i.aYo(paramString)), str, Long.valueOf(new e(str).length()) });
      if (bool) {
        paramString = str;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      for (;;)
      {
        ad.e("MicroMsg.MediaUtils", "compressImage, oom");
      }
    }
    AppMethodBeat.o(189147);
    return paramString;
  }
  
  public static final String PY(String paramString)
  {
    AppMethodBeat.i(189148);
    p.h(paramString, "srcPath");
    Object localObject1 = Exif.fromFile(paramString);
    p.g(localObject1, "exif");
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
            ad.e("MicroMsg.MediaUtils", "rotate image, get null bmp");
            AppMethodBeat.o(189148);
            return paramString;
          }
          localBitmap = g.a((Bitmap)localObject1, i % 360);
          localObject2 = new StringBuilder().append(com.tencent.mm.loader.j.b.arS()).append("microMsg.tmp.").append(System.currentTimeMillis());
          if (c.d(localOptions))
          {
            localObject1 = ".jpg";
            localObject2 = (String)localObject1;
            if (!c.d(localOptions)) {
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
          AppMethodBeat.o(189148);
          return paramString;
        }
        catch (NullPointerException localNullPointerException)
        {
          continue;
        }
        try
        {
          g.a(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
          if (c.d(localOptions)) {
            com.tencent.mm.plugin.appbrand.l.b.cT(paramString, (String)localObject2);
          }
          paramString = (String)localObject2;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.MediaUtils", "rotate image, exception occurred when saving | %s", new Object[] { localException });
          i.deleteFile((String)localObject2);
          continue;
        }
        AppMethodBeat.o(189148);
        return paramString;
        localObject1 = ".png";
        continue;
        localObject1 = Bitmap.CompressFormat.PNG;
      }
    }
  }
  
  public static final boolean Qc(String paramString)
  {
    AppMethodBeat.i(189150);
    p.h(paramString, "imageFile");
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(189150);
      return false;
    }
    paramString = Exif.fromFile(paramString);
    p.g(paramString, "Exif.fromFile(imageFile)");
    if (paramString.getOrientationInDegree() != 0)
    {
      AppMethodBeat.o(189150);
      return true;
    }
    AppMethodBeat.o(189150);
    return false;
  }
  
  public static final boolean bp(List<String> paramList)
  {
    AppMethodBeat.i(189149);
    p.h(paramList, "imageFiles");
    if (bt.hj(paramList))
    {
      AppMethodBeat.o(189149);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Exif localExif = Exif.fromFile((String)paramList.next());
      p.g(localExif, "Exif.fromFile(path)");
      if (localExif.getOrientationInDegree() != 0)
      {
        AppMethodBeat.o(189149);
        return true;
      }
    }
    AppMethodBeat.o(189149);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.r
 * JD-Core Version:    0.7.0.1
 */