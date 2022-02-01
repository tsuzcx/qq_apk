package com.tencent.mm.plugin.card.ui.v4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vending.e.b;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "mCardsCardListAdapter", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "mEmptyView", "Landroid/view/ViewGroup;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel;", "needForceRefresh", "", "bindData", "", "doItemClick", "getLayoutId", "", "gotoCardDetailUI", "position", "gotoCouponHistoryCardListUI", "title", "initView", "jumpToNextPage", "item", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showDeleteCardAlert", "Landroid/view/View;", "showDeleteConfirmDialog", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "showFetchCardListTips", "fetchState", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateCardListView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateIconMenu", "iconMenuData", "", "plugin-card_release"})
public final class CouponAndGiftCardListV4UI
  extends CardNewBaseUI
{
  private final String TAG = "MicroMsg.CouponAndGiftCardListV4UI";
  private com.tencent.mm.ui.base.s jhZ;
  private ViewGroup tCE;
  private LoadMoreRecyclerView tEO;
  private f tEP;
  private c tEQ;
  private boolean tER;
  
  public final void ac(int paramInt, boolean paramBoolean) {}
  
  public final int getLayoutId()
  {
    return a.e.tjs;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(246219);
    Object localObject1 = findViewById(a.d.tfx);
    p.j(localObject1, "findViewById(R.id.ctlu_rv)");
    this.tEO = ((LoadMoreRecyclerView)localObject1);
    localObject1 = findViewById(a.d.tdT);
    p.j(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.tCE = ((ViewGroup)localObject1);
    localObject1 = this.tEO;
    if (localObject1 == null) {
      p.bGy("mCouponCardListRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    this.tEQ = new c();
    localObject1 = this.tEQ;
    if (localObject1 == null) {
      p.bGy("mCardsCardListAdapter");
    }
    ((c)localObject1).aw(true);
    localObject1 = this.tEO;
    if (localObject1 == null) {
      p.bGy("mCouponCardListRv");
    }
    Object localObject2 = this.tEQ;
    if (localObject2 == null) {
      p.bGy("mCardsCardListAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new i((Context)getContext(), 1);
    ((i)localObject1).t(getResources().getDrawable(a.c.taj));
    localObject2 = this.tEO;
    if (localObject2 == null) {
      p.bGy("mCouponCardListRv");
    }
    ((LoadMoreRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = this.tEO;
    if (localObject1 == null) {
      p.bGy("mCouponCardListRv");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView(a.e.tis);
    localObject1 = this.tEO;
    if (localObject1 == null) {
      p.bGy("mCouponCardListRv");
    }
    localObject2 = this.tCE;
    if (localObject2 == null) {
      p.bGy("mEmptyView");
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
      setActionbarColor(getResources().getColor(a.a.BG_0));
      hideActionbarLine();
      setBackBtn((MenuItem.OnMenuItemClickListener)new CouponAndGiftCardListV4UI.i(this));
      AppMethodBeat.o(246219);
      return;
      i = 0;
      break;
      label353:
      setMMTitle(a.g.thV);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(246217);
    super.onCreate(paramBundle);
    initView();
    paramBundle = this.tEO;
    if (paramBundle == null) {
      p.bGy("mCouponCardListRv");
    }
    paramBundle.setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new f(this));
    paramBundle = this.tEO;
    if (paramBundle == null) {
      p.bGy("mCouponCardListRv");
    }
    paramBundle.setOnItemClickListener((MRecyclerView.a)new g(this));
    paramBundle = this.tEO;
    if (paramBundle == null) {
      p.bGy("mCouponCardListRv");
    }
    paramBundle.setOnItemLongClickListener((MRecyclerView.b)new CouponAndGiftCardListV4UI.h(this));
    paramBundle = z.a((FragmentActivity)this).i(f.class);
    p.j(paramBundle, "ViewModelProviders.of(th…istViewModel::class.java)");
    this.tEP = ((f)paramBundle);
    paramBundle = this.tEP;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.tEJ).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new CouponAndGiftCardListV4UI.a(this));
    paramBundle = this.tEP;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.tEK).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new CouponAndGiftCardListV4UI.b(this));
    paramBundle = this.tEP;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.tEL).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new CouponAndGiftCardListV4UI.c(this));
    paramBundle = this.tEP;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.tEM).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new CouponAndGiftCardListV4UI.d(this));
    paramBundle = this.tEP;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    ((LiveData)paramBundle.tEN).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new CouponAndGiftCardListV4UI.e(this));
    paramBundle = this.tEP;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    paramBundle.cKW();
    paramBundle = this.tEP;
    if (paramBundle == null) {
      p.bGy("mViewModel");
    }
    paramBundle.d((b)this);
    AppMethodBeat.o(246217);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(246221);
    super.onDestroy();
    f localf = this.tEP;
    if (localf == null) {
      p.bGy("mViewModel");
    }
    localf.cKX();
    AppMethodBeat.o(246221);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(246220);
    if (this.tER)
    {
      f localf = this.tEP;
      if (localf == null) {
        p.bGy("mViewModel");
      }
      localf.d((b)this);
      this.tER = false;
    }
    super.onResume();
    AppMethodBeat.o(246220);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class f
    implements LoadMoreRecyclerView.a
  {
    f(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
    
    public final void clj()
    {
      AppMethodBeat.i(246989);
      CouponAndGiftCardListV4UI.a(this.tES).c((b)this.tES);
      AppMethodBeat.o(246989);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class g
    implements MRecyclerView.a
  {
    g(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
    
    public final void U(View paramView, int paramInt)
    {
      AppMethodBeat.i(246031);
      CouponAndGiftCardListV4UI.a(this.tES, paramInt);
      AppMethodBeat.o(246031);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI$showDeleteCardAlert$1$1"})
  static final class j
    implements View.OnCreateContextMenuListener
  {
    j(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, View paramView, a parama) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(246998);
      paramContextMenu.add(0, 1, 0, (CharSequence)this.tES.getString(a.g.app_delete));
      AppMethodBeat.o(246998);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI$showDeleteCardAlert$1$2"})
  static final class k
    implements q.g
  {
    k(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, View paramView, a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(249302);
      CouponAndGiftCardListV4UI.a(this.tES, this.tET);
      AppMethodBeat.o(249302);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class l
    implements q.f
  {
    l(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(255053);
      paramo.a(1, this.tES.getResources().getColor(a.a.red_text_color), (CharSequence)this.tES.getString(a.g.app_delete));
      AppMethodBeat.o(255053);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class m
    implements q.g
  {
    m(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, a parama) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(250465);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(250465);
        return;
        CouponAndGiftCardListV4UI.a(this.tES).a(this.tEU);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI$updateIconMenu$1$1"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(List paramList, CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(246675);
      paramMenuItem = new e((Context)this.tES.getContext(), 1, false);
      paramMenuItem.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(255884);
          Iterator localIterator = ((Iterable)this.tEV.tEp).iterator();
          int i = 0;
          while (localIterator.hasNext())
          {
            Object localObject = localIterator.next();
            if (i < 0) {
              j.iBO();
            }
            paramAnonymouso.add(0, i, 1, (CharSequence)((ug)localObject).SeO);
            i += 1;
          }
          AppMethodBeat.o(255884);
        }
      });
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(244208);
          CouponAndGiftCardListV4UI.a(this.tEV.tES).Ih(paramAnonymousInt);
          AppMethodBeat.o(244208);
        }
      });
      paramMenuItem.eik();
      h.IzE.a(19747, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      AppMethodBeat.o(246675);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListV4UI
 * JD-Core Version:    0.7.0.1
 */