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
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.presenter.base.c.a;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelinePresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback.initView.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback.initView.2;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer.a;
import com.tencent.mm.plugin.finder.view.d.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_WX_MSG", "", "TAG", "", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "getCommentScene", "getLayoutId", "getReportType", "goBack", "", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderLikedFeedUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderLikedFeedUI";
  private HashMap _$_findViewCache;
  private final int rIa = 1;
  private RefreshLoadMoreLayout rfT;
  private com.tencent.mm.plugin.finder.view.d rfU;
  public FinderLikeDrawer rfW;
  private FinderLikedFeedContract.LikedTimelinePresenter rwC;
  private FinderLikedFeedContract.LikedTimelineViewCallback rww;
  private String username;
  
  private final void goBack()
  {
    AppMethodBeat.i(167323);
    Object localObject = this.rfU;
    if (localObject == null) {
      k.aVY("drawer");
    }
    if (((com.tencent.mm.plugin.finder.view.d)localObject).cEG())
    {
      localObject = this.rfU;
      if (localObject == null) {
        k.aVY("drawer");
      }
      ((com.tencent.mm.plugin.finder.view.d)localObject).cEF();
      AppMethodBeat.o(167323);
      return;
    }
    localObject = this.rfW;
    if (localObject == null) {
      k.aVY("friendLikeDrawer");
    }
    if (((FinderLikeDrawer)localObject).cEG())
    {
      localObject = this.rfW;
      if (localObject == null) {
        k.aVY("friendLikeDrawer");
      }
      ((FinderLikeDrawer)localObject).cEF();
      AppMethodBeat.o(167323);
      return;
    }
    localObject = this.rww;
    if (localObject == null) {
      k.aVY("viewCallback");
    }
    localObject = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).cvk();
    if (((TouchMediaPreviewLayout)localObject).JcV)
    {
      ((TouchMediaPreviewLayout)localObject).fuZ();
      AppMethodBeat.o(167323);
      return;
    }
    finish();
    AppMethodBeat.o(167323);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203222);
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
    AppMethodBeat.o(203222);
    return localView1;
  }
  
  public final int cuI()
  {
    return 2;
  }
  
  public final int cvJ()
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
    this.rfT = ((RefreshLoadMoreLayout)localObject1);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    localObject1 = com.tencent.mm.plugin.finder.view.d.rVR;
    localObject1 = (MMActivity)this;
    Object localObject2 = getWindow();
    k.g(localObject2, "window");
    localObject2 = ((Window)localObject2).getDecorView();
    k.g(localObject2, "window.decorView");
    this.rfU = d.a.a((MMActivity)localObject1, (View)localObject2, 2, false);
    localObject1 = FinderLikeDrawer.rXU;
    localObject1 = getContext();
    k.g(localObject1, "context");
    localObject1 = (Context)localObject1;
    localObject2 = getContext();
    k.g(localObject2, "context");
    localObject2 = ((AppCompatActivity)localObject2).getWindow();
    k.g(localObject2, "context.window");
    Object localObject3 = FinderLikeDrawer.rXU;
    this.rfW = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cEZ());
    localObject1 = this.rfT;
    if (localObject1 == null) {
      k.aVY("rlLayout");
    }
    localObject2 = z.jD((Context)getContext()).inflate(2131494590, null);
    k.g(localObject2, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
    localObject1 = (MMActivity)this;
    localObject2 = this.rfU;
    if (localObject2 == null) {
      k.aVY("drawer");
    }
    this.rwC = new FinderLikedFeedContract.LikedTimelinePresenter((MMActivity)localObject1, (com.tencent.mm.plugin.finder.view.d)localObject2);
    localObject1 = (MMActivity)this;
    localObject2 = this.rwC;
    if (localObject2 == null) {
      k.aVY("presenter");
    }
    this.rww = new FinderLikedFeedContract.LikedTimelineViewCallback((MMActivity)localObject1, (FinderLikedFeedContract.LikedTimelinePresenter)localObject2);
    localObject1 = this.rww;
    if (localObject1 == null) {
      k.aVY("viewCallback");
    }
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iMV.findViewById(2131299478);
    k.g(localObject2, "context.findViewById(R.id.empty_view)");
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).EP = ((View)localObject2);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).EP;
    if (localObject2 == null) {
      k.aVY("mEmptyView");
    }
    ((View)localObject2).setVisibility(8);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iMV.findViewById(2131304203);
    k.g(localObject2, "context.findViewById(R.id.rl_layout)");
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).rfT = ((RefreshLoadMoreLayout)localObject2);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).rfT;
    if (localObject2 == null) {
      k.aVY("rlLayout");
    }
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fTr = ((RefreshLoadMoreLayout)localObject2).getRecyclerView();
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fTr;
    if (localObject2 == null) {
      k.aVY("recyclerView");
    }
    ((RecyclerView)localObject2).setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fTr;
    if (localObject2 == null) {
      k.aVY("recyclerView");
    }
    ((RecyclerView)localObject2).setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).rwC), (ArrayList)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).rwC.rgh.getDataList()));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iMV.findViewById(2131298781);
    localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).rfT;
    if (localObject3 == null) {
      k.aVY("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject3).setActionCallback((RefreshLoadMoreLayout.a)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.1((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1, (View)localObject2));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fTr;
    if (localObject2 == null) {
      k.aVY("recyclerView");
    }
    ((RecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getColor(2131099648)), (int)c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getDimension(2131166294)));
    com.tencent.mm.ac.c.a(com.tencent.mm.ac.c.aid(), (d.g.a.b)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.2((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1));
    localObject2 = a.IrY;
    localObject2 = FinderReporterUIC.d((FinderReporterUIC)a.q(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iMV).get(FinderReporterUIC.class));
    if (localObject2 != null)
    {
      localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fTr;
      if (localObject3 == null) {
        k.aVY("recyclerView");
      }
      ((RecyclerView)localObject3).a(((f)localObject2).ctt());
    }
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).rfY = new TouchMediaPreviewLayout((Context)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iMV);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).rfY;
    if (localObject2 == null) {
      k.aVY("touchPhotoLayout");
    }
    localObject1 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iMV.getWindow();
    k.g(localObject1, "context.window");
    localObject1 = ((Window)localObject1).getDecorView();
    k.g(localObject1, "context.window.decorView");
    ((TouchMediaPreviewLayout)localObject2).gG((View)localObject1);
    localObject1 = this.rww;
    if (localObject1 == null) {
      k.aVY("viewCallback");
    }
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).rwC.rgh;
    localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).rfT;
    if (localObject3 == null) {
      k.aVY("rlLayout");
    }
    ((BaseFinderFeedLoader)localObject2).register((com.tencent.mm.view.d)localObject3, ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).iMV);
    localObject1 = this.rwC;
    if (localObject1 == null) {
      k.aVY("presenter");
    }
    localObject2 = this.rww;
    if (localObject2 == null) {
      k.aVY("viewCallback");
    }
    ((FinderLikedFeedContract.LikedTimelinePresenter)localObject1).a((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2);
    AppMethodBeat.o(167321);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(203221);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.view.d locald = this.rfU;
    if (locald == null) {
      k.aVY("drawer");
    }
    locald.d(paramInt1, paramIntent);
    AppMethodBeat.o(203221);
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
    this.username = u.axw();
    ac.i(this.TAG, "username %s", new Object[] { this.username });
    initView();
    AppMethodBeat.o(167320);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167322);
    Object localObject = this.rfU;
    if (localObject == null) {
      k.aVY("drawer");
    }
    ((com.tencent.mm.plugin.finder.view.d)localObject).onDetach();
    super.onDestroy();
    localObject = this.rww;
    if (localObject == null) {
      k.aVY("viewCallback");
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).rwC.rgh;
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).rfT;
    if (localRefreshLoadMoreLayout == null) {
      k.aVY("rlLayout");
    }
    localBaseFinderFeedLoader.unregister((com.tencent.mm.view.d)localRefreshLoadMoreLayout, ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).iMV);
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).rwC.onDetach();
    AppMethodBeat.o(167322);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(178433);
    super.onPause();
    if (this.rfU == null) {
      k.aVY("drawer");
    }
    AppMethodBeat.o(178433);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(178432);
    super.onResume();
    com.tencent.mm.plugin.finder.view.d locald = this.rfU;
    if (locald == null) {
      k.aVY("drawer");
    }
    locald.onUIResume();
    AppMethodBeat.o(178432);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderLikedFeedUI paramFinderLikedFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167316);
      FinderLikedFeedUI.a(this.rIb);
      AppMethodBeat.o(167316);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI
 * JD-Core Version:    0.7.0.1
 */