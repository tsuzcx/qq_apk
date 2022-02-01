package com.google.android.material.card;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  private final MaterialCardView dru;
  int strokeColor;
  int strokeWidth;
  
  public a(MaterialCardView paramMaterialCardView)
  {
    this.dru = paramMaterialCardView;
  }
  
  private Drawable VU()
  {
    AppMethodBeat.i(208918);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(this.dru.getRadius());
    if (this.strokeColor != -1) {
      localGradientDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
    AppMethodBeat.o(208918);
    return localGradientDrawable;
  }
  
  final void VT()
  {
    AppMethodBeat.i(208923);
    this.dru.setForeground(VU());
    AppMethodBeat.o(208923);
  }
  
  final void VV()
  {
    AppMethodBeat.i(208925);
    int i = this.dru.getContentPaddingLeft();
    int j = this.strokeWidth;
    int k = this.dru.getContentPaddingTop();
    int m = this.strokeWidth;
    int n = this.dru.getContentPaddingRight();
    int i1 = this.strokeWidth;
    int i2 = this.dru.getContentPaddingBottom();
    int i3 = this.strokeWidth;
    this.dru.setContentPadding(i + j, k + m, n + i1, i2 + i3);
    AppMethodBeat.o(208925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.card.a
 * JD-Core Version:    0.7.0.1
 */