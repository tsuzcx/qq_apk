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
import android.support.v4.view.u;
import android.support.v7.a.a.a;
import android.support.v7.widget.az;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;

public final class d
{
  private static final boolean oO;
  private static final Paint oP;
  private final TextPaint iW;
  private boolean oQ;
  float oR;
  private final Rect oS;
  private final Rect oT;
  private final RectF oU;
  int oV = 16;
  int oW = 16;
  float oX = 15.0F;
  private float oY = 15.0F;
  private ColorStateList oZ;
  private float pA;
  private int pB;
  private float pC;
  private float pD;
  private float pE;
  private int pF;
  ColorStateList pa;
  private float pb;
  private float pc;
  private float pd;
  private float pe;
  private float pg;
  private float ph;
  Typeface pi;
  Typeface pj;
  private Typeface pk;
  private CharSequence pl;
  private boolean pm;
  private boolean pn;
  private Bitmap po;
  private Paint pp;
  private float pq;
  private float pr;
  private float ps;
  private int[] pt;
  private boolean pu;
  private final TextPaint pv;
  TimeInterpolator pw;
  private TimeInterpolator px;
  private float py;
  private float pz;
  private float scale;
  CharSequence text;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      oO = bool;
      oP = null;
      return;
    }
  }
  
  public d(View paramView)
  {
    this.view = paramView;
    this.iW = new TextPaint(129);
    this.pv = new TextPaint(this.iW);
    this.oT = new Rect();
    this.oS = new Rect();
    this.oU = new RectF();
  }
  
  private Typeface Q(int paramInt)
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
    paramTextPaint.setTextSize(this.oY);
    paramTextPaint.setTypeface(this.pi);
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
    if (u.Z(this.view) == 1) {
      if (i == 0) {
        break label40;
      }
    }
    label40:
    for (android.support.v4.d.d locald = e.Ot;; locald = e.Os)
    {
      return locald.a(paramCharSequence, paramCharSequence.length());
      i = 0;
      break;
    }
  }
  
  private float ch()
  {
    if (this.text == null) {
      return 0.0F;
    }
    a(this.pv);
    return this.pv.measureText(this.text, 0, this.text.length());
  }
  
  private void cj()
  {
    if ((this.oT.width() > 0) && (this.oT.height() > 0) && (this.oS.width() > 0) && (this.oS.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.oQ = bool;
      return;
    }
  }
  
  private void ck()
  {
    l(this.oR);
  }
  
  private int cl()
  {
    if (this.pt != null) {
      return this.oZ.getColorForState(this.pt, 0);
    }
    return this.oZ.getDefaultColor();
  }
  
  private void cn()
  {
    int j = 1;
    float f2 = 0.0F;
    float f3 = this.ps;
    o(this.oY);
    float f1;
    int i;
    if (this.pl != null)
    {
      f1 = this.iW.measureText(this.pl, 0, this.pl.length());
      int k = this.oW;
      if (!this.pm) {
        break label383;
      }
      i = 1;
      label63:
      i = android.support.v4.view.d.getAbsoluteGravity(k, i);
      switch (i & 0x70)
      {
      default: 
        this.pc = ((this.iW.descent() - this.iW.ascent()) / 2.0F - this.iW.descent() + this.oT.centerY());
        label142:
        switch (i & 0x800007)
        {
        default: 
          this.pe = this.oT.left;
          label188:
          o(this.oX);
          f1 = f2;
          if (this.pl != null) {
            f1 = this.iW.measureText(this.pl, 0, this.pl.length());
          }
          k = this.oV;
          if (this.pm)
          {
            i = j;
            label244:
            i = android.support.v4.view.d.getAbsoluteGravity(k, i);
            switch (i & 0x70)
            {
            default: 
              this.pb = ((this.iW.descent() - this.iW.ascent()) / 2.0F - this.iW.descent() + this.oS.centerY());
              label322:
              switch (i & 0x800007)
              {
              default: 
                this.pd = this.oS.left;
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
      cq();
      n(f3);
      return;
      f1 = 0.0F;
      break;
      label383:
      i = 0;
      break label63;
      this.pc = this.oT.bottom;
      break label142;
      this.pc = (this.oT.top - this.iW.ascent());
      break label142;
      this.pe = (this.oT.centerX() - f1 / 2.0F);
      break label188;
      this.pe = (this.oT.right - f1);
      break label188;
      i = 0;
      break label244;
      this.pb = this.oS.bottom;
      break label322;
      this.pb = (this.oS.top - this.iW.ascent());
      break label322;
      this.pd = (this.oS.centerX() - f1 / 2.0F);
      continue;
      this.pd = (this.oS.right - f1);
    }
  }
  
  private void co()
  {
    if ((this.po != null) || (this.oS.isEmpty()) || (TextUtils.isEmpty(this.pl))) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        l(0.0F);
        this.pq = this.iW.ascent();
        this.pr = this.iW.descent();
        i = Math.round(this.iW.measureText(this.pl, 0, this.pl.length()));
        j = Math.round(this.pr - this.pq);
      } while ((i <= 0) || (j <= 0));
      this.po = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      new Canvas(this.po).drawText(this.pl, 0, this.pl.length(), 0.0F, j - this.iW.descent(), this.iW);
    } while (this.pp != null);
    this.pp = new Paint(3);
  }
  
  private void cq()
  {
    if (this.po != null)
    {
      this.po.recycle();
      this.po = null;
    }
  }
  
  private void l(float paramFloat)
  {
    m(paramFloat);
    this.pg = a(this.pd, this.pe, paramFloat, this.pw);
    this.ph = a(this.pb, this.pc, paramFloat, this.pw);
    n(a(this.oX, this.oY, paramFloat, this.px));
    if (this.pa != this.oZ) {
      this.iW.setColor(c(cl(), cm(), paramFloat));
    }
    for (;;)
    {
      this.iW.setShadowLayer(a(this.pC, this.py, paramFloat, null), a(this.pD, this.pz, paramFloat, null), a(this.pE, this.pA, paramFloat, null), c(this.pF, this.pB, paramFloat));
      u.X(this.view);
      return;
      this.iW.setColor(cm());
    }
  }
  
  private void m(float paramFloat)
  {
    this.oU.left = a(this.oS.left, this.oT.left, paramFloat, this.pw);
    this.oU.top = a(this.pb, this.pc, paramFloat, this.pw);
    this.oU.right = a(this.oS.right, this.oT.right, paramFloat, this.pw);
    this.oU.bottom = a(this.oS.bottom, this.oT.bottom, paramFloat, this.pw);
  }
  
  private void n(float paramFloat)
  {
    o(paramFloat);
    if ((oO) && (this.scale != 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      this.pn = bool;
      if (this.pn) {
        co();
      }
      u.X(this.view);
      return;
    }
  }
  
  private void o(float paramFloat)
  {
    boolean bool = true;
    if (this.text == null) {
      return;
    }
    float f2 = this.oT.width();
    float f3 = this.oS.width();
    float f1;
    int i;
    if (c(paramFloat, this.oY))
    {
      f1 = this.oY;
      this.scale = 1.0F;
      if (this.pk == this.pi) {
        break label339;
      }
      this.pk = this.pi;
      i = 1;
      paramFloat = f2;
    }
    for (;;)
    {
      int j = i;
      if (paramFloat > 0.0F)
      {
        if ((this.ps != f1) || (this.pu) || (i != 0))
        {
          i = 1;
          label109:
          this.ps = f1;
          this.pu = false;
          j = i;
        }
      }
      else
      {
        if ((this.pl != null) && (j == 0)) {
          break;
        }
        this.iW.setTextSize(this.ps);
        this.iW.setTypeface(this.pk);
        Object localObject = this.iW;
        if (this.scale == 1.0F) {
          break label327;
        }
        label173:
        ((TextPaint)localObject).setLinearText(bool);
        localObject = TextUtils.ellipsize(this.text, this.iW, paramFloat, TextUtils.TruncateAt.END);
        if (TextUtils.equals((CharSequence)localObject, this.pl)) {
          break;
        }
        this.pl = ((CharSequence)localObject);
        this.pm = c(this.pl);
        return;
        f1 = this.oX;
        if (this.pk == this.pj) {
          break label333;
        }
        this.pk = this.pj;
      }
      label315:
      label327:
      label333:
      for (i = 1;; i = 0)
      {
        if (c(paramFloat, this.oX)) {}
        for (this.scale = 1.0F;; this.scale = (paramFloat / this.oX))
        {
          paramFloat = this.oY / this.oX;
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
  
  public final void M(int paramInt)
  {
    if (this.oV != paramInt)
    {
      this.oV = paramInt;
      cp();
    }
  }
  
  public final void N(int paramInt)
  {
    if (this.oW != paramInt)
    {
      this.oW = paramInt;
      cp();
    }
  }
  
  public final void O(int paramInt)
  {
    az localaz = az.a(this.view.getContext(), paramInt, a.a.TextAppearance);
    if (localaz.hasValue(3)) {
      this.pa = localaz.getColorStateList(3);
    }
    if (localaz.hasValue(0)) {
      this.oY = localaz.getDimensionPixelSize(0, (int)this.oY);
    }
    this.pB = localaz.getInt(6, 0);
    this.pz = localaz.getFloat(7, 0.0F);
    this.pA = localaz.getFloat(8, 0.0F);
    this.py = localaz.getFloat(9, 0.0F);
    localaz.ayy.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.pi = Q(paramInt);
    }
    cp();
  }
  
  public final void P(int paramInt)
  {
    az localaz = az.a(this.view.getContext(), paramInt, a.a.TextAppearance);
    if (localaz.hasValue(3)) {
      this.oZ = localaz.getColorStateList(3);
    }
    if (localaz.hasValue(0)) {
      this.oX = localaz.getDimensionPixelSize(0, (int)this.oX);
    }
    this.pF = localaz.getInt(6, 0);
    this.pD = localaz.getFloat(7, 0.0F);
    this.pE = localaz.getFloat(8, 0.0F);
    this.pC = localaz.getFloat(9, 0.0F);
    localaz.ayy.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.pj = Q(paramInt);
    }
    cp();
  }
  
  public final void a(TimeInterpolator paramTimeInterpolator)
  {
    this.px = paramTimeInterpolator;
    cp();
  }
  
  public final void a(RectF paramRectF)
  {
    boolean bool = c(this.text);
    if (!bool)
    {
      f = this.oT.left;
      paramRectF.left = f;
      paramRectF.top = this.oT.top;
      if (bool) {
        break label93;
      }
    }
    label93:
    for (float f = paramRectF.left + ch();; f = this.oT.right)
    {
      paramRectF.right = f;
      paramRectF.bottom = (this.oT.top + ci());
      return;
      f = this.oT.right - ch();
      break;
    }
  }
  
  public final void b(Typeface paramTypeface)
  {
    this.pj = paramTypeface;
    this.pi = paramTypeface;
    cp();
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.oS, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.oS.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.pu = true;
      cj();
    }
  }
  
  public final float ci()
  {
    a(this.pv);
    return -this.pv.ascent();
  }
  
  public final int cm()
  {
    if (this.pt != null) {
      return this.pa.getColorForState(this.pt, 0);
    }
    return this.pa.getDefaultColor();
  }
  
  public final void cp()
  {
    if ((this.view.getHeight() > 0) && (this.view.getWidth() > 0))
    {
      cn();
      ck();
    }
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.oT, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.oT.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.pu = true;
      cj();
    }
  }
  
  public final void d(ColorStateList paramColorStateList)
  {
    if (this.pa != paramColorStateList)
    {
      this.pa = paramColorStateList;
      cp();
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
    if ((this.pl != null) && (this.oQ))
    {
      f4 = this.pg;
      float f3 = this.ph;
      if ((!this.pn) || (this.po == null)) {
        break label128;
      }
      i = 1;
      if (i == 0) {
        break label134;
      }
      f1 = this.pq * this.scale;
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
      paramCanvas.drawBitmap(this.po, f4, f2, this.pp);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      return;
      label128:
      i = 0;
      break;
      label134:
      this.iW.ascent();
      f1 = 0.0F;
      this.iW.descent();
      break label64;
      label155:
      paramCanvas.drawText(this.pl, 0, this.pl.length(), f4, f2, this.iW);
    }
  }
  
  public final void e(ColorStateList paramColorStateList)
  {
    if (this.oZ != paramColorStateList)
    {
      this.oZ = paramColorStateList;
      cp();
    }
  }
  
  public final void k(float paramFloat)
  {
    paramFloat = android.support.v4.b.a.j(paramFloat, 1.0F);
    if (paramFloat != this.oR)
    {
      this.oR = paramFloat;
      ck();
    }
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    this.pt = paramArrayOfInt;
    if (((this.pa != null) && (this.pa.isStateful())) || ((this.oZ != null) && (this.oZ.isStateful()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      cp();
      return true;
    }
    return false;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.text)))
    {
      this.text = paramCharSequence;
      this.pl = null;
      cq();
      cp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.d
 * JD-Core Version:    0.7.0.1
 */