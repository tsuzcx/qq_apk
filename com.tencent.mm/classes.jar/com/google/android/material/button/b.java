package com.google.android.material.button;

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
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  static final boolean bxX;
  final MaterialButton bxY;
  int bxZ;
  int bya;
  int byb;
  int byc;
  PorterDuff.Mode byd;
  ColorStateList bye;
  ColorStateList byf;
  ColorStateList byg;
  final Paint byh;
  final Rect byi;
  final RectF byj;
  GradientDrawable byk;
  Drawable byl;
  GradientDrawable bym;
  Drawable byn;
  GradientDrawable byo;
  GradientDrawable byp;
  GradientDrawable byq;
  boolean byr;
  int cornerRadius;
  int strokeWidth;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      bxX = bool;
      return;
    }
  }
  
  public b(MaterialButton paramMaterialButton)
  {
    AppMethodBeat.i(235600);
    this.byh = new Paint(1);
    this.byi = new Rect();
    this.byj = new RectF();
    this.byr = false;
    this.bxY = paramMaterialButton;
    AppMethodBeat.o(235600);
  }
  
  final InsetDrawable w(Drawable paramDrawable)
  {
    AppMethodBeat.i(235602);
    paramDrawable = new InsetDrawable(paramDrawable, this.bxZ, this.byb, this.bya, this.byc);
    AppMethodBeat.o(235602);
    return paramDrawable;
  }
  
  final void wr()
  {
    AppMethodBeat.i(235605);
    if (this.byo != null)
    {
      androidx.core.graphics.drawable.a.a(this.byo, this.bye);
      if (this.byd != null) {
        androidx.core.graphics.drawable.a.a(this.byo, this.byd);
      }
    }
    AppMethodBeat.o(235605);
  }
  
  @TargetApi(21)
  final Drawable ws()
  {
    AppMethodBeat.i(235610);
    this.byo = new GradientDrawable();
    this.byo.setCornerRadius(this.cornerRadius + 1.0E-005F);
    this.byo.setColor(-1);
    wr();
    this.byp = new GradientDrawable();
    this.byp.setCornerRadius(this.cornerRadius + 1.0E-005F);
    this.byp.setColor(0);
    this.byp.setStroke(this.strokeWidth, this.byf);
    Object localObject = w(new LayerDrawable(new Drawable[] { this.byo, this.byp }));
    this.byq = new GradientDrawable();
    this.byq.setCornerRadius(this.cornerRadius + 1.0E-005F);
    this.byq.setColor(-1);
    localObject = new a(com.google.android.material.f.a.g(this.byg), (InsetDrawable)localObject, this.byq);
    AppMethodBeat.o(235610);
    return localObject;
  }
  
  final void wt()
  {
    AppMethodBeat.i(235612);
    if ((bxX) && (this.byp != null))
    {
      this.bxY.setInternalBackground(ws());
      AppMethodBeat.o(235612);
      return;
    }
    if (!bxX) {
      this.bxY.invalidate();
    }
    AppMethodBeat.o(235612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.button.b
 * JD-Core Version:    0.7.0.1
 */