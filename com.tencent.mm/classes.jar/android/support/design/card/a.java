package android.support.design.card;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

final class a
{
  private final MaterialCardView hY;
  int strokeColor;
  int strokeWidth;
  
  public a(MaterialCardView paramMaterialCardView)
  {
    this.hY = paramMaterialCardView;
  }
  
  private Drawable bd()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(this.hY.getRadius());
    if (this.strokeColor != -1) {
      localGradientDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
    return localGradientDrawable;
  }
  
  final void bc()
  {
    this.hY.setForeground(bd());
  }
  
  final void be()
  {
    int i = this.hY.getContentPaddingLeft();
    int j = this.strokeWidth;
    int k = this.hY.getContentPaddingTop();
    int m = this.strokeWidth;
    int n = this.hY.getContentPaddingRight();
    int i1 = this.strokeWidth;
    int i2 = this.hY.getContentPaddingBottom();
    int i3 = this.strokeWidth;
    this.hY.setContentPadding(i + j, k + m, n + i1, i2 + i3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.card.a
 * JD-Core Version:    0.7.0.1
 */