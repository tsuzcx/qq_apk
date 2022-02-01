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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import d.g.a.m;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "FIRST_PAGE_FILE_NAME", "", "MENU_ID_ADD_BLACK_LIST", "", "TAG", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetFansScene", "", "getLayoutId", "initView", "jumpToProfile", "fansContact", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "anchor", "Landroid/view/View;", "updateTitle", "plugin-finder_release"})
public final class FinderFansListUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.i.a.k<amf>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private TextView gCu;
  private boolean hasMore;
  private ListView iWK;
  private com.tencent.mm.ui.widget.b.a nym;
  private final f rFJ;
  private final String rHo;
  private final com.tencent.mm.plugin.finder.storage.data.b rHp;
  private final int rHq;
  private com.tencent.mm.bw.b rpX;
  private final ArrayList<ajs> rpr;
  
  public FinderFansListUI()
  {
    AppMethodBeat.i(167257);
    this.TAG = "Finder.FinderFansListUI";
    this.rFJ = new f((Activity)this);
    this.rpr = new ArrayList();
    this.rHo = "fansList.fp";
    this.rHp = new com.tencent.mm.plugin.finder.storage.data.b(this.rHo);
    this.rHq = 1001;
    AppMethodBeat.o(167257);
  }
  
  private final void cBG()
  {
    AppMethodBeat.i(167254);
    aa localaa = new aa(this.rpX);
    com.tencent.mm.kernel.g.agi().b((n)localaa);
    AppMethodBeat.o(167254);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(167252);
    Object localObject = com.tencent.mm.kernel.g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    int i = ((e)localObject).agA().getInt(ah.a.GVn, 0);
    ac.i(this.TAG, "update title %s", new Object[] { Integer.valueOf(i) });
    setMMTitle(getString(2131759271, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.gCu;
      if (localObject == null) {
        d.g.b.k.aVY("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.gCu;
      if (localObject == null) {
        d.g.b.k.aVY("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131759209));
      AppMethodBeat.o(167252);
      return;
    }
    localObject = this.gCu;
    if (localObject == null) {
      d.g.b.k.aVY("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(167252);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203172);
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
    AppMethodBeat.o(203172);
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
    d.g.b.k.g(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.iWK = ((ListView)localObject);
    localObject = findViewById(2131299472);
    d.g.b.k.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.gCu = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.nym = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.iWK;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.rFJ);
    localObject = this.iWK;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.iWK;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
    this.rFJ.rFA = ((m)new c(this));
    AppMethodBeat.o(167251);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167250);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(3531, (com.tencent.mm.ak.g)this);
    initView();
    c.b(c.a(c.aid(), (d.g.a.b)new d(this)), (d.g.a.b)new e(this));
    cBG();
    AppMethodBeat.o(167250);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167255);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(3531, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(167255);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(167256);
    ac.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFansList");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      paramString = ((aa)paramn).rr.aBC();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListRequest");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      paramString = ((akj)paramString).rmJ;
      if ((d.g.b.k.g(this.rpX, paramString) ^ true))
      {
        ac.i(this.TAG, "not my buf, ignore!");
        AppMethodBeat.o(167256);
        return;
      }
      paramString = ((aa)paramn).rr.aBD();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      if (((akk)paramString).continueFlag != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.hasMore = bool;
        if (this.rpX == null)
        {
          this.rpr.clear();
          c.a(c.aid(), (d.g.a.b)new g(this, paramn));
        }
        paramString = ((aa)paramn).rr.aBD();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      this.rpX = ((akk)paramString).rmJ;
      c.g((d.g.a.a)new h(this, paramn));
    }
    AppMethodBeat.o(167256);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderFansListUI paramFinderFansListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167239);
      this.rHr.finish();
      AppMethodBeat.o(167239);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class b
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167240);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFansListUI.e(this.rHr))
        {
          FinderFansListUI.f(this.rHr);
          AppMethodBeat.o(167240);
          return;
        }
        if (FinderFansListUI.g(this.rHr).getFooterViewsCount() == 0) {
          FinderFansListUI.g(this.rHr).addFooterView(View.inflate((Context)this.rHr, 2131494060, null));
        }
      }
      AppMethodBeat.o(167240);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements m<View, Integer, y>
  {
    c(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<Void, LinkedList<ajs>>
  {
    d(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<LinkedList<ajs>, Object>
  {
    e(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(FinderFansListUI paramFinderFansListUI, aiz paramaiz, amf paramamf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "(Ljava/lang/Void;)Lkotlin/Unit;", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$onSceneEnd$1$1"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Void, y>
  {
    g(FinderFansListUI paramFinderFansListUI, n paramn)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(FinderFansListUI paramFinderFansListUI, n paramn)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class i
    implements View.OnCreateContextMenuListener
  {
    i(FinderFansListUI paramFinderFansListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167247);
      paramContextMenu.add(0, FinderFansListUI.h(this.rHr), 0, (CharSequence)this.rHr.getString(2131757736));
      AppMethodBeat.o(167247);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements n.d
  {
    j(FinderFansListUI paramFinderFansListUI, ajs paramajs) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167249);
      d.g.b.k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderFansListUI.h(this.rHr)) {
        h.d((Context)this.rHr, this.rHr.getString(2131759145), "", this.rHr.getString(2131757736), this.rHr.getString(2131755691), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(167248);
            paramAnonymousDialogInterface = (com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class);
            String str = this.rHt.rFO.EEs;
            d.g.b.k.g(str, "fansContact.fansId");
            paramAnonymousDialogInterface.a(str, true, (com.tencent.mm.plugin.i.a.k)this.rHt.rHr);
            AppMethodBeat.o(167248);
          }
        }, null);
      }
      AppMethodBeat.o(167249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFansListUI
 * JD-Core Version:    0.7.0.1
 */