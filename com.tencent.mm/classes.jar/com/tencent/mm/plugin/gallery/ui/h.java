package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.plugin.gallery.model.a;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends Drawable
{
  private static final Paint dPt = new Paint();
  private static Rect rect = null;
  protected int bLN = 0;
  protected ImageView jjn;
  protected String kGp = "";
  protected long kGq = 0L;
  protected boolean kKI = false;
  public h.a kKJ;
  long kKK;
  boolean kKL = false;
  private Rect kKM = new Rect();
  private Bitmap mBitmap;
  protected String mFilePath = "";
  private int mWidth;
  
  static
  {
    dPt.setAntiAlias(true);
    dPt.setFilterBitmap(true);
  }
  
  private h(ImageView paramImageView)
  {
    this.jjn = paramImageView;
    this.mFilePath = "";
  }
  
  public static void a(ImageView paramImageView, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    a(paramImageView, paramInt, paramString1, paramString2, paramLong, -1, null);
  }
  
  public static void a(ImageView paramImageView, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, h.a parama)
  {
    Object localObject = paramImageView.getDrawable();
    if ((localObject != null) && ((localObject instanceof h)))
    {
      localObject = (h)localObject;
      if (paramInt2 > 0) {
        ((h)localObject).mWidth = paramInt2;
      }
      ((h)localObject).kKJ = parama;
      if (!bk.bl(paramString1)) {
        break label90;
      }
    }
    label90:
    for (parama = paramString2;; parama = paramString1)
    {
      if (!bk.bl(parama)) {
        break label96;
      }
      y.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
      paramImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = new h(paramImageView);
      break;
    }
    label96:
    label109:
    boolean bool1;
    if (!bk.bl(paramString1))
    {
      ((h)localObject).kKI = true;
      c.aXa().a(new h.c((h)localObject));
      if ((((h)localObject).mFilePath.equals(parama)) && (((h)localObject).mBitmap != null) && (!((h)localObject).mBitmap.isRecycled())) {
        break label385;
      }
      ((h)localObject).mFilePath = parama;
      ((h)localObject).kGp = paramString2;
      ((h)localObject).kGq = paramLong;
      ((h)localObject).bLN = paramInt1;
      ((h)localObject).mBitmap = c.aXa().En(((h)localObject).mFilePath);
      if (((h)localObject).mBitmap != null) {
        break label364;
      }
      bool1 = true;
      label209:
      if (((h)localObject).mBitmap == null) {
        break label370;
      }
      bool2 = ((h)localObject).mBitmap.isRecycled();
      label227:
      y.d("MicroMsg.ThumbDrawable", "setMediaFeature ok filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]", new Object[] { parama, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((((h)localObject).mBitmap != null) && (!((h)localObject).mBitmap.isRecycled())) {
        break label376;
      }
      ((h)localObject).kKL = true;
      ((h)localObject).kKK = 0L;
      ((h)localObject).mBitmap = c.aXa().b(parama, paramInt1, paramString2, paramLong);
    }
    for (;;)
    {
      if ((((h)localObject).kKJ != null) && (((h)localObject).mBitmap != null) && (!((h)localObject).mBitmap.isRecycled())) {
        ((h)localObject).kKJ.aXK();
      }
      ((h)localObject).jjn.invalidate();
      break;
      ((h)localObject).kKI = false;
      break label109;
      label364:
      bool1 = false;
      break label209;
      label370:
      bool2 = false;
      break label227;
      label376:
      ((h)localObject).kKL = false;
    }
    label385:
    if (((h)localObject).mBitmap == null)
    {
      bool1 = true;
      label396:
      if (((h)localObject).mBitmap == null) {
        break label455;
      }
    }
    label455:
    for (boolean bool2 = ((h)localObject).mBitmap.isRecycled();; bool2 = false)
    {
      y.d("MicroMsg.ThumbDrawable", "setMediaFeature fuck filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]", new Object[] { parama, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      break;
      bool1 = false;
      break label396;
    }
  }
  
  private boolean d(Canvas paramCanvas, int paramInt)
  {
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled()))
    {
      y.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap is null: " + this.mFilePath);
      if ((this.mBitmap != null) && (this.mBitmap.isRecycled()))
      {
        this.kKL = true;
        this.kKK = 0L;
        this.mBitmap = c.aXa().b(this.mFilePath, this.bLN, this.kGp, this.kGq);
        if ((this.kKJ != null) && (this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
          this.kKJ.aXK();
        }
      }
      return false;
    }
    y.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap ok:" + this.mFilePath);
    Bitmap localBitmap = this.mBitmap;
    Rect localRect = this.kKM;
    int i;
    if (localBitmap.getWidth() > localBitmap.getHeight())
    {
      localRect.top = 0;
      localRect.bottom = localBitmap.getHeight();
      localRect.left = (localBitmap.getWidth() - localBitmap.getHeight() >> 1);
      i = localRect.left;
      localRect.right = (localBitmap.getHeight() + i);
    }
    for (;;)
    {
      dPt.setAlpha(paramInt);
      paramCanvas.drawBitmap(this.mBitmap, this.kKM, getBounds(), dPt);
      y.v("MicroMsg.ThumbDrawable", "Bounts:%s", new Object[] { getBounds().toString() });
      return true;
      localRect.left = 0;
      localRect.right = localBitmap.getWidth();
      localRect.top = (localBitmap.getHeight() - localBitmap.getWidth() >> 1);
      i = localRect.top;
      localRect.bottom = (localBitmap.getWidth() + i);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    float f = (float)(SystemClock.uptimeMillis() - this.kKK) / 200.0F;
    if (this.kKK == 0L)
    {
      y.d("MicroMsg.ThumbDrawable", "[duanyi test]: draw:[%s] startTimeMillis is 0", new Object[] { this.mFilePath });
      f = 0.0F;
    }
    y.d("MicroMsg.ThumbDrawable", "[duanyi test]: hash:[%s] draw:[%s] animating:[%s] normalized:[%s] alpha[%s]", new Object[] { Integer.valueOf(hashCode()), this.mFilePath, Boolean.valueOf(this.kKL), Float.valueOf(f), Integer.valueOf((int)(255.0F * f)) });
    if (!this.kKL)
    {
      d(paramCanvas, 255);
      setAlpha(255);
    }
    do
    {
      return;
      if (f >= 1.0F)
      {
        this.kKL = false;
        d(paramCanvas, 255);
        return;
      }
    } while (!d(paramCanvas, (int)(f * 255.0F)));
    invalidateSelf();
  }
  
  public final int getIntrinsicHeight()
  {
    return 400;
  }
  
  public final int getIntrinsicWidth()
  {
    return 400;
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.v("MicroMsg.ThumbDrawable", "setBountsLTRB:%d %d - %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void setBounds(Rect paramRect)
  {
    y.v("MicroMsg.ThumbDrawable", "setBountsRECT:%s", new Object[] { paramRect.toString() });
    super.setBounds(paramRect);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.h
 * JD-Core Version:    0.7.0.1
 */