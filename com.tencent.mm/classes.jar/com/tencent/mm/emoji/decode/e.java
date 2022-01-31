package com.tencent.mm.emoji.decode;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/decode/MMWXGFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "TAG", "", "currFrame", "", "currFrameTime", "frameMetadata", "", "gifHandle", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "plugin-emojisdk_release"})
public final class e
  implements b
{
  private final String TAG;
  private int currFrame;
  private Bitmap evb;
  private final int[] evd;
  private long eve;
  private final int[] evf;
  private int evg;
  
  public e(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63149);
    this.TAG = "MicroMsg.GIF.MMWXGFDecoder";
    this.evd = new int[4];
    this.evf = new int[4];
    this.currFrame = -1;
    this.evg = 100;
    this.eve = MMWXGFJNI.nativeInitWxAMDecoder();
    if ((this.eve == 0L) || (this.eve == -901L))
    {
      ab.w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", new Object[] { Long.valueOf(this.eve) });
      if (this.eve == -901L) {
        h.qsU.idkeyStat(711L, 5L, 1L, false);
      }
      h.qsU.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = (Throwable)new MMGIFException(201);
      AppMethodBeat.o(63149);
      throw paramArrayOfByte;
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(this.eve, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      ab.w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        h.qsU.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(63149);
        throw paramArrayOfByte;
        h.qsU.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.eve, paramArrayOfByte, paramArrayOfByte.length, this.evd);
    if (i != 0)
    {
      ab.w(this.TAG, "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        h.qsU.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = (Throwable)new MMGIFException(i);
        AppMethodBeat.o(63149);
        throw paramArrayOfByte;
        h.qsU.idkeyStat(711L, 3L, 1L, false);
      }
    }
    paramArrayOfByte = Bitmap.createBitmap(this.evd[1], this.evd[2], Bitmap.Config.ARGB_8888);
    j.p(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
    this.evb = paramArrayOfByte;
    AppMethodBeat.o(63149);
  }
  
  public final void Om()
  {
    AppMethodBeat.i(63147);
    Bitmap localBitmap = this.evb;
    int i = MMWXGFJNI.nativeDecodeBufferFrame(this.eve, null, 0, localBitmap, this.evf);
    if (i == -904)
    {
      ab.i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
      h.qsU.idkeyStat(401L, 8L, 1L, false);
      this.currFrame += 1;
      if ((this.currFrame >= this.evd[0]) || (i == 1))
      {
        this.currFrame = -1;
        if (MMWXGFJNI.nativeRewindBuffer(this.eve) == -905)
        {
          h.qsU.idkeyStat(711L, 9L, 1L, false);
          ab.w(this.TAG, "Cpan Rewind buffer failed.");
        }
      }
      if (this.evf[0] <= 0) {
        break label201;
      }
    }
    label201:
    for (i = this.evf[0];; i = 100)
    {
      this.evg = i;
      AppMethodBeat.o(63147);
      return;
      if (i == -909)
      {
        ab.i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
        h.qsU.idkeyStat(401L, 11L, 1L, false);
        break;
      }
      if (i != -1) {
        break;
      }
      ab.i(this.TAG, "nativeDecodeBufferFrame failed.");
      break;
    }
  }
  
  public final Bitmap On()
  {
    return this.evb;
  }
  
  public final int Oo()
  {
    return this.evd[0];
  }
  
  public final int Op()
  {
    if (this.evd[0] == 1) {
      return 2147483647;
    }
    return this.evg;
  }
  
  public final int Oq()
  {
    return this.evd[1];
  }
  
  public final int Or()
  {
    return this.evd[2];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63148);
    long l = this.eve;
    this.eve = 0L;
    int i = MMWXGFJNI.nativeUninit(l);
    if (i == -906) {
      h.qsU.idkeyStat(401L, 10L, 1L, false);
    }
    ab.d(this.TAG, "nativeUninit result:%d gifHandle:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    AppMethodBeat.o(63148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.e
 * JD-Core Version:    0.7.0.1
 */