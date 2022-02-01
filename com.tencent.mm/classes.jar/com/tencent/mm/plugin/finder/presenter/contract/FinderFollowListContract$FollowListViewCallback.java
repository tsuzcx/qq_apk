package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "contentView", "Landroid/view/View;", "presenter", "isFromTeenModeSettingPage", "", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListPresent;Z)V", "MENU_ID_UNFOLLOW", "", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "emptyTip", "Landroid/widget/TextView;", "mHellScrollListener", "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "addScrollListener", "", "getActivity", "getPresenter", "initView", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "refreshList", "isDown", "startIndex", "increaseCount", "refreshTitle", "removeScrollListener", "showPopupMenu", "data", "anchor", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFollowListContract$FollowListViewCallback
  implements c<FinderFollowListContract.FollowListPresent>, HeadFooterLayout.b
{
  private WxRecyclerAdapter<aj> ALE;
  private final int ASU;
  private RefreshLoadMoreLayout ATx;
  private MMProcessBar BaP;
  private final FinderFollowListContract.FollowListPresent EXI;
  private final boolean EXJ;
  final mHellScrollListener.1 EXK;
  private final String TAG;
  private final MMActivity activity;
  private final View contentView;
  RecyclerView mkw;
  private TextView njh;
  private com.tencent.mm.ui.widget.b.a vEV;
  
  public FinderFollowListContract$FollowListViewCallback(MMActivity paramMMActivity, View paramView, FinderFollowListContract.FollowListPresent paramFollowListPresent, boolean paramBoolean)
  {
    AppMethodBeat.i(343736);
    this.activity = paramMMActivity;
    this.contentView = paramView;
    this.EXI = paramFollowListPresent;
    this.EXJ = paramBoolean;
    this.TAG = s.X("Finder.FinderFollowListContract.FollowListViewCallback.", Integer.valueOf(hashCode()));
    this.ASU = 1001;
    this.EXK = new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(343730);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(343730);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(343719);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        s.u(paramAnonymousRecyclerView, "recyclerView");
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(paramAnonymousRecyclerView, q.w.DwO, "12", com.tencent.mm.plugin.finder.live.report.d.Dne);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$mHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(343719);
      }
    };
    AppMethodBeat.o(343736);
  }
  
  private static final void a(FollowListViewCallback paramFollowListViewCallback, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(343761);
    s.u(paramFollowListViewCallback, "this$0");
    paramContextMenu.add(0, paramFollowListViewCallback.ASU, 0, (CharSequence)paramFollowListViewCallback.activity.getString(e.h.finder_unfollow));
    AppMethodBeat.o(343761);
  }
  
  private static final void a(FollowListViewCallback paramFollowListViewCallback, m paramm, aj paramaj, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(343773);
    s.u(paramFollowListViewCallback, "this$0");
    s.u(paramm, "$finderContact");
    s.u(paramaj, "$data");
    Object localObject;
    label158:
    r localr1;
    label188:
    r localr2;
    if (paramMenuItem.getItemId() == paramFollowListViewCallback.ASU)
    {
      paramaj = com.tencent.mm.ui.component.k.aeZF;
      paramaj = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramFollowListViewCallback.activity).q(as.class)).fou();
      paramaj.hLK = 12;
      paramMenuItem = com.tencent.mm.plugin.finder.model.ak.ECS;
      paramMenuItem = paramm.getUsername();
      localObject = bh.ABm;
      com.tencent.mm.plugin.finder.model.ak.a(paramaj, paramMenuItem, bh.dVs(), 0L, false, false, 0, 240);
      paramMenuItem = (com.tencent.mm.plugin.datareport.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.datareport.a.b.class);
      paramaj = as.GSQ;
      paramaj = as.a.hu((Context)paramFollowListViewCallback.activity);
      if (paramaj != null) {
        break label323;
      }
      paramaj = null;
      localObject = v.Y("session_id", paramaj);
      paramaj = as.GSQ;
      paramaj = as.a.hu((Context)paramFollowListViewCallback.activity);
      if (paramaj != null) {
        break label331;
      }
      paramaj = null;
      localr1 = v.Y("finder_context_id", paramaj);
      paramaj = as.GSQ;
      paramaj = as.a.hu((Context)paramFollowListViewCallback.activity);
      if (paramaj != null) {
        break label339;
      }
      paramaj = null;
      localr2 = v.Y("finder_tab_context_id", paramaj);
      paramaj = as.GSQ;
      paramaj = as.a.hu((Context)paramFollowListViewCallback.activity);
      if (paramaj != null) {
        break label347;
      }
    }
    label323:
    label331:
    label339:
    label347:
    for (paramaj = null;; paramaj = Integer.valueOf(paramaj.AJo))
    {
      paramMenuItem.a("un_follow_click", null, kotlin.a.ak.e(new r[] { localObject, localr1, localr2, v.Y("comment_scene", paramaj) }), 24617);
      paramaj = com.tencent.mm.plugin.finder.upload.action.f.GcR;
      com.tencent.mm.plugin.finder.upload.action.f.e(1, paramm.getUsername(), true);
      if (paramFollowListViewCallback.EXJ) {
        com.tencent.mm.plugin.report.service.h.OAn.b(20911, new Object[] { Integer.valueOf(3), paramm.getUsername(), paramm.getNickname() });
      }
      AppMethodBeat.o(343773);
      return;
      paramaj = paramaj.sessionId;
      break;
      paramaj = paramaj.zIO;
      break label158;
      paramaj = paramaj.zIB;
      break label188;
    }
  }
  
  private static final boolean a(FollowListViewCallback paramFollowListViewCallback, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(343749);
    s.u(paramFollowListViewCallback, "this$0");
    paramFollowListViewCallback.activity.finish();
    AppMethodBeat.o(343749);
    return true;
  }
  
  private static final boolean b(FollowListViewCallback paramFollowListViewCallback, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(343757);
    s.u(paramFollowListViewCallback, "this$0");
    paramMenuItem = com.tencent.mm.plugin.finder.search.k.FxZ;
    com.tencent.mm.plugin.finder.search.k.a(null);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("request_type", 3);
    paramMenuItem.putExtra("need_history", false);
    com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.U((Context)paramFollowListViewCallback.activity, paramMenuItem);
    AppMethodBeat.o(343757);
    return true;
  }
  
  public final boolean NK(int paramInt)
  {
    AppMethodBeat.i(343873);
    Log.i(this.TAG, s.X("[onOverEnd] dy=", Integer.valueOf(paramInt)));
    AppMethodBeat.o(343873);
    return false;
  }
  
  public final void eHZ()
  {
    Object localObject = null;
    TextView localTextView1 = null;
    AppMethodBeat.i(343855);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcN, 0);
    this.activity.setMMTitle(c.a.a(this).getString(e.h.finder_my_follow_contact_number, new Object[] { Integer.valueOf(i) }));
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
      this.activity.setMMSubTitle(c.a.a(this).getString(e.h.finder_teen_mode_follow_sub_tip));
    }
    if (i == 0)
    {
      TextView localTextView2 = this.njh;
      localObject = localTextView2;
      if (localTextView2 == null)
      {
        s.bIx("emptyTip");
        localObject = null;
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.njh;
      if (localObject == null)
      {
        s.bIx("emptyTip");
        localObject = localTextView1;
      }
      for (;;)
      {
        ((TextView)localObject).setText((CharSequence)this.activity.getString(e.h.finder_follow_contact_empty_tip));
        AppMethodBeat.o(343855);
        return;
      }
    }
    localTextView1 = this.njh;
    if (localTextView1 == null) {
      s.bIx("emptyTip");
    }
    for (;;)
    {
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(343855);
      return;
      localObject = localTextView1;
    }
  }
  
  public final void ecZ()
  {
    AppMethodBeat.i(343862);
    Log.i(this.TAG, "[onOverStop]");
    MMProcessBar localMMProcessBar2 = this.BaP;
    MMProcessBar localMMProcessBar1 = localMMProcessBar2;
    if (localMMProcessBar2 == null)
    {
      s.bIx("rlProcessBar");
      localMMProcessBar1 = null;
    }
    localMMProcessBar1.jEP();
    AppMethodBeat.o(343862);
  }
  
  public final void i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = null;
    Object localObject1 = null;
    AppMethodBeat.i(343848);
    if ((paramInt1 >= 0) && (paramInt2 > 0))
    {
      localObject2 = this.ALE;
      if (localObject2 != null) {
        ((WxRecyclerAdapter)localObject2).bA(paramInt1, paramInt2);
      }
      if (!paramBoolean) {
        break label144;
      }
      localObject2 = new RefreshLoadMoreLayout.d(0);
      ((RefreshLoadMoreLayout.d)localObject2).agJu = this.EXI.hasMore;
      ((RefreshLoadMoreLayout.d)localObject2).agJv = paramInt2;
      if (((RefreshLoadMoreLayout.d)localObject2).agJv > 0) {
        ((RefreshLoadMoreLayout.d)localObject2).pzq = false;
      }
      localRefreshLoadMoreLayout = this.ATx;
      if (localRefreshLoadMoreLayout != null) {
        break label137;
      }
      s.bIx("rlLayout");
    }
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject1).onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.d)localObject2);
      AppMethodBeat.o(343848);
      return;
      localObject2 = this.ALE;
      if (localObject2 == null) {
        break;
      }
      ((RecyclerView.a)localObject2).bZE.notifyChanged();
      break;
      label137:
      localObject1 = localRefreshLoadMoreLayout;
    }
    label144:
    Object localObject2 = this.ATx;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("rlLayout");
      localObject1 = null;
    }
    ((RefreshLoadMoreLayout)localObject1).aFV(0);
    if (!this.EXI.hasMore)
    {
      localObject1 = this.ATx;
      if (localObject1 != null) {
        break label217;
      }
      s.bIx("rlLayout");
      localObject1 = localRefreshLoadMoreLayout;
    }
    label217:
    for (;;)
    {
      RefreshLoadMoreLayout.e((RefreshLoadMoreLayout)localObject1);
      AppMethodBeat.o(343848);
      return;
    }
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(343841);
    Object localObject1 = this.contentView.findViewById(e.e.rl_layout);
    s.s(localObject1, "contentView.findViewById(R.id.rl_layout)");
    this.ATx = ((RefreshLoadMoreLayout)localObject1);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    localObject1 = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      s.bIx("rlLayout");
      localObject1 = null;
    }
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest((int)MMApplicationContext.getContext().getResources().getDimension(e.c.finder_timeline_refresh_height) - (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_12A));
    localRefreshLoadMoreLayout = this.ATx;
    localObject1 = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      s.bIx("rlLayout");
      localObject1 = null;
    }
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY((int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_7A) - (int)MMApplicationContext.getContext().getResources().getDimension(e.c.finder_timeline_refresh_height));
    localRefreshLoadMoreLayout = this.ATx;
    localObject1 = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      s.bIx("rlLayout");
      localObject1 = null;
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.contentView.findViewById(e.e.rl_loading_icon);
    s.s(localObject1, "contentView.findViewById…ar>(R.id.rl_loading_icon)");
    this.BaP = ((MMProcessBar)localObject1);
    localRefreshLoadMoreLayout = this.ATx;
    localObject1 = localRefreshLoadMoreLayout;
    if (localRefreshLoadMoreLayout == null)
    {
      s.bIx("rlLayout");
      localObject1 = null;
    }
    this.mkw = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
    localObject1 = this.mkw;
    if (localObject1 == null)
    {
      s.bIx("recyclerView");
      localObject1 = null;
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      this.ALE = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new com.tencent.mm.view.recyclerview.g()
      {
        public final com.tencent.mm.view.recyclerview.f<?> yF(int paramAnonymousInt)
        {
          AppMethodBeat.i(343461);
          if (paramAnonymousInt == aj.class.getName().hashCode())
          {
            localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.ak();
            AppMethodBeat.o(343461);
            return localObject;
          }
          Object localObject = av.GiL;
          av.eY(FinderFollowListContract.FollowListViewCallback.c(this.EXL), paramAnonymousInt);
          localObject = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
          AppMethodBeat.o(343461);
          return localObject;
        }
      }, this.EXI.pUj, true);
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label596;
      }
      s.bIx("recyclerView");
      localObject1 = null;
      label291:
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.ALE);
      localObject1 = this.ALE;
      s.checkNotNull(localObject1);
      ((i)localObject1).agOe = ((i.c)new i.c() {});
      localObject1 = this.ALE;
      s.checkNotNull(localObject1);
      ((i)localObject1).agOd = ((i.d)new i.d() {});
      localObject1 = this.ATx;
      if (localObject1 != null) {
        break label599;
      }
      s.bIx("rlLayout");
      localObject1 = null;
      label367:
      ((RefreshLoadMoreLayout)localObject1).setOverCallback((HeadFooterLayout.b)this);
      localObject1 = this.ATx;
      if (localObject1 != null) {
        break label602;
      }
      s.bIx("rlLayout");
      localObject1 = null;
      label392:
      ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.b)new RefreshLoadMoreLayout.b()
      {
        public final void IH(int paramAnonymousInt)
        {
          AppMethodBeat.i(343460);
          super.IH(paramAnonymousInt);
          FinderFollowListContract.FollowListViewCallback.d(this.EXL).AyB = null;
          FinderFollowListContract.FollowListViewCallback.d(this.EXL).tc(false);
          AppMethodBeat.o(343460);
        }
        
        public final void a(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
        {
          AppMethodBeat.i(343477);
          s.u(paramAnonymousd, "reason");
          super.a(paramAnonymousd);
          if (!FinderFollowListContract.FollowListViewCallback.d(this.EXL).hasMore)
          {
            RefreshLoadMoreLayout localRefreshLoadMoreLayout = FinderFollowListContract.FollowListViewCallback.g(this.EXL);
            paramAnonymousd = localRefreshLoadMoreLayout;
            if (localRefreshLoadMoreLayout == null)
            {
              s.bIx("rlLayout");
              paramAnonymousd = null;
            }
            RefreshLoadMoreLayout.e(paramAnonymousd);
          }
          AppMethodBeat.o(343477);
        }
        
        public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
        {
          AppMethodBeat.i(343469);
          s.u(paramAnonymousd, "reason");
          super.onRefreshEnd(paramAnonymousd);
          if (paramAnonymousd.agJu)
          {
            localRefreshLoadMoreLayout = FinderFollowListContract.FollowListViewCallback.g(this.EXL);
            paramAnonymousd = localRefreshLoadMoreLayout;
            if (localRefreshLoadMoreLayout == null)
            {
              s.bIx("rlLayout");
              paramAnonymousd = null;
            }
            if (!paramAnonymousd.agJe)
            {
              localRefreshLoadMoreLayout = FinderFollowListContract.FollowListViewCallback.g(this.EXL);
              paramAnonymousd = localRefreshLoadMoreLayout;
              if (localRefreshLoadMoreLayout == null)
              {
                s.bIx("rlLayout");
                paramAnonymousd = null;
              }
              paramAnonymousd.setHasBottomMore(true);
              localRefreshLoadMoreLayout = FinderFollowListContract.FollowListViewCallback.g(this.EXL);
              paramAnonymousd = localRefreshLoadMoreLayout;
              if (localRefreshLoadMoreLayout == null)
              {
                s.bIx("rlLayout");
                paramAnonymousd = null;
              }
              paramAnonymousd = paramAnonymousd.getLoadMoreFooter();
              if (paramAnonymousd != null)
              {
                paramAnonymousd = (TextView)paramAnonymousd.findViewById(e.e.load_more_footer_tip_tv);
                if (paramAnonymousd != null) {
                  paramAnonymousd.setVisibility(0);
                }
              }
              localRefreshLoadMoreLayout = FinderFollowListContract.FollowListViewCallback.g(this.EXL);
              paramAnonymousd = localRefreshLoadMoreLayout;
              if (localRefreshLoadMoreLayout == null)
              {
                s.bIx("rlLayout");
                paramAnonymousd = null;
              }
              paramAnonymousd = paramAnonymousd.getLoadMoreFooter();
              if (paramAnonymousd != null)
              {
                paramAnonymousd = paramAnonymousd.findViewById(e.e.load_more_footer_end_layout);
                if (paramAnonymousd != null) {
                  paramAnonymousd.setVisibility(8);
                }
              }
            }
          }
          RefreshLoadMoreLayout localRefreshLoadMoreLayout = FinderFollowListContract.FollowListViewCallback.g(this.EXL);
          paramAnonymousd = localRefreshLoadMoreLayout;
          if (localRefreshLoadMoreLayout == null)
          {
            s.bIx("rlLayout");
            paramAnonymousd = null;
          }
          RefreshLoadMoreLayout.c(paramAnonymousd);
          ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(null, q.w.DwO, "12", com.tencent.mm.plugin.finder.live.report.d.Dnh);
          AppMethodBeat.o(343469);
        }
        
        public final void qI(int paramAnonymousInt)
        {
          AppMethodBeat.i(343472);
          super.qI(paramAnonymousInt);
          FinderFollowListContract.FollowListViewCallback.d(this.EXL).tc(true);
          AppMethodBeat.o(343472);
        }
      });
      localObject1 = this.contentView.findViewById(e.e.empty_tip);
      s.s(localObject1, "contentView.findViewById<TextView>(R.id.empty_tip)");
      this.njh = ((TextView)localObject1);
      eHZ();
      this.vEV = new com.tencent.mm.ui.widget.b.a((Context)this.activity);
      this.activity.setBackBtn(new FinderFollowListContract.FollowListViewCallback..ExternalSyntheticLambda0(this));
      localObject1 = this.EXI;
      com.tencent.mm.ae.d.b(com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.bbX(), (kotlin.g.a.b)new FinderFollowListContract.FollowListPresent.loadStart.1((FinderFollowListContract.FollowListPresent)localObject1)), (kotlin.g.a.b)new FinderFollowListContract.FollowListPresent.loadStart.2((FinderFollowListContract.FollowListPresent)localObject1));
      ((FinderFollowListContract.FollowListPresent)localObject1).tc(false);
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if ((com.tencent.mm.plugin.finder.storage.d.eQV()) && (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())) {
        this.activity.addIconOptionMenu(0, e.g.icons_outlined_search, new FinderFollowListContract.FollowListViewCallback..ExternalSyntheticLambda1(this));
      }
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label605;
      }
      s.bIx("recyclerView");
      localObject1 = localObject2;
    }
    label596:
    label599:
    label602:
    label605:
    for (;;)
    {
      ((RecyclerView)localObject1).a((RecyclerView.l)this.EXK);
      AppMethodBeat.o(343841);
      return;
      break;
      break label291;
      break label367;
      break label392;
    }
  }
  
  public final boolean v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(343868);
    Log.i(this.TAG, s.X("[onOverStart] dy=", Integer.valueOf(paramInt1)));
    MMProcessBar localMMProcessBar2 = this.BaP;
    MMProcessBar localMMProcessBar1 = localMMProcessBar2;
    if (localMMProcessBar2 == null)
    {
      s.bIx("rlProcessBar");
      localMMProcessBar1 = null;
    }
    localMMProcessBar1.ed(paramInt1 / (int)MMApplicationContext.getContext().getResources().getDimension(e.c.Edge_26A));
    AppMethodBeat.o(343868);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract.FollowListViewCallback
 * JD-Core Version:    0.7.0.1
 */