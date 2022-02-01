package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.presenter.base.b.a;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelinePresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback.initView.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback.initView.2;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.plugin.finder.view.f.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_WX_MSG", "", "TAG", "", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "getCommentScene", "getLayoutId", "getReportType", "goBack", "", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderLikedFeedUI
  extends MMFinderUI
{
  private f KMN;
  public FinderLikeDrawer KMP;
  private final String TAG = "Finder.FinderLikedFeedUI";
  private HashMap _$_findViewCache;
  private FinderLikedFeedContract.LikedTimelineViewCallback qEN;
  private FinderLikedFeedContract.LikedTimelinePresenter qET;
  private final int qMH = 1;
  private RefreshLoadMoreLayout quj;
  private String username;
  
  private final void goBack()
  {
    AppMethodBeat.i(167323);
    Object localObject = this.KMN;
    if (localObject == null) {
      k.aPZ("drawer");
    }
    if (((f)localObject).fiQ())
    {
      localObject = this.KMN;
      if (localObject == null) {
        k.aPZ("drawer");
      }
      ((f)localObject).csJ();
      AppMethodBeat.o(167323);
      return;
    }
    localObject = this.KMP;
    if (localObject == null) {
      k.aPZ("friendLikeDrawer");
    }
    if (((FinderLikeDrawer)localObject).fiQ())
    {
      localObject = this.KMP;
      if (localObject == null) {
        k.aPZ("friendLikeDrawer");
      }
      ((FinderLikeDrawer)localObject).csJ();
      AppMethodBeat.o(167323);
      return;
    }
    localObject = this.qEN;
    if (localObject == null) {
      k.aPZ("viewCallback");
    }
    localObject = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).cmo();
    if (((TouchMediaPreviewLayout)localObject).HCz)
    {
      ((TouchMediaPreviewLayout)localObject).ffe();
      AppMethodBeat.o(167323);
      return;
    }
    finish();
    AppMethodBeat.o(167323);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199251);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(199251);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131494059;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167321);
    setMMTitle(2131759274);
    Object localObject1 = findViewById(2131304203);
    k.g(localObject1, "findViewById(R.id.rl_layout)");
    this.quj = ((RefreshLoadMoreLayout)localObject1);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    localObject1 = f.LeE;
    localObject1 = (MMActivity)this;
    Object localObject2 = getWindow();
    k.g(localObject2, "window");
    localObject2 = ((Window)localObject2).getDecorView();
    k.g(localObject2, "window.decorView");
    this.KMN = f.a.a((MMActivity)localObject1, (View)localObject2, 2, false);
    localObject1 = FinderLikeDrawer.Lfb;
    localObject1 = getContext();
    k.g(localObject1, "context");
    localObject1 = (Context)localObject1;
    localObject2 = getContext();
    k.g(localObject2, "context");
    localObject2 = ((AppCompatActivity)localObject2).getWindow();
    k.g(localObject2, "context.window");
    Object localObject3 = FinderLikeDrawer.Lfb;
    this.KMP = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.fWQ());
    localObject1 = this.quj;
    if (localObject1 == null) {
      k.aPZ("rlLayout");
    }
    localObject2 = y.js((Context)getContext()).inflate(2131494590, null);
    k.g(localObject2, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
    localObject1 = (MMActivity)this;
    localObject2 = this.KMN;
    if (localObject2 == null) {
      k.aPZ("drawer");
    }
    this.qET = new FinderLikedFeedContract.LikedTimelinePresenter((MMActivity)localObject1, (f)localObject2);
    localObject1 = (MMActivity)this;
    localObject2 = this.qET;
    if (localObject2 == null) {
      k.aPZ("presenter");
    }
    this.qEN = new FinderLikedFeedContract.LikedTimelineViewCallback((MMActivity)localObject1, (FinderLikedFeedContract.LikedTimelinePresenter)localObject2);
    localObject1 = this.qEN;
    if (localObject1 == null) {
      k.aPZ("viewCallback");
    }
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).imP.findViewById(2131299478);
    k.g(localObject2, "context.findViewById(R.id.empty_view)");
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).DR = ((View)localObject2);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).DR;
    if (localObject2 == null) {
      k.aPZ("mEmptyView");
    }
    ((View)localObject2).setVisibility(8);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).imP.findViewById(2131304203);
    k.g(localObject2, "context.findViewById(R.id.rl_layout)");
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).quj = ((RefreshLoadMoreLayout)localObject2);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).quj;
    if (localObject2 == null) {
      k.aPZ("rlLayout");
    }
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fPw = ((RefreshLoadMoreLayout)localObject2).getRecyclerView();
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fPw;
    if (localObject2 == null) {
      k.aPZ("recyclerView");
    }
    ((RecyclerView)localObject2).setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fPw;
    if (localObject2 == null) {
      k.aPZ("recyclerView");
    }
    ((RecyclerView)localObject2).setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).qET), (ArrayList)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).qET.qvo.getDataList()));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).imP.findViewById(2131298781);
    localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).quj;
    if (localObject3 == null) {
      k.aPZ("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject3).setActionCallback((RefreshLoadMoreLayout.a)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.1((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1, (View)localObject2));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fPw;
    if (localObject2 == null) {
      k.aPZ("recyclerView");
    }
    ((RecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(b.a.a((com.tencent.mm.plugin.finder.presenter.base.b)localObject1).getColor(2131099648)), (int)b.a.a((com.tencent.mm.plugin.finder.presenter.base.b)localObject1).getDimension(2131166294)));
    com.tencent.mm.ad.c.a(com.tencent.mm.ad.c.agM(), (d.g.a.b)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.2((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1));
    localObject2 = a.LCX;
    localObject2 = FinderReporterUIC.d((FinderReporterUIC)a.s(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).imP).get(FinderReporterUIC.class));
    if (localObject2 != null)
    {
      localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fPw;
      if (localObject3 == null) {
        k.aPZ("recyclerView");
      }
      ((RecyclerView)localObject3).a(((e)localObject2).fSD());
    }
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).qum = new TouchMediaPreviewLayout((Context)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).imP);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).qum;
    if (localObject2 == null) {
      k.aPZ("touchPhotoLayout");
    }
    localObject1 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).imP.getWindow();
    k.g(localObject1, "context.window");
    localObject1 = ((Window)localObject1).getDecorView();
    k.g(localObject1, "context.window.decorView");
    ((TouchMediaPreviewLayout)localObject2).gr((View)localObject1);
    localObject1 = this.qEN;
    if (localObject1 == null) {
      k.aPZ("viewCallback");
    }
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).qET.qvo;
    localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).quj;
    if (localObject3 == null) {
      k.aPZ("rlLayout");
    }
    ((BaseFinderFeedLoader)localObject2).register((d)localObject3, ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).imP);
    localObject1 = this.qET;
    if (localObject1 == null) {
      k.aPZ("presenter");
    }
    localObject2 = this.qEN;
    if (localObject2 == null) {
      k.aPZ("viewCallback");
    }
    ((FinderLikedFeedContract.LikedTimelinePresenter)localObject1).a((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2);
    AppMethodBeat.o(167321);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(199250);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    f localf = this.KMN;
    if (localf == null) {
      k.aPZ("drawer");
    }
    localf.r(paramInt1, paramIntent);
    AppMethodBeat.o(199250);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167324);
    goBack();
    AppMethodBeat.o(167324);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167320);
    super.onCreate(paramBundle);
    this.username = u.aqG();
    ad.i(this.TAG, "username %s", new Object[] { this.username });
    initView();
    AppMethodBeat.o(167320);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167322);
    super.onDestroy();
    FinderLikedFeedContract.LikedTimelineViewCallback localLikedTimelineViewCallback = this.qEN;
    if (localLikedTimelineViewCallback == null) {
      k.aPZ("viewCallback");
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = localLikedTimelineViewCallback.qET.qvo;
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = localLikedTimelineViewCallback.quj;
    if (localRefreshLoadMoreLayout == null) {
      k.aPZ("rlLayout");
    }
    localBaseFinderFeedLoader.unregister((d)localRefreshLoadMoreLayout, localLikedTimelineViewCallback.imP);
    localLikedTimelineViewCallback.qET.onDetach();
    AppMethodBeat.o(167322);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(178433);
    super.onPause();
    if (this.KMN == null) {
      k.aPZ("drawer");
    }
    AppMethodBeat.o(178433);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(178432);
    super.onResume();
    f localf = this.KMN;
    if (localf == null) {
      k.aPZ("drawer");
    }
    localf.onUIResume();
    AppMethodBeat.o(178432);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderLikedFeedUI paramFinderLikedFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167316);
      FinderLikedFeedUI.a(this.qMI);
      AppMethodBeat.o(167316);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI
 * JD-Core Version:    0.7.0.1
 */