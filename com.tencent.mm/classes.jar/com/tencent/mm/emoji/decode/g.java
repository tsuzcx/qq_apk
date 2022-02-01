package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/decode/MMWXGFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "TAG", "", "currFrame", "", "currFrameTime", "frameMetadata", "", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifHandle", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class g
  implements d
{
  private final String TAG;
  private int gkA;
  private int gkB;
  private final c gkC;
  private long gkD;
  private final int[] gkE;
  private Bitmap gkx;
  private final int[] gkz;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105378);
    this.TAG = "MicroMsg.GIF.MMWXGFDecoder";
    this.gkz = new int[4];
    this.gkE = new int[4];
    this.gkA = -1;
    this.gkD = MMWXGFJNI.nativeInitWxAMDecoder();
    if ((this.gkD == 0L) || (this.gkD == -901L))
    {
      ae.w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", new Object[] { Long.valueOf(this.gkD) });
      if (this.gkD == -901L) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 5L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = (Throwable)new MMGIFException(201);
      AppMethodBeat.o(105378);
      throw paramArrayOfByte;
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(this.gkD, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      ae.w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.gkD, paramArrayOfByte, paramArrayOfByte.length, this.gkz);
    if (i != 0)
    {
      ae.w(this.TAG, "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 3L, 1L, false);
      }
    }
    paramArrayOfByte = Bitmap.createBitmap(this.gkz[1], this.gkz[2], Bitmap.Config.ARGB_8888);
    p.g(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
    this.gkx = paramArrayOfByte;
    this.gkC = new c(this.gkz[0]);
    AppMethodBeat.o(105378);
  }
  
  public final void aeG()
  {
    AppMethodBeat.i(105376);
    Bitmap localBitmap = this.gkx;
    int i = MMWXGFJNI.nativeDecodeBufferFrame(this.gkD, null, 0, localBitmap, this.gkE);
    if (i == -904)
    {
      ae.i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(401L, 8L, 1L, false);
      this.gkA += 1;
      if (((this.gkA >= this.gkz[0] - 1) || (i == 1)) && (MMWXGFJNI.nativeRewindBuffer(this.gkD) == -905))
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(711L, 9L, 1L, false);
        ae.w(this.TAG, "Cpan Rewind buffer failed.");
      }
      this.gkA %= this.gkz[0];
      if (this.gkE[0] <= 0) {
        break label251;
      }
    }
    label251:
    for (i = this.gkE[0];; i = 100)
    {
      this.gkB = i;
      ae.d(this.TAG, "drawFrameBitmap: decode frame " + this.gkA + ", " + this.gkB);
      AppMethodBeat.o(105376);
      return;
      if (i == -909)
      {
        ae.i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(401L, 11L, 1L, false);
        break;
      }
      if (i != -1) {
        break;
      }
      ae.i(this.TAG, "nativeDecodeBufferFrame failed.");
      break;
    }
  }
  
  public final Bitmap aeH()
  {
    return this.gkx;
  }
  
  public final int aeI()
  {
    return this.gkz[0];
  }
  
  public final int aeJ()
  {
    if (this.gkz[0] == 1) {
      return 2147483647;
    }
    return this.gkB;
  }
  
  public final int aeK()
  {
    return this.gkz[1];
  }
  
  public final int aeL()
  {
    return this.gkz[2];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105377);
    long l = this.gkD;
    this.gkD = 0L;
    int i = MMWXGFJNI.nativeUninit(l);
    if (i == -906) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(401L, 10L, 1L, false);
    }
    ae.d(this.TAG, "nativeUninit result:%d gifHandle:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    AppMethodBeat.o(105377);
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(188545);
    if (this.gkB <= 0) {
      aeG();
    }
    int j = this.gkC.lW((int)paramLong);
    int m = this.gkz[0];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      aeG();
      this.gkC.cw(this.gkA, this.gkB);
      j = this.gkC.lW((int)paramLong);
      i += 1;
    }
    j = (j - this.gkA + this.gkz[0]) % this.gkz[0];
    ae.d(this.TAG, "seekTo: " + paramLong + ", " + this.gkA + ", " + j + ", " + aeJ() + ", " + this.gkz[0] + 65292 + this.gkC.gkv);
    i = k;
    while (i < j)
    {
      aeG();
      i += 1;
    }
    AppMethodBeat.o(188545);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.g
 * JD-Core Version:    0.7.0.1
 */