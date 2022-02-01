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
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.ad;
import com.tencent.mm.plugin.finder.cgi.y.a;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.search.h;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import d.a.j;
import d.g.b.k;
import d.g.b.v.a;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderFollowListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_UNFOLLOW", "", "TAG", "", "contactList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "emptyTip", "Landroid/widget/TextView;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/ContactListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetFollowScene", "", "getCommentScene", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "refreshTitle", "showPopupMenu", "finderContact", "anchor", "Landroid/view/View;", "Companion", "plugin-finder_release"})
public final class FinderFollowListUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g
{
  public static final a rHE;
  private static final String rHo = "followList.fp";
  private final String TAG;
  private HashMap _$_findViewCache;
  private TextView gCu;
  private boolean hasMore;
  private ListView iWK;
  private com.tencent.mm.ui.widget.b.a nym;
  private b rHB;
  private final LinkedList<com.tencent.mm.plugin.finder.api.f> rHC;
  private final com.tencent.mm.plugin.finder.storage.data.f rHD;
  private final int raj;
  private com.tencent.mm.bw.b rpX;
  
  static
  {
    AppMethodBeat.i(203195);
    rHE = new a((byte)0);
    rHo = "followList.fp";
    AppMethodBeat.o(203195);
  }
  
  public FinderFollowListUI()
  {
    AppMethodBeat.i(167282);
    this.TAG = "Finder.FinderFollowListUI";
    this.rHB = new b((Activity)this);
    this.rHC = new LinkedList();
    this.hasMore = true;
    this.rHD = new com.tencent.mm.plugin.finder.storage.data.f(rHo);
    this.raj = 1001;
    AppMethodBeat.o(167282);
  }
  
  private final void c(boolean paramBoolean, List<? extends FinderContact> paramList)
  {
    AppMethodBeat.i(167279);
    ac.i(this.TAG, "firstPage " + paramBoolean + ", get follow contact " + paramList.size());
    if (paramBoolean) {
      this.rHC.clear();
    }
    LinkedList localLinkedList = this.rHC;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(a.c((FinderContact)((Iterator)localObject).next()));
    }
    localLinkedList.addAll((Collection)paramList);
    this.rHB.dC((List)this.rHC);
    this.rHB.notifyDataSetChanged();
    AppMethodBeat.o(167279);
  }
  
  private final void cBI()
  {
    AppMethodBeat.i(167276);
    Object localObject = com.tencent.mm.kernel.g.agR();
    k.g(localObject, "MMKernel.storage()");
    int i = ((e)localObject).agA().getInt(ah.a.GVm, 0);
    setMMTitle(getResources().getString(2131759273, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.gCu;
      if (localObject == null) {
        k.aVY("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.gCu;
      if (localObject == null) {
        k.aVY("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131759229));
      AppMethodBeat.o(167276);
      return;
    }
    localObject = this.gCu;
    if (localObject == null) {
      k.aVY("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(167276);
  }
  
  private final void cBJ()
  {
    AppMethodBeat.i(167278);
    ad localad = new ad(this.rpX);
    com.tencent.mm.kernel.g.agi().b((n)localad);
    AppMethodBeat.o(167278);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203196);
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
    AppMethodBeat.o(203196);
    return localView1;
  }
  
  public final int cuI()
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
    this.iWK = ((ListView)localObject);
    localObject = findViewById(2131299472);
    k.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.gCu = ((TextView)localObject);
    cBI();
    localObject = this.iWK;
    if (localObject == null) {
      k.aVY("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.rHB);
    localObject = this.iWK;
    if (localObject == null) {
      k.aVY("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.iWK;
    if (localObject == null) {
      k.aVY("listView");
    }
    ((ListView)localObject).setOnItemClickListener((AdapterView.OnItemClickListener)new b(this));
    localObject = this.iWK;
    if (localObject == null) {
      k.aVY("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    this.nym = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.iWK;
    if (localObject == null) {
      k.aVY("listView");
    }
    ((ListView)localObject).setOnItemLongClickListener((AdapterView.OnItemLongClickListener)new d(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new e(this));
    AppMethodBeat.o(167275);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167274);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(713, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().a(3867, (com.tencent.mm.ak.g)this);
    initView();
    c.b(c.a(c.aid(), (d.g.a.b)new f(this)), (d.g.a.b)new g(this));
    cBJ();
    paramBundle = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.cyR()) {
      addIconOptionMenu(0, 2131690649, (MenuItem.OnMenuItemClickListener)new h(this));
    }
    AppMethodBeat.o(167274);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167280);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(713, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().b(3867, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(167280);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final n paramn)
  {
    com.tencent.mm.bw.b localb = null;
    AppMethodBeat.i(167281);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(" scene type ");
    if (paramn != null)
    {
      paramString = Integer.valueOf(paramn.getType());
      ac.i(str, paramString);
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
          paramString.KUL = false;
          if (paramn == null)
          {
            paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
            AppMethodBeat.o(167281);
            throw paramString;
          }
          localb = ((ad)paramn).csv();
          if ((k.g(this.rpX, localb) ^ true))
          {
            ac.i(this.TAG, "not my buf, ignore!");
            AppMethodBeat.o(167281);
            return;
          }
          if (this.rpX == null)
          {
            cBI();
            paramString.KUL = true;
            c.a(c.aid(), (d.g.a.b)new i(this, paramString, paramn));
          }
          this.hasMore = ((ad)paramn).css();
          this.rpX = ((ad)paramn).csq();
          c(paramString.KUL, (List)((ad)paramn).csu());
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
      paramInt1 = ((com.tencent.mm.plugin.finder.cgi.y)paramn).opType;
      paramString = com.tencent.mm.plugin.finder.cgi.y.qXW;
      if (paramInt1 == com.tencent.mm.plugin.finder.cgi.y.cso())
      {
        j.a((List)this.rHC, (d.g.a.b)new j(paramn));
        this.rHB.dC((List)this.rHC);
        this.rHB.notifyDataSetChanged();
        paramString = com.tencent.mm.kernel.g.agR();
        k.g(paramString, "MMKernel.storage()");
        paramInt1 = paramString.agA().getInt(ah.a.GVm, 0);
        ac.i(this.TAG, "oldFollowCnt %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 > 0)
        {
          paramString = com.tencent.mm.kernel.g.agR();
          k.g(paramString, "MMKernel.storage()");
          paramString.agA().set(ah.a.GVm, Integer.valueOf(paramInt1 - 1));
        }
        cBI();
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderFollowListUI$Companion;", "", "()V", "FIRST_PAGE_FILE_NAME", "", "getFIRST_PAGE_FILE_NAME", "()Ljava/lang/String;", "transformToLocalContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "fcontact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "plugin-finder_release"})
  public static final class a
  {
    public static com.tencent.mm.plugin.finder.api.f c(FinderContact paramFinderContact)
    {
      AppMethodBeat.i(203194);
      k.h(paramFinderContact, "fcontact");
      com.tencent.mm.plugin.finder.api.f localf = new com.tencent.mm.plugin.finder.api.f();
      String str2 = paramFinderContact.username;
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localf.setUsername(str1);
      str2 = paramFinderContact.headUrl;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localf.adl(str1);
      str2 = paramFinderContact.nickname;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localf.qj(str1);
      localf.field_version = paramFinderContact.seq;
      str2 = paramFinderContact.signature;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localf.field_signature = str1;
      localf.field_follow_Flag = paramFinderContact.followFlag;
      str2 = paramFinderContact.nickname;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localf.field_pyInitial = com.tencent.mm.platformtools.f.Fw(str1);
      localf.field_followTime = paramFinderContact.followTime;
      str2 = paramFinderContact.coverImgUrl;
      str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localf.field_coverImg = str1;
      localf.field_spamStatus = paramFinderContact.spamStatus;
      localf.field_authInfo = paramFinderContact.authInfo;
      localf.field_extInfo = paramFinderContact.extInfo;
      AppMethodBeat.o(203194);
      return localf;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class b
    implements AdapterView.OnItemClickListener
  {
    b(FinderFollowListUI paramFinderFollowListUI) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(167263);
      if (paramInt < FinderFollowListUI.c(this.rHF).size())
      {
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("finder_username", ((com.tencent.mm.plugin.finder.api.f)FinderFollowListUI.c(this.rHF).get(paramInt)).getUsername());
        paramView = FinderReporterUIC.seQ;
        FinderReporterUIC.a.a((Context)this.rHF, paramAdapterView, 0L, 1, false, 64);
        paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)this.rHF, paramAdapterView);
        paramAdapterView = FinderReporterUIC.seQ;
        paramAdapterView = this.rHF.getContext();
        k.g(paramAdapterView, "context");
        paramAdapterView = FinderReporterUIC.a.eV((Context)paramAdapterView);
        if (paramAdapterView != null)
        {
          paramView = d.rxr;
          d.a(6, 0L, paramAdapterView.rfR, 1, ((com.tencent.mm.plugin.finder.api.f)FinderFollowListUI.c(this.rHF).get(paramInt)).getUsername());
          AppMethodBeat.o(167263);
          return;
        }
      }
      AppMethodBeat.o(167263);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderFollowListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167264);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFollowListUI.e(this.rHF))
        {
          FinderFollowListUI.f(this.rHF);
          AppMethodBeat.o(167264);
          return;
        }
        if (FinderFollowListUI.g(this.rHF).getFooterViewsCount() == 0) {
          FinderFollowListUI.g(this.rHF).addFooterView(View.inflate((Context)this.rHF, 2131494060, null));
        }
      }
      AppMethodBeat.o(167264);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class d
    implements AdapterView.OnItemLongClickListener
  {
    d(FinderFollowListUI paramFinderFollowListUI) {}
    
    public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(167265);
      if (!FinderFollowListUI.d(this.rHF).Ep(paramInt).getUsername().equals(u.axE()))
      {
        paramAdapterView = this.rHF;
        com.tencent.mm.plugin.finder.api.f localf = FinderFollowListUI.d(this.rHF).Ep(paramInt);
        k.g(paramView, "view");
        FinderFollowListUI.a(paramAdapterView, localf, paramView);
      }
      AppMethodBeat.o(167265);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(FinderFollowListUI paramFinderFollowListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167266);
      this.rHF.finish();
      AppMethodBeat.o(167266);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<Void, LinkedList<FinderContact>>
  {
    f(FinderFollowListUI paramFinderFollowListUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<LinkedList<FinderContact>, Object>
  {
    g(FinderFollowListUI paramFinderFollowListUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(FinderFollowListUI paramFinderFollowListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167269);
      paramMenuItem = h.rBC;
      h.a(null);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("request_type", 3);
      paramMenuItem.putExtra("need_history", false);
      Object localObject = com.tencent.mm.plugin.finder.utils.a.rOv;
      localObject = this.rHF.getContext();
      k.g(localObject, "context");
      com.tencent.mm.plugin.finder.utils.a.y((Context)localObject, paramMenuItem);
      AppMethodBeat.o(167269);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderFollowListUI$onSceneEnd$1$1"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<Void, d.y>
  {
    i(FinderFollowListUI paramFinderFollowListUI, v.a parama, n paramn)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.finder.api.f, Boolean>
  {
    j(n paramn)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class k
    implements View.OnCreateContextMenuListener
  {
    k(FinderFollowListUI paramFinderFollowListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167272);
      paramContextMenu.add(0, FinderFollowListUI.h(this.rHF), 0, (CharSequence)this.rHF.getString(2131759384));
      AppMethodBeat.o(167272);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements n.d
  {
    l(FinderFollowListUI paramFinderFollowListUI, com.tencent.mm.plugin.finder.api.f paramf) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167273);
      k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderFollowListUI.h(this.rHF))
      {
        paramMenuItem = com.tencent.mm.ui.component.a.IrY;
        paramMenuItem = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this.rHF).get(FinderReporterUIC.class)).cGb();
        paramMenuItem.seo = 12;
        Object localObject = t.ruU;
        localObject = this.rHI.getUsername();
        y.a locala = com.tencent.mm.plugin.finder.cgi.y.qXW;
        paramMenuItem = t.a(paramMenuItem, (String)localObject, com.tencent.mm.plugin.finder.cgi.y.cso());
        com.tencent.mm.kernel.g.agi().b((n)paramMenuItem);
      }
      AppMethodBeat.o(167273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFollowListUI
 * JD-Core Version:    0.7.0.1
 */