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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/decode/MMGIFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "TAG", "", "currFrame", "", "currFrameTime", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifPointer", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "", "startPerformance", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class f
  implements d
{
  private final String TAG;
  private int iWt;
  private Bitmap jFB;
  private long jFC;
  private final int[] jFD;
  private int jFE;
  private int jFF;
  private final c jFG;
  
  public f(InputStream paramInputStream)
  {
    AppMethodBeat.i(105373);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.jFD = new int[6];
    this.jFE = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.iWt = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.jFC = MMGIFJNI.openByInputStrem(paramInputStream, this.jFD);
      if ((this.jFD[0] > 1024) || (this.jFD[1] > 1024))
      {
        Log.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.jFD[0]), Integer.valueOf(this.jFD[1]) });
        h.IzE.idkeyStat(401L, 2L, 1L, false);
      }
      paramInputStream = Bitmap.createBitmap(this.jFD[0], this.jFD[1], Bitmap.Config.ARGB_8888);
      p.j(paramInputStream, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.jFB = paramInputStream;
      this.jFG = new c(this.jFD[2]);
      AppMethodBeat.o(105373);
      return;
    }
  }
  
  public f(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105372);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.jFD = new int[6];
    this.jFE = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.iWt = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.jFC = MMGIFJNI.openByByteArray(paramArrayOfByte, this.jFD);
      if ((this.jFD[0] > 1024) || (this.jFD[1] > 1024))
      {
        Log.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.jFD[0]), Integer.valueOf(this.jFD[1]) });
        h.IzE.idkeyStat(401L, 2L, 1L, false);
      }
      paramArrayOfByte = Bitmap.createBitmap(this.jFD[0], this.jFD[1], Bitmap.Config.ARGB_8888);
      p.j(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.jFB = paramArrayOfByte;
      this.jFG = new c(this.jFD[2]);
      AppMethodBeat.o(105372);
      return;
    }
  }
  
  public final void aBh()
  {
    AppMethodBeat.i(105370);
    Bitmap localBitmap = this.jFB;
    MMGIFJNI.drawFrameBitmap(this.jFC, localBitmap, this.jFD);
    this.jFE = this.jFD[5];
    this.jFF = this.jFD[4];
    Log.d(this.TAG, "drawFrameBitmap: decode frame " + this.jFE + ", " + this.jFF);
    AppMethodBeat.o(105370);
  }
  
  public final int aBi()
  {
    return this.jFD[2];
  }
  
  public final int aBj()
  {
    if (this.jFD[2] == 1) {
      return 2147483647;
    }
    return this.jFD[4];
  }
  
  public final int aBk()
  {
    return this.jFD[0];
  }
  
  public final int aBl()
  {
    return this.jFD[1];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105371);
    if (this.iWt != 0) {
      if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      WXHardCoderJNI.stopPerformance(bool, this.iWt);
      this.iWt = 0;
      long l = this.jFC;
      this.jFC = 0L;
      MMGIFJNI.recycle(l);
      AppMethodBeat.o(105371);
      return;
    }
  }
  
  public final Bitmap getFrame()
  {
    return this.jFB;
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(225996);
    if (this.jFF <= 0) {
      aBh();
    }
    int j = this.jFG.rx((int)paramLong);
    int m = this.jFD[2];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      aBh();
      this.jFG.cT(this.jFE, this.jFF);
      j = this.jFG.rx((int)paramLong);
      i += 1;
    }
    j = (j - this.jFE + this.jFD[2]) % this.jFD[2];
    Log.d(this.TAG, "seekTo: " + paramLong + ", " + this.jFE + ", " + j + ", " + aBj() + ", " + this.jFD[2] + 65292 + this.jFG.jFz);
    i = k;
    while (i < j)
    {
      aBh();
      i += 1;
    }
    AppMethodBeat.o(225996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.f
 * JD-Core Version:    0.7.0.1
 */