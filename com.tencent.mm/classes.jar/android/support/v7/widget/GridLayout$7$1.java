package android.support.v7.widget;

import android.view.View;

final class GridLayout$7$1
  extends GridLayout.e
{
  private int size;
  
  GridLayout$7$1(GridLayout.7 param7) {}
  
  protected final void R(int paramInt1, int paramInt2)
  {
    super.R(paramInt1, paramInt2);
    this.size = Math.max(this.size, paramInt1 + paramInt2);
  }
  
  protected final int a(GridLayout paramGridLayout, View paramView, GridLayout.a parama, int paramInt, boolean paramBoolean)
  {
    return Math.max(0, super.a(paramGridLayout, paramView, parama, paramInt, paramBoolean));
  }
  
  protected final int ad(boolean paramBoolean)
  {
    return Math.max(super.ad(paramBoolean), this.size);
  }
  
  protected final void reset()
  {
    super.reset();
    this.size = -2147483648;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.7.1
 * JD-Core Version:    0.7.0.1
 */