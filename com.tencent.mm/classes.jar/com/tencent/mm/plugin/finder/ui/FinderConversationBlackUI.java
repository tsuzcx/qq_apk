package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.i.d;
import androidx.i.d.a;
import androidx.i.e;
import androidx.i.f;
import androidx.i.f.a;
import androidx.i.f.c;
import androidx.i.h;
import androidx.i.h.a;
import androidx.i.h.d.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.concurrent.Executor;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactListAdapter;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ContactDataSource", "ContactDataSourceFactory", "ContactHolder", "ContactItem", "ContactListAdapter", "PageParam", "plugin-finder_release"})
public final class FinderConversationBlackUI
  extends MMFinderUI
{
  public static final FinderConversationBlackUI.a AoC;
  private final FinderConversationBlackUI.f AoB;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(226092);
    AoC = new FinderConversationBlackUI.a((byte)0);
    AppMethodBeat.o(226092);
  }
  
  public FinderConversationBlackUI()
  {
    AppMethodBeat.i(226091);
    this.AoB = new FinderConversationBlackUI.f();
    AppMethodBeat.o(226091);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(226097);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(226097);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(226095);
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
    AppMethodBeat.o(226095);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_conversation_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(226090);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("KEY_TALKER_TYPE", -1);
    Log.i("Finder.ConversationBlackUI", "[onCreate] talkerType==".concat(String.valueOf(i)));
    setMMTitle(b.j.finder_un_accept_msg_title);
    setBackBtn((MenuItem.OnMenuItemClickListener)new FinderConversationBlackUI.g(this));
    paramBundle = new h.d.a().jE().jG().jH().jF().jI();
    Object localObject = (RecyclerView)_$_findCachedViewById(b.f.conversationRecyclerView);
    p.j(localObject, "this");
    ((RecyclerView)localObject).getContext();
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((RecyclerView)localObject).setAdapter(((RecyclerView)localObject).getAdapter());
    RecyclerView.f localf = ((RecyclerView)localObject).getItemAnimator();
    if (localf != null) {
      localf.n(0L);
    }
    localObject = ((RecyclerView)localObject).getItemAnimator();
    if (localObject != null) {
      ((RecyclerView.f)localObject).l(0L);
    }
    localObject = new i(this);
    paramBundle = new e((d.a)new c(i), paramBundle).a((h.a)localObject).a((Executor)a.dmw()).jC();
    p.j(paramBundle, "LivePagedListBuilder(Con…tor)\n            .build()");
    paramBundle.a((androidx.lifecycle.l)this, (s)new h(this, (i)localObject));
    AppMethodBeat.o(226090);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactDataSource;", "Landroidx/paging/PageKeyedDataSource;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$PageParam;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "talkerType", "", "(I)V", "loadAfter", "", "params", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "callback", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "loadBefore", "loadInitial", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "plugin-finder_release"})
  public static final class b
    extends f<Object, FinderConversationBlackUI.e>
  {
    private final int AoD;
    
    public b(int paramInt)
    {
      this.AoD = paramInt;
    }
    
    public final void a(f.c<Object> paramc, f.a<Object, FinderConversationBlackUI.e> parama)
    {
      AppMethodBeat.i(276405);
      p.k(paramc, "params");
      p.k(parama, "callback");
      AppMethodBeat.o(276405);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$PageParam;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "talkerType", "", "(I)V", "create", "Landroidx/paging/DataSource;", "plugin-finder_release"})
  public static final class c
    extends d.a<Object, FinderConversationBlackUI.e>
  {
    private final int AoD;
    
    public c(int paramInt)
    {
      this.AoD = paramInt;
    }
    
    public final d<Object, FinderConversationBlackUI.e> jB()
    {
      AppMethodBeat.i(227212);
      d locald = (d)new FinderConversationBlackUI.b(this.AoD);
      AppMethodBeat.o(227212);
      return locald;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroidx/paging/PagedList;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class h<T>
    implements s<h<FinderConversationBlackUI.e>>
  {
    h(FinderConversationBlackUI paramFinderConversationBlackUI, FinderConversationBlackUI.i parami) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$onCreate$boundaryCallback$1", "Landroidx/paging/PagedList$BoundaryCallback;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationBlackUI$ContactItem;", "onItemAtEndLoaded", "", "itemAtEnd", "onItemAtFrontLoaded", "itemAtFront", "onItemsChangeLoaded", "onZeroItemsLoaded", "plugin-finder_release"})
  public static final class i
    extends h.a<FinderConversationBlackUI.e>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationBlackUI
 * JD-Core Version:    0.7.0.1
 */