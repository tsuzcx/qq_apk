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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ah;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.amp;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "FIRST_PAGE_FILE_NAME", "", "MENU_ID_ADD_BLACK_LIST", "", "TAG", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetFansScene", "", "getLayoutId", "initView", "jumpToProfile", "fansContact", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "anchor", "Landroid/view/View;", "updateTitle", "plugin-finder_release"})
public final class FinderFansListUI
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
  private final String sCt;
  private final com.tencent.mm.plugin.finder.storage.data.b sCu;
  private final int sCv;
  private final ArrayList<amp> sec;
  
  public FinderFansListUI()
  {
    AppMethodBeat.i(167257);
    this.TAG = "Finder.FinderFansListUI";
    this.sAI = new a((Activity)this);
    this.sec = new ArrayList();
    this.sCt = "fansList.fp";
    this.sCu = new com.tencent.mm.plugin.finder.storage.data.b(this.sCt);
    this.sCv = 1001;
    AppMethodBeat.o(167257);
  }
  
  private final void cJJ()
  {
    AppMethodBeat.i(167254);
    ah localah = new ah(this.rHF);
    g.aiU().b((n)localah);
    AppMethodBeat.o(167254);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(167252);
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    int i = ((e)localObject).ajl().getInt(al.a.IHV, 0);
    ad.i(this.TAG, "update title %s", new Object[] { Integer.valueOf(i) });
    setMMTitle(getString(2131759271, new Object[] { Integer.valueOf(i) }));
    if (i == 0)
    {
      localObject = this.gWe;
      if (localObject == null) {
        p.bcb("emptyTip");
      }
      ((TextView)localObject).setVisibility(0);
      localObject = this.gWe;
      if (localObject == null) {
        p.bcb("emptyTip");
      }
      ((TextView)localObject).setText((CharSequence)getString(2131759209));
      AppMethodBeat.o(167252);
      return;
    }
    localObject = this.gWe;
    if (localObject == null) {
      p.bcb("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(167252);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203959);
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
    AppMethodBeat.o(203959);
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
    this.jpT = ((ListView)localObject);
    localObject = findViewById(2131299472);
    p.g(localObject, "findViewById<TextView>(R.id.empty_tip)");
    this.gWe = ((TextView)localObject);
    updateTitle();
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
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.jpT;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
    localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cHS().value()).intValue() > 0) {
      this.sAI.sAA = ((m)new c(this));
    }
    this.sAI.sAz = ((m)new d(this));
    AppMethodBeat.o(167251);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167250);
    super.onCreate(paramBundle);
    g.aiU().a(3531, (f)this);
    initView();
    c.b(c.a(c.akP(), (d.g.a.b)new e(this)), (d.g.a.b)new f(this));
    cJJ();
    AppMethodBeat.o(167250);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167255);
    super.onDestroy();
    g.aiU().b(3531, (f)this);
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
      paramString = ((ah)paramn).rr.aEE();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListRequest");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      paramString = ((ank)paramString).sbF;
      if ((p.i(this.rHF, paramString) ^ true))
      {
        ad.i(this.TAG, "not my buf, ignore!");
        AppMethodBeat.o(167256);
        return;
      }
      paramString = ((ah)paramn).rr.aEF();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      if (((anl)paramString).continueFlag != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.hasMore = bool;
        if (this.rHF == null)
        {
          this.sec.clear();
          c.a(c.akP(), (d.g.a.b)new h(this, paramn));
        }
        paramString = ((ah)paramn).rr.aEF();
        if (paramString != null) {
          break;
        }
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFansListResponse");
        AppMethodBeat.o(167256);
        throw paramString;
      }
      this.rHF = ((anl)paramString).sbF;
      c.g((d.g.a.a)new i(this, paramn));
    }
    AppMethodBeat.o(167256);
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
    a(FinderFansListUI paramFinderFansListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167239);
      this.sCw.finish();
      AppMethodBeat.o(167239);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class b
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(167240);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFansListUI.e(this.sCw))
        {
          FinderFansListUI.f(this.sCw);
          AppMethodBeat.o(167240);
          return;
        }
        if (FinderFansListUI.g(this.sCw).getFooterViewsCount() == 0) {
          FinderFansListUI.g(this.sCw).addFooterView(View.inflate((Context)this.sCw, 2131496456, null));
        }
      }
      AppMethodBeat.o(167240);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements m<View, Integer, z>
  {
    c(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements m<View, Integer, z>
  {
    d(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "it", "Ljava/lang/Void;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<Void, LinkedList<amp>>
  {
    e(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<LinkedList<amp>, Object>
  {
    f(FinderFansListUI paramFinderFansListUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    g(FinderFansListUI paramFinderFansListUI, alp paramalp, apl paramapl)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Void;", "invoke", "(Ljava/lang/Void;)Lkotlin/Unit;", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$onSceneEnd$1$1"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<Void, z>
  {
    h(FinderFansListUI paramFinderFansListUI, n paramn)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    i(FinderFansListUI paramFinderFansListUI, n paramn)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class j
    implements View.OnCreateContextMenuListener
  {
    j(FinderFansListUI paramFinderFansListUI) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(167247);
      paramContextMenu.add(0, FinderFansListUI.h(this.sCw), 0, (CharSequence)this.sCw.getString(2131757736));
      AppMethodBeat.o(167247);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class k
    implements n.e
  {
    k(FinderFansListUI paramFinderFansListUI, amp paramamp) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(167249);
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == FinderFansListUI.h(this.sCw)) {
        h.e((Context)this.sCw, this.sCw.getString(2131759145), "", this.sCw.getString(2131757736), this.sCw.getString(2131755691), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(167248);
            paramAnonymousDialogInterface = (j)g.ab(j.class);
            String str = this.sCx.sAN.GlF;
            p.g(str, "fansContact.fansId");
            paramAnonymousDialogInterface.a(str, true, (s)this.sCx.sCw);
            AppMethodBeat.o(167248);
          }
        }, null);
      }
      AppMethodBeat.o(167249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFansListUI
 * JD-Core Version:    0.7.0.1
 */