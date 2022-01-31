package android.support.v7.widget;

import android.view.View;

final class RecyclerView$i$2
  implements bf.b
{
  RecyclerView$i$2(RecyclerView.i parami) {}
  
  public final int bH(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return RecyclerView.i.bA(paramView) - localLayoutParams.topMargin;
  }
  
  public final int bI(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bC(paramView);
    return localLayoutParams.bottomMargin + i;
  }
  
  public final View getChildAt(int paramInt)
  {
    return this.ajx.getChildAt(paramInt);
  }
  
  public final int jC()
  {
    return this.ajx.getPaddingTop();
  }
  
  public final int jD()
  {
    return this.ajx.mHeight - this.ajx.getPaddingBottom();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.i.2
 * JD-Core Version:    0.7.0.1
 */