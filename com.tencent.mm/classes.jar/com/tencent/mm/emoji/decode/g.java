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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/decode/MMWXGFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "TAG", "", "currFrame", "", "currFrameTime", "frameMetadata", "", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifHandle", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class g
  implements d
{
  private final String TAG;
  private Bitmap gUK;
  private final int[] gUM;
  private int gUN;
  private int gUO;
  private final c gUP;
  private long gUQ;
  private final int[] gUR;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105378);
    this.TAG = "MicroMsg.GIF.MMWXGFDecoder";
    this.gUM = new int[4];
    this.gUR = new int[4];
    this.gUN = -1;
    this.gUQ = MMWXGFJNI.nativeInitWxAMDecoder();
    if ((this.gUQ == 0L) || (this.gUQ == -901L))
    {
      Log.w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", new Object[] { Long.valueOf(this.gUQ) });
      if (this.gUQ == -901L) {
        h.CyF.idkeyStat(711L, 5L, 1L, false);
      }
      h.CyF.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = (Throwable)new MMGIFException(201);
      AppMethodBeat.o(105378);
      throw paramArrayOfByte;
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(this.gUQ, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      Log.w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        h.CyF.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        h.CyF.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.gUQ, paramArrayOfByte, paramArrayOfByte.length, this.gUM);
    if (i != 0)
    {
      Log.w(this.TAG, "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        h.CyF.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        h.CyF.idkeyStat(711L, 3L, 1L, false);
      }
    }
    paramArrayOfByte = Bitmap.createBitmap(this.gUM[1], this.gUM[2], Bitmap.Config.ARGB_8888);
    p.g(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
    this.gUK = paramArrayOfByte;
    this.gUP = new c(this.gUM[0]);
    AppMethodBeat.o(105378);
  }
  
  public final void auo()
  {
    AppMethodBeat.i(105376);
    Bitmap localBitmap = this.gUK;
    int i = MMWXGFJNI.nativeDecodeBufferFrame(this.gUQ, null, 0, localBitmap, this.gUR);
    if (i == -904)
    {
      Log.i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
      h.CyF.idkeyStat(401L, 8L, 1L, false);
      this.gUN += 1;
      if (((this.gUN >= this.gUM[0] - 1) || (i == 1)) && (MMWXGFJNI.nativeRewindBuffer(this.gUQ) == -905))
      {
        h.CyF.idkeyStat(711L, 9L, 1L, false);
        Log.w(this.TAG, "Cpan Rewind buffer failed.");
      }
      this.gUN %= this.gUM[0];
      if (this.gUR[0] <= 0) {
        break label251;
      }
    }
    label251:
    for (i = this.gUR[0];; i = 100)
    {
      this.gUO = i;
      Log.d(this.TAG, "drawFrameBitmap: decode frame " + this.gUN + ", " + this.gUO);
      AppMethodBeat.o(105376);
      return;
      if (i == -909)
      {
        Log.i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
        h.CyF.idkeyStat(401L, 11L, 1L, false);
        break;
      }
      if (i != -1) {
        break;
      }
      Log.i(this.TAG, "nativeDecodeBufferFrame failed.");
      break;
    }
  }
  
  public final int aup()
  {
    return this.gUM[0];
  }
  
  public final int auq()
  {
    if (this.gUM[0] == 1) {
      return 2147483647;
    }
    return this.gUO;
  }
  
  public final int aur()
  {
    return this.gUM[1];
  }
  
  public final int aus()
  {
    return this.gUM[2];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105377);
    long l = this.gUQ;
    this.gUQ = 0L;
    int i = MMWXGFJNI.nativeUninit(l);
    if (i == -906) {
      h.CyF.idkeyStat(401L, 10L, 1L, false);
    }
    Log.d(this.TAG, "nativeUninit result:%d gifHandle:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    AppMethodBeat.o(105377);
  }
  
  public final Bitmap getFrame()
  {
    return this.gUK;
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(199867);
    if (this.gUO <= 0) {
      auo();
    }
    int j = this.gUP.pe((int)paramLong);
    int m = this.gUM[0];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      auo();
      this.gUP.cz(this.gUN, this.gUO);
      j = this.gUP.pe((int)paramLong);
      i += 1;
    }
    j = (j - this.gUN + this.gUM[0]) % this.gUM[0];
    Log.d(this.TAG, "seekTo: " + paramLong + ", " + this.gUN + ", " + j + ", " + auq() + ", " + this.gUM[0] + 65292 + this.gUP.gUI);
    i = k;
    while (i < j)
    {
      auo();
      i += 1;
    }
    AppMethodBeat.o(199867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.g
 * JD-Core Version:    0.7.0.1
 */