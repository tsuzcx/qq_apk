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
import com.tencent.mm.ad.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.n.e;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_ID_UNSET_BLACK_LIST", "", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetBlackListScene", "", "getLayoutId", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "fansContact", "anchor", "Landroid/view/View;", "update", "plugin-finder_release"})
public final class FinderBlackListUI
  extends MMFinderUI
  implements f, s<apl>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private TextView gWe;
  private boolean hasMore;
  private ListView jpT;
  private com.tencent.mm.ui.widget.b.a nZK;
  private com.tencent.mm.bx.b rHF;
  private final a sAI;
  private final int sAJ;
  private final ArrayList<amp> sec;
  
  public FinderBlackListUI()
  {
    AppMethodBeat.i(167154);
    this.TAG = "Finder.FinderBlackListUI";
    this.sAI = new a((Activity)this);
    this.sec = new ArrayList();
    this.sAJ = 1001;
    AppMethodBeat.o(167154);
  }
  
  private final void cJw()
  {
    AppMethodBeat.i(167151);
    ag localag = new ag(this.rHF);
    g.aiU().b((n)localag);
    AppMethodBeat.o(167151);
  }
  
  private final void update()
  {
    AppMethodBeat.i(167149);
    if (this.sec.isEmpty())
    {
      localTextView = this.gWe;
      if (localTextView == null) {
        p.bcb("emptyTip");
      }
      localTextView.setVisibility(0);
      localTextView = this.gWe;
      if (localTextView == null) {
        p.bcb("emptyTip");
      }
      localTextView.setText((CharSequence)getString(2131759155));
      AppMethodBeat.o(167149);
      return;
    }
    TextView localTextView = this.gWe;
    if (localTextView == null) {
      p.bcb("emptyTip");
    }
    localTextView.setVisibility(8);
    AppMethodBeat.o(167149);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203889);
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
    AppMethodBeat.o(203889);
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
    p.g(localObject, "findViewById<ListView>(R.id.contact_list)");
    this.jpT = ((ListView)localObject);
    localObject = findViewById(2131299472);
    p.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.gWe = ((TextView)localObject);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.nZK = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.jpT;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.sAI);
    localObject = this.jpT;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
    this.sAI.sAz = ((m)new c(this));
    update();
    AppMethodBeat.o(167148);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167147);
    super.onCreate(paramBundle);
    g.aiU().a(3717, (f)this);
    initView();
    cJw();
    AppMethodBeat.o(167147);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167152);
    super.onDestroy();
    g.aiU().b(3717, (f)this);
    AppMethodBeat.o(167152);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(167153);
    ad.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetBlackList");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      paramString = ((ag)paramn).rr.aEF();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      if (((anf)paramString).continueFlag != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.hasMore = bool;
        paramString = ((ag)paramn).rr.aEF();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
        AppMethodBeat.o(167153);
        throw paramString;
      }
      this.rHF = ((anf)paramString).sbF;
      c.g((d.g.a.a)new e(this, paramn));
    }
    AppMethodBeat.o(167153);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167140);
      this.sAK.finish();
      AppMethodBeat.o(167140);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderBlackListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class b
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167141);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderBlackListUI.a(this.sAK))
        {
          FinderBlackListUI.b(this.sAK);
          AppMethodBeat.o(167141);
          return;
        }
        if (FinderBlackListUI.c(this.sAK).getFooterViewsCount() == 0) {
          FinderBlackListUI.c(this.sAK).addFooterView(View.inflate((Context)this.sAK, 2131494060, null));
        }
      }
      AppMethodBeat.o(167141);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements m<View, Integer, z>
  {
    c(FinderBlackListUI paramFinderBlackListUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(FinderBlackListUI paramFinderBlackListUI, alp paramalp, apl paramapl)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(FinderBlackListUI paramFinderBlackListUI, n paramn)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class f
    implements View.OnCreateContextMenuListener
  {
    f(FinderBlackListUI paramFinderBlackListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167145);
      paramContextMenu.add(0, FinderBlackListUI.e(this.sAK), 0, (CharSequence)this.sAK.getString(2131757741));
      AppMethodBeat.o(167145);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements n.e
  {
    g(FinderBlackListUI paramFinderBlackListUI, amp paramamp) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167146);
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderBlackListUI.e(this.sAK))
      {
        paramMenuItem = (j)g.ab(j.class);
        String str = this.sAN.GlF;
        p.g(str, "fansContact.fansId");
        paramMenuItem.a(str, false, (s)this.sAK);
      }
      AppMethodBeat.o(167146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBlackListUI
 * JD-Core Version:    0.7.0.1
 */