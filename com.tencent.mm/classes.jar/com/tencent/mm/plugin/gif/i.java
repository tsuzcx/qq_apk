package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class i
{
  public static Bitmap az(byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte)) {
      return null;
    }
    int[] arrayOfInt2 = new int[4];
    int[] arrayOfInt1 = new int[4];
    long l = MMWXGFJNI.nativeInitWxAMDecoder();
    if (l == 0L) {
      y.w("MicroMsg.GIF.MMWXGFUtil", "Cpan init wxam decoder failed.");
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(l, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0) {
      y.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
    }
    i = MMWXGFJNI.nativeGetOption(l, paramArrayOfByte, paramArrayOfByte.length, arrayOfInt2);
    if (i != 0) {
      y.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
    }
    paramArrayOfByte = Bitmap.createBitmap(arrayOfInt2[1], arrayOfInt2[2], Bitmap.Config.ARGB_8888);
    MMWXGFJNI.nativeDecodeBufferFrame(l, null, 0, paramArrayOfByte, arrayOfInt1);
    MMWXGFJNI.nativeUninit(l);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.i
 * JD-Core Version:    0.7.0.1
 */