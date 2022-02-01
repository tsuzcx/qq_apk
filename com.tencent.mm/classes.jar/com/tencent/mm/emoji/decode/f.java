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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/decode/MMGIFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "TAG", "", "currFrame", "", "currFrameTime", "framePicker", "Lcom/tencent/mm/emoji/decode/FramePicker;", "gifPointer", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "", "startPerformance", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "plugin-emojisdk_release"})
public final class f
  implements d
{
  private final String TAG;
  private Bitmap gUK;
  private long gUL;
  private final int[] gUM;
  private int gUN;
  private int gUO;
  private final c gUP;
  private int gsi;
  
  public f(InputStream paramInputStream)
  {
    AppMethodBeat.i(105373);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.gUM = new int[6];
    this.gUN = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.gsi = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.gUL = MMGIFJNI.openByInputStrem(paramInputStream, this.gUM);
      if ((this.gUM[0] > 1024) || (this.gUM[1] > 1024))
      {
        Log.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.gUM[0]), Integer.valueOf(this.gUM[1]) });
        h.CyF.idkeyStat(401L, 2L, 1L, false);
      }
      paramInputStream = Bitmap.createBitmap(this.gUM[0], this.gUM[1], Bitmap.Config.ARGB_8888);
      p.g(paramInputStream, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.gUK = paramInputStream;
      this.gUP = new c(this.gUM[2]);
      AppMethodBeat.o(105373);
      return;
    }
  }
  
  public f(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(105372);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.gUM = new int[6];
    this.gUN = -1;
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.gsi = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.gUL = MMGIFJNI.openByByteArray(paramArrayOfByte, this.gUM);
      if ((this.gUM[0] > 1024) || (this.gUM[1] > 1024))
      {
        Log.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.gUM[0]), Integer.valueOf(this.gUM[1]) });
        h.CyF.idkeyStat(401L, 2L, 1L, false);
      }
      paramArrayOfByte = Bitmap.createBitmap(this.gUM[0], this.gUM[1], Bitmap.Config.ARGB_8888);
      p.g(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.gUK = paramArrayOfByte;
      this.gUP = new c(this.gUM[2]);
      AppMethodBeat.o(105372);
      return;
    }
  }
  
  public final void auo()
  {
    AppMethodBeat.i(105370);
    Bitmap localBitmap = this.gUK;
    MMGIFJNI.drawFrameBitmap(this.gUL, localBitmap, this.gUM);
    this.gUN = this.gUM[5];
    this.gUO = this.gUM[4];
    Log.d(this.TAG, "drawFrameBitmap: decode frame " + this.gUN + ", " + this.gUO);
    AppMethodBeat.o(105370);
  }
  
  public final int aup()
  {
    return this.gUM[2];
  }
  
  public final int auq()
  {
    if (this.gUM[2] == 1) {
      return 2147483647;
    }
    return this.gUM[4];
  }
  
  public final int aur()
  {
    return this.gUM[0];
  }
  
  public final int aus()
  {
    return this.gUM[1];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(105371);
    if (this.gsi != 0) {
      if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      WXHardCoderJNI.stopPerformance(bool, this.gsi);
      this.gsi = 0;
      long l = this.gUL;
      this.gUL = 0L;
      MMGIFJNI.recycle(l);
      AppMethodBeat.o(105371);
      return;
    }
  }
  
  public final Bitmap getFrame()
  {
    return this.gUK;
  }
  
  public final void seekTo(long paramLong)
  {
    int k = 0;
    AppMethodBeat.i(199863);
    if (this.gUO <= 0) {
      auo();
    }
    int j = this.gUP.pe((int)paramLong);
    int m = this.gUM[2];
    int i = 0;
    while ((i < m) && (j < 0))
    {
      auo();
      this.gUP.cz(this.gUN, this.gUO);
      j = this.gUP.pe((int)paramLong);
      i += 1;
    }
    j = (j - this.gUN + this.gUM[2]) % this.gUM[2];
    Log.d(this.TAG, "seekTo: " + paramLong + ", " + this.gUN + ", " + j + ", " + auq() + ", " + this.gUM[2] + 65292 + this.gUP.gUI);
    i = k;
    while (i < j)
    {
      auo();
      i += 1;
    }
    AppMethodBeat.o(199863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.f
 * JD-Core Version:    0.7.0.1
 */