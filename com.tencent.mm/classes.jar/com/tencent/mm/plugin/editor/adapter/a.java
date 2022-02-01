package com.tencent.mm.plugin.editor.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class a
  extends RecyclerView.l
{
  private int uqo;
  
  public abstract void cRA();
  
  public abstract void cRB();
  
  public abstract void cRC();
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt1);
    localb.sg(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
    if (Math.abs(paramInt2) > this.uqo)
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        if (paramRecyclerView.canScrollVertically(-1)) {
          break label91;
        }
        cRC();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      return;
      paramInt1 = 0;
      break;
      label91:
      if (paramRecyclerView.canScrollVertically(1)) {
        if (paramInt2 < 0) {
          cRA();
        } else if (paramInt2 > 0) {
          cRB();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a
 * JD-Core Version:    0.7.0.1
 */