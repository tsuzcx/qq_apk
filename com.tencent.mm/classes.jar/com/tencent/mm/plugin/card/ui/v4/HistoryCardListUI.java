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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v4/HistoryCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "mCardType", "", "mEmptyView", "Landroid/view/ViewGroup;", "mHistoryCardListAdapter", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "mHistoryCardListRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "bindData", "", "doItemClick", "getLayoutId", "gotoCardDetailUI", "position", "initDeleteDialog", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "initView", "jumpToNextPage", "item", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "", "saveSnapshot", "showDeleteCardMenu", "Landroid/view/View;", "showFetchCardListTips", "fetchState", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateCardListView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateIconMenu", "iconMenuData", "", "Companion", "plugin-card_release"})
public final class HistoryCardListUI
  extends CardNewBaseUI
{
  public static final HistoryCardListUI.a qjy;
  private q gxX;
  private ViewGroup qgI;
  private LoadMoreRecyclerView qju;
  private CardsViewModel qjv;
  private c qjw;
  private int qjx = 1;
  
  static
  {
    AppMethodBeat.i(201703);
    qjy = new HistoryCardListUI.a((byte)0);
    AppMethodBeat.o(201703);
  }
  
  public final void ad(int paramInt, boolean paramBoolean) {}
  
  public final int getLayoutId()
  {
    return 2131493802;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(201701);
    Object localObject1 = findViewById(2131299368);
    p.g(localObject1, "findViewById(R.id.ctlu_rv)");
    this.qju = ((LoadMoreRecyclerView)localObject1);
    localObject1 = findViewById(2131298671);
    p.g(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.qgI = ((ViewGroup)localObject1);
    localObject1 = (TextView)findViewById(2131298672);
    Object localObject2 = (WeImageView)findViewById(2131298670);
    ((WeImageView)localObject2).setImageResource(2131690447);
    ((WeImageView)localObject2).setIconColor(getResources().getColor(2131099749));
    localObject2 = this.qju;
    if (localObject2 == null) {
      p.btv("mHistoryCardListRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    this.qjw = new c(true);
    localObject2 = this.qjw;
    if (localObject2 == null) {
      p.btv("mHistoryCardListAdapter");
    }
    ((c)localObject2).au(true);
    localObject2 = this.qju;
    if (localObject2 == null) {
      p.btv("mHistoryCardListRv");
    }
    Object localObject3 = this.qjw;
    if (localObject3 == null) {
      p.btv("mHistoryCardListAdapter");
    }
    ((LoadMoreRecyclerView)localObject2).setAdapter((RecyclerView.a)localObject3);
    localObject2 = new w((Context)getContext(), 1);
    ((w)localObject2).setDrawable(getResources().getDrawable(2131231535));
    localObject3 = this.qju;
    if (localObject3 == null) {
      p.btv("mHistoryCardListRv");
    }
    ((LoadMoreRecyclerView)localObject3).b((RecyclerView.h)localObject2);
    localObject2 = this.qju;
    if (localObject2 == null) {
      p.btv("mHistoryCardListRv");
    }
    ((LoadMoreRecyclerView)localObject2).setLoadingView(2131493384);
    localObject2 = this.qju;
    if (localObject2 == null) {
      p.btv("mHistoryCardListRv");
    }
    localObject3 = this.qgI;
    if (localObject3 == null) {
      p.btv("mEmptyView");
    }
    ((LoadMoreRecyclerView)localObject2).setEmptyView((View)localObject3);
    ((TextView)localObject1).setText(2131757055);
    localObject1 = getIntent().getStringExtra("title");
    this.qjx = getIntent().getIntExtra("card_type", 2);
    localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label428;
      }
      setMMTitle((String)localObject1);
    }
    for (;;)
    {
      setActionbarColor(getResources().getColor(2131099648));
      hideActionbarLine();
      setBackBtn((MenuItem.OnMenuItemClickListener)new l(this));
      AppMethodBeat.o(201701);
      return;
      i = 0;
      break;
      label428:
      setMMTitle(2131766757);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201700);
    super.onCreate(paramBundle);
    initView();
    paramBundle = this.qju;
    if (paramBundle == null) {
      p.btv("mHistoryCardListRv");
    }
    paramBundle.setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new g(this));
    paramBundle = this.qju;
    if (paramBundle == null) {
      p.btv("mHistoryCardListRv");
    }
    paramBundle.setOnItemClickListener((MRecyclerView.a)new h(this));
    paramBundle = this.qju;
    if (paramBundle == null) {
      p.btv("mHistoryCardListRv");
    }
    paramBundle.setOnItemLongClickListener((MRecyclerView.b)new i(this));
    switch (this.qjx)
    {
    default: 
      paramBundle = ViewModelProviders.of((FragmentActivity)this).get(CouponHistoryCardListViewModel.class);
      p.g(paramBundle, "ViewModelProviders.of(th…istViewModel::class.java)");
      paramBundle = (CardsViewModel)paramBundle;
    }
    for (;;)
    {
      this.qjv = paramBundle;
      paramBundle = this.qjv;
      if (paramBundle == null) {
        p.btv("mViewModel");
      }
      ((LiveData)paramBundle.qiN).observe((LifecycleOwner)this, (Observer)new b(this));
      paramBundle = this.qjv;
      if (paramBundle == null) {
        p.btv("mViewModel");
      }
      ((LiveData)paramBundle.qiO).observe((LifecycleOwner)this, (Observer)new c(this));
      paramBundle = this.qjv;
      if (paramBundle == null) {
        p.btv("mViewModel");
      }
      ((LiveData)paramBundle.qiP).observe((LifecycleOwner)this, (Observer)new d(this));
      paramBundle = this.qjv;
      if (paramBundle == null) {
        p.btv("mViewModel");
      }
      ((LiveData)paramBundle.qiQ).observe((LifecycleOwner)this, (Observer)new e(this));
      paramBundle = this.qjv;
      if (paramBundle == null) {
        p.btv("mViewModel");
      }
      ((LiveData)paramBundle.qiR).observe((LifecycleOwner)this, (Observer)new f(this));
      paramBundle = this.qjv;
      if (paramBundle == null) {
        p.btv("mViewModel");
      }
      paramBundle.cxu();
      paramBundle = this.qjv;
      if (paramBundle == null) {
        p.btv("mViewModel");
      }
      paramBundle.d((b)this);
      AppMethodBeat.o(201700);
      return;
      paramBundle = ViewModelProviders.of((FragmentActivity)this).get(CouponHistoryCardListViewModel.class);
      p.g(paramBundle, "ViewModelProviders.of(th…istViewModel::class.java)");
      paramBundle = (CardsViewModel)paramBundle;
      continue;
      paramBundle = ViewModelProviders.of((FragmentActivity)this).get(MemberHistoryCardListViewModel.class);
      p.g(paramBundle, "ViewModelProviders.of(th…istViewModel::class.java)");
      paramBundle = (CardsViewModel)paramBundle;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201702);
    super.onDestroy();
    CardsViewModel localCardsViewModel = this.qjv;
    if (localCardsViewModel == null) {
      p.btv("mViewModel");
    }
    localCardsViewModel.cxv();
    AppMethodBeat.o(201702);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "iconMenuData", "", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "onChanged"})
  static final class b<T>
    implements Observer<List<? extends ue>>
  {
    b(HistoryCardListUI paramHistoryCardListUI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "jumpUrlItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "onChanged"})
  static final class c<T>
    implements Observer<ue>
  {
    c(HistoryCardListUI paramHistoryCardListUI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "onChanged"})
  static final class d<T>
    implements Observer<ArrayList<a>>
  {
    d(HistoryCardListUI paramHistoryCardListUI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "onChanged"})
  static final class e<T>
    implements Observer<e>
  {
    e(HistoryCardListUI paramHistoryCardListUI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isShowDialog", "", "onChanged", "(Ljava/lang/Boolean;)V"})
  static final class f<T>
    implements Observer<Boolean>
  {
    f(HistoryCardListUI paramHistoryCardListUI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class g
    implements LoadMoreRecyclerView.a
  {
    g(HistoryCardListUI paramHistoryCardListUI) {}
    
    public final void bYy()
    {
      AppMethodBeat.i(201689);
      HistoryCardListUI.a(this.qjz).c((b)this.qjz);
      AppMethodBeat.o(201689);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class h
    implements MRecyclerView.a
  {
    h(HistoryCardListUI paramHistoryCardListUI) {}
    
    public final void S(View paramView, int paramInt)
    {
      AppMethodBeat.i(201690);
      HistoryCardListUI.a(this.qjz, paramInt);
      AppMethodBeat.o(201690);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class i
    implements MRecyclerView.b
  {
    i(HistoryCardListUI paramHistoryCardListUI) {}
    
    public final boolean T(View paramView, int paramInt)
    {
      AppMethodBeat.i(201691);
      HistoryCardListUI localHistoryCardListUI = this.qjz;
      p.g(paramView, "view");
      boolean bool = HistoryCardListUI.a(localHistoryCardListUI, paramInt, paramView);
      AppMethodBeat.o(201691);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class j
    implements o.f
  {
    j(HistoryCardListUI paramHistoryCardListUI) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(201692);
      paramm.a(1, this.qjz.getResources().getColor(2131100996), (CharSequence)this.qjz.getString(2131755778));
      AppMethodBeat.o(201692);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class k
    implements o.g
  {
    k(HistoryCardListUI paramHistoryCardListUI, a parama, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(201693);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(201693);
        return;
      }
      switch (HistoryCardListUI.b(this.qjz))
      {
      default: 
        paramInt = 2;
      }
      for (;;)
      {
        paramMenuItem = this.qiY.qiw;
        if (paramMenuItem != null)
        {
          String str = paramMenuItem.KDM;
          paramMenuItem = str;
          if (str != null) {}
        }
        else
        {
          paramMenuItem = "";
        }
        Log.i("MicroMsg.HistoryCardListUI", "delete card, cardIndex: " + this.gUj + ", cardID: " + paramMenuItem + ", pageScene: " + paramInt);
        h.CyF.a(21329, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), paramMenuItem, Integer.valueOf(this.gUj) });
        HistoryCardListUI.a(this.qjz).a(this.qiY);
        break;
        paramInt = 2;
        continue;
        paramInt = 1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class l
    implements MenuItem.OnMenuItemClickListener
  {
    l(HistoryCardListUI paramHistoryCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201694);
      this.qjz.finish();
      AppMethodBeat.o(201694);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$showDeleteCardMenu$1$1"})
  static final class m
    implements View.OnCreateContextMenuListener
  {
    m(HistoryCardListUI paramHistoryCardListUI, View paramView, a parama, int paramInt) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(201695);
      paramContextMenu.add(0, 1, 0, (CharSequence)this.qjz.getString(2131755778));
      AppMethodBeat.o(201695);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$showDeleteCardMenu$1$2"})
  static final class n
    implements o.g
  {
    n(HistoryCardListUI paramHistoryCardListUI, View paramView, a parama, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(201696);
      HistoryCardListUI.a(this.qjz, this.qiX, this.oeZ);
      AppMethodBeat.o(201696);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$updateIconMenu$1$1"})
  static final class o
    implements MenuItem.OnMenuItemClickListener
  {
    o(List paramList, HistoryCardListUI paramHistoryCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201699);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.qjz.getContext(), 1, false);
      paramMenuItem.a((o.f)new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(201697);
          Iterator localIterator = ((Iterable)this.qjA.qit).iterator();
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
          AppMethodBeat.o(201697);
        }
      });
      paramMenuItem.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(201698);
          HistoryCardListUI.a(this.qjA.qjz).EG(paramAnonymousInt);
          AppMethodBeat.o(201698);
        }
      });
      paramMenuItem.dGm();
      AppMethodBeat.o(201699);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.HistoryCardListUI
 * JD-Core Version:    0.7.0.1
 */