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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.g.b.a.dr;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_REMOVE_BLACK_LIST", "", "getMENU_ID_REMOVE_BLACK_LIST", "()I", "clickTabContextId", "", "getClickTabContextId", "()Ljava/lang/String;", "clickTabContextId$delegate", "Lkotlin/Lazy;", "contactList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contextId", "getContextId", "contextId$delegate", "emptyTip", "Landroid/widget/TextView;", "enterCount", "getEnterCount", "setEnterCount", "(I)V", "feedId", "", "getFeedId", "()J", "feedId$delegate", "fromCommentScene", "getFromCommentScene", "fromCommentScene$delegate", "lastDelList", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "listView", "Landroid/widget/ListView;", "md5", "getMd5", "setMd5", "(Ljava/lang/String;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "sessionId", "getSessionId", "sessionId$delegate", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getTipDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTipDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "checkNetworkAvailable", "", "checkNetworkAvailableMM", "doConfirm", "", "deleteName", "doConfirmScene", "opList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "finish", "genMd5", "getLayoutId", "initData", "data", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "publishEvent", "userName", "unlike", "refresh", "addList", "showEmptyView", "showListView", "showPopupMenu", "blackInfo", "anchor", "Landroid/view/View;", "isMale", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFriendBlackListUI
  extends MMFinderUI
  implements i
{
  static final String TAG = "Finder.FinderFriendBlackListUI";
  public static final a uao;
  private HashMap _$_findViewCache;
  private TextView hRM;
  private ListView krb;
  private String md5;
  private com.tencent.mm.ui.widget.b.a pqr;
  com.tencent.mm.ui.base.q tipDialog;
  private final ArrayList<String> uae;
  private final ArrayList<String> uaf;
  final int uag;
  private final com.tencent.mm.plugin.finder.ui.c uah;
  private final kotlin.f uai;
  private final kotlin.f uaj;
  private final kotlin.f uak;
  private final kotlin.f ual;
  private final kotlin.f uam;
  private int uan;
  
  static
  {
    AppMethodBeat.i(245213);
    uao = new a((byte)0);
    TAG = "Finder.FinderFriendBlackListUI";
    AppMethodBeat.o(245213);
  }
  
  public FinderFriendBlackListUI()
  {
    AppMethodBeat.i(245212);
    this.uae = new ArrayList();
    this.uaf = new ArrayList();
    this.md5 = "";
    this.uag = 1001;
    this.uah = new com.tencent.mm.plugin.finder.ui.c((Activity)this);
    this.uai = kotlin.g.ah((kotlin.g.a.a)i.uar);
    this.uaj = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.uak = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.ual = kotlin.g.ah((kotlin.g.a.a)new f(this));
    this.uam = kotlin.g.ah((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(245212);
  }
  
  private void IQ(int paramInt)
  {
    AppMethodBeat.i(245206);
    if (paramInt <= 0)
    {
      setMMTitle(getString(2131759850));
      AppMethodBeat.o(245206);
      return;
    }
    setMMTitle(getString(2131759848, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(245206);
  }
  
  private final String acj()
  {
    AppMethodBeat.i(245201);
    String str = (String)this.uaj.getValue();
    AppMethodBeat.o(245201);
    return str;
  }
  
  private final String ack()
  {
    AppMethodBeat.i(245202);
    String str = (String)this.uak.getValue();
    AppMethodBeat.o(245202);
    return str;
  }
  
  static void ah(LinkedList<cpm> paramLinkedList)
  {
    AppMethodBeat.i(245208);
    p.h(paramLinkedList, "opList");
    Object localObject = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramLinkedList.add(((cpm)((Iterator)localObject).next()).UserName);
    }
    paramLinkedList = new com.tencent.mm.modelmulti.c((List)paramLinkedList, 33554432, 2, com.tencent.mm.n.h.aqJ().getInt("MMBatchModContactTypeMaxNumForServer", 30));
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramLinkedList);
    AppMethodBeat.o(245208);
  }
  
  private void bIo()
  {
    AppMethodBeat.i(245207);
    Object localObject = this.hRM;
    if (localObject == null) {
      p.btv("emptyTip");
    }
    ((TextView)localObject).setVisibility(0);
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setVisibility(8);
    AppMethodBeat.o(245207);
  }
  
  private final int ddV()
  {
    AppMethodBeat.i(245203);
    int i = ((Number)this.ual.getValue()).intValue();
    AppMethodBeat.o(245203);
    return i;
  }
  
  private final String getSessionId()
  {
    AppMethodBeat.i(245200);
    String str = (String)this.uai.getValue();
    AppMethodBeat.o(245200);
    return str;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245216);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245216);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245215);
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
    AppMethodBeat.o(245215);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245210);
    if (!this.uaf.isEmpty())
    {
      p.h("", "userName");
      hh localhh = new hh();
      localhh.dLL.dLN = "";
      localhh.dLL.dLM = 0;
      EventCenter.instance.publish((IEvent)localhh);
      Log.i(TAG, "publishEvent");
    }
    super.finish();
    AppMethodBeat.o(245210);
  }
  
  public final int getLayoutId()
  {
    return 2131494325;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(245205);
    Object localObject = findViewById(2131300862);
    p.g(localObject, "findViewById(R.id.finder_liked_list)");
    this.krb = ((ListView)localObject);
    localObject = findViewById(2131300101);
    p.g(localObject, "findViewById(R.id.empty_tip)");
    this.hRM = ((TextView)localObject);
    this.pqr = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.uah);
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    this.uah.vKe = ((kotlin.g.a.q)new g(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    AppMethodBeat.o(245205);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245204);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.azz().a(3528, (i)this);
    com.tencent.mm.kernel.g.azz().a(3990, (i)this);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.d.vFS;
    d.a.dyw().onAlive();
    initView();
    paramBundle = com.tencent.mm.plugin.finder.storage.data.d.vFS;
    paramBundle = d.a.dyw().dyv();
    p.h(paramBundle, "data");
    if (paramBundle.isEmpty())
    {
      IQ(0);
      Log.i(TAG, "onCreate sessionId:" + getSessionId() + " contextId:" + acj() + " clickTabContextId:" + ack() + " fromCommentScene:" + ddV());
      AppMethodBeat.o(245204);
      return;
    }
    this.uae.clear();
    this.uae.addAll((Collection)paramBundle);
    paramBundle = Util.listToString((List)this.uae, ",");
    p.g(paramBundle, "Util.listToString(contactList, \",\")");
    this.md5 = paramBundle;
    paramBundle = this.uae;
    p.h(paramBundle, "addList");
    Log.i(TAG, "friend list: " + paramBundle.size());
    if (paramBundle.isEmpty()) {
      bIo();
    }
    for (;;)
    {
      this.uan = paramBundle.size();
      IQ(paramBundle.size());
      break;
      Object localObject = this.hRM;
      if (localObject == null) {
        p.btv("emptyTip");
      }
      ((TextView)localObject).setVisibility(8);
      localObject = this.krb;
      if (localObject == null) {
        p.btv("listView");
      }
      ((ListView)localObject).setVisibility(0);
      this.uah.ew((List)paramBundle);
      this.uah.notifyDataSetChanged();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245211);
    Object localObject1 = Util.listToString((List)this.uaf, ";");
    bbn localbbn = new bbn();
    localbbn.sessionId = getSessionId();
    localbbn.sGQ = acj();
    localbbn.sGE = ack();
    localbbn.tCE = ddV();
    Object localObject2 = com.tencent.mm.plugin.finder.report.k.vfA;
    long l = ((Number)this.uam.getValue()).longValue();
    p.g(localObject1, "delUsernames");
    int i = this.uan;
    p.h(localbbn, "contextObj");
    p.h("", "addUsernames");
    p.h(localObject1, "delUsernames");
    localObject2 = new dr();
    ((dr)localObject2).pA(localbbn.sessionId);
    ((dr)localObject2).pB(localbbn.sGQ);
    ((dr)localObject2).pC(localbbn.sGE);
    ((dr)localObject2).ku(localbbn.tCE);
    ((dr)localObject2).pF(com.tencent.mm.ac.d.zs(l));
    ((dr)localObject2).pD("");
    ((dr)localObject2).pE((String)localObject1);
    ((dr)localObject2).kv(i);
    ((dr)localObject2).bfK();
    com.tencent.mm.plugin.finder.report.k.a((com.tencent.mm.plugin.report.a)localObject2);
    com.tencent.mm.kernel.g.azz().b(3528, (i)this);
    com.tencent.mm.kernel.g.azz().b(3990, (i)this);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.vFS;
    d.a.dyw().onDetach();
    localObject1 = this.tipDialog;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.base.q)localObject1).dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(245211);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(245209);
    if ((paramq instanceof com.tencent.mm.modelmulti.c))
    {
      Log.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        paramString = ((com.tencent.mm.modelmulti.c)paramq).bdH();
        p.g(paramString, "scene.names");
        paramString = (String)j.kt(paramString);
        if (paramString != null)
        {
          this.uaf.add(paramString);
          this.uah.avP(paramString);
          IQ(this.uah.getCount());
          if (this.uah.getCount() <= 0) {
            bIo();
          }
          AppMethodBeat.o(245209);
          return;
        }
        AppMethodBeat.o(245209);
        return;
      }
      if (paramInt2 == -3500)
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        u.makeText((Context)this, 2131759551, 0).show();
        AppMethodBeat.o(245209);
        return;
      }
      paramString = this.tipDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      u.makeText((Context)this, 2131759852, 0).show();
    }
    AppMethodBeat.o(245209);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    b(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    c(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long>
  {
    e(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    f(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "blackInfo", "", "isMale", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.q<View, String, Boolean, x>
  {
    g(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245195);
      this.uap.finish();
      AppMethodBeat.o(245195);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    public static final i uar;
    
    static
    {
      AppMethodBeat.i(245197);
      uar = new i();
      AppMethodBeat.o(245197);
    }
    
    i()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
  static final class j
    implements View.OnCreateContextMenuListener
  {
    j(FinderFriendBlackListUI paramFinderFriendBlackListUI, boolean paramBoolean) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(245198);
      int i = this.uap.uag;
      if (this.uas) {}
      for (paramView = this.uap.getString(2131759854);; paramView = this.uap.getString(2131759853))
      {
        paramContextMenu.add(0, i, 0, (CharSequence)paramView);
        AppMethodBeat.o(245198);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class k
    implements o.g
  {
    k(FinderFriendBlackListUI paramFinderFriendBlackListUI, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(245199);
      p.g(paramMenuItem, "menuItem");
      if (paramMenuItem.getItemId() == this.uap.uag)
      {
        Object localObject1 = this.uap;
        paramMenuItem = this.uat;
        p.h(paramMenuItem, "deleteName");
        if (!Util.isNullOrNil(paramMenuItem))
        {
          Object localObject2 = com.tencent.mm.kernel.g.aAe().azG();
          p.g(localObject2, "MMKernel.process().current()");
          if (((com.tencent.mm.kernel.b.h)localObject2).aBb())
          {
            localObject2 = com.tencent.mm.kernel.g.azz();
            p.g(localObject2, "MMKernel.getNetSceneQueue()");
            paramInt = ((t)localObject2).aYS();
            if ((paramInt == 4) || (paramInt == 6)) {
              paramInt = 1;
            }
          }
          while (paramInt == 0)
          {
            u.makeText((Context)localObject1, 2131759552, 0).show();
            AppMethodBeat.o(245199);
            return;
            paramInt = 0;
            continue;
            if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {}
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
          ((FinderFriendBlackListUI)localObject1).getString(2131755998);
          ((FinderFriendBlackListUI)localObject1).tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, ((FinderFriendBlackListUI)localObject1).getString(2131759556), true, (DialogInterface.OnCancelListener)FinderFriendBlackListUI.d.uaq);
          localObject1 = new LinkedList();
          Log.d(FinderFriendBlackListUI.TAG, "deleted user:".concat(String.valueOf(paramMenuItem)));
          localObject2 = new cpm();
          ((cpm)localObject2).UserName = paramMenuItem;
          ((cpm)localObject2).MvC = com.tencent.mm.plugin.i.a.k.wEb;
          ((cpm)localObject2).MvD = 2;
          ((LinkedList)localObject1).add(localObject2);
          FinderFriendBlackListUI.ah((LinkedList)localObject1);
        }
      }
      AppMethodBeat.o(245199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendBlackListUI
 * JD-Core Version:    0.7.0.1
 */