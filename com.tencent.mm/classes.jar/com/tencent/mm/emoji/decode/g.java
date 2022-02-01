package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/decode/MMWXGFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "TAG", "", "currFrame", "", "currFrameTime", "frameMetadata", "", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifHandle", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements d
{
  private final String TAG;
  private Bitmap mfo;
  private final int[] mfq;
  private int mfr;
  private int mfs;
  private final c mft;
  private long mfu;
  private final int[] mfv;
  
  public g(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105378);
    this.TAG = "MicroMsg.GIF.MMWXGFDecoder";
    this.mfq = new int[4];
    this.mfv = new int[4];
    this.mfr = -1;
    this.mfu = MMWXGFJNI.nativeInitWxAMDecoder();
    if ((this.mfu == 0L) || (this.mfu == -901L))
    {
      Log.w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", new Object[] { Long.valueOf(this.mfu) });
      if (this.mfu == -901L) {
        h.OAn.idkeyStat(711L, 5L, 1L, false);
      }
      h.OAn.idkeyStat(711L, 4L, 1L, false);
      paramArrayOfByte = new MMGIFException(201);
      AppMethodBeat.o(105378);
      throw paramArrayOfByte;
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(this.mfu, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      Log.w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        h.OAn.idkeyStat(711L, 8L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        h.OAn.idkeyStat(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.mfu, paramArrayOfByte, paramArrayOfByte.length, this.mfq);
    if (i != 0)
    {
      Log.w(this.TAG, "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        h.OAn.idkeyStat(711L, 7L, 1L, false);
      }
      for (;;)
      {
        paramArrayOfByte = new MMGIFException(i);
        AppMethodBeat.o(105378);
        throw paramArrayOfByte;
        h.OAn.idkeyStat(711L, 3L, 1L, false);
      }
    }
    paramArrayOfByte = Bitmap.createBitmap(this.mfq[1], this.mfq[2], Bitmap.Config.ARGB_8888);
    s.s(paramArrayOfByte, "createBitmap(frameWidth(… Bitmap.Config.ARGB_8888)");
    this.mfo = paramArrayOfByte;
    this.mft = new c(this.mfq[0]);
    AppMethodBeat.o(105378);
  }
  
  public final void aUe()
  {
    AppMethodBeat.i(105376);
    Bitmap localBitmap = this.mfo;
    int i = MMWXGFJNI.nativeDecodeBufferFrame(this.mfu, null, 0, localBitmap, this.mfv);
    switch (i)
    {
    default: 
      this.mfr += 1;
      if (((this.mfr >= this.mfq[0] - 1) || (i == 1)) && (MMWXGFJNI.nativeRewindBuffer(this.mfu) == -905))
      {
        h.OAn.idkeyStat(711L, 9L, 1L, false);
        Log.w(this.TAG, "Cpan Rewind buffer failed.");
      }
      this.mfr %= this.mfq[0];
      if (this.mfv[0] <= 0) {
        break;
      }
    }
    for (i = this.mfv[0];; i = 100)
    {
      this.mfs = i;
      Log.d(this.TAG, "drawFrameBitmap: decode frame " + this.mfr + ", " + this.mfs);
      AppMethodBeat.o(105376);
      return;
      Log.i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
      h.OAn.idkeyStat(401L, 8L, 1L, false);
      break;
      Log.i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
      h.OAn.idkeyStat(401L, 11L, 1L, false);
      break;
      Log.i(this.TAG, "nativeDecodeBufferFrame failed.");
      break;
    }
  }
  
  public final int aUf()
  {
    return this.mfq[0];
  }
  
  public final int aUg()
  {
    if (this.mfq[0] == 1) {
      return 2147483647;
    }
    return this.mfs;
  }
  
  public final int aUh()
  {
    return this.mfq[1];
  }
  
  public final int aUi()
  {
    return this.mfq[2];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105377);
    long l = this.mfu;
    this.mfu = 0L;
    int i = MMWXGFJNI.nativeUninit(l);
    if (i == -906) {
      h.OAn.idkeyStat(401L, 10L, 1L, false);
    }
    Log.d(this.TAG, "nativeUninit result:%d gifHandle:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
    AppMethodBeat.o(105377);
  }
  
  public final Bitmap getFrame()
  {
    return this.mfo;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(242228);
    if (this.mfs <= 0) {
      aUe();
    }
    int i = this.mft.rz((int)paramLong);
    int n = this.mfq[0];
    int j = i;
    if (n > 0)
    {
      j = 0;
      int m;
      do
      {
        m = j + 1;
        j = i;
        if (i >= 0) {
          break;
        }
        aUe();
        this.mft.dG(this.mfr, this.mfs);
        k = this.mft.rz((int)paramLong);
        i = k;
        j = m;
      } while (m < n);
      j = k;
    }
    int k = (j - this.mfr + this.mfq[0]) % this.mfq[0];
    Log.d(this.TAG, "seekTo: " + paramLong + ", " + this.mfr + ", " + k + ", " + aUg() + ", " + this.mfq[0] + 65292 + this.mft.mfm);
    if (k > 0)
    {
      i = 0;
      do
      {
        j = i + 1;
        aUe();
        i = j;
      } while (j < k);
    }
    AppMethodBeat.o(242228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.g
 * JD-Core Version:    0.7.0.1
 */