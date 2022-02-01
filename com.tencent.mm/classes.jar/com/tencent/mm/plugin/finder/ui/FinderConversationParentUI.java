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
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "Lcom/tencent/mm/plugin/finder/ui/ReadyChattingCompatUI;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource$onQueryBackListener;", "()V", "animRunnable", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "convScene", "", "getConvScene", "()I", "setConvScene", "(I)V", "convType", "getConvType", "setConvType", "conversationAdapter", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "getConversationAdapter", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "dataSource", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;", "setDataSource", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversationDataSource;)V", "onContactStorageChange", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "onConversationStorageChange", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onFinderContactStorageChange", "checkEmpty", "", "doSomethingOnConvDel", "getLayoutId", "getTitleResId", "loadAfter", "data", "", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "loadInitial", "modifyChange", "obj", "", "onChattingUIEnter", "onChattingUIExit", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "source", "onCreateAfter", "onDestroy", "onResume", "refreshAll", "reportChatExpose", "updateActionBar", "scene", "Companion", "plugin-finder_release"})
public class FinderConversationParentUI
  extends ReadyChattingCompatUI
  implements f.b
{
  public static final FinderConversationParentUI.b sMd;
  private HashMap _$_findViewCache;
  int sLV;
  int sLW;
  public com.tencent.mm.plugin.finder.conv.f sLX;
  private com.tencent.mm.plugin.finder.conv.b sLY;
  final com.tencent.mm.plugin.finder.conv.d sLZ;
  private final k.a sMa;
  private final k.a sMb;
  private final n.b sMc;
  
  static
  {
    AppMethodBeat.i(204525);
    sMd = new FinderConversationParentUI.b((byte)0);
    AppMethodBeat.o(204525);
  }
  
  public FinderConversationParentUI()
  {
    AppMethodBeat.i(204524);
    this.sLV = -1;
    this.sLW = -1;
    com.tencent.mm.plugin.finder.conv.d locald = new com.tencent.mm.plugin.finder.conv.d();
    Object localObject = (d.b)new com.tencent.mm.plugin.finder.conv.g((d.g.a.a)FinderConversationParentUI.c.sMf);
    p.h(localObject, "listener");
    locald.rTE = ((d.b)localObject);
    localObject = (d.a)new e((ReadyChattingCompatUI)this, (d.g.a.b)new a(this));
    p.h(localObject, "listener");
    locald.rTD = ((d.a)localObject);
    this.sLZ = locald;
    this.sMa = ((k.a)new e(this));
    this.sMb = ((k.a)new j(this));
    this.sMc = ((n.b)new d(this));
    AppMethodBeat.o(204524);
  }
  
  private final void cMc()
  {
    AppMethodBeat.i(204514);
    Object localObject = findViewById(2131299472);
    if (localObject != null)
    {
      if (this.sLZ.getItemCount() == 0)
      {
        ((View)localObject).setVisibility(0);
        localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(2131304203);
        p.g(localObject, "rl_layout");
        ((RefreshLoadMoreLayout)localObject).setVisibility(8);
        AppMethodBeat.o(204514);
        return;
      }
      ((View)localObject).setVisibility(8);
      localObject = (RefreshLoadMoreLayout)_$_findCachedViewById(2131304203);
      p.g(localObject, "rl_layout");
      ((RefreshLoadMoreLayout)localObject).setVisibility(0);
      AppMethodBeat.o(204514);
      return;
    }
    AppMethodBeat.o(204514);
  }
  
  public final void ZI()
  {
    AppMethodBeat.i(204517);
    super.ZI();
    setMMTitle(cMd());
    AppMethodBeat.o(204517);
  }
  
  public final void ZK()
  {
    AppMethodBeat.i(204520);
    super.ZK();
    RecyclerView localRecyclerView = (RecyclerView)_$_findCachedViewById(2131308076);
    p.g(localRecyclerView, "conversationRecyclerView");
    localRecyclerView.setLayoutFrozen(true);
    AppMethodBeat.o(204520);
  }
  
  public boolean ZL()
  {
    AppMethodBeat.i(204521);
    super.ZL();
    RecyclerView localRecyclerView = (RecyclerView)_$_findCachedViewById(2131308076);
    p.g(localRecyclerView, "conversationRecyclerView");
    localRecyclerView.setLayoutFrozen(false);
    AppMethodBeat.o(204521);
    return true;
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204528);
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
    AppMethodBeat.o(204528);
    return localView1;
  }
  
  public final void a(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(204516);
    super.a(paramBundle, paramInt);
    paramBundle = this.sTw;
    if (paramBundle != null) {
      paramBundle.d(Boolean.TRUE);
    }
    this.sLV = getIntent().getIntExtra("KEY_TALKER_TYPE", -1);
    this.sLW = getIntent().getIntExtra("KEY_TALKER_SCENE", -1);
    this.sLZ.pageType = this.sLV;
    this.sLZ.scene = this.sLW;
    ae.i("Finder.FinderConversationParentUI", "[onCreate] scene==" + this.sLV);
    ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).m(this.sMa);
    ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).m(this.sMb);
    setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
    paramBundle = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getConversationStorage();
    Object localObject = (RecyclerView)_$_findCachedViewById(2131308076);
    p.g(localObject, "this");
    ((RecyclerView)localObject).getContext();
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.sLZ);
    ((RecyclerView)localObject).setItemAnimator(null);
    ((RecyclerView)localObject).a((RecyclerView.m)new f(this));
    localObject = (RecyclerView)_$_findCachedViewById(2131308076);
    p.g(localObject, "conversationRecyclerView");
    localObject = ((RecyclerView)localObject).getViewTreeObserver();
    if (localObject != null) {
      ((ViewTreeObserver)localObject).addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new h(this));
    }
    this.sLX = new com.tencent.mm.plugin.finder.conv.f(paramBundle, this.sLV, this.sLW, (f.b)this);
    localObject = this.sLX;
    if (localObject == null) {
      p.bdF("dataSource");
    }
    com.tencent.mm.plugin.finder.storage.d locald = ((com.tencent.mm.plugin.finder.conv.f)localObject).rTM;
    if (((com.tencent.mm.plugin.finder.conv.f)localObject).type == 1) {
      if (((com.tencent.mm.plugin.finder.conv.f)localObject).scene == 2)
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
      paramBundle = locald.a(0, 15, paramBundle, ((com.tencent.mm.plugin.finder.conv.f)localObject).scene);
      ((com.tencent.mm.plugin.finder.conv.f)localObject).rTN.dD(paramBundle);
      ((RefreshLoadMoreLayout)_$_findCachedViewById(2131304203)).setActionCallback((RefreshLoadMoreLayout.a)new i(this));
      if (this.sLW != 1) {
        break;
      }
      com.tencent.mm.plugin.report.service.g.yxI.n(1473L, 11L, 1L);
      AppMethodBeat.o(204516);
      return;
      paramBundle = new int[1];
      paramBundle[0] = 2;
      continue;
      paramBundle = new int[1];
      paramBundle[0] = 1;
    }
    if (this.sLW == 2)
    {
      if (this.sLV == 1)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(1473L, 12L, 1L);
        AppMethodBeat.o(204516);
        return;
      }
      if (this.sLV == 2) {
        com.tencent.mm.plugin.report.service.g.yxI.n(1473L, 13L, 1L);
      }
    }
    AppMethodBeat.o(204516);
  }
  
  public final com.tencent.mm.plugin.finder.conv.f cMa()
  {
    AppMethodBeat.i(204513);
    com.tencent.mm.plugin.finder.conv.f localf = this.sLX;
    if (localf == null) {
      p.bdF("dataSource");
    }
    AppMethodBeat.o(204513);
    return localf;
  }
  
  public void cMb() {}
  
  public int cMd()
  {
    return 0;
  }
  
  public final void dD(List<com.tencent.mm.plugin.finder.conv.c> paramList)
  {
    AppMethodBeat.i(204518);
    p.h(paramList, "data");
    this.sLZ.dC(paramList);
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
    AppMethodBeat.o(204518);
  }
  
  public final void dE(List<com.tencent.mm.plugin.finder.conv.c> paramList)
  {
    AppMethodBeat.i(204519);
    p.h(paramList, "data");
    Object localObject = RefreshLoadMoreLayout.c.LOa;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fUy());
    ((RefreshLoadMoreLayout.c)localObject).iOP = false;
    if (!((Collection)paramList).isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      ((RefreshLoadMoreLayout.c)localObject).LNT = bool;
      ((RefreshLoadMoreLayout.c)localObject).LNU = paramList.size();
      this.sLZ.dC(paramList);
      ((RefreshLoadMoreLayout)_$_findCachedViewById(2131304203)).d((RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(204519);
      return;
    }
  }
  
  public final void dd(Object paramObject)
  {
    AppMethodBeat.i(204522);
    int i;
    if ((paramObject instanceof String))
    {
      if (((CharSequence)paramObject).length() <= 0) {
        break label200;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = this.sLZ.oeJ;
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
        localObject1 = ((an)localObject1).getUsername();
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
        ae.i("Finder.FinderConversationParentUI", "[onContactStorageChange] username=".concat(String.valueOf(paramObject)));
        paramObject = this.sLZ;
        p.h(localObject1, "conv");
        ((com.tencent.mm.plugin.finder.conv.c)localObject1).prepare();
        i = paramObject.oeJ.indexOf(localObject1);
        if ((i >= 0) && (i < paramObject.oeJ.size())) {
          paramObject.cj(i);
        }
      }
      AppMethodBeat.o(204522);
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
    AppMethodBeat.i(204523);
    super.onDestroy();
    ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).l(this.sMb);
    ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).l(this.sMa);
    Object localObject = com.tencent.mm.plugin.finder.report.b.sxb;
    localObject = FinderReporterUIC.tnG;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = FinderReporterUIC.a.fc((Context)localObject);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).cQZ();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.b.b((arn)localObject);
      AppMethodBeat.o(204523);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(204515);
    super.onResume();
    com.tencent.mm.plugin.finder.conv.b localb = this.sLY;
    if (localb != null)
    {
      com.tencent.mm.ac.c.a(200L, (Runnable)localb);
      this.sLY = null;
    }
    cMc();
    AppMethodBeat.o(204515);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/conv/FinderConvItemUnselectedAnim;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$conversationAdapter$1$2"})
  static final class a
    extends q
    implements d.g.a.b<com.tencent.mm.plugin.finder.conv.b, z>
  {
    a(FinderConversationParentUI paramFinderConversationParentUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "event", "", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "kotlin.jvm.PlatformType", "obj", "", "onNotifyChange"})
  static final class d
    implements n.b
  {
    d(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void a(int paramInt, n paramn, Object paramObject)
    {
      AppMethodBeat.i(204501);
      ae.i("Finder.FinderConversationParentUI", "[onContactStorageChange]");
      this.sMe.dd(paramObject);
      AppMethodBeat.o(204501);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class e
    implements k.a
  {
    e(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void a(String paramString, final m paramm)
    {
      AppMethodBeat.i(204503);
      if ((paramm.obj instanceof com.tencent.mm.plugin.finder.conv.c))
      {
        paramString = paramm.obj;
        if (paramString == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.conv.FinderConversation");
          AppMethodBeat.o(204503);
          throw paramString;
        }
        paramString = (com.tencent.mm.plugin.finder.conv.c)paramString;
        if (paramString.field_scene != this.sMe.sLW)
        {
          ae.i("Finder.FinderConversationParentUI", "conv.field_scene:" + paramString.field_scene + " != conveScene:" + this.sMe.sLW);
          AppMethodBeat.o(204503);
          return;
        }
        com.tencent.mm.ac.c.h((d.g.a.a)new q(paramm) {});
      }
      AppMethodBeat.o(204503);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$2$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.m
  {
    f(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(204505);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(204505);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(204504);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(204504);
        return;
        FinderConversationParentUI.a(this.sMe);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(204506);
      this.sMe.finish();
      AppMethodBeat.o(204506);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class h
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(204507);
      FinderConversationParentUI.a(this.sMe);
      Object localObject = (RecyclerView)this.sMe._$_findCachedViewById(2131308076);
      p.g(localObject, "conversationRecyclerView");
      localObject = ((RecyclerView)localObject).getViewTreeObserver();
      if (localObject != null)
      {
        ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        AppMethodBeat.o(204507);
        return;
      }
      AppMethodBeat.o(204507);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(204509);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(204509);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(204511);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(204511);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(204510);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(204510);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(204508);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      com.tencent.mm.plugin.finder.conv.f localf = this.sMe.cMa();
      int i = this.sMe.sLZ.oeJ.size();
      com.tencent.mm.plugin.finder.storage.d locald = localf.rTM;
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
        localf.rTN.dE((List)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderConversationParentUI$onCreate$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(204508);
        return;
        localObject = new int[1];
        localObject[0] = 2;
        continue;
        localObject = new int[1];
        localObject[0] = 1;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "obj", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class j
    implements k.a
  {
    j(FinderConversationParentUI paramFinderConversationParentUI) {}
    
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(204512);
      ae.i("Finder.FinderConversationParentUI", "[onFinderContactStorageChange]");
      this.sMe.dd(paramm.obj);
      AppMethodBeat.o(204512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
 * JD-Core Version:    0.7.0.1
 */