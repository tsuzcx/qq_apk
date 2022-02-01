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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static final boolean duu;
  private static final Paint duv;
  public CharSequence bba;
  private final TextPaint dso;
  private final RectF duA;
  public int duB;
  public int duC;
  public float duD;
  private float duE;
  private ColorStateList duF;
  public ColorStateList duG;
  private float duH;
  private float duI;
  private float duJ;
  private float duK;
  private float duL;
  private float duM;
  public Typeface duN;
  public Typeface duO;
  private Typeface duP;
  private CharSequence duQ;
  private boolean duR;
  private boolean duS;
  private Bitmap duT;
  private Paint duU;
  private float duV;
  private float duW;
  private float duX;
  private int[] duY;
  private boolean duZ;
  private boolean duw;
  public float dux;
  private final Rect duy;
  private final Rect duz;
  private final TextPaint dva;
  public TimeInterpolator dvb;
  private TimeInterpolator dvc;
  private float dvd;
  private float dve;
  private float dvf;
  private int dvg;
  private float dvh;
  private float dvi;
  private float dvj;
  private int dvk;
  private float scale;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      duu = bool;
      duv = null;
      return;
    }
  }
  
  public c(View paramView)
  {
    AppMethodBeat.i(209318);
    this.duB = 16;
    this.duC = 16;
    this.duD = 15.0F;
    this.duE = 15.0F;
    this.view = paramView;
    this.dso = new TextPaint(129);
    this.dva = new TextPaint(this.dso);
    this.duz = new Rect();
    this.duy = new Rect();
    this.duA = new RectF();
    AppMethodBeat.o(209318);
  }
  
  private boolean C(CharSequence paramCharSequence)
  {
    int i = 1;
    AppMethodBeat.i(209420);
    if (z.U(this.view) == 1) {
      if (i == 0) {
        break label54;
      }
    }
    label54:
    for (d locald = androidx.core.e.e.bss;; locald = androidx.core.e.e.bsr)
    {
      boolean bool = locald.a(paramCharSequence, paramCharSequence.length());
      AppMethodBeat.o(209420);
      return bool;
      i = 0;
      break;
    }
  }
  
  private float WG()
  {
    AppMethodBeat.i(209327);
    if (this.bba == null)
    {
      AppMethodBeat.o(209327);
      return 0.0F;
    }
    b(this.dva);
    float f = this.dva.measureText(this.bba, 0, this.bba.length());
    AppMethodBeat.o(209327);
    return f;
  }
  
  private void WI()
  {
    AppMethodBeat.i(209340);
    if ((this.duz.width() > 0) && (this.duz.height() > 0) && (this.duy.width() > 0) && (this.duy.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.duw = bool;
      AppMethodBeat.o(209340);
      return;
    }
  }
  
  private void WJ()
  {
    AppMethodBeat.i(209362);
    aV(this.dux);
    AppMethodBeat.o(209362);
  }
  
  private int WK()
  {
    AppMethodBeat.i(209381);
    if (this.duY != null)
    {
      i = this.duF.getColorForState(this.duY, 0);
      AppMethodBeat.o(209381);
      return i;
    }
    int i = this.duF.getDefaultColor();
    AppMethodBeat.o(209381);
    return i;
  }
  
  private void WM()
  {
    int j = 1;
    float f2 = 0.0F;
    AppMethodBeat.i(209399);
    float f3 = this.duX;
    aY(this.duE);
    float f1;
    int i;
    if (this.duQ != null)
    {
      f1 = this.dso.measureText(this.duQ, 0, this.duQ.length());
      int k = this.duC;
      if (!this.duR) {
        break label384;
      }
      i = 1;
      label68:
      i = androidx.core.g.e.ay(k, i);
      switch (i & 0x70)
      {
      default: 
        this.duI = ((this.dso.descent() - this.dso.ascent()) / 2.0F - this.dso.descent() + this.duz.centerY());
        label146:
        switch (i & 0x800007)
        {
        default: 
          this.duK = this.duz.left;
          label188:
          aY(this.duD);
          f1 = f2;
          if (this.duQ != null) {
            f1 = this.dso.measureText(this.duQ, 0, this.duQ.length());
          }
          k = this.duB;
          if (this.duR)
          {
            i = j;
            label244:
            i = androidx.core.g.e.ay(k, i);
            switch (i & 0x70)
            {
            default: 
              this.duH = ((this.dso.descent() - this.dso.ascent()) / 2.0F - this.dso.descent() + this.duy.centerY());
              label322:
              switch (i & 0x800007)
              {
              default: 
                this.duJ = this.duy.left;
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
      WO();
      aX(f3);
      AppMethodBeat.o(209399);
      return;
      f1 = 0.0F;
      break;
      label384:
      i = 0;
      break label68;
      this.duI = this.duz.bottom;
      break label146;
      this.duI = (this.duz.top - this.dso.ascent());
      break label146;
      this.duK = (this.duz.centerX() - f1 / 2.0F);
      break label188;
      this.duK = (this.duz.right - f1);
      break label188;
      i = 0;
      break label244;
      this.duH = this.duy.bottom;
      break label322;
      this.duH = (this.duy.top - this.dso.ascent());
      break label322;
      this.duJ = (this.duy.centerX() - f1 / 2.0F);
      continue;
      this.duJ = (this.duy.right - f1);
    }
  }
  
  private void WN()
  {
    AppMethodBeat.i(209445);
    if ((this.duT != null) || (this.duy.isEmpty()) || (TextUtils.isEmpty(this.duQ)))
    {
      AppMethodBeat.o(209445);
      return;
    }
    aV(0.0F);
    this.duV = this.dso.ascent();
    this.duW = this.dso.descent();
    int i = Math.round(this.dso.measureText(this.duQ, 0, this.duQ.length()));
    int j = Math.round(this.duW - this.duV);
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(209445);
      return;
    }
    this.duT = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    new Canvas(this.duT).drawText(this.duQ, 0, this.duQ.length(), 0.0F, j - this.dso.descent(), this.dso);
    if (this.duU == null) {
      this.duU = new Paint(3);
    }
    AppMethodBeat.o(209445);
  }
  
  private void WO()
  {
    AppMethodBeat.i(209454);
    if (this.duT != null)
    {
      this.duT.recycle();
      this.duT = null;
    }
    AppMethodBeat.o(209454);
  }
  
  private static boolean X(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(209461);
    if (Math.abs(paramFloat1 - paramFloat2) < 0.001F)
    {
      AppMethodBeat.o(209461);
      return true;
    }
    AppMethodBeat.o(209461);
    return false;
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, TimeInterpolator paramTimeInterpolator)
  {
    AppMethodBeat.i(209479);
    float f = paramFloat3;
    if (paramTimeInterpolator != null) {
      f = paramTimeInterpolator.getInterpolation(paramFloat3);
    }
    paramFloat1 = com.google.android.material.a.a.lerp(paramFloat1, paramFloat2, f);
    AppMethodBeat.o(209479);
    return paramFloat1;
  }
  
  private static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  private void aV(float paramFloat)
  {
    AppMethodBeat.i(209372);
    aW(paramFloat);
    this.duL = a(this.duJ, this.duK, paramFloat, this.dvb);
    this.duM = a(this.duH, this.duI, paramFloat, this.dvb);
    aX(a(this.duD, this.duE, paramFloat, this.dvc));
    if (this.duG != this.duF) {
      this.dso.setColor(e(WK(), WL(), paramFloat));
    }
    for (;;)
    {
      this.dso.setShadowLayer(a(this.dvh, this.dvd, paramFloat, null), a(this.dvi, this.dve, paramFloat, null), a(this.dvj, this.dvf, paramFloat, null), e(this.dvk, this.dvg, paramFloat));
      z.Q(this.view);
      AppMethodBeat.o(209372);
      return;
      this.dso.setColor(WL());
    }
  }
  
  private void aW(float paramFloat)
  {
    AppMethodBeat.i(209410);
    this.duA.left = a(this.duy.left, this.duz.left, paramFloat, this.dvb);
    this.duA.top = a(this.duH, this.duI, paramFloat, this.dvb);
    this.duA.right = a(this.duy.right, this.duz.right, paramFloat, this.dvb);
    this.duA.bottom = a(this.duy.bottom, this.duz.bottom, paramFloat, this.dvb);
    AppMethodBeat.o(209410);
  }
  
  private void aX(float paramFloat)
  {
    AppMethodBeat.i(209428);
    aY(paramFloat);
    if ((duu) && (this.scale != 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      this.duS = bool;
      if (this.duS) {
        WN();
      }
      z.Q(this.view);
      AppMethodBeat.o(209428);
      return;
    }
  }
  
  private void aY(float paramFloat)
  {
    boolean bool = true;
    AppMethodBeat.i(209438);
    if (this.bba == null)
    {
      AppMethodBeat.o(209438);
      return;
    }
    float f2 = this.duz.width();
    float f3 = this.duy.width();
    float f1;
    int i;
    if (X(paramFloat, this.duE))
    {
      f1 = this.duE;
      this.scale = 1.0F;
      if (this.duP == this.duN) {
        break label357;
      }
      this.duP = this.duN;
      i = 1;
      paramFloat = f2;
    }
    for (;;)
    {
      int j = i;
      if (paramFloat > 0.0F)
      {
        if ((this.duX != f1) || (this.duZ) || (i != 0))
        {
          i = 1;
          label121:
          this.duX = f1;
          this.duZ = false;
          j = i;
        }
      }
      else
      {
        if ((this.duQ == null) || (j != 0))
        {
          this.dso.setTextSize(this.duX);
          this.dso.setTypeface(this.duP);
          Object localObject = this.dso;
          if (this.scale == 1.0F) {
            break label345;
          }
          label185:
          ((TextPaint)localObject).setLinearText(bool);
          localObject = TextUtils.ellipsize(this.bba, this.dso, paramFloat, TextUtils.TruncateAt.END);
          if (!TextUtils.equals((CharSequence)localObject, this.duQ))
          {
            this.duQ = ((CharSequence)localObject);
            this.duR = C(this.duQ);
          }
        }
        AppMethodBeat.o(209438);
        return;
        f1 = this.duD;
        if (this.duP == this.duO) {
          break label351;
        }
        this.duP = this.duO;
      }
      label333:
      label345:
      label351:
      for (i = 1;; i = 0)
      {
        if (X(paramFloat, this.duD)) {}
        for (this.scale = 1.0F;; this.scale = (paramFloat / this.duD))
        {
          paramFloat = this.duE / this.duD;
          if (f3 * paramFloat <= f2) {
            break label333;
          }
          paramFloat = Math.min(f2 / paramFloat, f3);
          break;
        }
        paramFloat = f3;
        break;
        i = 0;
        break label121;
        bool = false;
        break label185;
      }
      label357:
      i = 0;
      paramFloat = f2;
    }
  }
  
  private void b(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(209332);
    paramTextPaint.setTextSize(this.duE);
    paramTextPaint.setTypeface(this.duN);
    AppMethodBeat.o(209332);
  }
  
  private static int e(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(209472);
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
    AppMethodBeat.o(209472);
    return paramInt1;
  }
  
  private boolean isStateful()
  {
    AppMethodBeat.i(209353);
    if (((this.duG != null) && (this.duG.isStateful())) || ((this.duF != null) && (this.duF.isStateful())))
    {
      AppMethodBeat.o(209353);
      return true;
    }
    AppMethodBeat.o(209353);
    return false;
  }
  
  private Typeface jo(int paramInt)
  {
    AppMethodBeat.i(209348);
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
      AppMethodBeat.o(209348);
    }
  }
  
  public final float WH()
  {
    AppMethodBeat.i(209550);
    b(this.dva);
    float f = -this.dva.ascent();
    AppMethodBeat.o(209550);
    return f;
  }
  
  public final int WL()
  {
    AppMethodBeat.i(209623);
    if (this.duY != null)
    {
      i = this.duG.getColorForState(this.duY, 0);
      AppMethodBeat.o(209623);
      return i;
    }
    int i = this.duG.getDefaultColor();
    AppMethodBeat.o(209623);
    return i;
  }
  
  public final void aU(float paramFloat)
  {
    AppMethodBeat.i(209606);
    paramFloat = androidx.core.b.a.g(paramFloat, 0.0F, 1.0F);
    if (paramFloat != this.dux)
    {
      this.dux = paramFloat;
      WJ();
    }
    AppMethodBeat.o(209606);
  }
  
  public final void b(RectF paramRectF)
  {
    AppMethodBeat.i(209558);
    boolean bool = C(this.bba);
    if (!bool)
    {
      f = this.duz.left;
      paramRectF.left = f;
      paramRectF.top = this.duz.top;
      if (bool) {
        break label105;
      }
    }
    label105:
    for (float f = paramRectF.left + WG();; f = this.duz.right)
    {
      paramRectF.right = f;
      paramRectF.bottom = (this.duz.top + WH());
      AppMethodBeat.o(209558);
      return;
      f = this.duz.right - WG();
      break;
    }
  }
  
  public final void c(TimeInterpolator paramTimeInterpolator)
  {
    AppMethodBeat.i(209503);
    this.dvc = paramTimeInterpolator;
    xQ();
    AppMethodBeat.o(209503);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209633);
    int j = paramCanvas.save();
    float f4;
    int i;
    float f1;
    label70:
    float f2;
    if ((this.duQ != null) && (this.duw))
    {
      f4 = this.duL;
      float f3 = this.duM;
      if ((!this.duS) || (this.duT == null)) {
        break label140;
      }
      i = 1;
      if (i == 0) {
        break label146;
      }
      f1 = this.duV * this.scale;
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
      paramCanvas.drawBitmap(this.duT, f4, f2, this.duU);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      AppMethodBeat.o(209633);
      return;
      label140:
      i = 0;
      break;
      label146:
      this.dso.ascent();
      f1 = 0.0F;
      this.dso.descent();
      break label70;
      label167:
      paramCanvas.drawText(this.duQ, 0, this.duQ.length(), f4, f2, this.dso);
    }
  }
  
  public final void e(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209515);
    if (this.duG != paramColorStateList)
    {
      this.duG = paramColorStateList;
      xQ();
    }
    AppMethodBeat.o(209515);
  }
  
  public final void f(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209524);
    if (this.duF != paramColorStateList)
    {
      this.duF = paramColorStateList;
      xQ();
    }
    AppMethodBeat.o(209524);
  }
  
  public final void f(Typeface paramTypeface)
  {
    AppMethodBeat.i(209598);
    this.duO = paramTypeface;
    this.duN = paramTypeface;
    xQ();
    AppMethodBeat.o(209598);
  }
  
  public final void jk(int paramInt)
  {
    AppMethodBeat.i(209566);
    if (this.duB != paramInt)
    {
      this.duB = paramInt;
      xQ();
    }
    AppMethodBeat.o(209566);
  }
  
  public final void jl(int paramInt)
  {
    AppMethodBeat.i(209572);
    if (this.duC != paramInt)
    {
      this.duC = paramInt;
      xQ();
    }
    AppMethodBeat.o(209572);
  }
  
  public final void jm(int paramInt)
  {
    AppMethodBeat.i(209581);
    ac localac = ac.a(this.view.getContext(), paramInt, a.j.TextAppearance);
    if (localac.az(a.j.TextAppearance_android_textColor)) {
      this.duG = localac.getColorStateList(a.j.TextAppearance_android_textColor);
    }
    if (localac.az(a.j.TextAppearance_android_textSize)) {
      this.duE = localac.u(a.j.TextAppearance_android_textSize, (int)this.duE);
    }
    this.dvg = localac.getInt(a.j.TextAppearance_android_shadowColor, 0);
    this.dve = localac.d(a.j.TextAppearance_android_shadowDx, 0.0F);
    this.dvf = localac.d(a.j.TextAppearance_android_shadowDy, 0.0F);
    this.dvd = localac.d(a.j.TextAppearance_android_shadowRadius, 0.0F);
    localac.xv.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.duN = jo(paramInt);
    }
    xQ();
    AppMethodBeat.o(209581);
  }
  
  public final void jn(int paramInt)
  {
    AppMethodBeat.i(209590);
    ac localac = ac.a(this.view.getContext(), paramInt, a.j.TextAppearance);
    if (localac.az(a.j.TextAppearance_android_textColor)) {
      this.duF = localac.getColorStateList(a.j.TextAppearance_android_textColor);
    }
    if (localac.az(a.j.TextAppearance_android_textSize)) {
      this.duD = localac.u(a.j.TextAppearance_android_textSize, (int)this.duD);
    }
    this.dvk = localac.getInt(a.j.TextAppearance_android_shadowColor, 0);
    this.dvi = localac.d(a.j.TextAppearance_android_shadowDx, 0.0F);
    this.dvj = localac.d(a.j.TextAppearance_android_shadowDy, 0.0F);
    this.dvh = localac.d(a.j.TextAppearance_android_shadowRadius, 0.0F);
    localac.xv.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.duO = jo(paramInt);
    }
    xQ();
    AppMethodBeat.o(209590);
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(209615);
    this.duY = paramArrayOfInt;
    if (isStateful())
    {
      xQ();
      AppMethodBeat.o(209615);
      return true;
    }
    AppMethodBeat.o(209615);
    return false;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209655);
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.bba)))
    {
      this.bba = paramCharSequence;
      this.duQ = null;
      WO();
      xQ();
    }
    AppMethodBeat.o(209655);
  }
  
  public final void xQ()
  {
    AppMethodBeat.i(209647);
    if ((this.view.getHeight() > 0) && (this.view.getWidth() > 0))
    {
      WM();
      WJ();
    }
    AppMethodBeat.o(209647);
  }
  
  public final void y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209532);
    if (!a(this.duy, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.duy.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.duZ = true;
      WI();
    }
    AppMethodBeat.o(209532);
  }
  
  public final void z(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209540);
    if (!a(this.duz, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.duz.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.duZ = true;
      WI();
    }
    AppMethodBeat.o(209540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.c
 * JD-Core Version:    0.7.0.1
 */