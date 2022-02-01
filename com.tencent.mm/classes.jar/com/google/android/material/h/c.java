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
  private int alpha;
  private PorterDuffColorFilter dsB;
  private PorterDuff.Mode dsD;
  private final PointF dss;
  private final Matrix[] dwU;
  private final Matrix[] dwV;
  private final d[] dwW;
  private final d dwX;
  private final Region dwY;
  private final Region dwZ;
  private final float[] dxa;
  private final float[] dxb;
  private e dxc;
  public boolean dxd;
  private boolean dxe;
  public float dxf;
  private int dxg;
  public Paint.Style dxh;
  public ColorStateList dxi;
  private final Matrix matrix;
  private final Paint paint;
  private final Path path;
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
    AppMethodBeat.i(209610);
    this.paint = new Paint();
    this.dwU = new Matrix[4];
    this.dwV = new Matrix[4];
    this.dwW = new d[4];
    this.matrix = new Matrix();
    this.path = new Path();
    this.dss = new PointF();
    this.dwX = new d();
    this.dwY = new Region();
    this.dwZ = new Region();
    this.dxa = new float[2];
    this.dxb = new float[2];
    this.dxc = null;
    this.dxd = false;
    this.dxe = false;
    this.dxf = 1.0F;
    this.shadowColor = -16777216;
    this.dxg = 5;
    this.shadowRadius = 10;
    this.alpha = 255;
    this.scale = 1.0F;
    this.strokeWidth = 0.0F;
    this.dxh = Paint.Style.FILL_AND_STROKE;
    this.dsD = PorterDuff.Mode.SRC_IN;
    this.dxi = null;
    this.dxc = parame;
    while (i < 4)
    {
      this.dwU[i] = new Matrix();
      this.dwV[i] = new Matrix();
      this.dwW[i] = new d();
      i += 1;
    }
    AppMethodBeat.o(209610);
  }
  
  private float O(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209658);
    a(paramInt1, paramInt2, paramInt3, this.dss);
    float f1 = this.dss.x;
    float f2 = this.dss.y;
    a((paramInt1 + 1) % 4, paramInt2, paramInt3, this.dss);
    float f3 = this.dss.x;
    f1 = (float)Math.atan2(this.dss.y - f2, f3 - f1);
    AppMethodBeat.o(209658);
    return f1;
  }
  
  private void WS()
  {
    AppMethodBeat.i(209674);
    if ((this.dxi == null) || (this.dsD == null))
    {
      this.dsB = null;
      AppMethodBeat.o(209674);
      return;
    }
    int i = this.dxi.getColorForState(getState(), 0);
    this.dsB = new PorterDuffColorFilter(i, this.dsD);
    if (this.dxe) {
      this.shadowColor = i;
    }
    AppMethodBeat.o(209674);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, PointF paramPointF)
  {
    AppMethodBeat.i(209648);
    switch (paramInt1)
    {
    default: 
      paramPointF.set(0.0F, 0.0F);
      AppMethodBeat.o(209648);
      return;
    case 1: 
      paramPointF.set(paramInt2, 0.0F);
      AppMethodBeat.o(209648);
      return;
    case 2: 
      paramPointF.set(paramInt2, paramInt3);
      AppMethodBeat.o(209648);
      return;
    }
    paramPointF.set(0.0F, paramInt3);
    AppMethodBeat.o(209648);
  }
  
  private void a(int paramInt1, int paramInt2, Path paramPath)
  {
    AppMethodBeat.i(209638);
    paramPath.rewind();
    if (this.dxc == null)
    {
      AppMethodBeat.o(209638);
      return;
    }
    int i = 0;
    float f1;
    while (i < 4)
    {
      a(i, paramInt1, paramInt2, this.dss);
      a((i - 1 + 4) % 4, paramInt1, paramInt2, this.dss);
      f1 = this.dss.x;
      float f2 = this.dss.y;
      a((i + 1) % 4, paramInt1, paramInt2, this.dss);
      float f3 = this.dss.x;
      float f4 = this.dss.y;
      a(i, paramInt1, paramInt2, this.dss);
      float f5 = this.dss.x;
      float f6 = this.dss.y;
      Math.atan2(f2 - f6, f1 - f5);
      Math.atan2(f4 - f6, f3 - f5);
      f1 = O((i - 1 + 4) % 4, paramInt1, paramInt2);
      this.dwU[i].reset();
      this.dwU[i].setTranslate(this.dss.x, this.dss.y);
      this.dwU[i].preRotate((float)Math.toDegrees(f1 + 1.570796F));
      this.dxa[0] = this.dwW[i].dxj;
      this.dxa[1] = this.dwW[i].dxk;
      this.dwU[i].mapPoints(this.dxa);
      f1 = O(i, paramInt1, paramInt2);
      this.dwV[i].reset();
      this.dwV[i].setTranslate(this.dxa[0], this.dxa[1]);
      this.dwV[i].preRotate((float)Math.toDegrees(f1));
      i += 1;
    }
    paramInt1 = 0;
    if (paramInt1 < 4)
    {
      this.dxa[0] = this.dwW[paramInt1].cxD;
      this.dxa[1] = this.dwW[paramInt1].cxE;
      this.dwU[paramInt1].mapPoints(this.dxa);
      label427:
      b localb;
      if (paramInt1 == 0)
      {
        paramPath.moveTo(this.dxa[0], this.dxa[1]);
        this.dwW[paramInt1].a(this.dwU[paramInt1], paramPath);
        paramInt2 = (paramInt1 + 1) % 4;
        this.dxa[0] = this.dwW[paramInt1].dxj;
        this.dxa[1] = this.dwW[paramInt1].dxk;
        this.dwU[paramInt1].mapPoints(this.dxa);
        this.dxb[0] = this.dwW[paramInt2].cxD;
        this.dxb[1] = this.dwW[paramInt2].cxE;
        this.dwU[paramInt2].mapPoints(this.dxb);
        f1 = (float)Math.hypot(this.dxa[0] - this.dxb[0], this.dxa[1] - this.dxb[1]);
        this.dwX.WT();
        switch (paramInt1)
        {
        default: 
          localb = this.dxc.dxu;
        }
      }
      for (;;)
      {
        localb.a(f1, this.dxf, this.dwX);
        this.dwX.a(this.dwV[paramInt1], paramPath);
        paramInt1 += 1;
        break;
        paramPath.lineTo(this.dxa[0], this.dxa[1]);
        break label427;
        localb = this.dxc.dxv;
        continue;
        localb = this.dxc.dxw;
        continue;
        localb = this.dxc.dxx;
      }
    }
    paramPath.close();
    AppMethodBeat.o(209638);
  }
  
  private void b(int paramInt1, int paramInt2, Path paramPath)
  {
    AppMethodBeat.i(209667);
    a(paramInt1, paramInt2, paramPath);
    if (this.scale == 1.0F)
    {
      AppMethodBeat.o(209667);
      return;
    }
    this.matrix.reset();
    this.matrix.setScale(this.scale, this.scale, paramInt1 / 2, paramInt2 / 2);
    paramPath.transform(this.matrix);
    AppMethodBeat.o(209667);
  }
  
  public final void ba(float paramFloat)
  {
    AppMethodBeat.i(209772);
    this.dxf = paramFloat;
    invalidateSelf();
    AppMethodBeat.o(209772);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209787);
    this.paint.setColorFilter(this.dsB);
    int i = this.paint.getAlpha();
    Paint localPaint = this.paint;
    int j = this.alpha;
    localPaint.setAlpha((j + (j >>> 7)) * i >>> 8);
    this.paint.setStrokeWidth(this.strokeWidth);
    this.paint.setStyle(this.dxh);
    if ((this.dxg > 0) && (this.dxd)) {
      this.paint.setShadowLayer(this.shadowRadius, 0.0F, this.dxg, this.shadowColor);
    }
    if (this.dxc != null)
    {
      b(paramCanvas.getWidth(), paramCanvas.getHeight(), this.path);
      paramCanvas.drawPath(this.path, this.paint);
    }
    for (;;)
    {
      this.paint.setAlpha(i);
      AppMethodBeat.o(209787);
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
    AppMethodBeat.i(209759);
    Object localObject = getBounds();
    this.dwY.set((Rect)localObject);
    b(((Rect)localObject).width(), ((Rect)localObject).height(), this.path);
    this.dwZ.setPath(this.path, this.dwY);
    this.dwY.op(this.dwZ, Region.Op.DIFFERENCE);
    localObject = this.dwY;
    AppMethodBeat.o(209759);
    return localObject;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(209740);
    this.alpha = paramInt;
    invalidateSelf();
    AppMethodBeat.o(209740);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(209747);
    this.paint.setColorFilter(paramColorFilter);
    invalidateSelf();
    AppMethodBeat.o(209747);
  }
  
  public final void setTint(int paramInt)
  {
    AppMethodBeat.i(209708);
    setTintList(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(209708);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209681);
    this.dxi = paramColorStateList;
    WS();
    invalidateSelf();
    AppMethodBeat.o(209681);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(209697);
    this.dsD = paramMode;
    WS();
    invalidateSelf();
    AppMethodBeat.o(209697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.h.c
 * JD-Core Version:    0.7.0.1
 */