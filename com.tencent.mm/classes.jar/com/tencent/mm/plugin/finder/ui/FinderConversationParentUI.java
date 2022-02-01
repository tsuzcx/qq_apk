package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.d.a;
import com.tencent.mm.plugin.finder.conv.d.b;
import com.tencent.mm.plugin.finder.conv.e;
import com.tencent.mm.plugin.finder.conv.f.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.l;
import d.v;
import d.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "()V", "animRunnable", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "convScene", "", "getConvScene", "()I", "setConvScene", "(I)V", "convType", "getConvType", "setConvType", "conversationAdapter", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "getConversationAdapter", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "dataSource", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "setDataSource", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;)V", "onContactStorageChange", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "onConversationStorageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onFinderContactStorageChange", "checkEmpty", "", "doSomethingOnConvDel", "getLayoutId", "getTitleResId", "loadAfter", "data", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "loadInitial", "modifyChange", "obj", "", "onChattingUIEnter", "onChattingUIExit", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onDestroy", "onResume", "refreshAll", "reportChatExpose", "updateActionBar", "scene", "Companion", "plugin-finder_release"})
public class FinderConversationParentUI
  extends ReadyChattingCompatUI
  implements f.b
{
  public static final b sBd;
  private HashMap _$_findViewCache;
  int sAV;
  int sAW;
  public com.tencent.mm.plugin.finder.conv.f sAX;
  private com.tencent.mm.plugin.finder.conv.b sAY;
  final com.tencent.mm.plugin.finder.conv.d sAZ;
  private final k.a sBa;
  private final k.a sBb;
  private final n.b sBc;
  
  static
  {
    AppMethodBeat.i(203929);
    sBd = new b((byte)0);
    AppMethodBeat.o(203929);
  }
  
  public FinderConversationParentUI()
  {
    AppMethodBeat.i(203928);
    this.sAV = -1;
    this.sAW = -1;
    com.tencent.mm.plugin.finder.conv.d locald = new com.tencent.mm.plugin.finder.conv.d();
    Object localObject = (d.b)new com.tencent.mm.plugin.finder.conv.g((d.g.a.a)c.sBf);
    p.h(localObject, "listener");
    locald.rLq = ((d.b)localObject);
    localObject = (d.a)new e((ReadyChattingCompatUI)this, (d.g.a.b)new a(this));
    p.h(localObject, "listener");
    locald.rLp = ((d.a)localObject);
    this.sAZ = locald;
    this.sBa = ((k.a)new e(this));
    this.sBb = ((k.a)new j(this));
    this.sBc = ((n.b)new d(this));
    AppMethodBeat.o(203928);
  }
  
  private final void cJz()
  {
    AppMethodBeat.i(203919);
    Object localObject = findViewById(2131299472);
    if (localObject != null)
    {
      if (this.sAZ.getItemCount() == 0)
      {
        ((View)localObject).setVisibility(0);
        localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(2131304203);
        p.g(localObject, "rl_layout");
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
        AppMethodBeat.o(203919);
        return;
      }
      ((View)localObject).setVisibility(8);
      localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(2131304203);
      p.g(localObject, "rl_layout");
      ((RefreshLoadMoreLayout)localObject).setVisibility(0);
      AppMethodBeat.o(203919);
      return;
    }
    AppMethodBeat.o(203919);
  }
  
  public final void ZB()
  {
    AppMethodBeat.i(203924);
    super.ZB();
    RecyclerView localRecyclerView = (RecyclerView)_$_findCachedViewById(2131308076);
    p.g(localRecyclerView, "conversationRecyclerView");
    localRecyclerView.setLayoutFrozen(true);
    AppMethodBeat.o(203924);
  }
  
  public boolean ZC()
  {
    AppMethodBeat.i(203925);
    super.ZC();
    RecyclerView localRecyclerView = (RecyclerView)_$_findCachedViewById(2131308076);
    p.g(localRecyclerView, "conversationRecyclerView");
    localRecyclerView.setLayoutFrozen(false);
    AppMethodBeat.o(203925);
    return true;
  }
  
  public final void Zz()
  {
    AppMethodBeat.i(221547);
    super.Zz();
    setMMTitle(cJA());
    AppMethodBeat.o(221547);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203932);
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
    AppMethodBeat.o(203932);
    return localView1;
  }
  
  public final void a(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(203921);
    super.a(paramBundle, paramInt);
    paramBundle = this.sIk;
    if (paramBundle != null) {
      paramBundle.d(Boolean.TRUE);
    }
    this.sAV = getIntent().getIntExtra("KEY_TALKER_TYPE", -1);
    this.sAW = getIntent().getIntExtra("KEY_TALKER_SCENE", -1);
    this.sAZ.pageType = this.sAV;
    this.sAZ.scene = this.sAW;
    ad.i("Finder.FinderConversationParentUI", "[onCreate] scene==" + this.sAV);
    ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).m(this.sBa);
    ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).m(this.sBb);
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
    paramBundle = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage();
    Object localObject1 = (RecyclerView)_$_findCachedViewById(2131308076);
    p.g(localObject1, "this");
    ((RecyclerView)localObject1).getContext();
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.sAZ);
    ((RecyclerView)localObject1).setItemAnimator(null);
    Object localObject2 = new y.d();
    ((y.d)localObject2).MLT = 0;
    ((RecyclerView)localObject1).a((RecyclerView.m)new f((y.d)localObject2, this));
    localObject1 = (RecyclerView)_$_findCachedViewById(2131308076);
    p.g(localObject1, "conversationRecyclerView");
    localObject1 = ((RecyclerView)localObject1).getViewTreeObserver();
    if (localObject1 != null) {
      ((ViewTreeObserver)localObject1).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new h(this));
    }
    this.sAX = new com.tencent.mm.plugin.finder.conv.f(paramBundle, this.sAV, this.sAW, (f.b)this);
    localObject1 = this.sAX;
    if (localObject1 == null) {
      p.bcb("dataSource");
    }
    localObject2 = ((com.tencent.mm.plugin.finder.conv.f)localObject1).rLz;
    if (((com.tencent.mm.plugin.finder.conv.f)localObject1).type == 1) {
      if (((com.tencent.mm.plugin.finder.conv.f)localObject1).scene == 2)
      {
        paramBundle = new int[2];
        Bundle tmp362_361 = paramBundle;
        tmp362_361[0] = 2;
        Bundle tmp366_362 = tmp362_361;
        tmp366_362[1] = 100;
        tmp366_362;
      }
    }
    for (;;)
    {
      paramBundle = ((com.tencent.mm.plugin.finder.storage.d)localObject2).a(0, 15, paramBundle, ((com.tencent.mm.plugin.finder.conv.f)localObject1).scene);
      ((com.tencent.mm.plugin.finder.conv.f)localObject1).rLA.dA(paramBundle);
      ((RefreshLoadMoreLayout)_$_findCachedViewById(2131304203)).setActionCallback((RefreshLoadMoreLayout.a)new i(this));
      if (this.sAW != 1) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.yhR.n(1473L, 11L, 1L);
      AppMethodBeat.o(203921);
      return;
      paramBundle = new int[1];
      paramBundle[0] = 2;
      continue;
      paramBundle = new int[1];
      paramBundle[0] = 1;
    }
    if (this.sAW == 2)
    {
      if (this.sAV == 1)
      {
        com.tencent.mm.plugin.report.service.g.yhR.n(1473L, 12L, 1L);
        AppMethodBeat.o(203921);
        return;
      }
      if (this.sAV == 2) {
        com.tencent.mm.plugin.report.service.g.yhR.n(1473L, 13L, 1L);
      }
    }
    AppMethodBeat.o(203921);
  }
  
  public int cJA()
  {
    return 0;
  }
  
  public final com.tencent.mm.plugin.finder.conv.f cJx()
  {
    AppMethodBeat.i(203918);
    com.tencent.mm.plugin.finder.conv.f localf = this.sAX;
    if (localf == null) {
      p.bcb("dataSource");
    }
    AppMethodBeat.o(203918);
    return localf;
  }
  
  public void cJy() {}
  
  public final void dA(List<com.tencent.mm.plugin.finder.conv.c> paramList)
  {
    AppMethodBeat.i(203922);
    p.h(paramList, "data");
    this.sAZ.dz(paramList);
    paramList = (MMProcessBar)_$_findCachedViewById(2131308148);
    p.g(paramList, "loadingIcon");
    if (paramList.getVisibility() == 0)
    {
      paramList = (RefreshLoadMoreLayout)_$_findCachedViewById(2131304203);
      p.g(paramList, "rl_layout");
      if (paramList.getVisibility() != 0)
      {
        paramList = (MMProcessBar)_$_findCachedViewById(2131308148);
        p.g(paramList, "loadingIcon");
        paramList.setVisibility(8);
        paramList = (RefreshLoadMoreLayout)_$_findCachedViewById(2131304203);
        p.g(paramList, "rl_layout");
        paramList.setVisibility(0);
      }
    }
    AppMethodBeat.o(203922);
  }
  
  public final void dB(List<com.tencent.mm.plugin.finder.conv.c> paramList)
  {
    AppMethodBeat.i(203923);
    p.h(paramList, "data");
    Object localObject = RefreshLoadMoreLayout.c.Lrp;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fQc());
    ((RefreshLoadMoreLayout.c)localObject).iLW = false;
    if (!((Collection)paramList).isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      ((RefreshLoadMoreLayout.c)localObject).Lri = bool;
      ((RefreshLoadMoreLayout.c)localObject).Lrj = paramList.size();
      this.sAZ.dz(paramList);
      ((RefreshLoadMoreLayout)_$_findCachedViewById(2131304203)).d((RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(203923);
      return;
    }
  }
  
  public final void dc(Object paramObject)
  {
    AppMethodBeat.i(203926);
    int i;
    if ((paramObject instanceof String))
    {
      if (((CharSequence)paramObject).length() <= 0) {
        break label200;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = this.sAZ.nZa;
        if (localObject1 == null) {
          break label220;
        }
        Iterator localIterator = ((Iterable)localObject1).iterator();
        label54:
        if (!localIterator.hasNext()) {
          break label215;
        }
        Object localObject2 = localIterator.next();
        com.tencent.mm.plugin.finder.conv.c localc = (com.tencent.mm.plugin.finder.conv.c)localObject2;
        localObject1 = localc.contact;
        if (localObject1 == null) {
          break label205;
        }
        localObject1 = ((am)localObject1).getUsername();
        label95:
        if ((!p.i(localObject1, paramObject)) && (!p.i(localc.field_talker, paramObject))) {
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
    for (Object localObject1 = (com.tencent.mm.plugin.finder.conv.c)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        ad.i("Finder.FinderConversationParentUI", "[onContactStorageChange] username=".concat(String.valueOf(paramObject)));
        paramObject = this.sAZ;
        p.h(localObject1, "conv");
        ((com.tencent.mm.plugin.finder.conv.c)localObject1).prepare();
        i = paramObject.nZa.indexOf(localObject1);
        if ((i >= 0) && (i < paramObject.nZa.size())) {
          paramObject.cj(i);
        }
      }
      AppMethodBeat.o(203926);
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
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(203927);
    super.onDestroy();
    ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).l(this.sBb);
    ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).l(this.sBa);
    Object localObject = com.tencent.mm.plugin.finder.report.b.snk;
    localObject = FinderReporterUIC.tcM;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = FinderReporterUIC.a.eY((Context)localObject);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).cOu();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.b.b((aqy)localObject);
      AppMethodBeat.o(203927);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(203920);
    super.onResume();
    com.tencent.mm.plugin.finder.conv.b localb = this.sAY;
    if (localb != null)
    {
      com.tencent.mm.ad.c.a(200L, (Runnable)localb);
      this.sAY = null;
    }
    cJz();
    AppMethodBeat.o(203920);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$conversationAdapter$1$2"})
  static final class a
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.conv.b, z>
  {
    a(FinderConversationParentUI paramFinderConversationParentUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI$Companion;", "", "()V", "DEFAULT_DURATION", "", "KEY_CONV_SCENE", "", "KEY_CONV_TYPE", "MENU_ID_MORE", "", "PAGE_COUNT", "PAGE_INITIAL_COUNT", "PREFETCH_DISTANCE", "REPORT_EXPOSE_SCROLL_LIMIT", "REQUEST_CODE_BLACK_SESSION", "TAG", "plugin-finder_release"})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    public static final c sBf;
    
    static
    {
      AppMethodBeat.i(203905);
      sBf = new c();
      AppMethodBeat.o(203905);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "kotlin.jvm.PlatformType", "obj", "", "onNotifyChange"})
  static final class d
    implements n.b
  {
    d(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void a(int paramInt, n paramn, Object paramObject)
    {
      AppMethodBeat.i(203906);
      ad.i("Finder.FinderConversationParentUI", "[onContactStorageChange]");
      this.sBe.dc(paramObject);
      AppMethodBeat.o(203906);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class e
    implements k.a
  {
    e(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void a(String paramString, final m paramm)
    {
      AppMethodBeat.i(203908);
      if ((paramm.obj instanceof com.tencent.mm.plugin.finder.conv.c))
      {
        paramString = paramm.obj;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversation");
          AppMethodBeat.o(203908);
          throw paramString;
        }
        paramString = (com.tencent.mm.plugin.finder.conv.c)paramString;
        if (paramString.field_scene != this.sBe.sAW)
        {
          ad.i("Finder.FinderConversationParentUI", "conv.field_scene:" + paramString.field_scene + " != conveScene:" + this.sBe.sAW);
          AppMethodBeat.o(203908);
          return;
        }
        com.tencent.mm.ad.c.g((d.g.a.a)new q(paramm) {});
      }
      AppMethodBeat.o(203908);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$2$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.m
  {
    f(y.d paramd, FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(203910);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(203910);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(203909);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(203909);
        return;
        FinderConversationParentUI.a(jdField_this);
        this.sBh.MLT = 0;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203911);
      this.sBe.finish();
      AppMethodBeat.o(203911);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class h
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(203912);
      FinderConversationParentUI.a(this.sBe);
      Object localObject = (RecyclerView)this.sBe._$_findCachedViewById(2131308076);
      p.g(localObject, "conversationRecyclerView");
      localObject = ((RecyclerView)localObject).getViewTreeObserver();
      if (localObject != null)
      {
        ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        AppMethodBeat.o(203912);
        return;
      }
      AppMethodBeat.o(203912);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(203914);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(203914);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203916);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203916);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203915);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203915);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(203913);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      com.tencent.mm.plugin.finder.conv.f localf = this.sBe.cJx();
      int i = this.sBe.sAZ.nZa.size();
      com.tencent.mm.plugin.finder.storage.d locald = localf.rLz;
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
        localObject = locald.a(i, 60, (int[])localObject, localf.scene);
        localf.rLA.dB((List)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(203913);
        return;
        localObject = new int[1];
        localObject[0] = 2;
        continue;
        localObject = new int[1];
        localObject[0] = 1;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "obj", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class j
    implements k.a
  {
    j(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(203917);
      ad.i("Finder.FinderConversationParentUI", "[onFinderContactStorageChange]");
      this.sBe.dc(paramm.obj);
      AppMethodBeat.o(203917);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
 * JD-Core Version:    0.7.0.1
 */