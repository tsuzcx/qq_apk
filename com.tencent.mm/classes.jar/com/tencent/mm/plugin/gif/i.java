package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
{
  public static Bitmap aX(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62447);
    if (bo.ce(paramArrayOfByte))
    {
      AppMethodBeat.o(62447);
      return null;
    }
    int[] arrayOfInt2 = new int[4];
    int[] arrayOfInt1 = new int[4];
    long l = MMWXGFJNI.nativeInitWxAMDecoder();
    if (l == 0L) {
      ab.w("MicroMsg.GIF.MMWXGFUtil", "Cpan init wxam decoder failed.");
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(l, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0) {
      ab.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
    }
    i = MMWXGFJNI.nativeGetOption(l, paramArrayOfByte, paramArrayOfByte.length, arrayOfInt2);
    if (i != 0) {
      ab.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
    }
    i = arrayOfInt2[1];
    int j = arrayOfInt2[2];
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(62447);
      return null;
    }
    paramArrayOfByte = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    MMWXGFJNI.nativeDecodeBufferFrame(l, null, 0, paramArrayOfByte, arrayOfInt1);
    MMWXGFJNI.nativeUninit(l);
    AppMethodBeat.o(62447);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.i
 * JD-Core Version:    0.7.0.1
 */