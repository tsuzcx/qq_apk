package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.d.a;
import com.tencent.mm.plugin.finder.conv.d.b;
import com.tencent.mm.plugin.finder.conv.f;
import com.tencent.mm.plugin.finder.conv.f.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.i.a.n;
import com.tencent.mm.protocal.protobuf.bbn;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "()V", "animRunnable", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "getAnimRunnable", "()Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "setAnimRunnable", "(Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;)V", "convScene", "", "getConvScene", "()I", "setConvScene", "(I)V", "convType", "getConvType", "setConvType", "conversationAdapter", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "getConversationAdapter", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "setConversationAdapter", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;)V", "dataSource", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "setDataSource", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;)V", "onContactStorageChange", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "onConversationStorageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onFinderContactStorageChange", "checkEmpty", "", "doSomethingOnConvDel", "getLayoutId", "getTitleResId", "loadAfter", "data", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "loadInitial", "modifyChange", "obj", "", "onBackPressed", "onChattingUIEnter", "onChattingUIExit", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onDestroy", "onResume", "refreshAll", "reportChatExpose", "updateActionBar", "scene", "Companion", "plugin-finder_release"})
public class FinderConversationParentUI
  extends ReadyChattingCompatUI
  implements f.b
{
  public static final b vHT;
  private HashMap _$_findViewCache;
  int vHL;
  int vHM;
  public f vHN;
  com.tencent.mm.plugin.finder.conv.b vHO;
  com.tencent.mm.plugin.finder.conv.d vHP;
  private final MStorage.IOnStorageChange vHQ;
  private final MStorage.IOnStorageChange vHR;
  private final MStorageEx.IOnStorageChange vHS;
  
  static
  {
    AppMethodBeat.i(252206);
    vHT = new b((byte)0);
    AppMethodBeat.o(252206);
  }
  
  public FinderConversationParentUI()
  {
    AppMethodBeat.i(252205);
    this.vHL = -1;
    this.vHM = -1;
    com.tencent.mm.plugin.finder.conv.d locald = new com.tencent.mm.plugin.finder.conv.d();
    locald.a((d.b)new com.tencent.mm.plugin.finder.conv.h((kotlin.g.a.a)c.vHV));
    locald.a((d.a)new com.tencent.mm.plugin.finder.conv.e((ReadyChattingCompatUI)this, (kotlin.g.a.b)new a(this)));
    this.vHP = locald;
    this.vHQ = ((MStorage.IOnStorageChange)new e(this));
    this.vHR = ((MStorage.IOnStorageChange)new j(this));
    this.vHS = ((MStorageEx.IOnStorageChange)new d(this));
    AppMethodBeat.o(252205);
  }
  
  private final void dza()
  {
    AppMethodBeat.i(252195);
    Object localObject = findViewById(2131300101);
    if (localObject != null)
    {
      if (this.vHP.getItemCount() == 0)
      {
        ((View)localObject).setVisibility(0);
        localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(2131307118);
        p.g(localObject, "rl_layout");
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
        AppMethodBeat.o(252195);
        return;
      }
      ((View)localObject).setVisibility(8);
      localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(2131307118);
      p.g(localObject, "rl_layout");
      ((RefreshLoadMoreLayout)localObject).setVisibility(0);
      AppMethodBeat.o(252195);
      return;
    }
    AppMethodBeat.o(252195);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252210);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252210);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252209);
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
    AppMethodBeat.o(252209);
    return localView1;
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(252197);
    super.a(paramBundle, paramInt);
    paramBundle = this.vQb;
    if (paramBundle != null) {
      paramBundle.c(Boolean.TRUE);
    }
    this.vHL = getIntent().getIntExtra("KEY_TALKER_TYPE", -1);
    this.vHM = getIntent().getIntExtra("KEY_TALKER_SCENE", -1);
    this.vHP.pageType = this.vHL;
    this.vHP.scene = this.vHM;
    Log.i("Finder.FinderConversationParentUI", "[onCreate] scene==" + this.vHL);
    ((n)g.af(n.class)).m(this.vHQ);
    ((m)g.af(m.class)).m(this.vHR);
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
    paramBundle = ((PluginFinder)g.ah(PluginFinder.class)).getConversationStorage();
    Object localObject = (RecyclerView)_$_findCachedViewById(2131299243);
    p.g(localObject, "this");
    ((RecyclerView)localObject).getContext();
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.vHP);
    ((RecyclerView)localObject).setItemAnimator(null);
    ((RecyclerView)localObject).a((RecyclerView.l)new f(this));
    localObject = (RecyclerView)_$_findCachedViewById(2131299243);
    p.g(localObject, "conversationRecyclerView");
    localObject = ((RecyclerView)localObject).getViewTreeObserver();
    if (localObject != null) {
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new h(this));
    }
    this.vHN = new f(paramBundle, this.vHL, this.vHM, (f.b)this);
    localObject = this.vHN;
    if (localObject == null) {
      p.btv("dataSource");
    }
    com.tencent.mm.plugin.finder.storage.e locale = ((f)localObject).tyE;
    if (((f)localObject).type == 1) {
      if (((f)localObject).scene == 2)
      {
        paramBundle = new int[2];
        Bundle tmp345_344 = paramBundle;
        tmp345_344[0] = 2;
        Bundle tmp349_345 = tmp345_344;
        tmp349_345[1] = 100;
        tmp349_345;
      }
    }
    for (;;)
    {
      paramBundle = locale.a(0, 15, paramBundle, ((f)localObject).scene);
      ((f)localObject).tyF.dS(paramBundle);
      ((RefreshLoadMoreLayout)_$_findCachedViewById(2131307118)).setActionCallback((RefreshLoadMoreLayout.a)new i(this));
      if (this.vHM != 1) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.CyF.n(1473L, 11L, 1L);
      AppMethodBeat.o(252197);
      return;
      paramBundle = new int[1];
      paramBundle[0] = 2;
      continue;
      paramBundle = new int[1];
      paramBundle[0] = 1;
    }
    if (this.vHM == 2)
    {
      if (this.vHL == 1)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(1473L, 12L, 1L);
        AppMethodBeat.o(252197);
        return;
      }
      if (this.vHL == 2) {
        com.tencent.mm.plugin.report.service.h.CyF.n(1473L, 13L, 1L);
      }
    }
    AppMethodBeat.o(252197);
  }
  
  public void anv()
  {
    AppMethodBeat.i(252198);
    super.anv();
    setMMTitle(dzb());
    AppMethodBeat.o(252198);
  }
  
  public final void anx()
  {
    AppMethodBeat.i(252201);
    super.anx();
    RecyclerView localRecyclerView = (RecyclerView)_$_findCachedViewById(2131299243);
    p.g(localRecyclerView, "conversationRecyclerView");
    localRecyclerView.setLayoutFrozen(true);
    AppMethodBeat.o(252201);
  }
  
  public boolean any()
  {
    AppMethodBeat.i(252202);
    super.any();
    RecyclerView localRecyclerView = (RecyclerView)_$_findCachedViewById(2131299243);
    p.g(localRecyclerView, "conversationRecyclerView");
    localRecyclerView.setLayoutFrozen(false);
    AppMethodBeat.o(252202);
    return true;
  }
  
  public final void dS(List<c> paramList)
  {
    AppMethodBeat.i(252199);
    p.h(paramList, "data");
    this.vHP.dR(paramList);
    Object localObject = (MMProcessBar)_$_findCachedViewById(2131303691);
    p.g(localObject, "loadingIcon");
    if (((MMProcessBar)localObject).getVisibility() == 0)
    {
      localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(2131307118);
      p.g(localObject, "rl_layout");
      if (((RefreshLoadMoreLayout)localObject).getVisibility() != 0)
      {
        localObject = (MMProcessBar)_$_findCachedViewById(2131303691);
        p.g(localObject, "loadingIcon");
        ((MMProcessBar)localObject).setVisibility(8);
        localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(2131307118);
        p.g(localObject, "rl_layout");
        ((RefreshLoadMoreLayout)localObject).setVisibility(0);
      }
    }
    if (paramList.size() < 15) {
      ((RefreshLoadMoreLayout)_$_findCachedViewById(2131307118)).setEnableLoadMore(false);
    }
    AppMethodBeat.o(252199);
  }
  
  public final void dT(List<c> paramList)
  {
    AppMethodBeat.i(252200);
    p.h(paramList, "data");
    Object localObject = RefreshLoadMoreLayout.c.Rms;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.hfU());
    ((RefreshLoadMoreLayout.c)localObject).jLE = false;
    if (!((Collection)paramList).isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      ((RefreshLoadMoreLayout.c)localObject).Rmj = bool;
      ((RefreshLoadMoreLayout.c)localObject).Rmk = paramList.size();
      this.vHP.dR(paramList);
      ((RefreshLoadMoreLayout)_$_findCachedViewById(2131307118)).onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(252200);
      return;
    }
  }
  
  public final void dn(Object paramObject)
  {
    AppMethodBeat.i(252203);
    int i;
    if ((paramObject instanceof String))
    {
      if (((CharSequence)paramObject).length() <= 0) {
        break label200;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = this.vHP.ppH;
        if (localObject1 == null) {
          break label220;
        }
        Iterator localIterator = ((Iterable)localObject1).iterator();
        label54:
        if (!localIterator.hasNext()) {
          break label215;
        }
        Object localObject2 = localIterator.next();
        c localc = (c)localObject2;
        localObject1 = localc.contact;
        if (localObject1 == null) {
          break label205;
        }
        localObject1 = ((as)localObject1).getUsername();
        label95:
        if ((!p.j(localObject1, paramObject)) && (!p.j(localc.field_talker, paramObject))) {
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
    for (Object localObject1 = (c)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        Log.i("Finder.FinderConversationParentUI", "[onContactStorageChange] username=".concat(String.valueOf(paramObject)));
        paramObject = this.vHP;
        p.h(localObject1, "conv");
        ((c)localObject1).prepare();
        i = paramObject.ppH.indexOf(localObject1);
        if ((i >= 0) && (i < paramObject.ppH.size())) {
          paramObject.Il(i);
        }
      }
      AppMethodBeat.o(252203);
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
  
  public final f dyY()
  {
    AppMethodBeat.i(252193);
    f localf = this.vHN;
    if (localf == null) {
      p.btv("dataSource");
    }
    AppMethodBeat.o(252193);
    return localf;
  }
  
  public void dyZ() {}
  
  public int dzb()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(252194);
    super.onBackPressed();
    AppMethodBeat.o(252194);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(252204);
    super.onDestroy();
    ((m)g.af(m.class)).l(this.vHR);
    ((n)g.af(n.class)).l(this.vHQ);
    Object localObject = com.tencent.mm.plugin.finder.report.d.vdp;
    localObject = FinderReporterUIC.wzC;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = FinderReporterUIC.a.fH((Context)localObject);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.d.c((bbn)localObject);
      AppMethodBeat.o(252204);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(252196);
    super.onResume();
    com.tencent.mm.plugin.finder.conv.b localb = this.vHO;
    if (localb != null)
    {
      com.tencent.mm.ac.d.a(200L, (Runnable)localb);
      this.vHO = null;
    }
    dza();
    AppMethodBeat.o(252196);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$conversationAdapter$1$2"})
  static final class a
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.finder.conv.b, x>
  {
    a(FinderConversationParentUI paramFinderConversationParentUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI$Companion;", "", "()V", "DEFAULT_DURATION", "", "KEY_CONV_SCENE", "", "KEY_CONV_TYPE", "MENU_ID_MORE", "", "PAGE_COUNT", "PAGE_INITIAL_COUNT", "PREFETCH_DISTANCE", "REPORT_EXPOSE_SCROLL_LIMIT", "REQUEST_CODE_BLACK_SESSION", "TAG", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final c vHV;
    
    static
    {
      AppMethodBeat.i(252180);
      vHV = new c();
      AppMethodBeat.o(252180);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "kotlin.jvm.PlatformType", "obj", "", "onNotifyChange"})
  static final class d
    implements MStorageEx.IOnStorageChange
  {
    d(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
    {
      AppMethodBeat.i(252181);
      Log.i("Finder.FinderConversationParentUI", "[onContactStorageChange]");
      this.vHU.dn(paramObject);
      AppMethodBeat.o(252181);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class e
    implements MStorage.IOnStorageChange
  {
    e(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void onNotifyChange(String paramString, final MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(252183);
      if ((paramMStorageEventData.obj instanceof c))
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversation");
          AppMethodBeat.o(252183);
          throw paramString;
        }
        paramString = (c)paramString;
        if (paramString.field_scene != this.vHU.vHM)
        {
          Log.i("Finder.FinderConversationParentUI", "conv.field_scene:" + paramString.field_scene + " != conveScene:" + this.vHU.vHM);
          AppMethodBeat.o(252183);
          return;
        }
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(paramMStorageEventData) {});
      }
      AppMethodBeat.o(252183);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$2$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    f(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(252184);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(252184);
        return;
        FinderConversationParentUI.a(this.vHU);
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(252185);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(252185);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252186);
      this.vHU.finish();
      AppMethodBeat.o(252186);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class h
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(252187);
      FinderConversationParentUI.a(this.vHU);
      Object localObject = (RecyclerView)this.vHU._$_findCachedViewById(2131299243);
      p.g(localObject, "conversationRecyclerView");
      localObject = ((RecyclerView)localObject).getViewTreeObserver();
      if (localObject != null)
      {
        ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        AppMethodBeat.o(252187);
        return;
      }
      AppMethodBeat.o(252187);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(252189);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(252189);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(252191);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(252191);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(252188);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      f localf = this.vHU.dyY();
      int i = this.vHU.vHP.ppH.size();
      com.tencent.mm.plugin.finder.storage.e locale = localf.tyE;
      Object localObject;
      if (localf.type == 1) {
        if (localf.scene == 2)
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
        localObject = locale.a(i, 60, (int[])localObject, localf.scene);
        localf.tyF.dT((List)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(252188);
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
      AppMethodBeat.i(252190);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(252190);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "obj", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class j
    implements MStorage.IOnStorageChange
  {
    j(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(252192);
      Log.i("Finder.FinderConversationParentUI", "[onFinderContactStorageChange]");
      this.vHU.dn(paramMStorageEventData.obj);
      AppMethodBeat.o(252192);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
 * JD-Core Version:    0.7.0.1
 */