package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.aq;
import com.tencent.mm.vfs.o;

public final class n
{
  private static final int tRU;
  private static final int tRV;
  private static int thumbWidth;
  
  static
  {
    int j = 960;
    AppMethodBeat.i(111344);
    thumbWidth = 0;
    int[] arrayOfInt = new int[2];
    Display localDisplay = ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay();
    arrayOfInt[0] = localDisplay.getWidth();
    arrayOfInt[1] = localDisplay.getHeight();
    if (arrayOfInt[0] > 960) {}
    for (int i = arrayOfInt[0];; i = 960)
    {
      tRU = i;
      i = j;
      if (arrayOfInt[1] > 960) {
        i = arrayOfInt[1];
      }
      tRV = i;
      AppMethodBeat.o(111344);
      return;
    }
  }
  
  private static Bitmap X(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    AppMethodBeat.i(173738);
    if (paramBitmap != null) {}
    try
    {
      if (paramBitmap.getWidth() >= paramBitmap.getHeight()) {}
      for (localBitmap = Bitmap.createBitmap(paramBitmap, paramBitmap.getWidth() / 2 - paramBitmap.getHeight() / 2, 0, paramBitmap.getHeight(), paramBitmap.getHeight());; localBitmap = Bitmap.createBitmap(paramBitmap, 0, paramBitmap.getHeight() / 2 - paramBitmap.getWidth() / 2, paramBitmap.getWidth(), paramBitmap.getWidth()))
      {
        AppMethodBeat.o(173738);
        return localBitmap;
      }
      return null;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      ae.printErrStackTrace("MicroMsg.MediaManager", paramBitmap, "cropCenter err!!!", new Object[0]);
      AppMethodBeat.o(173738);
    }
  }
  
  public static Bitmap a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(111338);
    if (e.cXr() == null)
    {
      AppMethodBeat.o(111338);
      return null;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(111338);
      return localObject;
      Bitmap localBitmap = m(paramString1, a.dK(paramString1, cXU()));
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        ae.d("MicroMsg.MediaManager", "get bitmap from file failed.");
        localBitmap = aw(paramString1, paramLong);
      }
      for (;;)
      {
        localObject = localBitmap;
        if (localBitmap != null) {
          break;
        }
        ae.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s], [%s]", new Object[] { paramString1, paramString2 });
        localObject = localBitmap;
        break;
        ae.d("MicroMsg.MediaManager", "get bitmap from file.");
      }
      localObject = q(paramLong, paramString2);
    }
  }
  
  public static Bitmap a(String paramString, s.e parame)
  {
    localObject1 = null;
    AppMethodBeat.i(111339);
    if ((bu.isNullOrNil(paramString)) || (parame == null) || (parame.tSI == 0))
    {
      ae.i("MicroMsg.MediaManager", "getPortraitBitmap err, filePath: %s.", new Object[] { paramString });
      AppMethodBeat.o(111339);
      return null;
    }
    ae.i("MicroMsg.MediaManager", "getPortraitBitmap, filePath: %s, cropArea: %f, %f, %f, %f.", new Object[] { paramString, Double.valueOf(parame.owS), Double.valueOf(parame.owT), Double.valueOf(parame.owU), Double.valueOf(parame.owV) });
    Rect localRect = new Rect();
    switch (parame.tSI)
    {
    }
    for (;;)
    {
      try
      {
        localObject2 = BitmapRegionDecoder.newInstance(o.openRead(paramString), false);
        parame = localObject1;
        if (localObject2 != null)
        {
          parame = localObject1;
          if (!((BitmapRegionDecoder)localObject2).isRecycled()) {
            parame = ((BitmapRegionDecoder)localObject2).decodeRegion(localRect, null);
          }
        }
      }
      catch (Exception parame)
      {
        Object localObject2;
        ae.printErrStackTrace("MicroMsg.MediaManager", parame, "getPortraitBitmap fail.", new Object[0]);
        parame = localObject1;
        continue;
      }
      paramString = m(paramString, X(parame));
      AppMethodBeat.o(111339);
      return paramString;
      try
      {
        localObject2 = h.aRz(paramString);
        localRect.set((int)(parame.owS * ((BitmapFactory.Options)localObject2).outWidth + 0.5D), (int)(parame.owT * ((BitmapFactory.Options)localObject2).outHeight + 0.5D), (int)(parame.owU * ((BitmapFactory.Options)localObject2).outWidth + 0.5D), (int)(parame.owV * ((BitmapFactory.Options)localObject2).outHeight + 0.5D));
      }
      catch (Exception parame)
      {
        ae.printErrStackTrace("MicroMsg.MediaManager", parame, "getPortraitBitmap, trans crop rel error.", new Object[0]);
      }
      continue;
      localRect.set((int)(parame.owS + 0.5D), (int)(parame.owT + 0.5D), (int)(parame.owU + 0.5D), (int)(parame.owV + 0.5D));
    }
  }
  
  public static Bitmap alP(String paramString)
  {
    int k = 1;
    AppMethodBeat.i(111342);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.MediaManager", "filepath is null or nil");
      AppMethodBeat.o(111342);
      return null;
    }
    for (;;)
    {
      int j;
      int m;
      int i;
      try
      {
        if (!o.fB(paramString))
        {
          ae.e("MicroMsg.MediaManager", "getSuitableBmp fail, file does not exist, filePath = ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(111342);
          return null;
        }
        j = tRU;
        m = tRV;
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        Bitmap localBitmap = MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        if (localBitmap != null)
        {
          ae.i("MicroMsg.MediaManager", "bitmap recycle %s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
        if ((((BitmapFactory.Options)localObject).outWidth <= 0) || (((BitmapFactory.Options)localObject).outHeight <= 0))
        {
          ae.d("MicroMsg.MediaManager", "get bitmap fail, file is not a image file = ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(111342);
          return null;
        }
        if ((ag.dx(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
        {
          i = 1;
          if ((ag.dw(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outHeight > 480))
          {
            break label390;
            i = ((BitmapFactory.Options)localObject).outHeight;
            j = ((BitmapFactory.Options)localObject).outWidth;
            m = BackwardSupportUtil.ExifHelper.df(paramString);
            if (m == 90) {
              break label405;
            }
            if (m != 270) {
              break label387;
            }
            break label405;
            localObject = h.d(paramString, i, j, false);
            if (localObject != null) {
              continue;
            }
            ae.e("MicroMsg.MediaManager", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
            AppMethodBeat.o(111342);
            return null;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        k = 0;
        break label390;
        float f = m;
        paramString = h.a((Bitmap)localObject, f);
        ae.d("MicroMsg.MediaManager", "bmp height = " + paramString.getHeight() + ",bmp width = " + paramString.getWidth());
        AppMethodBeat.o(111342);
        return paramString;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.MediaManager", "decode bitmap err: " + paramString.getMessage());
        AppMethodBeat.o(111342);
        return null;
      }
      label387:
      continue;
      label390:
      if (i == 0)
      {
        i = m;
        if (k != 0)
        {
          continue;
          label405:
          k = i;
          i = j;
          j = k;
        }
      }
    }
  }
  
  public static Bitmap aw(String paramString, long paramLong)
  {
    Object localObject2 = null;
    Bitmap localBitmap2 = null;
    AppMethodBeat.i(186181);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.MediaManager", "filePath is null or nil");
      AppMethodBeat.o(186181);
      return null;
    }
    localBitmap1 = localBitmap2;
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        localBitmap1 = localBitmap2;
        localObject1 = localObject2;
        localBitmap2 = MediaStore.Images.Thumbnails.getThumbnail(ak.getContext().getContentResolver(), paramLong, 1, null);
        if (localBitmap2 != null) {
          continue;
        }
        i = 0;
        if (localBitmap2 != null) {
          continue;
        }
        j = 0;
        localBitmap1 = localBitmap2;
        localObject1 = localBitmap2;
        ae.v("MicroMsg.MediaManager", "getImageThumb[%s]FromContentResolver type[%s], bmp size[%d, %d]: total time:[%dms]", new Object[] { paramString, "MINI_KIND", Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
        localObject1 = localBitmap2;
      }
      catch (Exception paramString)
      {
        int i;
        int j;
        localObject1 = localBitmap1;
        ae.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s]", new Object[] { paramString.toString() });
        ae.printErrStackTrace("MicroMsg.MediaManager", paramString, "", new Object[0]);
        continue;
      }
      catch (OutOfMemoryError paramString)
      {
        continue;
      }
      AppMethodBeat.o(186181);
      return localObject1;
      localBitmap1 = localBitmap2;
      localObject1 = localBitmap2;
      i = localBitmap2.getWidth();
      continue;
      localBitmap1 = localBitmap2;
      localObject1 = localBitmap2;
      j = localBitmap2.getHeight();
    }
  }
  
  private static int cXU()
  {
    AppMethodBeat.i(164766);
    if (thumbWidth > 0)
    {
      i = thumbWidth;
      AppMethodBeat.o(164766);
      return i;
    }
    int i = aq.fromDPToPix(ak.getContext(), 100);
    thumbWidth = i;
    AppMethodBeat.o(164766);
    return i;
  }
  
  public static Bitmap gU(String paramString1, String paramString2)
  {
    int k = 0;
    AppMethodBeat.i(164767);
    ae.d("MicroMsg.MediaManager", "current thread %s", new Object[] { Thread.currentThread().getName() });
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.MediaManager", "filePath is null or nil");
      AppMethodBeat.o(164767);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = h.d(paramString1, cXU(), cXU(), false);
    int i;
    int j;
    if (localBitmap == null)
    {
      i = 0;
      if (localBitmap != null) {
        break label260;
      }
      j = 0;
      label85:
      ae.v("MicroMsg.MediaManager", "getImageThumb[%s]FromThumbFilePath, bmp size[%d, %d]: total time:[%dms]", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
      if (localBitmap != null) {
        break label303;
      }
      ae.w("MicroMsg.MediaManager", "get bitmap from thumb failed, try to get thumb from orig image:[%s]", new Object[] { paramString2 });
      if (bu.isNullOrNil(paramString2)) {
        break label287;
      }
      l = System.currentTimeMillis();
      localBitmap = h.d(paramString2, cXU(), cXU(), false);
      if (localBitmap != null) {
        break label269;
      }
      i = 0;
      label180:
      if (localBitmap != null) {
        break label278;
      }
      j = k;
      label188:
      ae.v("MicroMsg.MediaManager", "getImageThumb[%s]FromOrigFilePath[%s], bmp size[%d, %d]:total time:[%dms]", new Object[] { paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
    }
    label260:
    label269:
    label278:
    label287:
    label303:
    for (paramString1 = localBitmap;; paramString1 = localBitmap)
    {
      paramString1 = m(paramString2, paramString1);
      AppMethodBeat.o(164767);
      return paramString1;
      i = localBitmap.getWidth();
      break;
      j = localBitmap.getHeight();
      break label85;
      i = localBitmap.getWidth();
      break label180;
      j = localBitmap.getHeight();
      break label188;
      ae.e("MicroMsg.MediaManager", "get bit from orig image faield:[%s]", new Object[] { paramString2 });
    }
  }
  
  private static Bitmap m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111341);
    if (paramBitmap != null)
    {
      long l = System.currentTimeMillis();
      int i = BackwardSupportUtil.ExifHelper.df(paramString);
      paramString = h.a(paramBitmap, i);
      ae.d("MicroMsg.MediaManager", "do rotate finish, width[%d] height[%d] rotate[%d] use[%dms]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
      if (paramString != null)
      {
        AppMethodBeat.o(111341);
        return paramString;
      }
    }
    AppMethodBeat.o(111341);
    return null;
  }
  
  @TargetApi(8)
  private static Bitmap q(long paramLong, String paramString)
  {
    AppMethodBeat.i(111343);
    try
    {
      Bitmap localBitmap1 = MediaStore.Video.Thumbnails.getThumbnail(ak.getContext().getContentResolver(), paramLong, 1, null);
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null)
      {
        ae.e("MicroMsg.MediaManager", "get video thumb failed : [%d] [%s]", new Object[] { Long.valueOf(paramLong), paramString });
        localBitmap1 = h.createVideoThumbnail(paramString, 1);
        localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap2 = localBitmap1;
          if (!bu.isNullOrNil(paramString))
          {
            ae.e("MicroMsg.MediaManager", "get video thumb failed : [%d], call media scanner : [%s]", new Object[] { Long.valueOf(paramLong), paramString });
            b.k(paramString, ak.getContext());
            localBitmap2 = localBitmap1;
          }
        }
      }
      AppMethodBeat.o(111343);
      return localBitmap2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.MediaManager", "exception: %s", new Object[] { bu.o(localException) });
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.n
 * JD-Core Version:    0.7.0.1
 */