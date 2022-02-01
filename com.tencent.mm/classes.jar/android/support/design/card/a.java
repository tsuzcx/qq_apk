package android.support.design.card;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

final class a
{
  private final MaterialCardView hW;
  int strokeColor;
  int strokeWidth;
  
  public a(MaterialCardView paramMaterialCardView)
  {
    this.hW = paramMaterialCardView;
  }
  
  private Drawable bb()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(this.hW.getRadius());
    if (this.strokeColor != -1) {
      localGradientDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
    return localGradientDrawable;
  }
  
  final void ba()
  {
    this.hW.setForeground(bb());
  }
  
  final void bc()
  {
    int i = this.hW.getContentPaddingLeft();
    int j = this.strokeWidth;
    int k = this.hW.getContentPaddingTop();
    int m = this.strokeWidth;
    int n = this.hW.getContentPaddingRight();
    int i1 = this.strokeWidth;
    int i2 = this.hW.getContentPaddingBottom();
    int i3 = this.strokeWidth;
    this.hW.setContentPadding(i + j, k + m, n + i1, i2 + i3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.card.a
 * JD-Core Version:    0.7.0.1
 */