package android.support.design.widget;

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
import android.support.v4.d.e;
import android.support.v4.view.t;
import android.support.v7.a.a.a;
import android.support.v7.widget.az;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;

public final class d
{
  private static final boolean mQ;
  private static final Paint mR;
  private final TextPaint gZ;
  private boolean mS;
  float mT;
  private final Rect mU;
  private final Rect mV;
  private final RectF mW;
  int mZ = 16;
  private TimeInterpolator nA;
  private float nB;
  private float nC;
  private float nD;
  private int nE;
  private float nF;
  private float nG;
  private float nH;
  private int nI;
  int na = 16;
  float nb = 15.0F;
  private float nc = 15.0F;
  private ColorStateList nd;
  ColorStateList ne;
  private float nf;
  private float ng;
  private float nh;
  private float ni;
  private float nj;
  private float nk;
  Typeface nl;
  Typeface nm;
  private Typeface nn;
  private CharSequence no;
  private boolean np;
  private boolean nq;
  private Bitmap nr;
  private Paint ns;
  private float nt;
  private float nu;
  private float nv;
  private int[] nw;
  private boolean nx;
  private final TextPaint ny;
  TimeInterpolator nz;
  private float scale;
  CharSequence text;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      mQ = bool;
      mR = null;
      return;
    }
  }
  
  public d(View paramView)
  {
    this.view = paramView;
    this.gZ = new TextPaint(129);
    this.ny = new TextPaint(this.gZ);
    this.mV = new Rect();
    this.mU = new Rect();
    this.mW = new RectF();
  }
  
  private Typeface S(int paramInt)
  {
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
    }
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, TimeInterpolator paramTimeInterpolator)
  {
    float f = paramFloat3;
    if (paramTimeInterpolator != null) {
      f = paramTimeInterpolator.getInterpolation(paramFloat3);
    }
    return android.support.design.a.a.lerp(paramFloat1, paramFloat2, f);
  }
  
  private void a(TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.nc);
    paramTextPaint.setTypeface(this.nl);
  }
  
  private static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  private float bP()
  {
    if (this.text == null) {
      return 0.0F;
    }
    a(this.ny);
    return this.ny.measureText(this.text, 0, this.text.length());
  }
  
  private void bR()
  {
    if ((this.mV.width() > 0) && (this.mV.height() > 0) && (this.mU.width() > 0) && (this.mU.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mS = bool;
      return;
    }
  }
  
  private void bS()
  {
    n(this.mT);
  }
  
  private int bT()
  {
    if (this.nw != null) {
      return this.nd.getColorForState(this.nw, 0);
    }
    return this.nd.getDefaultColor();
  }
  
  private void bV()
  {
    int j = 1;
    float f2 = 0.0F;
    float f3 = this.nv;
    q(this.nc);
    float f1;
    int i;
    if (this.no != null)
    {
      f1 = this.gZ.measureText(this.no, 0, this.no.length());
      int k = this.na;
      if (!this.np) {
        break label383;
      }
      i = 1;
      label63:
      i = android.support.v4.view.d.getAbsoluteGravity(k, i);
      switch (i & 0x70)
      {
      default: 
        this.ng = ((this.gZ.descent() - this.gZ.ascent()) / 2.0F - this.gZ.descent() + this.mV.centerY());
        label142:
        switch (i & 0x800007)
        {
        default: 
          this.ni = this.mV.left;
          label188:
          q(this.nb);
          f1 = f2;
          if (this.no != null) {
            f1 = this.gZ.measureText(this.no, 0, this.no.length());
          }
          k = this.mZ;
          if (this.np)
          {
            i = j;
            label244:
            i = android.support.v4.view.d.getAbsoluteGravity(k, i);
            switch (i & 0x70)
            {
            default: 
              this.nf = ((this.gZ.descent() - this.gZ.ascent()) / 2.0F - this.gZ.descent() + this.mU.centerY());
              label322:
              switch (i & 0x800007)
              {
              default: 
                this.nh = this.mU.left;
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
      bY();
      p(f3);
      return;
      f1 = 0.0F;
      break;
      label383:
      i = 0;
      break label63;
      this.ng = this.mV.bottom;
      break label142;
      this.ng = (this.mV.top - this.gZ.ascent());
      break label142;
      this.ni = (this.mV.centerX() - f1 / 2.0F);
      break label188;
      this.ni = (this.mV.right - f1);
      break label188;
      i = 0;
      break label244;
      this.nf = this.mU.bottom;
      break label322;
      this.nf = (this.mU.top - this.gZ.ascent());
      break label322;
      this.nh = (this.mU.centerX() - f1 / 2.0F);
      continue;
      this.nh = (this.mU.right - f1);
    }
  }
  
  private void bW()
  {
    if ((this.nr != null) || (this.mU.isEmpty()) || (TextUtils.isEmpty(this.no))) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        n(0.0F);
        this.nt = this.gZ.ascent();
        this.nu = this.gZ.descent();
        i = Math.round(this.gZ.measureText(this.no, 0, this.no.length()));
        j = Math.round(this.nu - this.nt);
      } while ((i <= 0) || (j <= 0));
      this.nr = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      new Canvas(this.nr).drawText(this.no, 0, this.no.length(), 0.0F, j - this.gZ.descent(), this.gZ);
    } while (this.ns != null);
    this.ns = new Paint(3);
  }
  
  private void bY()
  {
    if (this.nr != null)
    {
      this.nr.recycle();
      this.nr = null;
    }
  }
  
  private static int c(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f1 * f8 + f9 * paramFloat));
  }
  
  private static boolean c(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }
  
  private boolean c(CharSequence paramCharSequence)
  {
    int i = 1;
    if (t.Y(this.view) == 1) {
      if (i == 0) {
        break label40;
      }
    }
    label40:
    for (android.support.v4.d.d locald = e.Mp;; locald = e.Mo)
    {
      return locald.a(paramCharSequence, paramCharSequence.length());
      i = 0;
      break;
    }
  }
  
  private void n(float paramFloat)
  {
    o(paramFloat);
    this.nj = a(this.nh, this.ni, paramFloat, this.nz);
    this.nk = a(this.nf, this.ng, paramFloat, this.nz);
    p(a(this.nb, this.nc, paramFloat, this.nA));
    if (this.ne != this.nd) {
      this.gZ.setColor(c(bT(), bU(), paramFloat));
    }
    for (;;)
    {
      this.gZ.setShadowLayer(a(this.nF, this.nB, paramFloat, null), a(this.nG, this.nC, paramFloat, null), a(this.nH, this.nD, paramFloat, null), c(this.nI, this.nE, paramFloat));
      t.W(this.view);
      return;
      this.gZ.setColor(bU());
    }
  }
  
  private void o(float paramFloat)
  {
    this.mW.left = a(this.mU.left, this.mV.left, paramFloat, this.nz);
    this.mW.top = a(this.nf, this.ng, paramFloat, this.nz);
    this.mW.right = a(this.mU.right, this.mV.right, paramFloat, this.nz);
    this.mW.bottom = a(this.mU.bottom, this.mV.bottom, paramFloat, this.nz);
  }
  
  private void p(float paramFloat)
  {
    q(paramFloat);
    if ((mQ) && (this.scale != 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      this.nq = bool;
      if (this.nq) {
        bW();
      }
      t.W(this.view);
      return;
    }
  }
  
  private void q(float paramFloat)
  {
    boolean bool = true;
    if (this.text == null) {
      return;
    }
    float f2 = this.mV.width();
    float f3 = this.mU.width();
    float f1;
    int i;
    if (c(paramFloat, this.nc))
    {
      f1 = this.nc;
      this.scale = 1.0F;
      if (this.nn == this.nl) {
        break label339;
      }
      this.nn = this.nl;
      i = 1;
      paramFloat = f2;
    }
    for (;;)
    {
      int j = i;
      if (paramFloat > 0.0F)
      {
        if ((this.nv != f1) || (this.nx) || (i != 0))
        {
          i = 1;
          label109:
          this.nv = f1;
          this.nx = false;
          j = i;
        }
      }
      else
      {
        if ((this.no != null) && (j == 0)) {
          break;
        }
        this.gZ.setTextSize(this.nv);
        this.gZ.setTypeface(this.nn);
        Object localObject = this.gZ;
        if (this.scale == 1.0F) {
          break label327;
        }
        label173:
        ((TextPaint)localObject).setLinearText(bool);
        localObject = TextUtils.ellipsize(this.text, this.gZ, paramFloat, TextUtils.TruncateAt.END);
        if (TextUtils.equals((CharSequence)localObject, this.no)) {
          break;
        }
        this.no = ((CharSequence)localObject);
        this.np = c(this.no);
        return;
        f1 = this.nb;
        if (this.nn == this.nm) {
          break label333;
        }
        this.nn = this.nm;
      }
      label315:
      label327:
      label333:
      for (i = 1;; i = 0)
      {
        if (c(paramFloat, this.nb)) {}
        for (this.scale = 1.0F;; this.scale = (paramFloat / this.nb))
        {
          paramFloat = this.nc / this.nb;
          if (f3 * paramFloat <= f2) {
            break label315;
          }
          paramFloat = Math.min(f2 / paramFloat, f3);
          break;
        }
        paramFloat = f3;
        break;
        i = 0;
        break label109;
        bool = false;
        break label173;
      }
      label339:
      i = 0;
      paramFloat = f2;
    }
  }
  
  public final void O(int paramInt)
  {
    if (this.mZ != paramInt)
    {
      this.mZ = paramInt;
      bX();
    }
  }
  
  public final void P(int paramInt)
  {
    if (this.na != paramInt)
    {
      this.na = paramInt;
      bX();
    }
  }
  
  public final void Q(int paramInt)
  {
    az localaz = az.a(this.view.getContext(), paramInt, a.a.TextAppearance);
    if (localaz.hasValue(3)) {
      this.ne = localaz.getColorStateList(3);
    }
    if (localaz.hasValue(0)) {
      this.nc = localaz.getDimensionPixelSize(0, (int)this.nc);
    }
    this.nE = localaz.getInt(6, 0);
    this.nC = localaz.getFloat(7, 0.0F);
    this.nD = localaz.getFloat(8, 0.0F);
    this.nB = localaz.getFloat(9, 0.0F);
    localaz.awJ.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.nl = S(paramInt);
    }
    bX();
  }
  
  public final void R(int paramInt)
  {
    az localaz = az.a(this.view.getContext(), paramInt, a.a.TextAppearance);
    if (localaz.hasValue(3)) {
      this.nd = localaz.getColorStateList(3);
    }
    if (localaz.hasValue(0)) {
      this.nb = localaz.getDimensionPixelSize(0, (int)this.nb);
    }
    this.nI = localaz.getInt(6, 0);
    this.nG = localaz.getFloat(7, 0.0F);
    this.nH = localaz.getFloat(8, 0.0F);
    this.nF = localaz.getFloat(9, 0.0F);
    localaz.awJ.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.nm = S(paramInt);
    }
    bX();
  }
  
  public final void a(TimeInterpolator paramTimeInterpolator)
  {
    this.nA = paramTimeInterpolator;
    bX();
  }
  
  public final void a(RectF paramRectF)
  {
    boolean bool = c(this.text);
    if (!bool)
    {
      f = this.mV.left;
      paramRectF.left = f;
      paramRectF.top = this.mV.top;
      if (bool) {
        break label93;
      }
    }
    label93:
    for (float f = paramRectF.left + bP();; f = this.mV.right)
    {
      paramRectF.right = f;
      paramRectF.bottom = (this.mV.top + bQ());
      return;
      f = this.mV.right - bP();
      break;
    }
  }
  
  public final void b(Typeface paramTypeface)
  {
    this.nm = paramTypeface;
    this.nl = paramTypeface;
    bX();
  }
  
  public final float bQ()
  {
    a(this.ny);
    return -this.ny.ascent();
  }
  
  public final int bU()
  {
    if (this.nw != null) {
      return this.ne.getColorForState(this.nw, 0);
    }
    return this.ne.getDefaultColor();
  }
  
  public final void bX()
  {
    if ((this.view.getHeight() > 0) && (this.view.getWidth() > 0))
    {
      bV();
      bS();
    }
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.mU, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.mU.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.nx = true;
      bR();
    }
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.mV, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.mV.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.nx = true;
      bR();
    }
  }
  
  public final void d(ColorStateList paramColorStateList)
  {
    if (this.ne != paramColorStateList)
    {
      this.ne = paramColorStateList;
      bX();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int j = paramCanvas.save();
    float f4;
    int i;
    float f1;
    label64:
    float f2;
    if ((this.no != null) && (this.mS))
    {
      f4 = this.nj;
      float f3 = this.nk;
      if ((!this.nq) || (this.nr == null)) {
        break label128;
      }
      i = 1;
      if (i == 0) {
        break label134;
      }
      f1 = this.nt * this.scale;
      f2 = f3;
      if (i != 0) {
        f2 = f3 + f1;
      }
      if (this.scale != 1.0F) {
        paramCanvas.scale(this.scale, this.scale, f4, f2);
      }
      if (i == 0) {
        break label155;
      }
      paramCanvas.drawBitmap(this.nr, f4, f2, this.ns);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      return;
      label128:
      i = 0;
      break;
      label134:
      this.gZ.ascent();
      f1 = 0.0F;
      this.gZ.descent();
      break label64;
      label155:
      paramCanvas.drawText(this.no, 0, this.no.length(), f4, f2, this.gZ);
    }
  }
  
  public final void e(ColorStateList paramColorStateList)
  {
    if (this.nd != paramColorStateList)
    {
      this.nd = paramColorStateList;
      bX();
    }
  }
  
  public final void m(float paramFloat)
  {
    paramFloat = android.support.v4.b.a.j(paramFloat, 1.0F);
    if (paramFloat != this.mT)
    {
      this.mT = paramFloat;
      bS();
    }
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    this.nw = paramArrayOfInt;
    if (((this.ne != null) && (this.ne.isStateful())) || ((this.nd != null) && (this.nd.isStateful()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      bX();
      return true;
    }
    return false;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.text)))
    {
      this.text = paramCharSequence;
      this.no = null;
      bY();
      bX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.d
 * JD-Core Version:    0.7.0.1
 */