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
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.z;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.n.d;
import d.g.a.m;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_ID_UNSET_BLACK_LIST", "", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetBlackListScene", "", "getLayoutId", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "fansContact", "anchor", "Landroid/view/View;", "update", "plugin-finder_release"})
public final class FinderBlackListUI
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
  private final int rFK;
  private com.tencent.mm.bw.b rpX;
  private final ArrayList<ajs> rpr;
  
  public FinderBlackListUI()
  {
    AppMethodBeat.i(167154);
    this.TAG = "Finder.FinderBlackListUI";
    this.rFJ = new f((Activity)this);
    this.rpr = new ArrayList();
    this.rFK = 1001;
    AppMethodBeat.o(167154);
  }
  
  private final void cBw()
  {
    AppMethodBeat.i(167151);
    z localz = new z(this.rpX);
    com.tencent.mm.kernel.g.agi().b((n)localz);
    AppMethodBeat.o(167151);
  }
  
  private final void update()
  {
    AppMethodBeat.i(167149);
    if (this.rpr.isEmpty())
    {
      localTextView = this.gCu;
      if (localTextView == null) {
        d.g.b.k.aVY("emptyTip");
      }
      localTextView.setVisibility(0);
      localTextView = this.gCu;
      if (localTextView == null) {
        d.g.b.k.aVY("emptyTip");
      }
      localTextView.setText((CharSequence)getString(2131759155));
      AppMethodBeat.o(167149);
      return;
    }
    TextView localTextView = this.gCu;
    if (localTextView == null) {
      d.g.b.k.aVY("emptyTip");
    }
    localTextView.setVisibility(8);
    AppMethodBeat.o(167149);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203092);
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
    AppMethodBeat.o(203092);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494022;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167148);
    setMMTitle(getString(2131759270));
    Object localObject = findViewById(2131298674);
    d.g.b.k.g(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.iWK = ((ListView)localObject);
    localObject = findViewById(2131299472);
    d.g.b.k.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.gCu = ((TextView)localObject);
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
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
    this.rFJ.rFA = ((m)new c(this));
    update();
    AppMethodBeat.o(167148);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167147);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(3717, (com.tencent.mm.ak.g)this);
    initView();
    cBw();
    AppMethodBeat.o(167147);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167152);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(3717, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(167152);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(167153);
    ac.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetBlackList");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      paramString = ((z)paramn).rr.aBD();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      if (((akg)paramString).continueFlag != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.hasMore = bool;
        paramString = ((z)paramn).rr.aBD();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      this.rpX = ((akg)paramString).rmJ;
      c.g((d.g.a.a)new e(this, paramn));
    }
    AppMethodBeat.o(167153);
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
    a(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167140);
      this.rFL.finish();
      AppMethodBeat.o(167140);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/ui/FinderBlackListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class b
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167141);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderBlackListUI.a(this.rFL))
        {
          FinderBlackListUI.b(this.rFL);
          AppMethodBeat.o(167141);
          return;
        }
        if (FinderBlackListUI.c(this.rFL).getFooterViewsCount() == 0) {
          FinderBlackListUI.c(this.rFL).addFooterView(View.inflate((Context)this.rFL, 2131494060, null));
        }
      }
      AppMethodBeat.o(167141);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements m<View, Integer, y>
  {
    c(FinderBlackListUI paramFinderBlackListUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(FinderBlackListUI paramFinderBlackListUI, aiz paramaiz, amf paramamf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(FinderBlackListUI paramFinderBlackListUI, n paramn)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class f
    implements View.OnCreateContextMenuListener
  {
    f(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167145);
      paramContextMenu.add(0, FinderBlackListUI.e(this.rFL), 0, (CharSequence)this.rFL.getString(2131757741));
      AppMethodBeat.o(167145);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.d
  {
    g(FinderBlackListUI paramFinderBlackListUI, ajs paramajs) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167146);
      d.g.b.k.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderBlackListUI.e(this.rFL))
      {
        paramMenuItem = (com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class);
        String str = this.rFO.EEs;
        d.g.b.k.g(str, "fansContact.fansId");
        paramMenuItem.a(str, false, (com.tencent.mm.plugin.i.a.k)this.rFL);
      }
      AppMethodBeat.o(167146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlackListUI
 * JD-Core Version:    0.7.0.1
 */