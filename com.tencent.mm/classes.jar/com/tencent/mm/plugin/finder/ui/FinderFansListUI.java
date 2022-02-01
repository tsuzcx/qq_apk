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
import com.tencent.mm.ad.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.p;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import d.g.a.m;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "FIRST_PAGE_FILE_NAME", "", "MENU_ID_ADD_BLACK_LIST", "", "TAG", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetFansScene", "", "getLayoutId", "initView", "jumpToProfile", "fansContact", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "anchor", "Landroid/view/View;", "updateTitle", "plugin-finder_release"})
public final class FinderFansListUI
  extends MMFinderUI
  implements com.tencent.mm.al.g, i<ajw>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean hasMore;
  private ListView iwH;
  private com.tencent.mm.ui.widget.b.a mVN;
  private final ArrayList<aii> qHA;
  private TextView qKU;
  private final b qKV;
  private com.tencent.mm.bx.b qKW;
  private final String qMj;
  private final com.tencent.mm.plugin.finder.storage.data.a qMk;
  private final int qMl;
  
  public FinderFansListUI()
  {
    AppMethodBeat.i(167257);
    this.TAG = "Finder.FinderFansListUI";
    this.qKV = new b((Activity)this);
    this.qHA = new ArrayList();
    this.qMj = "fansList.fp";
    this.qMk = new com.tencent.mm.plugin.finder.storage.data.a(this.qMj);
    this.qMl = 1001;
    AppMethodBeat.o(167257);
  }
  
  private final void cqZ()
  {
    AppMethodBeat.i(167254);
    p localp = new p(this.qKW);
    com.tencent.mm.kernel.g.aeS().b((n)localp);
    AppMethodBeat.o(167254);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(167252);
    Object localObject = com.tencent.mm.kernel.g.afB();
    k.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).afk().getInt(ae.a.FwX, 0);
    ad.i(this.TAG, "update title %s", new Object[] { Integer.valueOf(i) });
    setMMTitle(getString(2131759271, new Object[] { Integer.valueOf(i) }));
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
      ((TextView)localObject).setText((CharSequence)getString(2131759209));
      AppMethodBeat.o(167252);
      return;
    }
    localObject = this.qKU;
    if (localObject == null) {
      k.aPZ("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(167252);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199202);
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
    AppMethodBeat.o(199202);
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
    k.g(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.iwH = ((ListView)localObject);
    localObject = findViewById(2131299472);
    k.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.qKU = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.mVN = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.qKV);
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
    this.qKV.qKM = ((m)new c(this));
    AppMethodBeat.o(167251);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167250);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(3531, (com.tencent.mm.al.g)this);
    initView();
    c.b(c.a(c.agM(), (d.g.a.b)new d(this)), (d.g.a.b)new e(this));
    cqZ();
    AppMethodBeat.o(167250);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167255);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(3531, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(167255);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(167256);
    ad.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFansList");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      paramString = ((p)paramn).rr.auL();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListRequest");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      paramString = ((aix)paramString).qHz;
      if ((k.g(this.qKW, paramString) ^ true))
      {
        ad.i(this.TAG, "not my buf, ignore!");
        AppMethodBeat.o(167256);
        return;
      }
      paramString = ((p)paramn).rr.auM();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      if (((aiy)paramString).continueFlag != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.hasMore = bool;
        if (this.qKW == null)
        {
          this.qHA.clear();
          c.a(c.agM(), (d.g.a.b)new g(this, paramn));
        }
        paramString = ((p)paramn).rr.auM();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      this.qKW = ((aiy)paramString).qHz;
      c.g((d.g.a.a)new h(this, paramn));
    }
    AppMethodBeat.o(167256);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderFansListUI paramFinderFansListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167239);
      this.qMm.finish();
      AppMethodBeat.o(167239);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class b
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167240);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFansListUI.e(this.qMm))
        {
          FinderFansListUI.f(this.qMm);
          AppMethodBeat.o(167240);
          return;
        }
        if (FinderFansListUI.g(this.qMm).getFooterViewsCount() == 0) {
          FinderFansListUI.g(this.qMm).addFooterView(View.inflate((Context)this.qMm, 2131494060, null));
        }
      }
      AppMethodBeat.o(167240);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements m<View, Integer, y>
  {
    c(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Void, LinkedList<aii>>
  {
    d(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<LinkedList<aii>, Object>
  {
    e(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(FinderFansListUI paramFinderFansListUI, ahw paramahw, ajw paramajw)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "(Ljava/lang/Void;)Lkotlin/Unit;", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$onSceneEnd$1$1"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Void, y>
  {
    g(FinderFansListUI paramFinderFansListUI, n paramn)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(FinderFansListUI paramFinderFansListUI, n paramn)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class i
    implements View.OnCreateContextMenuListener
  {
    i(FinderFansListUI paramFinderFansListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167247);
      paramContextMenu.add(0, FinderFansListUI.h(this.qMm), 0, (CharSequence)this.qMm.getString(2131757736));
      AppMethodBeat.o(167247);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements n.d
  {
    j(FinderFansListUI paramFinderFansListUI, aii paramaii) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167249);
      k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderFansListUI.h(this.qMm)) {
        h.d((Context)this.qMm, this.qMm.getString(2131759145), "", this.qMm.getString(2131757736), this.qMm.getString(2131755691), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(167248);
            paramAnonymousDialogInterface = (com.tencent.mm.plugin.i.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.e.class);
            String str = this.qMo.qLc.DkZ;
            k.g(str, "fansContact.fansId");
            paramAnonymousDialogInterface.a(str, true, (i)this.qMo.qMm);
            AppMethodBeat.o(167248);
          }
        }, null);
      }
      AppMethodBeat.o(167249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFansListUI
 * JD-Core Version:    0.7.0.1
 */