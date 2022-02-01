package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.bv;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.aj.b;
import com.tencent.mm.plugin.finder.feed.aj.c;
import com.tencent.mm.plugin.finder.feed.aj.c.a;
import com.tencent.mm.plugin.finder.feed.aj.c.b;
import com.tencent.mm.plugin.finder.feed.aj.c.c;
import com.tencent.mm.plugin.finder.feed.aj.c.d;
import com.tencent.mm.plugin.finder.feed.aj.c.e;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiManageUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManagePresent;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManagePresent;", "presenter$delegate", "Lkotlin/Lazy;", "username", "", "getUsername", "()Ljava/lang/String;", "username$delegate", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback;", "viewCallback$delegate", "getCommentScene", "", "getLayoutId", "gotoPoiAdd", "", "handleIntent", "data", "Landroid/content/Intent;", "initView", "onActivityResult", "requestCode", "resultCode", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPoiManageUI
  extends MMFinderUI
{
  public static final a BqH;
  final j BlK;
  private final j Bqv;
  private final j Bqw;
  
  static
  {
    AppMethodBeat.i(364507);
    BqH = new a((byte)0);
    AppMethodBeat.o(364507);
  }
  
  public FinderPoiManageUI()
  {
    AppMethodBeat.i(364476);
    this.Bqv = k.cm((kotlin.g.a.a)new b(this));
    this.Bqw = k.cm((kotlin.g.a.a)new d(this));
    this.BlK = k.cm((kotlin.g.a.a)c.BqJ);
    AppMethodBeat.o(364476);
  }
  
  private static final boolean a(FinderPoiManageUI paramFinderPoiManageUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364492);
    kotlin.g.b.s.u(paramFinderPoiManageUI, "this$0");
    paramFinderPoiManageUI.finish();
    AppMethodBeat.o(364492);
    return true;
  }
  
  private static final boolean b(FinderPoiManageUI paramFinderPoiManageUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364499);
    kotlin.g.b.s.u(paramFinderPoiManageUI, "this$0");
    paramMenuItem = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.h((Activity)paramFinderPoiManageUI, 12222);
    AppMethodBeat.o(364499);
    return true;
  }
  
  private aj.c efL()
  {
    AppMethodBeat.i(364484);
    aj.c localc = (aj.c)this.Bqw.getValue();
    AppMethodBeat.o(364484);
    return localc;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final aj.b efK()
  {
    AppMethodBeat.i(364546);
    aj.b localb = (aj.b)this.Bqv.getValue();
    AppMethodBeat.o(364546);
    return localb;
  }
  
  public final int getCommentScene()
  {
    return 126;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_poi_manage_layout;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(364566);
    setBackBtn(new FinderPoiManageUI..ExternalSyntheticLambda0(this));
    setMMTitle(getResources().getString(e.h.finder_poi));
    hideActionbarLine();
    addTextOptionMenu(10001, getResources().getString(e.h.finder_poi_add), getResources().getColor(e.b.BW_0_Alpha_0_9), new FinderPoiManageUI..ExternalSyntheticLambda1(this));
    efK().a(efL());
    aj.c localc = efL();
    int i = e.e.rl_layout;
    Object localObject1 = localc.AXG.findViewById(i);
    kotlin.g.b.s.s(localObject1, "activity.findViewById(id)");
    localc.ATx = ((RefreshLoadMoreLayout)localObject1);
    Object localObject3 = localc.ATx;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = null;
    }
    RecyclerView localRecyclerView = ((RefreshLoadMoreLayout)localObject1).getRecyclerView();
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localc.ALE = new WxRecyclerAdapter((g)new aj.c.a(), localc.AXH.pUj, true);
    localObject3 = localc.ALE;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("adapter");
      localObject1 = null;
    }
    localRecyclerView.setAdapter((RecyclerView.a)localObject1);
    localObject1 = localc.ALE;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("adapter");
      localObject1 = null;
      ((i)localObject1).agOe = ((i.c)new aj.c.b());
      localObject1 = localc.ALE;
      if (localObject1 != null) {
        break label371;
      }
      kotlin.g.b.s.bIx("adapter");
      localObject1 = null;
      label274:
      ((i)localObject1).agOd = ((i.d)new aj.c.c(localc));
      localObject1 = localc.ATx;
      if (localObject1 != null) {
        break label374;
      }
      kotlin.g.b.s.bIx("rlLayout");
      localObject1 = localObject2;
    }
    label371:
    label374:
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.b)new aj.c.d(localc));
      localc.vEV = new com.tencent.mm.ui.widget.b.a((Context)localc.AXG);
      d.a(d.bbX(), (b)new aj.c.e(localc));
      AppMethodBeat.o(364566);
      return;
      break;
      break label274;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(364581);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((paramInt1 == 12222) && (paramInt2 == -1))
    {
      if (paramIntent != null) {
        break label116;
      }
      paramIntent = null;
      localObject = (Collection)paramIntent;
      if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
        break label127;
      }
    }
    label116:
    label127:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        localObject = efK();
        kotlin.g.b.s.u(paramIntent, "poiList");
        paramIntent = new LinkedList((Collection)paramIntent);
        paramIntent = new bv(((aj.b)localObject).username, paramIntent);
        h.aZW().a((p)paramIntent, 0);
      }
      AppMethodBeat.o(364581);
      return;
      paramIntent = paramIntent.getStringArrayListExtra("extra_poi_list");
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364555);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(364555);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364572);
    super.onDestroy();
    efK().onDetach();
    AppMethodBeat.o(364572);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiManageUI$Companion;", "", "()V", "EXTRA_POI_LIST", "", "MENU_ID_ADD", "", "MENU_ID_POI_DELETE", "REQUEST_CODE_ADD_POI", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManagePresent;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<aj.b>
  {
    b(FinderPoiManageUI paramFinderPoiManageUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final c BqJ;
    
    static
    {
      AppMethodBeat.i(364749);
      BqJ = new c();
      AppMethodBeat.o(364749);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiManageUIContract$PoiManageViewCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<aj.c>
  {
    d(FinderPoiManageUI paramFinderPoiManageUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderPoiManageUI
 * JD-Core Version:    0.7.0.1
 */