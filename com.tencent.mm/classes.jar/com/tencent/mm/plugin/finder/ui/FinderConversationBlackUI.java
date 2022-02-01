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
import android.arch.b.i;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.h.c.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.f;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.concurrent.Executor;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ContactDataSource", "ContactDataSourceFactory", "ContactHolder", "ContactItem", "ContactListAdapter", "PageParam", "plugin-finder_release"})
public final class FinderConversationBlackUI
  extends MMActivity
{
  public static final FinderConversationBlackUI.a vHF;
  private HashMap _$_findViewCache;
  private final f vHE;
  
  static
  {
    AppMethodBeat.i(252176);
    vHF = new FinderConversationBlackUI.a((byte)0);
    AppMethodBeat.o(252176);
  }
  
  public FinderConversationBlackUI()
  {
    AppMethodBeat.i(252175);
    this.vHE = new f();
    AppMethodBeat.o(252175);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252178);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252178);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252177);
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
    AppMethodBeat.o(252177);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494231;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252174);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("KEY_TALKER_TYPE", -1);
    Log.i("Finder.ConversationBlackUI", "[onCreate] talkerType==".concat(String.valueOf(i)));
    setMMTitle(2131760647);
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
    paramBundle = new h.d.a().au().aw().ax().av().ay();
    Object localObject = (RecyclerView)_$_findCachedViewById(2131299243);
    p.g(localObject, "this");
    ((RecyclerView)localObject).getContext();
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((RecyclerView)localObject).setAdapter(((RecyclerView)localObject).getAdapter());
    RecyclerView.f localf = ((RecyclerView)localObject).getItemAnimator();
    if (localf != null) {
      localf.lB();
    }
    localObject = ((RecyclerView)localObject).getItemAnimator();
    if (localObject != null) {
      ((RecyclerView.f)localObject).lw();
    }
    localObject = new i(this);
    paramBundle = new e((d.a)new c(i), paramBundle).a((h.a)localObject).a((Executor)a.cXm()).as();
    p.g(paramBundle, "LivePagedListBuilder(Con…tor)\n            .build()");
    paramBundle.observe((LifecycleOwner)this, (Observer)new h(this, (i)localObject));
    AppMethodBeat.o(252174);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactDataSource;", "Landroid/arch/paging/PageKeyedDataSource;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$PageParam;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "talkerType", "", "(I)V", "loadAfter", "", "params", "Landroid/arch/paging/PageKeyedDataSource$LoadParams;", "callback", "Landroid/arch/paging/PageKeyedDataSource$LoadCallback;", "loadBefore", "loadInitial", "Landroid/arch/paging/PageKeyedDataSource$LoadInitialParams;", "Landroid/arch/paging/PageKeyedDataSource$LoadInitialCallback;", "plugin-finder_release"})
  public static final class b
    extends f<Object, FinderConversationBlackUI.e>
  {
    private final int vHG;
    
    public b(int paramInt)
    {
      this.vHG = paramInt;
    }
    
    public final void a(f.c<Object> paramc, f.a<Object, FinderConversationBlackUI.e> parama)
    {
      AppMethodBeat.i(252164);
      p.h(paramc, "params");
      p.h(parama, "callback");
      AppMethodBeat.o(252164);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactDataSourceFactory;", "Landroid/arch/paging/DataSource$Factory;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$PageParam;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "talkerType", "", "(I)V", "create", "Landroid/arch/paging/DataSource;", "plugin-finder_release"})
  public static final class c
    extends d.a<Object, FinderConversationBlackUI.e>
  {
    private final int vHG;
    
    public c(int paramInt)
    {
      this.vHG = paramInt;
    }
    
    public final d<Object, FinderConversationBlackUI.e> ar()
    {
      AppMethodBeat.i(252165);
      d locald = (d)new FinderConversationBlackUI.b(this.vHG);
      AppMethodBeat.o(252165);
      return locald;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter;", "Landroid/arch/paging/PagedListAdapter;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactHolder;", "()V", "onBindViewHolder", "", "p0", "p1", "", "onCreateViewHolder", "Landroid/view/ViewGroup;", "Companion", "plugin-finder_release"})
  public static final class f
    extends i<FinderConversationBlackUI.e, FinderConversationBlackUI.d>
  {
    private static final b vHH;
    public static final FinderConversationBlackUI.f.a vHI;
    
    static
    {
      AppMethodBeat.i(252171);
      vHI = new FinderConversationBlackUI.f.a((byte)0);
      vHH = new b();
      AppMethodBeat.o(252171);
    }
    
    public f()
    {
      super();
      AppMethodBeat.i(252170);
      AppMethodBeat.o(252170);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter$Companion$DIFF_CALLBACK$1", "Landroid/support/v7/util/DiffUtil$ItemCallback;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "plugin-finder_release"})
    public static final class b
      extends c.c<FinderConversationBlackUI.e>
    {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderConversationBlackUI paramFinderConversationBlackUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252172);
      this.vHJ.finish();
      AppMethodBeat.o(252172);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/arch/paging/PagedList;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class h<T>
    implements Observer<h<FinderConversationBlackUI.e>>
  {
    h(FinderConversationBlackUI paramFinderConversationBlackUI, FinderConversationBlackUI.i parami) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$onCreate$boundaryCallback$1", "Landroid/arch/paging/PagedList$BoundaryCallback;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "onItemAtEndLoaded", "", "itemAtEnd", "onItemAtFrontLoaded", "itemAtFront", "onItemsChangeLoaded", "onZeroItemsLoaded", "plugin-finder_release"})
  public static final class i
    extends h.a<FinderConversationBlackUI.e>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationBlackUI
 * JD-Core Version:    0.7.0.1
 */