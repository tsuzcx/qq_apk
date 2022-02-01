package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.cgi.n.a;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import d.a.j;
import d.g.b.k;
import d.g.b.v.a;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderFollowListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_UNFOLLOW", "", "TAG", "", "contactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "emptyTip", "Landroid/widget/TextView;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/ContactListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetFollowScene", "", "getCommentScene", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refreshTitle", "showPopupMenu", "finderContact", "anchor", "Landroid/view/View;", "Companion", "plugin-finder_release"})
public final class FinderFollowListUI
  extends MMFinderUI
  implements com.tencent.mm.al.g
{
  public static final FinderFollowListUI.l KYt;
  private static final String qMj = "followList.fp";
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean hasMore;
  private ListView iwH;
  private com.tencent.mm.ui.widget.b.a mVN;
  private TextView qKU;
  private com.tencent.mm.bx.b qKW;
  private a qMp;
  private final LinkedList<f> qMq;
  private final d qMr;
  private final int qqA;
  
  static
  {
    AppMethodBeat.i(199225);
    KYt = new FinderFollowListUI.l((byte)0);
    qMj = "followList.fp";
    AppMethodBeat.o(199225);
  }
  
  public FinderFollowListUI()
  {
    AppMethodBeat.i(167282);
    this.TAG = "Finder.FinderFollowListUI";
    this.qMp = new a((Activity)this);
    this.qMq = new LinkedList();
    this.hasMore = true;
    this.qMr = new d(qMj);
    this.qqA = 1001;
    AppMethodBeat.o(167282);
  }
  
  private final void c(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(167279);
    ad.i(this.TAG, "firstPage " + paramBoolean + ", get follow contact " + paramList.size());
    if (paramBoolean) {
      this.qMq.clear();
    }
    LinkedList localLinkedList = this.qMq;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(FinderFollowListUI.l.c((FinderContact)((Iterator)localObject).next()));
    }
    localLinkedList.addAll((Collection)paramList);
    this.qMp.dB((List)this.qMq);
    this.qMp.notifyDataSetChanged();
    AppMethodBeat.o(167279);
  }
  
  private final void cra()
  {
    AppMethodBeat.i(167276);
    Object localObject = com.tencent.mm.kernel.g.afB();
    k.g(localObject, "MMKernel.storage()");
    int i = ((e)localObject).afk().getInt(ae.a.FwW, 0);
    setMMTitle(getResources().getString(2131759273, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.qKU;
      if (localObject == null) {
        k.aPZ("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.qKU;
      if (localObject == null) {
        k.aPZ("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131759229));
      AppMethodBeat.o(167276);
      return;
    }
    localObject = this.qKU;
    if (localObject == null) {
      k.aPZ("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(167276);
  }
  
  private final void crb()
  {
    AppMethodBeat.i(167278);
    com.tencent.mm.plugin.finder.cgi.q localq = new com.tencent.mm.plugin.finder.cgi.q(this.qKW);
    com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)localq);
    AppMethodBeat.o(167278);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199226);
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
    AppMethodBeat.o(199226);
    return localView1;
  }
  
  public final int getCommentScene()
  {
    return 12;
  }
  
  public final int getLayoutId()
  {
    return 2131494022;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167275);
    Object localObject = findViewById(2131298674);
    k.g(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.iwH = ((ListView)localObject);
    localObject = findViewById(2131299472);
    k.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.qKU = ((TextView)localObject);
    cra();
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.qMp);
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setOnItemClickListener((AdapterView.OnItemClickListener)new a(this));
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
    this.mVN = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setOnItemLongClickListener((AdapterView.OnItemLongClickListener)new c(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    AppMethodBeat.o(167275);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167274);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(713, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().a(3867, (com.tencent.mm.al.g)this);
    initView();
    c.b(c.a(c.agM(), (d.g.a.b)new e(this)), (d.g.a.b)new f(this));
    crb();
    paramBundle = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cpu()) {
      addIconOptionMenu(0, 2131690649, (MenuItem.OnMenuItemClickListener)new g(this));
    }
    AppMethodBeat.o(167274);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167280);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(713, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().b(3867, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(167280);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    com.tencent.mm.bx.b localb = null;
    AppMethodBeat.i(167281);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramn != null)
    {
      paramString = Integer.valueOf(paramn.getType());
      ad.i(str, paramString);
      paramString = localb;
      if (paramn != null) {
        paramString = Integer.valueOf(paramn.getType());
      }
      if (paramString != null) {
        break label122;
      }
    }
    for (;;)
    {
      if (paramString == null)
      {
        AppMethodBeat.o(167281);
        return;
        paramString = null;
        break;
        label122:
        if (paramString.intValue() == 713)
        {
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label490;
          }
          paramString = new v.a();
          paramString.Jhs = false;
          if (paramn == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
            AppMethodBeat.o(167281);
            throw paramString;
          }
          localb = ((com.tencent.mm.plugin.finder.cgi.q)paramn).fRY();
          if ((k.g(this.qKW, localb) ^ true))
          {
            ad.i(this.TAG, "not my buf, ignore!");
            AppMethodBeat.o(167281);
            return;
          }
          if (this.qKW == null)
          {
            cra();
            paramString.Jhs = true;
            c.a(c.agM(), (d.g.a.b)new h(this, paramString, paramn));
          }
          this.hasMore = ((com.tencent.mm.plugin.finder.cgi.q)paramn).fRW();
          this.qKW = ((com.tencent.mm.plugin.finder.cgi.q)paramn).ckJ();
          c(paramString.Jhs, (List)((com.tencent.mm.plugin.finder.cgi.q)paramn).ckI());
          AppMethodBeat.o(167281);
          return;
        }
      }
    }
    if ((paramString.intValue() == 3867) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderFollow");
        AppMethodBeat.o(167281);
        throw paramString;
      }
      paramInt1 = ((com.tencent.mm.plugin.finder.cgi.n)paramn).opType;
      paramString = com.tencent.mm.plugin.finder.cgi.n.qpg;
      if (paramInt1 == com.tencent.mm.plugin.finder.cgi.n.ckG())
      {
        j.a((List)this.qMq, (d.g.a.b)new i(paramn));
        this.qMp.dB((List)this.qMq);
        this.qMp.notifyDataSetChanged();
        paramString = com.tencent.mm.kernel.g.afB();
        k.g(paramString, "MMKernel.storage()");
        paramInt1 = paramString.afk().getInt(ae.a.FwW, 0);
        ad.i(this.TAG, "oldFollowCnt %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 > 0)
        {
          paramString = com.tencent.mm.kernel.g.afB();
          k.g(paramString, "MMKernel.storage()");
          paramString.afk().set(ae.a.FwW, Integer.valueOf(paramInt1 - 1));
        }
        cra();
      }
    }
    label490:
    AppMethodBeat.o(167281);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class a
    implements AdapterView.OnItemClickListener
  {
    a(FinderFollowListUI paramFinderFollowListUI) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(167263);
      if (paramInt < FinderFollowListUI.c(this.qMs).size())
      {
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("finder_username", ((f)FinderFollowListUI.c(this.qMs).get(paramInt)).getUsername());
        paramView = FinderReporterUIC.Ljl;
        FinderReporterUIC.a.a((Context)this.qMs, paramAdapterView, 0L, 1, false, 64);
        paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.qMs, paramAdapterView);
        paramAdapterView = FinderReporterUIC.Ljl;
        paramAdapterView = this.qMs.getContext();
        k.g(paramAdapterView, "context");
        paramAdapterView = FinderReporterUIC.a.lB((Context)paramAdapterView);
        if (paramAdapterView != null)
        {
          paramView = com.tencent.mm.plugin.finder.report.b.qFq;
          com.tencent.mm.plugin.finder.report.b.a(6, 0L, paramAdapterView.qqE, 1, ((f)FinderFollowListUI.c(this.qMs).get(paramInt)).getUsername());
          AppMethodBeat.o(167263);
          return;
        }
      }
      AppMethodBeat.o(167263);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderFollowListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class b
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167264);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFollowListUI.e(this.qMs))
        {
          FinderFollowListUI.f(this.qMs);
          AppMethodBeat.o(167264);
          return;
        }
        if (FinderFollowListUI.g(this.qMs).getFooterViewsCount() == 0) {
          FinderFollowListUI.g(this.qMs).addFooterView(View.inflate((Context)this.qMs, 2131494060, null));
        }
      }
      AppMethodBeat.o(167264);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class c
    implements AdapterView.OnItemLongClickListener
  {
    c(FinderFollowListUI paramFinderFollowListUI) {}
    
    public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(167265);
      if (!FinderFollowListUI.d(this.qMs).CW(paramInt).getUsername().equals(u.aqO()))
      {
        paramAdapterView = this.qMs;
        f localf = FinderFollowListUI.d(this.qMs).CW(paramInt);
        k.g(paramView, "view");
        FinderFollowListUI.a(paramAdapterView, localf, paramView);
      }
      AppMethodBeat.o(167265);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderFollowListUI paramFinderFollowListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167266);
      this.qMs.finish();
      AppMethodBeat.o(167266);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<Void, LinkedList<FinderContact>>
  {
    e(FinderFollowListUI paramFinderFollowListUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<LinkedList<FinderContact>, Object>
  {
    f(FinderFollowListUI paramFinderFollowListUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderFollowListUI paramFinderFollowListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167269);
      paramMenuItem = i.qIB;
      i.a(null);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("request_type", 3);
      paramMenuItem.putExtra("need_history", false);
      Object localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
      localObject = this.qMs.getContext();
      k.g(localObject, "context");
      com.tencent.mm.plugin.finder.utils.a.Y((Context)localObject, paramMenuItem);
      AppMethodBeat.o(167269);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderFollowListUI$onSceneEnd$1$1"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<Void, y>
  {
    h(FinderFollowListUI paramFinderFollowListUI, v.a parama, com.tencent.mm.al.n paramn)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<f, Boolean>
  {
    i(com.tencent.mm.al.n paramn)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class j
    implements View.OnCreateContextMenuListener
  {
    j(FinderFollowListUI paramFinderFollowListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167272);
      paramContextMenu.add(0, FinderFollowListUI.h(this.qMs), 0, (CharSequence)this.qMs.getString(2131759384));
      AppMethodBeat.o(167272);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class k
    implements n.d
  {
    k(FinderFollowListUI paramFinderFollowListUI, f paramf) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167273);
      k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderFollowListUI.h(this.qMs))
      {
        paramMenuItem = com.tencent.mm.ui.component.a.LCX;
        paramMenuItem = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this.qMs).get(FinderReporterUIC.class)).fXs();
        paramMenuItem.LiL = 12;
        Object localObject = o.qDF;
        localObject = this.qMv.getUsername();
        n.a locala = com.tencent.mm.plugin.finder.cgi.n.qpg;
        paramMenuItem = o.a(paramMenuItem, (String)localObject, com.tencent.mm.plugin.finder.cgi.n.ckG());
        com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)paramMenuItem);
      }
      AppMethodBeat.o(167273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFollowListUI
 * JD-Core Version:    0.7.0.1
 */