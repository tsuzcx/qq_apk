package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.be;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_ID_UNSET_BLACK_LIST", "", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetBlackListScene", "", "getLayoutId", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "fansContact", "anchor", "Landroid/view/View;", "update", "plugin-finder_release"})
public final class FinderBlackListUI
  extends MMFinderUI
  implements i, ai<ayt>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private TextView hRM;
  private boolean hasMore;
  private ListView krb;
  private com.tencent.mm.ui.widget.b.a pqr;
  private b tsO;
  private final ArrayList<aqr> uae;
  private final a vHn;
  private final int vHo;
  
  public FinderBlackListUI()
  {
    AppMethodBeat.i(167154);
    this.TAG = "Finder.FinderBlackListUI";
    this.vHn = new a((Activity)this);
    this.uae = new ArrayList();
    this.vHo = 1001;
    AppMethodBeat.o(167154);
  }
  
  private final void dyU()
  {
    AppMethodBeat.i(167151);
    be localbe = new be(this.tsO);
    g.azz().b((com.tencent.mm.ak.q)localbe);
    AppMethodBeat.o(167151);
  }
  
  private final void update()
  {
    AppMethodBeat.i(167149);
    if (this.uae.isEmpty())
    {
      localTextView = this.hRM;
      if (localTextView == null) {
        p.btv("emptyTip");
      }
      localTextView.setVisibility(0);
      localTextView = this.hRM;
      if (localTextView == null) {
        p.btv("emptyTip");
      }
      localTextView.setText((CharSequence)getString(2131759559));
      AppMethodBeat.o(167149);
      return;
    }
    TextView localTextView = this.hRM;
    if (localTextView == null) {
      p.btv("emptyTip");
    }
    localTextView.setVisibility(8);
    AppMethodBeat.o(167149);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252135);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252135);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252134);
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
    AppMethodBeat.o(252134);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494228;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167148);
    setMMTitle(getString(2131760314));
    Object localObject = findViewById(2131299111);
    p.g(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.krb = ((ListView)localObject);
    localObject = findViewById(2131300101);
    p.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.hRM = ((TextView)localObject);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
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
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
    this.vHn.uAi = ((m)new c(this));
    update();
    AppMethodBeat.o(167148);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167147);
    super.onCreate(paramBundle);
    g.azz().a(3717, (i)this);
    initView();
    dyU();
    AppMethodBeat.o(167147);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167152);
    super.onDestroy();
    g.azz().b(3717, (i)this);
    AppMethodBeat.o(167152);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(167153);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetBlackList");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      paramString = ((be)paramq).rr.aYK();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      if (((aro)paramString).continueFlag != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.hasMore = bool;
        paramString = ((be)paramq).rr.aYK();
        if (paramString != null) {
          break;
        }
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      this.tsO = ((aro)paramString).tVM;
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new e(this, paramq));
    }
    AppMethodBeat.o(167153);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167140);
      this.vHp.finish();
      AppMethodBeat.o(167140);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderBlackListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class b
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167141);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderBlackListUI.a(this.vHp))
        {
          FinderBlackListUI.b(this.vHp);
          AppMethodBeat.o(167141);
          return;
        }
        if (FinderBlackListUI.c(this.vHp).getFooterViewsCount() == 0) {
          FinderBlackListUI.c(this.vHp).addFooterView(View.inflate((Context)this.vHp, 2131494490, null));
        }
      }
      AppMethodBeat.o(167141);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements m<View, Integer, x>
  {
    c(FinderBlackListUI paramFinderBlackListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(FinderBlackListUI paramFinderBlackListUI, apg paramapg, ayt paramayt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(FinderBlackListUI paramFinderBlackListUI, com.tencent.mm.ak.q paramq)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class f
    implements View.OnCreateContextMenuListener
  {
    f(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167145);
      paramContextMenu.add(0, FinderBlackListUI.e(this.vHp), 0, (CharSequence)this.vHp.getString(2131757978));
      AppMethodBeat.o(167145);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements o.g
  {
    g(FinderBlackListUI paramFinderBlackListUI, aqr paramaqr) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167146);
      p.g(paramMenuItem, "menuItem");
      com.tencent.mm.plugin.i.a.t localt;
      if (paramMenuItem.getItemId() == FinderBlackListUI.e(this.vHp))
      {
        localt = (com.tencent.mm.plugin.i.a.t)g.af(com.tencent.mm.plugin.i.a.t.class);
        paramMenuItem = this.vHs.dMj;
        if (paramMenuItem != null) {
          break label72;
        }
        paramMenuItem = "";
      }
      label72:
      for (;;)
      {
        localt.b(paramMenuItem, false, (ai)this.vHp);
        AppMethodBeat.o(167146);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlackListUI
 * JD-Core Version:    0.7.0.1
 */