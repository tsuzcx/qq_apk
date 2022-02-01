package android.support.design.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;

final class b
{
  static final boolean fM;
  final MaterialButton fN;
  int fO;
  PorterDuff.Mode fP;
  ColorStateList fQ;
  ColorStateList fR;
  ColorStateList fS;
  final Paint fT = new Paint(1);
  final Rect fU = new Rect();
  final RectF fV = new RectF();
  GradientDrawable fW;
  Drawable fX;
  GradientDrawable fY;
  Drawable fZ;
  GradientDrawable ga;
  GradientDrawable gb;
  GradientDrawable gc;
  boolean gd = false;
  int insetBottom;
  int insetLeft;
  int insetRight;
  int insetTop;
  int strokeWidth;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      fM = bool;
      return;
    }
  }
  
  public b(MaterialButton paramMaterialButton)
  {
    this.fN = paramMaterialButton;
  }
  
  final InsetDrawable a(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
  }
  
  final void aH()
  {
    if (this.ga != null)
    {
      android.support.v4.graphics.drawable.a.a(this.ga, this.fQ);
      if (this.fP != null) {
        android.support.v4.graphics.drawable.a.a(this.ga, this.fP);
      }
    }
  }
  
  @TargetApi(21)
  final Drawable aI()
  {
    this.ga = new GradientDrawable();
    this.ga.setCornerRadius(this.fO + 1.0E-005F);
    this.ga.setColor(-1);
    aH();
    this.gb = new GradientDrawable();
    this.gb.setCornerRadius(this.fO + 1.0E-005F);
    this.gb.setColor(0);
    this.gb.setStroke(this.strokeWidth, this.fR);
    InsetDrawable localInsetDrawable = a(new LayerDrawable(new Drawable[] { this.ga, this.gb }));
    this.gc = new GradientDrawable();
    this.gc.setCornerRadius(this.fO + 1.0E-005F);
    this.gc.setColor(-1);
    return new a(android.support.design.e.a.b(this.fS), localInsetDrawable, this.gc);
  }
  
  final void aJ()
  {
    if ((fM) && (this.gb != null)) {
      this.fN.setInternalBackground(aI());
    }
    while (fM) {
      return;
    }
    this.fN.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.button.b
 * JD-Core Version:    0.7.0.1
 */