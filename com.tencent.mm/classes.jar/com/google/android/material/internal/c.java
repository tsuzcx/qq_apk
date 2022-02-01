package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import androidx.appcompat.a.j;
import androidx.appcompat.widget.ac;
import androidx.core.e.d;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static final boolean bBs;
  private static final Paint bBt;
  public CharSequence LV;
  public int bBA;
  public float bBB;
  private float bBC;
  private ColorStateList bBD;
  public ColorStateList bBE;
  private float bBF;
  private float bBG;
  private float bBH;
  private float bBI;
  private float bBJ;
  private float bBK;
  public Typeface bBL;
  public Typeface bBM;
  private Typeface bBN;
  private CharSequence bBO;
  private boolean bBP;
  private boolean bBQ;
  private Bitmap bBR;
  private Paint bBS;
  private float bBT;
  private float bBU;
  private float bBV;
  private int[] bBW;
  private boolean bBX;
  private final TextPaint bBY;
  public TimeInterpolator bBZ;
  private boolean bBu;
  public float bBv;
  private final Rect bBw;
  private final Rect bBx;
  private final RectF bBy;
  public int bBz;
  private TimeInterpolator bCa;
  private float bCb;
  private float bCc;
  private float bCd;
  private int bCe;
  private float bCf;
  private float bCg;
  private float bCh;
  private int bCi;
  private final TextPaint bzo;
  private float scale;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      bBs = bool;
      bBt = null;
      return;
    }
  }
  
  public c(View paramView)
  {
    AppMethodBeat.i(237575);
    this.bBz = 16;
    this.bBA = 16;
    this.bBB = 15.0F;
    this.bBC = 15.0F;
    this.view = paramView;
    this.bzo = new TextPaint(129);
    this.bBY = new TextPaint(this.bzo);
    this.bBx = new Rect();
    this.bBw = new Rect();
    this.bBy = new RectF();
    AppMethodBeat.o(237575);
  }
  
  private void U(float paramFloat)
  {
    AppMethodBeat.i(237615);
    V(paramFloat);
    this.bBJ = a(this.bBH, this.bBI, paramFloat, this.bBZ);
    this.bBK = a(this.bBF, this.bBG, paramFloat, this.bBZ);
    W(a(this.bBB, this.bBC, paramFloat, this.bCa));
    if (this.bBE != this.bBD) {
      this.bzo.setColor(d(xm(), xn(), paramFloat));
    }
    for (;;)
    {
      this.bzo.setShadowLayer(a(this.bCf, this.bCb, paramFloat, null), a(this.bCg, this.bCc, paramFloat, null), a(this.bCh, this.bCd, paramFloat, null), d(this.bCi, this.bCe, paramFloat));
      w.G(this.view);
      AppMethodBeat.o(237615);
      return;
      this.bzo.setColor(xn());
    }
  }
  
  private void V(float paramFloat)
  {
    AppMethodBeat.i(237619);
    this.bBy.left = a(this.bBw.left, this.bBx.left, paramFloat, this.bBZ);
    this.bBy.top = a(this.bBF, this.bBG, paramFloat, this.bBZ);
    this.bBy.right = a(this.bBw.right, this.bBx.right, paramFloat, this.bBZ);
    this.bBy.bottom = a(this.bBw.bottom, this.bBx.bottom, paramFloat, this.bBZ);
    AppMethodBeat.o(237619);
  }
  
  private void W(float paramFloat)
  {
    AppMethodBeat.i(237623);
    X(paramFloat);
    if ((bBs) && (this.scale != 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bBQ = bool;
      if (this.bBQ) {
        xp();
      }
      w.G(this.view);
      AppMethodBeat.o(237623);
      return;
    }
  }
  
  private void X(float paramFloat)
  {
    boolean bool = true;
    AppMethodBeat.i(237624);
    if (this.LV == null)
    {
      AppMethodBeat.o(237624);
      return;
    }
    float f2 = this.bBx.width();
    float f3 = this.bBw.width();
    float f1;
    int i;
    if (r(paramFloat, this.bBC))
    {
      f1 = this.bBC;
      this.scale = 1.0F;
      if (this.bBN == this.bBL) {
        break label354;
      }
      this.bBN = this.bBL;
      i = 1;
      paramFloat = f2;
    }
    for (;;)
    {
      int j = i;
      if (paramFloat > 0.0F)
      {
        if ((this.bBV != f1) || (this.bBX) || (i != 0))
        {
          i = 1;
          label119:
          this.bBV = f1;
          this.bBX = false;
          j = i;
        }
      }
      else
      {
        if ((this.bBO == null) || (j != 0))
        {
          this.bzo.setTextSize(this.bBV);
          this.bzo.setTypeface(this.bBN);
          Object localObject = this.bzo;
          if (this.scale == 1.0F) {
            break label342;
          }
          label183:
          ((TextPaint)localObject).setLinearText(bool);
          localObject = TextUtils.ellipsize(this.LV, this.bzo, paramFloat, TextUtils.TruncateAt.END);
          if (!TextUtils.equals((CharSequence)localObject, this.bBO))
          {
            this.bBO = ((CharSequence)localObject);
            this.bBP = x(this.bBO);
          }
        }
        AppMethodBeat.o(237624);
        return;
        f1 = this.bBB;
        if (this.bBN == this.bBM) {
          break label348;
        }
        this.bBN = this.bBM;
      }
      label330:
      label342:
      label348:
      for (i = 1;; i = 0)
      {
        if (r(paramFloat, this.bBB)) {}
        for (this.scale = 1.0F;; this.scale = (paramFloat / this.bBB))
        {
          paramFloat = this.bBC / this.bBB;
          if (f3 * paramFloat <= f2) {
            break label330;
          }
          paramFloat = Math.min(f2 / paramFloat, f3);
          break;
        }
        paramFloat = f3;
        break;
        i = 0;
        break label119;
        bool = false;
        break label183;
      }
      label354:
      i = 0;
      paramFloat = f2;
    }
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, TimeInterpolator paramTimeInterpolator)
  {
    AppMethodBeat.i(237637);
    float f = paramFloat3;
    if (paramTimeInterpolator != null) {
      f = paramTimeInterpolator.getInterpolation(paramFloat3);
    }
    paramFloat1 = com.google.android.material.a.a.lerp(paramFloat1, paramFloat2, f);
    AppMethodBeat.o(237637);
    return paramFloat1;
  }
  
  private void a(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(237591);
    paramTextPaint.setTextSize(this.bBC);
    paramTextPaint.setTypeface(this.bBL);
    AppMethodBeat.o(237591);
  }
  
  private static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  private static int d(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(237636);
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    paramInt1 = Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f1 * f8 + f9 * paramFloat));
    AppMethodBeat.o(237636);
    return paramInt1;
  }
  
  private Typeface fZ(int paramInt)
  {
    AppMethodBeat.i(237605);
    TypedArray localTypedArray = this.view.getContext().obtainStyledAttributes(paramInt, new int[] { 16843692 });
    try
    {
      Object localObject1 = localTypedArray.getString(0);
      if (localObject1 != null)
      {
        localObject1 = Typeface.create((String)localObject1, 0);
        return localObject1;
      }
      return null;
    }
    finally
    {
      localTypedArray.recycle();
      AppMethodBeat.o(237605);
    }
  }
  
  private boolean isStateful()
  {
    AppMethodBeat.i(237613);
    if (((this.bBE != null) && (this.bBE.isStateful())) || ((this.bBD != null) && (this.bBD.isStateful())))
    {
      AppMethodBeat.o(237613);
      return true;
    }
    AppMethodBeat.o(237613);
    return false;
  }
  
  private static boolean r(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237634);
    if (Math.abs(paramFloat1 - paramFloat2) < 0.001F)
    {
      AppMethodBeat.o(237634);
      return true;
    }
    AppMethodBeat.o(237634);
    return false;
  }
  
  private boolean x(CharSequence paramCharSequence)
  {
    int i = 1;
    AppMethodBeat.i(237622);
    if (w.I(this.view) == 1) {
      if (i == 0) {
        break label56;
      }
    }
    label56:
    for (d locald = androidx.core.e.e.Mn;; locald = androidx.core.e.e.Mm)
    {
      boolean bool = locald.a(paramCharSequence, paramCharSequence.length());
      AppMethodBeat.o(237622);
      return bool;
      i = 0;
      break;
    }
  }
  
  private float xi()
  {
    AppMethodBeat.i(237581);
    if (this.LV == null)
    {
      AppMethodBeat.o(237581);
      return 0.0F;
    }
    a(this.bBY);
    float f = this.bBY.measureText(this.LV, 0, this.LV.length());
    AppMethodBeat.o(237581);
    return f;
  }
  
  private void xk()
  {
    AppMethodBeat.i(237594);
    if ((this.bBx.width() > 0) && (this.bBx.height() > 0) && (this.bBw.width() > 0) && (this.bBw.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bBu = bool;
      AppMethodBeat.o(237594);
      return;
    }
  }
  
  private void xl()
  {
    AppMethodBeat.i(237614);
    U(this.bBv);
    AppMethodBeat.o(237614);
  }
  
  private int xm()
  {
    AppMethodBeat.i(237616);
    if (this.bBW != null)
    {
      i = this.bBD.getColorForState(this.bBW, 0);
      AppMethodBeat.o(237616);
      return i;
    }
    int i = this.bBD.getDefaultColor();
    AppMethodBeat.o(237616);
    return i;
  }
  
  private void xo()
  {
    int j = 1;
    float f2 = 0.0F;
    AppMethodBeat.i(237618);
    float f3 = this.bBV;
    X(this.bBC);
    float f1;
    int i;
    if (this.bBO != null)
    {
      f1 = this.bzo.measureText(this.bBO, 0, this.bBO.length());
      int k = this.bBA;
      if (!this.bBP) {
        break label393;
      }
      i = 1;
      label69:
      i = androidx.core.g.e.D(k, i);
      switch (i & 0x70)
      {
      default: 
        this.bBG = ((this.bzo.descent() - this.bzo.ascent()) / 2.0F - this.bzo.descent() + this.bBx.centerY());
        label146:
        switch (i & 0x800007)
        {
        default: 
          this.bBI = this.bBx.left;
          label192:
          X(this.bBB);
          f1 = f2;
          if (this.bBO != null) {
            f1 = this.bzo.measureText(this.bBO, 0, this.bBO.length());
          }
          k = this.bBz;
          if (this.bBP)
          {
            i = j;
            label248:
            i = androidx.core.g.e.D(k, i);
            switch (i & 0x70)
            {
            default: 
              this.bBF = ((this.bzo.descent() - this.bzo.ascent()) / 2.0F - this.bzo.descent() + this.bBw.centerY());
              label326:
              switch (i & 0x800007)
              {
              default: 
                this.bBH = this.bBw.left;
              }
              break;
            }
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      xr();
      W(f3);
      AppMethodBeat.o(237618);
      return;
      f1 = 0.0F;
      break;
      label393:
      i = 0;
      break label69;
      this.bBG = this.bBx.bottom;
      break label146;
      this.bBG = (this.bBx.top - this.bzo.ascent());
      break label146;
      this.bBI = (this.bBx.centerX() - f1 / 2.0F);
      break label192;
      this.bBI = (this.bBx.right - f1);
      break label192;
      i = 0;
      break label248;
      this.bBF = this.bBw.bottom;
      break label326;
      this.bBF = (this.bBw.top - this.bzo.ascent());
      break label326;
      this.bBH = (this.bBw.centerX() - f1 / 2.0F);
      continue;
      this.bBH = (this.bBw.right - f1);
    }
  }
  
  private void xp()
  {
    AppMethodBeat.i(237625);
    if ((this.bBR != null) || (this.bBw.isEmpty()) || (TextUtils.isEmpty(this.bBO)))
    {
      AppMethodBeat.o(237625);
      return;
    }
    U(0.0F);
    this.bBT = this.bzo.ascent();
    this.bBU = this.bzo.descent();
    int i = Math.round(this.bzo.measureText(this.bBO, 0, this.bBO.length()));
    int j = Math.round(this.bBU - this.bBT);
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(237625);
      return;
    }
    this.bBR = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    new Canvas(this.bBR).drawText(this.bBO, 0, this.bBO.length(), 0.0F, j - this.bzo.descent(), this.bzo);
    if (this.bBS == null) {
      this.bBS = new Paint(3);
    }
    AppMethodBeat.o(237625);
  }
  
  private void xr()
  {
    AppMethodBeat.i(237631);
    if (this.bBR != null)
    {
      this.bBR.recycle();
      this.bBR = null;
    }
    AppMethodBeat.o(237631);
  }
  
  public final void T(float paramFloat)
  {
    AppMethodBeat.i(237609);
    paramFloat = androidx.core.b.a.c(paramFloat, 0.0F, 1.0F);
    if (paramFloat != this.bBv)
    {
      this.bBv = paramFloat;
      xl();
    }
    AppMethodBeat.o(237609);
  }
  
  public final void b(RectF paramRectF)
  {
    AppMethodBeat.i(237587);
    boolean bool = x(this.LV);
    if (!bool)
    {
      f = this.bBx.left;
      paramRectF.left = f;
      paramRectF.top = this.bBx.top;
      if (bool) {
        break label105;
      }
    }
    label105:
    for (float f = paramRectF.left + xi();; f = this.bBx.right)
    {
      paramRectF.right = f;
      paramRectF.bottom = (this.bBx.top + xj());
      AppMethodBeat.o(237587);
      return;
      f = this.bBx.right - xi();
      break;
    }
  }
  
  public final void c(TimeInterpolator paramTimeInterpolator)
  {
    AppMethodBeat.i(237576);
    this.bCa = paramTimeInterpolator;
    xq();
    AppMethodBeat.o(237576);
  }
  
  public final void c(Typeface paramTypeface)
  {
    AppMethodBeat.i(237607);
    this.bBM = paramTypeface;
    this.bBL = paramTypeface;
    xq();
    AppMethodBeat.o(237607);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(237621);
    int j = paramCanvas.save();
    float f4;
    int i;
    float f1;
    label70:
    float f2;
    if ((this.bBO != null) && (this.bBu))
    {
      f4 = this.bBJ;
      float f3 = this.bBK;
      if ((!this.bBQ) || (this.bBR == null)) {
        break label140;
      }
      i = 1;
      if (i == 0) {
        break label146;
      }
      f1 = this.bBT * this.scale;
      f2 = f3;
      if (i != 0) {
        f2 = f3 + f1;
      }
      if (this.scale != 1.0F) {
        paramCanvas.scale(this.scale, this.scale, f4, f2);
      }
      if (i == 0) {
        break label167;
      }
      paramCanvas.drawBitmap(this.bBR, f4, f2, this.bBS);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      AppMethodBeat.o(237621);
      return;
      label140:
      i = 0;
      break;
      label146:
      this.bzo.ascent();
      f1 = 0.0F;
      this.bzo.descent();
      break label70;
      label167:
      paramCanvas.drawText(this.bBO, 0, this.bBO.length(), f4, f2, this.bzo);
    }
  }
  
  public final void e(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237577);
    if (this.bBE != paramColorStateList)
    {
      this.bBE = paramColorStateList;
      xq();
    }
    AppMethodBeat.o(237577);
  }
  
  public final void f(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237578);
    if (this.bBD != paramColorStateList)
    {
      this.bBD = paramColorStateList;
      xq();
    }
    AppMethodBeat.o(237578);
  }
  
  public final void fV(int paramInt)
  {
    AppMethodBeat.i(237596);
    if (this.bBz != paramInt)
    {
      this.bBz = paramInt;
      xq();
    }
    AppMethodBeat.o(237596);
  }
  
  public final void fW(int paramInt)
  {
    AppMethodBeat.i(237599);
    if (this.bBA != paramInt)
    {
      this.bBA = paramInt;
      xq();
    }
    AppMethodBeat.o(237599);
  }
  
  public final void fX(int paramInt)
  {
    AppMethodBeat.i(237601);
    ac localac = ac.a(this.view.getContext(), paramInt, a.j.TextAppearance);
    if (localac.aC(a.j.TextAppearance_android_textColor)) {
      this.bBE = localac.getColorStateList(a.j.TextAppearance_android_textColor);
    }
    if (localac.aC(a.j.TextAppearance_android_textSize)) {
      this.bBC = localac.p(a.j.TextAppearance_android_textSize, (int)this.bBC);
    }
    this.bCe = localac.getInt(a.j.TextAppearance_android_shadowColor, 0);
    this.bCc = localac.c(a.j.TextAppearance_android_shadowDx, 0.0F);
    this.bCd = localac.c(a.j.TextAppearance_android_shadowDy, 0.0F);
    this.bCb = localac.c(a.j.TextAppearance_android_shadowRadius, 0.0F);
    localac.wA.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.bBL = fZ(paramInt);
    }
    xq();
    AppMethodBeat.o(237601);
  }
  
  public final void fY(int paramInt)
  {
    AppMethodBeat.i(237603);
    ac localac = ac.a(this.view.getContext(), paramInt, a.j.TextAppearance);
    if (localac.aC(a.j.TextAppearance_android_textColor)) {
      this.bBD = localac.getColorStateList(a.j.TextAppearance_android_textColor);
    }
    if (localac.aC(a.j.TextAppearance_android_textSize)) {
      this.bBB = localac.p(a.j.TextAppearance_android_textSize, (int)this.bBB);
    }
    this.bCi = localac.getInt(a.j.TextAppearance_android_shadowColor, 0);
    this.bCg = localac.c(a.j.TextAppearance_android_shadowDx, 0.0F);
    this.bCh = localac.c(a.j.TextAppearance_android_shadowDy, 0.0F);
    this.bCf = localac.c(a.j.TextAppearance_android_shadowRadius, 0.0F);
    localac.wA.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.bBM = fZ(paramInt);
    }
    xq();
    AppMethodBeat.o(237603);
  }
  
  public final void p(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(237579);
    if (!a(this.bBw, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.bBw.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.bBX = true;
      xk();
    }
    AppMethodBeat.o(237579);
  }
  
  public final void q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(237580);
    if (!a(this.bBx, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.bBx.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.bBX = true;
      xk();
    }
    AppMethodBeat.o(237580);
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237612);
    this.bBW = paramArrayOfInt;
    if (isStateful())
    {
      xq();
      AppMethodBeat.o(237612);
      return true;
    }
    AppMethodBeat.o(237612);
    return false;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(237629);
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.LV)))
    {
      this.LV = paramCharSequence;
      this.bBO = null;
      xr();
      xq();
    }
    AppMethodBeat.o(237629);
  }
  
  public final float xj()
  {
    AppMethodBeat.i(237584);
    a(this.bBY);
    float f = -this.bBY.ascent();
    AppMethodBeat.o(237584);
    return f;
  }
  
  public final int xn()
  {
    AppMethodBeat.i(237617);
    if (this.bBW != null)
    {
      i = this.bBE.getColorForState(this.bBW, 0);
      AppMethodBeat.o(237617);
      return i;
    }
    int i = this.bBE.getDefaultColor();
    AppMethodBeat.o(237617);
    return i;
  }
  
  public final void xq()
  {
    AppMethodBeat.i(237626);
    if ((this.view.getHeight() > 0) && (this.view.getWidth() > 0))
    {
      xo();
      xl();
    }
    AppMethodBeat.o(237626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.c
 * JD-Core Version:    0.7.0.1
 */