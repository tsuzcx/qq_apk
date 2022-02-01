package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/decode/MMWXGFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "TAG", "", "currFrame", "", "currFrameTime", "frameMetadata", "", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifHandle", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class f
  implements c
{
  private final String TAG;
  private Bitmap fKU;
  private final int[] fKW;
  private long fKX;
  private final int[] fKY;
  private int fKZ;
  private int fLa;
  private final g qro;
  
  public f(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105378);
    this.TAG = "MicroMsg.GIF.MMWXGFDecoder";
    this.fKW = new int[4];
    this.fKY = new int[4];
    this.fKZ = -1;
    this.fKX = MMWXGFJNI.nativeInitWxAMDecoder();
    if ((this.fKX == 0L) || (this.fKX == -901L))
    {
      ad.w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", new Object[] { Long.valueOf(this.fKX) });
      if (this.fKX == -901L) {
        h.vKh.idkeyStat(711L, 5L, 1L, false);
      }
      h.vKh.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = (Throwable)new MMGIFException(201);
      AppMethodBeat.o(105378);
      throw paramArrayOfByte;
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(this.fKX, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      ad.w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        h.vKh.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        h.vKh.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.fKX, paramArrayOfByte, paramArrayOfByte.length, this.fKW);
    if (i != 0)
    {
      ad.w(this.TAG, "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        h.vKh.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        h.vKh.idkeyStat(711L, 3L, 1L, false);
      }
    }
    paramArrayOfByte = Bitmap.createBitmap(this.fKW[1], this.fKW[2], Bitmap.Config.ARGB_8888);
    k.g(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
    this.fKU = paramArrayOfByte;
    this.qro = new g(this.fKW[0]);
    AppMethodBeat.o(105378);
  }
  
  public final void aaR()
  {
    AppMethodBeat.i(105376);
    Bitmap localBitmap = this.fKU;
    int i = MMWXGFJNI.nativeDecodeBufferFrame(this.fKX, null, 0, localBitmap, this.fKY);
    if (i == -904)
    {
      ad.i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
      h.vKh.idkeyStat(401L, 8L, 1L, false);
      this.fKZ += 1;
      if (((this.fKZ >= this.fKW[0] - 1) || (i == 1)) && (MMWXGFJNI.nativeRewindBuffer(this.fKX) == -905))
      {
        h.vKh.idkeyStat(711L, 9L, 1L, false);
        ad.w(this.TAG, "Cpan Rewind buffer failed.");
      }
      this.fKZ %= this.fKW[0];
      if (this.fKY[0] <= 0) {
        break label251;
      }
    }
    label251:
    for (i = this.fKY[0];; i = 100)
    {
      this.fLa = i;
      ad.d(this.TAG, "drawFrameBitmap: decode frame " + this.fKZ + ", " + this.fLa);
      AppMethodBeat.o(105376);
      return;
      if (i == -909)
      {
        ad.i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
        h.vKh.idkeyStat(401L, 11L, 1L, false);
        break;
      }
      if (i != -1) {
        break;
      }
      ad.i(this.TAG, "nativeDecodeBufferFrame failed.");
      break;
    }
  }
  
  public final Bitmap aaS()
  {
    return this.fKU;
  }
  
  public final int aaT()
  {
    return this.fKW[0];
  }
  
  public final int aaU()
  {
    if (this.fKW[0] == 1) {
      return 2147483647;
    }
    return this.fLa;
  }
  
  public final int aaV()
  {
    return this.fKW[1];
  }
  
  public final int aaW()
  {
    return this.fKW[2];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105377);
    long l = this.fKX;
    this.fKX = 0L;
    int i = MMWXGFJNI.nativeUninit(l);
    if (i == -906) {
      h.vKh.idkeyStat(401L, 10L, 1L, false);
    }
    ad.d(this.TAG, "nativeUninit result:%d gifHandle:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    AppMethodBeat.o(105377);
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(202402);
    if (this.fLa <= 0) {
      aaR();
    }
    int j = this.qro.Bx((int)paramLong);
    int m = this.fKW[0];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      aaR();
      this.qro.ep(this.fKZ, this.fLa);
      j = this.qro.Bx((int)paramLong);
      i += 1;
    }
    j = (j - this.fKZ + this.fKW[0]) % this.fKW[0];
    ad.d(this.TAG, "seekTo: " + paramLong + ", " + this.fKZ + ", " + j + ", " + aaU() + ", " + this.fKW[0] + 65292 + this.qro.qre);
    i = k;
    while (i < j)
    {
      aaR();
      i += 1;
    }
    AppMethodBeat.o(202402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.f
 * JD-Core Version:    0.7.0.1
 */