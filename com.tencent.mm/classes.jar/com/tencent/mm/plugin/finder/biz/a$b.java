package com.tencent.mm.plugin.finder.biz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/biz/FinderBizProfileContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "bizName", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Ljava/lang/String;Lcom/tencent/mm/ui/MMActivity;IIZ)V", "SHOW_JUST_WATCHED_ICON", "getSHOW_JUST_WATCHED_ICON", "()I", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "jumpToLive", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "pos", "onGridItemClick", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  extends c.b
{
  final int AxC;
  private com.tencent.mm.plugin.finder.storage.as AxD;
  private final String ovT;
  
  private a$b(String paramString, MMActivity paramMMActivity)
  {
    super(paramMMActivity, 2, 119, false);
    AppMethodBeat.i(330513);
    this.ovT = paramString;
    this.AxC = 5;
    this.AxD = ((com.tencent.mm.plugin.finder.storage.as)new com.tencent.mm.plugin.finder.profile.a((Activity)paramMMActivity, false));
    AppMethodBeat.o(330513);
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(330551);
    s.u(parama, "adapter");
    s.u(paramView, "view");
    int i = paramInt - ((i)parama).agOb.size();
    if ((i >= 0) && (i < ebL().ALH.getSize()))
    {
      parama = (cc)ebL().ALH.getDataListJustForAdapter().get(i);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(330551);
        return;
      }
      Log.i("Finder.FinderBizProfileContract", "onClick " + i + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + i);
      paramView = aw.Gjk;
      if (aw.s((BaseFinderFeed)parama))
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)parama;
        Object localObject2;
        Object localObject3;
        long l1;
        if (Util.isEqual(localBaseFinderFeed.feedObject.getFeedObject().username, com.tencent.mm.model.z.bAW()))
        {
          parama = h.ax(f.class);
          s.s(parama, "service(IActivityRouter::class.java)");
          localObject2 = (f)parama;
          localObject3 = (Context)this.lzt;
          l1 = localBaseFinderFeed.feedObject.getFeedObject().id;
          paramView = localBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
          parama = paramView;
          if (paramView == null) {
            parama = "";
          }
          localObject1 = localBaseFinderFeed.feedObject.getFeedObject().liveInfo;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = new bip();
          }
          f.a.a((f)localObject2, (Context)localObject3, l1, parama, paramView, null, null, null, null, null, localBaseFinderFeed.getSessionBuffer(), null, null, 7152);
          AppMethodBeat.o(330551);
          return;
        }
        ((ce)h.ax(ce.class)).a(localBaseFinderFeed, paramInt, q.w.DwU, q.n.Dtx.scene);
        Intent localIntent = new Intent();
        parama = localBaseFinderFeed.feedObject.getFeedObject().liveInfo;
        f localf;
        Context localContext;
        long l2;
        label446:
        String str1;
        label517:
        String str2;
        if (parama == null)
        {
          paramInt = 0;
          localIntent.putExtra("KEY_ENTER_LIVE_PARAM_VR_LIVE_TYPE", paramInt);
          parama = localBaseFinderFeed.feedObject.getFeedObject().liveInfo;
          if (parama != null)
          {
            parama = parama.ZSn;
            if (parama != null) {
              localIntent.putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_INFO", parama.toByteArray());
            }
          }
          localf = (f)com.tencent.mm.plugin.finder.utils.a.GfO;
          localContext = (Context)this.lzt;
          l2 = localBaseFinderFeed.feedObject.getFeedObject().id;
          parama = localBaseFinderFeed.feedObject.getFeedObject().liveInfo;
          if (parama != null) {
            break label647;
          }
          l1 = 0L;
          parama = localBaseFinderFeed.feedObject.getFeedObject().username;
          localObject1 = parama;
          if (parama == null) {
            localObject1 = "";
          }
          parama = localBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
          localObject2 = parama;
          if (parama == null) {
            localObject2 = "";
          }
          str1 = localBaseFinderFeed.feedObject.getDescription();
          parama = localBaseFinderFeed.feedObject.getLiveInfo();
          if (parama != null) {
            break label656;
          }
          paramInt = 0;
          str2 = localBaseFinderFeed.getSessionBuffer();
          parama = localBaseFinderFeed.feedObject.getLiveInfo();
          if (parama != null) {
            break label664;
          }
          localObject3 = null;
          label540:
          parama = localBaseFinderFeed.feedObject.getLiveInfo();
          if (parama != null) {
            break label673;
          }
          parama = null;
          label555:
          paramView = k.aeZF;
          i = ((com.tencent.mm.plugin.finder.viewmodel.component.as)k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.as.class)).AJo;
          paramView = localBaseFinderFeed.feedObject.getLiveInfo();
          if (paramView != null) {
            break label698;
          }
          paramView = null;
        }
        for (;;)
        {
          f.a.a(localf, localIntent, localContext, l2, l1, (String)localObject1, (String)localObject2, str1, "", paramInt, str2, null, (String)localObject3, parama, i, paramView, false, 33792);
          AppMethodBeat.o(330551);
          return;
          paramInt = parama.ZSl;
          break;
          label647:
          l1 = parama.liveId;
          break label446;
          label656:
          paramInt = parama.ZRR;
          break label517;
          label664:
          localObject3 = parama.mIE;
          break label540;
          label673:
          parama = parama.ZRQ;
          if (parama == null)
          {
            parama = null;
            break label555;
          }
          parama = Integer.valueOf(parama.mNn);
          break label555;
          label698:
          paramView = paramView.ZOg;
          if (paramView == null) {
            paramView = null;
          } else {
            paramView = paramView.toByteArray();
          }
        }
      }
      paramView = new Intent();
      paramView.putExtra("KEY_BIZ_USERNAME", this.ovT);
      BaseFeedLoader.saveCache$default((BaseFeedLoader)ebL().ALH, paramView, i, null, 4, null);
      Object localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.q((Activity)this.lzt, paramView);
      paramView = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramView = as.a.hu((Context)this.lzt);
      if (paramView != null)
      {
        paramView = paramView.fou();
        if (paramView != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
          com.tencent.mm.plugin.finder.report.z.a(paramView, parama.bZA(), this.ATx.getRecyclerView(), 0, null, 24);
        }
      }
    }
    AppMethodBeat.o(330551);
  }
  
  public final void ae(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(330539);
    s.u(paramArrayList, "data");
    super.ae(paramArrayList);
    this.ATx.setEnableRefresh(false);
    this.ATx.setSuperNestedScroll(true);
    AppMethodBeat.o(330539);
  }
  
  public final String b(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(330577);
    s.u(paramd, "reason");
    AppMethodBeat.o(330577);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.d<Object> paramd)
  {
    AppMethodBeat.i(330583);
    s.u(paramd, "reason");
    AppMethodBeat.o(330583);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.storage.as dUN()
  {
    return this.AxD;
  }
  
  public final void dUO() {}
  
  public final MMFragmentActivity dUP()
  {
    return (MMFragmentActivity)this.lzt;
  }
  
  public final RecyclerView.LayoutManager fT(Context paramContext)
  {
    AppMethodBeat.i(330556);
    s.u(paramContext, "context");
    paramContext = this.AxD.fT(paramContext);
    AppMethodBeat.o(330556);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(330567);
    View localView = findViewById(e.e.empty_view);
    if ((localView instanceof View))
    {
      AppMethodBeat.o(330567);
      return localView;
    }
    AppMethodBeat.o(330567);
    return null;
  }
  
  public final View getHeaderView()
  {
    return null;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(330562);
    RecyclerView.h localh = this.AxD.getItemDecoration();
    AppMethodBeat.o(330562);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.biz.a.b
 * JD-Core Version:    0.7.0.1
 */