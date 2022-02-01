package android.support.design.card;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

final class a
{
  private final MaterialCardView ff;
  int strokeColor;
  int strokeWidth;
  
  public a(MaterialCardView paramMaterialCardView)
  {
    this.ff = paramMaterialCardView;
  }
  
  private Drawable aE()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(this.ff.getRadius());
    if (this.strokeColor != -1) {
      localGradientDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
    return localGradientDrawable;
  }
  
  final void aD()
  {
    this.ff.setForeground(aE());
  }
  
  final void aF()
  {
    int i = this.ff.getContentPaddingLeft();
    int j = this.strokeWidth;
    int k = this.ff.getContentPaddingTop();
    int m = this.strokeWidth;
    int n = this.ff.getContentPaddingRight();
    int i1 = this.strokeWidth;
    int i2 = this.ff.getContentPaddingBottom();
    int i3 = this.strokeWidth;
    this.ff.setContentPadding(i + j, k + m, n + i1, i2 + i3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.card.a
 * JD-Core Version:    0.7.0.1
 */