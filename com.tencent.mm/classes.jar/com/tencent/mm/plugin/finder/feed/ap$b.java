package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "req", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "title", "", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;Ljava/lang/String;)V", "TAG", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "getTitle", "()Ljava/lang/String;", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap$b
  extends c.b
{
  private final bav AYw;
  private com.tencent.mm.plugin.finder.storage.as AxD;
  private final String TAG;
  private final String title;
  
  public ap$b(MMActivity paramMMActivity, int paramInt1, int paramInt2, bav parambav, String paramString)
  {
    super(paramMMActivity, paramInt1, paramInt2);
    AppMethodBeat.i(362821);
    this.AYw = parambav;
    this.title = paramString;
    this.TAG = "Finder.FinderRelatedFeedUIContract.FavFeedViewCallback";
    this.AxD = ((com.tencent.mm.plugin.finder.storage.as)new r(paramMMActivity));
    AppMethodBeat.o(362821);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(362879);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    paramInt -= ((i)parama).agOb.size();
    if ((paramInt >= 0) && (paramInt < ebL().ALH.getSize()))
    {
      parama = (cc)ebL().ALH.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(362879);
        return;
      }
      Log.i(this.TAG, "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt);
      parama = new Intent();
      BaseFeedLoader.saveCache$default((BaseFeedLoader)ebL().ALH, parama, paramInt, null, 4, null);
      parama.putExtra("KEY_TITLE", this.title);
      parama.putExtra("KEY_REQUEST_PB", this.AYw.toByteArray());
      parama.putExtra("KEY_MORE_ACTION_TYPE", this.lzt.getIntent().getIntExtra("KEY_MORE_ACTION_TYPE", 0));
      as.a locala = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      as.a.a(paramView, parama, 0L, 0, false, 124);
      paramView = a.GfO;
      a.ak((Context)this.lzt, parama);
    }
    AppMethodBeat.o(362879);
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362889);
    s.u(paramd, "reason");
    AppMethodBeat.o(362889);
    return "";
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362897);
    s.u(paramd, "reason");
    AppMethodBeat.o(362897);
    return "";
  }
  
  public final com.tencent.mm.plugin.finder.storage.as dUN()
  {
    return this.AxD;
  }
  
  public final void dUO() {}
  
  public final boolean ebM()
  {
    return false;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(362863);
    s.u(paramContext, "context");
    paramContext = this.AxD.fT(paramContext);
    AppMethodBeat.o(362863);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(362852);
    View localView = this.lzt.findViewById(e.e.empty_view);
    AppMethodBeat.o(362852);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(362838);
    RecyclerView.h localh = this.AxD.getItemDecoration();
    AppMethodBeat.o(362838);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ap.b
 * JD-Core Version:    0.7.0.1
 */