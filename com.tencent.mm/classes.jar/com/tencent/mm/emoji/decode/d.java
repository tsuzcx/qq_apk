package com.tencent.mm.emoji.decode;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.gif.MMGIFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/decode/MMGIFDecoder;", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "bytes", "", "([B)V", "stream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "TAG", "", "gifPointer", "", "lastValidFrame", "Landroid/graphics/Bitmap;", "metadata", "", "startPerformance", "", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "frameCount", "frameHeight", "frameTime", "frameWidth", "getFrame", "plugin-emojisdk_release"})
public final class d
  implements b
{
  private final String TAG;
  private int eez;
  private Bitmap evb;
  private long evc;
  private final int[] evd;
  
  public d(InputStream paramInputStream)
  {
    AppMethodBeat.i(63144);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.evd = new int[6];
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.eez = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.evc = MMGIFJNI.openByInputStrem(paramInputStream, this.evd);
      if ((this.evd[0] > 1024) || (this.evd[1] > 1024))
      {
        ab.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.evd[0]), Integer.valueOf(this.evd[1]) });
        h.qsU.idkeyStat(401L, 2L, 1L, false);
      }
      paramInputStream = Bitmap.createBitmap(this.evd[0], this.evd[1], Bitmap.Config.ARGB_8888);
      j.p(paramInputStream, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.evb = paramInputStream;
      AppMethodBeat.o(63144);
      return;
    }
  }
  
  public d(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63143);
    this.TAG = "MicroMsg.GIF.MMGIFDecoder";
    this.evd = new int[6];
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      this.eez = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, this.TAG);
      this.evc = MMGIFJNI.openByByteArray(paramArrayOfByte, this.evd);
      if ((this.evd[0] > 1024) || (this.evd[1] > 1024))
      {
        ab.w(this.TAG, "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.evd[0]), Integer.valueOf(this.evd[1]) });
        h.qsU.idkeyStat(401L, 2L, 1L, false);
      }
      paramArrayOfByte = Bitmap.createBitmap(this.evd[0], this.evd[1], Bitmap.Config.ARGB_8888);
      j.p(paramArrayOfByte, "Bitmap.createBitmap(fram… Bitmap.Config.ARGB_8888)");
      this.evb = paramArrayOfByte;
      AppMethodBeat.o(63143);
      return;
    }
  }
  
  public final void Om()
  {
    AppMethodBeat.i(63141);
    MMGIFJNI.drawFrameBitmap(this.evc, this.evb, this.evd);
    AppMethodBeat.o(63141);
  }
  
  public final Bitmap On()
  {
    return this.evb;
  }
  
  public final int Oo()
  {
    return this.evd[2];
  }
  
  public final int Op()
  {
    if (this.evd[2] == 1) {
      return 2147483647;
    }
    return this.evd[4];
  }
  
  public final int Oq()
  {
    return this.evd[0];
  }
  
  public final int Or()
  {
    return this.evd[1];
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63142);
    if (this.eez != 0) {
      if ((!WXHardCoderJNI.hcGifEnable) && (!WXHardCoderJNI.hcGifFrameEnable)) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      WXHardCoderJNI.stopPerformance(bool, this.eez);
      this.eez = 0;
      long l = this.evc;
      this.evc = 0L;
      MMGIFJNI.recycle(l);
      AppMethodBeat.o(63142);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.d
 * JD-Core Version:    0.7.0.1
 */