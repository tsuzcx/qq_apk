package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.s.a;
import android.support.v7.widget.RecyclerView.s.b;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.ae;
import android.support.v7.widget.af;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper;", "Landroid/support/v7/widget/LinearSnapHelper;", "()V", "onPageSelectedListener", "Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "attachToRecyclerView", "", "createScroller", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "findSnapView", "Landroid/view/View;", "findTargetSnapPosition", "", "velocityX", "velocityY", "OnPageSelectedListener", "plugin-emojicapture_release"})
public final class c
  extends af
{
  RecyclerView gmV;
  public a pZs;
  
  public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(893);
    paramInt1 = super.a(parami, paramInt1, paramInt2);
    parami = this.pZs;
    if (parami != null) {
      parami.onPageSelected(paramInt1);
    }
    AppMethodBeat.o(893);
    return paramInt1;
  }
  
  public final View a(RecyclerView.i parami)
  {
    AppMethodBeat.i(894);
    View localView = super.a(parami);
    if (localView != null)
    {
      parami = localView.getLayoutParams();
      RecyclerView.i locali = parami;
      if (!(parami instanceof RecyclerView.LayoutParams)) {
        locali = null;
      }
      parami = (RecyclerView.LayoutParams)locali;
      if (parami == null) {
        break label79;
      }
    }
    label79:
    for (int i = parami.lD();; i = -1)
    {
      parami = this.pZs;
      if (parami != null) {
        parami.onPageSelected(i);
      }
      AppMethodBeat.o(894);
      return localView;
      parami = null;
      break;
    }
  }
  
  public final RecyclerView.s g(RecyclerView.i parami)
  {
    Object localObject = null;
    AppMethodBeat.i(892);
    if (!(parami instanceof RecyclerView.s.b))
    {
      AppMethodBeat.o(892);
      return null;
    }
    RecyclerView localRecyclerView = this.gmV;
    parami = localObject;
    if (localRecyclerView != null) {
      parami = localRecyclerView.getContext();
    }
    parami = (RecyclerView.s)new b(this, parami);
    AppMethodBeat.o(892);
    return parami;
  }
  
  public final void j(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(891);
    super.j(paramRecyclerView);
    this.gmV = paramRecyclerView;
    AppMethodBeat.o(891);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-emojicapture_release"})
  public static abstract interface a
  {
    public abstract void onPageSelected(int paramInt);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/ui/layout/StickerSnapHelper$createScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "action", "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-emojicapture_release"})
  public static final class b
    extends ae
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final void a(View paramView, RecyclerView.t paramt, RecyclerView.s.a parama)
    {
      AppMethodBeat.i(890);
      p.h(paramView, "targetView");
      p.h(paramt, "state");
      p.h(parama, "action");
      if (this.pZt.gmV != null)
      {
        c localc = this.pZt;
        paramt = this.pZt.gmV;
        if (paramt != null) {}
        int i;
        int j;
        for (paramt = paramt.getLayoutManager();; paramt = null)
        {
          if (paramt == null) {
            p.gfZ();
          }
          paramView = localc.a(paramt, paramView);
          if (paramView == null) {
            p.gfZ();
          }
          i = paramView[0];
          j = paramView[1];
          int k = cd(Math.max(Math.abs(i), Math.abs(j)));
          if (k <= 0) {
            break;
          }
          parama.a(i, j, k, (Interpolator)this.VD);
          AppMethodBeat.o(890);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.VD);
      }
      AppMethodBeat.o(890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.layout.c
 * JD-Core Version:    0.7.0.1
 */