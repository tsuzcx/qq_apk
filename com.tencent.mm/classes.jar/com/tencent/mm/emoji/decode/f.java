package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gif.MMGIFJNI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.InputStream;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/decode/MMGIFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "TAG", "", "currFrame", "", "currFrameTime", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifPointer", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "", "startPerformance", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class f
  implements d
{
  private final String TAG;
  private int fKU;
  private Bitmap gif;
  private long gig;
  private final int[] gih;
  private int gii;
  private int gij;
  private final c gik;
  
  public f(InputStream paramInputStream)
  {
    AppMethodBeat.i(105373);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.gih = new int[6];
    this.gii = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.fKU = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.gig = MMGIFJNI.openByInputStrem(paramInputStream, this.gih);
      if ((this.gih[0] > 1024) || (this.gih[1] > 1024))
      {
        ad.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.gih[0]), Integer.valueOf(this.gih[1]) });
        g.yhR.idkeyStat(401L, 2L, 1L, false);
      }
      paramInputStream = Bitmap.createBitmap(this.gih[0], this.gih[1], Bitmap.Config.ARGB_8888);
      p.g(paramInputStream, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.gif = paramInputStream;
      this.gik = new c(this.gih[2]);
      AppMethodBeat.o(105373);
      return;
    }
  }
  
  public f(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105372);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.gih = new int[6];
    this.gii = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.fKU = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.gig = MMGIFJNI.openByByteArray(paramArrayOfByte, this.gih);
      if ((this.gih[0] > 1024) || (this.gih[1] > 1024))
      {
        ad.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.gih[0]), Integer.valueOf(this.gih[1]) });
        g.yhR.idkeyStat(401L, 2L, 1L, false);
      }
      paramArrayOfByte = Bitmap.createBitmap(this.gih[0], this.gih[1], Bitmap.Config.ARGB_8888);
      p.g(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.gif = paramArrayOfByte;
      this.gik = new c(this.gih[2]);
      AppMethodBeat.o(105372);
      return;
    }
  }
  
  public final void aeu()
  {
    AppMethodBeat.i(105370);
    Bitmap localBitmap = this.gif;
    MMGIFJNI.drawFrameBitmap(this.gig, localBitmap, this.gih);
    this.gii = this.gih[5];
    this.gij = this.gih[4];
    ad.d(this.TAG, "drawFrameBitmap: decode frame " + this.gii + ", " + this.gij);
    AppMethodBeat.o(105370);
  }
  
  public final Bitmap aev()
  {
    return this.gif;
  }
  
  public final int aew()
  {
    return this.gih[2];
  }
  
  public final int aex()
  {
    if (this.gih[2] == 1) {
      return 2147483647;
    }
    return this.gih[4];
  }
  
  public final int aey()
  {
    return this.gih[0];
  }
  
  public final int aez()
  {
    return this.gih[1];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105371);
    if (this.fKU != 0) {
      if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      WXHardCoderJNI.stopPerformance(bool, this.fKU);
      this.fKU = 0;
      long l = this.gig;
      this.gig = 0L;
      MMGIFJNI.recycle(l);
      AppMethodBeat.o(105371);
      return;
    }
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(218935);
    if (this.gij <= 0) {
      aeu();
    }
    int j = this.gik.lU((int)paramLong);
    int m = this.gih[2];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      aeu();
      this.gik.cw(this.gii, this.gij);
      j = this.gik.lU((int)paramLong);
      i += 1;
    }
    j = (j - this.gii + this.gih[2]) % this.gih[2];
    ad.d(this.TAG, "seekTo: " + paramLong + ", " + this.gii + ", " + j + ", " + aex() + ", " + this.gih[2] + 65292 + this.gik.gid);
    i = k;
    while (i < j)
    {
      aeu();
      i += 1;
    }
    AppMethodBeat.o(218935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.f
 * JD-Core Version:    0.7.0.1
 */