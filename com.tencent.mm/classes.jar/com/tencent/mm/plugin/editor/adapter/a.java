package com.tencent.mm.plugin.editor.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class a
  extends RecyclerView.m
{
  private int psn;
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt1);
    localb.mr(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
    if (Math.abs(paramInt2) > this.psn)
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        if (paramRecyclerView.canScrollVertically(-1)) {
          break label91;
        }
        cdS();
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      return;
      paramInt1 = 0;
      break;
      label91:
      if (paramRecyclerView.canScrollVertically(1)) {
        if (paramInt2 < 0) {
          cdQ();
        } else if (paramInt2 > 0) {
          cdR();
        }
      }
    }
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
    super.b(paramRecyclerView, paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
  }
  
  public abstract void cdQ();
  
  public abstract void cdR();
  
  public abstract void cdS();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a
 * JD-Core Version:    0.7.0.1
 */