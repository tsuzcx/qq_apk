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
  private final Matrix gT = new Matrix();
  private final PointF ja = new PointF();
  private PorterDuffColorFilter ji;
  private PorterDuff.Mode jk = PorterDuff.Mode.SRC_IN;
  private final Matrix[] lO = new Matrix[4];
  private final Matrix[] lP = new Matrix[4];
  private final d[] lQ = new d[4];
  private final Path lR = new Path();
  private final d lS = new d();
  private final Region lT = new Region();
  private final Region lU = new Region();
  private final float[] lV = new float[2];
  private final float[] lW = new float[2];
  private e lX = null;
  public boolean lY = false;
  private boolean lZ = false;
  public float ma = 1.0F;
  private int mb = 5;
  public Paint.Style mc = Paint.Style.FILL_AND_STROKE;
  public ColorStateList md = null;
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
    this.lX = parame;
    while (i < 4)
    {
      this.lO[i] = new Matrix();
      this.lP[i] = new Matrix();
      this.lQ[i] = new d();
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
    if (this.lX == null) {
      return;
    }
    int i = 0;
    float f1;
    while (i < 4)
    {
      a(i, paramInt1, paramInt2, this.ja);
      a((i - 1 + 4) % 4, paramInt1, paramInt2, this.ja);
      f1 = this.ja.x;
      float f2 = this.ja.y;
      a((i + 1) % 4, paramInt1, paramInt2, this.ja);
      float f3 = this.ja.x;
      float f4 = this.ja.y;
      a(i, paramInt1, paramInt2, this.ja);
      float f5 = this.ja.x;
      float f6 = this.ja.y;
      Math.atan2(f2 - f6, f1 - f5);
      Math.atan2(f4 - f6, f3 - f5);
      f1 = e((i - 1 + 4) % 4, paramInt1, paramInt2);
      this.lO[i].reset();
      this.lO[i].setTranslate(this.ja.x, this.ja.y);
      this.lO[i].preRotate((float)Math.toDegrees(f1 + 1.570796F));
      this.lV[0] = this.lQ[i].mg;
      this.lV[1] = this.lQ[i].mh;
      this.lO[i].mapPoints(this.lV);
      f1 = e(i, paramInt1, paramInt2);
      this.lP[i].reset();
      this.lP[i].setTranslate(this.lV[0], this.lV[1]);
      this.lP[i].preRotate((float)Math.toDegrees(f1));
      i += 1;
    }
    paramInt1 = 0;
    if (paramInt1 < 4)
    {
      this.lV[0] = this.lQ[paramInt1].me;
      this.lV[1] = this.lQ[paramInt1].mf;
      this.lO[paramInt1].mapPoints(this.lV);
      label417:
      b localb;
      if (paramInt1 == 0)
      {
        paramPath.moveTo(this.lV[0], this.lV[1]);
        this.lQ[paramInt1].a(this.lO[paramInt1], paramPath);
        paramInt2 = (paramInt1 + 1) % 4;
        this.lV[0] = this.lQ[paramInt1].mg;
        this.lV[1] = this.lQ[paramInt1].mh;
        this.lO[paramInt1].mapPoints(this.lV);
        this.lW[0] = this.lQ[paramInt2].me;
        this.lW[1] = this.lQ[paramInt2].mf;
        this.lO[paramInt2].mapPoints(this.lW);
        f1 = (float)Math.hypot(this.lV[0] - this.lW[0], this.lV[1] - this.lW[1]);
        this.lS.bK();
        switch (paramInt1)
        {
        default: 
          localb = this.lX.mr;
        }
      }
      for (;;)
      {
        localb.a(f1, this.ma, this.lS);
        this.lS.a(this.lP[paramInt1], paramPath);
        paramInt1 += 1;
        break;
        paramPath.lineTo(this.lV[0], this.lV[1]);
        break label417;
        localb = this.lX.ms;
        continue;
        localb = this.lX.mt;
        continue;
        localb = this.lX.mu;
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
    this.gT.reset();
    this.gT.setScale(this.scale, this.scale, paramInt1 / 2, paramInt2 / 2);
    paramPath.transform(this.gT);
  }
  
  private void bJ()
  {
    if ((this.md == null) || (this.jk == null)) {
      this.ji = null;
    }
    int i;
    do
    {
      return;
      i = this.md.getColorForState(getState(), 0);
      this.ji = new PorterDuffColorFilter(i, this.jk);
    } while (!this.lZ);
    this.shadowColor = i;
  }
  
  private float e(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, this.ja);
    float f1 = this.ja.x;
    float f2 = this.ja.y;
    a((paramInt1 + 1) % 4, paramInt2, paramInt3, this.ja);
    float f3 = this.ja.x;
    return (float)Math.atan2(this.ja.y - f2, f3 - f1);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    this.paint.setColorFilter(this.ji);
    int i = this.paint.getAlpha();
    Paint localPaint = this.paint;
    int j = this.alpha;
    localPaint.setAlpha((j + (j >>> 7)) * i >>> 8);
    this.paint.setStrokeWidth(this.strokeWidth);
    this.paint.setStyle(this.mc);
    if ((this.mb > 0) && (this.lY)) {
      this.paint.setShadowLayer(this.shadowRadius, 0.0F, this.mb, this.shadowColor);
    }
    if (this.lX != null)
    {
      b(paramCanvas.getWidth(), paramCanvas.getHeight(), this.lR);
      paramCanvas.drawPath(this.lR, this.paint);
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
    this.lT.set(localRect);
    b(localRect.width(), localRect.height(), this.lR);
    this.lU.setPath(this.lR, this.lT);
    this.lT.op(this.lU, Region.Op.DIFFERENCE);
    return this.lT;
  }
  
  public final void i(float paramFloat)
  {
    this.ma = paramFloat;
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
    this.md = paramColorStateList;
    bJ();
    invalidateSelf();
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    this.jk = paramMode;
    bJ();
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.f.c
 * JD-Core Version:    0.7.0.1
 */