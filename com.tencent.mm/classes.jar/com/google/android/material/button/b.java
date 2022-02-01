package com.google.android.material.button;

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
  static final boolean dra;
  final RectF avO;
  final Rect bounds;
  int cornerRadius;
  final MaterialButton drb;
  int drc;
  int drd;
  int dre;
  int drf;
  PorterDuff.Mode drg;
  ColorStateList drh;
  ColorStateList dri;
  ColorStateList drj;
  final Paint drk;
  GradientDrawable drl;
  Drawable drm;
  GradientDrawable drn;
  Drawable dro;
  GradientDrawable drp;
  GradientDrawable drq;
  GradientDrawable drr;
  boolean drs;
  int strokeWidth;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      dra = bool;
      return;
    }
  }
  
  public b(MaterialButton paramMaterialButton)
  {
    AppMethodBeat.i(209824);
    this.drk = new Paint(1);
    this.bounds = new Rect();
    this.avO = new RectF();
    this.drs = false;
    this.drb = paramMaterialButton;
    AppMethodBeat.o(209824);
  }
  
  final InsetDrawable G(Drawable paramDrawable)
  {
    AppMethodBeat.i(209836);
    paramDrawable = new InsetDrawable(paramDrawable, this.drc, this.dre, this.drd, this.drf);
    AppMethodBeat.o(209836);
    return paramDrawable;
  }
  
  final void VQ()
  {
    AppMethodBeat.i(209844);
    if (this.drp != null)
    {
      androidx.core.graphics.drawable.a.a(this.drp, this.drh);
      if (this.drg != null) {
        androidx.core.graphics.drawable.a.a(this.drp, this.drg);
      }
    }
    AppMethodBeat.o(209844);
  }
  
  final Drawable VR()
  {
    AppMethodBeat.i(209850);
    this.drp = new GradientDrawable();
    this.drp.setCornerRadius(this.cornerRadius + 1.0E-005F);
    this.drp.setColor(-1);
    VQ();
    this.drq = new GradientDrawable();
    this.drq.setCornerRadius(this.cornerRadius + 1.0E-005F);
    this.drq.setColor(0);
    this.drq.setStroke(this.strokeWidth, this.dri);
    Object localObject = G(new LayerDrawable(new Drawable[] { this.drp, this.drq }));
    this.drr = new GradientDrawable();
    this.drr.setCornerRadius(this.cornerRadius + 1.0E-005F);
    this.drr.setColor(-1);
    localObject = new a(com.google.android.material.f.a.g(this.drj), (InsetDrawable)localObject, this.drr);
    AppMethodBeat.o(209850);
    return localObject;
  }
  
  final void VS()
  {
    AppMethodBeat.i(209859);
    if ((dra) && (this.drq != null))
    {
      this.drb.setInternalBackground(VR());
      AppMethodBeat.o(209859);
      return;
    }
    if (!dra) {
      this.drb.invalidate();
    }
    AppMethodBeat.o(209859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.button.b
 * JD-Core Version:    0.7.0.1
 */