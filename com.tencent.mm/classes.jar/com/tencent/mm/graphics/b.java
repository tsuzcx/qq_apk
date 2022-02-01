package com.tencent.mm.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.InputStream;

public final class b
{
  public static Bitmap a(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    Object localObject4 = null;
    AppMethodBeat.i(1012);
    try
    {
      localBitmapRegionDecoder = BitmapRegionDecoder.newInstance(paramInputStream, true);
    }
    finally
    {
      Bitmap localBitmap2;
      Bitmap localBitmap1;
      label110:
      localBitmapRegionDecoder = null;
    }
    try
    {
      localBitmap2 = localBitmapRegionDecoder.decodeRegion(paramRect, paramOptions);
      localBitmap1 = localBitmap2;
      if (localBitmapRegionDecoder != null)
      {
        localBitmapRegionDecoder.recycle();
        localBitmap1 = localBitmap2;
      }
    }
    finally
    {
      Object localObject1;
      break label110;
      Object localObject3 = null;
    }
    if (localBitmap1 == null)
    {
      Log.w("MicroMsg.MMBitmapRegionDecoder", "fail to do regional decode with BitmapRegionDecoder, decode fully and crop instead.");
      paramOptions = MMBitmapFactory.decodeStream(paramInputStream, null, paramOptions);
      paramInputStream = localObject4;
      if (paramOptions != null)
      {
        paramRect = Bitmap.createBitmap(paramOptions, paramRect.left, paramRect.top, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
        paramInputStream = paramRect;
        if (paramRect != paramOptions)
        {
          paramOptions.recycle();
          paramInputStream = paramRect;
        }
      }
      AppMethodBeat.o(1012);
      return paramInputStream;
    }
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    Object localObject4 = null;
    AppMethodBeat.i(1013);
    try
    {
      localBitmapRegionDecoder = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramInt, true);
    }
    finally
    {
      Bitmap localBitmap2;
      Bitmap localBitmap1;
      label116:
      localBitmapRegionDecoder = null;
    }
    try
    {
      localBitmap2 = localBitmapRegionDecoder.decodeRegion(paramRect, paramOptions);
      localBitmap1 = localBitmap2;
      if (localBitmapRegionDecoder != null)
      {
        localBitmapRegionDecoder.recycle();
        localBitmap1 = localBitmap2;
      }
    }
    finally
    {
      Object localObject1;
      break label116;
      Object localObject3 = null;
    }
    if (localBitmap1 == null)
    {
      Log.w("MicroMsg.MMBitmapRegionDecoder", "fail to do regional decode with BitmapRegionDecoder, decode fully and crop instead.");
      paramOptions = MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramInt, paramOptions);
      paramArrayOfByte = localObject4;
      if (paramOptions != null)
      {
        paramRect = Bitmap.createBitmap(paramOptions, paramRect.left, paramRect.top, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
        paramArrayOfByte = paramRect;
        if (paramRect != paramOptions)
        {
          paramOptions.recycle();
          paramArrayOfByte = paramRect;
        }
      }
      AppMethodBeat.o(1013);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.graphics.b
 * JD-Core Version:    0.7.0.1
 */