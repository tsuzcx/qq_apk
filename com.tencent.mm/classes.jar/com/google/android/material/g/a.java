package com.google.android.material.g;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import androidx.appcompat.b.a.c;
import com.google.android.material.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends c
{
  static final double zc;
  final Paint bDF;
  final Paint bDG;
  final RectF bDH;
  float bDI;
  Path bDJ;
  float bDK;
  float bDL;
  float bDM;
  public float bDN;
  private final int bDO;
  private final int bDP;
  private final int bDQ;
  public boolean bDR;
  private boolean bDS;
  private boolean dirty;
  public float rotation;
  
  static
  {
    AppMethodBeat.i(238876);
    zc = Math.cos(Math.toRadians(45.0D));
    AppMethodBeat.o(238876);
  }
  
  public a(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    AppMethodBeat.i(238853);
    this.dirty = true;
    this.bDR = true;
    this.bDS = false;
    this.bDO = androidx.core.content.a.w(paramContext, a.c.design_fab_shadow_start_color);
    this.bDP = androidx.core.content.a.w(paramContext, a.c.design_fab_shadow_mid_color);
    this.bDQ = androidx.core.content.a.w(paramContext, a.c.design_fab_shadow_end_color);
    this.bDF = new Paint(5);
    this.bDF.setStyle(Paint.Style.FILL);
    this.bDI = Math.round(paramFloat1);
    this.bDH = new RectF();
    this.bDG = new Paint(this.bDF);
    this.bDG.setAntiAlias(false);
    b(paramFloat2, paramFloat3);
    AppMethodBeat.o(238853);
  }
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - zc) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - zc) * paramFloat2);
    }
    return f;
  }
  
  private static int f(float paramFloat)
  {
    AppMethodBeat.i(238857);
    int i = Math.round(paramFloat);
    if (i % 2 == 1)
    {
      AppMethodBeat.o(238857);
      return i - 1;
    }
    AppMethodBeat.o(238857);
    return i;
  }
  
  public final void Y(float paramFloat)
  {
    AppMethodBeat.i(238864);
    b(paramFloat, this.bDL);
    AppMethodBeat.o(238864);
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(238861);
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid shadow size");
      AppMethodBeat.o(238861);
      throw localIllegalArgumentException;
    }
    float f = f(paramFloat1);
    paramFloat2 = f(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.bDS) {
        this.bDS = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.bDN == paramFloat1) && (this.bDL == paramFloat2))
    {
      AppMethodBeat.o(238861);
      return;
    }
    this.bDN = paramFloat1;
    this.bDL = paramFloat2;
    this.bDM = Math.round(paramFloat1 * 1.5F);
    this.bDK = paramFloat2;
    this.dirty = true;
    invalidateSelf();
    AppMethodBeat.o(238861);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(238874);
    float f1;
    float f2;
    float f3;
    int i;
    int k;
    if (this.dirty)
    {
      Object localObject = getBounds();
      f1 = this.bDL * 1.5F;
      this.bDH.set(((Rect)localObject).left + this.bDL, ((Rect)localObject).top + f1, ((Rect)localObject).right - this.bDL, ((Rect)localObject).bottom - f1);
      this.mDrawable.setBounds((int)this.bDH.left, (int)this.bDH.top, (int)this.bDH.right, (int)this.bDH.bottom);
      localObject = new RectF(-this.bDI, -this.bDI, this.bDI, this.bDI);
      RectF localRectF = new RectF((RectF)localObject);
      localRectF.inset(-this.bDM, -this.bDM);
      if (this.bDJ == null)
      {
        this.bDJ = new Path();
        this.bDJ.setFillType(Path.FillType.EVEN_ODD);
        this.bDJ.moveTo(-this.bDI, 0.0F);
        this.bDJ.rLineTo(-this.bDM, 0.0F);
        this.bDJ.arcTo(localRectF, 180.0F, 90.0F, false);
        this.bDJ.arcTo((RectF)localObject, 270.0F, -90.0F, false);
        this.bDJ.close();
        f1 = -localRectF.top;
        if (f1 > 0.0F)
        {
          f2 = this.bDI / f1;
          f3 = (1.0F - f2) / 2.0F;
          localPaint = this.bDF;
          i = this.bDO;
          j = this.bDP;
          k = this.bDQ;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
        }
        Paint localPaint = this.bDG;
        f1 = ((RectF)localObject).top;
        f2 = localRectF.top;
        i = this.bDO;
        j = this.bDP;
        k = this.bDQ;
        localObject = Shader.TileMode.CLAMP;
        localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
        this.bDG.setAntiAlias(false);
        this.dirty = false;
      }
    }
    else
    {
      k = paramCanvas.save();
      paramCanvas.rotate(this.rotation, this.bDH.centerX(), this.bDH.centerY());
      f1 = -this.bDI - this.bDM;
      f2 = this.bDI;
      if (this.bDH.width() - 2.0F * f2 <= 0.0F) {
        break label1073;
      }
      i = 1;
      label541:
      if (this.bDH.height() - 2.0F * f2 <= 0.0F) {
        break label1079;
      }
    }
    label1073:
    label1079:
    for (int j = 1;; j = 0)
    {
      float f6 = this.bDN;
      float f7 = this.bDN;
      f3 = this.bDN;
      float f8 = this.bDN;
      float f4 = this.bDN;
      float f5 = this.bDN;
      f3 = f2 / (f3 - f8 * 0.5F + f2);
      f6 = f2 / (f6 - f7 * 0.25F + f2);
      f4 = f2 / (f2 + (f4 - f5 * 1.0F));
      int m = paramCanvas.save();
      paramCanvas.translate(this.bDH.left + f2, this.bDH.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.drawPath(this.bDJ, this.bDF);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.bDH.width() - 2.0F * f2, -this.bDI, this.bDG);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.save();
      paramCanvas.translate(this.bDH.right - f2, this.bDH.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.bDJ, this.bDF);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        f5 = this.bDH.width();
        f7 = -this.bDI;
        paramCanvas.drawRect(0.0F, f1, f5 - 2.0F * f2, this.bDM + f7, this.bDG);
      }
      paramCanvas.restoreToCount(m);
      i = paramCanvas.save();
      paramCanvas.translate(this.bDH.left + f2, this.bDH.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.bDJ, this.bDF);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f4, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.bDH.height() - 2.0F * f2, -this.bDI, this.bDG);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.bDH.right - f2, this.bDH.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.bDJ, this.bDF);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.bDH.height() - 2.0F * f2, -this.bDI, this.bDG);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.restoreToCount(k);
      super.draw(paramCanvas);
      AppMethodBeat.o(238874);
      return;
      this.bDJ.reset();
      break;
      i = 0;
      break label541;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    AppMethodBeat.i(238868);
    int i = (int)Math.ceil(a(this.bDL, this.bDI, this.bDR));
    int j = (int)Math.ceil(b(this.bDL, this.bDI, this.bDR));
    paramRect.set(j, i, j, i);
    AppMethodBeat.o(238868);
    return true;
  }
  
  public final void onBoundsChange(Rect paramRect)
  {
    this.dirty = true;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(238858);
    super.setAlpha(paramInt);
    this.bDF.setAlpha(paramInt);
    this.bDG.setAlpha(paramInt);
    AppMethodBeat.o(238858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.material.g.a
 * JD-Core Version:    0.7.0.1
 */