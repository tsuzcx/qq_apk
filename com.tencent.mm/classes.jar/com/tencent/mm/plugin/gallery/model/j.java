package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class j
{
  private static int dQQ;
  private static final int kHf;
  private static final int kHg;
  
  static
  {
    int j = 960;
    dQQ = 0;
    int[] arrayOfInt = new int[2];
    Display localDisplay = ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay();
    arrayOfInt[0] = localDisplay.getWidth();
    arrayOfInt[1] = localDisplay.getHeight();
    if (arrayOfInt[0] > 960) {}
    for (int i = arrayOfInt[0];; i = 960)
    {
      kHf = i;
      i = j;
      if (arrayOfInt[1] > 960) {
        i = arrayOfInt[1];
      }
      kHg = i;
      return;
    }
  }
  
  public static Bitmap Er(String paramString)
  {
    int k = 1;
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.MediaManager", "filepath is null or nil");
      return null;
    }
    label399:
    label408:
    label410:
    label415:
    label418:
    for (;;)
    {
      try
      {
        if (!e.bK(paramString))
        {
          y.e("MicroMsg.MediaManager", "getSuitableBmp fail, file does not exist, filePath = " + paramString);
          return null;
        }
        j = kHf;
        m = kHg;
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        localBitmap = MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject, null, 0, new int[0]);
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        if ((((BitmapFactory.Options)localObject).outWidth <= 0) || (((BitmapFactory.Options)localObject).outHeight <= 0))
        {
          y.d("MicroMsg.MediaManager", "get bitmap fail, file is not a image file = " + paramString);
          return null;
        }
        if ((!aa.bD(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outWidth <= 480)) {
          break label410;
        }
        i = 1;
        if ((!aa.bC(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) || (((BitmapFactory.Options)localObject).outHeight <= 480)) {
          break label415;
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        Bitmap localBitmap;
        label193:
        label205:
        label229:
        y.e("MicroMsg.MediaManager", "decode bitmap err: " + paramString.getMessage());
        return null;
      }
      int i = ((BitmapFactory.Options)localObject).outHeight;
      int j = ((BitmapFactory.Options)localObject).outWidth;
      int m = BackwardSupportUtil.ExifHelper.YS(paramString);
      if (m != 90) {
        if (m == 270)
        {
          break label399;
          localObject = new MMBitmapFactory.DecodeResultLogger();
          localBitmap = com.tencent.mm.sdk.platformtools.c.a(paramString, i, j, false, (MMBitmapFactory.DecodeResultLogger)localObject, 0);
          if (localBitmap == null)
          {
            y.e("MicroMsg.MediaManager", "getSuitableBmp fail, temBmp is null, filePath = " + paramString);
            if (((MMBitmapFactory.DecodeResultLogger)localObject).getDecodeResult() < 2000) {
              break label408;
            }
            paramString = MMBitmapFactory.KVStatHelper.getKVStatString(paramString, 1, (MMBitmapFactory.DecodeResultLogger)localObject);
            h.nFQ.aC(12712, paramString);
            break label408;
          }
          paramString = com.tencent.mm.sdk.platformtools.c.b(localBitmap, m);
          y.i("MicroMsg.MediaManager", "bmp height = " + paramString.getHeight() + ",bmp width = " + paramString.getWidth());
          return paramString;
        }
        else
        {
          continue;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label418;
        }
        i = m;
        if (k == 0) {
          break label205;
        }
        break label193;
        k = i;
        i = j;
        j = k;
        break label229;
        return null;
        i = 0;
        break;
        k = 0;
      }
    }
  }
  
  public static Bitmap a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = null;
    if (c.aXb() == null) {}
    Bitmap localBitmap;
    do
    {
      MMBitmapFactory.DecodeResultLogger localDecodeResultLogger;
      do
      {
        do
        {
          return localObject;
          switch (paramInt)
          {
          default: 
            return null;
          case 1: 
            localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
            localBitmap = dm(paramString1, paramString2);
            localObject = localBitmap;
          }
        } while (localBitmap != null);
        y.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s], [%s]", new Object[] { paramString1, paramString2 });
        localObject = localBitmap;
      } while (localDecodeResultLogger.getDecodeResult() < 2000);
      paramString1 = MMBitmapFactory.KVStatHelper.getKVStatString(paramString2, 1, localDecodeResultLogger);
      h.nFQ.aC(12712, paramString1);
      return localBitmap;
      localBitmap = n(paramLong, paramString2);
      localObject = localBitmap;
    } while (localBitmap != null);
    return dm(paramString1, paramString2);
  }
  
  private static int aXB()
  {
    if (dQQ > 0) {
      return dQQ;
    }
    int i = BackwardSupportUtil.b.b(ae.getContext(), 150.0F);
    dQQ = i;
    return i;
  }
  
  private static Bitmap dm(String paramString1, String paramString2)
  {
    y.d("MicroMsg.MediaManager", "current thread %s", new Object[] { Thread.currentThread().getName() });
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.MediaManager", "filePath is null or nill");
      paramString1 = null;
      return paramString1;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap2 = com.tencent.mm.sdk.platformtools.c.a(paramString1, aXB(), aXB(), false, null, 0);
    int i;
    label65:
    int j;
    label72:
    Bitmap localBitmap1;
    if (localBitmap2 == null)
    {
      i = 0;
      if (localBitmap2 != null) {
        break label317;
      }
      j = 0;
      y.v("MicroMsg.MediaManager", "getImageThumb[%s]FromThumbFilePath, bmp size[%d, %d]: total time:[%dms]", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        y.w("MicroMsg.MediaManager", "get bitmap from thumb failed, try to get thumb from orig image:[%s]", new Object[] { paramString2 });
        if (bk.bl(paramString2)) {
          break label344;
        }
        l = System.currentTimeMillis();
        localBitmap1 = com.tencent.mm.sdk.platformtools.c.a(paramString2, aXB(), aXB(), false, null, 0);
        if (localBitmap1 != null) {
          break label326;
        }
        i = 0;
        label171:
        if (localBitmap1 != null) {
          break label335;
        }
        j = 0;
        label178:
        y.v("MicroMsg.MediaManager", "getImageThumb[%s]FromOrigFilePath[%s], bmp size[%d, %d]:total time:[%dms]", new Object[] { paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
      }
    }
    for (;;)
    {
      if (localBitmap1 != null)
      {
        l = System.currentTimeMillis();
        i = BackwardSupportUtil.ExifHelper.YS(paramString2);
        paramString2 = com.tencent.mm.sdk.platformtools.c.b(localBitmap1, i);
        y.d("MicroMsg.MediaManager", "do rotate finish, width[%d] height[%d] rotate[%d] use[%dms]", new Object[] { Integer.valueOf(localBitmap1.getWidth()), Integer.valueOf(localBitmap1.getHeight()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
        paramString1 = paramString2;
        if (paramString2 != null) {
          break;
        }
      }
      return null;
      i = localBitmap2.getWidth();
      break label65;
      label317:
      j = localBitmap2.getHeight();
      break label72;
      label326:
      i = localBitmap1.getWidth();
      break label171;
      label335:
      j = localBitmap1.getHeight();
      break label178;
      label344:
      y.e("MicroMsg.MediaManager", "get bit from orig image faield:[%s]", new Object[] { paramString2 });
      localBitmap1 = localBitmap2;
    }
  }
  
  @TargetApi(8)
  private static Bitmap n(long paramLong, String paramString)
  {
    try
    {
      Bitmap localBitmap1 = MediaStore.Video.Thumbnails.getThumbnail(ae.getContext().getContentResolver(), paramLong, 1, null);
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null)
      {
        y.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", new Object[] { Long.valueOf(paramLong), paramString });
        if (Build.VERSION.SDK_INT >= 8) {
          localBitmap1 = ThumbnailUtils.createVideoThumbnail(paramString, 1);
        }
        localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap2 = localBitmap1;
          if (!bk.bl(paramString))
          {
            y.e("MicroMsg.MediaManager", "get vedio thumb failed : [%d], call media scanner : [%s]", new Object[] { Long.valueOf(paramLong), paramString });
            ae.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + paramString)));
            localBitmap2 = localBitmap1;
          }
        }
      }
      return localBitmap2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.MediaManager", "exception: %s", new Object[] { bk.j(localException) });
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.j
 * JD-Core Version:    0.7.0.1
 */