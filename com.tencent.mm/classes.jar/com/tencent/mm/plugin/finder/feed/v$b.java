package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderHotWordFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderHotWordFeedUIContract$HotWordFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "hotWordHeader", "Landroid/view/View;", "getHotWordHeader", "()Landroid/view/View;", "setHotWordHeader", "(Landroid/view/View;)V", "needRefreshWhenEnter", "getNeedRefreshWhenEnter", "()Z", "setNeedRefreshWhenEnter", "(Z)V", "topic", "getTopic", "()Ljava/lang/String;", "setTopic", "(Ljava/lang/String;)V", "type", "getType", "()I", "setType", "(I)V", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshWhenEnter", "showHeaderOnDataEmpty", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v$b
  extends c.b
{
  private View AWc;
  private boolean AWd;
  private final String TAG;
  public String topic;
  public int type;
  
  private v$b(MMActivity paramMMActivity, int paramInt)
  {
    super(paramMMActivity, 2, 115, false);
    AppMethodBeat.i(362571);
    this.TAG = "Finder.FinderHotWordFeedUIContract.HotWordFeedViewCallback";
    this.topic = "";
    this.AWd = true;
    AppMethodBeat.o(362571);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(362606);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    paramInt -= ((i)parama).agOb.size();
    if ((paramInt >= 0) && (paramInt < ebL().ALH.getSize()))
    {
      parama = ((BaseFinderFeed)ebL().ALH.getListOfType(BaseFinderFeed.class).get(paramInt)).feedObject;
      Log.i(this.TAG, "onClick " + paramInt + " id:" + parama.getId() + ", pos:" + paramInt);
      Object localObject1 = k.aeZF;
      Object localObject2 = ((b)k.cn(PluginFinder.class).q(b.class)).dUh();
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_topic_type", this.type);
      ((Intent)localObject1).putExtra("key_topic_title", this.topic);
      ((Intent)localObject1).putExtra("FEED_ID", parama.getId());
      ((Intent)localObject1).putExtra("FEED_NONCE_ID", parama.getFeedObject().objectNonceId);
      ((Intent)localObject1).putExtra("TITLE_WORDING", "");
      ((Intent)localObject1).putExtra("GET_REL_SCENE", 24);
      ((Intent)localObject1).putExtra("POI_LATITUDE", ((Number)((r)localObject2).bsD).floatValue());
      ((Intent)localObject1).putExtra("POI_LONGITUDE", ((Number)((r)localObject2).bsC).floatValue());
      BaseFeedLoader.saveCache$default((BaseFeedLoader)ebL().ALH, (Intent)localObject1, paramInt, null, 4, null);
      ((FinderHotWordFeedLoader)ebL().ALH).BgA = null;
      Log.i(this.TAG, s.X("enterTimelineUI, fixPos:", Integer.valueOf(paramInt)));
      localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      as.a.a((Context)this.lzt, (Intent)localObject1, 0L, 0, false, 124);
      a.GfO.m((Context)this.lzt, (Intent)localObject1);
      localObject1 = z.FrZ;
      z.ab(parama.getId(), getScene());
      localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramView = paramView.getContext();
      s.s(paramView, "view.context");
      paramView = as.a.hu(paramView);
      if (paramView != null)
      {
        paramView = paramView.fou();
        if (paramView != null)
        {
          localObject1 = z.FrZ;
          z.a(paramView, parama.getId(), this.ATx.getRecyclerView(), this.type, null, 16);
        }
      }
    }
    AppMethodBeat.o(362606);
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362642);
    s.u(paramd, "reason");
    AppMethodBeat.o(362642);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(362649);
    s.u(paramd, "reason");
    AppMethodBeat.o(362649);
    return null;
  }
  
  public final void dUO() {}
  
  public final boolean ebM()
  {
    return this.AWd;
  }
  
  public final boolean ebN()
  {
    return false;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(362613);
    s.u(paramContext, "context");
    paramContext = dUN().fT(paramContext);
    AppMethodBeat.o(362613);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(362630);
    View localView = this.lzt.findViewById(e.e.empty_view);
    AppMethodBeat.o(362630);
    return localView;
  }
  
  public final View getHeaderView()
  {
    return this.AWc;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(362621);
    RecyclerView.h localh = dUN().getItemDecoration();
    AppMethodBeat.o(362621);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.v.b
 * JD-Core Version:    0.7.0.1
 */