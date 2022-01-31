package com.tencent.mm.plugin.gif;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.l.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;

public final class d
  extends b
{
  private final Rect Aq = new Rect();
  private int dmY;
  private ah jge = new ah();
  private boolean lhI = false;
  private volatile long lhJ;
  private AssetFileDescriptor lhK = null;
  private final int[] lhL = new int[6];
  private float lhM = 1.0F;
  private float lhN = 1.0F;
  private boolean lhO;
  private int[] lhP;
  private int lhQ = 0;
  private int lhR = -1;
  private long lhS = 0L;
  private long lhT = 0L;
  private long lhU = 0L;
  private long lhV = 0L;
  private long lhW;
  private long lhX = 0L;
  private int lhY;
  private boolean lhZ = false;
  int lia = 0;
  private int lic = 0;
  k lid;
  private boolean lie = true;
  private final Runnable lif = new d.1(this);
  private final Runnable lig = new d.2(this);
  private final Runnable lih = new d.3(this);
  private final Runnable lii = new d.4(this);
  private final Runnable lij = new d.5(this);
  private final Runnable lik = new d.6(this);
  private float mDensity;
  private boolean mIsRunning = true;
  private final Paint mPaint = new Paint(6);
  
  private d(AssetFileDescriptor paramAssetFileDescriptor)
  {
    if (paramAssetFileDescriptor == null) {
      throw new NullPointerException("assert file Descriptor is null.");
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.dmY = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.lhK = paramAssetFileDescriptor;
    this.lhJ = MMGIFJNI.openByFileDescroptor(this.lhK.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), this.lhL);
    init();
  }
  
  public d(Resources paramResources, int paramInt)
  {
    this(paramResources.openRawResourceFd(paramInt));
  }
  
  public d(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      throw new NullPointerException("input stream is null.");
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.dmY = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.lhJ = MMGIFJNI.openByInputStrem(paramInputStream, this.lhL);
    init();
  }
  
  public d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("file path is null.");
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.dmY = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.lhJ = MMGIFJNI.openByFilePath(paramString, this.lhL);
    init();
  }
  
  public d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("bytes is null.");
    }
    boolean bool = WXHardCoderJNI.hcGifEnable;
    int j = WXHardCoderJNI.hcGifDelay;
    int k = WXHardCoderJNI.hcGifCPU;
    int m = WXHardCoderJNI.hcGifIO;
    if (WXHardCoderJNI.hcGifThr) {
      i = Process.myTid();
    }
    this.dmY = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcGifTimeout, 602, WXHardCoderJNI.hcGifAction, "MicroMsg.GIF.MMGIFDrawable");
    this.lhJ = MMGIFJNI.openByByteArray(paramArrayOfByte, this.lhL);
    init();
  }
  
  private void i(Runnable paramRunnable, long paramLong)
  {
    this.lhX = (SystemClock.uptimeMillis() + paramLong);
    if (this.jge != null) {
      this.jge.postAtTime(paramRunnable, this.lhX);
    }
  }
  
  private void init()
  {
    y.i("MicroMsg.GIF.MMGIFDrawable", "gif info pointer:%d", new Object[] { Long.valueOf(this.lhJ) });
    this.lhQ = this.lhL[2];
    this.lhY = com.tencent.mm.cb.a.aa(ae.getContext(), a.c.emoji_view_image_size);
    if ((this.lhL[0] > 1024) || (this.lhL[1] > 1024))
    {
      y.w("MicroMsg.GIF.MMGIFDrawable", "emoji width or height over size. Width:%d Height:%d", new Object[] { Integer.valueOf(this.lhL[0]), Integer.valueOf(this.lhL[1]) });
      this.lhP = new int[this.lhY * this.lhY];
      this.lhZ = true;
      h.nFQ.a(401L, 2L, 1L, false);
      return;
    }
    this.lhP = new int[this.lhL[0] * this.lhL[1]];
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.lhO)
    {
      this.Aq.set(getBounds());
      this.lhM = (this.Aq.width() / this.lhL[0]);
      this.lhN = (this.Aq.height() / this.lhL[1]);
      this.lhO = false;
    }
    if (this.mPaint.getShader() == null)
    {
      if (this.lhV == 0L) {
        this.lhV = System.currentTimeMillis();
      }
      paramCanvas.scale(this.lhM, this.lhN);
      int[] arrayOfInt = this.lhP;
      if (arrayOfInt != null) {
        if (arrayOfInt.length == this.lhL[0] * this.lhL[1])
        {
          paramCanvas.drawBitmap(arrayOfInt, 0, this.lhL[0], 0.0F, 0.0F, this.lhL[0], this.lhL[1], true, this.mPaint);
          this.lhW = (System.currentTimeMillis() - this.lhV);
          if ((this.lhZ) || (this.lhL[2] <= 0)) {
            break label327;
          }
          if (this.lhL[4] < 0) {
            y.i("MicroMsg.GIF.MMGIFDrawable", "current index error. start first frame");
          }
          if ((this.lia == 0) || (this.lic <= this.lia - 1)) {
            break label305;
          }
          i(this.lif, 0L);
        }
      }
      label305:
      while (!this.lie)
      {
        return;
        paramCanvas.drawRGB(230, 230, 230);
        y.w("MicroMsg.GIF.MMGIFDrawable", "colors is not equal width*height. length:%d width:%d height:%d", new Object[] { Integer.valueOf(arrayOfInt.length), Integer.valueOf(this.lhL[0]), Integer.valueOf(this.lhL[1]) });
        break;
        y.e("MicroMsg.GIF.MMGIFDrawable", "colors is null.");
        break;
      }
      com.tencent.mm.ar.a.f(this.lik, 0L);
      this.lie = false;
      return;
      label327:
      y.e("MicroMsg.GIF.MMGIFDrawable", "framecount:%d errorcode:%d no post and oversize:%b", new Object[] { Integer.valueOf(this.lhL[2]), Integer.valueOf(this.lhL[4]), Boolean.valueOf(this.lhZ) });
      return;
    }
    y.i("MicroMsg.GIF.MMGIFDrawable", "colors drawRect ");
    paramCanvas.drawRect(this.Aq, this.mPaint);
  }
  
  protected final void finalize()
  {
    try
    {
      recycle();
      return;
    }
    catch (Throwable localThrowable)
    {
      super.finalize();
    }
  }
  
  public final float getEmojiDensityScale()
  {
    if (this.mDensity == 0.0F)
    {
      this.mDensity = (com.tencent.mm.cb.a.getDensity(ae.getContext()) / 2.0F);
      if (this.mDensity >= 1.0F) {
        break label40;
      }
      this.mDensity = 1.0F;
    }
    for (;;)
    {
      return this.mDensity;
      label40:
      if (this.mDensity > 2.0F) {
        this.mDensity = 2.0F;
      }
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return (int)(this.lhL[1] * getEmojiDensityScale());
  }
  
  public final int getIntrinsicWidth()
  {
    return (int)(this.lhL[0] * getEmojiDensityScale());
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
    super.onBoundsChange(paramRect);
    this.lhO = true;
  }
  
  public final void pause()
  {
    this.mIsRunning = false;
  }
  
  public final void recycle()
  {
    y.d("MicroMsg.GIF.MMGIFDrawable", "recycle");
    this.lhI = true;
    this.mIsRunning = false;
    long l = this.lhJ;
    this.lhJ = 0L;
    MMGIFJNI.recycle(l);
    this.lhP = null;
    if (this.lhK != null) {}
    try
    {
      this.lhK.close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void reset()
  {
    this.lhI = false;
    this.mIsRunning = true;
    com.tencent.mm.ar.a.f(this.lii, 0L);
  }
  
  public final void resume()
  {
    if (!this.lhI)
    {
      this.mIsRunning = true;
      i(this.lig, 0L);
    }
  }
  
  public final void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public final void start()
  {
    this.mIsRunning = true;
    com.tencent.mm.ar.a.f(this.lih, 0L);
  }
  
  public final void stop()
  {
    boolean bool2 = true;
    y.d("MicroMsg.GIF.MMGIFDrawable", "stop");
    this.mIsRunning = false;
    if (this.dmY != 0)
    {
      y.i("MicroMsg.GIF.MMGIFDrawable", "summerhardcoder stopPerformace startPerformance:%x ", new Object[] { Integer.valueOf(this.dmY) });
      bool1 = bool2;
      if (!WXHardCoderJNI.hcGifEnable) {
        if (!WXHardCoderJNI.hcGifFrameEnable) {
          break label86;
        }
      }
    }
    label86:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      WXHardCoderJNI.stopPerformace(bool1, this.dmY);
      this.dmY = 0;
      com.tencent.mm.ar.a.f(this.lij, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d
 * JD-Core Version:    0.7.0.1
 */