package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gif.MMGIFJNI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.io.InputStream;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/decode/MMGIFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "TAG", "", "currFrame", "", "currFrameTime", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifPointer", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "", "startPerformance", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class f
  implements d
{
  private final String TAG;
  private int fMX;
  private int gkA;
  private int gkB;
  private final c gkC;
  private Bitmap gkx;
  private long gky;
  private final int[] gkz;
  
  public f(InputStream paramInputStream)
  {
    AppMethodBeat.i(105373);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.gkz = new int[6];
    this.gkA = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.fMX = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.gky = MMGIFJNI.openByInputStrem(paramInputStream, this.gkz);
      if ((this.gkz[0] > 1024) || (this.gkz[1] > 1024))
      {
        ae.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.gkz[0]), Integer.valueOf(this.gkz[1]) });
        g.yxI.idkeyStat(401L, 2L, 1L, false);
      }
      paramInputStream = Bitmap.createBitmap(this.gkz[0], this.gkz[1], Bitmap.Config.ARGB_8888);
      p.g(paramInputStream, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.gkx = paramInputStream;
      this.gkC = new c(this.gkz[2]);
      AppMethodBeat.o(105373);
      return;
    }
  }
  
  public f(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105372);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.gkz = new int[6];
    this.gkA = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.fMX = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.gky = MMGIFJNI.openByByteArray(paramArrayOfByte, this.gkz);
      if ((this.gkz[0] > 1024) || (this.gkz[1] > 1024))
      {
        ae.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.gkz[0]), Integer.valueOf(this.gkz[1]) });
        g.yxI.idkeyStat(401L, 2L, 1L, false);
      }
      paramArrayOfByte = Bitmap.createBitmap(this.gkz[0], this.gkz[1], Bitmap.Config.ARGB_8888);
      p.g(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.gkx = paramArrayOfByte;
      this.gkC = new c(this.gkz[2]);
      AppMethodBeat.o(105372);
      return;
    }
  }
  
  public final void aeG()
  {
    AppMethodBeat.i(105370);
    Bitmap localBitmap = this.gkx;
    MMGIFJNI.drawFrameBitmap(this.gky, localBitmap, this.gkz);
    this.gkA = this.gkz[5];
    this.gkB = this.gkz[4];
    ae.d(this.TAG, "drawFrameBitmap: decode frame " + this.gkA + ", " + this.gkB);
    AppMethodBeat.o(105370);
  }
  
  public final Bitmap aeH()
  {
    return this.gkx;
  }
  
  public final int aeI()
  {
    return this.gkz[2];
  }
  
  public final int aeJ()
  {
    if (this.gkz[2] == 1) {
      return 2147483647;
    }
    return this.gkz[4];
  }
  
  public final int aeK()
  {
    return this.gkz[0];
  }
  
  public final int aeL()
  {
    return this.gkz[1];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105371);
    if (this.fMX != 0) {
      if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      WXHardCoderJNI.stopPerformance(bool, this.fMX);
      this.fMX = 0;
      long l = this.gky;
      this.gky = 0L;
      MMGIFJNI.recycle(l);
      AppMethodBeat.o(105371);
      return;
    }
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(188544);
    if (this.gkB <= 0) {
      aeG();
    }
    int j = this.gkC.lW((int)paramLong);
    int m = this.gkz[2];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      aeG();
      this.gkC.cw(this.gkA, this.gkB);
      j = this.gkC.lW((int)paramLong);
      i += 1;
    }
    j = (j - this.gkA + this.gkz[2]) % this.gkz[2];
    ae.d(this.TAG, "seekTo: " + paramLong + ", " + this.gkA + ", " + j + ", " + aeJ() + ", " + this.gkz[2] + 65292 + this.gkC.gkv);
    i = k;
    while (i < j)
    {
      aeG();
      i += 1;
    }
    AppMethodBeat.o(188544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.f
 * JD-Core Version:    0.7.0.1
 */