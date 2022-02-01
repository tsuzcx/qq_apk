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
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "getActivity", "getEmptyView", "kotlin.jvm.PlatformType", "getHeaderView", "", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "", "onItemDelete", "requestLoadMore", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
  extends a.b
{
  public static final a EAf;
  
  static
  {
    AppMethodBeat.i(341893);
    EAf = new a((byte)0);
    AppMethodBeat.o(341893);
  }
  
  public b$b(MMActivity paramMMActivity, View paramView)
  {
    super(paramMMActivity, paramView);
    AppMethodBeat.i(341886);
    AppMethodBeat.o(341886);
  }
  
  public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(341915);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    Log.i("FinderFavMegaVideoUIContract.ViewCallback", s.X("onItemClick: position=", Integer.valueOf(paramInt)));
    paramInt -= ((i)parama).agOb.size();
    if ((paramInt >= 0) && (paramInt < eCN().EzZ.getSize()))
    {
      parama = (cc)eCN().EzZ.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof ca))
      {
        AppMethodBeat.o(341915);
        return;
      }
      Log.i("FinderFavMegaVideoUIContract.ViewCallback", "onItemClick " + paramInt + " id:" + parama.bZA() + ", pos:" + paramInt);
      parama = new Intent();
      parama.putExtra("KEY_ROUTER_UI", 1);
      BaseFeedLoader.saveCache$default((BaseFeedLoader)eCN().EzZ, parama, paramInt, null, 4, null);
      Object localObject = as.GSQ;
      as.a.a((Context)dSs(), parama, 0L, 0, false, 124);
      localObject = a.GfO;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      a.at(paramView, parama);
    }
    AppMethodBeat.o(341915);
  }
  
  public final void dUO()
  {
    AppMethodBeat.i(341900);
    if ((eCN().EzZ.getSize() <= 9) && (((FinderFavMegaVideoLoader)eCN().EzZ).hasMore)) {
      RefreshLoadMoreLayout.d(this.ATx);
    }
    FinderFavMegaVideoLoader localFinderFavMegaVideoLoader = (FinderFavMegaVideoLoader)eCN().EzZ;
    localFinderFavMegaVideoLoader.lNX -= 1;
    localFinderFavMegaVideoLoader.BfD -= 1;
    AppMethodBeat.o(341900);
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(341923);
    View localView = getRootView().findViewById(e.e.empty_view);
    AppMethodBeat.o(341923);
    return localView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.b.b
 * JD-Core Version:    0.7.0.1
 */