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
  private static final boolean lR;
  private static final Paint lS;
  private final TextPaint ga;
  private boolean lT;
  float lU;
  private final Rect lV;
  private final Rect lW;
  private final RectF lX;
  int lY = 16;
  int lZ = 16;
  private float mA;
  private float mB;
  private float mC;
  private int mD;
  private float mE;
  private float mF;
  private float mG;
  private int mH;
  float ma = 15.0F;
  private float mb = 15.0F;
  private ColorStateList mc;
  ColorStateList md;
  private float me;
  private float mf;
  private float mg;
  private float mh;
  private float mi;
  private float mj;
  Typeface mk;
  Typeface ml;
  private Typeface mm;
  private CharSequence mn;
  private boolean mo;
  private boolean mp;
  private Bitmap mq;
  private Paint mr;
  private float ms;
  private float mt;
  private float mu;
  private int[] mv;
  private boolean mw;
  private final TextPaint mx;
  TimeInterpolator my;
  private TimeInterpolator mz;
  private float scale;
  CharSequence text;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      lR = bool;
      lS = null;
      return;
    }
  }
  
  public d(View paramView)
  {
    this.view = paramView;
    this.ga = new TextPaint(129);
    this.mx = new TextPaint(this.ga);
    this.lW = new Rect();
    this.lV = new Rect();
    this.lX = new RectF();
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
    paramTextPaint.setTextSize(this.mb);
    paramTextPaint.setTypeface(this.mk);
  }
  
  private static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  private float bI()
  {
    if (this.text == null) {
      return 0.0F;
    }
    a(this.mx);
    return this.mx.measureText(this.text, 0, this.text.length());
  }
  
  private void bK()
  {
    if ((this.lW.width() > 0) && (this.lW.height() > 0) && (this.lV.width() > 0) && (this.lV.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.lT = bool;
      return;
    }
  }
  
  private void bL()
  {
    j(this.lU);
  }
  
  private int bM()
  {
    if (this.mv != null) {
      return this.mc.getColorForState(this.mv, 0);
    }
    return this.mc.getDefaultColor();
  }
  
  private void bO()
  {
    int j = 1;
    float f2 = 0.0F;
    float f3 = this.mu;
    m(this.mb);
    float f1;
    int i;
    if (this.mn != null)
    {
      f1 = this.ga.measureText(this.mn, 0, this.mn.length());
      int k = this.lZ;
      if (!this.mo) {
        break label383;
      }
      i = 1;
      label63:
      i = android.support.v4.view.d.getAbsoluteGravity(k, i);
      switch (i & 0x70)
      {
      default: 
        this.mf = ((this.ga.descent() - this.ga.ascent()) / 2.0F - this.ga.descent() + this.lW.centerY());
        label142:
        switch (i & 0x800007)
        {
        default: 
          this.mh = this.lW.left;
          label188:
          m(this.ma);
          f1 = f2;
          if (this.mn != null) {
            f1 = this.ga.measureText(this.mn, 0, this.mn.length());
          }
          k = this.lY;
          if (this.mo)
          {
            i = j;
            label244:
            i = android.support.v4.view.d.getAbsoluteGravity(k, i);
            switch (i & 0x70)
            {
            default: 
              this.me = ((this.ga.descent() - this.ga.ascent()) / 2.0F - this.ga.descent() + this.lV.centerY());
              label322:
              switch (i & 0x800007)
              {
              default: 
                this.mg = this.lV.left;
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
      bR();
      l(f3);
      return;
      f1 = 0.0F;
      break;
      label383:
      i = 0;
      break label63;
      this.mf = this.lW.bottom;
      break label142;
      this.mf = (this.lW.top - this.ga.ascent());
      break label142;
      this.mh = (this.lW.centerX() - f1 / 2.0F);
      break label188;
      this.mh = (this.lW.right - f1);
      break label188;
      i = 0;
      break label244;
      this.me = this.lV.bottom;
      break label322;
      this.me = (this.lV.top - this.ga.ascent());
      break label322;
      this.mg = (this.lV.centerX() - f1 / 2.0F);
      continue;
      this.mg = (this.lV.right - f1);
    }
  }
  
  private void bP()
  {
    if ((this.mq != null) || (this.lV.isEmpty()) || (TextUtils.isEmpty(this.mn))) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        j(0.0F);
        this.ms = this.ga.ascent();
        this.mt = this.ga.descent();
        i = Math.round(this.ga.measureText(this.mn, 0, this.mn.length()));
        j = Math.round(this.mt - this.ms);
      } while ((i <= 0) || (j <= 0));
      this.mq = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      new Canvas(this.mq).drawText(this.mn, 0, this.mn.length(), 0.0F, j - this.ga.descent(), this.ga);
    } while (this.mr != null);
    this.mr = new Paint(3);
  }
  
  private void bR()
  {
    if (this.mq != null)
    {
      this.mq.recycle();
      this.mq = null;
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
    for (android.support.v4.d.d locald = e.Lu;; locald = e.Lt)
    {
      return locald.a(paramCharSequence, paramCharSequence.length());
      i = 0;
      break;
    }
  }
  
  private void j(float paramFloat)
  {
    k(paramFloat);
    this.mi = a(this.mg, this.mh, paramFloat, this.my);
    this.mj = a(this.me, this.mf, paramFloat, this.my);
    l(a(this.ma, this.mb, paramFloat, this.mz));
    if (this.md != this.mc) {
      this.ga.setColor(c(bM(), bN(), paramFloat));
    }
    for (;;)
    {
      this.ga.setShadowLayer(a(this.mE, this.mA, paramFloat, null), a(this.mF, this.mB, paramFloat, null), a(this.mG, this.mC, paramFloat, null), c(this.mH, this.mD, paramFloat));
      t.W(this.view);
      return;
      this.ga.setColor(bN());
    }
  }
  
  private void k(float paramFloat)
  {
    this.lX.left = a(this.lV.left, this.lW.left, paramFloat, this.my);
    this.lX.top = a(this.me, this.mf, paramFloat, this.my);
    this.lX.right = a(this.lV.right, this.lW.right, paramFloat, this.my);
    this.lX.bottom = a(this.lV.bottom, this.lW.bottom, paramFloat, this.my);
  }
  
  private void l(float paramFloat)
  {
    m(paramFloat);
    if ((lR) && (this.scale != 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mp = bool;
      if (this.mp) {
        bP();
      }
      t.W(this.view);
      return;
    }
  }
  
  private void m(float paramFloat)
  {
    boolean bool = true;
    if (this.text == null) {
      return;
    }
    float f2 = this.lW.width();
    float f3 = this.lV.width();
    float f1;
    int i;
    if (c(paramFloat, this.mb))
    {
      f1 = this.mb;
      this.scale = 1.0F;
      if (this.mm == this.mk) {
        break label339;
      }
      this.mm = this.mk;
      i = 1;
      paramFloat = f2;
    }
    for (;;)
    {
      int j = i;
      if (paramFloat > 0.0F)
      {
        if ((this.mu != f1) || (this.mw) || (i != 0))
        {
          i = 1;
          label109:
          this.mu = f1;
          this.mw = false;
          j = i;
        }
      }
      else
      {
        if ((this.mn != null) && (j == 0)) {
          break;
        }
        this.ga.setTextSize(this.mu);
        this.ga.setTypeface(this.mm);
        Object localObject = this.ga;
        if (this.scale == 1.0F) {
          break label327;
        }
        label173:
        ((TextPaint)localObject).setLinearText(bool);
        localObject = TextUtils.ellipsize(this.text, this.ga, paramFloat, TextUtils.TruncateAt.END);
        if (TextUtils.equals((CharSequence)localObject, this.mn)) {
          break;
        }
        this.mn = ((CharSequence)localObject);
        this.mo = c(this.mn);
        return;
        f1 = this.ma;
        if (this.mm == this.ml) {
          break label333;
        }
        this.mm = this.ml;
      }
      label315:
      label327:
      label333:
      for (i = 1;; i = 0)
      {
        if (c(paramFloat, this.ma)) {}
        for (this.scale = 1.0F;; this.scale = (paramFloat / this.ma))
        {
          paramFloat = this.mb / this.ma;
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
    if (this.lY != paramInt)
    {
      this.lY = paramInt;
      bQ();
    }
  }
  
  public final void P(int paramInt)
  {
    if (this.lZ != paramInt)
    {
      this.lZ = paramInt;
      bQ();
    }
  }
  
  public final void Q(int paramInt)
  {
    az localaz = az.a(this.view.getContext(), paramInt, a.a.TextAppearance);
    if (localaz.hasValue(3)) {
      this.md = localaz.getColorStateList(3);
    }
    if (localaz.hasValue(0)) {
      this.mb = localaz.getDimensionPixelSize(0, (int)this.mb);
    }
    this.mD = localaz.getInt(6, 0);
    this.mB = localaz.getFloat(7, 0.0F);
    this.mC = localaz.getFloat(8, 0.0F);
    this.mA = localaz.getFloat(9, 0.0F);
    localaz.avP.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.mk = S(paramInt);
    }
    bQ();
  }
  
  public final void R(int paramInt)
  {
    az localaz = az.a(this.view.getContext(), paramInt, a.a.TextAppearance);
    if (localaz.hasValue(3)) {
      this.mc = localaz.getColorStateList(3);
    }
    if (localaz.hasValue(0)) {
      this.ma = localaz.getDimensionPixelSize(0, (int)this.ma);
    }
    this.mH = localaz.getInt(6, 0);
    this.mF = localaz.getFloat(7, 0.0F);
    this.mG = localaz.getFloat(8, 0.0F);
    this.mE = localaz.getFloat(9, 0.0F);
    localaz.avP.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.ml = S(paramInt);
    }
    bQ();
  }
  
  public final void a(TimeInterpolator paramTimeInterpolator)
  {
    this.mz = paramTimeInterpolator;
    bQ();
  }
  
  public final void a(RectF paramRectF)
  {
    boolean bool = c(this.text);
    if (!bool)
    {
      f = this.lW.left;
      paramRectF.left = f;
      paramRectF.top = this.lW.top;
      if (bool) {
        break label93;
      }
    }
    label93:
    for (float f = paramRectF.left + bI();; f = this.lW.right)
    {
      paramRectF.right = f;
      paramRectF.bottom = (this.lW.top + bJ());
      return;
      f = this.lW.right - bI();
      break;
    }
  }
  
  public final void b(Typeface paramTypeface)
  {
    this.ml = paramTypeface;
    this.mk = paramTypeface;
    bQ();
  }
  
  public final float bJ()
  {
    a(this.mx);
    return -this.mx.ascent();
  }
  
  public final int bN()
  {
    if (this.mv != null) {
      return this.md.getColorForState(this.mv, 0);
    }
    return this.md.getDefaultColor();
  }
  
  public final void bQ()
  {
    if ((this.view.getHeight() > 0) && (this.view.getWidth() > 0))
    {
      bO();
      bL();
    }
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.lV, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.lV.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.mw = true;
      bK();
    }
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.lW, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.lW.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.mw = true;
      bK();
    }
  }
  
  public final void d(ColorStateList paramColorStateList)
  {
    if (this.md != paramColorStateList)
    {
      this.md = paramColorStateList;
      bQ();
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
    if ((this.mn != null) && (this.lT))
    {
      f4 = this.mi;
      float f3 = this.mj;
      if ((!this.mp) || (this.mq == null)) {
        break label128;
      }
      i = 1;
      if (i == 0) {
        break label134;
      }
      f1 = this.ms * this.scale;
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
      paramCanvas.drawBitmap(this.mq, f4, f2, this.mr);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      return;
      label128:
      i = 0;
      break;
      label134:
      this.ga.ascent();
      f1 = 0.0F;
      this.ga.descent();
      break label64;
      label155:
      paramCanvas.drawText(this.mn, 0, this.mn.length(), f4, f2, this.ga);
    }
  }
  
  public final void e(ColorStateList paramColorStateList)
  {
    if (this.mc != paramColorStateList)
    {
      this.mc = paramColorStateList;
      bQ();
    }
  }
  
  public final void i(float paramFloat)
  {
    paramFloat = android.support.v4.b.a.j(paramFloat, 1.0F);
    if (paramFloat != this.lU)
    {
      this.lU = paramFloat;
      bL();
    }
  }
  
  public final boolean setState(int[] paramArrayOfInt)
  {
    this.mv = paramArrayOfInt;
    if (((this.md != null) && (this.md.isStateful())) || ((this.mc != null) && (this.mc.isStateful()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      bQ();
      return true;
    }
    return false;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.text)))
    {
      this.text = paramCharSequence;
      this.mn = null;
      bR();
      bQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.d
 * JD-Core Version:    0.7.0.1
 */