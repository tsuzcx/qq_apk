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
import com.tencent.mm.model.v;
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
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.e.a;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_WX_MSG", "", "TAG", "", "cacheId", "", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "initPos", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "username", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "getCommentScene", "getLayoutId", "getReportType", "goBack", "", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "plugin-finder_release"})
public final class FinderLikedFeedUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderLikedFeedUI";
  private HashMap _$_findViewCache;
  private int sCF;
  private final int sNX = 1;
  private RefreshLoadMoreLayout scj;
  private e sck;
  public FinderLikeDrawer scm;
  private long sme;
  private FinderLikedFeedContract.LikedTimelineViewCallback swg;
  private FinderLikedFeedContract.LikedTimelinePresenter swm;
  private String username;
  
  private final void goBack()
  {
    AppMethodBeat.i(167323);
    Object localObject = this.sck;
    if (localObject == null) {
      p.bdF("drawer");
    }
    if (((e)localObject).cPI())
    {
      localObject = this.sck;
      if (localObject == null) {
        p.bdF("drawer");
      }
      ((e)localObject).cPH();
      AppMethodBeat.o(167323);
      return;
    }
    localObject = this.scm;
    if (localObject == null) {
      p.bdF("friendLikeDrawer");
    }
    if (((FinderLikeDrawer)localObject).cPI())
    {
      localObject = this.scm;
      if (localObject == null) {
        p.bdF("friendLikeDrawer");
      }
      ((FinderLikeDrawer)localObject).cPH();
      AppMethodBeat.o(167323);
      return;
    }
    localObject = this.swg;
    if (localObject == null) {
      p.bdF("viewCallback");
    }
    localObject = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).cDn();
    if (((TouchMediaPreviewLayout)localObject).LqB)
    {
      ((TouchMediaPreviewLayout)localObject).fQg();
      AppMethodBeat.o(167323);
      return;
    }
    finish();
    AppMethodBeat.o(167323);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204618);
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
    AppMethodBeat.o(204618);
    return localView1;
  }
  
  public final int cCL()
  {
    return 2;
  }
  
  public final int cDL()
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
    p.g(localObject1, "findViewById(R.id.rl_layout)");
    this.scj = ((RefreshLoadMoreLayout)localObject1);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.sme = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    this.sCF = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
    localObject1 = e.tdM;
    localObject1 = (MMActivity)this;
    Object localObject2 = getWindow();
    p.g(localObject2, "window");
    localObject2 = ((Window)localObject2).getDecorView();
    p.g(localObject2, "window.decorView");
    this.sck = e.a.a((MMActivity)localObject1, (View)localObject2, 2, false);
    localObject1 = FinderLikeDrawer.tgd;
    localObject1 = getContext();
    p.g(localObject1, "context");
    localObject1 = (Context)localObject1;
    localObject2 = getContext();
    p.g(localObject2, "context");
    localObject2 = ((AppCompatActivity)localObject2).getWindow();
    p.g(localObject2, "context.window");
    Object localObject3 = FinderLikeDrawer.tgd;
    this.scm = FinderLikeDrawer.a.a((Context)localObject1, (Window)localObject2, FinderLikeDrawer.cQd());
    localObject1 = this.scj;
    if (localObject1 == null) {
      p.bdF("rlLayout");
    }
    localObject2 = z.jV((Context)getContext()).inflate(2131494590, null);
    p.g(localObject2, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    ((RefreshLoadMoreLayout)localObject1).setLoadMoreFooter((View)localObject2);
    localObject1 = (MMActivity)this;
    localObject2 = this.sck;
    if (localObject2 == null) {
      p.bdF("drawer");
    }
    this.swm = new FinderLikedFeedContract.LikedTimelinePresenter((MMActivity)localObject1, (e)localObject2);
    localObject1 = (MMActivity)this;
    localObject2 = this.swm;
    if (localObject2 == null) {
      p.bdF("presenter");
    }
    this.swg = new FinderLikedFeedContract.LikedTimelineViewCallback((MMActivity)localObject1, (FinderLikedFeedContract.LikedTimelinePresenter)localObject2);
    localObject1 = this.swg;
    if (localObject1 == null) {
      p.bdF("viewCallback");
    }
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fNT.findViewById(2131299478);
    p.g(localObject2, "context.findViewById(R.id.empty_view)");
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).GG = ((View)localObject2);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).GG;
    if (localObject2 == null) {
      p.bdF("mEmptyView");
    }
    ((View)localObject2).setVisibility(8);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fNT.findViewById(2131304203);
    p.g(localObject2, "context.findViewById(R.id.rl_layout)");
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).scj = ((RefreshLoadMoreLayout)localObject2);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).scj;
    if (localObject2 == null) {
      p.bdF("rlLayout");
    }
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).gpr = ((RefreshLoadMoreLayout)localObject2).getRecyclerView();
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).gpr;
    if (localObject2 == null) {
      p.bdF("recyclerView");
    }
    ((RecyclerView)localObject2).setLayoutManager((RecyclerView.i)new FinderLayoutManager((byte)0));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).gpr;
    if (localObject2 == null) {
      p.bdF("recyclerView");
    }
    ((RecyclerView)localObject2).setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new FinderLikedFeedContract.LikedTimelinePresenter.buildItemCoverts.1(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).swm), (ArrayList)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).getModel().getDataList()));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fNT.findViewById(2131298781);
    localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).scj;
    if (localObject3 == null) {
      p.bdF("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject3).setActionCallback((RefreshLoadMoreLayout.a)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.1((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1, (View)localObject2));
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).gpr;
    if (localObject2 == null) {
      p.bdF("recyclerView");
    }
    ((RecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.plugin.finder.view.decoration.b((Drawable)new ColorDrawable(c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getColor(2131099648)), (int)c.a.a((com.tencent.mm.plugin.finder.presenter.base.c)localObject1).getDimension(2131166294)));
    com.tencent.mm.ac.c.a(com.tencent.mm.ac.c.ale(), (d.g.a.b)new FinderLikedFeedContract.LikedTimelineViewCallback.initView.2((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1));
    localObject2 = a.KEX;
    localObject2 = FinderReporterUIC.d((FinderReporterUIC)a.s(((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fNT).get(FinderReporterUIC.class));
    if (localObject2 != null)
    {
      localObject3 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).gpr;
      if (localObject3 == null) {
        p.bdF("recyclerView");
      }
      ((f)localObject2).s((RecyclerView)localObject3);
    }
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).scn = new TouchMediaPreviewLayout((Context)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fNT);
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).scn;
    if (localObject2 == null) {
      p.bdF("touchPhotoLayout");
    }
    localObject1 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject1).fNT.getWindow();
    p.g(localObject1, "context.window");
    localObject1 = ((Window)localObject1).getDecorView();
    p.g(localObject1, "context.window.decorView");
    ((TouchMediaPreviewLayout)localObject2).hc((View)localObject1);
    localObject2 = this.swg;
    if (localObject2 == null) {
      p.bdF("viewCallback");
    }
    localObject1 = (BaseFinderFeedLoader)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2).swm.snY;
    localObject2 = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2).scj;
    if (localObject2 == null) {
      p.bdF("rlLayout");
    }
    ((BaseFinderFeedLoader)localObject1).register((d)localObject2);
    localObject1 = this.swm;
    if (localObject1 == null) {
      p.bdF("presenter");
    }
    localObject2 = this.swg;
    if (localObject2 == null) {
      p.bdF("viewCallback");
    }
    ((FinderLikedFeedContract.LikedTimelinePresenter)localObject1).a((FinderLikedFeedContract.LikedTimelineViewCallback)localObject2);
    AppMethodBeat.o(167321);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(204617);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    e locale = this.sck;
    if (locale == null) {
      p.bdF("drawer");
    }
    locale.d(paramInt1, paramIntent);
    AppMethodBeat.o(204617);
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
    this.username = v.aAC();
    ae.i(this.TAG, "username %s", new Object[] { this.username });
    initView();
    AppMethodBeat.o(167320);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167322);
    Object localObject = this.sck;
    if (localObject == null) {
      p.bdF("drawer");
    }
    ((e)localObject).onDetach();
    super.onDestroy();
    localObject = this.swg;
    if (localObject == null) {
      p.bdF("viewCallback");
    }
    BaseFinderFeedLoader localBaseFinderFeedLoader = (BaseFinderFeedLoader)((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).swm.snY;
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).scj;
    if (localRefreshLoadMoreLayout == null) {
      p.bdF("rlLayout");
    }
    localBaseFinderFeedLoader.unregister((d)localRefreshLoadMoreLayout);
    ((FinderLikedFeedContract.LikedTimelineViewCallback)localObject).swm.onDetach();
    AppMethodBeat.o(167322);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(178433);
    super.onPause();
    if (this.sck == null) {
      p.bdF("drawer");
    }
    AppMethodBeat.o(178433);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(178432);
    super.onResume();
    e locale = this.sck;
    if (locale == null) {
      p.bdF("drawer");
    }
    locale.onUIResume();
    AppMethodBeat.o(178432);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(224306);
    super.onSaveInstanceState(paramBundle);
    paramBundle = this.swm;
    if (paramBundle == null) {
      p.bdF("presenter");
    }
    paramBundle = (BaseFinderFeedLoader)paramBundle.snY;
    Intent localIntent = getIntent();
    p.g(localIntent, "intent");
    FinderLikedFeedContract.LikedTimelinePresenter localLikedTimelinePresenter = this.swm;
    if (localLikedTimelinePresenter == null) {
      p.bdF("presenter");
    }
    BaseFinderFeedLoader.saveCache$default(paramBundle, localIntent, ((BaseFinderFeedLoader)localLikedTimelinePresenter.snY).getInitPos(), null, 4, null);
    AppMethodBeat.o(224306);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderLikedFeedUI paramFinderLikedFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167316);
      FinderLikedFeedUI.a(this.sNY);
      AppMethodBeat.o(167316);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderLikedFeedUI
 * JD-Core Version:    0.7.0.1
 */