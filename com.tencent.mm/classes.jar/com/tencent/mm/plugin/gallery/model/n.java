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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.at;
import com.tencent.mm.vfs.s;

public final class n
{
  private static int thumbWidth;
  private static final int xjh;
  private static final int xji;
  
  static
  {
    int j = 960;
    AppMethodBeat.i(111344);
    thumbWidth = 0;
    int[] arrayOfInt = new int[2];
    Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
    arrayOfInt[0] = localDisplay.getWidth();
    arrayOfInt[1] = localDisplay.getHeight();
    if (arrayOfInt[0] > 960) {}
    for (int i = arrayOfInt[0];; i = 960)
    {
      xjh = i;
      i = j;
      if (arrayOfInt[1] > 960) {
        i = arrayOfInt[1];
      }
      xji = i;
      AppMethodBeat.o(111344);
      return;
    }
  }
  
  public static Bitmap a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(111338);
    if (e.dQK() == null)
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
      Bitmap localBitmap = m(paramString1, a.dZ(paramString1, dRn()));
      if ((localBitmap == null) || (localBitmap.isRecycled()))
      {
        Log.d("MicroMsg.MediaManager", "get bitmap from file failed.");
        localBitmap = aw(paramString1, paramLong);
      }
      for (;;)
      {
        localObject = localBitmap;
        if (localBitmap != null) {
          break;
        }
        Log.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s], [%s]", new Object[] { paramString1, paramString2 });
        localObject = localBitmap;
        break;
        Log.d("MicroMsg.MediaManager", "get bitmap from file.");
      }
      localObject = u(paramLong, paramString2);
    }
  }
  
  public static Bitmap a(String paramString, s.e parame)
  {
    localObject1 = null;
    AppMethodBeat.i(111339);
    if ((Util.isNullOrNil(paramString)) || (parame == null) || (parame.xjV == 0))
    {
      Log.i("MicroMsg.MediaManager", "getPortraitBitmap err, filePath: %s.", new Object[] { paramString });
      AppMethodBeat.o(111339);
      return null;
    }
    Log.i("MicroMsg.MediaManager", "getPortraitBitmap, filePath: %s, cropArea: %f, %f, %f, %f.", new Object[] { paramString, Double.valueOf(parame.pKw), Double.valueOf(parame.pKx), Double.valueOf(parame.pKy), Double.valueOf(parame.pKz) });
    Rect localRect = new Rect();
    switch (parame.xjV)
    {
    }
    for (;;)
    {
      try
      {
        localObject2 = BitmapRegionDecoder.newInstance(s.openRead(paramString), false);
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
        Log.printErrStackTrace("MicroMsg.MediaManager", parame, "getPortraitBitmap fail.", new Object[0]);
        parame = localObject1;
        continue;
      }
      paramString = m(paramString, ad(parame));
      AppMethodBeat.o(111339);
      return paramString;
      try
      {
        localObject2 = BitmapUtil.getImageOptions(paramString);
        localRect.set((int)(parame.pKw * ((BitmapFactory.Options)localObject2).outWidth + 0.5D), (int)(parame.pKx * ((BitmapFactory.Options)localObject2).outHeight + 0.5D), (int)(parame.pKy * ((BitmapFactory.Options)localObject2).outWidth + 0.5D), (int)(parame.pKz * ((BitmapFactory.Options)localObject2).outHeight + 0.5D));
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace("MicroMsg.MediaManager", parame, "getPortraitBitmap, trans crop rel error.", new Object[0]);
      }
      continue;
      localRect.set((int)(parame.pKw + 0.5D), (int)(parame.pKx + 0.5D), (int)(parame.pKy + 0.5D), (int)(parame.pKz + 0.5D));
    }
  }
  
  private static Bitmap ad(Bitmap paramBitmap)
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
      Log.printErrStackTrace("MicroMsg.MediaManager", paramBitmap, "cropCenter err!!!", new Object[0]);
      AppMethodBeat.o(173738);
    }
  }
  
  public static Bitmap aw(String paramString, long paramLong)
  {
    Object localObject2 = null;
    Bitmap localBitmap2 = null;
    AppMethodBeat.i(257730);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.MediaManager", "filePath is null or nil");
      AppMethodBeat.o(257730);
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
        localBitmap2 = MediaStore.Images.Thumbnails.getThumbnail(MMApplicationContext.getContext().getContentResolver(), paramLong, 1, null);
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
        Log.v("MicroMsg.MediaManager", "getImageThumb[%s]FromContentResolver type[%s], bmp size[%d, %d]: total time:[%dms]", new Object[] { paramString, "MINI_KIND", Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
        localObject1 = localBitmap2;
      }
      catch (Exception paramString)
      {
        int i;
        int j;
        localObject1 = localBitmap1;
        Log.e("MicroMsg.MediaManager", "get thumb from content resolver failed: [%s]", new Object[] { paramString.toString() });
        Log.printErrStackTrace("MicroMsg.MediaManager", paramString, "", new Object[0]);
        continue;
      }
      catch (OutOfMemoryError paramString)
      {
        continue;
      }
      AppMethodBeat.o(257730);
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
  
  public static Bitmap ayT(String paramString)
  {
    int k = 1;
    AppMethodBeat.i(111342);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.MediaManager", "filepath is null or nil");
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
        if (!s.YS(paramString))
        {
          Log.e("MicroMsg.MediaManager", "getSuitableBmp fail, file does not exist, filePath = ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(111342);
          return null;
        }
        j = xjh;
        m = xji;
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        Bitmap localBitmap = MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        if (localBitmap != null)
        {
          Log.i("MicroMsg.MediaManager", "bitmap recycle %s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
        if ((((BitmapFactory.Options)localObject).outWidth <= 0) || (((BitmapFactory.Options)localObject).outHeight <= 0))
        {
          Log.d("MicroMsg.MediaManager", "get bitmap fail, file is not a image file = ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(111342);
          return null;
        }
        if ((LongBitmapHandler.isLongHorizontal(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outWidth > 480))
        {
          i = 1;
          if ((LongBitmapHandler.isLongVertical(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight)) && (((BitmapFactory.Options)localObject).outHeight > 480))
          {
            break label400;
            i = ((BitmapFactory.Options)localObject).outHeight;
            j = ((BitmapFactory.Options)localObject).outWidth;
            m = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
            if (m == 90) {
              break label415;
            }
            if (m != 270) {
              break label397;
            }
            break label415;
            localObject = BitmapUtil.extractThumbNail(paramString, i, j, false);
            if (localObject != null) {
              continue;
            }
            Log.e("MicroMsg.MediaManager", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
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
        break label400;
        float f = m;
        paramString = BitmapUtil.rotate((Bitmap)localObject, f);
        Log.d("MicroMsg.MediaManager", "bmp height = " + paramString.getHeight() + ",bmp width = " + paramString.getWidth());
        AppMethodBeat.o(111342);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.MediaManager", "decode bitmap err: " + paramString.getMessage());
        AppMethodBeat.o(111342);
        return null;
      }
      label397:
      continue;
      label400:
      if (i == 0)
      {
        i = m;
        if (k != 0)
        {
          continue;
          label415:
          k = i;
          i = j;
          j = k;
        }
      }
    }
  }
  
  private static int dRn()
  {
    AppMethodBeat.i(164766);
    if (thumbWidth > 0)
    {
      i = thumbWidth;
      AppMethodBeat.o(164766);
      return i;
    }
    int i = at.fromDPToPix(MMApplicationContext.getContext(), 100);
    thumbWidth = i;
    AppMethodBeat.o(164766);
    return i;
  }
  
  public static Bitmap hB(String paramString1, String paramString2)
  {
    int k = 0;
    AppMethodBeat.i(164767);
    Log.d("MicroMsg.MediaManager", "current thread %s", new Object[] { Thread.currentThread().getName() });
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.MediaManager", "filePath is null or nil");
      AppMethodBeat.o(164767);
      return null;
    }
    long l = System.currentTimeMillis();
    Bitmap localBitmap = BitmapUtil.extractThumbNail(paramString1, dRn(), dRn(), false);
    int i;
    int j;
    if (localBitmap == null)
    {
      i = 0;
      if (localBitmap != null) {
        break label259;
      }
      j = 0;
      label84:
      Log.v("MicroMsg.MediaManager", "getImageThumb[%s]FromThumbFilePath, bmp size[%d, %d]: total time:[%dms]", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
      if (localBitmap != null) {
        break label302;
      }
      Log.w("MicroMsg.MediaManager", "get bitmap from thumb failed, try to get thumb from orig image:[%s]", new Object[] { paramString2 });
      if (Util.isNullOrNil(paramString2)) {
        break label286;
      }
      l = System.currentTimeMillis();
      localBitmap = BitmapUtil.extractThumbNail(paramString2, dRn(), dRn(), false);
      if (localBitmap != null) {
        break label268;
      }
      i = 0;
      label179:
      if (localBitmap != null) {
        break label277;
      }
      j = k;
      label187:
      Log.v("MicroMsg.MediaManager", "getImageThumb[%s]FromOrigFilePath[%s], bmp size[%d, %d]:total time:[%dms]", new Object[] { paramString1, paramString2, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l) });
    }
    label259:
    label268:
    label277:
    label286:
    label302:
    for (paramString1 = localBitmap;; paramString1 = localBitmap)
    {
      paramString1 = m(paramString2, paramString1);
      AppMethodBeat.o(164767);
      return paramString1;
      i = localBitmap.getWidth();
      break;
      j = localBitmap.getHeight();
      break label84;
      i = localBitmap.getWidth();
      break label179;
      j = localBitmap.getHeight();
      break label187;
      Log.e("MicroMsg.MediaManager", "get bit from orig image faield:[%s]", new Object[] { paramString2 });
    }
  }
  
  private static Bitmap m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(111341);
    if (paramBitmap != null)
    {
      long l = System.currentTimeMillis();
      int i = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
      paramString = BitmapUtil.rotate(paramBitmap, i);
      Log.d("MicroMsg.MediaManager", "do rotate finish, width[%d] height[%d] rotate[%d] use[%dms]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l) });
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
  private static Bitmap u(long paramLong, String paramString)
  {
    AppMethodBeat.i(111343);
    try
    {
      Bitmap localBitmap1 = MediaStore.Video.Thumbnails.getThumbnail(MMApplicationContext.getContext().getContentResolver(), paramLong, 1, null);
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap1 == null)
      {
        Log.e("MicroMsg.MediaManager", "get video thumb failed : [%d] [%s]", new Object[] { Long.valueOf(paramLong), paramString });
        localBitmap1 = BitmapUtil.createVideoThumbnail(paramString, 1);
        localBitmap2 = localBitmap1;
        if (localBitmap1 == null)
        {
          localBitmap2 = localBitmap1;
          if (!Util.isNullOrNil(paramString))
          {
            Log.e("MicroMsg.MediaManager", "get video thumb failed : [%d], call media scanner : [%s]", new Object[] { Long.valueOf(paramLong), paramString });
            AndroidMediaUtil.refreshMediaScanner(paramString, MMApplicationContext.getContext());
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
        Log.e("MicroMsg.MediaManager", "exception: %s", new Object[] { Util.stackTraceToString(localException) });
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.n
 * JD-Core Version:    0.7.0.1
 */