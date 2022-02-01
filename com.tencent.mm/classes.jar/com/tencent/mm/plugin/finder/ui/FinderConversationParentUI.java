package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.conv.e;
import com.tencent.mm.plugin.finder.conv.e.a;
import com.tencent.mm.plugin.finder.conv.e.b;
import com.tencent.mm.plugin.finder.conv.g;
import com.tencent.mm.plugin.finder.conv.g.b;
import com.tencent.mm.plugin.finder.conv.i;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.plugin.findersdk.a.n;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "()V", "animRunnable", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "getAnimRunnable", "()Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "setAnimRunnable", "(Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;)V", "convScene", "", "getConvScene", "()I", "setConvScene", "(I)V", "convType", "getConvType", "setConvType", "conversationAdapter", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "getConversationAdapter", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "setConversationAdapter", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;)V", "dataSource", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "setDataSource", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;)V", "onContactStorageChange", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "onConversationStorageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onFinderContactStorageChange", "checkEmpty", "", "doSomethingOnConvDel", "getLayoutId", "getTitleResId", "", "loadAfter", "data", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "loadInitial", "modifyChange", "obj", "", "onBackPressed", "onChattingUIEnter", "onChattingUIExit", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onDestroy", "onResume", "refreshAll", "reportChatExpose", "updateActionBar", "scene", "Companion", "plugin-finder_release"})
public class FinderConversationParentUI
  extends ReadyChattingCompatUI
  implements g.b
{
  public static final b AoQ;
  int AoI;
  int AoJ;
  public g AoK;
  com.tencent.mm.plugin.finder.conv.b AoL;
  e AoM;
  private final MStorage.IOnStorageChange AoN;
  private final MStorage.IOnStorageChange AoO;
  private final MStorageEx.IOnStorageChange AoP;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(288361);
    AoQ = new b((byte)0);
    AppMethodBeat.o(288361);
  }
  
  public FinderConversationParentUI()
  {
    AppMethodBeat.i(288360);
    this.AoI = -1;
    this.AoJ = -1;
    e locale = new e();
    locale.a((e.b)new i((kotlin.g.a.a)c.AoS));
    locale.a((e.a)new com.tencent.mm.plugin.finder.conv.f((ReadyChattingCompatUI)this, (kotlin.g.a.b)new a(this)));
    this.AoM = locale;
    this.AoN = ((MStorage.IOnStorageChange)new e(this));
    this.AoO = ((MStorage.IOnStorageChange)new j(this));
    this.AoP = ((MStorageEx.IOnStorageChange)new d(this));
    AppMethodBeat.o(288360);
  }
  
  private final void dZS()
  {
    AppMethodBeat.i(288348);
    Object localObject = findViewById(b.f.empty_tip);
    if (localObject != null)
    {
      if (this.AoM.getItemCount() == 0)
      {
        ((View)localObject).setVisibility(0);
        localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(b.f.rl_layout);
        p.j(localObject, "rl_layout");
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
        AppMethodBeat.o(288348);
        return;
      }
      ((View)localObject).setVisibility(8);
      localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(b.f.rl_layout);
      p.j(localObject, "rl_layout");
      ((RefreshLoadMoreLayout)localObject).setVisibility(0);
      AppMethodBeat.o(288348);
      return;
    }
    AppMethodBeat.o(288348);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(288366);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(288366);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(288365);
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
    AppMethodBeat.o(288365);
    return localView1;
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(288351);
    super.a(paramBundle, paramInt);
    paramBundle = this.AwZ;
    if (paramBundle != null) {
      paramBundle.e(Boolean.TRUE);
    }
    this.AoI = getIntent().getIntExtra("KEY_TALKER_TYPE", -1);
    this.AoJ = getIntent().getIntExtra("KEY_TALKER_SCENE", -1);
    this.AoM.pageType = this.AoI;
    this.AoM.scene = this.AoJ;
    Log.i("Finder.FinderConversationParentUI", "[onCreate] scene==" + this.AoI);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).m(this.AoN);
    ((m)com.tencent.mm.kernel.h.ae(m.class)).m(this.AoO);
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
    paramBundle = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getConversationStorage();
    Object localObject = (RecyclerView)_$_findCachedViewById(b.f.conversationRecyclerView);
    p.j(localObject, "this");
    ((RecyclerView)localObject).getContext();
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.AoM);
    ((RecyclerView)localObject).setItemAnimator(null);
    ((RecyclerView)localObject).a((RecyclerView.l)new f(this));
    localObject = (RecyclerView)_$_findCachedViewById(b.f.conversationRecyclerView);
    p.j(localObject, "conversationRecyclerView");
    localObject = ((RecyclerView)localObject).getViewTreeObserver();
    if (localObject != null) {
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new h(this));
    }
    this.AoK = new g(paramBundle, this.AoI, this.AoJ, (g.b)this);
    localObject = this.AoK;
    if (localObject == null) {
      p.bGy("dataSource");
    }
    com.tencent.mm.plugin.finder.storage.f localf = ((g)localObject).xgq;
    if (((g)localObject).type == 1) {
      if (((g)localObject).scene == 2)
      {
        paramBundle = new int[2];
        Bundle tmp347_346 = paramBundle;
        tmp347_346[0] = 2;
        Bundle tmp351_347 = tmp347_346;
        tmp351_347[1] = 100;
        tmp351_347;
      }
    }
    for (;;)
    {
      paramBundle = localf.a(0, 15, paramBundle, ((g)localObject).scene);
      ((g)localObject).xgr.ea(paramBundle);
      ((RefreshLoadMoreLayout)_$_findCachedViewById(b.f.rl_layout)).setActionCallback((RefreshLoadMoreLayout.a)new i(this));
      if (this.AoJ != 1) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.IzE.p(1473L, 11L, 1L);
      AppMethodBeat.o(288351);
      return;
      paramBundle = new int[2];
      Bundle tmp438_437 = paramBundle;
      tmp438_437[0] = 2;
      Bundle tmp442_438 = tmp438_437;
      tmp442_438[1] = 'È';
      tmp442_438;
      continue;
      if (((g)localObject).type == 3)
      {
        paramBundle = new int[1];
        paramBundle[0] = 3;
      }
      else
      {
        paramBundle = new int[1];
        paramBundle[0] = 1;
      }
    }
    if (this.AoJ == 2)
    {
      if (this.AoI == 1)
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(1473L, 12L, 1L);
        AppMethodBeat.o(288351);
        return;
      }
      if (this.AoI == 2) {
        com.tencent.mm.plugin.report.service.h.IzE.p(1473L, 13L, 1L);
      }
    }
    AppMethodBeat.o(288351);
  }
  
  public void atw()
  {
    AppMethodBeat.i(288352);
    super.atw();
    setMMTitle(duZ());
    AppMethodBeat.o(288352);
  }
  
  public final void aty()
  {
    AppMethodBeat.i(288356);
    super.aty();
    RecyclerView localRecyclerView = (RecyclerView)_$_findCachedViewById(b.f.conversationRecyclerView);
    p.j(localRecyclerView, "conversationRecyclerView");
    localRecyclerView.setLayoutFrozen(true);
    AppMethodBeat.o(288356);
  }
  
  public boolean atz()
  {
    AppMethodBeat.i(288357);
    super.atz();
    RecyclerView localRecyclerView = (RecyclerView)_$_findCachedViewById(b.f.conversationRecyclerView);
    p.j(localRecyclerView, "conversationRecyclerView");
    localRecyclerView.setLayoutFrozen(false);
    AppMethodBeat.o(288357);
    return true;
  }
  
  public final g dZQ()
  {
    AppMethodBeat.i(288346);
    g localg = this.AoK;
    if (localg == null) {
      p.bGy("dataSource");
    }
    AppMethodBeat.o(288346);
    return localg;
  }
  
  public void dZR() {}
  
  public final void ds(Object paramObject)
  {
    AppMethodBeat.i(288358);
    int i;
    if ((paramObject instanceof String))
    {
      if (((CharSequence)paramObject).length() <= 0) {
        break label200;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = this.AoM.syG;
        if (localObject1 == null) {
          break label220;
        }
        Iterator localIterator = ((Iterable)localObject1).iterator();
        label54:
        if (!localIterator.hasNext()) {
          break label215;
        }
        Object localObject2 = localIterator.next();
        com.tencent.mm.plugin.finder.conv.d locald = (com.tencent.mm.plugin.finder.conv.d)localObject2;
        localObject1 = locald.contact;
        if (localObject1 == null) {
          break label205;
        }
        localObject1 = ((as)localObject1).getUsername();
        label95:
        if ((!p.h(localObject1, paramObject)) && (!p.h(locald.field_talker, paramObject))) {
          break label210;
        }
        i = 1;
        label117:
        if (i == 0) {
          break label213;
        }
        localObject1 = localObject2;
      }
    }
    label124:
    for (Object localObject1 = (com.tencent.mm.plugin.finder.conv.d)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Log.i("Finder.FinderConversationParentUI", "[onContactStorageChange] username=".concat(String.valueOf(paramObject)));
        paramObject = this.AoM;
        p.k(localObject1, "conv");
        ((com.tencent.mm.plugin.finder.conv.d)localObject1).prepare();
        i = paramObject.syG.indexOf(localObject1);
        if ((i >= 0) && (i < paramObject.syG.size())) {
          paramObject.LW(i);
        }
      }
      AppMethodBeat.o(288358);
      return;
      i = 0;
      break;
      localObject1 = null;
      break label95;
      i = 0;
      break label117;
      break label54;
      localObject1 = null;
      break label124;
    }
  }
  
  public String duZ()
  {
    return "";
  }
  
  public final void ea(List<com.tencent.mm.plugin.finder.conv.d> paramList)
  {
    AppMethodBeat.i(288353);
    p.k(paramList, "data");
    this.AoM.dZ(paramList);
    Object localObject = (MMProcessBar)_$_findCachedViewById(b.f.loadingIcon);
    p.j(localObject, "loadingIcon");
    if (((MMProcessBar)localObject).getVisibility() == 0)
    {
      localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(b.f.rl_layout);
      p.j(localObject, "rl_layout");
      if (((RefreshLoadMoreLayout)localObject).getVisibility() != 0)
      {
        localObject = (MMProcessBar)_$_findCachedViewById(b.f.loadingIcon);
        p.j(localObject, "loadingIcon");
        ((MMProcessBar)localObject).setVisibility(8);
        localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(b.f.rl_layout);
        p.j(localObject, "rl_layout");
        ((RefreshLoadMoreLayout)localObject).setVisibility(0);
      }
    }
    if (paramList.size() < 15) {
      ((RefreshLoadMoreLayout)_$_findCachedViewById(b.f.rl_layout)).setEnableLoadMore(false);
    }
    AppMethodBeat.o(288353);
  }
  
  public final void eb(List<com.tencent.mm.plugin.finder.conv.d> paramList)
  {
    AppMethodBeat.i(288354);
    p.k(paramList, "data");
    Object localObject = RefreshLoadMoreLayout.c.YNO;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.iht());
    ((RefreshLoadMoreLayout.c)localObject).mCI = false;
    if (!((Collection)paramList).isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      ((RefreshLoadMoreLayout.c)localObject).YNF = bool;
      ((RefreshLoadMoreLayout.c)localObject).YNG = paramList.size();
      this.AoM.dZ(paramList);
      ((RefreshLoadMoreLayout)_$_findCachedViewById(b.f.rl_layout)).onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(288354);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(288347);
    super.onBackPressed();
    AppMethodBeat.o(288347);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(288359);
    super.onDestroy();
    ((m)com.tencent.mm.kernel.h.ae(m.class)).l(this.AoO);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).l(this.AoN);
    Object localObject = com.tencent.mm.plugin.finder.report.d.zUg;
    localObject = aj.Bnu;
    localObject = getContext();
    p.j(localObject, "context");
    localObject = aj.a.fZ((Context)localObject);
    if (localObject != null) {}
    for (localObject = ((aj)localObject).ekY();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.d.e((bid)localObject);
      AppMethodBeat.o(288359);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(288349);
    super.onResume();
    com.tencent.mm.plugin.finder.conv.b localb = this.AoL;
    if (localb != null)
    {
      com.tencent.mm.ae.d.a(200L, (Runnable)localb);
      this.AoL = null;
    }
    dZS();
    AppMethodBeat.o(288349);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$conversationAdapter$1$2"})
  static final class a
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.conv.b, x>
  {
    a(FinderConversationParentUI paramFinderConversationParentUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI$Companion;", "", "()V", "DEFAULT_DURATION", "", "KEY_CONV_SCENE", "", "KEY_CONV_TYPE", "MENU_ID_MORE", "", "PAGE_COUNT", "PAGE_INITIAL_COUNT", "PREFETCH_DISTANCE", "REPORT_EXPOSE_SCROLL_LIMIT", "REQUEST_CODE_BLACK_SESSION", "TAG", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final c AoS;
    
    static
    {
      AppMethodBeat.i(278956);
      AoS = new c();
      AppMethodBeat.o(278956);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "kotlin.jvm.PlatformType", "obj", "", "onNotifyChange"})
  static final class d
    implements MStorageEx.IOnStorageChange
  {
    d(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
    {
      AppMethodBeat.i(270547);
      Log.i("Finder.FinderConversationParentUI", "[onContactStorageChange]");
      this.AoR.ds(paramObject);
      AppMethodBeat.o(270547);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class e
    implements MStorage.IOnStorageChange
  {
    e(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void onNotifyChange(String paramString, final MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(277082);
      if ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.finder.conv.d))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversation");
          AppMethodBeat.o(277082);
          throw paramString;
        }
        paramString = (com.tencent.mm.plugin.finder.conv.d)paramString;
        if (paramString.field_scene != this.AoR.AoJ)
        {
          Log.i("Finder.FinderConversationParentUI", "conv.field_scene:" + paramString.field_scene + " != conveScene:" + this.AoR.AoJ);
          AppMethodBeat.o(277082);
          return;
        }
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramMStorageEventData) {});
      }
      AppMethodBeat.o(277082);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$2$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    f(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(282857);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(282857);
        return;
        FinderConversationParentUI.a(this.AoR);
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(282858);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(282858);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(234594);
      this.AoR.finish();
      AppMethodBeat.o(234594);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class h
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(289277);
      FinderConversationParentUI.a(this.AoR);
      Object localObject = (RecyclerView)this.AoR._$_findCachedViewById(b.f.conversationRecyclerView);
      p.j(localObject, "conversationRecyclerView");
      localObject = ((RecyclerView)localObject).getViewTreeObserver();
      if (localObject != null)
      {
        ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        AppMethodBeat.o(289277);
        return;
      }
      AppMethodBeat.o(289277);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(289345);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(289345);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(289347);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(289347);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(289344);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      g localg = this.AoR.dZQ();
      int i = this.AoR.AoM.syG.size();
      com.tencent.mm.plugin.finder.storage.f localf = localg.xgq;
      Object localObject;
      if (localg.type == 1) {
        if (localg.scene == 2)
        {
          localObject = new int[2];
          Object tmp66_65 = localObject;
          tmp66_65[0] = 2;
          Object tmp70_66 = tmp66_65;
          tmp70_66[1] = 100;
          tmp70_66;
        }
      }
      for (;;)
      {
        localObject = localf.a(i, 60, (int[])localObject, localg.scene);
        localg.xgr.eb((List)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(289344);
        return;
        localObject = new int[1];
        localObject[0] = 2;
        continue;
        localObject = new int[1];
        localObject[0] = 1;
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(289346);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(289346);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "obj", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class j
    implements MStorage.IOnStorageChange
  {
    j(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(281087);
      Log.i("Finder.FinderConversationParentUI", "[onFinderContactStorageChange]");
      this.AoR.ds(paramMStorageEventData.obj);
      AppMethodBeat.o(281087);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
 * JD-Core Version:    0.7.0.1
 */