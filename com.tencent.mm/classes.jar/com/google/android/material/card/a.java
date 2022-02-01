package com.google.android.material.card;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
{
  private final MaterialCardView byt;
  int strokeColor;
  int strokeWidth;
  
  public a(MaterialCardView paramMaterialCardView)
  {
    this.byt = paramMaterialCardView;
  }
  
  private Drawable wv()
  {
    AppMethodBeat.i(235638);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(this.byt.getRadius());
    if (this.strokeColor != -1) {
      localGradientDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
    AppMethodBeat.o(235638);
    return localGradientDrawable;
  }
  
  final void wu()
  {
    AppMethodBeat.i(235636);
    this.byt.setForeground(wv());
    AppMethodBeat.o(235636);
  }
  
  final void ww()
  {
    AppMethodBeat.i(235641);
    int i = this.byt.getContentPaddingLeft();
    int j = this.strokeWidth;
    int k = this.byt.getContentPaddingTop();
    int m = this.strokeWidth;
    int n = this.byt.getContentPaddingRight();
    int i1 = this.strokeWidth;
    int i2 = this.byt.getContentPaddingBottom();
    int i3 = this.strokeWidth;
    this.byt.setContentPadding(i + j, k + m, n + i1, i2 + i3);
    AppMethodBeat.o(235641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.card.a
 * JD-Core Version:    0.7.0.1
 */