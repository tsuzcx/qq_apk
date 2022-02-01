package com.tencent.mm.plugin.hld.emoji;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.r.b;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "()V", "onPageSelectedListener", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "targetSnapPos", "", "attachToRecyclerView", "", "createScroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findSnapView", "Landroid/view/View;", "findTargetSnapPosition", "velocityX", "velocityY", "OnPageSelectedListener", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends t
{
  private int EBt = -1;
  public a Jpr;
  private RecyclerView mkw;
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(312725);
    paramInt1 = super.a(paramLayoutManager, paramInt1, paramInt2);
    this.EBt = paramInt1;
    paramLayoutManager = this.Jpr;
    if (paramLayoutManager != null) {
      paramLayoutManager.onPageSelected(paramInt1);
    }
    AppMethodBeat.o(312725);
    return paramInt1;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(312732);
    View localView = super.a(paramLayoutManager);
    if (localView == null)
    {
      paramLayoutManager = null;
      if (!(paramLayoutManager instanceof RecyclerView.LayoutParams)) {
        break label79;
      }
      paramLayoutManager = (RecyclerView.LayoutParams)paramLayoutManager;
      label29:
      if (paramLayoutManager != null) {
        break label84;
      }
    }
    label79:
    label84:
    for (int i = -1;; i = paramLayoutManager.bXh.KJ())
    {
      if (this.EBt == -1)
      {
        paramLayoutManager = this.Jpr;
        if (paramLayoutManager != null) {
          paramLayoutManager.onPageSelected(i);
        }
      }
      this.EBt = -1;
      AppMethodBeat.o(312732);
      return localView;
      paramLayoutManager = localView.getLayoutParams();
      break;
      paramLayoutManager = null;
      break label29;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(312712);
    super.a(paramRecyclerView);
    this.mkw = paramRecyclerView;
    AppMethodBeat.o(312712);
  }
  
  public final RecyclerView.r g(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(312719);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(312719);
      return null;
    }
    paramLayoutManager = this.mkw;
    if (paramLayoutManager == null) {}
    for (paramLayoutManager = null;; paramLayoutManager = paramLayoutManager.getContext())
    {
      paramLayoutManager = (RecyclerView.r)new b(this, paramLayoutManager);
      AppMethodBeat.o(312719);
      return paramLayoutManager;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onPageSelected(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/hld/emoji/ImeEmojiPagerScrollHelper$createScroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "action", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller$Action;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends o
  {
    b(i parami, Context paramContext)
    {
      super();
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(312673);
      s.u(paramView, "targetView");
      s.u(params, "state");
      s.u(parama, "action");
      if (i.a(this.Jps) != null)
      {
        i locali = this.Jps;
        params = i.a(this.Jps);
        if (params == null) {}
        int i;
        int j;
        for (params = null;; params = params.getLayoutManager())
        {
          s.checkNotNull(params);
          paramView = locali.a(params, paramView);
          s.checkNotNull(paramView);
          i = paramView[0];
          j = paramView[1];
          int k = fO(Math.max(Math.abs(i), Math.abs(j)));
          if (k <= 0) {
            break;
          }
          parama.a(i, j, k, (Interpolator)this.bXY);
          AppMethodBeat.o(312673);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.bXY);
      }
      AppMethodBeat.o(312673);
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(312678);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = 50.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(312678);
      return f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.emoji.i
 * JD-Core Version:    0.7.0.1
 */