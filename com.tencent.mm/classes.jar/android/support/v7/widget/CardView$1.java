package android.support.v7.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

final class CardView$1
  implements s
{
  private Drawable abc;
  
  CardView$1(CardView paramCardView) {}
  
  public final void L(int paramInt1, int paramInt2)
  {
    if (paramInt1 > this.abd.aaX) {
      CardView.a(this.abd, paramInt1);
    }
    if (paramInt2 > this.abd.aaY) {
      CardView.b(this.abd, paramInt2);
    }
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.abd.aba.set(paramInt1, paramInt2, paramInt3, paramInt4);
    CardView.a(this.abd, this.abd.aaZ.left + paramInt1, this.abd.aaZ.top + paramInt2, this.abd.aaZ.right + paramInt3, this.abd.aaZ.bottom + paramInt4);
  }
  
  public final boolean getPreventCornerOverlap()
  {
    return this.abd.getPreventCornerOverlap();
  }
  
  public final boolean getUseCompatPadding()
  {
    return this.abd.getUseCompatPadding();
  }
  
  public final Drawable gu()
  {
    return this.abc;
  }
  
  public final View gv()
  {
    return this.abd;
  }
  
  public final void j(Drawable paramDrawable)
  {
    this.abc = paramDrawable;
    this.abd.setBackgroundDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.CardView.1
 * JD-Core Version:    0.7.0.1
 */