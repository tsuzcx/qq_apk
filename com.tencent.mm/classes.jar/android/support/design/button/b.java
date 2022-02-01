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
  static final boolean eL;
  final MaterialButton eM;
  int eN;
  PorterDuff.Mode eO;
  ColorStateList eP;
  ColorStateList eQ;
  ColorStateList eR;
  final Paint eS = new Paint(1);
  final Rect eT = new Rect();
  final RectF eU = new RectF();
  GradientDrawable eV;
  Drawable eW;
  GradientDrawable eX;
  Drawable eY;
  GradientDrawable eZ;
  GradientDrawable fa;
  GradientDrawable fb;
  boolean fc = false;
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
      eL = bool;
      return;
    }
  }
  
  public b(MaterialButton paramMaterialButton)
  {
    this.eM = paramMaterialButton;
  }
  
  final InsetDrawable a(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
  }
  
  final void aA()
  {
    if (this.eZ != null)
    {
      android.support.v4.graphics.drawable.a.a(this.eZ, this.eP);
      if (this.eO != null) {
        android.support.v4.graphics.drawable.a.a(this.eZ, this.eO);
      }
    }
  }
  
  @TargetApi(21)
  final Drawable aB()
  {
    this.eZ = new GradientDrawable();
    this.eZ.setCornerRadius(this.eN + 1.0E-005F);
    this.eZ.setColor(-1);
    aA();
    this.fa = new GradientDrawable();
    this.fa.setCornerRadius(this.eN + 1.0E-005F);
    this.fa.setColor(0);
    this.fa.setStroke(this.strokeWidth, this.eQ);
    InsetDrawable localInsetDrawable = a(new LayerDrawable(new Drawable[] { this.eZ, this.fa }));
    this.fb = new GradientDrawable();
    this.fb.setCornerRadius(this.eN + 1.0E-005F);
    this.fb.setColor(-1);
    return new a(android.support.design.e.a.b(this.eR), localInsetDrawable, this.fb);
  }
  
  final void aC()
  {
    if ((eL) && (this.fa != null)) {
      this.eM.setInternalBackground(aB());
    }
    while (eL) {
      return;
    }
    this.eM.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.button.b
 * JD-Core Version:    0.7.0.1
 */