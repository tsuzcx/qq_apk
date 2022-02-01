package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/decode/MMWXGFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "TAG", "", "currFrame", "", "currFrameTime", "frameMetadata", "", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifHandle", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class g
  implements d
{
  private final String TAG;
  private Bitmap fOF;
  private final int[] fOH;
  private int fOI;
  private int fOJ;
  private final c fOK;
  private long fOL;
  private final int[] fOM;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105378);
    this.TAG = "MicroMsg.GIF.MMWXGFDecoder";
    this.fOH = new int[4];
    this.fOM = new int[4];
    this.fOI = -1;
    this.fOL = MMWXGFJNI.nativeInitWxAMDecoder();
    if ((this.fOL == 0L) || (this.fOL == -901L))
    {
      ac.w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", new Object[] { Long.valueOf(this.fOL) });
      if (this.fOL == -901L) {
        h.wUl.idkeyStat(711L, 5L, 1L, false);
      }
      h.wUl.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = (Throwable)new MMGIFException(201);
      AppMethodBeat.o(105378);
      throw paramArrayOfByte;
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(this.fOL, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      ac.w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        h.wUl.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        h.wUl.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.fOL, paramArrayOfByte, paramArrayOfByte.length, this.fOH);
    if (i != 0)
    {
      ac.w(this.TAG, "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        h.wUl.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        h.wUl.idkeyStat(711L, 3L, 1L, false);
      }
    }
    paramArrayOfByte = Bitmap.createBitmap(this.fOH[1], this.fOH[2], Bitmap.Config.ARGB_8888);
    k.g(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
    this.fOF = paramArrayOfByte;
    this.fOK = new c(this.fOH[0]);
    AppMethodBeat.o(105378);
  }
  
  public final void abQ()
  {
    AppMethodBeat.i(105376);
    Bitmap localBitmap = this.fOF;
    int i = MMWXGFJNI.nativeDecodeBufferFrame(this.fOL, null, 0, localBitmap, this.fOM);
    if (i == -904)
    {
      ac.i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
      h.wUl.idkeyStat(401L, 8L, 1L, false);
      this.fOI += 1;
      if (((this.fOI >= this.fOH[0] - 1) || (i == 1)) && (MMWXGFJNI.nativeRewindBuffer(this.fOL) == -905))
      {
        h.wUl.idkeyStat(711L, 9L, 1L, false);
        ac.w(this.TAG, "Cpan Rewind buffer failed.");
      }
      this.fOI %= this.fOH[0];
      if (this.fOM[0] <= 0) {
        break label251;
      }
    }
    label251:
    for (i = this.fOM[0];; i = 100)
    {
      this.fOJ = i;
      ac.d(this.TAG, "drawFrameBitmap: decode frame " + this.fOI + ", " + this.fOJ);
      AppMethodBeat.o(105376);
      return;
      if (i == -909)
      {
        ac.i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
        h.wUl.idkeyStat(401L, 11L, 1L, false);
        break;
      }
      if (i != -1) {
        break;
      }
      ac.i(this.TAG, "nativeDecodeBufferFrame failed.");
      break;
    }
  }
  
  public final Bitmap abR()
  {
    return this.fOF;
  }
  
  public final int abS()
  {
    return this.fOH[0];
  }
  
  public final int abT()
  {
    if (this.fOH[0] == 1) {
      return 2147483647;
    }
    return this.fOJ;
  }
  
  public final int abU()
  {
    return this.fOH[1];
  }
  
  public final int abV()
  {
    return this.fOH[2];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105377);
    long l = this.fOL;
    this.fOL = 0L;
    int i = MMWXGFJNI.nativeUninit(l);
    if (i == -906) {
      h.wUl.idkeyStat(401L, 10L, 1L, false);
    }
    ac.d(this.TAG, "nativeUninit result:%d gifHandle:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    AppMethodBeat.o(105377);
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(209817);
    if (this.fOJ <= 0) {
      abQ();
    }
    int j = this.fOK.lv((int)paramLong);
    int m = this.fOH[0];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      abQ();
      this.fOK.cu(this.fOI, this.fOJ);
      j = this.fOK.lv((int)paramLong);
      i += 1;
    }
    j = (j - this.fOI + this.fOH[0]) % this.fOH[0];
    ac.d(this.TAG, "seekTo: " + paramLong + ", " + this.fOI + ", " + j + ", " + abT() + ", " + this.fOH[0] + 65292 + this.fOK.fOD);
    i = k;
    while (i < j)
    {
      abQ();
      i += 1;
    }
    AppMethodBeat.o(209817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.g
 * JD-Core Version:    0.7.0.1
 */