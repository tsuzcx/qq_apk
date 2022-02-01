package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "getActivity", "getEmptyView", "kotlin.jvm.PlatformType", "getHeaderView", "", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "", "onItemDelete", "requestLoadMore", "Companion", "plugin-finder_release"})
public final class c$b
  extends a.b
{
  public static final a uLO;
  
  static
  {
    AppMethodBeat.i(248507);
    uLO = new a((byte)0);
    AppMethodBeat.o(248507);
  }
  
  public c$b(MMActivity paramMMActivity, View paramView)
  {
    super(paramMMActivity, paramView);
    AppMethodBeat.i(248506);
    AppMethodBeat.o(248506);
  }
  
  public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(248504);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    Log.i("FinderLikeMegaVideoUIContract.ViewCallback", "onItemClick: position=".concat(String.valueOf(paramInt)));
    paramInt -= ((g)parama).RqM.size();
    if ((paramInt >= 0) && (paramInt < dkn().uLF.getSize()))
    {
      parama = (bo)dkn().uLF.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof bm))
      {
        AppMethodBeat.o(248504);
        return;
      }
      Log.i("FinderLikeMegaVideoUIContract.ViewCallback", "onItemClick " + paramInt + " id:" + parama.lT() + ", pos:" + paramInt);
      parama = new Intent();
      parama.putExtra("KEY_ROUTER_UI", 2);
      BaseFeedLoader.saveCache$default(dkn().uLF, parama, paramInt, null, 4, null);
      Object localObject = FinderReporterUIC.wzC;
      FinderReporterUIC.a.a((Context)this.gte, parama, 0L, 0, false, 124);
      localObject = a.vUU;
      paramView = paramView.getContext();
      p.g(paramView, "view.context");
      a.ag(paramView, parama);
    }
    AppMethodBeat.o(248504);
  }
  
  public final void dcv()
  {
    AppMethodBeat.i(248503);
    if (dkm().uLF.getSize() <= 9)
    {
      localObject = dkm().uLF;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader");
        AppMethodBeat.o(248503);
        throw ((Throwable)localObject);
      }
      if (((FinderLikeMegaVideoLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.c(this.tLS);
      }
    }
    Object localObject = dkm().uLF;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader");
      AppMethodBeat.o(248503);
      throw ((Throwable)localObject);
    }
    localObject = (FinderLikeMegaVideoLoader)localObject;
    ((FinderLikeMegaVideoLoader)localObject).gAZ -= 1;
    ((FinderLikeMegaVideoLoader)localObject).tUU -= 1;
    AppMethodBeat.o(248503);
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(248505);
    View localView = this.lJI.findViewById(2131300111);
    AppMethodBeat.o(248505);
    return localView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.c.b
 * JD-Core Version:    0.7.0.1
 */