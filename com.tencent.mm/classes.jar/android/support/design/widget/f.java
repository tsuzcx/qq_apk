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
import android.support.v4.e.b;
import android.support.v4.e.c;
import android.support.v4.view.d;
import android.support.v4.view.q;
import android.support.v7.a.a.j;
import android.support.v7.widget.ax;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class f
{
  private static final boolean gc;
  private static final Paint gd;
  private boolean gA;
  private Bitmap gB;
  private Paint gC;
  private float gD;
  private float gE;
  private float gF;
  private int[] gG;
  private boolean gH;
  private final TextPaint gI;
  Interpolator gJ;
  private Interpolator gK;
  private float gL;
  private float gM;
  private float gN;
  private int gO;
  private float gP;
  private float gQ;
  private float gR;
  private int gS;
  private boolean ge;
  float gf;
  private final Rect gg;
  private final Rect gh;
  private final RectF gi;
  int gj = 16;
  int gk = 16;
  float gl = 15.0F;
  float gm = 15.0F;
  private ColorStateList gn;
  ColorStateList go;
  private float gp;
  private float gq;
  private float gr;
  private float gs;
  private float gt;
  private float gu;
  Typeface gv;
  Typeface gw;
  private Typeface gx;
  private CharSequence gy;
  private boolean gz;
  private float mScale;
  CharSequence mText;
  private final View mView;
  
  static
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = true;; bool = false)
    {
      gc = bool;
      gd = null;
      return;
    }
  }
  
  public f(View paramView)
  {
    this.mView = paramView;
    this.gI = new TextPaint(129);
    this.gh = new Rect();
    this.gg = new Rect();
    this.gi = new RectF();
  }
  
  private Typeface D(int paramInt)
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
  
  private void aA()
  {
    if (this.gB != null)
    {
      this.gB.recycle();
      this.gB = null;
    }
  }
  
  private void av()
  {
    if ((this.gh.width() > 0) && (this.gh.height() > 0) && (this.gg.width() > 0) && (this.gg.height() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ge = bool;
      return;
    }
  }
  
  private void ax()
  {
    i(this.gf);
  }
  
  private int ay()
  {
    if (this.gG != null) {
      return this.go.getColorForState(this.gG, 0);
    }
    return this.go.getDefaultColor();
  }
  
  private static int b(int paramInt1, int paramInt2, float paramFloat)
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
    this.gi.left = a(this.gg.left, this.gh.left, paramFloat, this.gJ);
    this.gi.top = a(this.gp, this.gq, paramFloat, this.gJ);
    this.gi.right = a(this.gg.right, this.gh.right, paramFloat, this.gJ);
    this.gi.bottom = a(this.gg.bottom, this.gh.bottom, paramFloat, this.gJ);
    this.gt = a(this.gr, this.gs, paramFloat, this.gJ);
    this.gu = a(this.gp, this.gq, paramFloat, this.gJ);
    j(a(this.gl, this.gm, paramFloat, this.gK));
    int i;
    if (this.go != this.gn)
    {
      TextPaint localTextPaint = this.gI;
      if (this.gG != null)
      {
        i = this.gn.getColorForState(this.gG, 0);
        localTextPaint.setColor(b(i, ay(), paramFloat));
      }
    }
    for (;;)
    {
      this.gI.setShadowLayer(a(this.gP, this.gL, paramFloat, null), a(this.gQ, this.gM, paramFloat, null), a(this.gR, this.gN, paramFloat, null), b(this.gS, this.gO, paramFloat));
      q.O(this.mView);
      return;
      i = this.gn.getDefaultColor();
      break;
      this.gI.setColor(ay());
    }
  }
  
  private void j(float paramFloat)
  {
    k(paramFloat);
    boolean bool;
    if ((gc) && (this.mScale != 1.0F))
    {
      bool = true;
      this.gA = bool;
      if ((this.gA) && (this.gB == null) && (!this.gg.isEmpty()) && (!TextUtils.isEmpty(this.gy))) {
        break label77;
      }
    }
    for (;;)
    {
      q.O(this.mView);
      return;
      bool = false;
      break;
      label77:
      i(0.0F);
      this.gD = this.gI.ascent();
      this.gE = this.gI.descent();
      int i = Math.round(this.gI.measureText(this.gy, 0, this.gy.length()));
      int j = Math.round(this.gE - this.gD);
      if ((i > 0) && (j > 0))
      {
        this.gB = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        new Canvas(this.gB).drawText(this.gy, 0, this.gy.length(), 0.0F, j - this.gI.descent(), this.gI);
        if (this.gC == null) {
          this.gC = new Paint(3);
        }
      }
    }
  }
  
  private void k(float paramFloat)
  {
    int k = 1;
    if (this.mText == null) {
      return;
    }
    float f2 = this.gh.width();
    float f3 = this.gg.width();
    float f1;
    int i;
    if (n(paramFloat, this.gm))
    {
      f1 = this.gm;
      this.mScale = 1.0F;
      if (!a(this.gx, this.gv)) {
        break label401;
      }
      this.gx = this.gv;
      i = 1;
      paramFloat = f2;
    }
    for (;;)
    {
      int j = i;
      label112:
      Object localObject;
      boolean bool;
      if (paramFloat > 0.0F)
      {
        if ((this.gF != f1) || (this.gH) || (i != 0))
        {
          i = 1;
          this.gF = f1;
          this.gH = false;
          j = i;
        }
      }
      else
      {
        if ((this.gy != null) && (j == 0)) {
          break;
        }
        this.gI.setTextSize(this.gF);
        this.gI.setTypeface(this.gx);
        localObject = this.gI;
        if (this.mScale == 1.0F) {
          break label375;
        }
        bool = true;
        label179:
        ((TextPaint)localObject).setLinearText(bool);
        localObject = TextUtils.ellipsize(this.mText, this.gI, paramFloat, TextUtils.TruncateAt.END);
        if (TextUtils.equals((CharSequence)localObject, this.gy)) {
          break;
        }
        this.gy = ((CharSequence)localObject);
        CharSequence localCharSequence = this.gy;
        if (q.Q(this.mView) != 1) {
          break label381;
        }
        i = k;
        label242:
        if (i == 0) {
          break label387;
        }
        localObject = c.DG;
        label252:
        this.gz = ((b)localObject).a(localCharSequence, localCharSequence.length());
        return;
        f1 = this.gl;
        if (!a(this.gx, this.gw)) {
          break label395;
        }
        this.gx = this.gw;
      }
      label387:
      label395:
      for (i = 1;; i = 0)
      {
        if (n(paramFloat, this.gl)) {}
        for (this.mScale = 1.0F;; this.mScale = (paramFloat / this.gl))
        {
          paramFloat = this.gm / this.gl;
          if (f3 * paramFloat <= f2) {
            break label363;
          }
          paramFloat = Math.min(f2 / paramFloat, f3);
          break;
        }
        label363:
        paramFloat = f3;
        break;
        i = 0;
        break label112;
        label375:
        bool = false;
        break label179;
        label381:
        i = 0;
        break label242;
        localObject = c.DF;
        break label252;
      }
      label401:
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
    if (this.gk != paramInt)
    {
      this.gk = paramInt;
      az();
    }
  }
  
  final void B(int paramInt)
  {
    ax localax = ax.a(this.mView.getContext(), paramInt, a.j.TextAppearance);
    if (localax.hasValue(a.j.TextAppearance_android_textColor)) {
      this.go = localax.getColorStateList(a.j.TextAppearance_android_textColor);
    }
    if (localax.hasValue(a.j.TextAppearance_android_textSize)) {
      this.gm = localax.getDimensionPixelSize(a.j.TextAppearance_android_textSize, (int)this.gm);
    }
    this.gO = localax.getInt(a.j.TextAppearance_android_shadowColor, 0);
    this.gM = localax.getFloat(a.j.TextAppearance_android_shadowDx, 0.0F);
    this.gN = localax.getFloat(a.j.TextAppearance_android_shadowDy, 0.0F);
    this.gL = localax.getFloat(a.j.TextAppearance_android_shadowRadius, 0.0F);
    localax.alZ.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.gv = D(paramInt);
    }
    az();
  }
  
  final void C(int paramInt)
  {
    ax localax = ax.a(this.mView.getContext(), paramInt, a.j.TextAppearance);
    if (localax.hasValue(a.j.TextAppearance_android_textColor)) {
      this.gn = localax.getColorStateList(a.j.TextAppearance_android_textColor);
    }
    if (localax.hasValue(a.j.TextAppearance_android_textSize)) {
      this.gl = localax.getDimensionPixelSize(a.j.TextAppearance_android_textSize, (int)this.gl);
    }
    this.gS = localax.getInt(a.j.TextAppearance_android_shadowColor, 0);
    this.gQ = localax.getFloat(a.j.TextAppearance_android_shadowDx, 0.0F);
    this.gR = localax.getFloat(a.j.TextAppearance_android_shadowDy, 0.0F);
    this.gP = localax.getFloat(a.j.TextAppearance_android_shadowRadius, 0.0F);
    localax.alZ.recycle();
    if (Build.VERSION.SDK_INT >= 16) {
      this.gw = D(paramInt);
    }
    az();
  }
  
  final void a(Typeface paramTypeface)
  {
    this.gw = paramTypeface;
    this.gv = paramTypeface;
    az();
  }
  
  final Typeface aw()
  {
    if (this.gv != null) {
      return this.gv;
    }
    return Typeface.DEFAULT;
  }
  
  public final void az()
  {
    int j = 1;
    float f2 = 0.0F;
    float f3;
    float f1;
    int i;
    if ((this.mView.getHeight() > 0) && (this.mView.getWidth() > 0))
    {
      f3 = this.gF;
      k(this.gm);
      if (this.gy == null) {
        break label402;
      }
      f1 = this.gI.measureText(this.gy, 0, this.gy.length());
      int k = this.gk;
      if (!this.gz) {
        break label407;
      }
      i = 1;
      label83:
      i = d.getAbsoluteGravity(k, i);
      switch (i & 0x70)
      {
      default: 
        this.gq = ((this.gI.descent() - this.gI.ascent()) / 2.0F - this.gI.descent() + this.gh.centerY());
        label162:
        switch (i & 0x800007)
        {
        default: 
          this.gs = this.gh.left;
          label208:
          k(this.gl);
          f1 = f2;
          if (this.gy != null) {
            f1 = this.gI.measureText(this.gy, 0, this.gy.length());
          }
          k = this.gj;
          if (this.gz)
          {
            i = j;
            i = d.getAbsoluteGravity(k, i);
            switch (i & 0x70)
            {
            default: 
              this.gp = ((this.gI.descent() - this.gI.ascent()) / 2.0F - this.gI.descent() + this.gg.centerY());
              label342:
              switch (i & 0x800007)
              {
              default: 
                this.gr = this.gg.left;
              }
              break;
            }
          }
          break;
        }
        label264:
        break;
      }
    }
    for (;;)
    {
      aA();
      j(f3);
      ax();
      return;
      label402:
      f1 = 0.0F;
      break;
      label407:
      i = 0;
      break label83;
      this.gq = this.gh.bottom;
      break label162;
      this.gq = (this.gh.top - this.gI.ascent());
      break label162;
      this.gs = (this.gh.centerX() - f1 / 2.0F);
      break label208;
      this.gs = (this.gh.right - f1);
      break label208;
      i = 0;
      break label264;
      this.gp = this.gg.bottom;
      break label342;
      this.gp = (this.gg.top - this.gI.ascent());
      break label342;
      this.gr = (this.gg.centerX() - f1 / 2.0F);
      continue;
      this.gr = (this.gg.right - f1);
    }
  }
  
  final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.gg, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.gg.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.gH = true;
      av();
    }
  }
  
  final void b(ColorStateList paramColorStateList)
  {
    if (this.go != paramColorStateList)
    {
      this.go = paramColorStateList;
      az();
    }
  }
  
  final void b(Interpolator paramInterpolator)
  {
    this.gK = paramInterpolator;
    az();
  }
  
  final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.gh, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.gh.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.gH = true;
      av();
    }
  }
  
  final void c(ColorStateList paramColorStateList)
  {
    if (this.gn != paramColorStateList)
    {
      this.gn = paramColorStateList;
      az();
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
    if ((this.gy != null) && (this.ge))
    {
      f4 = this.gt;
      float f3 = this.gu;
      if ((!this.gA) || (this.gB == null)) {
        break label128;
      }
      i = 1;
      if (i == 0) {
        break label134;
      }
      f1 = this.gD * this.mScale;
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
      paramCanvas.drawBitmap(this.gB, f4, f2, this.gC);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      return;
      label128:
      i = 0;
      break;
      label134:
      this.gI.ascent();
      f1 = 0.0F;
      this.gI.descent();
      break label64;
      label155:
      paramCanvas.drawText(this.gy, 0, this.gy.length(), f4, f2, this.gI);
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
      if (f != this.gf)
      {
        this.gf = f;
        ax();
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
    this.gG = paramArrayOfInt;
    if (((this.go != null) && (this.go.isStateful())) || ((this.gn != null) && (this.gn.isStateful()))) {}
    for (int i = 1; i != 0; i = 0)
    {
      az();
      return true;
    }
    return false;
  }
  
  final void setText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!paramCharSequence.equals(this.mText)))
    {
      this.mText = paramCharSequence;
      this.gy = null;
      aA();
      az();
    }
  }
  
  final void z(int paramInt)
  {
    if (this.gj != paramInt)
    {
      this.gj = paramInt;
      az();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.design.widget.f
 * JD-Core Version:    0.7.0.1
 */