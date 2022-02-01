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
  static final double Rr;
  private boolean dirty;
  final Paint dwG;
  final Paint dwH;
  final RectF dwI;
  float dwJ;
  Path dwK;
  float dwL;
  float dwM;
  float dwN;
  public float dwO;
  private final int dwP;
  private final int dwQ;
  private final int dwR;
  public boolean dwS;
  private boolean dwT;
  public float rotation;
  
  static
  {
    AppMethodBeat.i(208990);
    Rr = Math.cos(Math.toRadians(45.0D));
    AppMethodBeat.o(208990);
  }
  
  public a(Context paramContext, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramDrawable);
    AppMethodBeat.i(208969);
    this.dirty = true;
    this.dwS = true;
    this.dwT = false;
    this.dwP = androidx.core.content.a.w(paramContext, a.c.design_fab_shadow_start_color);
    this.dwQ = androidx.core.content.a.w(paramContext, a.c.design_fab_shadow_mid_color);
    this.dwR = androidx.core.content.a.w(paramContext, a.c.design_fab_shadow_end_color);
    this.dwG = new Paint(5);
    this.dwG.setStyle(Paint.Style.FILL);
    this.dwJ = Math.round(paramFloat1);
    this.dwI = new RectF();
    this.dwH = new Paint(this.dwG);
    this.dwH.setAntiAlias(false);
    p(paramFloat2, paramFloat3);
    AppMethodBeat.o(208969);
  }
  
  public static float d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return (float)(1.5F * paramFloat1 + (1.0D - Rr) * paramFloat2);
    }
    return 1.5F * paramFloat1;
  }
  
  public static float e(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean) {
      f = (float)(paramFloat1 + (1.0D - Rr) * paramFloat2);
    }
    return f;
  }
  
  private static int k(float paramFloat)
  {
    AppMethodBeat.i(208976);
    int i = Math.round(paramFloat);
    if (i % 2 == 1)
    {
      AppMethodBeat.o(208976);
      return i - 1;
    }
    AppMethodBeat.o(208976);
    return i;
  }
  
  public final void aZ(float paramFloat)
  {
    AppMethodBeat.i(209023);
    p(paramFloat, this.dwM);
    AppMethodBeat.o(209023);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209077);
    float f1;
    float f2;
    float f3;
    int i;
    int k;
    if (this.dirty)
    {
      Object localObject = getBounds();
      f1 = this.dwM * 1.5F;
      this.dwI.set(((Rect)localObject).left + this.dwM, ((Rect)localObject).top + f1, ((Rect)localObject).right - this.dwM, ((Rect)localObject).bottom - f1);
      this.kD.setBounds((int)this.dwI.left, (int)this.dwI.top, (int)this.dwI.right, (int)this.dwI.bottom);
      localObject = new RectF(-this.dwJ, -this.dwJ, this.dwJ, this.dwJ);
      RectF localRectF = new RectF((RectF)localObject);
      localRectF.inset(-this.dwN, -this.dwN);
      if (this.dwK == null)
      {
        this.dwK = new Path();
        this.dwK.setFillType(Path.FillType.EVEN_ODD);
        this.dwK.moveTo(-this.dwJ, 0.0F);
        this.dwK.rLineTo(-this.dwN, 0.0F);
        this.dwK.arcTo(localRectF, 180.0F, 90.0F, false);
        this.dwK.arcTo((RectF)localObject, 270.0F, -90.0F, false);
        this.dwK.close();
        f1 = -localRectF.top;
        if (f1 > 0.0F)
        {
          f2 = this.dwJ / f1;
          f3 = (1.0F - f2) / 2.0F;
          localPaint = this.dwG;
          i = this.dwP;
          j = this.dwQ;
          k = this.dwR;
          Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
          localPaint.setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f2 + f3, 1.0F }, localTileMode));
        }
        Paint localPaint = this.dwH;
        f1 = ((RectF)localObject).top;
        f2 = localRectF.top;
        i = this.dwP;
        j = this.dwQ;
        k = this.dwR;
        localObject = Shader.TileMode.CLAMP;
        localPaint.setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject));
        this.dwH.setAntiAlias(false);
        this.dirty = false;
      }
    }
    else
    {
      k = paramCanvas.save();
      paramCanvas.rotate(this.rotation, this.dwI.centerX(), this.dwI.centerY());
      f1 = -this.dwJ - this.dwN;
      f2 = this.dwJ;
      if (this.dwI.width() - 2.0F * f2 <= 0.0F) {
        break label1071;
      }
      i = 1;
      label540:
      if (this.dwI.height() - 2.0F * f2 <= 0.0F) {
        break label1077;
      }
    }
    label1071:
    label1077:
    for (int j = 1;; j = 0)
    {
      float f6 = this.dwO;
      float f7 = this.dwO;
      f3 = this.dwO;
      float f8 = this.dwO;
      float f4 = this.dwO;
      float f5 = this.dwO;
      f3 = f2 / (f3 - f8 * 0.5F + f2);
      f6 = f2 / (f6 - f7 * 0.25F + f2);
      f4 = f2 / (f2 + (f4 - f5 * 1.0F));
      int m = paramCanvas.save();
      paramCanvas.translate(this.dwI.left + f2, this.dwI.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.drawPath(this.dwK, this.dwG);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.dwI.width() - 2.0F * f2, -this.dwJ, this.dwH);
      }
      paramCanvas.restoreToCount(m);
      m = paramCanvas.save();
      paramCanvas.translate(this.dwI.right - f2, this.dwI.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(180.0F);
      paramCanvas.drawPath(this.dwK, this.dwG);
      if (i != 0)
      {
        paramCanvas.scale(1.0F / f3, 1.0F);
        f5 = this.dwI.width();
        f7 = -this.dwJ;
        paramCanvas.drawRect(0.0F, f1, f5 - 2.0F * f2, this.dwN + f7, this.dwH);
      }
      paramCanvas.restoreToCount(m);
      i = paramCanvas.save();
      paramCanvas.translate(this.dwI.left + f2, this.dwI.bottom - f2);
      paramCanvas.scale(f3, f4);
      paramCanvas.rotate(270.0F);
      paramCanvas.drawPath(this.dwK, this.dwG);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f4, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.dwI.height() - 2.0F * f2, -this.dwJ, this.dwH);
      }
      paramCanvas.restoreToCount(i);
      i = paramCanvas.save();
      paramCanvas.translate(this.dwI.right - f2, this.dwI.top + f2);
      paramCanvas.scale(f3, f6);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawPath(this.dwK, this.dwG);
      if (j != 0)
      {
        paramCanvas.scale(1.0F / f6, 1.0F);
        paramCanvas.drawRect(0.0F, f1, this.dwI.height() - 2.0F * f2, -this.dwJ, this.dwH);
      }
      paramCanvas.restoreToCount(i);
      paramCanvas.restoreToCount(k);
      super.draw(paramCanvas);
      AppMethodBeat.o(209077);
      return;
      this.dwK.reset();
      break;
      i = 0;
      break label540;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    AppMethodBeat.i(209042);
    int i = (int)Math.ceil(d(this.dwM, this.dwJ, this.dwS));
    int j = (int)Math.ceil(e(this.dwM, this.dwJ, this.dwS));
    paramRect.set(j, i, j, i);
    AppMethodBeat.o(209042);
    return true;
  }
  
  public final void onBoundsChange(Rect paramRect)
  {
    this.dirty = true;
  }
  
  public final void p(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(209016);
    if ((paramFloat1 < 0.0F) || (paramFloat2 < 0.0F))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid shadow size");
      AppMethodBeat.o(209016);
      throw localIllegalArgumentException;
    }
    float f = k(paramFloat1);
    paramFloat2 = k(paramFloat2);
    paramFloat1 = f;
    if (f > paramFloat2)
    {
      if (!this.dwT) {
        this.dwT = true;
      }
      paramFloat1 = paramFloat2;
    }
    if ((this.dwO == paramFloat1) && (this.dwM == paramFloat2))
    {
      AppMethodBeat.o(209016);
      return;
    }
    this.dwO = paramFloat1;
    this.dwM = paramFloat2;
    this.dwN = Math.round(paramFloat1 * 1.5F);
    this.dwL = paramFloat2;
    this.dirty = true;
    invalidateSelf();
    AppMethodBeat.o(209016);
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(208998);
    super.setAlpha(paramInt);
    this.dwG.setAlpha(paramInt);
    this.dwH.setAlpha(paramInt);
    AppMethodBeat.o(208998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.g.a
 * JD-Core Version:    0.7.0.1
 */