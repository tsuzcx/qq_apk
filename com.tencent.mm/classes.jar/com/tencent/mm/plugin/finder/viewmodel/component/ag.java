package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.initAndRefreshAll.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.initAndRefreshAll.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.initRefreshLayout..inlined.apply.lambda.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.initView.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.initView.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.initView.3;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.initView.4;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.initView.5;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.refresh.1;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI;
import com.tencent.mm.plugin.finder.viewmodel.e;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import com.tencent.mm.view.recyclerview.m;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderNotifyUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "isRefreshed", "", "lastTabIndex", "getLastTabIndex", "setLastTabIndex", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "redDotCount", "getRedDotCount", "setRedDotCount", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback;", "getActiveIndex", "getLayoutId", "getPresenter", "onCreateAfter", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleFocused", "onUserVisibleUnFocused", "refreshSelf", "reportExpose", "setRedDot", "unsetRedDotCount", "Companion", "plugin-finder_release"})
public final class ag
  extends UIComponent
  implements i, FinderNotifyContract.NotifyViewCallback.UICallbackListener
{
  private static final String[] BmC;
  public static final a BmD;
  private boolean BmA;
  private FinderNotifyContract.NotifyViewCallback BmB;
  private int Bmy;
  private int Bmz;
  public int index;
  private FinderNotifyContract.NotifyPresenter zPr;
  
  static
  {
    AppMethodBeat.i(290480);
    BmD = new a((byte)0);
    BmC = new String[] { "NotificationCenterLike", "NotificationCenterComment", "NotificationCenterFollow" };
    AppMethodBeat.o(290480);
  }
  
  public ag(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(290479);
    this.index = -1;
    AppMethodBeat.o(290479);
  }
  
  private final void cBa()
  {
    AppMethodBeat.i(290472);
    Object localObject1 = a.RS(this.index);
    Object localObject2 = h.ag(PluginFinder.class);
    p.j(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
    localObject2 = ((PluginFinder)localObject2).getRedDotManager().aBf((String)localObject1);
    Object localObject3 = h.ag(PluginFinder.class);
    p.j(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
    localObject3 = ((PluginFinder)localObject3).getRedDotManager().aBe((String)localObject1);
    localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
    Fragment localFragment = getFragment();
    if ((localObject2 != null) && (localObject3 != null) && (localFragment != null))
    {
      localObject1 = com.tencent.mm.plugin.finder.report.l.zWx;
      localObject1 = aj.Bnu;
      localObject1 = localFragment.getActivity();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(290472);
        throw ((Throwable)localObject1);
      }
      localObject1 = aj.a.fZ((Context)localObject1);
      if (localObject1 != null) {}
      for (localObject1 = ((aj)localObject1).ekY();; localObject1 = null)
      {
        com.tencent.mm.plugin.finder.report.l.a("5", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject3, 1, (bid)localObject1, 0, 0, null, 224);
        if (this.Bmy != this.index) {
          break label240;
        }
        localObject1 = com.tencent.mm.plugin.finder.report.l.zWx;
        localObject1 = aj.Bnu;
        localObject1 = localFragment.getActivity();
        if (localObject1 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(290472);
        throw ((Throwable)localObject1);
      }
      localObject1 = aj.a.fZ((Context)localObject1);
      if (localObject1 == null) {
        break label246;
      }
    }
    label240:
    label246:
    for (localObject1 = ((aj)localObject1).ekY();; localObject1 = null)
    {
      com.tencent.mm.plugin.finder.report.l.a("5", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject2, (bkn)localObject3, 3, (bid)localObject1, 1, 0, null, 192);
      AppMethodBeat.o(290472);
      return;
    }
  }
  
  private final FinderNotifyContract.NotifyPresenter ekQ()
  {
    AppMethodBeat.i(290477);
    Object localObject = getFragment();
    if (localObject != null)
    {
      localObject = ((Fragment)localObject).getActivity();
      if (!(localObject instanceof FinderFinderMsgUI)) {
        break label86;
      }
      localObject = getFragment();
      if (localObject == null) {
        break label66;
      }
    }
    label66:
    for (localObject = ((Fragment)localObject).getActivity();; localObject = null)
    {
      if (localObject != null) {
        break label71;
      }
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI");
      AppMethodBeat.o(290477);
      throw ((Throwable)localObject);
      localObject = null;
      break;
    }
    label71:
    localObject = ((FinderFinderMsgUI)localObject).zPr;
    AppMethodBeat.o(290477);
    return localObject;
    label86:
    AppMethodBeat.o(290477);
    return null;
  }
  
  public final void a(an paraman)
  {
    AppMethodBeat.i(290478);
    p.k(paraman, "mention");
    AppMethodBeat.o(290478);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_msg_notify_content_ui;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(290471);
    super.onCreateAfter(paramBundle);
    paramBundle = g.Xox;
    this.Bmy = ((e)g.bD(PluginFinder.class).i(e.class)).eke();
    this.zPr = ekQ();
    paramBundle = getFragment();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getActivity(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(290471);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    Object localObject1 = getRootView();
    Object localObject2 = ekQ();
    if (localObject2 == null) {
      p.iCn();
    }
    localObject1 = new FinderNotifyContract.NotifyViewCallback(paramBundle, (View)localObject1, (FinderNotifyContract.NotifyPresenter)localObject2, (FinderNotifyContract.NotifyViewCallback.UICallbackListener)this, this.index);
    paramBundle = this.zPr;
    if (paramBundle != null) {
      paramBundle.a((FinderNotifyContract.NotifyViewCallback)localObject1);
    }
    ((FinderNotifyContract.NotifyViewCallback)localObject1).xvJ = ((RefreshLoadMoreLayout)((FinderNotifyContract.NotifyViewCallback)localObject1).contentView.findViewById(b.f.rl_layout));
    if (!((FinderNotifyContract.NotifyViewCallback)localObject1).zPq)
    {
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).xvJ;
      if (paramBundle != null) {
        paramBundle.setEnableRefresh(false);
      }
      ((FinderNotifyContract.NotifyViewCallback)localObject1).szq = new com.tencent.mm.ui.widget.b.a((Context)((FinderNotifyContract.NotifyViewCallback)localObject1).iXq);
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).contentView.findViewById(b.f.notify_recycler_view);
      p.j(paramBundle, "contentView.findViewById….id.notify_recycler_view)");
      ((FinderNotifyContract.NotifyViewCallback)localObject1).jLl = ((RecyclerView)paramBundle);
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      ((FinderNotifyContract.NotifyViewCallback)localObject1).zOP = ((TextView)((FinderNotifyContract.NotifyViewCallback)localObject1).contentView.findViewById(b.f.notify_refresh_tip));
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).zOP;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new FinderNotifyContract.NotifyViewCallback.initView.1((FinderNotifyContract.NotifyViewCallback)localObject1));
      }
      ((FinderNotifyContract.NotifyViewCallback)localObject1).xnR = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new FinderNotifyContract.NotifyViewCallback.initView.2((FinderNotifyContract.NotifyViewCallback)localObject1), ((FinderNotifyContract.NotifyViewCallback)localObject1).zPr.OW(((FinderNotifyContract.NotifyViewCallback)localObject1).zPu), true);
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).xnR;
      if (paramBundle != null) {
        paramBundle.YTa = ((m)new FinderNotifyContract.NotifyViewCallback.initView.3((FinderNotifyContract.NotifyViewCallback)localObject1));
      }
      paramBundle = aj.Bnu;
      paramBundle = aj.a.fZ((Context)((FinderNotifyContract.NotifyViewCallback)localObject1).iXq);
      if (paramBundle != null)
      {
        paramBundle = aj.d(paramBundle);
        if (paramBundle != null)
        {
          localObject2 = ((FinderNotifyContract.NotifyViewCallback)localObject1).jLl;
          if (localObject2 == null) {
            p.bGy("recyclerView");
          }
          paramBundle.k((RecyclerView)localObject2);
        }
      }
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      paramBundle.setAdapter((RecyclerView.a)((FinderNotifyContract.NotifyViewCallback)localObject1).xnR);
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).xnR;
      if (paramBundle != null) {
        paramBundle.YSn = ((h.c)new FinderNotifyContract.NotifyViewCallback.initView.4((FinderNotifyContract.NotifyViewCallback)localObject1));
      }
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).xnR;
      if (paramBundle != null) {
        paramBundle.YSm = ((h.d)new FinderNotifyContract.NotifyViewCallback.initView.5((FinderNotifyContract.NotifyViewCallback)localObject1));
      }
      paramBundle = h.ag(PluginFinder.class);
      p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      paramBundle = ((PluginFinder)paramBundle).getRedDotManager().aBe(BmC[this.index]);
      if (paramBundle == null) {
        break label741;
      }
    }
    label741:
    for (int i = paramBundle.count;; i = 0)
    {
      this.Bmz = i;
      paramBundle = g.Xox;
      paramBundle = getFragment();
      if (paramBundle == null) {
        p.iCn();
      }
      paramBundle = paramBundle.getActivity();
      if (paramBundle != null) {
        break label746;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(290471);
      throw paramBundle;
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).xvJ;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setEnableRefresh(false);
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      i = (int)((Context)localObject2).getResources().getDimension(b.d.finder_timeline_refresh_height);
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      paramBundle.setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(b.d.Edge_12A));
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      i = (int)((Context)localObject2).getResources().getDimension(b.d.Edge_7A);
      localObject2 = MMApplicationContext.getContext();
      p.j(localObject2, "MMApplicationContext.getContext()");
      paramBundle.setRefreshTargetY(i - (int)((Context)localObject2).getResources().getDimension(b.d.finder_timeline_refresh_height));
      paramBundle.setDamping(1.85F);
      ((FinderNotifyContract.NotifyViewCallback)localObject1).xDP = ((MMProcessBar)((FinderNotifyContract.NotifyViewCallback)localObject1).contentView.findViewById(b.f.rl_loading_icon));
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new FinderNotifyContract.NotifyViewCallback.initRefreshLayout..inlined.apply.lambda.1(paramBundle, (FinderNotifyContract.NotifyViewCallback)localObject1));
      paramBundle.setOverCallback((HeadFooterLayout.b)localObject1);
      break;
    }
    label746:
    localObject2 = ((af)g.b((AppCompatActivity)paramBundle).i(af.class)).Sc(this.index);
    if (((localObject2 instanceof com.tencent.mm.plugin.finder.viewmodel.notifytab.a)) && (this.Bmz > 0))
    {
      if (this.Bmz > 9999)
      {
        paramBundle = "+" + this.Bmz / 10000 + '万';
        Log.i("SimpleUIComponent", "setRedDot " + this.index + ':' + paramBundle);
        ((com.tencent.mm.plugin.finder.view.tabcomp.a)localObject2).aGC(paramBundle);
      }
    }
    else
    {
      if (this.Bmy != this.index) {
        break label1057;
      }
      paramBundle = this.zPr;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.zPd;
        if (paramBundle != null) {
          paramBundle.set(this.index, Boolean.TRUE);
        }
      }
      Log.i(((FinderNotifyContract.NotifyViewCallback)localObject1).TAG, "initRefresh:" + ((FinderNotifyContract.NotifyViewCallback)localObject1).zPu);
      d.a(d.aJa(), (b)new FinderNotifyContract.NotifyViewCallback.initAndRefreshAll.1((FinderNotifyContract.NotifyViewCallback)localObject1));
      d.a(200L, (kotlin.g.a.a)new FinderNotifyContract.NotifyViewCallback.initAndRefreshAll.2((FinderNotifyContract.NotifyViewCallback)localObject1));
      cBa();
      this.BmA = true;
    }
    for (;;)
    {
      if (this.Bmz > 0)
      {
        paramBundle = h.ag(PluginFinder.class);
        p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramBundle).getRedDotManager().aBd(BmC[this.index]);
      }
      this.BmB = ((FinderNotifyContract.NotifyViewCallback)localObject1);
      AppMethodBeat.o(290471);
      return;
      paramBundle = "+" + this.Bmz;
      break;
      label1057:
      cBa();
      if (!this.BmA)
      {
        Log.i("SimpleUIComponent", "refresh index: " + this.index);
        Log.i(((FinderNotifyContract.NotifyViewCallback)localObject1).TAG, "refresh: " + ((FinderNotifyContract.NotifyViewCallback)localObject1).zPu);
        d.a(250L, (kotlin.g.a.a)new FinderNotifyContract.NotifyViewCallback.refresh.1((FinderNotifyContract.NotifyViewCallback)localObject1));
        this.BmA = true;
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(290476);
    super.onPause();
    Object localObject = this.BmB;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyViewCallback)localObject).xnR;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onPause();
        AppMethodBeat.o(290476);
        return;
      }
    }
    AppMethodBeat.o(290476);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(290475);
    super.onResume();
    Object localObject = this.BmB;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyViewCallback)localObject).xnR;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onResume();
        AppMethodBeat.o(290475);
        return;
      }
    }
    AppMethodBeat.o(290475);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(290473);
    Log.i("SimpleUIComponent", "onUserVisibleFocused:" + this.BmA + "  " + this.index);
    Object localObject = this.zPr;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyPresenter)localObject).zPd;
      if (localObject != null)
      {
        ((List)localObject).set(this.index, Boolean.TRUE);
        AppMethodBeat.o(290473);
        return;
      }
    }
    AppMethodBeat.o(290473);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(290474);
    Log.i("SimpleUIComponent", "onUserVisibleUnFocused:" + this.BmA + "  " + this.index);
    AppMethodBeat.o(290474);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderNotifyUIC$Companion;", "", "()V", "pathTypes", "", "", "getPathTypes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getCtrlPath", "index", "", "plugin-finder_release"})
  public static final class a
  {
    public static String RS(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "";
      case 0: 
        return "NotificationCenterLike";
      case 1: 
        return "NotificationCenterComment";
      }
      return "NotificationCenterFollow";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ag
 * JD-Core Version:    0.7.0.1
 */