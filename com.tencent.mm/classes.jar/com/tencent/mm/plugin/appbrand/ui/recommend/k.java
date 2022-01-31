package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.p;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/SmoothScrollLinerLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "", "supportsPredictiveItemAnimations", "", "plugin-appbrand-integration_release"})
public final class k
  extends LinearLayoutManager
{
  private final Context context;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(135216);
    this.context = paramContext;
    AppMethodBeat.o(135216);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(135215);
    j.q(paramRecyclerView, "recyclerView");
    paramRecyclerView = new p(this.context, (LinearLayoutManager)this);
    paramRecyclerView.cg(paramInt);
    a((RecyclerView.r)paramRecyclerView);
    AppMethodBeat.o(135215);
  }
  
  public final boolean ih()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.k
 * JD-Core Version:    0.7.0.1
 */