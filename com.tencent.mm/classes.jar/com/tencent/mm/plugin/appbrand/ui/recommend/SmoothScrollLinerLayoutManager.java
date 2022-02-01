package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/SmoothScrollLinerLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "", "supportsPredictiveItemAnimations", "", "plugin-appbrand-integration_release"})
public final class SmoothScrollLinerLayoutManager
  extends LinearLayoutManager
{
  private final Context context;
  
  public SmoothScrollLinerLayoutManager(Context paramContext)
  {
    AppMethodBeat.i(51392);
    this.context = paramContext;
    AppMethodBeat.o(51392);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    AppMethodBeat.i(51391);
    p.h(paramRecyclerView, "recyclerView");
    paramRecyclerView = new o(this.context, (LinearLayoutManager)this);
    paramRecyclerView.cz(paramInt);
    a((RecyclerView.s)paramRecyclerView);
    AppMethodBeat.o(51391);
  }
  
  public final boolean ka()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.SmoothScrollLinerLayoutManager
 * JD-Core Version:    0.7.0.1
 */