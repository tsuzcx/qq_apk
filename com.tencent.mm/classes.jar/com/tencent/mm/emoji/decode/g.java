package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/decode/MMWXGFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "TAG", "", "currFrame", "", "currFrameTime", "frameMetadata", "", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifHandle", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class g
  implements d
{
  private final String TAG;
  private Bitmap gif;
  private final int[] gih;
  private int gii;
  private int gij;
  private final c gik;
  private long gil;
  private final int[] gim;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105378);
    this.TAG = "MicroMsg.GIF.MMWXGFDecoder";
    this.gih = new int[4];
    this.gim = new int[4];
    this.gii = -1;
    this.gil = MMWXGFJNI.nativeInitWxAMDecoder();
    if ((this.gil == 0L) || (this.gil == -901L))
    {
      ad.w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", new Object[] { Long.valueOf(this.gil) });
      if (this.gil == -901L) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 5L, 1L, false);
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = (Throwable)new MMGIFException(201);
      AppMethodBeat.o(105378);
      throw paramArrayOfByte;
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(this.gil, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      ad.w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.gil, paramArrayOfByte, paramArrayOfByte.length, this.gih);
    if (i != 0)
    {
      ad.w(this.TAG, "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 3L, 1L, false);
      }
    }
    paramArrayOfByte = Bitmap.createBitmap(this.gih[1], this.gih[2], Bitmap.Config.ARGB_8888);
    p.g(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
    this.gif = paramArrayOfByte;
    this.gik = new c(this.gih[0]);
    AppMethodBeat.o(105378);
  }
  
  public final void aeu()
  {
    AppMethodBeat.i(105376);
    Bitmap localBitmap = this.gif;
    int i = MMWXGFJNI.nativeDecodeBufferFrame(this.gil, null, 0, localBitmap, this.gim);
    if (i == -904)
    {
      ad.i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(401L, 8L, 1L, false);
      this.gii += 1;
      if (((this.gii >= this.gih[0] - 1) || (i == 1)) && (MMWXGFJNI.nativeRewindBuffer(this.gil) == -905))
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(711L, 9L, 1L, false);
        ad.w(this.TAG, "Cpan Rewind buffer failed.");
      }
      this.gii %= this.gih[0];
      if (this.gim[0] <= 0) {
        break label251;
      }
    }
    label251:
    for (i = this.gim[0];; i = 100)
    {
      this.gij = i;
      ad.d(this.TAG, "drawFrameBitmap: decode frame " + this.gii + ", " + this.gij);
      AppMethodBeat.o(105376);
      return;
      if (i == -909)
      {
        ad.i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(401L, 11L, 1L, false);
        break;
      }
      if (i != -1) {
        break;
      }
      ad.i(this.TAG, "nativeDecodeBufferFrame failed.");
      break;
    }
  }
  
  public final Bitmap aev()
  {
    return this.gif;
  }
  
  public final int aew()
  {
    return this.gih[0];
  }
  
  public final int aex()
  {
    if (this.gih[0] == 1) {
      return 2147483647;
    }
    return this.gij;
  }
  
  public final int aey()
  {
    return this.gih[1];
  }
  
  public final int aez()
  {
    return this.gih[2];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105377);
    long l = this.gil;
    this.gil = 0L;
    int i = MMWXGFJNI.nativeUninit(l);
    if (i == -906) {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(401L, 10L, 1L, false);
    }
    ad.d(this.TAG, "nativeUninit result:%d gifHandle:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    AppMethodBeat.o(105377);
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(218936);
    if (this.gij <= 0) {
      aeu();
    }
    int j = this.gik.lU((int)paramLong);
    int m = this.gih[0];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      aeu();
      this.gik.cw(this.gii, this.gij);
      j = this.gik.lU((int)paramLong);
      i += 1;
    }
    j = (j - this.gii + this.gih[0]) % this.gih[0];
    ad.d(this.TAG, "seekTo: " + paramLong + ", " + this.gii + ", " + j + ", " + aex() + ", " + this.gih[0] + 65292 + this.gik.gid);
    i = k;
    while (i < j)
    {
      aeu();
      i += 1;
    }
    AppMethodBeat.o(218936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.g
 * JD-Core Version:    0.7.0.1
 */