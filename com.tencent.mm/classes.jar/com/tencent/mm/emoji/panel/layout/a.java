package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.support.v7.widget.ak;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/layout/EmojiPagerScrollHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "onPageSelectedListener", "Lcom/tencent/mm/emoji/panel/layout/EmojiPagerScrollHelper$OnPageSelectedListener;", "getOnPageSelectedListener", "()Lcom/tencent/mm/emoji/panel/layout/EmojiPagerScrollHelper$OnPageSelectedListener;", "setOnPageSelectedListener", "(Lcom/tencent/mm/emoji/panel/layout/EmojiPagerScrollHelper$OnPageSelectedListener;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "targetSnapPos", "", "attachToRecyclerView", "", "createScroller", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "findSnapView", "Landroid/view/View;", "findTargetSnapPosition", "velocityX", "velocityY", "OnPageSelectedListener", "plugin-emojisdk_release"})
public final class a
  extends ak
{
  RecyclerView fPw;
  private int fQT = -1;
  public a fQU;
  
  public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105710);
    paramInt1 = super.a(parami, paramInt1, paramInt2);
    this.fQT = paramInt1;
    parami = this.fQU;
    if (parami != null) {
      parami.onPageSelected(paramInt1);
    }
    AppMethodBeat.o(105710);
    return paramInt1;
  }
  
  public final View a(RecyclerView.i parami)
  {
    AppMethodBeat.i(105711);
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
        break label90;
      }
    }
    label90:
    for (int i = parami.ld();; i = -1)
    {
      if (this.fQT == -1)
      {
        parami = this.fQU;
        if (parami != null) {
          parami.onPageSelected(i);
        }
      }
      this.fQT = -1;
      AppMethodBeat.o(105711);
      return localView;
      parami = null;
      break;
    }
  }
  
  public final RecyclerView.r g(RecyclerView.i parami)
  {
    Object localObject = null;
    AppMethodBeat.i(105709);
    if (!(parami instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(105709);
      return null;
    }
    RecyclerView localRecyclerView = this.fPw;
    parami = localObject;
    if (localRecyclerView != null) {
      parami = localRecyclerView.getContext();
    }
    parami = (RecyclerView.r)new b(this, parami);
    AppMethodBeat.o(105709);
    return parami;
  }
  
  public final void j(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(105708);
    super.j(paramRecyclerView);
    this.fPw = paramRecyclerView;
    AppMethodBeat.o(105708);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/layout/EmojiPagerScrollHelper$OnPageSelectedListener;", "", "onPageSelected", "", "position", "", "plugin-emojisdk_release"})
  public static abstract interface a
  {
    public abstract void onPageSelected(int paramInt);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/panel/layout/EmojiPagerScrollHelper$createScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "action", "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-emojisdk_release"})
  public static final class b
    extends ae
  {
    b(Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(105707);
      k.h(paramDisplayMetrics, "displayMetrics");
      float f = 50.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(105707);
      return f;
    }
    
    public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
    {
      AppMethodBeat.i(105706);
      k.h(paramView, "targetView");
      k.h(params, "state");
      k.h(parama, "action");
      if (this.fQV.fPw != null)
      {
        a locala = this.fQV;
        params = this.fQV.fPw;
        if (params != null) {}
        int i;
        int j;
        for (params = params.getLayoutManager();; params = null)
        {
          if (params == null) {
            k.fvU();
          }
          paramView = locala.a(params, paramView);
          if (paramView == null) {
            k.fvU();
          }
          i = paramView[0];
          j = paramView[1];
          int k = cd(Math.max(Math.abs(i), Math.abs(j)));
          if (k <= 0) {
            break;
          }
          parama.a(i, j, k, (Interpolator)this.SS);
          AppMethodBeat.o(105706);
          return;
        }
        parama.a(i, j, 1, (Interpolator)this.SS);
      }
      AppMethodBeat.o(105706);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.layout.a
 * JD-Core Version:    0.7.0.1
 */