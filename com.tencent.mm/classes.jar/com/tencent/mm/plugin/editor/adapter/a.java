package com.tencent.mm.plugin.editor.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class a
  extends RecyclerView.l
{
  private int qOk;
  
  public abstract void cCV();
  
  public abstract void cCW();
  
  public abstract void cCX();
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    if (Math.abs(paramInt2) > this.qOk)
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        if (paramRecyclerView.canScrollVertically(-1)) {
          break label91;
        }
        cCX();
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
          cCV();
        } else if (paramInt2 > 0) {
          cCW();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a
 * JD-Core Version:    0.7.0.1
 */