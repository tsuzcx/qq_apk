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
  private final Matrix dY = new Matrix();
  private final PointF ge = new PointF();
  private PorterDuffColorFilter gm;
  private PorterDuff.Mode go = PorterDuff.Mode.SRC_IN;
  private final Matrix[] iX = new Matrix[4];
  private final Matrix[] iY = new Matrix[4];
  private final d[] iZ = new d[4];
  private final Path ja = new Path();
  private final d jb = new d();
  private final Region jc = new Region();
  private final Region jd = new Region();
  private final float[] je = new float[2];
  private final float[] jf = new float[2];
  private e jg = null;
  public boolean jh = false;
  private boolean ji = false;
  public float jj = 1.0F;
  private int jk = 5;
  public Paint.Style jl = Paint.Style.FILL_AND_STROKE;
  public ColorStateList jm = null;
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
    this.jg = parame;
    while (i < 4)
    {
      this.iX[i] = new Matrix();
      this.iY[i] = new Matrix();
      this.iZ[i] = new d();
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
    if (this.jg == null) {
      return;
    }
    int i = 0;
    float f1;
    while (i < 4)
    {
      a(i, paramInt1, paramInt2, this.ge);
      a((i - 1 + 4) % 4, paramInt1, paramInt2, this.ge);
      f1 = this.ge.x;
      float f2 = this.ge.y;
      a((i + 1) % 4, paramInt1, paramInt2, this.ge);
      float f3 = this.ge.x;
      float f4 = this.ge.y;
      a(i, paramInt1, paramInt2, this.ge);
      float f5 = this.ge.x;
      float f6 = this.ge.y;
      Math.atan2(f2 - f6, f1 - f5);
      Math.atan2(f4 - f6, f3 - f5);
      f1 = e((i - 1 + 4) % 4, paramInt1, paramInt2);
      this.iX[i].reset();
      this.iX[i].setTranslate(this.ge.x, this.ge.y);
      this.iX[i].preRotate((float)Math.toDegrees(f1 + 1.570796F));
      this.je[0] = this.iZ[i].jp;
      this.je[1] = this.iZ[i].jq;
      this.iX[i].mapPoints(this.je);
      f1 = e(i, paramInt1, paramInt2);
      this.iY[i].reset();
      this.iY[i].setTranslate(this.je[0], this.je[1]);
      this.iY[i].preRotate((float)Math.toDegrees(f1));
      i += 1;
    }
    paramInt1 = 0;
    if (paramInt1 < 4)
    {
      this.je[0] = this.iZ[paramInt1].jn;
      this.je[1] = this.iZ[paramInt1].jo;
      this.iX[paramInt1].mapPoints(this.je);
      label417:
      b localb;
      if (paramInt1 == 0)
      {
        paramPath.moveTo(this.je[0], this.je[1]);
        this.iZ[paramInt1].a(this.iX[paramInt1], paramPath);
        paramInt2 = (paramInt1 + 1) % 4;
        this.je[0] = this.iZ[paramInt1].jp;
        this.je[1] = this.iZ[paramInt1].jq;
        this.iX[paramInt1].mapPoints(this.je);
        this.jf[0] = this.iZ[paramInt2].jn;
        this.jf[1] = this.iZ[paramInt2].jo;
        this.iX[paramInt2].mapPoints(this.jf);
        f1 = (float)Math.hypot(this.je[0] - this.jf[0], this.je[1] - this.jf[1]);
        this.jb.bm();
        switch (paramInt1)
        {
        default: 
          localb = this.jg.jA;
        }
      }
      for (;;)
      {
        localb.a(f1, this.jj, this.jb);
        this.jb.a(this.iY[paramInt1], paramPath);
        paramInt1 += 1;
        break;
        paramPath.lineTo(this.je[0], this.je[1]);
        break label417;
        localb = this.jg.jB;
        continue;
        localb = this.jg.jC;
        continue;
        localb = this.jg.jD;
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
    this.dY.reset();
    this.dY.setScale(this.scale, this.scale, paramInt1 / 2, paramInt2 / 2);
    paramPath.transform(this.dY);
  }
  
  private void bl()
  {
    if ((this.jm == null) || (this.go == null)) {
      this.gm = null;
    }
    int i;
    do
    {
      return;
      i = this.jm.getColorForState(getState(), 0);
      this.gm = new PorterDuffColorFilter(i, this.go);
    } while (!this.ji);
    this.shadowColor = i;
  }
  
  private float e(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, this.ge);
    float f1 = this.ge.x;
    float f2 = this.ge.y;
    a((paramInt1 + 1) % 4, paramInt2, paramInt3, this.ge);
    float f3 = this.ge.x;
    return (float)Math.atan2(this.ge.y - f2, f3 - f1);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    this.paint.setColorFilter(this.gm);
    int i = this.paint.getAlpha();
    Paint localPaint = this.paint;
    int j = this.alpha;
    localPaint.setAlpha((j + (j >>> 7)) * i >>> 8);
    this.paint.setStrokeWidth(this.strokeWidth);
    this.paint.setStyle(this.jl);
    if ((this.jk > 0) && (this.jh)) {
      this.paint.setShadowLayer(this.shadowRadius, 0.0F, this.jk, this.shadowColor);
    }
    if (this.jg != null)
    {
      b(paramCanvas.getWidth(), paramCanvas.getHeight(), this.ja);
      paramCanvas.drawPath(this.ja, this.paint);
    }
    for (;;)
    {
      this.paint.setAlpha(i);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), this.paint);
    }
  }
  
  public final void f(float paramFloat)
  {
    this.jj = paramFloat;
    invalidateSelf();
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final Region getTransparentRegion()
  {
    Rect localRect = getBounds();
    this.jc.set(localRect);
    b(localRect.width(), localRect.height(), this.ja);
    this.jd.setPath(this.ja, this.jc);
    this.jc.op(this.jd, Region.Op.DIFFERENCE);
    return this.jc;
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
    this.jm = paramColorStateList;
    bl();
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    this.go = paramMode;
    bl();
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.f.c
 * JD-Core Version:    0.7.0.1
 */