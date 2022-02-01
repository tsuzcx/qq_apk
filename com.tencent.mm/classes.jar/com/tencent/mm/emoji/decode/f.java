package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gif.MMGIFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/decode/MMGIFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "TAG", "", "currFrame", "", "currFrameTime", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifPointer", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "", "startPerformance", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements d
{
  private final String TAG;
  private int lyw;
  private Bitmap mfo;
  private long mfp;
  private final int[] mfq;
  private int mfr;
  private int mfs;
  private final c mft;
  
  public f(InputStream paramInputStream)
  {
    AppMethodBeat.i(105373);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.mfq = new int[6];
    this.mfr = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.lyw = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.mfp = MMGIFJNI.openByInputStrem(paramInputStream, this.mfq);
      if ((this.mfq[0] > 1024) || (this.mfq[1] > 1024))
      {
        Log.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.mfq[0]), Integer.valueOf(this.mfq[1]) });
        h.OAn.idkeyStat(401L, 2L, 1L, false);
      }
      paramInputStream = Bitmap.createBitmap(this.mfq[0], this.mfq[1], Bitmap.Config.ARGB_8888);
      s.s(paramInputStream, "createBitmap(frameWidth(… Bitmap.Config.ARGB_8888)");
      this.mfo = paramInputStream;
      this.mft = new c(this.mfq[2]);
      AppMethodBeat.o(105373);
      return;
    }
  }
  
  public f(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105372);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.mfq = new int[6];
    this.mfr = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.lyw = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.mfp = MMGIFJNI.openByByteArray(paramArrayOfByte, this.mfq);
      if ((this.mfq[0] > 1024) || (this.mfq[1] > 1024))
      {
        Log.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.mfq[0]), Integer.valueOf(this.mfq[1]) });
        h.OAn.idkeyStat(401L, 2L, 1L, false);
      }
      paramArrayOfByte = Bitmap.createBitmap(this.mfq[0], this.mfq[1], Bitmap.Config.ARGB_8888);
      s.s(paramArrayOfByte, "createBitmap(frameWidth(… Bitmap.Config.ARGB_8888)");
      this.mfo = paramArrayOfByte;
      this.mft = new c(this.mfq[2]);
      AppMethodBeat.o(105372);
      return;
    }
  }
  
  public final void aUe()
  {
    AppMethodBeat.i(105370);
    Bitmap localBitmap = this.mfo;
    MMGIFJNI.drawFrameBitmap(this.mfp, localBitmap, this.mfq);
    this.mfr = this.mfq[5];
    this.mfs = this.mfq[4];
    Log.d(this.TAG, "drawFrameBitmap: decode frame " + this.mfr + ", " + this.mfs);
    AppMethodBeat.o(105370);
  }
  
  public final int aUf()
  {
    return this.mfq[2];
  }
  
  public final int aUg()
  {
    if (this.mfq[2] == 1) {
      return 2147483647;
    }
    return this.mfq[4];
  }
  
  public final int aUh()
  {
    return this.mfq[0];
  }
  
  public final int aUi()
  {
    return this.mfq[1];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105371);
    if (this.lyw != 0) {
      if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      WXHardCoderJNI.stopPerformance(bool, this.lyw);
      this.lyw = 0;
      long l = this.mfp;
      this.mfp = 0L;
      MMGIFJNI.recycle(l);
      AppMethodBeat.o(105371);
      return;
    }
  }
  
  public final Bitmap getFrame()
  {
    return this.mfo;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(242233);
    if (this.mfs <= 0) {
      aUe();
    }
    int i = this.mft.rz((int)paramLong);
    int n = this.mfq[2];
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
    int k = (j - this.mfr + this.mfq[2]) % this.mfq[2];
    Log.d(this.TAG, "seekTo: " + paramLong + ", " + this.mfr + ", " + k + ", " + aUg() + ", " + this.mfq[2] + 65292 + this.mft.mfm);
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
    AppMethodBeat.o(242233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.f
 * JD-Core Version:    0.7.0.1
 */