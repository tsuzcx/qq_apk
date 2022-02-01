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
  private static final boolean oM;
  private static final Paint oN;
  private final TextPaint iU;
  private boolean oO;
  float oP;
  private final Rect oQ;
  private final Rect oR;
  private final RectF oS;
  int oT = 16;
  int oU = 16;
  float oV = 15.0F;
  private float oW = 15.0F;
  private ColorStateList oX;
  ColorStateList oY;
  private float oZ;
  private float pA;
  private float pB;
  private int pC;
  private float pa;
  private float pb;
  private float pc;
  private float pd;
  private float pe;
  Typeface pf;
  Typeface pg;
  private Typeface ph;
  private CharSequence pi;
  private boolean pj;
  private boolean pk;
  private Bitmap pl;
  private Paint pm;
  private float pn;
  private float po;
  private float pp;
  private int[] pq;
  private boolean pr;
  private final TextPaint ps;
  TimeInterpolator pt;
  private TimeInterpolator pu;
  private float pv;
  private float pw;
  private float px;
  private int py;
  private float pz;
  private float scale;
  CharSequence text;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      oM = bool;
      oN = null;
      return;
    }
  }
  
  public d(View paramView)
  {
    this.view = paramView;
    this.iU = new TextPaint(129);
    this.ps = new TextPaint(this.iU);
    this.oR = new Rect();
    this.oQ = new Rect();
    this.oS = new RectF();
  }
  
  private Typeface R(int paramInt)
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
    paramTextPaint.setTextSize(this.oW);
    paramTextPaint.setTypeface(this.pf);
  }
  
  private static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
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
    for (android.support.v4.d.d locald = e.Oh;; locald = e.Og)
    {
      return locald.a(paramCharSequence, paramCharSequence.length());
      i = 0;
      break;
    }
  }
  
  private float cf()
  {
    if (this.text == null) {
      return 0.0F;
    }
    a(this.ps);
    return this.ps.measureText(this.text, 0, this.text.length());
  }
  
  private void ch()
  {
    if ((this.oR.width() > 0) && (this.oR.height() > 0) && (this.oQ.width() > 0) && (this.oQ.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.oO = bool;
      return;
    }
  }
  
  private void ci()
  {
    l(this.oP);
  }
  
  private int cj()
  {
    if (this.pq != null) {
      return this.oX.getColorForState(this.pq, 0);
    }
    return this.oX.getDefaultColor();
  }
  
  private void cl()
  {
    int j = 1;
    float f2 = 0.0F;
    float f3 = this.pp;
    o(this.oW);
    float f1;
    int i;
    if (this.pi != null)
    {
      f1 = this.iU.measureText(this.pi, 0, this.pi.length());
      int k = this.oU;
      if (!this.pj) {
        break label383;
      }
      i = 1;
      label63:
      i = android.support.v4.view.d.getAbsoluteGravity(k, i);
      switch (i & 0x70)
      {
      default: 
        this.pa = ((this.iU.descent() - this.iU.ascent()) / 2.0F - this.iU.descent() + this.oR.centerY());
        label142:
        switch (i & 0x800007)
        {
        default: 
          this.pc = this.oR.left;
          label188:
          o(this.oV);
          f1 = f2;
          if (this.pi != null) {
            f1 = this.iU.measureText(this.pi, 0, this.pi.length());
          }
          k = this.oT;
          if (this.pj)
          {
            i = j;
            label244:
            i = android.support.v4.view.d.getAbsoluteGravity(k, i);
            switch (i & 0x70)
            {
            default: 
              this.oZ = ((this.iU.descent() - this.iU.ascent()) / 2.0F - this.iU.descent() + this.oQ.centerY());
              label322:
              switch (i & 0x800007)
              {
              default: 
                this.pb = this.oQ.left;
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
      co();
      n(f3);
      return;
      f1 = 0.0F;
      break;
      label383:
      i = 0;
      break label63;
      this.pa = this.oR.bottom;
      break label142;
      this.pa = (this.oR.top - this.iU.ascent());
      break label142;
      this.pc = (this.oR.centerX() - f1 / 2.0F);
      break label188;
      this.pc = (this.oR.right - f1);
      break label188;
      i = 0;
      break label244;
      this.oZ = this.oQ.bottom;
      break label322;
      this.oZ = (this.oQ.top - this.iU.ascent());
      break label322;
      this.pb = (this.oQ.centerX() - f1 / 2.0F);
      continue;
      this.pb = (this.oQ.right - f1);
    }
  }
  
  private void cm()
  {
    if ((this.pl != null) || (this.oQ.isEmpty()) || (TextUtils.isEmpty(this.pi))) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        l(0.0F);
        this.pn = this.iU.ascent();
        this.po = this.iU.descent();
        i = Math.round(this.iU.measureText(this.pi, 0, this.pi.length()));
        j = Math.round(this.po - this.pn);
      } while ((i <= 0) || (j <= 0));
      this.pl = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      new Canvas(this.pl).drawText(this.pi, 0, this.pi.length(), 0.0F, j - this.iU.descent(), this.iU);
    } while (this.pm != null);
    this.pm = new Paint(3);
  }
  
  private void co()
  {
    if (this.pl != null)
    {
      this.pl.recycle();
      this.pl = null;
    }
  }
  
  private void l(float paramFloat)
  {
    m(paramFloat);
    this.pd = a(this.pb, this.pc, paramFloat, this.pt);
    this.pe = a(this.oZ, this.pa, paramFloat, this.pt);
    n(a(this.oV, this.oW, paramFloat, this.pu));
    if (this.oY != this.oX) {
      this.iU.setColor(c(cj(), ck(), paramFloat));
    }
    for (;;)
    {
      this.iU.setShadowLayer(a(this.pz, this.pv, paramFloat, null), a(this.pA, this.pw, paramFloat, null), a(this.pB, this.px, paramFloat, null), c(this.pC, this.py, paramFloat));
      t.W(this.view);
      return;
      this.iU.setColor(ck());
    }
  }
  
  private void m(float paramFloat)
  {
    this.oS.left = a(this.oQ.left, this.oR.left, paramFloat, this.pt);
    this.oS.top = a(this.oZ, this.pa, paramFloat, this.pt);
    this.oS.right = a(this.oQ.right, this.oR.right, paramFloat, this.pt);
    this.oS.bottom = a(this.oQ.bottom, this.oR.bottom, paramFloat, this.pt);
  }
  
  private void n(float paramFloat)
  {
    o(paramFloat);
    if ((oM) && (this.scale != 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      this.pk = bool;
      if (this.pk) {
        cm();
      }
      t.W(this.view);
      return;
    }
  }
  
  private void o(float paramFloat)
  {
    boolean bool = true;
    if (this.text == null) {
      return;
    }
    float f2 = this.oR.width();
    float f3 = this.oQ.width();
    float f1;
    int i;
    if (c(paramFloat, this.oW))
    {
      f1 = this.oW;
      this.scale = 1.0F;
      if (this.ph == this.pf) {
        break label339;
      }
      this.ph = this.pf;
      i = 1;
      paramFloat = f2;
    }
    for (;;)
    {
      int j = i;
      if (paramFloat > 0.0F)
      {
        if ((this.pp != f1) || (this.pr) || (i != 0))
        {
          i = 1;
          label109:
          this.pp = f1;
          this.pr = false;
          j = i;
        }
      }
      else
      {
        if ((this.pi != null) && (j == 0)) {
          break;
        }
        this.iU.setTextSize(this.pp);
        this.iU.setTypeface(this.ph);
        Object localObject = this.iU;
        if (this.scale == 1.0F) {
          break label327;
        }
        label173:
        ((TextPaint)localObject).setLinearText(bool);
        localObject = TextUtils.ellipsize(this.text, this.iU, paramFloat, TextUtils.TruncateAt.END);
        if (TextUtils.equals((CharSequence)localObject, this.pi)) {
          break;
        }
        this.pi = ((CharSequence)localObject);
        this.pj = c(this.pi);
        return;
        f1 = this.oV;
        if (this.ph == this.pg) {
          break label333;
        }
        this.ph = this.pg;
      }
      label315:
      label327:
      label333:
      for (i = 1;; i = 0)
      {
        if (c(paramFloat, this.oV)) {}
        for (this.scale = 1.0F;; this.scale = (paramFloat / this.oV))
        {
          paramFloat = this.oW / this.oV;
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
  
  public final void N(int paramInt)
  {
    if (this.oT != paramInt)
    {
      this.oT = paramInt;
      cn();
    }
  }
  
  public final void O(int paramInt)
  {
    if (this.oU != paramInt)
    {
      this.oU = paramInt;
      cn();
    }
  }
  
  public final void P(int paramInt)
  {
    az localaz = az.a(this.view.getContext(), paramInt, a.a.TextAppearance);
    if (localaz.hasValue(3)) {
      this.oY = localaz.getColorStateList(3);
    }
    if (localaz.hasValue(0)) {
      this.oW = localaz.getDimensionPixelSize(0, (int)this.oW);
    }
    this.py = localaz.getInt(6, 0);
    this.pw = localaz.getFloat(7, 0.0F);
    this.px = localaz.getFloat(8, 0.0F);
    this.pv = localaz.getFloat(9, 0.0F);
    localaz.ayA.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.pf = R(paramInt);
    }
    cn();
  }
  
  public final void Q(int paramInt)
  {
    az localaz = az.a(this.view.getContext(), paramInt, a.a.TextAppearance);
    if (localaz.hasValue(3)) {
      this.oX = localaz.getColorStateList(3);
    }
    if (localaz.hasValue(0)) {
      this.oV = localaz.getDimensionPixelSize(0, (int)this.oV);
    }
    this.pC = localaz.getInt(6, 0);
    this.pA = localaz.getFloat(7, 0.0F);
    this.pB = localaz.getFloat(8, 0.0F);
    this.pz = localaz.getFloat(9, 0.0F);
    localaz.ayA.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.pg = R(paramInt);
    }
    cn();
  }
  
  public final void a(TimeInterpolator paramTimeInterpolator)
  {
    this.pu = paramTimeInterpolator;
    cn();
  }
  
  public final void a(RectF paramRectF)
  {
    boolean bool = c(this.text);
    if (!bool)
    {
      f = this.oR.left;
      paramRectF.left = f;
      paramRectF.top = this.oR.top;
      if (bool) {
        break label93;
      }
    }
    label93:
    for (float f = paramRectF.left + cf();; f = this.oR.right)
    {
      paramRectF.right = f;
      paramRectF.bottom = (this.oR.top + cg());
      return;
      f = this.oR.right - cf();
      break;
    }
  }
  
  public final void b(Typeface paramTypeface)
  {
    this.pg = paramTypeface;
    this.pf = paramTypeface;
    cn();
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.oQ, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.oQ.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.pr = true;
      ch();
    }
  }
  
  public final float cg()
  {
    a(this.ps);
    return -this.ps.ascent();
  }
  
  public final int ck()
  {
    if (this.pq != null) {
      return this.oY.getColorForState(this.pq, 0);
    }
    return this.oY.getDefaultColor();
  }
  
  public final void cn()
  {
    if ((this.view.getHeight() > 0) && (this.view.getWidth() > 0))
    {
      cl();
      ci();
    }
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.oR, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.oR.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.pr = true;
      ch();
    }
  }
  
  public final void d(ColorStateList paramColorStateList)
  {
    if (this.oY != paramColorStateList)
    {
      this.oY = paramColorStateList;
      cn();
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
    if ((this.pi != null) && (this.oO))
    {
      f4 = this.pd;
      float f3 = this.pe;
      if ((!this.pk) || (this.pl == null)) {
        break label128;
      }
      i = 1;
      if (i == 0) {
        break label134;
      }
      f1 = this.pn * this.scale;
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
      paramCanvas.drawBitmap(this.pl, f4, f2, this.pm);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      return;
      label128:
      i = 0;
      break;
      label134:
      this.iU.ascent();
      f1 = 0.0F;
      this.iU.descent();
      break label64;
      label155:
      paramCanvas.drawText(this.pi, 0, this.pi.length(), f4, f2, this.iU);
    }
  }
  
  public final void e(ColorStateList paramColorStateList)
  {
    if (this.oX != paramColorStateList)
    {
      this.oX = paramColorStateList;
      cn();
    }
  }
  
  public final void k(float paramFloat)
  {
    paramFloat = android.support.v4.b.a.j(paramFloat, 1.0F);
    if (paramFloat != this.oP)
    {
      this.oP = paramFloat;
      ci();
    }
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    this.pq = paramArrayOfInt;
    if (((this.oY != null) && (this.oY.isStateful())) || ((this.oX != null) && (this.oX.isStateful()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      cn();
      return true;
    }
    return false;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.text)))
    {
      this.text = paramCharSequence;
      this.pi = null;
      co();
      cn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.d
 * JD-Core Version:    0.7.0.1
 */