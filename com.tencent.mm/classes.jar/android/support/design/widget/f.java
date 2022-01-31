package android.support.design.widget;

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
import android.support.v4.d.c;
import android.support.v4.view.t;
import android.support.v7.a.a.a;
import android.support.v7.widget.az;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class f
{
  private static final boolean gW;
  private static final Paint gX;
  private boolean gY;
  float gZ;
  private boolean hA;
  private final TextPaint hB;
  Interpolator hC;
  private Interpolator hD;
  private float hE;
  private float hF;
  private float hG;
  private int hH;
  private float hI;
  private float hJ;
  private float hK;
  private int hL;
  private final Rect ha;
  private final Rect hb;
  private final RectF hc;
  int hd = 16;
  int he = 16;
  float hf = 15.0F;
  float hg = 15.0F;
  private ColorStateList hh;
  ColorStateList hi;
  private float hj;
  private float hk;
  private float hl;
  private float hm;
  private float hn;
  private float ho;
  Typeface hp;
  Typeface hq;
  private Typeface hr;
  private CharSequence hs;
  private boolean ht;
  private Bitmap hu;
  private Paint hv;
  private float hw;
  private float hx;
  private float hy;
  private int[] hz;
  private boolean mIsRtl;
  private float mScale;
  CharSequence mText;
  private final View mView;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      gW = bool;
      gX = null;
      return;
    }
  }
  
  public f(View paramView)
  {
    this.mView = paramView;
    this.hB = new TextPaint(129);
    this.hb = new Rect();
    this.ha = new Rect();
    this.hc = new RectF();
  }
  
  private Typeface C(int paramInt)
  {
    TypedArray localTypedArray = this.mView.getContext().obtainStyledAttributes(paramInt, new int[] { 16843692 });
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
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, Interpolator paramInterpolator)
  {
    float f = paramFloat3;
    if (paramInterpolator != null) {
      f = paramInterpolator.getInterpolation(paramFloat3);
    }
    return a.b(paramFloat1, paramFloat2, f);
  }
  
  private static boolean a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  static boolean a(Typeface paramTypeface1, Typeface paramTypeface2)
  {
    return ((paramTypeface1 != null) && (!paramTypeface1.equals(paramTypeface2))) || ((paramTypeface1 == null) && (paramTypeface2 != null));
  }
  
  private void aZ()
  {
    if ((this.hb.width() > 0) && (this.hb.height() > 0) && (this.ha.width() > 0) && (this.ha.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.gY = bool;
      return;
    }
  }
  
  private boolean b(CharSequence paramCharSequence)
  {
    int i = 1;
    if (t.T(this.mView) == 1) {
      if (i == 0) {
        break label40;
      }
    }
    label40:
    for (c localc = android.support.v4.d.d.Ev;; localc = android.support.v4.d.d.Eu)
    {
      return localc.a(paramCharSequence, paramCharSequence.length());
      i = 0;
      break;
    }
  }
  
  private void bb()
  {
    i(this.gZ);
  }
  
  private int bc()
  {
    if (this.hz != null) {
      return this.hh.getColorForState(this.hz, 0);
    }
    return this.hh.getDefaultColor();
  }
  
  private int bd()
  {
    if (this.hz != null) {
      return this.hi.getColorForState(this.hz, 0);
    }
    return this.hi.getDefaultColor();
  }
  
  private void bf()
  {
    int j = 1;
    float f2 = 0.0F;
    float f3 = this.hy;
    l(this.hg);
    float f1;
    int i;
    if (this.hs != null)
    {
      f1 = this.hB.measureText(this.hs, 0, this.hs.length());
      int k = this.he;
      if (!this.mIsRtl) {
        break label383;
      }
      i = 1;
      label63:
      i = android.support.v4.view.d.getAbsoluteGravity(k, i);
      switch (i & 0x70)
      {
      default: 
        this.hk = ((this.hB.descent() - this.hB.ascent()) / 2.0F - this.hB.descent() + this.hb.centerY());
        label142:
        switch (i & 0x800007)
        {
        default: 
          this.hm = this.hb.left;
          label188:
          l(this.hf);
          f1 = f2;
          if (this.hs != null) {
            f1 = this.hB.measureText(this.hs, 0, this.hs.length());
          }
          k = this.hd;
          if (this.mIsRtl)
          {
            i = j;
            label244:
            i = android.support.v4.view.d.getAbsoluteGravity(k, i);
            switch (i & 0x70)
            {
            default: 
              this.hj = ((this.hB.descent() - this.hB.ascent()) / 2.0F - this.hB.descent() + this.ha.centerY());
              label322:
              switch (i & 0x800007)
              {
              default: 
                this.hl = this.ha.left;
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
      bi();
      k(f3);
      return;
      f1 = 0.0F;
      break;
      label383:
      i = 0;
      break label63;
      this.hk = this.hb.bottom;
      break label142;
      this.hk = (this.hb.top - this.hB.ascent());
      break label142;
      this.hm = (this.hb.centerX() - f1 / 2.0F);
      break label188;
      this.hm = (this.hb.right - f1);
      break label188;
      i = 0;
      break label244;
      this.hj = this.ha.bottom;
      break label322;
      this.hj = (this.ha.top - this.hB.ascent());
      break label322;
      this.hl = (this.ha.centerX() - f1 / 2.0F);
      continue;
      this.hl = (this.ha.right - f1);
    }
  }
  
  private void bg()
  {
    if ((this.hu != null) || (this.ha.isEmpty()) || (TextUtils.isEmpty(this.hs))) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        i(0.0F);
        this.hw = this.hB.ascent();
        this.hx = this.hB.descent();
        i = Math.round(this.hB.measureText(this.hs, 0, this.hs.length()));
        j = Math.round(this.hx - this.hw);
      } while ((i <= 0) || (j <= 0));
      this.hu = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      new Canvas(this.hu).drawText(this.hs, 0, this.hs.length(), 0.0F, j - this.hB.descent(), this.hB);
    } while (this.hv != null);
    this.hv = new Paint(3);
  }
  
  private void bi()
  {
    if (this.hu != null)
    {
      this.hu.recycle();
      this.hu = null;
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
  
  private void i(float paramFloat)
  {
    j(paramFloat);
    this.hn = a(this.hl, this.hm, paramFloat, this.hC);
    this.ho = a(this.hj, this.hk, paramFloat, this.hC);
    k(a(this.hf, this.hg, paramFloat, this.hD));
    if (this.hi != this.hh) {
      this.hB.setColor(c(bc(), bd(), paramFloat));
    }
    for (;;)
    {
      this.hB.setShadowLayer(a(this.hI, this.hE, paramFloat, null), a(this.hJ, this.hF, paramFloat, null), a(this.hK, this.hG, paramFloat, null), c(this.hL, this.hH, paramFloat));
      t.R(this.mView);
      return;
      this.hB.setColor(bd());
    }
  }
  
  private void j(float paramFloat)
  {
    this.hc.left = a(this.ha.left, this.hb.left, paramFloat, this.hC);
    this.hc.top = a(this.hj, this.hk, paramFloat, this.hC);
    this.hc.right = a(this.ha.right, this.hb.right, paramFloat, this.hC);
    this.hc.bottom = a(this.ha.bottom, this.hb.bottom, paramFloat, this.hC);
  }
  
  private void k(float paramFloat)
  {
    l(paramFloat);
    if ((gW) && (this.mScale != 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ht = bool;
      if (this.ht) {
        bg();
      }
      t.R(this.mView);
      return;
    }
  }
  
  private void l(float paramFloat)
  {
    boolean bool = true;
    if (this.mText == null) {
      return;
    }
    float f2 = this.hb.width();
    float f3 = this.ha.width();
    float f1;
    int i;
    if (n(paramFloat, this.hg))
    {
      f1 = this.hg;
      this.mScale = 1.0F;
      if (!a(this.hr, this.hp)) {
        break label345;
      }
      this.hr = this.hp;
      i = 1;
      paramFloat = f2;
    }
    for (;;)
    {
      int j = i;
      if (paramFloat > 0.0F)
      {
        if ((this.hy != f1) || (this.hA) || (i != 0))
        {
          i = 1;
          label112:
          this.hy = f1;
          this.hA = false;
          j = i;
        }
      }
      else
      {
        if ((this.hs != null) && (j == 0)) {
          break;
        }
        this.hB.setTextSize(this.hy);
        this.hB.setTypeface(this.hr);
        Object localObject = this.hB;
        if (this.mScale == 1.0F) {
          break label333;
        }
        label176:
        ((TextPaint)localObject).setLinearText(bool);
        localObject = TextUtils.ellipsize(this.mText, this.hB, paramFloat, TextUtils.TruncateAt.END);
        if (TextUtils.equals((CharSequence)localObject, this.hs)) {
          break;
        }
        this.hs = ((CharSequence)localObject);
        this.mIsRtl = b(this.hs);
        return;
        f1 = this.hf;
        if (!a(this.hr, this.hq)) {
          break label339;
        }
        this.hr = this.hq;
      }
      label321:
      label333:
      label339:
      for (i = 1;; i = 0)
      {
        if (n(paramFloat, this.hf)) {}
        for (this.mScale = 1.0F;; this.mScale = (paramFloat / this.hf))
        {
          paramFloat = this.hg / this.hf;
          if (f3 * paramFloat <= f2) {
            break label321;
          }
          paramFloat = Math.min(f2 / paramFloat, f3);
          break;
        }
        paramFloat = f3;
        break;
        i = 0;
        break label112;
        bool = false;
        break label176;
      }
      label345:
      i = 0;
      paramFloat = f2;
    }
  }
  
  private static boolean n(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }
  
  final void A(int paramInt)
  {
    az localaz = az.a(this.mView.getContext(), paramInt, a.a.TextAppearance);
    if (localaz.hasValue(3)) {
      this.hi = localaz.getColorStateList(3);
    }
    if (localaz.hasValue(0)) {
      this.hg = localaz.getDimensionPixelSize(0, (int)this.hg);
    }
    this.hH = localaz.getInt(6, 0);
    this.hF = localaz.getFloat(7, 0.0F);
    this.hG = localaz.getFloat(8, 0.0F);
    this.hE = localaz.getFloat(9, 0.0F);
    localaz.aoo.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.hp = C(paramInt);
    }
    bh();
  }
  
  final void B(int paramInt)
  {
    az localaz = az.a(this.mView.getContext(), paramInt, a.a.TextAppearance);
    if (localaz.hasValue(3)) {
      this.hh = localaz.getColorStateList(3);
    }
    if (localaz.hasValue(0)) {
      this.hf = localaz.getDimensionPixelSize(0, (int)this.hf);
    }
    this.hL = localaz.getInt(6, 0);
    this.hJ = localaz.getFloat(7, 0.0F);
    this.hK = localaz.getFloat(8, 0.0F);
    this.hI = localaz.getFloat(9, 0.0F);
    localaz.aoo.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.hq = C(paramInt);
    }
    bh();
  }
  
  final void a(Typeface paramTypeface)
  {
    this.hq = paramTypeface;
    this.hp = paramTypeface;
    bh();
  }
  
  final void b(ColorStateList paramColorStateList)
  {
    if (this.hi != paramColorStateList)
    {
      this.hi = paramColorStateList;
      bh();
    }
  }
  
  final void b(Interpolator paramInterpolator)
  {
    this.hD = paramInterpolator;
    bh();
  }
  
  final Typeface ba()
  {
    if (this.hp != null) {
      return this.hp;
    }
    return Typeface.DEFAULT;
  }
  
  public final void bh()
  {
    if ((this.mView.getHeight() > 0) && (this.mView.getWidth() > 0))
    {
      bf();
      bb();
    }
  }
  
  final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.ha, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.ha.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.hA = true;
      aZ();
    }
  }
  
  final void c(ColorStateList paramColorStateList)
  {
    if (this.hh != paramColorStateList)
    {
      this.hh = paramColorStateList;
      bh();
    }
  }
  
  final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.hb, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.hb.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.hA = true;
      aZ();
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
    if ((this.hs != null) && (this.gY))
    {
      f4 = this.hn;
      float f3 = this.ho;
      if ((!this.ht) || (this.hu == null)) {
        break label128;
      }
      i = 1;
      if (i == 0) {
        break label134;
      }
      f1 = this.hw * this.mScale;
      f2 = f3;
      if (i != 0) {
        f2 = f3 + f1;
      }
      if (this.mScale != 1.0F) {
        paramCanvas.scale(this.mScale, this.mScale, f4, f2);
      }
      if (i == 0) {
        break label155;
      }
      paramCanvas.drawBitmap(this.hu, f4, f2, this.hv);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      return;
      label128:
      i = 0;
      break;
      label134:
      this.hB.ascent();
      f1 = 0.0F;
      this.hB.descent();
      break label64;
      label155:
      paramCanvas.drawText(this.hs, 0, this.hs.length(), f4, f2, this.hB);
    }
  }
  
  final void h(float paramFloat)
  {
    float f;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    for (;;)
    {
      if (f != this.gZ)
      {
        this.gZ = f;
        bb();
      }
      return;
      f = paramFloat;
      if (paramFloat > 1.0F) {
        f = 1.0F;
      }
    }
  }
  
  final boolean setState(int[] paramArrayOfInt)
  {
    this.hz = paramArrayOfInt;
    if (((this.hi != null) && (this.hi.isStateful())) || ((this.hh != null) && (this.hh.isStateful()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      bh();
      return true;
    }
    return false;
  }
  
  final void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.mText)))
    {
      this.mText = paramCharSequence;
      this.hs = null;
      bi();
      bh();
    }
  }
  
  final void y(int paramInt)
  {
    if (this.hd != paramInt)
    {
      this.hd = paramInt;
      bh();
    }
  }
  
  final void z(int paramInt)
  {
    if (this.he != paramInt)
    {
      this.he = paramInt;
      bh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.f
 * JD-Core Version:    0.7.0.1
 */