package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaUtils;", "", "()V", "DEFAULT_IMAGE_COMPRESS_QUALITY", "", "TAG", "", "doCompressImage", "srcPath", "doRotate", "shouldRotate", "", "imageFile", "imageFiles", "", "plugin-appbrand-integration_release"})
public final class q
{
  public static final q kzA;
  
  static
  {
    AppMethodBeat.i(187218);
    kzA = new q();
    AppMethodBeat.o(187218);
  }
  
  public static final String MA(String paramString)
  {
    AppMethodBeat.i(187215);
    k.h(paramString, "srcPath");
    Object localObject1 = Exif.fromFile(paramString);
    k.g(localObject1, "exif");
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
            ac.e("MicroMsg.MediaUtils", "rotate image, get null bmp");
            AppMethodBeat.o(187215);
            return paramString;
          }
          localBitmap = f.a((Bitmap)localObject1, i % 360);
          localObject2 = new StringBuilder().append(com.tencent.mm.loader.j.b.apf()).append("microMsg.tmp.").append(System.currentTimeMillis());
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
          AppMethodBeat.o(187215);
          return paramString;
        }
        catch (NullPointerException localNullPointerException)
        {
          continue;
        }
        try
        {
          f.a(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
          if (c.d(localOptions)) {
            com.tencent.mm.plugin.appbrand.m.b.cR(paramString, (String)localObject2);
          }
          paramString = (String)localObject2;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.MediaUtils", "rotate image, exception occurred when saving | %s", new Object[] { localException });
          i.deleteFile((String)localObject2);
          continue;
        }
        AppMethodBeat.o(187215);
        return paramString;
        localObject1 = ".png";
        continue;
        localObject1 = Bitmap.CompressFormat.PNG;
      }
    }
  }
  
  public static final boolean ME(String paramString)
  {
    AppMethodBeat.i(187217);
    k.h(paramString, "imageFile");
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(187217);
      return false;
    }
    paramString = Exif.fromFile(paramString);
    k.g(paramString, "Exif.fromFile(imageFile)");
    if (paramString.getOrientationInDegree() != 0)
    {
      AppMethodBeat.o(187217);
      return true;
    }
    AppMethodBeat.o(187217);
    return false;
  }
  
  public static final String Mz(String paramString)
  {
    AppMethodBeat.i(187214);
    k.h(paramString, "srcPath");
    String str = i.k(com.tencent.mm.loader.j.b.aps() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
    long l;
    try
    {
      Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap1 == null)
      {
        ac.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(187214);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        ac.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom");
        try
        {
          Bitmap localBitmap2 = f.decodeFile(paramString, null);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          ac.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom retry, oom again");
          Object localObject1 = null;
        }
        catch (Exception localException1)
        {
          ac.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
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
          Bitmap localBitmap3 = f.decodeFile(paramString, null);
        }
        catch (Exception localException2)
        {
          ac.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
          Object localObject3 = null;
        }
      }
    }
    catch (Exception localException3)
    {
      Object localObject4;
      for (;;)
      {
        ac.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
        localObject4 = null;
      }
      localObject4.recycle();
      l = bs.eWj();
    }
    try
    {
      boolean bool = c.ej(str, paramString);
      ac.i("MicroMsg.MediaUtils", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(bs.eWj() - l), paramString, Long.valueOf(i.aSp(paramString)), str, Long.valueOf(new e(str).length()) });
      if (bool) {
        paramString = str;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      for (;;)
      {
        ac.e("MicroMsg.MediaUtils", "compressImage, oom");
      }
    }
    AppMethodBeat.o(187214);
    return paramString;
  }
  
  public static final boolean bn(List<String> paramList)
  {
    AppMethodBeat.i(187216);
    k.h(paramList, "imageFiles");
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(187216);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Exif localExif = Exif.fromFile((String)paramList.next());
      k.g(localExif, "Exif.fromFile(path)");
      if (localExif.getOrientationInDegree() != 0)
      {
        AppMethodBeat.o(187216);
        return true;
      }
    }
    AppMethodBeat.o(187216);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.q
 * JD-Core Version:    0.7.0.1
 */