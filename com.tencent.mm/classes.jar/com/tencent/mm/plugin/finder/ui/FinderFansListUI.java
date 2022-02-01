package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.f.a.hy;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "FIRST_PAGE_FILE_NAME", "", "TAG", "addBlackListListener", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "finderBottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetFansScene", "", "getLayoutId", "", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "fansId", "retCode", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "fansContact", "anchor", "Landroid/view/View;", "updateListAfterOp", "updateTitle", "plugin-finder_release"})
public final class FinderFansListUI
  extends MMFinderUI
  implements i, aj<beo>
{
  private e Aan;
  private final a Aok;
  private final com.tencent.mm.plugin.finder.storage.data.b AqF;
  private final a AqG;
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean hasMore;
  private TextView kGj;
  private ListView niO;
  private com.tencent.mm.ui.widget.b.a szq;
  private final ArrayList<asn> xMG;
  private com.tencent.mm.cd.b xaw;
  private final String zNg;
  
  public FinderFansListUI()
  {
    AppMethodBeat.i(167257);
    this.TAG = "Finder.FinderFansListUI";
    this.Aok = new a((Activity)this);
    this.xMG = new ArrayList();
    this.zNg = "fansList.fp";
    this.AqF = new com.tencent.mm.plugin.finder.storage.data.b(this.zNg);
    this.AqG = new a(this);
    AppMethodBeat.o(167257);
  }
  
  private final void dvp()
  {
    AppMethodBeat.i(167254);
    bj localbj = new bj(this.xaw);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)localbj);
    AppMethodBeat.o(167254);
  }
  
  private final void eg(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(263873);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(this, paramInt, paramString));
    AppMethodBeat.o(263873);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(167252);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    int i = ((f)localObject).aHp().getInt(ar.a.VAx, 0);
    Log.i(this.TAG, "update title %s", new Object[] { Integer.valueOf(i) });
    setMMTitle(getString(b.j.finder_my_fans_contact_number, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.kGj;
      if (localObject == null) {
        p.bGy("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.kGj;
      if (localObject == null) {
        p.bGy("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)getString(b.j.finder_fans_contact_empty_tip));
      AppMethodBeat.o(167252);
      return;
    }
    localObject = this.kGj;
    if (localObject == null) {
      p.bGy("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    addIconOptionMenu(0, b.i.icons_outlined_search, (MenuItem.OnMenuItemClickListener)new n(this));
    AppMethodBeat.o(167252);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(263877);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(263877);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(263876);
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
    AppMethodBeat.o(263876);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_contact_sort_list_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167251);
    Object localObject = findViewById(b.f.contact_list);
    p.j(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.niO = ((ListView)localObject);
    localObject = findViewById(b.f.empty_tip);
    p.j(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.kGj = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    this.szq = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.Aok);
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dUP().aSr()).intValue() > 0) {
      this.Aok.yWH = ((m)new d(this));
    }
    this.Aok.yWG = ((m)new e(this));
    AppMethodBeat.o(167251);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167250);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(3531, (i)this);
    initView();
    com.tencent.mm.ae.d.b(com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (kotlin.g.a.b)new f(this)), (kotlin.g.a.b)new g(this));
    dvp();
    EventCenter.instance.addListener((IListener)this.AqG);
    AppMethodBeat.o(167250);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167255);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(3531, (i)this);
    EventCenter.instance.removeListener((IListener)this.AqG);
    AppMethodBeat.o(167255);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
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
      paramString = ((bj)paramq).dob();
      if ((p.h(this.xaw, paramString) ^ true))
      {
        Log.i(this.TAG, "not my buf, ignore!");
        AppMethodBeat.o(167256);
        return;
      }
      this.hasMore = ((bj)paramq).dod();
      if (this.xaw == null)
      {
        this.xMG.clear();
        com.tencent.mm.ae.d.a(com.tencent.mm.ae.d.aJa(), (kotlin.g.a.b)new i(this, paramq));
      }
      this.xaw = ((bj)paramq).doa();
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new j(this, paramq));
    }
    AppMethodBeat.o(167256);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderAddUserToBlackListEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<hy>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFansListUI paramFinderFansListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167239);
      this.AqH.finish();
      AppMethodBeat.o(167239);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167240);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFansListUI.e(this.AqH))
        {
          FinderFansListUI.f(this.AqH);
          AppMethodBeat.o(167240);
          return;
        }
        if (FinderFansListUI.g(this.AqH).getFooterViewsCount() == 0) {
          FinderFansListUI.g(this.AqH).addFooterView(View.inflate((Context)this.AqH, b.g.finder_fans_no_more_footer, null));
        }
      }
      AppMethodBeat.o(167240);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements m<View, Integer, x>
  {
    d(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements m<View, Integer, x>
  {
    e(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, LinkedList<asn>>
  {
    f(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<LinkedList<asn>, Object>
  {
    g(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(FinderFansListUI paramFinderFansListUI, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "(Ljava/lang/Void;)Lkotlin/Unit;", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$onSceneEnd$1$1"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Void, x>
  {
    i(FinderFansListUI paramFinderFansListUI, com.tencent.mm.an.q paramq)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(FinderFansListUI paramFinderFansListUI, com.tencent.mm.an.q paramq)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class k
    implements View.OnCreateContextMenuListener
  {
    k(FinderFansListUI paramFinderFansListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167247);
      paramContextMenu.add(0, 1001, 0, (CharSequence)this.AqH.getString(b.j.finder_del_fans));
      AppMethodBeat.o(167247);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements q.g
  {
    l(FinderFansListUI paramFinderFansListUI, asn paramasn) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167249);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      do
      {
        AppMethodBeat.o(167249);
        return;
        paramMenuItem = this.Aop.fFa;
      } while (paramMenuItem == null);
      Object localObject = n.zWF;
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      n.b((Context)localObject, 8L, 3L);
      localObject = (com.tencent.mm.plugin.finder.service.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.finder.service.h.class);
      p.j(paramMenuItem, "it");
      ((com.tencent.mm.plugin.finder.service.h)localObject).a(paramMenuItem, (aj)new a(this));
      AppMethodBeat.o(167249);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$showPopupMenu$2$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderRemoveFansSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class a
      implements aj<bic>
    {
      a(FinderFansListUI.l paraml) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(FinderFansListUI paramFinderFansListUI, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class n
    implements MenuItem.OnMenuItemClickListener
  {
    n(FinderFansListUI paramFinderFansListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(291652);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
      com.tencent.mm.plugin.finder.utils.a.ap((Context)this.AqH, new Intent());
      AppMethodBeat.o(291652);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFansListUI
 * JD-Core Version:    0.7.0.1
 */