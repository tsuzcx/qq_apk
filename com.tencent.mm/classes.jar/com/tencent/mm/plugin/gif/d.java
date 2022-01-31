package com.tencent.mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.InputStream;

public final class d
  extends b
{
  private final Rect Bc;
  private int eez;
  private ak loX;
  private float mDensity;
  private boolean mIsRunning;
  private final Paint mPaint;
  private final Runnable nFA;
  private final Runnable nFB;
  private final Runnable nFC;
  private final Runnable nFD;
  private final Runnable nFE;
  private final Runnable nFF;
  private boolean nFe;
  private volatile long nFf;
  private AssetFileDescriptor nFg;
  private final int[] nFh;
  private float nFi;
  private float nFj;
  private boolean nFk;
  private int[] nFl;
  private int nFm;
  private int nFn;
  private long nFo;
  private long nFp;
  private long nFq;
  private long nFr;
  private long nFs;
  private long nFt;
  private int nFu;
  private boolean nFv;
  int nFw;
  private int nFx;
  k nFy;
  private boolean nFz;
  
  public d(Resources paramResources, int paramInt)
  {
    this(paramResources.openRawResource(paramInt));
    AppMethodBeat.i(62387);
    AppMethodBeat.o(62387);
  }
  
  public d(InputStream paramInputStream)
  {
    AppMethodBeat.i(62390);
    this.mIsRunning = true;
    this.nFe = false;
    this.nFg = null;
    this.nFh = new int[6];
    this.nFi = 1.0F;
    this.nFj = 1.0F;
    this.Bc = new Rect();
    this.mPaint = new Paint(6);
    this.nFm = 0;
    this.nFn = -1;
    this.nFo = 0L;
    this.nFp = 0L;
    this.nFq = 0L;
    this.nFr = 0L;
    this.nFt = 0L;
    this.nFv = false;
    this.nFw = 0;
    this.nFx = 0;
    this.loX = new ak(Looper.getMainLooper());
    this.nFz = true;
    this.nFA = new d.1(this);
    this.nFB = new d.2(this);
    this.nFC = new d.3(this);
    this.nFD = new d.4(this);
    this.nFE = new d.5(this);
    this.nFF = new d.6(this);
    if (paramInputStream == null)
    {
      paramInputStream = new NullPointerException("input stream is null.");
      AppMethodBeat.o(62390);
      throw paramInputStream;
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.eez = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.nFf = MMGIFJNI.openByInputStrem(paramInputStream, this.nFh);
    init();
    AppMethodBeat.o(62390);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(62388);
    this.mIsRunning = true;
    this.nFe = false;
    this.nFg = null;
    this.nFh = new int[6];
    this.nFi = 1.0F;
    this.nFj = 1.0F;
    this.Bc = new Rect();
    this.mPaint = new Paint(6);
    this.nFm = 0;
    this.nFn = -1;
    this.nFo = 0L;
    this.nFp = 0L;
    this.nFq = 0L;
    this.nFr = 0L;
    this.nFt = 0L;
    this.nFv = false;
    this.nFw = 0;
    this.nFx = 0;
    this.loX = new ak(Looper.getMainLooper());
    this.nFz = true;
    this.nFA = new d.1(this);
    this.nFB = new d.2(this);
    this.nFC = new d.3(this);
    this.nFD = new d.4(this);
    this.nFE = new d.5(this);
    this.nFF = new d.6(this);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("file path is null.");
      AppMethodBeat.o(62388);
      throw paramString;
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.eez = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.nFf = MMGIFJNI.openByFilePath(paramString, this.nFh);
    init();
    AppMethodBeat.o(62388);
  }
  
  public d(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62391);
    this.mIsRunning = true;
    this.nFe = false;
    this.nFg = null;
    this.nFh = new int[6];
    this.nFi = 1.0F;
    this.nFj = 1.0F;
    this.Bc = new Rect();
    this.mPaint = new Paint(6);
    this.nFm = 0;
    this.nFn = -1;
    this.nFo = 0L;
    this.nFp = 0L;
    this.nFq = 0L;
    this.nFr = 0L;
    this.nFt = 0L;
    this.nFv = false;
    this.nFw = 0;
    this.nFx = 0;
    this.loX = new ak(Looper.getMainLooper());
    this.nFz = true;
    this.nFA = new d.1(this);
    this.nFB = new d.2(this);
    this.nFC = new d.3(this);
    this.nFD = new d.4(this);
    this.nFE = new d.5(this);
    this.nFF = new d.6(this);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new NullPointerException("bytes is null.");
      AppMethodBeat.o(62391);
      throw paramArrayOfByte;
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.eez = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.nFf = MMGIFJNI.openByByteArray(paramArrayOfByte, this.nFh);
    init();
    AppMethodBeat.o(62391);
  }
  
  private void init()
  {
    AppMethodBeat.i(62392);
    ab.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[] { Long.valueOf(this.nFf) });
    this.nFm = this.nFh[2];
    this.nFu = com.tencent.mm.cb.a.ao(ah.getContext(), 2131428398);
    if ((this.nFh[0] > 1024) || (this.nFh[1] > 1024))
    {
      ab.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.nFh[0]), Integer.valueOf(this.nFh[1]) });
      this.nFl = new int[this.nFu * this.nFu];
      this.nFv = true;
      h.qsU.idkeyStat(401L, 2L, 1L, false);
      AppMethodBeat.o(62392);
      return;
    }
    this.nFl = new int[this.nFh[0] * this.nFh[1]];
    AppMethodBeat.o(62392);
  }
  
  private void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(62386);
    this.nFt = (SystemClock.uptimeMillis() + paramLong);
    if (this.loX != null) {
      this.loX.postAtTime(paramRunnable, this.nFt);
    }
    AppMethodBeat.o(62386);
  }
  
  public final int bHL()
  {
    return this.nFh[0];
  }
  
  public final int bHM()
  {
    return this.nFh[1];
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(62397);
    if (this.nFk)
    {
      this.Bc.set(getBounds());
      this.nFi = (this.Bc.width() / this.nFh[0]);
      this.nFj = (this.Bc.height() / this.nFh[1]);
      this.nFk = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.nFr == 0L) {
        this.nFr = System.currentTimeMillis();
      }
      paramCanvas.scale(this.nFi, this.nFj);
      int[] arrayOfInt = this.nFl;
      if (arrayOfInt != null) {
        if (arrayOfInt.length == this.nFh[0] * this.nFh[1]) {
          paramCanvas.drawBitmap(arrayOfInt, 0, this.nFh[0], 0.0F, 0.0F, this.nFh[0], this.nFh[1], true, this.mPaint);
        }
      }
      for (;;)
      {
        this.nFs = (System.currentTimeMillis() - this.nFr);
        if ((this.nFv) || (this.nFh[2] <= 0)) {
          break label345;
        }
        if (this.nFh[4] < 0) {
          ab.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
        }
        if ((this.nFw == 0) || (this.nFx <= this.nFw - 1)) {
          break;
        }
        m(this.nFA, 0L);
        AppMethodBeat.o(62397);
        return;
        paramCanvas.drawRGB(230, 230, 230);
        ab.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(this.nFh[0]), Integer.valueOf(this.nFh[1]) });
        continue;
        ab.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
      }
      if (this.nFz)
      {
        com.tencent.mm.as.a.i(this.nFF, 0L);
        this.nFz = false;
        AppMethodBeat.o(62397);
        return;
        label345:
        ab.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", new Object[] { Integer.valueOf(this.nFh[2]), Integer.valueOf(this.nFh[4]), Boolean.valueOf(this.nFv) });
      }
      AppMethodBeat.o(62397);
      return;
    }
    ab.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
    paramCanvas.drawRect(this.Bc, this.mPaint);
    AppMethodBeat.o(62397);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(62405);
    try
    {
      recycle();
      AppMethodBeat.o(62405);
      return;
    }
    catch (Throwable localThrowable)
    {
      super.finalize();
      AppMethodBeat.o(62405);
    }
  }
  
  public final float getEmojiDensityScale()
  {
    AppMethodBeat.i(62393);
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.cb.a.getDensity(ah.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label54;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      float f = this.mDensity;
      AppMethodBeat.o(62393);
      return f;
      label54:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  public final int getIntrinsicHeight()
  {
    AppMethodBeat.i(62395);
    int i = (int)(this.nFh[1] * getEmojiDensityScale());
    AppMethodBeat.o(62395);
    return i;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(62394);
    int i = (int)(this.nFh[0] * getEmojiDensityScale());
    AppMethodBeat.o(62394);
    return i;
  }
  
  public final int getOpacity()
  {
    return -2;
  }
  
  public final boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    AppMethodBeat.i(62396);
    super.onBoundsChange(paramRect);
    this.nFk = true;
    AppMethodBeat.o(62396);
  }
  
  public final void pause()
  {
    this.mIsRunning = false;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(62404);
    ab.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
    this.nFe = true;
    this.mIsRunning = false;
    long l = this.nFf;
    this.nFf = 0L;
    MMGIFJNI.recycle(l);
    this.nFl = null;
    if (this.nFg != null) {
      try
      {
        this.nFg.close();
        AppMethodBeat.o(62404);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(62404);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(62403);
    this.nFe = false;
    this.mIsRunning = true;
    com.tencent.mm.as.a.i(this.nFD, 0L);
    AppMethodBeat.o(62403);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(62402);
    if (!this.nFe)
    {
      this.mIsRunning = true;
      m(this.nFB, 0L);
    }
    AppMethodBeat.o(62402);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(62398);
    this.mPaint.setAlpha(paramInt);
    AppMethodBeat.o(62398);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(62399);
    this.mPaint.setColorFilter(paramColorFilter);
    AppMethodBeat.o(62399);
  }
  
  public final void start()
  {
    AppMethodBeat.i(62400);
    this.mIsRunning = true;
    com.tencent.mm.as.a.i(this.nFC, 0L);
    AppMethodBeat.o(62400);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    AppMethodBeat.i(62401);
    ab.d("MicroMsg.GIF.MMGIFDrawable", "stop");
    this.mIsRunning = false;
    if (this.eez != 0)
    {
      ab.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformance startPerformance:%x ", new Object[] { Integer.valueOf(this.eez) });
      bool1 = bool2;
      if (!WXHardCoderJNI.hcGifEnable) {
        if (!WXHardCoderJNI.hcGifFrameEnable) {
          break label98;
        }
      }
    }
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      WXHardCoderJNI.stopPerformance(bool1, this.eez);
      this.eez = 0;
      com.tencent.mm.as.a.i(this.nFE, 300L);
      AppMethodBeat.o(62401);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d
 * JD-Core Version:    0.7.0.1
 */