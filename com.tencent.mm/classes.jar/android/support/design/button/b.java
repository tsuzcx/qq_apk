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
  static final boolean hF;
  final MaterialButton hG;
  int hH;
  PorterDuff.Mode hI;
  ColorStateList hJ;
  ColorStateList hK;
  ColorStateList hL;
  final Paint hM = new Paint(1);
  final Rect hN = new Rect();
  final RectF hO = new RectF();
  GradientDrawable hP;
  Drawable hQ;
  GradientDrawable hR;
  Drawable hS;
  GradientDrawable hT;
  GradientDrawable hU;
  GradientDrawable hV;
  boolean hW = false;
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
      hF = bool;
      return;
    }
  }
  
  public b(MaterialButton paramMaterialButton)
  {
    this.hG = paramMaterialButton;
  }
  
  final InsetDrawable a(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
  }
  
  final void aZ()
  {
    if (this.hT != null)
    {
      android.support.v4.graphics.drawable.a.a(this.hT, this.hJ);
      if (this.hI != null) {
        android.support.v4.graphics.drawable.a.a(this.hT, this.hI);
      }
    }
  }
  
  @TargetApi(21)
  final Drawable ba()
  {
    this.hT = new GradientDrawable();
    this.hT.setCornerRadius(this.hH + 1.0E-005F);
    this.hT.setColor(-1);
    aZ();
    this.hU = new GradientDrawable();
    this.hU.setCornerRadius(this.hH + 1.0E-005F);
    this.hU.setColor(0);
    this.hU.setStroke(this.strokeWidth, this.hK);
    InsetDrawable localInsetDrawable = a(new LayerDrawable(new Drawable[] { this.hT, this.hU }));
    this.hV = new GradientDrawable();
    this.hV.setCornerRadius(this.hH + 1.0E-005F);
    this.hV.setColor(-1);
    return new a(android.support.design.e.a.b(this.hL), localInsetDrawable, this.hV);
  }
  
  final void bb()
  {
    if ((hF) && (this.hU != null)) {
      this.hG.setInternalBackground(ba());
    }
    while (hF) {
      return;
    }
    this.hG.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.button.b
 * JD-Core Version:    0.7.0.1
 */