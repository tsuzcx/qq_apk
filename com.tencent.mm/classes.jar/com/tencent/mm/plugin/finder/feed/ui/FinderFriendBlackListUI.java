package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.plugin.finder.cgi.y;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import d.a.j;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_REMOVE_BLACK_LIST", "", "getMENU_ID_REMOVE_BLACK_LIST", "()I", "clickTabContextId", "", "getClickTabContextId", "()Ljava/lang/String;", "clickTabContextId$delegate", "Lkotlin/Lazy;", "contactList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contextId", "getContextId", "contextId$delegate", "emptyTip", "Landroid/widget/TextView;", "enterCount", "getEnterCount", "setEnterCount", "(I)V", "feedId", "", "getFeedId", "()J", "feedId$delegate", "fromCommentScene", "getFromCommentScene", "fromCommentScene$delegate", "lastDelList", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "listView", "Landroid/widget/ListView;", "md5", "getMd5", "setMd5", "(Ljava/lang/String;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "sessionId", "getSessionId", "sessionId$delegate", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getTipDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTipDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "checkNetworkAvailable", "", "checkNetworkAvailableMM", "doConfirm", "", "deleteName", "doConfirmScene", "opList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "finish", "genMd5", "getLayoutId", "initData", "data", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "publishEvent", "userName", "unlike", "refresh", "addList", "showEmptyView", "showListView", "showPopupMenu", "blackInfo", "anchor", "Landroid/view/View;", "isMale", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFriendBlackListUI
  extends MMFinderUI
  implements com.tencent.mm.al.f
{
  static final String TAG = "Finder.FinderFriendBlackListUI";
  public static final a sem;
  private HashMap _$_findViewCache;
  private TextView gWe;
  private ListView jpT;
  private String md5;
  private com.tencent.mm.ui.widget.b.a nZK;
  private final ArrayList<String> sec;
  private final ArrayList<String> sed;
  final int see;
  private final com.tencent.mm.plugin.finder.ui.b sef;
  private final d.f seg;
  private final d.f seh;
  private final d.f sei;
  private final d.f sej;
  private final d.f sek;
  private int sel;
  com.tencent.mm.ui.base.p tipDialog;
  
  static
  {
    AppMethodBeat.i(202688);
    sem = new a((byte)0);
    TAG = "Finder.FinderFriendBlackListUI";
    AppMethodBeat.o(202688);
  }
  
  public FinderFriendBlackListUI()
  {
    AppMethodBeat.i(202687);
    this.sec = new ArrayList();
    this.sed = new ArrayList();
    this.md5 = "";
    this.see = 1001;
    this.sef = new com.tencent.mm.plugin.finder.ui.b((Activity)this);
    this.seg = d.g.O((d.g.a.a)i.sep);
    this.seh = d.g.O((d.g.a.a)new c(this));
    this.sei = d.g.O((d.g.a.a)new b(this));
    this.sej = d.g.O((d.g.a.a)new f(this));
    this.sek = d.g.O((d.g.a.a)new e(this));
    AppMethodBeat.o(202687);
  }
  
  private void EG(int paramInt)
  {
    AppMethodBeat.i(202682);
    if (paramInt <= 0)
    {
      setMMTitle(getString(2131767002));
      AppMethodBeat.o(202682);
      return;
    }
    setMMTitle(getString(2131766436, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(202682);
  }
  
  private final String SD()
  {
    AppMethodBeat.i(202678);
    String str = (String)this.sei.getValue();
    AppMethodBeat.o(202678);
    return str;
  }
  
  private final String UL()
  {
    AppMethodBeat.i(202677);
    String str = (String)this.seh.getValue();
    AppMethodBeat.o(202677);
    return str;
  }
  
  private void bmg()
  {
    AppMethodBeat.i(202683);
    Object localObject = this.gWe;
    if (localObject == null) {
      d.g.b.p.bcb("emptyTip");
    }
    ((TextView)localObject).setVisibility(0);
    localObject = this.jpT;
    if (localObject == null) {
      d.g.b.p.bcb("listView");
    }
    ((ListView)localObject).setVisibility(8);
    AppMethodBeat.o(202683);
  }
  
  private final int cCj()
  {
    AppMethodBeat.i(202679);
    int i = ((Number)this.sej.getValue()).intValue();
    AppMethodBeat.o(202679);
    return i;
  }
  
  private final String getSessionId()
  {
    AppMethodBeat.i(202676);
    String str = (String)this.seg.getValue();
    AppMethodBeat.o(202676);
    return str;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202690);
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
    AppMethodBeat.o(202690);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(202685);
    if (!this.sed.isEmpty())
    {
      d.g.b.p.h("", "userName");
      hc localhc = new hc();
      localhc.dtv.dtx = "";
      localhc.dtv.dtw = 0;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localhc);
      ad.i(TAG, "publishEvent");
    }
    super.finish();
    AppMethodBeat.o(202685);
  }
  
  public final int getLayoutId()
  {
    return 2131496203;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(202681);
    Object localObject = findViewById(2131307405);
    d.g.b.p.g(localObject, "findViewById(R.id.finder_liked_list)");
    this.jpT = ((ListView)localObject);
    localObject = findViewById(2131299472);
    d.g.b.p.g(localObject, "findViewById(R.id.empty_tip)");
    this.gWe = ((TextView)localObject);
    this.nZK = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.jpT;
    if (localObject == null) {
      d.g.b.p.bcb("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.sef);
    localObject = this.jpT;
    if (localObject == null) {
      d.g.b.p.bcb("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    this.sef.sCF = ((d.g.a.q)new g(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    AppMethodBeat.o(202681);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202680);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aiU().a(3528, (com.tencent.mm.al.f)this);
    com.tencent.mm.kernel.g.aiU().a(3990, (com.tencent.mm.al.f)this);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.c.szF;
    c.a.cJc().onAlive();
    initView();
    paramBundle = com.tencent.mm.plugin.finder.storage.data.c.szF;
    paramBundle = c.a.cJc().cJb();
    d.g.b.p.h(paramBundle, "data");
    if (paramBundle.isEmpty())
    {
      EG(0);
      ad.i(TAG, "onCreate sessionId:" + getSessionId() + " contextId:" + UL() + " clickTabContextId:" + SD() + " fromCommentScene:" + cCj());
      AppMethodBeat.o(202680);
      return;
    }
    this.sec.clear();
    this.sec.addAll((Collection)paramBundle);
    paramBundle = bt.m((List)this.sec, ",");
    d.g.b.p.g(paramBundle, "Util.listToString(contactList, \",\")");
    this.md5 = paramBundle;
    paramBundle = this.sec;
    d.g.b.p.h(paramBundle, "addList");
    ad.i(TAG, "friend list: " + paramBundle.size());
    if (paramBundle.isEmpty()) {
      bmg();
    }
    for (;;)
    {
      this.sel = paramBundle.size();
      EG(paramBundle.size());
      break;
      Object localObject = this.gWe;
      if (localObject == null) {
        d.g.b.p.bcb("emptyTip");
      }
      ((TextView)localObject).setVisibility(8);
      localObject = this.jpT;
      if (localObject == null) {
        d.g.b.p.bcb("listView");
      }
      ((ListView)localObject).setVisibility(0);
      this.sef.dK((List)paramBundle);
      this.sef.notifyDataSetChanged();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202686);
    Object localObject1 = bt.m((List)this.sed, ";");
    aqy localaqy = new aqy();
    localaqy.sessionId = getSessionId();
    localaqy.qXu = UL();
    localaqy.qXj = SD();
    localaqy.rTD = cCj();
    Object localObject2 = com.tencent.mm.plugin.finder.report.h.soM;
    long l = ((Number)this.sek.getValue()).longValue();
    d.g.b.p.g(localObject1, "delUsernames");
    int i = this.sel;
    d.g.b.p.h(localaqy, "contextObj");
    d.g.b.p.h("", "addUsernames");
    d.g.b.p.h(localObject1, "delUsernames");
    localObject2 = new bn();
    ((bn)localObject2).ki(localaqy.sessionId);
    ((bn)localObject2).kj(localaqy.qXu);
    ((bn)localObject2).kk(localaqy.qXj);
    ((bn)localObject2).fY(localaqy.rTD);
    ((bn)localObject2).kn(com.tencent.mm.ad.c.rc(l));
    ((bn)localObject2).kl("");
    ((bn)localObject2).km((String)localObject1);
    ((bn)localObject2).fZ(i);
    ((bn)localObject2).aLk();
    com.tencent.mm.plugin.finder.report.h.a((com.tencent.mm.plugin.report.a)localObject2);
    com.tencent.mm.kernel.g.aiU().b(3528, (com.tencent.mm.al.f)this);
    com.tencent.mm.kernel.g.aiU().b(3990, (com.tencent.mm.al.f)this);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.c.szF;
    c.a.cJc().onDetach();
    localObject1 = this.tipDialog;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.base.p)localObject1).dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(202686);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(202684);
    if ((paramn instanceof y))
    {
      ad.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        paramn = (bzq)j.jd((List)((y)paramn).rIW);
        if (paramn != null)
        {
          this.sed.add(paramn.nDo);
          paramString = this.sef;
          paramn = paramn.nDo;
          d.g.b.p.g(paramn, "it.UserName");
          paramString.aiI(paramn);
          EG(this.sef.getCount());
          if (this.sef.getCount() <= 0) {
            bmg();
          }
          AppMethodBeat.o(202684);
          return;
        }
        AppMethodBeat.o(202684);
        return;
      }
      if (paramInt2 == -3500)
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        t.makeText((Context)this, 2131764969, 0).show();
        AppMethodBeat.o(202684);
        return;
      }
      paramString = this.tipDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      t.makeText((Context)this, 2131766439, 0).show();
    }
    AppMethodBeat.o(202684);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    b(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    c(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<Long>
  {
    e(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    f(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "view", "Landroid/view/View;", "blackInfo", "", "isMale", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.q<View, String, Boolean, z>
  {
    g(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202671);
      this.sen.finish();
      AppMethodBeat.o(202671);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    public static final i sep;
    
    static
    {
      AppMethodBeat.i(202673);
      sep = new i();
      AppMethodBeat.o(202673);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class j
    implements View.OnCreateContextMenuListener
  {
    j(FinderFriendBlackListUI paramFinderFriendBlackListUI, boolean paramBoolean) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(202674);
      int i = this.sen.see;
      if (this.ser) {}
      for (paramView = this.sen.getString(2131767004);; paramView = this.sen.getString(2131767003))
      {
        paramContextMenu.add(0, i, 0, (CharSequence)paramView);
        AppMethodBeat.o(202674);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class k
    implements n.e
  {
    k(FinderFriendBlackListUI paramFinderFriendBlackListUI, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(202675);
      d.g.b.p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == this.sen.see)
      {
        Object localObject1 = this.sen;
        paramMenuItem = this.ses;
        d.g.b.p.h(paramMenuItem, "deleteName");
        if (!bt.isNullOrNil(paramMenuItem))
        {
          Object localObject2 = com.tencent.mm.kernel.g.ajz().ajb();
          d.g.b.p.g(localObject2, "MMKernel.process().current()");
          if (((com.tencent.mm.kernel.b.h)localObject2).akw())
          {
            localObject2 = com.tencent.mm.kernel.g.aiU();
            d.g.b.p.g(localObject2, "MMKernel.getNetSceneQueue()");
            paramInt = ((com.tencent.mm.al.q)localObject2).aEN();
            if ((paramInt == 4) || (paramInt == 6)) {
              paramInt = 1;
            }
          }
          while (paramInt == 0)
          {
            t.makeText((Context)localObject1, 2131765430, 0).show();
            AppMethodBeat.o(202675);
            return;
            paramInt = 0;
            continue;
            if (ay.isConnected(aj.getContext())) {}
            for (paramInt = 6;; paramInt = 0)
            {
              if (paramInt != 6) {
                break label163;
              }
              paramInt = 1;
              break;
            }
            label163:
            paramInt = 0;
          }
          localObject2 = (Context)localObject1;
          ((FinderFriendBlackListUI)localObject1).getString(2131755906);
          ((FinderFriendBlackListUI)localObject1).tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject2, ((FinderFriendBlackListUI)localObject1).getString(2131765434), true, (DialogInterface.OnCancelListener)FinderFriendBlackListUI.d.seo);
          localObject1 = new LinkedList();
          ad.d(FinderFriendBlackListUI.TAG, "deleted user:".concat(String.valueOf(paramMenuItem)));
          localObject2 = new bzq();
          ((bzq)localObject2).nDo = paramMenuItem;
          ((bzq)localObject2).GUG = com.tencent.mm.plugin.i.a.d.tfL;
          ((bzq)localObject2).GUH = 2;
          ((LinkedList)localObject1).add(localObject2);
          d.g.b.p.h(localObject1, "opList");
          paramMenuItem = new y((LinkedList)localObject1);
          com.tencent.mm.kernel.g.aiU().b((n)paramMenuItem);
        }
      }
      AppMethodBeat.o(202675);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendBlackListUI
 * JD-Core Version:    0.7.0.1
 */