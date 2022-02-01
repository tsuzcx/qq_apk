package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/InterceptRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "enableDrag", "", "enableDragWhenScrollIdle", "", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class InterceptRecyclerView
  extends RecyclerView
{
  public boolean GEW;
  
  public InterceptRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344684);
    this.GEW = true;
    a((RecyclerView.l)new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(345017);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        a.c("com/tencent/mm/plugin/finder/view/InterceptRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        s.u(paramAnonymousRecyclerView, "recyclerView");
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0) {
          InterceptRecyclerView.a(this.GEX);
        }
        a.a(this, "com/tencent/mm/plugin/finder/view/InterceptRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(345017);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(345024);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        a.c("com/tencent/mm/plugin/finder/view/InterceptRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        a.a(this, "com/tencent/mm/plugin/finder/view/InterceptRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(345024);
      }
    });
    AppMethodBeat.o(344684);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(344698);
    if (this.GEW)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(344698);
      return bool;
    }
    AppMethodBeat.o(344698);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.InterceptRecyclerView
 * JD-Core Version:    0.7.0.1
 */