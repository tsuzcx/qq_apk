package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.k;
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
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.refresh.1;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStateCacheVM;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g.c;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderNotifyUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "isRefreshed", "", "lastTabIndex", "getLastTabIndex", "setLastTabIndex", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "redDotCount", "getRedDotCount", "setRedDotCount", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback;", "getActiveIndex", "getLayoutId", "getPresenter", "onCreateAfter", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleFocused", "onUserVisibleUnFocused", "refreshSelf", "reportExpose", "setRedDot", "unsetRedDotCount", "Companion", "plugin-finder_release"})
public final class FinderNotifyUIC
  extends UIComponent
  implements i, FinderNotifyContract.NotifyViewCallback.UICallbackListener
{
  private static final String[] wyP;
  public static final a wyQ;
  public int index;
  private FinderNotifyContract.NotifyPresenter uZa;
  private int wyL;
  private int wyM;
  private boolean wyN;
  private FinderNotifyContract.NotifyViewCallback wyO;
  
  static
  {
    AppMethodBeat.i(255854);
    wyQ = new a((byte)0);
    wyP = new String[] { "NotificationCenterLike", "NotificationCenterComment", "NotificationCenterFollow" };
    AppMethodBeat.o(255854);
  }
  
  public FinderNotifyUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255853);
    this.index = -1;
    AppMethodBeat.o(255853);
  }
  
  private final void cnl()
  {
    AppMethodBeat.i(255846);
    Object localObject1 = a.My(this.index);
    Object localObject2 = g.ah(PluginFinder.class);
    p.g(localObject2, "MMKernel.plugin(PluginFinder::class.java)");
    localObject2 = ((PluginFinder)localObject2).getRedDotManager().asX((String)localObject1);
    Object localObject3 = g.ah(PluginFinder.class);
    p.g(localObject3, "MMKernel.plugin(PluginFinder::class.java)");
    localObject3 = ((PluginFinder)localObject3).getRedDotManager().asW((String)localObject1);
    localObject1 = y.vXH;
    Fragment localFragment = getFragment();
    if ((localObject2 != null) && (localObject3 != null) && (localFragment != null))
    {
      localObject1 = j.vft;
      localObject1 = FinderReporterUIC.wzC;
      localObject1 = localFragment.getActivity();
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255846);
        throw ((Throwable)localObject1);
      }
      localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
      if (localObject1 != null) {}
      for (localObject1 = ((FinderReporterUIC)localObject1).dIx();; localObject1 = null)
      {
        j.a("5", (k)localObject2, (bdo)localObject3, 1, (bbn)localObject1, 0, 0, 96);
        if (this.wyL != this.index) {
          break label236;
        }
        localObject1 = j.vft;
        localObject1 = FinderReporterUIC.wzC;
        localObject1 = localFragment.getActivity();
        if (localObject1 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255846);
        throw ((Throwable)localObject1);
      }
      localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
      if (localObject1 == null) {
        break label242;
      }
    }
    label236:
    label242:
    for (localObject1 = ((FinderReporterUIC)localObject1).dIx();; localObject1 = null)
    {
      j.a("5", (k)localObject2, (bdo)localObject3, 3, (bbn)localObject1, 1, 0, 64);
      AppMethodBeat.o(255846);
      return;
    }
  }
  
  private final FinderNotifyContract.NotifyPresenter dIq()
  {
    AppMethodBeat.i(255851);
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
      AppMethodBeat.o(255851);
      throw ((Throwable)localObject);
      localObject = null;
      break;
    }
    label71:
    localObject = ((FinderFinderMsgUI)localObject).uZa;
    AppMethodBeat.o(255851);
    return localObject;
    label86:
    AppMethodBeat.o(255851);
    return null;
  }
  
  public final void a(ao paramao)
  {
    AppMethodBeat.i(255852);
    p.h(paramao, "mention");
    AppMethodBeat.o(255852);
  }
  
  public final int getLayoutId()
  {
    return 2131494540;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(255845);
    super.onCreateAfter(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    this.wyL = ((FinderTabStateCacheVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStateCacheVM.class)).dHU();
    this.uZa = dIq();
    paramBundle = getFragment();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getActivity(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255845);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    Object localObject1 = getRootView();
    Object localObject2 = dIq();
    if (localObject2 == null) {
      p.hyc();
    }
    localObject1 = new FinderNotifyContract.NotifyViewCallback(paramBundle, (View)localObject1, (FinderNotifyContract.NotifyPresenter)localObject2, (FinderNotifyContract.NotifyViewCallback.UICallbackListener)this, this.index);
    paramBundle = this.uZa;
    if (paramBundle != null) {
      paramBundle.a((FinderNotifyContract.NotifyViewCallback)localObject1);
    }
    ((FinderNotifyContract.NotifyViewCallback)localObject1).tLS = ((RefreshLoadMoreLayout)((FinderNotifyContract.NotifyViewCallback)localObject1).contentView.findViewById(2131307118));
    if (!((FinderNotifyContract.NotifyViewCallback)localObject1).uYZ)
    {
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).tLS;
      if (paramBundle != null) {
        paramBundle.setEnableRefresh(false);
      }
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).contentView.findViewById(2131305556);
      p.g(paramBundle, "contentView.findViewById….id.notify_recycler_view)");
      ((FinderNotifyContract.NotifyViewCallback)localObject1).hak = ((RecyclerView)paramBundle);
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      ((FinderNotifyContract.NotifyViewCallback)localObject1).uYA = ((TextView)((FinderNotifyContract.NotifyViewCallback)localObject1).contentView.findViewById(2131305557));
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).uYA;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new FinderNotifyContract.NotifyViewCallback.initView.1((FinderNotifyContract.NotifyViewCallback)localObject1));
      }
      ((FinderNotifyContract.NotifyViewCallback)localObject1).tFp = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new FinderNotifyContract.NotifyViewCallback.initView.2((FinderNotifyContract.NotifyViewCallback)localObject1), ((FinderNotifyContract.NotifyViewCallback)localObject1).uZa.JV(((FinderNotifyContract.NotifyViewCallback)localObject1).uZc), true);
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).tFp;
      if (paramBundle != null) {
        paramBundle.RrA = ((com.tencent.mm.view.recyclerview.l)new FinderNotifyContract.NotifyViewCallback.initView.3((FinderNotifyContract.NotifyViewCallback)localObject1));
      }
      paramBundle = FinderReporterUIC.wzC;
      paramBundle = FinderReporterUIC.a.fH((Context)((FinderNotifyContract.NotifyViewCallback)localObject1).gte);
      if (paramBundle != null)
      {
        paramBundle = FinderReporterUIC.d(paramBundle);
        if (paramBundle != null)
        {
          localObject2 = ((FinderNotifyContract.NotifyViewCallback)localObject1).hak;
          if (localObject2 == null) {
            p.btv("recyclerView");
          }
          paramBundle.m((RecyclerView)localObject2);
        }
      }
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.setAdapter((RecyclerView.a)((FinderNotifyContract.NotifyViewCallback)localObject1).tFp);
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).tFp;
      if (paramBundle != null) {
        paramBundle.RqP = ((g.c)new FinderNotifyContract.NotifyViewCallback.initView.4((FinderNotifyContract.NotifyViewCallback)localObject1));
      }
      paramBundle = g.ah(PluginFinder.class);
      p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      paramBundle = ((PluginFinder)paramBundle).getRedDotManager().asW(wyP[this.index]);
      if (paramBundle == null) {
        break label699;
      }
    }
    label699:
    for (int i = paramBundle.count;; i = 0)
    {
      this.wyM = i;
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      paramBundle = getFragment();
      if (paramBundle == null) {
        p.hyc();
      }
      paramBundle = paramBundle.getActivity();
      if (paramBundle != null) {
        break label704;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255845);
      throw paramBundle;
      paramBundle = ((FinderNotifyContract.NotifyViewCallback)localObject1).tLS;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setEnableRefresh(false);
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      i = (int)((Context)localObject2).getResources().getDimension(2131166379);
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      paramBundle.setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(2131165281));
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      i = (int)((Context)localObject2).getResources().getDimension(2131165310);
      localObject2 = MMApplicationContext.getContext();
      p.g(localObject2, "MMApplicationContext.getContext()");
      paramBundle.setRefreshTargetY(i - (int)((Context)localObject2).getResources().getDimension(2131166379));
      paramBundle.setDamping(1.85F);
      ((FinderNotifyContract.NotifyViewCallback)localObject1).tSY = ((MMProcessBar)((FinderNotifyContract.NotifyViewCallback)localObject1).contentView.findViewById(2131307120));
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new FinderNotifyContract.NotifyViewCallback.initRefreshLayout..inlined.apply.lambda.1(paramBundle, (FinderNotifyContract.NotifyViewCallback)localObject1));
      paramBundle.setOverCallback((HeadFooterLayout.b)localObject1);
      break;
    }
    label704:
    localObject2 = ((FinderMsgNotifyTabUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramBundle).get(FinderMsgNotifyTabUIC.class)).MI(this.index);
    if (((localObject2 instanceof com.tencent.mm.plugin.finder.viewmodel.notifytab.a)) && (this.wyM > 0))
    {
      if (this.wyM > 9999)
      {
        paramBundle = "+" + this.wyM / 10000 + '万';
        Log.i("SimpleUIComponent", "setRedDot " + this.index + ':' + paramBundle);
        ((com.tencent.mm.plugin.finder.view.tabcomp.a)localObject2).by(paramBundle, true);
      }
    }
    else
    {
      if (this.wyL != this.index) {
        break label1016;
      }
      paramBundle = this.uZa;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.uYL;
        if (paramBundle != null) {
          paramBundle.set(this.index, Boolean.TRUE);
        }
      }
      Log.i(((FinderNotifyContract.NotifyViewCallback)localObject1).TAG, "initRefresh:" + ((FinderNotifyContract.NotifyViewCallback)localObject1).uZc);
      d.a(d.aBx(), (b)new FinderNotifyContract.NotifyViewCallback.initAndRefreshAll.1((FinderNotifyContract.NotifyViewCallback)localObject1));
      d.a(200L, (kotlin.g.a.a)new FinderNotifyContract.NotifyViewCallback.initAndRefreshAll.2((FinderNotifyContract.NotifyViewCallback)localObject1));
      cnl();
      this.wyN = true;
    }
    for (;;)
    {
      if (this.wyM > 0)
      {
        paramBundle = g.ah(PluginFinder.class);
        p.g(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)paramBundle).getRedDotManager().asV(wyP[this.index]);
      }
      this.wyO = ((FinderNotifyContract.NotifyViewCallback)localObject1);
      AppMethodBeat.o(255845);
      return;
      paramBundle = "+" + this.wyM;
      break;
      label1016:
      cnl();
      if (!this.wyN)
      {
        Log.i("SimpleUIComponent", "refresh index: " + this.index);
        Log.i(((FinderNotifyContract.NotifyViewCallback)localObject1).TAG, "refresh: " + ((FinderNotifyContract.NotifyViewCallback)localObject1).uZc);
        d.a(250L, (kotlin.g.a.a)new FinderNotifyContract.NotifyViewCallback.refresh.1((FinderNotifyContract.NotifyViewCallback)localObject1));
        this.wyN = true;
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(255850);
    super.onPause();
    Object localObject = this.wyO;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyViewCallback)localObject).tFp;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onPause();
        AppMethodBeat.o(255850);
        return;
      }
    }
    AppMethodBeat.o(255850);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(255849);
    super.onResume();
    Object localObject = this.wyO;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyViewCallback)localObject).tFp;
      if (localObject != null)
      {
        ((WxRecyclerAdapter)localObject).onResume();
        AppMethodBeat.o(255849);
        return;
      }
    }
    AppMethodBeat.o(255849);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(255847);
    Log.i("SimpleUIComponent", "onUserVisibleFocused:" + this.wyN + "  " + this.index);
    Object localObject = this.uZa;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyPresenter)localObject).uYL;
      if (localObject != null)
      {
        ((List)localObject).set(this.index, Boolean.TRUE);
        AppMethodBeat.o(255847);
        return;
      }
    }
    AppMethodBeat.o(255847);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(255848);
    Log.i("SimpleUIComponent", "onUserVisibleUnFocused:" + this.wyN + "  " + this.index);
    AppMethodBeat.o(255848);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderNotifyUIC$Companion;", "", "()V", "pathTypes", "", "", "getPathTypes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getCtrlPath", "index", "", "plugin-finder_release"})
  public static final class a
  {
    public static String My(int paramInt)
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
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderNotifyUIC
 * JD-Core Version:    0.7.0.1
 */