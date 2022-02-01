package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "getActivity", "getEmptyView", "kotlin.jvm.PlatformType", "getHeaderView", "", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "", "onItemDelete", "requestLoadMore", "Companion", "plugin-finder_release"})
public final class b$b
  extends a.b
{
  public static final a zxn;
  
  static
  {
    AppMethodBeat.i(281587);
    zxn = new a((byte)0);
    AppMethodBeat.o(281587);
  }
  
  public b$b(MMActivity paramMMActivity, View paramView)
  {
    super(paramMMActivity, paramView);
    AppMethodBeat.i(281586);
    AppMethodBeat.o(281586);
  }
  
  public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(281583);
    p.k(parama, "adapter");
    p.k(paramView, "view");
    Log.i("FinderFavMegaVideoUIContract.ViewCallback", "onItemClick: position=".concat(String.valueOf(paramInt)));
    paramInt -= ((h)parama).YSk.size();
    if ((paramInt >= 0) && (paramInt < dJS().zxg.getSize()))
    {
      parama = (bu)dJS().zxg.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof bs))
      {
        AppMethodBeat.o(281583);
        return;
      }
      Log.i("FinderFavMegaVideoUIContract.ViewCallback", "onItemClick " + paramInt + " id:" + parama.mf() + ", pos:" + paramInt);
      parama = new Intent();
      parama.putExtra("KEY_ROUTER_UI", 1);
      BaseFeedLoader.saveCache$default(dJS().zxg, parama, paramInt, null, 4, null);
      Object localObject = aj.Bnu;
      aj.a.a((Context)dlC(), parama, 0L, 0, false, 124);
      localObject = a.ACH;
      paramView = paramView.getContext();
      p.j(paramView, "view.context");
      a.am(paramView, parama);
    }
    AppMethodBeat.o(281583);
  }
  
  public final void dsL()
  {
    AppMethodBeat.i(281582);
    if (dJR().zxg.getSize() <= 9)
    {
      localObject = dJR().zxg;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader");
        AppMethodBeat.o(281582);
        throw ((Throwable)localObject);
      }
      if (((FinderFavMegaVideoLoader)localObject).hasMore) {
        RefreshLoadMoreLayout.c(this.xvJ);
      }
    }
    Object localObject = dJR().zxg;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader");
      AppMethodBeat.o(281582);
      throw ((Throwable)localObject);
    }
    localObject = (FinderFavMegaVideoLoader)localObject;
    ((FinderFavMegaVideoLoader)localObject).jlf -= 1;
    ((FinderFavMegaVideoLoader)localObject).xGy -= 1;
    AppMethodBeat.o(281582);
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(281584);
    View localView = getRootView().findViewById(b.f.empty_view);
    AppMethodBeat.o(281584);
    return localView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.b.b
 * JD-Core Version:    0.7.0.1
 */