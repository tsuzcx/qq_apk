package com.tencent.mm.plugin.finder.megavideo.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "getActivity", "getEmptyView", "kotlin.jvm.PlatformType", "getHeaderView", "", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "", "onItemDelete", "requestLoadMore", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
  extends a.b
{
  public static final a EAh;
  
  static
  {
    AppMethodBeat.i(342006);
    EAh = new a((byte)0);
    AppMethodBeat.o(342006);
  }
  
  public c$b(MMActivity paramMMActivity, View paramView)
  {
    super(paramMMActivity, paramView);
    AppMethodBeat.i(342001);
    AppMethodBeat.o(342001);
  }
  
  public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(342026);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    Log.i("FinderLikeMegaVideoUIContract.ViewCallback", s.X("onItemClick: position=", Integer.valueOf(paramInt)));
    paramInt -= ((i)parama).agOb.size();
    if ((paramInt >= 0) && (paramInt < eCN().EzZ.getSize()))
    {
      parama = (cc)eCN().EzZ.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof ca))
      {
        AppMethodBeat.o(342026);
        return;
      }
      Log.i("FinderLikeMegaVideoUIContract.ViewCallback", "onItemClick " + paramInt + " id:" + parama.bZA() + ", pos:" + paramInt);
      parama = new Intent();
      parama.putExtra("KEY_ROUTER_UI", 2);
      BaseFeedLoader.saveCache$default((BaseFeedLoader)eCN().EzZ, parama, paramInt, null, 4, null);
      Object localObject = as.GSQ;
      as.a.a((Context)dSs(), parama, 0L, 0, false, 124);
      localObject = a.GfO;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      a.at(paramView, parama);
    }
    AppMethodBeat.o(342026);
  }
  
  public final void dUO()
  {
    AppMethodBeat.i(342012);
    if ((eCN().EzZ.getSize() <= 9) && (((FinderLikeMegaVideoLoader)eCN().EzZ).hasMore)) {
      RefreshLoadMoreLayout.d(this.ATx);
    }
    FinderLikeMegaVideoLoader localFinderLikeMegaVideoLoader = (FinderLikeMegaVideoLoader)eCN().EzZ;
    localFinderLikeMegaVideoLoader.lNX -= 1;
    localFinderLikeMegaVideoLoader.BfD -= 1;
    AppMethodBeat.o(342012);
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(342032);
    View localView = getRootView().findViewById(e.e.empty_view);
    AppMethodBeat.o(342032);
    return localView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.c.b
 * JD-Core Version:    0.7.0.1
 */