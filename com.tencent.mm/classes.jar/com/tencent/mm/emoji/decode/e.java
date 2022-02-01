package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gif.MMGIFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.io.InputStream;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/decode/MMGIFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "TAG", "", "currFrame", "", "currFrameTime", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifPointer", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "", "startPerformance", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class e
  implements c
{
  private final String TAG;
  private Bitmap fKU;
  private long fKV;
  private final int[] fKW;
  private int fKZ;
  private int fLa;
  private int foV;
  private final g qro;
  
  public e(InputStream paramInputStream)
  {
    AppMethodBeat.i(105373);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.fKW = new int[6];
    this.fKZ = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.foV = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.fKV = MMGIFJNI.openByInputStrem(paramInputStream, this.fKW);
      if ((this.fKW[0] > 1024) || (this.fKW[1] > 1024))
      {
        ad.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.fKW[0]), Integer.valueOf(this.fKW[1]) });
        h.vKh.idkeyStat(401L, 2L, 1L, false);
      }
      paramInputStream = Bitmap.createBitmap(this.fKW[0], this.fKW[1], Bitmap.Config.ARGB_8888);
      k.g(paramInputStream, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.fKU = paramInputStream;
      this.qro = new g(this.fKW[2]);
      AppMethodBeat.o(105373);
      return;
    }
  }
  
  public e(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105372);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.fKW = new int[6];
    this.fKZ = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.foV = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.fKV = MMGIFJNI.openByByteArray(paramArrayOfByte, this.fKW);
      if ((this.fKW[0] > 1024) || (this.fKW[1] > 1024))
      {
        ad.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.fKW[0]), Integer.valueOf(this.fKW[1]) });
        h.vKh.idkeyStat(401L, 2L, 1L, false);
      }
      paramArrayOfByte = Bitmap.createBitmap(this.fKW[0], this.fKW[1], Bitmap.Config.ARGB_8888);
      k.g(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.fKU = paramArrayOfByte;
      this.qro = new g(this.fKW[2]);
      AppMethodBeat.o(105372);
      return;
    }
  }
  
  public final void aaR()
  {
    AppMethodBeat.i(105370);
    Bitmap localBitmap = this.fKU;
    MMGIFJNI.drawFrameBitmap(this.fKV, localBitmap, this.fKW);
    this.fKZ = this.fKW[5];
    this.fLa = this.fKW[4];
    ad.d(this.TAG, "drawFrameBitmap: decode frame " + this.fKZ + ", " + this.fLa);
    AppMethodBeat.o(105370);
  }
  
  public final Bitmap aaS()
  {
    return this.fKU;
  }
  
  public final int aaT()
  {
    return this.fKW[2];
  }
  
  public final int aaU()
  {
    if (this.fKW[2] == 1) {
      return 2147483647;
    }
    return this.fKW[4];
  }
  
  public final int aaV()
  {
    return this.fKW[0];
  }
  
  public final int aaW()
  {
    return this.fKW[1];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105371);
    if (this.foV != 0) {
      if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      WXHardCoderJNI.stopPerformance(bool, this.foV);
      this.foV = 0;
      long l = this.fKV;
      this.fKV = 0L;
      MMGIFJNI.recycle(l);
      AppMethodBeat.o(105371);
      return;
    }
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(202401);
    if (this.fLa <= 0) {
      aaR();
    }
    int j = this.qro.Bx((int)paramLong);
    int m = this.fKW[2];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      aaR();
      this.qro.ep(this.fKZ, this.fLa);
      j = this.qro.Bx((int)paramLong);
      i += 1;
    }
    j = (j - this.fKZ + this.fKW[2]) % this.fKW[2];
    ad.d(this.TAG, "seekTo: " + paramLong + ", " + this.fKZ + ", " + j + ", " + aaU() + ", " + this.fKW[2] + 65292 + this.qro.qre);
    i = k;
    while (i < j)
    {
      aaR();
      i += 1;
    }
    AppMethodBeat.o(202401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.e
 * JD-Core Version:    0.7.0.1
 */