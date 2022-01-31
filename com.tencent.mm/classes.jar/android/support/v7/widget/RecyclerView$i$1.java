package android.support.v7.widget;

import android.view.View;

final class RecyclerView$i$1
  implements bf.b
{
  RecyclerView$i$1(RecyclerView.i parami) {}
  
  public final int bH(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return RecyclerView.i.bz(paramView) - localLayoutParams.leftMargin;
  }
  
  public final int bI(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bB(paramView);
    return localLayoutParams.rightMargin + i;
  }
  
  public final View getChildAt(int paramInt)
  {
    return this.ajx.getChildAt(paramInt);
  }
  
  public final int jC()
  {
    return this.ajx.getPaddingLeft();
  }
  
  public final int jD()
  {
    return this.ajx.mWidth - this.ajx.getPaddingRight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.i.1
 * JD-Core Version:    0.7.0.1
 */