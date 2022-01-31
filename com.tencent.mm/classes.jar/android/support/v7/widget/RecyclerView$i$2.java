package android.support.v7.widget;

import android.view.View;

final class RecyclerView$i$2
  implements bd.b
{
  RecyclerView$i$2(RecyclerView.i parami) {}
  
  public final int bs(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    return RecyclerView.i.bp(paramView) - localLayoutParams.topMargin;
  }
  
  public final int bt(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = RecyclerView.i.br(paramView);
    return localLayoutParams.bottomMargin + i;
  }
  
  public final View getChildAt(int paramInt)
  {
    return this.ahh.getChildAt(paramInt);
  }
  
  public final int hT()
  {
    return this.ahh.getPaddingTop();
  }
  
  public final int hU()
  {
    return this.ahh.mHeight - this.ahh.getPaddingBottom();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.i.2
 * JD-Core Version:    0.7.0.1
 */