package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

public final class k
{
  private static int fgR;
  private static final int ndt;
  private static final int ndu;
  
  static
  {
    int j = 960;
    AppMethodBeat.i(21317);
    fgR = 0;
    int[] arrayOfInt = new int[2];
    Display localDisplay = ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay();
    arrayOfInt[0] = localDisplay.getWidth();
    arrayOfInt[1] = localDisplay.getHeight();
    if (arrayOfInt[0] > 960) {}
    for (int i = arrayOfInt[0];; i = 960)
    {
      ndt = i;
      i = j;
      if (arrayOfInt[1] > 960) {
        i = arrayOfInt[1];
      }
      ndu = i;
      AppMethodBeat.o(21317);
      return;
    }
  }
  
  public static Bitmap PC(String paramString)
  {
    int k = 1;
    AppMethodBeat.i(21315);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.MediaManager", "filepath is null or nil");
      AppMethodBeat.o(21315);
      return null;
    }
    for (;;)
    {
      int j;
      int m;
      int i;
      try
      {
        if (!com.tencent.mm.a.e.cN(paramString))
        {
          ab.e("MicroMsg.MediaManager", "getSuitableBmp fail, file does not exist, filePath = ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(21315);
          return null;
        }
        j = ndt;
        m = ndu;
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        Bitmap localBitmap = MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        if (localBitmap != null)
        {
          ab.i("MicroMsg.MediaManager", "bitmap recycle %s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
        if ((((BitmapFactory.Options)localObject).outWidth <= 0) || (((BitmapFactory.Options)localObject).outHeight <= 0))
        {
          ab.d("MicroMsg.MediaManager", "get bitmap fail, file is not a image file = ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(21315);
          return null;
        }
        if ((ad.cO(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
        {
          i = 1;
          if ((ad.cN(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outHeight > 480))
          {
            break label392;
            i = ((BitmapFactory.Options)localObject).outHeight;
            j = ((BitmapFactory.Options)localObject).outWidth;
            m = BackwardSupportUtil.ExifHelper.bY(paramString);
            if (m == 90) {
              break label407;
            }
            if (m != 270) {
              break label389;
            }
            break label407;
            localObject = d.d(paramString, i, j, false);
            if (localObject != null) {
              continue;
            }
            ab.e("MicroMsg.MediaManager", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
            AppMethodBeat.o(21315);
            return null;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        k = 0;
        break label392;
        float f = m;
        paramString = d.b((Bitmap)localObject, f);
        ab.i("MicroMsg.MediaManager", "bmp height = " + paramString.getHeight() + ",bmp width = " + paramString.getWidth());
        AppMethodBeat.o(21315);
        return paramString;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.MediaManager", "decode bitmap err: " + paramString.getMessage());
        AppMethodBeat.o(21315);
        return null;
      }
      label389:
      continue;
      label392:
      if (i == 0)
      {
        i = m;
        if (k != 0)
        {
          continue;
          label407:
          k = i;
          i = j;
          j = k;
        }
      }
    }
  }
  
  public static Bitmap a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(21311);
    if (e.bDQ() == null)
    {
      AppMethodBeat.o(21311);
      return null;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(21311);
      return localObject;
      Bitmap localBitmap = i(paramString1, paramString2, paramLong);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        ab.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s], [%s]", new Object[] { paramString1, paramString2 });
        localObject = localBitmap;
        continue;
        localBitmap = n(paramLong, paramString2);
        localObject = localBitmap;
        if (localBitmap == null) {
          localObject = i(paramString1, paramString2, paramLong);
        }
      }
    }
  }
  
  private static int bEj()
  {
    AppMethodBeat.i(21312);
    if (fgR > 0)
    {
      i = fgR;
      AppMethodBeat.o(21312);
      return i;
    }
    int i = BackwardSupportUtil.b.b(ah.getContext(), 150.0F);
    fgR = i;
    AppMethodBeat.o(21312);
    return i;
  }
  
  private static Bitmap eA(String paramString1, String paramString2)
  {
    int k = 0;
    AppMethodBeat.i(21313);
    ab.d("MicroMsg.MediaManager", "current thread %s", new Object[] { Thread.currentThread().getName() });
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.MediaManager", "filePath is null or nill");
      AppMethodBeat.o(21313);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = d.d(paramString1, bEj(), bEj(), false);
    int i;
    int j;
    if (localBitmap == null)
    {
      i = 0;
      if (localBitmap != null) {
        break label256;
      }
      j = 0;
      label83:
      ab.v("MicroMsg.MediaManager", "getImageThumb[%s]FromThumbFilePath, bmp size[%d, %d]: total time:[%dms]", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
      if (localBitmap != null) {
        break label299;
      }
      ab.w("MicroMsg.MediaManager", "get bitmap from thumb failed, try to get thumb from orig image:[%s]", new Object[] { paramString2 });
      if (bo.isNullOrNil(paramString2)) {
        break label283;
      }
      l = System.currentTimeMillis();
      localBitmap = d.d(paramString2, bEj(), bEj(), false);
      if (localBitmap != null) {
        break label265;
      }
      i = 0;
      label176:
      if (localBitmap != null) {
        break label274;
      }
      j = k;
      label184:
      ab.v("MicroMsg.MediaManager", "getImageThumb[%s]FromOrigFilePath[%s], bmp size[%d, %d]:total time:[%dms]", new Object[] { paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
    }
    label256:
    label265:
    label274:
    label283:
    label299:
    for (paramString1 = localBitmap;; paramString1 = localBitmap)
    {
      paramString1 = o(paramString2, paramString1);
      AppMethodBeat.o(21313);
      return paramString1;
      i = localBitmap.getWidth();
      break;
      j = localBitmap.getHeight();
      break label83;
      i = localBitmap.getWidth();
      break label176;
      j = localBitmap.getHeight();
      break label184;
      ab.e("MicroMsg.MediaManager", "get bit from orig image faield:[%s]", new Object[] { paramString2 });
    }
  }
  
  private static Bitmap i(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(138610);
    Bitmap localBitmap2 = eA(paramString1, paramString2);
    Bitmap localBitmap1 = localBitmap2;
    long l;
    if (localBitmap2 == null)
    {
      l = SystemClock.uptimeMillis();
      localBitmap1 = j(paramString1, paramString2, paramLong);
      if (localBitmap1 != null) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      ab.w("MicroMsg.MediaManager", "null == bitmap by getImageThumbFromFile! use media system decode bitmap is null?%s cost:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(SystemClock.uptimeMillis() - l) });
      AppMethodBeat.o(138610);
      return localBitmap1;
    }
  }
  
  private static Bitmap j(String paramString1, String paramString2, long paramLong)
  {
    Bitmap localBitmap2 = null;
    AppMethodBeat.i(138611);
    if (bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.MediaManager", "filePath is null or nill");
      AppMethodBeat.o(138611);
      return null;
    }
    Bitmap localBitmap1 = localBitmap2;
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        localBitmap1 = localBitmap2;
        localBitmap2 = MediaStore.Images.Thumbnails.getThumbnail(ah.getContext().getContentResolver(), paramLong, 1, null);
        if (localBitmap2 != null) {
          continue;
        }
        i = 0;
        if (localBitmap2 != null) {
          continue;
        }
        j = 0;
        localBitmap1 = localBitmap2;
        ab.v("MicroMsg.MediaManager", "getImageThumb[%s]FromContentResolver type[%s], bmp size[%d, %d]: total time:[%dms]", new Object[] { paramString1, "MINI_KIND", Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
        localBitmap1 = localBitmap2;
      }
      catch (Exception paramString1)
      {
        int i;
        int j;
        ab.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s]", new Object[] { paramString1.toString() });
        ab.printErrStackTrace("MicroMsg.MediaManager", paramString1, "", new Object[0]);
        continue;
      }
      paramString1 = o(paramString2, localBitmap1);
      AppMethodBeat.o(138611);
      return paramString1;
      localBitmap1 = localBitmap2;
      i = localBitmap2.getWidth();
      continue;
      localBitmap1 = localBitmap2;
      j = localBitmap2.getHeight();
    }
  }
  
  @TargetApi(8)
  private static Bitmap n(long paramLong, String paramString)
  {
    AppMethodBeat.i(21316);
    try
    {
      Bitmap localBitmap1 = MediaStore.Video.Thumbnails.getThumbnail(ah.getContext().getContentResolver(), paramLong, 1, null);
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null)
      {
        ab.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", new Object[] { Long.valueOf(paramLong), paramString });
        if (Build.VERSION.SDK_INT >= 8) {
          localBitmap1 = ThumbnailUtils.createVideoThumbnail(paramString, 1);
        }
        localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap2 = localBitmap1;
          if (!bo.isNullOrNil(paramString))
          {
            ab.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", new Object[] { Long.valueOf(paramLong), paramString });
            ah.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://".concat(String.valueOf(paramString)))));
            localBitmap2 = localBitmap1;
          }
        }
      }
      AppMethodBeat.o(21316);
      return localBitmap2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MediaManager", "exception: %s", new Object[] { bo.l(localException) });
        Object localObject = null;
      }
    }
  }
  
  private static Bitmap o(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(21314);
    if (paramBitmap != null)
    {
      long l = System.currentTimeMillis();
      int i = BackwardSupportUtil.ExifHelper.bY(paramString);
      paramString = d.b(paramBitmap, i);
      ab.d("MicroMsg.MediaManager", "do rotate finish, width[%d] height[%d] rotate[%d] use[%dms]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      if (paramString != null)
      {
        AppMethodBeat.o(21314);
        return paramString;
      }
    }
    AppMethodBeat.o(21314);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.k
 * JD-Core Version:    0.7.0.1
 */