package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gif.MMGIFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.io.InputStream;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/decode/MMGIFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "TAG", "", "currFrame", "", "currFrameTime", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifPointer", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "", "startPerformance", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class f
  implements d
{
  private final String TAG;
  private Bitmap fOF;
  private long fOG;
  private final int[] fOH;
  private int fOI;
  private int fOJ;
  private final c fOK;
  private int fsu;
  
  public f(InputStream paramInputStream)
  {
    AppMethodBeat.i(105373);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.fOH = new int[6];
    this.fOI = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.fsu = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.fOG = MMGIFJNI.openByInputStrem(paramInputStream, this.fOH);
      if ((this.fOH[0] > 1024) || (this.fOH[1] > 1024))
      {
        ac.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.fOH[0]), Integer.valueOf(this.fOH[1]) });
        h.wUl.idkeyStat(401L, 2L, 1L, false);
      }
      paramInputStream = Bitmap.createBitmap(this.fOH[0], this.fOH[1], Bitmap.Config.ARGB_8888);
      k.g(paramInputStream, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.fOF = paramInputStream;
      this.fOK = new c(this.fOH[2]);
      AppMethodBeat.o(105373);
      return;
    }
  }
  
  public f(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105372);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.fOH = new int[6];
    this.fOI = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.fsu = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.fOG = MMGIFJNI.openByByteArray(paramArrayOfByte, this.fOH);
      if ((this.fOH[0] > 1024) || (this.fOH[1] > 1024))
      {
        ac.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.fOH[0]), Integer.valueOf(this.fOH[1]) });
        h.wUl.idkeyStat(401L, 2L, 1L, false);
      }
      paramArrayOfByte = Bitmap.createBitmap(this.fOH[0], this.fOH[1], Bitmap.Config.ARGB_8888);
      k.g(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.fOF = paramArrayOfByte;
      this.fOK = new c(this.fOH[2]);
      AppMethodBeat.o(105372);
      return;
    }
  }
  
  public final void abQ()
  {
    AppMethodBeat.i(105370);
    Bitmap localBitmap = this.fOF;
    MMGIFJNI.drawFrameBitmap(this.fOG, localBitmap, this.fOH);
    this.fOI = this.fOH[5];
    this.fOJ = this.fOH[4];
    ac.d(this.TAG, "drawFrameBitmap: decode frame " + this.fOI + ", " + this.fOJ);
    AppMethodBeat.o(105370);
  }
  
  public final Bitmap abR()
  {
    return this.fOF;
  }
  
  public final int abS()
  {
    return this.fOH[2];
  }
  
  public final int abT()
  {
    if (this.fOH[2] == 1) {
      return 2147483647;
    }
    return this.fOH[4];
  }
  
  public final int abU()
  {
    return this.fOH[0];
  }
  
  public final int abV()
  {
    return this.fOH[1];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105371);
    if (this.fsu != 0) {
      if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      WXHardCoderJNI.stopPerformance(bool, this.fsu);
      this.fsu = 0;
      long l = this.fOG;
      this.fOG = 0L;
      MMGIFJNI.recycle(l);
      AppMethodBeat.o(105371);
      return;
    }
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(209816);
    if (this.fOJ <= 0) {
      abQ();
    }
    int j = this.fOK.lv((int)paramLong);
    int m = this.fOH[2];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      abQ();
      this.fOK.cu(this.fOI, this.fOJ);
      j = this.fOK.lv((int)paramLong);
      i += 1;
    }
    j = (j - this.fOI + this.fOH[2]) % this.fOH[2];
    ac.d(this.TAG, "seekTo: " + paramLong + ", " + this.fOI + ", " + j + ", " + abT() + ", " + this.fOH[2] + 65292 + this.fOK.fOD);
    i = k;
    while (i < j)
    {
      abQ();
      i += 1;
    }
    AppMethodBeat.o(209816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.f
 * JD-Core Version:    0.7.0.1
 */