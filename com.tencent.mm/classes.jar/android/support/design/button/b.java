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
  static final boolean hD;
  final MaterialButton hE;
  int hF;
  PorterDuff.Mode hG;
  ColorStateList hH;
  ColorStateList hI;
  ColorStateList hJ;
  final Paint hK = new Paint(1);
  final Rect hL = new Rect();
  final RectF hM = new RectF();
  GradientDrawable hN;
  Drawable hO;
  GradientDrawable hP;
  Drawable hQ;
  GradientDrawable hR;
  GradientDrawable hS;
  GradientDrawable hT;
  boolean hU = false;
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
      hD = bool;
      return;
    }
  }
  
  public b(MaterialButton paramMaterialButton)
  {
    this.hE = paramMaterialButton;
  }
  
  final InsetDrawable a(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
  }
  
  final void aX()
  {
    if (this.hR != null)
    {
      android.support.v4.graphics.drawable.a.a(this.hR, this.hH);
      if (this.hG != null) {
        android.support.v4.graphics.drawable.a.a(this.hR, this.hG);
      }
    }
  }
  
  @TargetApi(21)
  final Drawable aY()
  {
    this.hR = new GradientDrawable();
    this.hR.setCornerRadius(this.hF + 1.0E-005F);
    this.hR.setColor(-1);
    aX();
    this.hS = new GradientDrawable();
    this.hS.setCornerRadius(this.hF + 1.0E-005F);
    this.hS.setColor(0);
    this.hS.setStroke(this.strokeWidth, this.hI);
    InsetDrawable localInsetDrawable = a(new LayerDrawable(new Drawable[] { this.hR, this.hS }));
    this.hT = new GradientDrawable();
    this.hT.setCornerRadius(this.hF + 1.0E-005F);
    this.hT.setColor(-1);
    return new a(android.support.design.e.a.b(this.hJ), localInsetDrawable, this.hT);
  }
  
  final void aZ()
  {
    if ((hD) && (this.hS != null)) {
      this.hE.setInternalBackground(aY());
    }
    while (hD) {
      return;
    }
    this.hE.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.button.b
 * JD-Core Version:    0.7.0.1
 */