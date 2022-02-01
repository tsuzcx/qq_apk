package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
{
  public static Bitmap bn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(104682);
    if (bt.cw(paramArrayOfByte))
    {
      AppMethodBeat.o(104682);
      return null;
    }
    int[] arrayOfInt2 = new int[4];
    int[] arrayOfInt1 = new int[4];
    long l = MMWXGFJNI.nativeInitWxAMDecoder();
    if (l == 0L) {
      ad.w("MicroMsg.GIF.MMWXGFUtil", "Cpan init wxam decoder failed.");
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(l, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0) {
      ad.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
    }
    i = MMWXGFJNI.nativeGetOption(l, paramArrayOfByte, paramArrayOfByte.length, arrayOfInt2);
    if (i != 0) {
      ad.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
    }
    i = arrayOfInt2[1];
    int j = arrayOfInt2[2];
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(104682);
      return null;
    }
    paramArrayOfByte = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    MMWXGFJNI.nativeDecodeBufferFrame(l, null, 0, paramArrayOfByte, arrayOfInt1);
    MMWXGFJNI.nativeUninit(l);
    AppMethodBeat.o(104682);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.i
 * JD-Core Version:    0.7.0.1
 */