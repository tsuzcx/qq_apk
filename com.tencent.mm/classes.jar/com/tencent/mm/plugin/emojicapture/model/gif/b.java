package com.tencent.mm.plugin.emojicapture.model.gif;

import android.graphics.Bitmap;
import android.os.Process;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gif.MMGIFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;

public final class b
  implements a
{
  private final String TAG = "MicroMsg.GIF.MMGIFDecoder";
  private int dmY;
  private long jkA;
  private final int[] jkB = new int[6];
  
  public b(InputStream paramInputStream)
  {
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.dmY = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.jkA = MMGIFJNI.openByInputStrem(paramInputStream, this.jkB);
      if ((this.jkB[0] > 1024) || (this.jkB[1] > 1024))
      {
        y.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.jkB[0]), Integer.valueOf(this.jkB[1]) });
        h.nFQ.a(401L, 2L, 1L, false);
      }
      return;
    }
  }
  
  public b(byte[] paramArrayOfByte)
  {
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.dmY = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.jkA = MMGIFJNI.openByByteArray(paramArrayOfByte, this.jkB);
      if ((this.jkB[0] > 1024) || (this.jkB[1] > 1024))
      {
        y.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.jkB[0]), Integer.valueOf(this.jkB[1]) });
        h.nFQ.a(401L, 2L, 1L, false);
      }
      return;
    }
  }
  
  public final int aKg()
  {
    return this.jkB[4];
  }
  
  public final int aKh()
  {
    return this.jkB[0];
  }
  
  public final int aKi()
  {
    return this.jkB[1];
  }
  
  public final void destroy()
  {
    if (this.dmY != 0) {
      if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      WXHardCoderJNI.stopPerformace(bool, this.dmY);
      this.dmY = 0;
      long l = this.jkA;
      this.jkA = 0L;
      MMGIFJNI.recycle(l);
      return;
    }
  }
  
  public final boolean x(Bitmap paramBitmap)
  {
    return MMGIFJNI.drawFrameBitmap(this.jkA, paramBitmap, this.jkB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.gif.b
 * JD-Core Version:    0.7.0.1
 */