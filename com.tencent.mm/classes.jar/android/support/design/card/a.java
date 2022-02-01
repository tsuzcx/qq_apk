package android.support.design.card;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

final class a
{
  private final MaterialCardView gf;
  int strokeColor;
  int strokeWidth;
  
  public a(MaterialCardView paramMaterialCardView)
  {
    this.gf = paramMaterialCardView;
  }
  
  private Drawable aL()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(this.gf.getRadius());
    if (this.strokeColor != -1) {
      localGradientDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
    return localGradientDrawable;
  }
  
  final void aK()
  {
    this.gf.setForeground(aL());
  }
  
  final void aM()
  {
    int i = this.gf.getContentPaddingLeft();
    int j = this.strokeWidth;
    int k = this.gf.getContentPaddingTop();
    int m = this.strokeWidth;
    int n = this.gf.getContentPaddingRight();
    int i1 = this.strokeWidth;
    int i2 = this.gf.getContentPaddingBottom();
    int i3 = this.strokeWidth;
    this.gf.setContentPadding(i + j, k + m, n + i1, i2 + i3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.card.a
 * JD-Core Version:    0.7.0.1
 */