package com.tencent.mm.plugin.finder.megavideo.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "targetUsername", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Ljava/lang/String;)V", "getTargetUsername", "()Ljava/lang/String;", "getActivity", "getEmptyView", "kotlin.jvm.PlatformType", "getHeaderView", "", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "", "onItemDelete", "onViewPrepared", "requestLoadMore", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$b
  extends a.b
{
  public static final a EAI;
  private final String ACm;
  
  static
  {
    AppMethodBeat.i(341914);
    EAI = new a((byte)0);
    AppMethodBeat.o(341914);
  }
  
  public d$b(MMActivity paramMMActivity, View paramView, String paramString)
  {
    super(paramMMActivity, paramView);
    AppMethodBeat.i(341907);
    this.ACm = paramString;
    AppMethodBeat.o(341907);
  }
  
  public final void b(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(341936);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    Log.i("FinderLikeMegaVideoUIContract.ViewCallback", s.X("onItemClick: position=", Integer.valueOf(paramInt)));
    paramInt -= ((i)parama).agOb.size();
    if ((paramInt >= 0) && (paramInt < eCN().EzZ.getSize()))
    {
      parama = (cc)eCN().EzZ.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof ca))
      {
        AppMethodBeat.o(341936);
        return;
      }
      Log.i("FinderLikeMegaVideoUIContract.ViewCallback", "onItemClick " + paramInt + " id:" + parama.bZA() + ", pos:" + paramInt);
      if (((ca)parama).EDG != null)
      {
        localObject = ((ca)parama).EDG;
        s.checkNotNull(localObject);
        if (!((FinderItem)localObject).isPostFinish())
        {
          paramView = new djh();
          localObject = paramView.mediaList;
          parama = ((ca)parama).EDG;
          s.checkNotNull(parama);
          ((LinkedList)localObject).addAll((Collection)parama.getLongVideoMediaList());
          parama = a.GfO;
          a.a((Activity)dSs(), null, paramView, null, true, false, 40);
          AppMethodBeat.o(341936);
          return;
        }
      }
      parama = new Intent();
      parama.putExtra("KEY_ROUTER_UI", 3);
      parama.putExtra("finder_username", this.ACm);
      parama.putExtra("KEY_FINDER_SELF_FLAG", s.p(this.ACm, z.bAW()));
      BaseFeedLoader.saveCache$default((BaseFeedLoader)eCN().EzZ, parama, paramInt, null, 4, null);
      Object localObject = as.GSQ;
      as.a.a((Context)dSs(), parama, 0L, 0, false, 124);
      localObject = a.GfO;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      a.at(paramView, parama);
    }
    AppMethodBeat.o(341936);
  }
  
  public final void dUO()
  {
    AppMethodBeat.i(341925);
    if ((eCN().EzZ.getSize() <= 9) && (((FinderMegaVideoProfileLoader)eCN().EzZ).hasMore)) {
      RefreshLoadMoreLayout.d(this.ATx);
    }
    AppMethodBeat.o(341925);
  }
  
  public final void ebi()
  {
    AppMethodBeat.i(341922);
    this.ATx.setSuperNestedScroll(true);
    this.ATx.setEnableRefresh(false);
    super.ebi();
    AppMethodBeat.o(341922);
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(341941);
    View localView = getRootView().findViewById(e.e.empty_view);
    AppMethodBeat.o(341941);
    return localView;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.d.b
 * JD-Core Version:    0.7.0.1
 */