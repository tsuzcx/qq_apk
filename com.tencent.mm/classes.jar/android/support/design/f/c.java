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
  private final Matrix gR = new Matrix();
  private final PointF iY = new PointF();
  private PorterDuffColorFilter jg;
  private PorterDuff.Mode ji = PorterDuff.Mode.SRC_IN;
  private final Matrix[] lM = new Matrix[4];
  private final Matrix[] lN = new Matrix[4];
  private final d[] lO = new d[4];
  private final Path lP = new Path();
  private final d lQ = new d();
  private final Region lR = new Region();
  private final Region lS = new Region();
  private final float[] lT = new float[2];
  private final float[] lU = new float[2];
  private e lV = null;
  public boolean lW = false;
  private boolean lX = false;
  public float lY = 1.0F;
  private int lZ = 5;
  public Paint.Style ma = Paint.Style.FILL_AND_STROKE;
  public ColorStateList mb = null;
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
    this.lV = parame;
    while (i < 4)
    {
      this.lM[i] = new Matrix();
      this.lN[i] = new Matrix();
      this.lO[i] = new d();
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
    if (this.lV == null) {
      return;
    }
    int i = 0;
    float f1;
    while (i < 4)
    {
      a(i, paramInt1, paramInt2, this.iY);
      a((i - 1 + 4) % 4, paramInt1, paramInt2, this.iY);
      f1 = this.iY.x;
      float f2 = this.iY.y;
      a((i + 1) % 4, paramInt1, paramInt2, this.iY);
      float f3 = this.iY.x;
      float f4 = this.iY.y;
      a(i, paramInt1, paramInt2, this.iY);
      float f5 = this.iY.x;
      float f6 = this.iY.y;
      Math.atan2(f2 - f6, f1 - f5);
      Math.atan2(f4 - f6, f3 - f5);
      f1 = e((i - 1 + 4) % 4, paramInt1, paramInt2);
      this.lM[i].reset();
      this.lM[i].setTranslate(this.iY.x, this.iY.y);
      this.lM[i].preRotate((float)Math.toDegrees(f1 + 1.570796F));
      this.lT[0] = this.lO[i].me;
      this.lT[1] = this.lO[i].mf;
      this.lM[i].mapPoints(this.lT);
      f1 = e(i, paramInt1, paramInt2);
      this.lN[i].reset();
      this.lN[i].setTranslate(this.lT[0], this.lT[1]);
      this.lN[i].preRotate((float)Math.toDegrees(f1));
      i += 1;
    }
    paramInt1 = 0;
    if (paramInt1 < 4)
    {
      this.lT[0] = this.lO[paramInt1].mc;
      this.lT[1] = this.lO[paramInt1].md;
      this.lM[paramInt1].mapPoints(this.lT);
      label417:
      b localb;
      if (paramInt1 == 0)
      {
        paramPath.moveTo(this.lT[0], this.lT[1]);
        this.lO[paramInt1].a(this.lM[paramInt1], paramPath);
        paramInt2 = (paramInt1 + 1) % 4;
        this.lT[0] = this.lO[paramInt1].me;
        this.lT[1] = this.lO[paramInt1].mf;
        this.lM[paramInt1].mapPoints(this.lT);
        this.lU[0] = this.lO[paramInt2].mc;
        this.lU[1] = this.lO[paramInt2].md;
        this.lM[paramInt2].mapPoints(this.lU);
        f1 = (float)Math.hypot(this.lT[0] - this.lU[0], this.lT[1] - this.lU[1]);
        this.lQ.bI();
        switch (paramInt1)
        {
        default: 
          localb = this.lV.mp;
        }
      }
      for (;;)
      {
        localb.a(f1, this.lY, this.lQ);
        this.lQ.a(this.lN[paramInt1], paramPath);
        paramInt1 += 1;
        break;
        paramPath.lineTo(this.lT[0], this.lT[1]);
        break label417;
        localb = this.lV.mq;
        continue;
        localb = this.lV.mr;
        continue;
        localb = this.lV.ms;
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
    this.gR.reset();
    this.gR.setScale(this.scale, this.scale, paramInt1 / 2, paramInt2 / 2);
    paramPath.transform(this.gR);
  }
  
  private void bH()
  {
    if ((this.mb == null) || (this.ji == null)) {
      this.jg = null;
    }
    int i;
    do
    {
      return;
      i = this.mb.getColorForState(getState(), 0);
      this.jg = new PorterDuffColorFilter(i, this.ji);
    } while (!this.lX);
    this.shadowColor = i;
  }
  
  private float e(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, this.iY);
    float f1 = this.iY.x;
    float f2 = this.iY.y;
    a((paramInt1 + 1) % 4, paramInt2, paramInt3, this.iY);
    float f3 = this.iY.x;
    return (float)Math.atan2(this.iY.y - f2, f3 - f1);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    this.paint.setColorFilter(this.jg);
    int i = this.paint.getAlpha();
    Paint localPaint = this.paint;
    int j = this.alpha;
    localPaint.setAlpha((j + (j >>> 7)) * i >>> 8);
    this.paint.setStrokeWidth(this.strokeWidth);
    this.paint.setStyle(this.ma);
    if ((this.lZ > 0) && (this.lW)) {
      this.paint.setShadowLayer(this.shadowRadius, 0.0F, this.lZ, this.shadowColor);
    }
    if (this.lV != null)
    {
      b(paramCanvas.getWidth(), paramCanvas.getHeight(), this.lP);
      paramCanvas.drawPath(this.lP, this.paint);
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
    this.lR.set(localRect);
    b(localRect.width(), localRect.height(), this.lP);
    this.lS.setPath(this.lP, this.lR);
    this.lR.op(this.lS, Region.Op.DIFFERENCE);
    return this.lR;
  }
  
  public final void i(float paramFloat)
  {
    this.lY = paramFloat;
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
    this.mb = paramColorStateList;
    bH();
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    this.ji = paramMode;
    bH();
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.f.c
 * JD-Core Version:    0.7.0.1
 */