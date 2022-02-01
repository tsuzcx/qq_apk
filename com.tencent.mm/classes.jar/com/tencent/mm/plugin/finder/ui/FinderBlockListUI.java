package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.i;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListPresenter.initData.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback.initView.1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback.initView.2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback.initView.3;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback.initView.4;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback.initView.5;
import com.tencent.mm.plugin.finder.storage.ad;
import com.tencent.mm.plugin.finder.storage.ae;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.g.b;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;", "type", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback;", "getLayoutId", "initView", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "Companion", "plugin-finder_release"})
public final class FinderBlockListUI
  extends MMFinderUI
{
  private static final int vHA = 20;
  private static final int vHB = 1;
  public static final a vHC;
  private static final int vHz = 1;
  private final String TAG = "Finder.FinderBlockListUI";
  private HashMap _$_findViewCache;
  private int type;
  private FinderBlockListContract.BlockListViewCallback uWo;
  private ak uWp;
  private FinderBlockListContract.BlockListPresenter uWr;
  
  static
  {
    AppMethodBeat.i(252161);
    vHC = new a((byte)0);
    vHz = 1;
    vHA = 20;
    vHB = 1;
    AppMethodBeat.o(252161);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252163);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252163);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252162);
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
    AppMethodBeat.o(252162);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494204;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252157);
    this.type = getIntent().getIntExtra("BLOCK_LIST_TYPE", 0);
    Object localObject1;
    switch (this.type)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      this.uWp = ((ak)localObject1);
      if (this.uWp == null) {
        finish();
      }
      localObject1 = this.uWp;
      if (localObject1 == null) {
        kotlin.g.b.p.hyc();
      }
      setMMTitle(((ak)localObject1).dql());
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      localObject1 = this.uWp;
      if (localObject1 == null) {
        kotlin.g.b.p.hyc();
      }
      this.uWr = new FinderBlockListContract.BlockListPresenter((ak)localObject1);
      localObject1 = (MMActivity)this;
      Object localObject2 = getContentView();
      kotlin.g.b.p.g(localObject2, "contentView");
      Object localObject3 = this.uWr;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      localObject1 = new FinderBlockListContract.BlockListViewCallback((MMActivity)localObject1, (View)localObject2, (FinderBlockListContract.BlockListPresenter)localObject3);
      localObject2 = this.uWr;
      if (localObject2 == null) {
        kotlin.g.b.p.hyc();
      }
      ((FinderBlockListContract.BlockListPresenter)localObject2).a((FinderBlockListContract.BlockListViewCallback)localObject1);
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).contentView.findViewById(2131307118);
      kotlin.g.b.p.g(localObject2, "contentView.findViewById(R.id.rl_layout)");
      ((FinderBlockListContract.BlockListViewCallback)localObject1).tLS = ((RefreshLoadMoreLayout)localObject2);
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tLS;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("rlLayout");
      }
      localObject3 = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject3, "MMApplicationContext.getContext()");
      int i = (int)((Context)localObject3).getResources().getDimension(2131166379);
      localObject3 = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject3, "MMApplicationContext.getContext()");
      ((RefreshLoadMoreLayout)localObject2).setLimitTopRequest(i - (int)((Context)localObject3).getResources().getDimension(2131165281));
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tLS;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("rlLayout");
      }
      localObject3 = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject3, "MMApplicationContext.getContext()");
      i = (int)((Context)localObject3).getResources().getDimension(2131165310);
      localObject3 = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject3, "MMApplicationContext.getContext()");
      ((RefreshLoadMoreLayout)localObject2).setRefreshTargetY(i - (int)((Context)localObject3).getResources().getDimension(2131166379));
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tLS;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject2).setDamping(1.85F);
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tLS;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("rlLayout");
      }
      ((FinderBlockListContract.BlockListViewCallback)localObject1).hak = ((RefreshLoadMoreLayout)localObject2).getRecyclerView();
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).hak;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("recyclerView");
      }
      ((RecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tLS;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject2).setEnableLoadMore(((FinderBlockListContract.BlockListViewCallback)localObject1).uWr.uWp.dqq());
      ((FinderBlockListContract.BlockListViewCallback)localObject1).tFp = new WxRecyclerAdapter((f)new FinderBlockListContract.BlockListViewCallback.initView.1(), ((FinderBlockListContract.BlockListViewCallback)localObject1).uWr.kgc, true);
      if (((FinderBlockListContract.BlockListViewCallback)localObject1).uWs == null) {
        ((FinderBlockListContract.BlockListViewCallback)localObject1).uWs = new i();
      }
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tFp;
      if (localObject2 == null) {
        kotlin.g.b.p.hyc();
      }
      localObject3 = ((FinderBlockListContract.BlockListViewCallback)localObject1).uWs;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      g.a((g)localObject2, (g.b)localObject3);
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).hak;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("recyclerView");
      }
      ((RecyclerView)localObject2).post((Runnable)new FinderBlockListContract.BlockListViewCallback.initView.2((FinderBlockListContract.BlockListViewCallback)localObject1));
      if (((FinderBlockListContract.BlockListViewCallback)localObject1).uWr.uWp.dqm() != -1)
      {
        localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tFp;
        if (localObject2 == null) {
          kotlin.g.b.p.hyc();
        }
        localObject3 = ((FinderBlockListContract.BlockListViewCallback)localObject1).gte.getResources().getString(((FinderBlockListContract.BlockListViewCallback)localObject1).uWr.uWp.dqm());
        kotlin.g.b.p.g(localObject3, "context.resources.getStr…onfig.getSubTitleStrId())");
        g.a((g)localObject2, (g.b)new m((String)localObject3));
      }
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tFp;
      if (localObject2 != null) {
        ((g)localObject2).RqP = ((g.c)new FinderBlockListContract.BlockListViewCallback.initView.3((FinderBlockListContract.BlockListViewCallback)localObject1));
      }
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tFp;
      if (localObject2 != null) {
        ((g)localObject2).RqO = ((g.d)new FinderBlockListContract.BlockListViewCallback.initView.4((FinderBlockListContract.BlockListViewCallback)localObject1));
      }
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).hak;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("recyclerView");
      }
      ((RecyclerView)localObject2).setAdapter((RecyclerView.a)((FinderBlockListContract.BlockListViewCallback)localObject1).tFp);
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tLS;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject2).setOverCallback((HeadFooterLayout.b)localObject1);
      localObject2 = ((FinderBlockListContract.BlockListViewCallback)localObject1).tLS;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("rlLayout");
      }
      ((RefreshLoadMoreLayout)localObject2).setActionCallback((RefreshLoadMoreLayout.a)new FinderBlockListContract.BlockListViewCallback.initView.5((FinderBlockListContract.BlockListViewCallback)localObject1));
      this.uWo = ((FinderBlockListContract.BlockListViewCallback)localObject1);
      localObject1 = this.uWp;
      if (localObject1 == null) {
        kotlin.g.b.p.hyc();
      }
      if (((ak)localObject1).dqn()) {
        addIconOptionMenu(0, 2131690730, (MenuItem.OnMenuItemClickListener)new c(this));
      }
      AppMethodBeat.o(252157);
      return;
      localObject1 = (ak)new b();
      continue;
      localObject1 = (ak)new ad();
      continue;
      localObject1 = (ak)new ae();
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252158);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == vHB)
    {
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getStringExtra("Select_Contact");; paramIntent = null)
      {
        paramIntent = Util.stringToList(paramIntent, ",");
        kotlin.g.b.p.g(paramIntent, "nameList");
        localObject = (Iterable)paramIntent;
        paramIntent = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          FinderContact localFinderContact = new FinderContact();
          localFinderContact.username = str;
          paramIntent.add(localFinderContact);
        }
      }
      paramIntent = (List)paramIntent;
      Object localObject = this.uWr;
      if (localObject != null)
      {
        ((FinderBlockListContract.BlockListPresenter)localObject).eo(paramIntent);
        AppMethodBeat.o(252158);
        return;
      }
    }
    AppMethodBeat.o(252158);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252156);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(252156);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252159);
    super.onDestroy();
    FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.uWr;
    if (localBlockListPresenter != null)
    {
      localBlockListPresenter.onDetach();
      AppMethodBeat.o(252159);
      return;
    }
    AppMethodBeat.o(252159);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252160);
    super.onResume();
    FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.uWr;
    if (localBlockListPresenter != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = localBlockListPresenter.uWp.dqp();
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(new com.tencent.mm.plugin.finder.model.p((FinderContact)((Iterator)localObject2).next()));
        }
      }
      int i;
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label158;
        }
        localObject2 = localBlockListPresenter.uWo;
        if (localObject2 != null) {
          ((FinderBlockListContract.BlockListViewCallback)localObject2).e((List)localObject1, true);
        }
      }
      for (;;)
      {
        d.a(300L, (a)new FinderBlockListContract.BlockListPresenter.initData.1(localBlockListPresenter));
        AppMethodBeat.o(252160);
        return;
        i = 0;
        break;
        label158:
        localObject1 = localBlockListPresenter.uWo;
        if (localObject1 != null) {
          ((FinderBlockListContract.BlockListViewCallback)localObject1).bIo();
        }
      }
    }
    AppMethodBeat.o(252160);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListUI$Companion;", "", "()V", "MAX_MULTI_SELECTED_USER", "", "getMAX_MULTI_SELECTED_USER", "()I", "MENU_ID_ADD_USER", "getMENU_ID_ADD_USER", "REQUEST_CODE_MULTI_ADDR", "getREQUEST_CODE_MULTI_ADDR", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderBlockListUI paramFinderBlockListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252154);
      this.vHD.finish();
      AppMethodBeat.o(252154);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderBlockListUI paramFinderBlockListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252155);
      Log.i(FinderBlockListUI.a(this.vHD), "doCallSelectContactUIForMultiRetransmit");
      paramMenuItem = new Intent();
      paramMenuItem.setClassName((Context)this.vHD, "com.tencent.mm.ui.contact.SelectContactUI");
      paramMenuItem.putExtra("list_type", 1);
      paramMenuItem.putExtra("titile", this.vHD.getString(2131760272));
      paramMenuItem.putExtra("list_attr", u.PWT);
      Object localObject1 = FinderBlockListUI.b(this.vHD);
      if (localObject1 == null) {
        kotlin.g.b.p.hyc();
      }
      Object localObject2 = (Iterable)((FinderBlockListContract.BlockListPresenter)localObject1).kgc;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.model.p)((Iterator)localObject2).next()).contact.username);
      }
      paramMenuItem.putExtra("always_select_contact", Util.listToString((List)localObject1, ","));
      paramMenuItem.putExtra("block_contact", z.aTY());
      localObject1 = FinderBlockListUI.vHC;
      paramMenuItem.putExtra("max_limit_num", FinderBlockListUI.dyW());
      paramMenuItem.putExtra("Forbid_SelectChatRoom", true);
      localObject1 = this.vHD.getContext();
      localObject2 = FinderBlockListUI.vHC;
      ((AppCompatActivity)localObject1).startActivityForResult(paramMenuItem, FinderBlockListUI.dyX());
      AppMethodBeat.o(252155);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlockListUI
 * JD-Core Version:    0.7.0.1
 */