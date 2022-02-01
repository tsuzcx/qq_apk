package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.t;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_REMOVE_BLACK_LIST", "", "getMENU_ID_REMOVE_BLACK_LIST", "()I", "clickTabContextId", "", "getClickTabContextId", "()Ljava/lang/String;", "clickTabContextId$delegate", "Lkotlin/Lazy;", "contactList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contextId", "getContextId", "contextId$delegate", "emptyTip", "Landroid/widget/TextView;", "enterCount", "getEnterCount", "setEnterCount", "(I)V", "feedId", "", "getFeedId", "()J", "feedId$delegate", "fromCommentScene", "getFromCommentScene", "fromCommentScene$delegate", "lastDelList", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "listView", "Landroid/widget/ListView;", "md5", "getMd5", "setMd5", "(Ljava/lang/String;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "sessionId", "getSessionId", "sessionId$delegate", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getTipDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTipDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "checkNetworkAvailable", "", "checkNetworkAvailableMM", "doConfirm", "", "deleteName", "doConfirmScene", "opList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "finish", "genMd5", "getLayoutId", "initData", "data", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "publishEvent", "userName", "unlike", "refresh", "addList", "showEmptyView", "showListView", "showPopupMenu", "blackInfo", "anchor", "Landroid/view/View;", "isMale", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFriendBlackListUI
  extends MMFinderUI
  implements com.tencent.mm.ak.f
{
  static final String TAG = "Finder.FinderFriendBlackListUI";
  public static final FinderFriendBlackListUI.a snc;
  private HashMap _$_findViewCache;
  private TextView gYR;
  private ListView jsM;
  private String md5;
  private com.tencent.mm.ui.widget.b.a ofu;
  private final ArrayList<String> smS;
  private final ArrayList<String> smT;
  final int smU;
  private final com.tencent.mm.plugin.finder.ui.b smV;
  private final d.f smW;
  private final d.f smX;
  private final d.f smY;
  private final d.f smZ;
  private final d.f sna;
  private int snb;
  com.tencent.mm.ui.base.p tipDialog;
  
  static
  {
    AppMethodBeat.i(203164);
    snc = new FinderFriendBlackListUI.a((byte)0);
    TAG = "Finder.FinderFriendBlackListUI";
    AppMethodBeat.o(203164);
  }
  
  public FinderFriendBlackListUI()
  {
    AppMethodBeat.i(203163);
    this.smS = new ArrayList();
    this.smT = new ArrayList();
    this.md5 = "";
    this.smU = 1001;
    this.smV = new com.tencent.mm.plugin.finder.ui.b((Activity)this);
    this.smW = d.g.O((d.g.a.a)i.snf);
    this.smX = d.g.O((d.g.a.a)new c(this));
    this.smY = d.g.O((d.g.a.a)new b(this));
    this.smZ = d.g.O((d.g.a.a)new f(this));
    this.sna = d.g.O((d.g.a.a)new e(this));
    AppMethodBeat.o(203163);
  }
  
  private void ET(int paramInt)
  {
    AppMethodBeat.i(203158);
    if (paramInt <= 0)
    {
      setMMTitle(getString(2131767002));
      AppMethodBeat.o(203158);
      return;
    }
    setMMTitle(getString(2131766436, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(203158);
  }
  
  private final String SB()
  {
    AppMethodBeat.i(203154);
    String str = (String)this.smY.getValue();
    AppMethodBeat.o(203154);
    return str;
  }
  
  private final String UR()
  {
    AppMethodBeat.i(203153);
    String str = (String)this.smX.getValue();
    AppMethodBeat.o(203153);
    return str;
  }
  
  private void bmP()
  {
    AppMethodBeat.i(203159);
    Object localObject = this.gYR;
    if (localObject == null) {
      d.g.b.p.bdF("emptyTip");
    }
    ((TextView)localObject).setVisibility(0);
    localObject = this.jsM;
    if (localObject == null) {
      d.g.b.p.bdF("listView");
    }
    ((ListView)localObject).setVisibility(8);
    AppMethodBeat.o(203159);
  }
  
  private final int cDV()
  {
    AppMethodBeat.i(203155);
    int i = ((Number)this.smZ.getValue()).intValue();
    AppMethodBeat.o(203155);
    return i;
  }
  
  private final String getSessionId()
  {
    AppMethodBeat.i(203152);
    String str = (String)this.smW.getValue();
    AppMethodBeat.o(203152);
    return str;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203166);
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
    AppMethodBeat.o(203166);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(203161);
    if (!this.smT.isEmpty())
    {
      d.g.b.p.h("", "userName");
      hd localhd = new hd();
      localhd.duA.duC = "";
      localhd.duA.duB = 0;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localhd);
      ae.i(TAG, "publishEvent");
    }
    super.finish();
    AppMethodBeat.o(203161);
  }
  
  public final int getLayoutId()
  {
    return 2131496203;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(203157);
    Object localObject = findViewById(2131307405);
    d.g.b.p.g(localObject, "findViewById(R.id.finder_liked_list)");
    this.jsM = ((ListView)localObject);
    localObject = findViewById(2131299472);
    d.g.b.p.g(localObject, "findViewById(R.id.empty_tip)");
    this.gYR = ((TextView)localObject);
    this.ofu = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject = this.jsM;
    if (localObject == null) {
      d.g.b.p.bdF("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.smV);
    localObject = this.jsM;
    if (localObject == null) {
      d.g.b.p.bdF("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    this.smV.sNE = ((d.g.a.q)new g(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    AppMethodBeat.o(203157);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203156);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajj().a(3528, (com.tencent.mm.ak.f)this);
    com.tencent.mm.kernel.g.ajj().a(3990, (com.tencent.mm.ak.f)this);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.c.sKz;
    c.a.cLE().onAlive();
    initView();
    paramBundle = com.tencent.mm.plugin.finder.storage.data.c.sKz;
    paramBundle = c.a.cLE().cLD();
    d.g.b.p.h(paramBundle, "data");
    if (paramBundle.isEmpty())
    {
      ET(0);
      ae.i(TAG, "onCreate sessionId:" + getSessionId() + " contextId:" + UR() + " clickTabContextId:" + SB() + " fromCommentScene:" + cDV());
      AppMethodBeat.o(203156);
      return;
    }
    this.smS.clear();
    this.smS.addAll((Collection)paramBundle);
    paramBundle = bu.m((List)this.smS, ",");
    d.g.b.p.g(paramBundle, "Util.listToString(contactList, \",\")");
    this.md5 = paramBundle;
    paramBundle = this.smS;
    d.g.b.p.h(paramBundle, "addList");
    ae.i(TAG, "friend list: " + paramBundle.size());
    if (paramBundle.isEmpty()) {
      bmP();
    }
    for (;;)
    {
      this.snb = paramBundle.size();
      ET(paramBundle.size());
      break;
      Object localObject = this.gYR;
      if (localObject == null) {
        d.g.b.p.bdF("emptyTip");
      }
      ((TextView)localObject).setVisibility(8);
      localObject = this.jsM;
      if (localObject == null) {
        d.g.b.p.bdF("listView");
      }
      ((ListView)localObject).setVisibility(0);
      this.smV.dN((List)paramBundle);
      this.smV.notifyDataSetChanged();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203162);
    Object localObject1 = bu.m((List)this.smT, ";");
    arn localarn = new arn();
    localarn.sessionId = getSessionId();
    localarn.rfA = UR();
    localarn.rfo = SB();
    localarn.sch = cDV();
    Object localObject2 = i.syT;
    long l = ((Number)this.sna.getValue()).longValue();
    d.g.b.p.g(localObject1, "delUsernames");
    int i = this.snb;
    d.g.b.p.h(localarn, "contextObj");
    d.g.b.p.h("", "addUsernames");
    d.g.b.p.h(localObject1, "delUsernames");
    localObject2 = new bn();
    ((bn)localObject2).kv(localarn.sessionId);
    ((bn)localObject2).kw(localarn.rfA);
    ((bn)localObject2).kx(localarn.rfo);
    ((bn)localObject2).gb(localarn.sch);
    ((bn)localObject2).kA(com.tencent.mm.ac.c.rp(l));
    ((bn)localObject2).ky("");
    ((bn)localObject2).kz((String)localObject1);
    ((bn)localObject2).gc(i);
    ((bn)localObject2).aLH();
    i.a((com.tencent.mm.plugin.report.a)localObject2);
    com.tencent.mm.kernel.g.ajj().b(3528, (com.tencent.mm.ak.f)this);
    com.tencent.mm.kernel.g.ajj().b(3990, (com.tencent.mm.ak.f)this);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.c.sKz;
    c.a.cLE().onDetach();
    localObject1 = this.tipDialog;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.base.p)localObject1).dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(203162);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(203160);
    if ((paramn instanceof com.tencent.mm.plugin.finder.cgi.z))
    {
      ae.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        paramn = (cak)j.jm((List)((com.tencent.mm.plugin.finder.cgi.z)paramn).rRk);
        if (paramn != null)
        {
          this.smT.add(paramn.nIJ);
          paramString = this.smV;
          paramn = paramn.nIJ;
          d.g.b.p.g(paramn, "it.UserName");
          paramString.ajF(paramn);
          ET(this.smV.getCount());
          if (this.smV.getCount() <= 0) {
            bmP();
          }
          AppMethodBeat.o(203160);
          return;
        }
        AppMethodBeat.o(203160);
        return;
      }
      if (paramInt2 == -3500)
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        t.makeText((Context)this, 2131764969, 0).show();
        AppMethodBeat.o(203160);
        return;
      }
      paramString = this.tipDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      t.makeText((Context)this, 2131766439, 0).show();
    }
    AppMethodBeat.o(203160);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    b(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    c(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<Long>
  {
    e(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    f(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "blackInfo", "", "isMale", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.q<View, String, Boolean, d.z>
  {
    g(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203147);
      this.snd.finish();
      AppMethodBeat.o(203147);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    public static final i snf;
    
    static
    {
      AppMethodBeat.i(203149);
      snf = new i();
      AppMethodBeat.o(203149);
    }
    
    i()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendBlackListUI
 * JD-Core Version:    0.7.0.1
 */