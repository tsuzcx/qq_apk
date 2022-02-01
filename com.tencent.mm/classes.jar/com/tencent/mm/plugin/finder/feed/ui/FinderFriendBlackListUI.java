package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ho;
import com.tencent.mm.f.b.a.ek;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_REMOVE_BLACK_LIST", "", "getMENU_ID_REMOVE_BLACK_LIST", "()I", "clickTabContextId", "", "getClickTabContextId", "()Ljava/lang/String;", "clickTabContextId$delegate", "Lkotlin/Lazy;", "contactList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contextId", "getContextId", "contextId$delegate", "emptyTip", "Landroid/widget/TextView;", "enterCount", "getEnterCount", "setEnterCount", "(I)V", "feedId", "", "getFeedId", "()J", "feedId$delegate", "fromCommentScene", "getFromCommentScene", "fromCommentScene$delegate", "lastDelList", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "listView", "Landroid/widget/ListView;", "md5", "getMd5", "setMd5", "(Ljava/lang/String;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "sessionId", "getSessionId", "sessionId$delegate", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getTipDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTipDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "checkNetworkAvailable", "", "checkNetworkAvailableMM", "doConfirm", "", "deleteName", "doConfirmScene", "opList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "finish", "genMd5", "getLayoutId", "initData", "data", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "publishEvent", "userName", "unlike", "refresh", "addList", "showEmptyView", "showListView", "showPopupMenu", "blackInfo", "anchor", "Landroid/view/View;", "isMale", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFriendBlackListUI
  extends MMFinderUI
  implements i
{
  static final String TAG = "Finder.FinderFriendBlackListUI";
  public static final a xMQ;
  private HashMap _$_findViewCache;
  private TextView kGj;
  private String md5;
  private ListView niO;
  private com.tencent.mm.ui.widget.b.a szq;
  s tipDialog;
  private final ArrayList<String> xMG;
  private final ArrayList<String> xMH;
  final int xMI;
  private final com.tencent.mm.plugin.finder.ui.c xMJ;
  private final kotlin.f xMK;
  private final kotlin.f xML;
  private final kotlin.f xMM;
  private final kotlin.f xMN;
  private final kotlin.f xMO;
  private int xMP;
  
  static
  {
    AppMethodBeat.i(280989);
    xMQ = new a((byte)0);
    TAG = "Finder.FinderFriendBlackListUI";
    AppMethodBeat.o(280989);
  }
  
  public FinderFriendBlackListUI()
  {
    AppMethodBeat.i(280988);
    this.xMG = new ArrayList();
    this.xMH = new ArrayList();
    this.md5 = "";
    this.xMI = 1001;
    this.xMJ = new com.tencent.mm.plugin.finder.ui.c((Activity)this);
    this.xMK = g.ar((kotlin.g.a.a)i.xMT);
    this.xML = g.ar((kotlin.g.a.a)new c(this));
    this.xMM = g.ar((kotlin.g.a.a)new b(this));
    this.xMN = g.ar((kotlin.g.a.a)new f(this));
    this.xMO = g.ar((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(280988);
  }
  
  private void MI(int paramInt)
  {
    AppMethodBeat.i(280981);
    if (paramInt <= 0)
    {
      setMMTitle(getString(b.j.finder_liked_nolonger_see_title));
      AppMethodBeat.o(280981);
      return;
    }
    setMMTitle(getString(b.j.finder_liked_nolonger_see_count, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(280981);
  }
  
  static void ag(LinkedList<cyc> paramLinkedList)
  {
    AppMethodBeat.i(280983);
    p.k(paramLinkedList, "opList");
    Object localObject = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramLinkedList.add(((cyc)((Iterator)localObject).next()).UserName);
    }
    paramLinkedList = new com.tencent.mm.modelmulti.c((List)paramLinkedList, 33554432, 2, com.tencent.mm.n.h.axc().getInt("MMBatchModContactTypeMaxNumForServer", 30));
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramLinkedList);
    AppMethodBeat.o(280983);
  }
  
  private final String agX()
  {
    AppMethodBeat.i(280976);
    String str = (String)this.xML.getValue();
    AppMethodBeat.o(280976);
    return str;
  }
  
  private final String agY()
  {
    AppMethodBeat.i(280977);
    String str = (String)this.xMM.getValue();
    AppMethodBeat.o(280977);
    return str;
  }
  
  private void bTY()
  {
    AppMethodBeat.i(280982);
    Object localObject = this.kGj;
    if (localObject == null) {
      p.bGy("emptyTip");
    }
    ((TextView)localObject).setVisibility(0);
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setVisibility(8);
    AppMethodBeat.o(280982);
  }
  
  private final int dvc()
  {
    AppMethodBeat.i(280978);
    int i = ((Number)this.xMN.getValue()).intValue();
    AppMethodBeat.o(280978);
    return i;
  }
  
  private final String getSessionId()
  {
    AppMethodBeat.i(280975);
    String str = (String)this.xMK.getValue();
    AppMethodBeat.o(280975);
    return str;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(280994);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(280994);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(280992);
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
    AppMethodBeat.o(280992);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(280986);
    if (!this.xMH.isEmpty())
    {
      p.k("", "userName");
      ho localho = new ho();
      localho.fEA.fEC = "";
      localho.fEA.fEB = 0;
      EventCenter.instance.publish((IEvent)localho);
      Log.i(TAG, "publishEvent");
    }
    super.finish();
    AppMethodBeat.o(280986);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_friend_black_list_layout;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(280980);
    Object localObject = findViewById(b.f.finder_liked_list);
    p.j(localObject, "findViewById(R.id.finder_liked_list)");
    this.niO = ((ListView)localObject);
    localObject = findViewById(b.f.empty_tip);
    p.j(localObject, "findViewById(R.id.empty_tip)");
    this.kGj = ((TextView)localObject);
    this.szq = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.xMJ);
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    this.xMJ.AqW = ((kotlin.g.a.q)new g(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    AppMethodBeat.o(280980);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(280979);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(3528, (i)this);
    com.tencent.mm.kernel.h.aGY().a(3990, (i)this);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.d.AmR;
    d.a.dZo().onAlive();
    initView();
    paramBundle = com.tencent.mm.plugin.finder.storage.data.d.AmR;
    paramBundle = d.a.dZo().dZn();
    p.k(paramBundle, "data");
    if (paramBundle.isEmpty())
    {
      MI(0);
      Log.i(TAG, "onCreate sessionId:" + getSessionId() + " contextId:" + agX() + " clickTabContextId:" + agY() + " fromCommentScene:" + dvc());
      AppMethodBeat.o(280979);
      return;
    }
    this.xMG.clear();
    this.xMG.addAll((Collection)paramBundle);
    paramBundle = Util.listToString((List)this.xMG, ",");
    p.j(paramBundle, "Util.listToString(contactList, \",\")");
    this.md5 = paramBundle;
    paramBundle = this.xMG;
    p.k(paramBundle, "addList");
    Log.i(TAG, "friend list: " + paramBundle.size());
    if (paramBundle.isEmpty()) {
      bTY();
    }
    for (;;)
    {
      this.xMP = paramBundle.size();
      MI(paramBundle.size());
      break;
      Object localObject = this.kGj;
      if (localObject == null) {
        p.bGy("emptyTip");
      }
      ((TextView)localObject).setVisibility(8);
      localObject = this.niO;
      if (localObject == null) {
        p.bGy("listView");
      }
      ((ListView)localObject).setVisibility(0);
      this.xMJ.eR((List)paramBundle);
      this.xMJ.notifyDataSetChanged();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(280987);
    Object localObject1 = Util.listToString((List)this.xMH, ";");
    bid localbid = new bid();
    localbid.sessionId = getSessionId();
    localbid.wmL = agX();
    localbid.wmz = agY();
    localbid.xkX = dvc();
    Object localObject2 = n.zWF;
    long l = ((Number)this.xMO.getValue()).longValue();
    p.j(localObject1, "delUsernames");
    int i = this.xMP;
    p.k(localbid, "contextObj");
    p.k("", "addUsernames");
    p.k(localObject1, "delUsernames");
    localObject2 = new ek();
    ((ek)localObject2).sl(localbid.sessionId);
    ((ek)localObject2).sm(localbid.wmL);
    ((ek)localObject2).sn(localbid.wmz);
    ((ek)localObject2).lw(localbid.xkX);
    ((ek)localObject2).sq(com.tencent.mm.ae.d.Fw(l));
    ((ek)localObject2).so("");
    ((ek)localObject2).sp((String)localObject1);
    ((ek)localObject2).lx(i);
    ((ek)localObject2).bpa();
    n.a((com.tencent.mm.plugin.report.a)localObject2);
    com.tencent.mm.kernel.h.aGY().b(3528, (i)this);
    com.tencent.mm.kernel.h.aGY().b(3990, (i)this);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.AmR;
    d.a.dZo().onDetach();
    localObject1 = this.tipDialog;
    if (localObject1 != null) {
      ((s)localObject1).dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(280987);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(280985);
    if ((paramq instanceof com.tencent.mm.modelmulti.c))
    {
      Log.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        paramString = ((com.tencent.mm.modelmulti.c)paramq).bnb();
        p.j(paramString, "scene.names");
        paramString = (String)kotlin.a.j.lp(paramString);
        if (paramString != null)
        {
          this.xMH.add(paramString);
          this.xMJ.aFg(paramString);
          MI(this.xMJ.getCount());
          if (this.xMJ.getCount() <= 0) {
            bTY();
          }
          AppMethodBeat.o(280985);
          return;
        }
        AppMethodBeat.o(280985);
        return;
      }
      if (paramInt2 == -3500)
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        w.makeText((Context)this, b.j.finder_black_list_limit_tips, 0).show();
        AppMethodBeat.o(280985);
        return;
      }
      paramString = this.tipDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      w.makeText((Context)this, b.j.finder_liked_see_failed, 0).show();
    }
    AppMethodBeat.o(280985);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    b(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    c(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long>
  {
    e(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    f(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "blackInfo", "", "isMale", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.q<View, String, Boolean, x>
  {
    g(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(289729);
      this.xMR.finish();
      AppMethodBeat.o(289729);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    public static final i xMT;
    
    static
    {
      AppMethodBeat.i(272564);
      xMT = new i();
      AppMethodBeat.o(272564);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class j
    implements View.OnCreateContextMenuListener
  {
    j(FinderFriendBlackListUI paramFinderFriendBlackListUI, boolean paramBoolean) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(288112);
      int i = this.xMR.xMI;
      if (this.xMU) {}
      for (paramView = this.xMR.getString(b.j.finder_liked_see_him);; paramView = this.xMR.getString(b.j.finder_liked_see_her))
      {
        paramContextMenu.add(0, i, 0, (CharSequence)paramView);
        AppMethodBeat.o(288112);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class k
    implements q.g
  {
    k(FinderFriendBlackListUI paramFinderFriendBlackListUI, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(290590);
      p.j(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == this.xMR.xMI)
      {
        Object localObject1 = this.xMR;
        paramMenuItem = this.xMV;
        p.k(paramMenuItem, "deleteName");
        if (!Util.isNullOrNil(paramMenuItem))
        {
          Object localObject2 = com.tencent.mm.kernel.h.aHD().aHf();
          p.j(localObject2, "MMKernel.process().current()");
          if (((com.tencent.mm.kernel.b.h)localObject2).aIE())
          {
            localObject2 = com.tencent.mm.kernel.h.aGY();
            p.j(localObject2, "MMKernel.getNetSceneQueue()");
            paramInt = ((t)localObject2).bih();
            if ((paramInt == 4) || (paramInt == 6)) {
              paramInt = 1;
            }
          }
          while (paramInt == 0)
          {
            w.makeText((Context)localObject1, b.j.finder_black_list_loading_fail, 0).show();
            AppMethodBeat.o(290590);
            return;
            paramInt = 0;
            continue;
            if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {}
            for (paramInt = 6;; paramInt = 0)
            {
              if (paramInt != 6) {
                break label164;
              }
              paramInt = 1;
              break;
            }
            label164:
            paramInt = 0;
          }
          localObject2 = (Context)localObject1;
          ((FinderFriendBlackListUI)localObject1).getString(c.g.app_tip);
          ((FinderFriendBlackListUI)localObject1).tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, ((FinderFriendBlackListUI)localObject1).getString(b.j.finder_black_list_setting_loading), true, (DialogInterface.OnCancelListener)FinderFriendBlackListUI.d.xMS);
          localObject1 = new LinkedList();
          Log.d(FinderFriendBlackListUI.TAG, "deleted user:".concat(String.valueOf(paramMenuItem)));
          localObject2 = new cyc();
          ((cyc)localObject2).UserName = paramMenuItem;
          ((cyc)localObject2).TGA = com.tencent.mm.plugin.findersdk.a.j.Bvg;
          ((cyc)localObject2).TGB = 2;
          ((LinkedList)localObject1).add(localObject2);
          FinderFriendBlackListUI.ag((LinkedList)localObject1);
        }
      }
      AppMethodBeat.o(290590);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendBlackListUI
 * JD-Core Version:    0.7.0.1
 */