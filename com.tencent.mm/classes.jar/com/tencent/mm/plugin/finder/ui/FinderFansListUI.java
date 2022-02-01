package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "FIRST_PAGE_FILE_NAME", "", "TAG", "addBlackListListener", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "finderBottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetFansScene", "", "getLayoutId", "", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "fansId", "retCode", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "fansContact", "anchor", "Landroid/view/View;", "updateListAfterOp", "updateTitle", "plugin-finder_release"})
public final class FinderFansListUI
  extends MMFinderUI
  implements i, ai<ayt>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private TextView hRM;
  private boolean hasMore;
  private ListView krb;
  private com.tencent.mm.ui.widget.b.a pqr;
  private com.tencent.mm.bw.b tsO;
  private final String uWR;
  private final ArrayList<aqr> uae;
  private final a vHn;
  private final com.tencent.mm.plugin.finder.storage.data.b vJN;
  private final a vJO;
  private com.tencent.mm.plugin.finder.view.d vJo;
  
  public FinderFansListUI()
  {
    AppMethodBeat.i(167257);
    this.TAG = "Finder.FinderFansListUI";
    this.vHn = new a((Activity)this);
    this.uae = new ArrayList();
    this.uWR = "fansList.fp";
    this.vJN = new com.tencent.mm.plugin.finder.storage.data.b(this.uWR);
    this.vJO = new a(this);
    AppMethodBeat.o(167257);
  }
  
  private final void dJ(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(252319);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new h(this, paramInt, paramString));
    AppMethodBeat.o(252319);
  }
  
  private final void dea()
  {
    AppMethodBeat.i(167254);
    bg localbg = new bg(this.tsO);
    g.azz().b((com.tencent.mm.ak.q)localbg);
    AppMethodBeat.o(167254);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(167252);
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    int i = ((e)localObject).azQ().getInt(ar.a.OlC, 0);
    Log.i(this.TAG, "update title %s", new Object[] { Integer.valueOf(i) });
    setMMTitle(getString(2131760315, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.hRM;
      if (localObject == null) {
        p.btv("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.hRM;
      if (localObject == null) {
        p.btv("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131759702));
      AppMethodBeat.o(167252);
      return;
    }
    localObject = this.hRM;
    if (localObject == null) {
      p.btv("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    addIconOptionMenu(0, 2131690901, (MenuItem.OnMenuItemClickListener)new n(this));
    AppMethodBeat.o(167252);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252323);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252323);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252322);
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
    AppMethodBeat.o(252322);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494228;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167251);
    Object localObject = findViewById(2131299111);
    p.g(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.krb = ((ListView)localObject);
    localObject = findViewById(2131300101);
    p.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.hRM = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    this.pqr = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.vHn);
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    localObject = c.vCb;
    if (((Number)c.dtG().value()).intValue() > 0) {
      this.vHn.uAj = ((m)new d(this));
    }
    this.vHn.uAi = ((m)new e(this));
    AppMethodBeat.o(167251);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167250);
    super.onCreate(paramBundle);
    g.azz().a(3531, (i)this);
    initView();
    com.tencent.mm.ac.d.b(com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), (kotlin.g.a.b)new f(this)), (kotlin.g.a.b)new g(this));
    dea();
    EventCenter.instance.addListener((IListener)this.vJO);
    AppMethodBeat.o(167250);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167255);
    super.onDestroy();
    g.azz().b(3531, (i)this);
    EventCenter.instance.removeListener((IListener)this.vJO);
    AppMethodBeat.o(167255);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(167256);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFansList");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      paramString = ((bg)paramq).cYn();
      if ((p.j(this.tsO, paramString) ^ true))
      {
        Log.i(this.TAG, "not my buf, ignore!");
        AppMethodBeat.o(167256);
        return;
      }
      this.hasMore = ((bg)paramq).cYp();
      if (this.tsO == null)
      {
        this.uae.clear();
        com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), (kotlin.g.a.b)new i(this, paramq));
      }
      this.tsO = ((bg)paramq).cYm();
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new j(this, paramq));
    }
    AppMethodBeat.o(167256);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderAddUserToBlackListEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<hq>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFansListUI paramFinderFansListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167239);
      this.vJP.finish();
      AppMethodBeat.o(167239);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167240);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFansListUI.e(this.vJP))
        {
          FinderFansListUI.f(this.vJP);
          AppMethodBeat.o(167240);
          return;
        }
        if (FinderFansListUI.g(this.vJP).getFooterViewsCount() == 0) {
          FinderFansListUI.g(this.vJP).addFooterView(View.inflate((Context)this.vJP, 2131494247, null));
        }
      }
      AppMethodBeat.o(167240);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements m<View, Integer, x>
  {
    d(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements m<View, Integer, x>
  {
    e(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, LinkedList<aqr>>
  {
    f(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<LinkedList<aqr>, Object>
  {
    g(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(FinderFansListUI paramFinderFansListUI, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "(Ljava/lang/Void;)Lkotlin/Unit;", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$onSceneEnd$1$1"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, x>
  {
    i(FinderFansListUI paramFinderFansListUI, com.tencent.mm.ak.q paramq)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(FinderFansListUI paramFinderFansListUI, com.tencent.mm.ak.q paramq)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class k
    implements View.OnCreateContextMenuListener
  {
    k(FinderFansListUI paramFinderFansListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167247);
      paramContextMenu.add(0, 1001, 0, (CharSequence)this.vJP.getString(2131759661));
      AppMethodBeat.o(167247);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements o.g
  {
    l(FinderFansListUI paramFinderFansListUI, aqr paramaqr) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167249);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      do
      {
        AppMethodBeat.o(167249);
        return;
        paramMenuItem = this.vHs.dMj;
      } while (paramMenuItem == null);
      Object localObject = k.vfA;
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      k.b((Context)localObject, 8L, 3L);
      localObject = (o)g.af(o.class);
      p.g(paramMenuItem, "it");
      ((o)localObject).a(paramMenuItem, (ai)new a(this));
      AppMethodBeat.o(167249);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$showPopupMenu$2$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderRemoveFansSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class a
      implements ai<bbm>
    {
      a(FinderFansListUI.l paraml) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(FinderFansListUI paramFinderFansListUI, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(FinderFansListUI paramFinderFansListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252318);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.ai((Context)this.vJP, new Intent());
      AppMethodBeat.o(252318);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFansListUI
 * JD-Core Version:    0.7.0.1
 */