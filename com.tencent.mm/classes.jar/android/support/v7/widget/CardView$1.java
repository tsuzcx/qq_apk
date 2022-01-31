package android.support.v7.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

final class CardView$1
  implements q
{
  private Drawable abN;
  
  CardView$1(CardView paramCardView) {}
  
  public final void O(int paramInt1, int paramInt2)
  {
    if (paramInt1 > this.abO.abI) {
      CardView.a(this.abO, paramInt1);
    }
    if (paramInt2 > this.abO.abJ) {
      CardView.b(this.abO, paramInt2);
    }
  }
  
  public final void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.abO.abL.set(paramInt1, paramInt2, paramInt3, paramInt4);
    CardView localCardView = this.abO;
    CardView.a(localCardView, localCardView.abK.left + paramInt1, this.abO.abK.top + paramInt2, this.abO.abK.right + paramInt3, this.abO.abK.bottom + paramInt4);
  }
  
  public final boolean getPreventCornerOverlap()
  {
    return this.abO.getPreventCornerOverlap();
  }
  
  public final boolean getUseCompatPadding()
  {
    return this.abO.getUseCompatPadding();
  }
  
  public final Drawable hu()
  {
    return this.abN;
  }
  
  public final View hv()
  {
    return this.abO;
  }
  
  public final void l(Drawable paramDrawable)
  {
    this.abN = paramDrawable;
    this.abO.setBackgroundDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.CardView.1
 * JD-Core Version:    0.7.0.1
 */