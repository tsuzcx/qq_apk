package android.support.v7.widget;

import android.view.View;

final class RecyclerView$i$1
  implements bd.b
{
  RecyclerView$i$1(RecyclerView.i parami) {}
  
  public final int bs(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return RecyclerView.i.bo(paramView) - localLayoutParams.leftMargin;
  }
  
  public final int bt(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.bq(paramView);
    return localLayoutParams.rightMargin + i;
  }
  
  public final View getChildAt(int paramInt)
  {
    return this.ahh.getChildAt(paramInt);
  }
  
  public final int hT()
  {
    return this.ahh.getPaddingLeft();
  }
  
  public final int hU()
  {
    return this.ahh.mWidth - this.ahh.getPaddingRight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.i.1
 * JD-Core Version:    0.7.0.1
 */