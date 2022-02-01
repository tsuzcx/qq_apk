package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/decode/MMWXGFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "TAG", "", "currFrame", "", "currFrameTime", "frameMetadata", "", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifHandle", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class g
  implements d
{
  private final String TAG;
  private Bitmap jFB;
  private final int[] jFD;
  private int jFE;
  private int jFF;
  private final c jFG;
  private long jFH;
  private final int[] jFI;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105378);
    this.TAG = "MicroMsg.GIF.MMWXGFDecoder";
    this.jFD = new int[4];
    this.jFI = new int[4];
    this.jFE = -1;
    this.jFH = MMWXGFJNI.nativeInitWxAMDecoder();
    if ((this.jFH == 0L) || (this.jFH == -901L))
    {
      Log.w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", new Object[] { Long.valueOf(this.jFH) });
      if (this.jFH == -901L) {
        h.IzE.idkeyStat(711L, 5L, 1L, false);
      }
      h.IzE.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = (Throwable)new MMGIFException(201);
      AppMethodBeat.o(105378);
      throw paramArrayOfByte;
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(this.jFH, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      Log.w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        h.IzE.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        h.IzE.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.jFH, paramArrayOfByte, paramArrayOfByte.length, this.jFD);
    if (i != 0)
    {
      Log.w(this.TAG, "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        h.IzE.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        h.IzE.idkeyStat(711L, 3L, 1L, false);
      }
    }
    paramArrayOfByte = Bitmap.createBitmap(this.jFD[1], this.jFD[2], Bitmap.Config.ARGB_8888);
    p.j(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
    this.jFB = paramArrayOfByte;
    this.jFG = new c(this.jFD[0]);
    AppMethodBeat.o(105378);
  }
  
  public final void aBh()
  {
    AppMethodBeat.i(105376);
    Bitmap localBitmap = this.jFB;
    int i = MMWXGFJNI.nativeDecodeBufferFrame(this.jFH, null, 0, localBitmap, this.jFI);
    if (i == -904)
    {
      Log.i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
      h.IzE.idkeyStat(401L, 8L, 1L, false);
      this.jFE += 1;
      if (((this.jFE >= this.jFD[0] - 1) || (i == 1)) && (MMWXGFJNI.nativeRewindBuffer(this.jFH) == -905))
      {
        h.IzE.idkeyStat(711L, 9L, 1L, false);
        Log.w(this.TAG, "Cpan Rewind buffer failed.");
      }
      this.jFE %= this.jFD[0];
      if (this.jFI[0] <= 0) {
        break label251;
      }
    }
    label251:
    for (i = this.jFI[0];; i = 100)
    {
      this.jFF = i;
      Log.d(this.TAG, "drawFrameBitmap: decode frame " + this.jFE + ", " + this.jFF);
      AppMethodBeat.o(105376);
      return;
      if (i == -909)
      {
        Log.i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
        h.IzE.idkeyStat(401L, 11L, 1L, false);
        break;
      }
      if (i != -1) {
        break;
      }
      Log.i(this.TAG, "nativeDecodeBufferFrame failed.");
      break;
    }
  }
  
  public final int aBi()
  {
    return this.jFD[0];
  }
  
  public final int aBj()
  {
    if (this.jFD[0] == 1) {
      return 2147483647;
    }
    return this.jFF;
  }
  
  public final int aBk()
  {
    return this.jFD[1];
  }
  
  public final int aBl()
  {
    return this.jFD[2];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105377);
    long l = this.jFH;
    this.jFH = 0L;
    int i = MMWXGFJNI.nativeUninit(l);
    if (i == -906) {
      h.IzE.idkeyStat(401L, 10L, 1L, false);
    }
    Log.d(this.TAG, "nativeUninit result:%d gifHandle:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    AppMethodBeat.o(105377);
  }
  
  public final Bitmap getFrame()
  {
    return this.jFB;
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(232182);
    if (this.jFF <= 0) {
      aBh();
    }
    int j = this.jFG.rx((int)paramLong);
    int m = this.jFD[0];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      aBh();
      this.jFG.cT(this.jFE, this.jFF);
      j = this.jFG.rx((int)paramLong);
      i += 1;
    }
    j = (j - this.jFE + this.jFD[0]) % this.jFD[0];
    Log.d(this.TAG, "seekTo: " + paramLong + ", " + this.jFE + ", " + j + ", " + aBj() + ", " + this.jFD[0] + 65292 + this.jFG.jFz);
    i = k;
    while (i < j)
    {
      aBh();
      i += 1;
    }
    AppMethodBeat.o(232182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.g
 * JD-Core Version:    0.7.0.1
 */