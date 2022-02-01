package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.b.d;
import android.arch.b.d.a;
import android.arch.b.e;
import android.arch.b.f;
import android.arch.b.f.a;
import android.arch.b.f.c;
import android.arch.b.h;
import android.arch.b.h.a;
import android.arch.b.h.d.a;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.i;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.concurrent.Executor;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ContactDataSource", "ContactDataSourceFactory", "ContactHolder", "ContactItem", "ContactListAdapter", "PageParam", "plugin-finder_release"})
public final class FinderConversationBlackUI
  extends MMActivity
{
  public static final FinderConversationBlackUI.a sLP;
  private HashMap _$_findViewCache;
  private final FinderConversationBlackUI.f sLO;
  
  static
  {
    AppMethodBeat.i(204497);
    sLP = new FinderConversationBlackUI.a((byte)0);
    AppMethodBeat.o(204497);
  }
  
  public FinderConversationBlackUI()
  {
    AppMethodBeat.i(204496);
    this.sLO = new FinderConversationBlackUI.f();
    AppMethodBeat.o(204496);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204498);
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
    AppMethodBeat.o(204498);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496390;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204495);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("KEY_TALKER_TYPE", -1);
    ae.i("Finder.ConversationBlackUI", "[onCreate] talkerType==".concat(String.valueOf(i)));
    setMMTitle(2131766858);
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
    paramBundle = new h.d.a().as().au().av().at().aw();
    Object localObject = (RecyclerView)_$_findCachedViewById(2131308076);
    p.g(localObject, "this");
    ((RecyclerView)localObject).getContext();
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    ((RecyclerView)localObject).setAdapter(((RecyclerView)localObject).getAdapter());
    RecyclerView.f localf = ((RecyclerView)localObject).getItemAnimator();
    if (localf != null) {
      localf.lt();
    }
    localObject = ((RecyclerView)localObject).getItemAnimator();
    if (localObject != null) {
      ((RecyclerView.f)localObject).lo();
    }
    localObject = new i(this);
    paramBundle = new e((d.a)new c(i), paramBundle).a((h.a)localObject).a((Executor)a.czi()).aq();
    p.g(paramBundle, "LivePagedListBuilder(Con…tor)\n            .build()");
    paramBundle.observe((LifecycleOwner)this, (Observer)new h(this, (i)localObject));
    AppMethodBeat.o(204495);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactDataSource;", "Landroid/arch/paging/PageKeyedDataSource;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$PageParam;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "talkerType", "", "(I)V", "loadAfter", "", "params", "Landroid/arch/paging/PageKeyedDataSource$LoadParams;", "callback", "Landroid/arch/paging/PageKeyedDataSource$LoadCallback;", "loadBefore", "loadInitial", "Landroid/arch/paging/PageKeyedDataSource$LoadInitialParams;", "Landroid/arch/paging/PageKeyedDataSource$LoadInitialCallback;", "plugin-finder_release"})
  public static final class b
    extends f<Object, FinderConversationBlackUI.e>
  {
    private final int sLQ;
    
    public b(int paramInt)
    {
      this.sLQ = paramInt;
    }
    
    public final void a(f.c<Object> paramc, f.a<Object, FinderConversationBlackUI.e> parama)
    {
      AppMethodBeat.i(204485);
      p.h(paramc, "params");
      p.h(parama, "callback");
      AppMethodBeat.o(204485);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactDataSourceFactory;", "Landroid/arch/paging/DataSource$Factory;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$PageParam;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "talkerType", "", "(I)V", "create", "Landroid/arch/paging/DataSource;", "plugin-finder_release"})
  public static final class c
    extends d.a<Object, FinderConversationBlackUI.e>
  {
    private final int sLQ;
    
    public c(int paramInt)
    {
      this.sLQ = paramInt;
    }
    
    public final d<Object, FinderConversationBlackUI.e> ap()
    {
      AppMethodBeat.i(204486);
      d locald = (d)new FinderConversationBlackUI.b(this.sLQ);
      AppMethodBeat.o(204486);
      return locald;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderConversationBlackUI paramFinderConversationBlackUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204493);
      this.sLT.finish();
      AppMethodBeat.o(204493);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/arch/paging/PagedList;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class h<T>
    implements Observer<h<FinderConversationBlackUI.e>>
  {
    h(FinderConversationBlackUI paramFinderConversationBlackUI, FinderConversationBlackUI.i parami) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$onCreate$boundaryCallback$1", "Landroid/arch/paging/PagedList$BoundaryCallback;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "onItemAtEndLoaded", "", "itemAtEnd", "onItemAtFrontLoaded", "itemAtFront", "onItemsChangeLoaded", "onZeroItemsLoaded", "plugin-finder_release"})
  public static final class i
    extends h.a<FinderConversationBlackUI.e>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationBlackUI
 * JD-Core Version:    0.7.0.1
 */