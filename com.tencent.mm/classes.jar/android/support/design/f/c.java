package android.support.design.f;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;

public final class c
  extends Drawable
  implements android.support.v4.graphics.drawable.e
{
  private int alpha = 255;
  private final Matrix eY = new Matrix();
  private final PointF hd = new PointF();
  private PorterDuffColorFilter hl;
  private PorterDuff.Mode hn = PorterDuff.Mode.SRC_IN;
  private final Matrix[] jW = new Matrix[4];
  private final Matrix[] jX = new Matrix[4];
  private final d[] jY = new d[4];
  private final Path jZ = new Path();
  private final d ka = new d();
  private final Region kb = new Region();
  private final Region kc = new Region();
  private final float[] kd = new float[2];
  private final float[] ke = new float[2];
  private e kf = null;
  public boolean kg = false;
  private boolean kh = false;
  public float ki = 1.0F;
  private int kj = 5;
  public Paint.Style kk = Paint.Style.FILL_AND_STROKE;
  public ColorStateList kl = null;
  private final Paint paint = new Paint();
  private float scale = 1.0F;
  private int shadowColor = -16777216;
  private int shadowRadius = 10;
  private float strokeWidth = 0.0F;
  
  public c()
  {
    this(null);
  }
  
  public c(e parame)
  {
    this.kf = parame;
    while (i < 4)
    {
      this.jW[i] = new Matrix();
      this.jX[i] = new Matrix();
      this.jY[i] = new d();
      i += 1;
    }
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, PointF paramPointF)
  {
    switch (paramInt1)
    {
    default: 
      paramPointF.set(0.0F, 0.0F);
      return;
    case 1: 
      paramPointF.set(paramInt2, 0.0F);
      return;
    case 2: 
      paramPointF.set(paramInt2, paramInt3);
      return;
    }
    paramPointF.set(0.0F, paramInt3);
  }
  
  private void a(int paramInt1, int paramInt2, Path paramPath)
  {
    paramPath.rewind();
    if (this.kf == null) {
      return;
    }
    int i = 0;
    float f1;
    while (i < 4)
    {
      a(i, paramInt1, paramInt2, this.hd);
      a((i - 1 + 4) % 4, paramInt1, paramInt2, this.hd);
      f1 = this.hd.x;
      float f2 = this.hd.y;
      a((i + 1) % 4, paramInt1, paramInt2, this.hd);
      float f3 = this.hd.x;
      float f4 = this.hd.y;
      a(i, paramInt1, paramInt2, this.hd);
      float f5 = this.hd.x;
      float f6 = this.hd.y;
      Math.atan2(f2 - f6, f1 - f5);
      Math.atan2(f4 - f6, f3 - f5);
      f1 = e((i - 1 + 4) % 4, paramInt1, paramInt2);
      this.jW[i].reset();
      this.jW[i].setTranslate(this.hd.x, this.hd.y);
      this.jW[i].preRotate((float)Math.toDegrees(f1 + 1.570796F));
      this.kd[0] = this.jY[i].ko;
      this.kd[1] = this.jY[i].kp;
      this.jW[i].mapPoints(this.kd);
      f1 = e(i, paramInt1, paramInt2);
      this.jX[i].reset();
      this.jX[i].setTranslate(this.kd[0], this.kd[1]);
      this.jX[i].preRotate((float)Math.toDegrees(f1));
      i += 1;
    }
    paramInt1 = 0;
    if (paramInt1 < 4)
    {
      this.kd[0] = this.jY[paramInt1].km;
      this.kd[1] = this.jY[paramInt1].kn;
      this.jW[paramInt1].mapPoints(this.kd);
      label417:
      b localb;
      if (paramInt1 == 0)
      {
        paramPath.moveTo(this.kd[0], this.kd[1]);
        this.jY[paramInt1].a(this.jW[paramInt1], paramPath);
        paramInt2 = (paramInt1 + 1) % 4;
        this.kd[0] = this.jY[paramInt1].ko;
        this.kd[1] = this.jY[paramInt1].kp;
        this.jW[paramInt1].mapPoints(this.kd);
        this.ke[0] = this.jY[paramInt2].km;
        this.ke[1] = this.jY[paramInt2].kn;
        this.jW[paramInt2].mapPoints(this.ke);
        f1 = (float)Math.hypot(this.kd[0] - this.ke[0], this.kd[1] - this.ke[1]);
        this.ka.bt();
        switch (paramInt1)
        {
        default: 
          localb = this.kf.kz;
        }
      }
      for (;;)
      {
        localb.a(f1, this.ki, this.ka);
        this.ka.a(this.jX[paramInt1], paramPath);
        paramInt1 += 1;
        break;
        paramPath.lineTo(this.kd[0], this.kd[1]);
        break label417;
        localb = this.kf.kA;
        continue;
        localb = this.kf.kB;
        continue;
        localb = this.kf.kC;
      }
    }
    paramPath.close();
  }
  
  private void b(int paramInt1, int paramInt2, Path paramPath)
  {
    a(paramInt1, paramInt2, paramPath);
    if (this.scale == 1.0F) {
      return;
    }
    this.eY.reset();
    this.eY.setScale(this.scale, this.scale, paramInt1 / 2, paramInt2 / 2);
    paramPath.transform(this.eY);
  }
  
  private void bs()
  {
    if ((this.kl == null) || (this.hn == null)) {
      this.hl = null;
    }
    int i;
    do
    {
      return;
      i = this.kl.getColorForState(getState(), 0);
      this.hl = new PorterDuffColorFilter(i, this.hn);
    } while (!this.kh);
    this.shadowColor = i;
  }
  
  private float e(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, this.hd);
    float f1 = this.hd.x;
    float f2 = this.hd.y;
    a((paramInt1 + 1) % 4, paramInt2, paramInt3, this.hd);
    float f3 = this.hd.x;
    return (float)Math.atan2(this.hd.y - f2, f3 - f1);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    this.paint.setColorFilter(this.hl);
    int i = this.paint.getAlpha();
    Paint localPaint = this.paint;
    int j = this.alpha;
    localPaint.setAlpha((j + (j >>> 7)) * i >>> 8);
    this.paint.setStrokeWidth(this.strokeWidth);
    this.paint.setStyle(this.kk);
    if ((this.kj > 0) && (this.kg)) {
      this.paint.setShadowLayer(this.shadowRadius, 0.0F, this.kj, this.shadowColor);
    }
    if (this.kf != null)
    {
      b(paramCanvas.getWidth(), paramCanvas.getHeight(), this.jZ);
      paramCanvas.drawPath(this.jZ, this.paint);
    }
    for (;;)
    {
      this.paint.setAlpha(i);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), this.paint);
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final Region getTransparentRegion()
  {
    Rect localRect = getBounds();
    this.kb.set(localRect);
    b(localRect.width(), localRect.height(), this.jZ);
    this.kc.setPath(this.jZ, this.kb);
    this.kb.op(this.kc, Region.Op.DIFFERENCE);
    return this.kb;
  }
  
  public final void j(float paramFloat)
  {
    this.ki = paramFloat;
    invalidateSelf();
  }
  
  public final void setAlpha(int paramInt)
  {
    this.alpha = paramInt;
    invalidateSelf();
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public final void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    this.kl = paramColorStateList;
    bs();
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    this.hn = paramMode;
    bs();
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.f.c
 * JD-Core Version:    0.7.0.1
 */