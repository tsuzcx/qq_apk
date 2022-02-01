package com.tencent.mm.plugin.card.ui.v4;

import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.w;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "mCardsCardListAdapter", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "mEmptyView", "Landroid/view/ViewGroup;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel;", "needForceRefresh", "", "bindData", "", "doItemClick", "getLayoutId", "", "gotoCardDetailUI", "position", "gotoCouponHistoryCardListUI", "title", "initView", "jumpToNextPage", "item", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showDeleteCardAlert", "Landroid/view/View;", "showDeleteConfirmDialog", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "showFetchCardListTips", "fetchState", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateCardListView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateIconMenu", "iconMenuData", "", "plugin-card_release"})
public final class CouponAndGiftCardListV4UI
  extends CardNewBaseUI
{
  private final String TAG = "MicroMsg.CouponAndGiftCardListV4UI";
  private q gxX;
  private ViewGroup qgI;
  private LoadMoreRecyclerView qiS;
  private CouponAndGiftCardListViewModel qiT;
  private c qiU;
  private boolean qiV;
  
  public final void ad(int paramInt, boolean paramBoolean) {}
  
  public final int getLayoutId()
  {
    return 2131493802;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(201641);
    Object localObject1 = findViewById(2131299368);
    p.g(localObject1, "findViewById(R.id.ctlu_rv)");
    this.qiS = ((LoadMoreRecyclerView)localObject1);
    localObject1 = findViewById(2131298671);
    p.g(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.qgI = ((ViewGroup)localObject1);
    localObject1 = this.qiS;
    if (localObject1 == null) {
      p.btv("mCouponCardListRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    this.qiU = new c();
    localObject1 = this.qiU;
    if (localObject1 == null) {
      p.btv("mCardsCardListAdapter");
    }
    ((c)localObject1).au(true);
    localObject1 = this.qiS;
    if (localObject1 == null) {
      p.btv("mCouponCardListRv");
    }
    Object localObject2 = this.qiU;
    if (localObject2 == null) {
      p.btv("mCardsCardListAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext(), 1);
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231535));
    localObject2 = this.qiS;
    if (localObject2 == null) {
      p.btv("mCouponCardListRv");
    }
    ((LoadMoreRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = this.qiS;
    if (localObject1 == null) {
      p.btv("mCouponCardListRv");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView(2131493384);
    localObject1 = this.qiS;
    if (localObject1 == null) {
      p.btv("mCouponCardListRv");
    }
    localObject2 = this.qgI;
    if (localObject2 == null) {
      p.btv("mEmptyView");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
    localObject1 = getIntent().getStringExtra("title");
    localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label353;
      }
      setMMTitle((String)localObject1);
    }
    for (;;)
    {
      setActionbarColor(getResources().getColor(2131099648));
      hideActionbarLine();
      setBackBtn((MenuItem.OnMenuItemClickListener)new i(this));
      AppMethodBeat.o(201641);
      return;
      i = 0;
      break;
      label353:
      setMMTitle(2131756989);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201640);
    super.onCreate(paramBundle);
    initView();
    paramBundle = this.qiS;
    if (paramBundle == null) {
      p.btv("mCouponCardListRv");
    }
    paramBundle.setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new f(this));
    paramBundle = this.qiS;
    if (paramBundle == null) {
      p.btv("mCouponCardListRv");
    }
    paramBundle.setOnItemClickListener((MRecyclerView.a)new g(this));
    paramBundle = this.qiS;
    if (paramBundle == null) {
      p.btv("mCouponCardListRv");
    }
    paramBundle.setOnItemLongClickListener((MRecyclerView.b)new h(this));
    paramBundle = ViewModelProviders.of((FragmentActivity)this).get(CouponAndGiftCardListViewModel.class);
    p.g(paramBundle, "ViewModelProviders.of(th…istViewModel::class.java)");
    this.qiT = ((CouponAndGiftCardListViewModel)paramBundle);
    paramBundle = this.qiT;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.qiN).observe((LifecycleOwner)this, (Observer)new a(this));
    paramBundle = this.qiT;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.qiO).observe((LifecycleOwner)this, (Observer)new b(this));
    paramBundle = this.qiT;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.qiP).observe((LifecycleOwner)this, (Observer)new c(this));
    paramBundle = this.qiT;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.qiQ).observe((LifecycleOwner)this, (Observer)new d(this));
    paramBundle = this.qiT;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    ((LiveData)paramBundle.qiR).observe((LifecycleOwner)this, (Observer)new e(this));
    paramBundle = this.qiT;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    paramBundle.cxu();
    paramBundle = this.qiT;
    if (paramBundle == null) {
      p.btv("mViewModel");
    }
    paramBundle.d((b)this);
    AppMethodBeat.o(201640);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201643);
    super.onDestroy();
    CouponAndGiftCardListViewModel localCouponAndGiftCardListViewModel = this.qiT;
    if (localCouponAndGiftCardListViewModel == null) {
      p.btv("mViewModel");
    }
    localCouponAndGiftCardListViewModel.cxv();
    AppMethodBeat.o(201643);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201642);
    if (this.qiV)
    {
      CouponAndGiftCardListViewModel localCouponAndGiftCardListViewModel = this.qiT;
      if (localCouponAndGiftCardListViewModel == null) {
        p.btv("mViewModel");
      }
      localCouponAndGiftCardListViewModel.d((b)this);
      this.qiV = false;
    }
    super.onResume();
    AppMethodBeat.o(201642);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "iconMenuData", "", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "onChanged"})
  static final class a<T>
    implements Observer<List<? extends ue>>
  {
    a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "jumpUrlItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "onChanged"})
  static final class b<T>
    implements Observer<ue>
  {
    b(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "onChanged"})
  static final class c<T>
    implements Observer<ArrayList<a>>
  {
    c(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "onChanged"})
  static final class d<T>
    implements Observer<e>
  {
    d(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isShowDialog", "", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class e<T>
    implements Observer<Boolean>
  {
    e(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class f
    implements LoadMoreRecyclerView.a
  {
    f(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
    
    public final void bYy()
    {
      AppMethodBeat.i(201629);
      CouponAndGiftCardListV4UI.a(this.qiW).c((b)this.qiW);
      AppMethodBeat.o(201629);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class g
    implements MRecyclerView.a
  {
    g(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
    
    public final void S(View paramView, int paramInt)
    {
      AppMethodBeat.i(201630);
      CouponAndGiftCardListV4UI.a(this.qiW, paramInt);
      AppMethodBeat.o(201630);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class h
    implements MRecyclerView.b
  {
    h(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
    
    public final boolean T(View paramView, int paramInt)
    {
      AppMethodBeat.i(201631);
      CouponAndGiftCardListV4UI localCouponAndGiftCardListV4UI = this.qiW;
      p.g(paramView, "view");
      boolean bool = CouponAndGiftCardListV4UI.a(localCouponAndGiftCardListV4UI, paramInt, paramView);
      AppMethodBeat.o(201631);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201632);
      this.qiW.finish();
      AppMethodBeat.o(201632);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI$showDeleteCardAlert$1$1"})
  static final class j
    implements View.OnCreateContextMenuListener
  {
    j(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, View paramView, a parama) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(201633);
      paramContextMenu.add(0, 1, 0, (CharSequence)this.qiW.getString(2131755778));
      AppMethodBeat.o(201633);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI$showDeleteCardAlert$1$2"})
  static final class k
    implements o.g
  {
    k(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, View paramView, a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(201634);
      CouponAndGiftCardListV4UI.a(this.qiW, this.qiX);
      AppMethodBeat.o(201634);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class l
    implements o.f
  {
    l(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(201635);
      paramm.a(1, this.qiW.getResources().getColor(2131100996), (CharSequence)this.qiW.getString(2131755778));
      AppMethodBeat.o(201635);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class m
    implements o.g
  {
    m(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(201636);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(201636);
        return;
        CouponAndGiftCardListV4UI.a(this.qiW).a(this.qiY);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI$updateIconMenu$1$1"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(List paramList, CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201639);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.qiW.getContext(), 1, false);
      paramMenuItem.a((o.f)new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(201637);
          Iterator localIterator = ((Iterable)this.qiZ.qit).iterator();
          int i = 0;
          while (localIterator.hasNext())
          {
            Object localObject = localIterator.next();
            if (i < 0) {
              j.hxH();
            }
            paramAnonymousm.add(0, i, 1, (CharSequence)((ue)localObject).LdB);
            i += 1;
          }
          AppMethodBeat.o(201637);
        }
      });
      paramMenuItem.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(201638);
          CouponAndGiftCardListV4UI.a(this.qiZ.qiW).EG(paramAnonymousInt);
          AppMethodBeat.o(201638);
        }
      });
      paramMenuItem.dGm();
      h.CyF.a(19747, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      AppMethodBeat.o(201639);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListV4UI
 * JD-Core Version:    0.7.0.1
 */