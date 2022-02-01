package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.utils.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaUtils;", "", "()V", "DEFAULT_IMAGE_COMPRESS_QUALITY", "", "TAG", "", "doCompressImage", "srcPath", "doRotate", "shouldRotate", "", "imageFile", "imageFiles", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s shL;
  
  static
  {
    AppMethodBeat.i(329334);
    shL = new s();
    AppMethodBeat.o(329334);
  }
  
  public static final String aaW(String paramString)
  {
    AppMethodBeat.i(329318);
    kotlin.g.b.s.u(paramString, "srcPath");
    String str = y.n(b.bmx() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
    kotlin.g.b.s.checkNotNull(str);
    kotlin.g.b.s.s(str, "exportExternalPath(CCons…illis() + \".jpg\", true)!!");
    long l;
    try
    {
      Bitmap localBitmap1 = MMBitmapFactory.decodeFile(paramString);
      if (localBitmap1 == null)
      {
        Log.e("MicroMsg.MediaUtils", "doCompressImage, decode bmp return null");
        AppMethodBeat.o(329318);
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
          Log.e("MicroMsg.MediaUtils", kotlin.g.b.s.X("doCompressImage, decode bmp oom retry, e ", localException1));
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
          Log.e("MicroMsg.MediaUtils", kotlin.g.b.s.X("doCompressImage, decode bmp npe retry, e ", localException2));
          Object localObject3 = null;
        }
      }
    }
    catch (Exception localException3)
    {
      Object localObject4;
      for (;;)
      {
        Log.e("MicroMsg.MediaUtils", kotlin.g.b.s.X("doCompressImage, decode bmp e ", localException3));
        localObject4 = null;
      }
      localObject4.recycle();
      l = Util.nowMilliSecond();
    }
    try
    {
      boolean bool = i.fs(str, paramString);
      Log.i("MicroMsg.MediaUtils", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[] { Boolean.valueOf(bool), Long.valueOf(Util.nowMilliSecond() - l), paramString, Long.valueOf(y.bEl(paramString)), str, Long.valueOf(new u(str).length()) });
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
    AppMethodBeat.o(329318);
    return paramString;
  }
  
  public static final String aaX(String paramString)
  {
    AppMethodBeat.i(329325);
    kotlin.g.b.s.u(paramString, "srcPath");
    int i = Exif.fromFile(paramString).getOrientationInDegree();
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
            AppMethodBeat.o(329325);
            return paramString;
          }
          localBitmap = BitmapUtil.rotate((Bitmap)localObject1, i % 360);
          localObject2 = new StringBuilder().append(b.bmx()).append("microMsg.tmp.").append(System.currentTimeMillis());
          if (i.a(localOptions))
          {
            localObject1 = ".jpg";
            localObject2 = (String)localObject1;
            if (!i.a(localOptions)) {
              continue;
            }
            localObject1 = Bitmap.CompressFormat.JPEG;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          BitmapFactory.Options localOptions;
          Object localObject1;
          Bitmap localBitmap;
          Object localObject2;
          continue;
          AppMethodBeat.o(329325);
          return paramString;
        }
        catch (NullPointerException localNullPointerException)
        {
          continue;
        }
        try
        {
          BitmapUtil.saveBitmapToImage(localBitmap, 80, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
          if (i.a(localOptions)) {
            c.dM(paramString, (String)localObject2);
          }
          paramString = (String)localObject2;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.MediaUtils", "rotate image, exception occurred when saving | %s", new Object[] { localException });
          y.deleteFile((String)localObject2);
          continue;
        }
        AppMethodBeat.o(329325);
        return paramString;
        localObject1 = ".png";
        continue;
        localObject1 = Bitmap.CompressFormat.PNG;
      }
    }
  }
  
  public static final boolean abb(String paramString)
  {
    AppMethodBeat.i(329332);
    kotlin.g.b.s.u(paramString, "imageFile");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(329332);
      return false;
    }
    if (Exif.fromFile(paramString).getOrientationInDegree() != 0)
    {
      AppMethodBeat.o(329332);
      return true;
    }
    AppMethodBeat.o(329332);
    return false;
  }
  
  public static final boolean dn(List<String> paramList)
  {
    AppMethodBeat.i(329329);
    kotlin.g.b.s.u(paramList, "imageFiles");
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(329329);
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (Exif.fromFile((String)paramList.next()).getOrientationInDegree() != 0)
      {
        AppMethodBeat.o(329329);
        return true;
      }
    }
    AppMethodBeat.o(329329);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.s
 * JD-Core Version:    0.7.0.1
 */