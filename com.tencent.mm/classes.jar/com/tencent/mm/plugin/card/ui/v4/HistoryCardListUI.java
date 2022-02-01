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
import android.widget.TextView;
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
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vending.e.b;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v4/HistoryCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "mCardType", "", "mEmptyView", "Landroid/view/ViewGroup;", "mHistoryCardListAdapter", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "mHistoryCardListRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "bindData", "", "doItemClick", "getLayoutId", "gotoCardDetailUI", "position", "initDeleteDialog", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "initView", "jumpToNextPage", "item", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "", "saveSnapshot", "showDeleteCardMenu", "Landroid/view/View;", "showFetchCardListTips", "fetchState", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateCardListView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateIconMenu", "iconMenuData", "", "Companion", "plugin-card_release"})
public final class HistoryCardListUI
  extends CardNewBaseUI
{
  public static final HistoryCardListUI.a tFu;
  private com.tencent.mm.ui.base.s jhZ;
  private ViewGroup tCE;
  private LoadMoreRecyclerView tFq;
  private d tFr;
  private c tFs;
  private int tFt = 1;
  
  static
  {
    AppMethodBeat.i(249031);
    tFu = new HistoryCardListUI.a((byte)0);
    AppMethodBeat.o(249031);
  }
  
  public final void ac(int paramInt, boolean paramBoolean) {}
  
  public final int getLayoutId()
  {
    return a.e.tjs;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(249027);
    Object localObject1 = findViewById(a.d.tfx);
    p.j(localObject1, "findViewById(R.id.ctlu_rv)");
    this.tFq = ((LoadMoreRecyclerView)localObject1);
    localObject1 = findViewById(a.d.tdT);
    p.j(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.tCE = ((ViewGroup)localObject1);
    localObject1 = (TextView)findViewById(a.d.tdU);
    Object localObject2 = (WeImageView)findViewById(a.d.tdS);
    ((WeImageView)localObject2).setImageResource(a.f.icon_history_card_empty);
    ((WeImageView)localObject2).setIconColor(getResources().getColor(a.a.FG_2));
    localObject2 = this.tFq;
    if (localObject2 == null) {
      p.bGy("mHistoryCardListRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    this.tFs = new c(true);
    localObject2 = this.tFs;
    if (localObject2 == null) {
      p.bGy("mHistoryCardListAdapter");
    }
    ((c)localObject2).aw(true);
    localObject2 = this.tFq;
    if (localObject2 == null) {
      p.bGy("mHistoryCardListRv");
    }
    Object localObject3 = this.tFs;
    if (localObject3 == null) {
      p.bGy("mHistoryCardListAdapter");
    }
    ((LoadMoreRecyclerView)localObject2).setAdapter((RecyclerView.a)localObject3);
    localObject2 = new i((Context)getContext(), 1);
    ((i)localObject2).t(getResources().getDrawable(a.c.taj));
    localObject3 = this.tFq;
    if (localObject3 == null) {
      p.bGy("mHistoryCardListRv");
    }
    ((LoadMoreRecyclerView)localObject3).b((RecyclerView.h)localObject2);
    localObject2 = this.tFq;
    if (localObject2 == null) {
      p.bGy("mHistoryCardListRv");
    }
    ((LoadMoreRecyclerView)localObject2).setLoadingView(a.e.tis);
    localObject2 = this.tFq;
    if (localObject2 == null) {
      p.bGy("mHistoryCardListRv");
    }
    localObject3 = this.tCE;
    if (localObject3 == null) {
      p.bGy("mEmptyView");
    }
    ((LoadMoreRecyclerView)localObject2).setEmptyView((View)localObject3);
    ((TextView)localObject1).setText(a.g.tkw);
    localObject1 = getIntent().getStringExtra("title");
    this.tFt = getIntent().getIntExtra("card_type", 2);
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
      setActionbarColor(getResources().getColor(a.a.BG_0));
      hideActionbarLine();
      setBackBtn((MenuItem.OnMenuItemClickListener)new HistoryCardListUI.l(this));
      AppMethodBeat.o(249027);
      return;
      i = 0;
      break;
      label428:
      setMMTitle(a.g.tmn);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249023);
    super.onCreate(paramBundle);
    initView();
    paramBundle = this.tFq;
    if (paramBundle == null) {
      p.bGy("mHistoryCardListRv");
    }
    paramBundle.setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new g(this));
    paramBundle = this.tFq;
    if (paramBundle == null) {
      p.bGy("mHistoryCardListRv");
    }
    paramBundle.setOnItemClickListener((MRecyclerView.a)new h(this));
    paramBundle = this.tFq;
    if (paramBundle == null) {
      p.bGy("mHistoryCardListRv");
    }
    paramBundle.setOnItemLongClickListener((MRecyclerView.b)new HistoryCardListUI.i(this));
    switch (this.tFt)
    {
    default: 
      paramBundle = z.a((FragmentActivity)this).i(g.class);
      p.j(paramBundle, "ViewModelProviders.of(th…istViewModel::class.java)");
      paramBundle = (d)paramBundle;
    }
    for (;;)
    {
      this.tFr = paramBundle;
      paramBundle = this.tFr;
      if (paramBundle == null) {
        p.bGy("mViewModel");
      }
      ((LiveData)paramBundle.tEJ).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new HistoryCardListUI.b(this));
      paramBundle = this.tFr;
      if (paramBundle == null) {
        p.bGy("mViewModel");
      }
      ((LiveData)paramBundle.tEK).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new HistoryCardListUI.c(this));
      paramBundle = this.tFr;
      if (paramBundle == null) {
        p.bGy("mViewModel");
      }
      ((LiveData)paramBundle.tEL).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new HistoryCardListUI.d(this));
      paramBundle = this.tFr;
      if (paramBundle == null) {
        p.bGy("mViewModel");
      }
      ((LiveData)paramBundle.tEM).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new HistoryCardListUI.e(this));
      paramBundle = this.tFr;
      if (paramBundle == null) {
        p.bGy("mViewModel");
      }
      ((LiveData)paramBundle.tEN).a((androidx.lifecycle.l)this, (androidx.lifecycle.s)new HistoryCardListUI.f(this));
      paramBundle = this.tFr;
      if (paramBundle == null) {
        p.bGy("mViewModel");
      }
      paramBundle.cKW();
      paramBundle = this.tFr;
      if (paramBundle == null) {
        p.bGy("mViewModel");
      }
      paramBundle.d((b)this);
      AppMethodBeat.o(249023);
      return;
      paramBundle = z.a((FragmentActivity)this).i(g.class);
      p.j(paramBundle, "ViewModelProviders.of(th…istViewModel::class.java)");
      paramBundle = (d)paramBundle;
      continue;
      paramBundle = z.a((FragmentActivity)this).i(k.class);
      p.j(paramBundle, "ViewModelProviders.of(th…istViewModel::class.java)");
      paramBundle = (d)paramBundle;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(249029);
    super.onDestroy();
    d locald = this.tFr;
    if (locald == null) {
      p.bGy("mViewModel");
    }
    locald.cKX();
    AppMethodBeat.o(249029);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class g
    implements LoadMoreRecyclerView.a
  {
    g(HistoryCardListUI paramHistoryCardListUI) {}
    
    public final void clj()
    {
      AppMethodBeat.i(246033);
      HistoryCardListUI.a(this.tFv).c((b)this.tFv);
      AppMethodBeat.o(246033);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class h
    implements MRecyclerView.a
  {
    h(HistoryCardListUI paramHistoryCardListUI) {}
    
    public final void U(View paramView, int paramInt)
    {
      AppMethodBeat.i(244374);
      HistoryCardListUI.a(this.tFv, paramInt);
      AppMethodBeat.o(244374);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class j
    implements q.f
  {
    j(HistoryCardListUI paramHistoryCardListUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(245659);
      paramo.a(1, this.tFv.getResources().getColor(a.a.red_text_color), (CharSequence)this.tFv.getString(a.g.app_delete));
      AppMethodBeat.o(245659);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class k
    implements q.g
  {
    k(HistoryCardListUI paramHistoryCardListUI, a parama, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(247550);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(247550);
        return;
      }
      switch (HistoryCardListUI.b(this.tFv))
      {
      default: 
        paramInt = 2;
      }
      for (;;)
      {
        paramMenuItem = this.tEU.tEs;
        if (paramMenuItem != null)
        {
          String str = paramMenuItem.RFf;
          paramMenuItem = str;
          if (str != null) {}
        }
        else
        {
          paramMenuItem = "";
        }
        Log.i("MicroMsg.HistoryCardListUI", "delete card, cardIndex: " + this.jEN + ", cardID: " + paramMenuItem + ", pageScene: " + paramInt);
        h.IzE.a(21329, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), paramMenuItem, Integer.valueOf(this.jEN) });
        HistoryCardListUI.a(this.tFv).a(this.tEU);
        break;
        paramInt = 2;
        continue;
        paramInt = 1;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$showDeleteCardMenu$1$1"})
  static final class m
    implements View.OnCreateContextMenuListener
  {
    m(HistoryCardListUI paramHistoryCardListUI, View paramView, a parama, int paramInt) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(246537);
      paramContextMenu.add(0, 1, 0, (CharSequence)this.tFv.getString(a.g.app_delete));
      AppMethodBeat.o(246537);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$showDeleteCardMenu$1$2"})
  static final class n
    implements q.g
  {
    n(HistoryCardListUI paramHistoryCardListUI, View paramView, a parama, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(246362);
      HistoryCardListUI.a(this.tFv, this.tET, this.rgL);
      AppMethodBeat.o(246362);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI$updateIconMenu$1$1"})
  static final class o
    implements MenuItem.OnMenuItemClickListener
  {
    o(List paramList, HistoryCardListUI paramHistoryCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(244787);
      paramMenuItem = new e((Context)this.tFv.getContext(), 1, false);
      paramMenuItem.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(245681);
          Iterator localIterator = ((Iterable)this.tFw.tEp).iterator();
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
          AppMethodBeat.o(245681);
        }
      });
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(244322);
          HistoryCardListUI.a(this.tFw.tFv).Ih(paramAnonymousInt);
          AppMethodBeat.o(244322);
        }
      });
      paramMenuItem.eik();
      AppMethodBeat.o(244787);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.HistoryCardListUI
 * JD-Core Version:    0.7.0.1
 */