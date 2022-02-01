package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.appbrand.utils.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaUtils;", "", "()V", "DEFAULT_IMAGE_COMPRESS_QUALITY", "", "TAG", "", "doCompressImage", "srcPath", "doRotate", "shouldRotate", "", "imageFile", "imageFiles", "", "plugin-appbrand-integration_release"})
public final class r
{
  public static final r kZs;
  
  static
  {
    AppMethodBeat.i(223408);
    kZs = new r();
    AppMethodBeat.o(223408);
  }
  
  public static final String QG(String paramString)
  {
    AppMethodBeat.i(223404);
    p.h(paramString, "srcPath");
    String str = o.k(com.tencent.mm.loader.j.b.asv() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
    long l;
    try
    {
      Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap1 == null)
      {
        ae.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(223404);
        return null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        ae.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom");
        try
        {
          Bitmap localBitmap2 = h.decodeFile(paramString, null);
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          ae.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom retry, oom again");
          Object localObject1 = null;
        }
        catch (Exception localException1)
        {
          ae.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(localException1)));
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
          Bitmap localBitmap3 = h.decodeFile(paramString, null);
        }
        catch (Exception localException2)
        {
          ae.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(localException2)));
          Object localObject3 = null;
        }
      }
    }
    catch (Exception localException3)
    {
      Object localObject4;
      for (;;)
      {
        ae.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp e ".concat(String.valueOf(localException3)));
        localObject4 = null;
      }
      localObject4.recycle();
      l = bu.fpO();
    }
    try
    {
      boolean bool = d.ev(str, paramString);
      ae.i("MicroMsg.MediaUtils", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(bu.fpO() - l), paramString, Long.valueOf(o.aZR(paramString)), str, Long.valueOf(new k(str).length()) });
      if (bool) {
        paramString = str;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      for (;;)
      {
        ae.e("MicroMsg.MediaUtils", "compressImage, oom");
      }
    }
    AppMethodBeat.o(223404);
    return paramString;
  }
  
  public static final String QH(String paramString)
  {
    AppMethodBeat.i(223405);
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
            ae.e("MicroMsg.MediaUtils", "rotate image, get null bmp");
            AppMethodBeat.o(223405);
            return paramString;
          }
          localBitmap = h.a((Bitmap)localObject1, i % 360);
          localObject2 = new StringBuilder().append(com.tencent.mm.loader.j.b.ash()).append("microMsg.tmp.").append(System.currentTimeMillis());
          if (d.d(localOptions))
          {
            localObject1 = ".jpg";
            localObject2 = (String)localObject1;
            if (!d.d(localOptions)) {
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
          AppMethodBeat.o(223405);
          return paramString;
        }
        catch (NullPointerException localNullPointerException)
        {
          continue;
        }
        try
        {
          h.a(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
          if (d.d(localOptions)) {
            com.tencent.mm.plugin.appbrand.l.b.cV(paramString, (String)localObject2);
          }
          paramString = (String)localObject2;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.MediaUtils", "rotate image, exception occurred when saving | %s", new Object[] { localException });
          o.deleteFile((String)localObject2);
          continue;
        }
        AppMethodBeat.o(223405);
        return paramString;
        localObject1 = ".png";
        continue;
        localObject1 = Bitmap.CompressFormat.PNG;
      }
    }
  }
  
  public static final boolean QL(String paramString)
  {
    AppMethodBeat.i(223407);
    p.h(paramString, "imageFile");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(223407);
      return false;
    }
    paramString = Exif.fromFile(paramString);
    p.g(paramString, "Exif.fromFile(imageFile)");
    if (paramString.getOrientationInDegree() != 0)
    {
      AppMethodBeat.o(223407);
      return true;
    }
    AppMethodBeat.o(223407);
    return false;
  }
  
  public static final boolean br(List<String> paramList)
  {
    AppMethodBeat.i(223406);
    p.h(paramList, "imageFiles");
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(223406);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Exif localExif = Exif.fromFile((String)paramList.next());
      p.g(localExif, "Exif.fromFile(path)");
      if (localExif.getOrientationInDegree() != 0)
      {
        AppMethodBeat.o(223406);
        return true;
      }
    }
    AppMethodBeat.o(223406);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.r
 * JD-Core Version:    0.7.0.1
 */