package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ai;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "FIRST_PAGE_FILE_NAME", "", "MENU_ID_ADD_BLACK_LIST", "", "TAG", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetFansScene", "", "getLayoutId", "initView", "jumpToProfile", "fansContact", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "anchor", "Landroid/view/View;", "updateTitle", "plugin-finder_release"})
public final class FinderFansListUI
  extends MMFinderUI
  implements f, s<apy>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private TextView gYR;
  private boolean hasMore;
  private ListView jsM;
  private com.tencent.mm.ui.widget.b.a ofu;
  private com.tencent.mm.bw.b rPQ;
  private final a sLI;
  private final String sNs;
  private final com.tencent.mm.plugin.finder.storage.data.b sNt;
  private final int sNu;
  private final ArrayList<anb> smS;
  
  public FinderFansListUI()
  {
    AppMethodBeat.i(167257);
    this.TAG = "Finder.FinderFansListUI";
    this.sLI = new a((Activity)this);
    this.smS = new ArrayList();
    this.sNs = "fansList.fp";
    this.sNt = new com.tencent.mm.plugin.finder.storage.data.b(this.sNs);
    this.sNu = 1001;
    AppMethodBeat.o(167257);
  }
  
  private final void cMm()
  {
    AppMethodBeat.i(167254);
    ai localai = new ai(this.rPQ);
    g.ajj().b((n)localai);
    AppMethodBeat.o(167254);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(167252);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    int i = ((e)localObject).ajA().getInt(am.a.Jcy, 0);
    ae.i(this.TAG, "update title %s", new Object[] { Integer.valueOf(i) });
    setMMTitle(getString(2131759271, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.gYR;
      if (localObject == null) {
        p.bdF("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.gYR;
      if (localObject == null) {
        p.bdF("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131759209));
      AppMethodBeat.o(167252);
      return;
    }
    localObject = this.gYR;
    if (localObject == null) {
      p.bdF("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(167252);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204555);
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
    AppMethodBeat.o(204555);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494022;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167251);
    Object localObject = findViewById(2131298674);
    p.g(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.jsM = ((ListView)localObject);
    localObject = findViewById(2131299472);
    p.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.gYR = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.ofu = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.jsM;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.sLI);
    localObject = this.jsM;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.jsM;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cJP().value()).intValue() > 0) {
      this.sLI.sLA = ((m)new c(this));
    }
    this.sLI.sLz = ((m)new d(this));
    AppMethodBeat.o(167251);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167250);
    super.onCreate(paramBundle);
    g.ajj().a(3531, (f)this);
    initView();
    c.b(c.a(c.ale(), (d.g.a.b)new e(this)), (d.g.a.b)new f(this));
    cMm();
    AppMethodBeat.o(167250);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167255);
    super.onDestroy();
    g.ajj().b(3531, (f)this);
    AppMethodBeat.o(167255);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(167256);
    ae.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFansList");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      paramString = ((ai)paramn).rr.aEU();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListRequest");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      paramString = ((anx)paramString).skw;
      if ((p.i(this.rPQ, paramString) ^ true))
      {
        ae.i(this.TAG, "not my buf, ignore!");
        AppMethodBeat.o(167256);
        return;
      }
      paramString = ((ai)paramn).rr.aEV();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      if (((any)paramString).continueFlag != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.hasMore = bool;
        if (this.rPQ == null)
        {
          this.smS.clear();
          c.a(c.ale(), (d.g.a.b)new h(this, paramn));
        }
        paramString = ((ai)paramn).rr.aEV();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      this.rPQ = ((any)paramString).skw;
      c.h((d.g.a.a)new i(this, paramn));
    }
    AppMethodBeat.o(167256);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderFansListUI paramFinderFansListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167239);
      this.sNv.finish();
      AppMethodBeat.o(167239);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class b
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167240);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFansListUI.e(this.sNv))
        {
          FinderFansListUI.f(this.sNv);
          AppMethodBeat.o(167240);
          return;
        }
        if (FinderFansListUI.g(this.sNv).getFooterViewsCount() == 0) {
          FinderFansListUI.g(this.sNv).addFooterView(View.inflate((Context)this.sNv, 2131496456, null));
        }
      }
      AppMethodBeat.o(167240);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements m<View, Integer, z>
  {
    c(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements m<View, Integer, z>
  {
    d(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<Void, LinkedList<anb>>
  {
    e(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<LinkedList<anb>, Object>
  {
    f(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    g(FinderFansListUI paramFinderFansListUI, amb paramamb, apy paramapy)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "(Ljava/lang/Void;)Lkotlin/Unit;", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$onSceneEnd$1$1"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<Void, z>
  {
    h(FinderFansListUI paramFinderFansListUI, n paramn)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    i(FinderFansListUI paramFinderFansListUI, n paramn)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class j
    implements View.OnCreateContextMenuListener
  {
    j(FinderFansListUI paramFinderFansListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167247);
      paramContextMenu.add(0, FinderFansListUI.h(this.sNv), 0, (CharSequence)this.sNv.getString(2131757736));
      AppMethodBeat.o(167247);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class k
    implements n.e
  {
    k(FinderFansListUI paramFinderFansListUI, anb paramanb) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167249);
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderFansListUI.h(this.sNv)) {
        h.e((Context)this.sNv, this.sNv.getString(2131759145), "", this.sNv.getString(2131757736), this.sNv.getString(2131755691), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(167248);
            j localj = (j)g.ab(j.class);
            paramAnonymousDialogInterface = this.sNw.sLN.GEH;
            if (paramAnonymousDialogInterface == null) {
              paramAnonymousDialogInterface = "";
            }
            for (;;)
            {
              localj.a(paramAnonymousDialogInterface, true, (s)this.sNw.sNv);
              AppMethodBeat.o(167248);
              return;
            }
          }
        }, null);
      }
      AppMethodBeat.o(167249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFansListUI
 * JD-Core Version:    0.7.0.1
 */