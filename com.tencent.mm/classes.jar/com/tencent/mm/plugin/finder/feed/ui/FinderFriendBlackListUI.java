package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hz;
import com.tencent.mm.autogen.mmdata.rpt.fw;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_REMOVE_BLACK_LIST", "", "getMENU_ID_REMOVE_BLACK_LIST", "()I", "clickTabContextId", "", "getClickTabContextId", "()Ljava/lang/String;", "clickTabContextId$delegate", "Lkotlin/Lazy;", "contactList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contextId", "getContextId", "contextId$delegate", "emptyTip", "Landroid/widget/TextView;", "enterCount", "getEnterCount", "setEnterCount", "(I)V", "feedId", "", "getFeedId", "()J", "feedId$delegate", "fromCommentScene", "getFromCommentScene", "fromCommentScene$delegate", "lastDelList", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "listView", "Landroid/widget/ListView;", "md5", "getMd5", "setMd5", "(Ljava/lang/String;)V", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "sessionId", "getSessionId", "sessionId$delegate", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getTipDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTipDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "checkNetworkAvailable", "", "checkNetworkAvailableMM", "doConfirm", "", "deleteName", "doConfirmScene", "opList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "finish", "genMd5", "getLayoutId", "initData", "data", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "publishEvent", "userName", "unlike", "refresh", "addList", "showEmptyView", "showListView", "showPopupMenu", "blackInfo", "anchor", "Landroid/view/View;", "isMale", "updateTitle", "count", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFriendBlackListUI
  extends MMFinderUI
  implements com.tencent.mm.am.h
{
  public static final FinderFriendBlackListUI.a BmN;
  private static final String TAG;
  private final j Blq;
  private final ArrayList<String> BmO;
  private final ArrayList<String> BmP;
  private final int BmQ;
  private final c BmR;
  private final j BmS;
  private final j BmT;
  private int BmU;
  private String md5;
  private final j nWN;
  private TextView njh;
  private final j odJ;
  private ListView qgc;
  private w tipDialog;
  private com.tencent.mm.ui.widget.b.a vEV;
  
  static
  {
    AppMethodBeat.i(365264);
    BmN = new FinderFriendBlackListUI.a((byte)0);
    TAG = "Finder.FinderFriendBlackListUI";
    AppMethodBeat.o(365264);
  }
  
  public FinderFriendBlackListUI()
  {
    AppMethodBeat.i(365175);
    this.BmO = new ArrayList();
    this.BmP = new ArrayList();
    this.md5 = "";
    this.BmQ = 1001;
    this.BmR = new c((Activity)this);
    this.nWN = kotlin.k.cm((kotlin.g.a.a)FinderFriendBlackListUI.g.BmW);
    this.BmS = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.odJ = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.BmT = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Blq = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(365175);
  }
  
  private void Og(int paramInt)
  {
    AppMethodBeat.i(365209);
    if (paramInt <= 0)
    {
      setMMTitle(getString(e.h.finder_liked_nolonger_see_title));
      AppMethodBeat.o(365209);
      return;
    }
    setMMTitle(getString(e.h.finder_liked_nolonger_see_count, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(365209);
  }
  
  private static final void a(FinderFriendBlackListUI paramFinderFriendBlackListUI, String paramString, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(365245);
    kotlin.g.b.s.u(paramFinderFriendBlackListUI, "this$0");
    kotlin.g.b.s.u(paramString, "$blackInfo");
    if (paramMenuItem.getItemId() == paramFinderFriendBlackListUI.BmQ)
    {
      kotlin.g.b.s.u(paramString, "deleteName");
      if (!Util.isNullOrNil(paramString))
      {
        if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
        {
          paramInt = com.tencent.mm.kernel.h.aZW().bFQ();
          if ((paramInt == 4) || (paramInt == 6)) {
            paramInt = 1;
          }
        }
        while (paramInt == 0)
        {
          aa.makeText((Context)paramFinderFriendBlackListUI, e.h.finder_black_list_loading_fail, 0).show();
          AppMethodBeat.o(365245);
          return;
          paramInt = 0;
          continue;
          if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {}
          for (paramInt = 6;; paramInt = 0)
          {
            if (paramInt != 6) {
              break label140;
            }
            paramInt = 1;
            break;
          }
          label140:
          paramInt = 0;
        }
        paramMenuItem = (Context)paramFinderFriendBlackListUI;
        paramFinderFriendBlackListUI.getString(c.g.app_tip);
        paramFinderFriendBlackListUI.tipDialog = com.tencent.mm.ui.base.k.a(paramMenuItem, paramFinderFriendBlackListUI.getString(e.h.finder_black_list_setting_loading), true, FinderFriendBlackListUI..ExternalSyntheticLambda0.INSTANCE);
        paramFinderFriendBlackListUI = new LinkedList();
        Log.d(TAG, kotlin.g.b.s.X("deleted user:", paramString));
        paramMenuItem = new dpi();
        paramMenuItem.UserName = paramString;
        paramMenuItem.aaWh = com.tencent.mm.plugin.findersdk.a.k.Hcb;
        paramMenuItem.aaWi = 2;
        paramString = ah.aiuX;
        paramFinderFriendBlackListUI.add(paramMenuItem);
        al(paramFinderFriendBlackListUI);
      }
    }
    AppMethodBeat.o(365245);
  }
  
  private static final void a(FinderFriendBlackListUI paramFinderFriendBlackListUI, boolean paramBoolean, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(365234);
    kotlin.g.b.s.u(paramFinderFriendBlackListUI, "this$0");
    int i = paramFinderFriendBlackListUI.BmQ;
    if (paramBoolean) {}
    for (paramFinderFriendBlackListUI = paramFinderFriendBlackListUI.getString(e.h.finder_liked_see_him);; paramFinderFriendBlackListUI = paramFinderFriendBlackListUI.getString(e.h.finder_liked_see_her))
    {
      paramContextMenu.add(0, i, 0, (CharSequence)paramFinderFriendBlackListUI);
      AppMethodBeat.o(365234);
      return;
    }
  }
  
  private static final boolean a(FinderFriendBlackListUI paramFinderFriendBlackListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365230);
    kotlin.g.b.s.u(paramFinderFriendBlackListUI, "this$0");
    paramFinderFriendBlackListUI.finish();
    AppMethodBeat.o(365230);
    return true;
  }
  
  private static void al(LinkedList<dpi> paramLinkedList)
  {
    AppMethodBeat.i(365225);
    kotlin.g.b.s.u(paramLinkedList, "opList");
    Object localObject = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramLinkedList.add(((dpi)((Iterator)localObject).next()).UserName);
    }
    paramLinkedList = new com.tencent.mm.modelmulti.h((List)paramLinkedList, 33554432, 2, i.aRC().getInt("MMBatchModContactTypeMaxNumForServer", 30));
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramLinkedList, 0);
    AppMethodBeat.o(365225);
  }
  
  private final String byu()
  {
    AppMethodBeat.i(365194);
    String str = (String)this.odJ.getValue();
    AppMethodBeat.o(365194);
    return str;
  }
  
  private void cul()
  {
    Object localObject2 = null;
    AppMethodBeat.i(365216);
    TextView localTextView = this.njh;
    Object localObject1 = localTextView;
    if (localTextView == null)
    {
      kotlin.g.b.s.bIx("emptyTip");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(0);
    localObject1 = this.qgc;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("listView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ListView)localObject1).setVisibility(8);
      AppMethodBeat.o(365216);
      return;
    }
  }
  
  private final String eeL()
  {
    AppMethodBeat.i(365188);
    String str = (String)this.BmS.getValue();
    AppMethodBeat.o(365188);
    return str;
  }
  
  private final int eeM()
  {
    AppMethodBeat.i(365199);
    int i = ((Number)this.BmT.getValue()).intValue();
    AppMethodBeat.o(365199);
    return i;
  }
  
  private final String getSessionId()
  {
    AppMethodBeat.i(365182);
    String str = (String)this.nWN.getValue();
    AppMethodBeat.o(365182);
    return str;
  }
  
  private static final void l(DialogInterface paramDialogInterface) {}
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(365347);
    if (!this.BmP.isEmpty())
    {
      kotlin.g.b.s.u("", "userName");
      hz localhz = new hz();
      localhz.hJq.hJs = "";
      localhz.hJq.hJr = 0;
      localhz.publish();
      Log.i(TAG, "publishEvent");
    }
    super.finish();
    AppMethodBeat.o(365347);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_friend_black_list_layout;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(365326);
    Object localObject1 = findViewById(e.e.finder_liked_list);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_liked_list)");
    this.qgc = ((ListView)localObject1);
    localObject1 = findViewById(e.e.empty_tip);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.empty_tip)");
    this.njh = ((TextView)localObject1);
    this.vEV = new com.tencent.mm.ui.widget.b.a((Context)this);
    localObject1 = this.qgc;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("listView");
      localObject1 = null;
      ((ListView)localObject1).setAdapter((ListAdapter)this.BmR);
      localObject1 = this.qgc;
      if (localObject1 != null) {
        break label169;
      }
      kotlin.g.b.s.bIx("listView");
      localObject1 = localObject2;
    }
    label169:
    for (;;)
    {
      ((ListView)localObject1).setSelector((Drawable)new ColorDrawable(0));
      this.BmR.DQi = ((q)new f(this));
      setBackBtn(new FinderFriendBlackListUI..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(365326);
      return;
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(365305);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3528, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(3990, (com.tencent.mm.am.h)this);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.d.FML;
    d.a.eZX().onAlive();
    initView();
    paramBundle = com.tencent.mm.plugin.finder.storage.data.d.FML;
    paramBundle = d.a.eZX().eZW();
    kotlin.g.b.s.u(paramBundle, "data");
    if (paramBundle.isEmpty())
    {
      Og(0);
      Log.i(TAG, "onCreate sessionId:" + getSessionId() + " contextId:" + eeL() + " clickTabContextId:" + byu() + " fromCommentScene:" + eeM());
      AppMethodBeat.o(365305);
      return;
    }
    this.BmO.clear();
    this.BmO.addAll((Collection)paramBundle);
    paramBundle = Util.listToString((List)this.BmO, ",");
    kotlin.g.b.s.s(paramBundle, "listToString(contactList, \",\")");
    this.md5 = paramBundle;
    ArrayList localArrayList = this.BmO;
    kotlin.g.b.s.u(localArrayList, "addList");
    Log.i(TAG, kotlin.g.b.s.X("friend list: ", Integer.valueOf(localArrayList.size())));
    if (localArrayList.isEmpty()) {
      cul();
    }
    for (;;)
    {
      this.BmU = localArrayList.size();
      Og(localArrayList.size());
      break;
      Object localObject2 = this.njh;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        paramBundle = null;
      }
      paramBundle.setVisibility(8);
      paramBundle = this.qgc;
      if (paramBundle == null)
      {
        kotlin.g.b.s.bIx("listView");
        paramBundle = (Bundle)localObject1;
        paramBundle.setVisibility(0);
        paramBundle = this.BmR;
        localObject1 = (List)localArrayList;
        kotlin.g.b.s.u(localObject1, "contacts");
        paramBundle.pUj.clear();
        localObject1 = ((Iterable)localObject1).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label428;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject2);
        if (localau != null)
        {
          paramBundle.pUj.add(localau);
          continue;
          break;
        }
        Log.i(paramBundle.TAG, kotlin.g.b.s.X("setLikedContactList, not exist contact: ", localObject2));
      }
      label428:
      this.BmR.notifyDataSetChanged();
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365360);
    Object localObject1 = Util.listToString((List)this.BmP, ";");
    bui localbui = new bui();
    localbui.sessionId = getSessionId();
    localbui.zIO = eeL();
    localbui.zIB = byu();
    localbui.AJo = eeM();
    Object localObject2 = z.FrZ;
    long l = ((Number)this.Blq.getValue()).longValue();
    kotlin.g.b.s.s(localObject1, "delUsernames");
    int i = this.BmU;
    kotlin.g.b.s.u(localbui, "contextObj");
    kotlin.g.b.s.u("", "addUsernames");
    kotlin.g.b.s.u(localObject1, "delUsernames");
    localObject2 = new fw();
    ((fw)localObject2).ijk = ((fw)localObject2).F("SessionId", localbui.sessionId, true);
    ((fw)localObject2).ipT = ((fw)localObject2).F("ContextId", localbui.zIO, true);
    ((fw)localObject2).ipU = ((fw)localObject2).F("ClickTabContextId", localbui.zIB, true);
    ((fw)localObject2).ipV = localbui.AJo;
    ((fw)localObject2).ivZ = ((fw)localObject2).F("FeedId", com.tencent.mm.ae.d.hF(l), true);
    ((fw)localObject2).iJs = ((fw)localObject2).F("AddUsername", "", true);
    ((fw)localObject2).iJt = ((fw)localObject2).F("DeleteUsername", (String)localObject1, true);
    ((fw)localObject2).iJu = i;
    ((fw)localObject2).bMH();
    z.a((com.tencent.mm.plugin.report.a)localObject2);
    com.tencent.mm.kernel.h.aZW().b(3528, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3990, (com.tencent.mm.am.h)this);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.d.FML;
    d.a.eZX().onDetach();
    localObject1 = this.tipDialog;
    if (localObject1 != null) {
      ((w)localObject1).dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(365360);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(365337);
    if ((paramp instanceof com.tencent.mm.modelmulti.h))
    {
      Log.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        paramString = ((com.tencent.mm.modelmulti.h)paramp).oLL;
        kotlin.g.b.s.s(paramString, "scene.names");
        paramString = (String)kotlin.a.p.oL(paramString);
        if (paramString != null)
        {
          this.BmP.add(paramString);
          this.BmR.aBa(paramString);
          Og(this.BmR.getCount());
          if (this.BmR.getCount() <= 0) {
            cul();
          }
          AppMethodBeat.o(365337);
        }
      }
      else
      {
        if (paramInt2 == -3500)
        {
          paramString = this.tipDialog;
          if (paramString != null) {
            paramString.dismiss();
          }
          aa.makeText((Context)this, e.h.finder_black_list_limit_tips, 0).show();
          AppMethodBeat.o(365337);
          return;
        }
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        aa.makeText((Context)this, e.h.finder_liked_see_failed, 0).show();
      }
    }
    AppMethodBeat.o(365337);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<String>
  {
    b(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    c(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Long>
  {
    d(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Integer>
  {
    e(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "blackInfo", "", "isMale", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements q<View, String, Boolean, ah>
  {
    f(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendBlackListUI
 * JD-Core Version:    0.7.0.1
 */