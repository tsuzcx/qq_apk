package com.google.android.material.h;

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
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends Drawable
  implements androidx.core.graphics.drawable.e
{
  private final Path aBZ;
  private final Matrix aHZ;
  private int alpha;
  private final Matrix[] bDT;
  private final Matrix[] bDU;
  private final d[] bDV;
  private final d bDW;
  private final Region bDX;
  private final Region bDY;
  private final float[] bDZ;
  private final float[] bEa;
  private e bEb;
  public boolean bEc;
  private boolean bEd;
  public float bEe;
  private int bEf;
  public Paint.Style bEg;
  public ColorStateList bEh;
  private PorterDuffColorFilter bzA;
  private PorterDuff.Mode bzC;
  private final PointF bzs;
  private final Paint paint;
  private float scale;
  private int shadowColor;
  private int shadowRadius;
  private float strokeWidth;
  
  public c()
  {
    this(null);
  }
  
  public c(e parame)
  {
    AppMethodBeat.i(238974);
    this.paint = new Paint();
    this.bDT = new Matrix[4];
    this.bDU = new Matrix[4];
    this.bDV = new d[4];
    this.aHZ = new Matrix();
    this.aBZ = new Path();
    this.bzs = new PointF();
    this.bDW = new d();
    this.bDX = new Region();
    this.bDY = new Region();
    this.bDZ = new float[2];
    this.bEa = new float[2];
    this.bEb = null;
    this.bEc = false;
    this.bEd = false;
    this.bEe = 1.0F;
    this.shadowColor = -16777216;
    this.bEf = 5;
    this.shadowRadius = 10;
    this.alpha = 255;
    this.scale = 1.0F;
    this.strokeWidth = 0.0F;
    this.bEg = Paint.Style.FILL_AND_STROKE;
    this.bzC = PorterDuff.Mode.SRC_IN;
    this.bEh = null;
    this.bEb = parame;
    while (i < 4)
    {
      this.bDT[i] = new Matrix();
      this.bDU[i] = new Matrix();
      this.bDV[i] = new d();
      i += 1;
    }
    AppMethodBeat.o(238974);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, PointF paramPointF)
  {
    AppMethodBeat.i(238993);
    switch (paramInt1)
    {
    default: 
      paramPointF.set(0.0F, 0.0F);
      AppMethodBeat.o(238993);
      return;
    case 1: 
      paramPointF.set(paramInt2, 0.0F);
      AppMethodBeat.o(238993);
      return;
    case 2: 
      paramPointF.set(paramInt2, paramInt3);
      AppMethodBeat.o(238993);
      return;
    }
    paramPointF.set(0.0F, paramInt3);
    AppMethodBeat.o(238993);
  }
  
  private void a(int paramInt1, int paramInt2, Path paramPath)
  {
    AppMethodBeat.i(238991);
    paramPath.rewind();
    if (this.bEb == null)
    {
      AppMethodBeat.o(238991);
      return;
    }
    int i = 0;
    float f1;
    while (i < 4)
    {
      a(i, paramInt1, paramInt2, this.bzs);
      a((i - 1 + 4) % 4, paramInt1, paramInt2, this.bzs);
      f1 = this.bzs.x;
      float f2 = this.bzs.y;
      a((i + 1) % 4, paramInt1, paramInt2, this.bzs);
      float f3 = this.bzs.x;
      float f4 = this.bzs.y;
      a(i, paramInt1, paramInt2, this.bzs);
      float f5 = this.bzs.x;
      float f6 = this.bzs.y;
      Math.atan2(f2 - f6, f1 - f5);
      Math.atan2(f4 - f6, f3 - f5);
      f1 = y((i - 1 + 4) % 4, paramInt1, paramInt2);
      this.bDT[i].reset();
      this.bDT[i].setTranslate(this.bzs.x, this.bzs.y);
      this.bDT[i].preRotate((float)Math.toDegrees(f1 + 1.570796F));
      this.bDZ[0] = this.bDV[i].bEi;
      this.bDZ[1] = this.bDV[i].bEj;
      this.bDT[i].mapPoints(this.bDZ);
      f1 = y(i, paramInt1, paramInt2);
      this.bDU[i].reset();
      this.bDU[i].setTranslate(this.bDZ[0], this.bDZ[1]);
      this.bDU[i].preRotate((float)Math.toDegrees(f1));
      i += 1;
    }
    paramInt1 = 0;
    if (paramInt1 < 4)
    {
      this.bDZ[0] = this.bDV[paramInt1].aBO;
      this.bDZ[1] = this.bDV[paramInt1].aBP;
      this.bDT[paramInt1].mapPoints(this.bDZ);
      label427:
      b localb;
      if (paramInt1 == 0)
      {
        paramPath.moveTo(this.bDZ[0], this.bDZ[1]);
        this.bDV[paramInt1].a(this.bDT[paramInt1], paramPath);
        paramInt2 = (paramInt1 + 1) % 4;
        this.bDZ[0] = this.bDV[paramInt1].bEi;
        this.bDZ[1] = this.bDV[paramInt1].bEj;
        this.bDT[paramInt1].mapPoints(this.bDZ);
        this.bEa[0] = this.bDV[paramInt2].aBO;
        this.bEa[1] = this.bDV[paramInt2].aBP;
        this.bDT[paramInt2].mapPoints(this.bEa);
        f1 = (float)Math.hypot(this.bDZ[0] - this.bEa[0], this.bDZ[1] - this.bEa[1]);
        this.bDW.xw();
        switch (paramInt1)
        {
        default: 
          localb = this.bEb.bEt;
        }
      }
      for (;;)
      {
        localb.a(f1, this.bEe, this.bDW);
        this.bDW.a(this.bDU[paramInt1], paramPath);
        paramInt1 += 1;
        break;
        paramPath.lineTo(this.bDZ[0], this.bDZ[1]);
        break label427;
        localb = this.bEb.bEu;
        continue;
        localb = this.bEb.bEv;
        continue;
        localb = this.bEb.bEw;
      }
    }
    paramPath.close();
    AppMethodBeat.o(238991);
  }
  
  private void b(int paramInt1, int paramInt2, Path paramPath)
  {
    AppMethodBeat.i(238995);
    a(paramInt1, paramInt2, paramPath);
    if (this.scale == 1.0F)
    {
      AppMethodBeat.o(238995);
      return;
    }
    this.aHZ.reset();
    this.aHZ.setScale(this.scale, this.scale, paramInt1 / 2, paramInt2 / 2);
    paramPath.transform(this.aHZ);
    AppMethodBeat.o(238995);
  }
  
  private void xv()
  {
    AppMethodBeat.i(238996);
    if ((this.bEh == null) || (this.bzC == null))
    {
      this.bzA = null;
      AppMethodBeat.o(238996);
      return;
    }
    int i = this.bEh.getColorForState(getState(), 0);
    this.bzA = new PorterDuffColorFilter(i, this.bzC);
    if (this.bEd) {
      this.shadowColor = i;
    }
    AppMethodBeat.o(238996);
  }
  
  private float y(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(238994);
    a(paramInt1, paramInt2, paramInt3, this.bzs);
    float f1 = this.bzs.x;
    float f2 = this.bzs.y;
    a((paramInt1 + 1) % 4, paramInt2, paramInt3, this.bzs);
    float f3 = this.bzs.x;
    f1 = (float)Math.atan2(this.bzs.y - f2, f3 - f1);
    AppMethodBeat.o(238994);
    return f1;
  }
  
  public final void Z(float paramFloat)
  {
    AppMethodBeat.i(238986);
    this.bEe = paramFloat;
    invalidateSelf();
    AppMethodBeat.o(238986);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(238987);
    this.paint.setColorFilter(this.bzA);
    int i = this.paint.getAlpha();
    Paint localPaint = this.paint;
    int j = this.alpha;
    localPaint.setAlpha((j + (j >>> 7)) * i >>> 8);
    this.paint.setStrokeWidth(this.strokeWidth);
    this.paint.setStyle(this.bEg);
    if ((this.bEf > 0) && (this.bEc)) {
      this.paint.setShadowLayer(this.shadowRadius, 0.0F, this.bEf, this.shadowColor);
    }
    if (this.bEb != null)
    {
      b(paramCanvas.getWidth(), paramCanvas.getHeight(), this.aBZ);
      paramCanvas.drawPath(this.aBZ, this.paint);
    }
    for (;;)
    {
      this.paint.setAlpha(i);
      AppMethodBeat.o(238987);
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
    AppMethodBeat.i(238985);
    Object localObject = getBounds();
    this.bDX.set((Rect)localObject);
    b(((Rect)localObject).width(), ((Rect)localObject).height(), this.aBZ);
    this.bDY.setPath(this.aBZ, this.bDX);
    this.bDX.op(this.bDY, Region.Op.DIFFERENCE);
    localObject = this.bDX;
    AppMethodBeat.o(238985);
    return localObject;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(238981);
    this.alpha = paramInt;
    invalidateSelf();
    AppMethodBeat.o(238981);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(238983);
    this.paint.setColorFilter(paramColorFilter);
    invalidateSelf();
    AppMethodBeat.o(238983);
  }
  
  public final void setTint(int paramInt)
  {
    AppMethodBeat.i(238978);
    setTintList(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(238978);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(238975);
    this.bEh = paramColorStateList;
    xv();
    invalidateSelf();
    AppMethodBeat.o(238975);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(238977);
    this.bzC = paramMode;
    xv();
    invalidateSelf();
    AppMethodBeat.o(238977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.h.c
 * JD-Core Version:    0.7.0.1
 */