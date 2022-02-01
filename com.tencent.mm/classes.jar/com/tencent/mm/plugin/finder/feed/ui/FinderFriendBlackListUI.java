package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.b.a.bb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import d.g.b.w;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "clickTabContextId", "", "getClickTabContextId", "()Ljava/lang/String;", "clickTabContextId$delegate", "Lkotlin/Lazy;", "contactList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contactListPref", "Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference;", "getContactListPref", "()Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference;", "setContactListPref", "(Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference;)V", "contextId", "getContextId", "contextId$delegate", "feedId", "", "getFeedId", "()J", "feedId$delegate", "fromCommentScene", "", "getFromCommentScene", "()I", "fromCommentScene$delegate", "lastAddList", "lastDelList", "listener", "Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference$OnContactItemClickListener;", "getListener", "()Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference$OnContactItemClickListener;", "setListener", "(Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference$OnContactItemClickListener;)V", "md5", "getMd5", "setMd5", "(Ljava/lang/String;)V", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "setScreen", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;)V", "sessionId", "getSessionId", "sessionId$delegate", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getTipDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTipDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "addAndRefresh", "", "addList", "checkBack", "", "checkNetworkAvailable", "checkNetworkAvailableMM", "dealAddMemberBtn", "dealDelChatRoomMember", "userName", "dealOnAddContact", "memBerList", "", "doConfirm", "doConfirmScene", "opList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "genMd5", "getResourceId", "initData", "data", "initPreference", "initView", "isContactExit", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "publishEvent", "unlike", "refresh", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFriendBlackListUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  static final String TAG = "Finder.FinderFriendBlackListUI";
  private static final int rpA = 1;
  public static final FinderFriendBlackListUI.a rpB;
  ContactListExpandPreference ftA;
  String md5;
  final ArrayList<String> rpr;
  final ArrayList<String> rps;
  final ArrayList<String> rpt;
  private final d.f rpu;
  private final d.f rpv;
  private final d.f rpw;
  private final d.f rpx;
  private final d.f rpy;
  private ContactListExpandPreference.a rpz;
  com.tencent.mm.ui.base.preference.f screen;
  p tipDialog;
  
  static
  {
    AppMethodBeat.i(202348);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(FinderFriendBlackListUI.class), "sessionId", "getSessionId()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bn(FinderFriendBlackListUI.class), "contextId", "getContextId()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bn(FinderFriendBlackListUI.class), "clickTabContextId", "getClickTabContextId()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bn(FinderFriendBlackListUI.class), "fromCommentScene", "getFromCommentScene()I")), (d.l.k)w.a(new d.g.b.u(w.bn(FinderFriendBlackListUI.class), "feedId", "getFeedId()J")) };
    rpB = new FinderFriendBlackListUI.a((byte)0);
    TAG = "Finder.FinderFriendBlackListUI";
    rpA = 1;
    AppMethodBeat.o(202348);
  }
  
  public FinderFriendBlackListUI()
  {
    AppMethodBeat.i(202363);
    this.rpr = new ArrayList();
    this.rps = new ArrayList();
    this.rpt = new ArrayList();
    this.md5 = "";
    this.rpu = d.g.K((d.g.a.a)l.rpE);
    this.rpv = d.g.K((d.g.a.a)new d(this));
    this.rpw = d.g.K((d.g.a.a)new c(this));
    this.rpx = d.g.K((d.g.a.a)new g(this));
    this.rpy = d.g.K((d.g.a.a)new f(this));
    this.rpz = ((ContactListExpandPreference.a)new k(this));
    AppMethodBeat.o(202363);
  }
  
  private final String QA()
  {
    AppMethodBeat.i(202351);
    String str = (String)this.rpw.getValue();
    AppMethodBeat.o(202351);
    return str;
  }
  
  private final String Sx()
  {
    AppMethodBeat.i(202350);
    String str = (String)this.rpv.getValue();
    AppMethodBeat.o(202350);
    return str;
  }
  
  private final int cvS()
  {
    AppMethodBeat.i(202352);
    int i = ((Number)this.rpx.getValue()).intValue();
    AppMethodBeat.o(202352);
    return i;
  }
  
  private final boolean cvU()
  {
    AppMethodBeat.i(202360);
    if (d.g.b.k.g(cvT(), this.md5))
    {
      finish();
      AppMethodBeat.o(202360);
      return true;
    }
    if (this.tipDialog != null) {}
    for (int i = 2131765433;; i = 2131765432)
    {
      com.tencent.mm.ui.base.h.d((Context)this, getString(i), "", getString(2131765435), getString(2131755691), (DialogInterface.OnClickListener)new b(this), null);
      AppMethodBeat.o(202360);
      return false;
    }
  }
  
  private final String getSessionId()
  {
    AppMethodBeat.i(202349);
    String str = (String)this.rpu.getValue();
    AppMethodBeat.o(202349);
    return str;
  }
  
  public final void DM(int paramInt)
  {
    AppMethodBeat.i(202357);
    setMMTitle(getString(2131766436, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(202357);
  }
  
  public final void V(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(202358);
    d.g.b.k.h(paramArrayList, "addList");
    ContactListExpandPreference localContactListExpandPreference = this.ftA;
    if (localContactListExpandPreference != null) {
      localContactListExpandPreference.eb((List)paramArrayList);
    }
    localContactListExpandPreference = this.ftA;
    if (localContactListExpandPreference != null) {
      localContactListExpandPreference.refresh();
    }
    DM(paramArrayList.size());
    paramArrayList = this.ftA;
    if (paramArrayList != null)
    {
      paramArrayList.notifyChanged();
      AppMethodBeat.o(202358);
      return;
    }
    AppMethodBeat.o(202358);
  }
  
  public final String cvT()
  {
    AppMethodBeat.i(202359);
    String str = bs.n((List)this.rpr, ",");
    d.g.b.k.g(str, "Util.listToString(contactList, \",\")");
    AppMethodBeat.o(202359);
    return str;
  }
  
  public final int getResourceId()
  {
    return 2131951768;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(202354);
    setBackBtn((MenuItem.OnMenuItemClickListener)new i(this));
    this.screen = getPreferenceScreen();
    Object localObject = this.screen;
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    localObject = ((com.tencent.mm.ui.base.preference.f)localObject).aPN("roominfo_contact_anchor");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference");
      AppMethodBeat.o(202354);
      throw ((Throwable)localObject);
    }
    this.ftA = ((ContactListExpandPreference)localObject);
    if (this.ftA != null)
    {
      localObject = this.ftA;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      com.tencent.mm.ui.base.preference.f localf = this.screen;
      ContactListExpandPreference localContactListExpandPreference = this.ftA;
      if (localContactListExpandPreference == null) {
        d.g.b.k.fOy();
      }
      ((ContactListExpandPreference)localObject).a(localf, localContactListExpandPreference.getKey());
      localObject = this.ftA;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      ((ContactListExpandPreference)localObject).vc(true).vd(true);
      localObject = this.ftA;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      ((ContactListExpandPreference)localObject).gS((List)this.rpr);
      localObject = this.ftA;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      ((ContactListExpandPreference)localObject).a((com.tencent.mm.pluginsdk.ui.applet.s.b)new h(this));
      localObject = this.ftA;
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      ((ContactListExpandPreference)localObject).a(this.rpz);
    }
    addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new j(this), null, com.tencent.mm.ui.s.b.Hom);
    enableOptionMenu(false);
    AppMethodBeat.o(202354);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(202355);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(202355);
      return;
    }
    Object localObject;
    if (paramInt1 == rpA)
    {
      if (paramIntent == null)
      {
        AppMethodBeat.o(202355);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ac.i(TAG, "onActivityResult %s", new Object[] { paramIntent });
      d.g.b.k.g(paramIntent, "userName");
      if (d.g.b.k.g(bs.nullAsNil(com.tencent.mm.model.u.axw()), paramIntent)) {
        paramInt2 = 1;
      }
      while (paramInt2 != 0)
      {
        com.tencent.mm.ui.base.h.Q((Context)this, getString(2131765431), "");
        AppMethodBeat.o(202355);
        return;
        if (this.rpr == null)
        {
          paramInt2 = 0;
        }
        else
        {
          localObject = this.rpr.iterator();
          paramInt1 = 0;
          paramInt2 = paramInt1;
          if (((Iterator)localObject).hasNext())
          {
            if (!d.g.b.k.g((String)((Iterator)localObject).next(), paramIntent)) {
              break label560;
            }
            paramInt1 = 1;
          }
        }
      }
    }
    label560:
    for (;;)
    {
      break;
      paramIntent = ((Collection)d.n.n.a((CharSequence)paramIntent, new String[] { "," })).toArray(new String[0]);
      if (paramIntent == null)
      {
        paramIntent = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(202355);
        throw paramIntent;
      }
      paramIntent = bs.S((String[])paramIntent);
      if (paramIntent == null)
      {
        AppMethodBeat.o(202355);
        return;
      }
      localObject = (List)paramIntent;
      String str1 = TAG;
      if (localObject != null) {}
      for (paramIntent = Integer.valueOf(((List)localObject).size());; paramIntent = Integer.valueOf(-1))
      {
        ac.i(str1, "dealOnAddContact %s", new Object[] { paramIntent });
        paramIntent = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(paramIntent, "MMKernel.service(IMessengerStorage::class.java)");
        paramIntent = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramIntent).awB();
        str1 = com.tencent.mm.model.u.axw();
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if ((!this.rpr.contains(str2)) && ((d.g.b.k.g(str1, str2) ^ true)))
          {
            com.tencent.mm.storage.ai localai = paramIntent.aNt(str2);
            d.g.b.k.g(localai, "cstg[user]");
            if (localai.aaE())
            {
              this.rpr.add(str2);
              this.rps.add(str2);
            }
          }
        }
      }
      if (this.rpr.size() > 0)
      {
        paramIntent = this.ftA;
        if (paramIntent == null) {
          d.g.b.k.fOy();
        }
        paramIntent.vc(true).vd(true);
      }
      for (;;)
      {
        DM(this.rpr.size());
        V(this.rpr);
        if (!d.g.b.k.g(cvT(), this.md5)) {
          break;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(202355);
        return;
        paramIntent = this.ftA;
        if (paramIntent == null) {
          d.g.b.k.fOy();
        }
        paramIntent.vc(true).vd(false);
      }
      AppMethodBeat.o(202355);
      return;
      enableOptionMenu(true);
      AppMethodBeat.o(202355);
      return;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(202356);
    cvU();
    AppMethodBeat.o(202356);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202353);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(3528, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().a(3990, (com.tencent.mm.ak.g)this);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.c.rEC;
    c.a.cBc().onAlive();
    initView();
    paramBundle = com.tencent.mm.plugin.finder.storage.data.c.rEC;
    paramBundle = c.a.cBc().cBb();
    d.g.b.k.h(paramBundle, "data");
    if (!paramBundle.isEmpty())
    {
      this.rpr.clear();
      this.rpr.addAll((Collection)paramBundle);
      this.md5 = cvT();
      V(this.rpr);
    }
    ac.i(TAG, "onCreate sessionId:" + getSessionId() + " contextId:" + Sx() + " clickTabContextId:" + QA() + " fromCommentScene:" + cvS());
    AppMethodBeat.o(202353);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202362);
    Object localObject1 = bs.n((List)this.rps, ";");
    String str = bs.n((List)this.rpt, ";");
    anm localanm = new anm();
    localanm.sessionId = getSessionId();
    localanm.qox = Sx();
    localanm.qom = QA();
    localanm.rfR = cvS();
    Object localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
    long l = ((Number)this.rpy.getValue()).longValue();
    d.g.b.k.g(localObject1, "addUsernames");
    d.g.b.k.g(str, "delUsernames");
    d.g.b.k.h(localanm, "contextObj");
    d.g.b.k.h(localObject1, "addUsernames");
    d.g.b.k.h(str, "delUsernames");
    localObject2 = new bb();
    ((bb)localObject2).iK(localanm.sessionId);
    ((bb)localObject2).iL(localanm.qox);
    ((bb)localObject2).iM(localanm.qom);
    ((bb)localObject2).eV(localanm.rfR);
    ((bb)localObject2).iP(com.tencent.mm.ac.c.pb(l));
    ((bb)localObject2).iN((String)localObject1);
    ((bb)localObject2).iO(str);
    ((bb)localObject2).aHZ();
    com.tencent.mm.plugin.finder.report.d.a((com.tencent.mm.plugin.report.a)localObject2);
    com.tencent.mm.kernel.g.agi().b(3528, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().b(3990, (com.tencent.mm.ak.g)this);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.c.rEC;
    c.a.cBc().onDetach();
    if ((this.ftA != null) && (this.ftA == null)) {
      d.g.b.k.fOy();
    }
    localObject1 = this.tipDialog;
    if (localObject1 != null) {
      ((p)localObject1).dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(202362);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(202361);
    if ((paramn instanceof com.tencent.mm.plugin.finder.cgi.t))
    {
      ac.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        finish();
        d.g.b.k.h("", "userName");
        paramString = new gy();
        paramString.dhT.dhV = "";
        paramString.dhT.dhU = 0;
        com.tencent.mm.sdk.b.a.GpY.l((b)paramString);
        AppMethodBeat.o(202361);
        return;
      }
      if (paramInt2 == -3500)
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        com.tencent.mm.ui.base.t.makeText((Context)this, 2131764969, 0).show();
        AppMethodBeat.o(202361);
        return;
      }
      paramString = this.tipDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      com.tencent.mm.ui.base.t.makeText((Context)this, 2131766439, 0).show();
    }
    AppMethodBeat.o(202361);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(202332);
      this.rpC.finish();
      AppMethodBeat.o(202332);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    c(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    d(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<Long>
  {
    f(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    g(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "parent", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "onItemLongClick"})
  static final class h
    implements com.tencent.mm.pluginsdk.ui.applet.s.b
  {
    h(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final boolean kF(int paramInt)
    {
      AppMethodBeat.i(202338);
      ContactListExpandPreference localContactListExpandPreference = this.rpC.ftA;
      if (localContactListExpandPreference == null) {
        d.g.b.k.fOy();
      }
      if (!localContactListExpandPreference.WY(paramInt)) {
        ac.d(FinderFriendBlackListUI.access$getTAG$cp(), "onItemLongClick ".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(202338);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202339);
      FinderFriendBlackListUI.a(this.rpC);
      AppMethodBeat.o(202339);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202340);
      paramMenuItem = this.rpC;
      Object localObject1 = com.tencent.mm.kernel.g.agO().agp();
      d.g.b.k.g(localObject1, "MMKernel.process().current()");
      int i;
      if (((com.tencent.mm.kernel.b.h)localObject1).ahL())
      {
        localObject1 = com.tencent.mm.kernel.g.agi();
        d.g.b.k.g(localObject1, "MMKernel.getNetSceneQueue()");
        i = ((q)localObject1).aBK();
        if ((i == 4) || (i == 6))
        {
          i = 1;
          if (i != 0) {
            break label123;
          }
          com.tencent.mm.ui.base.t.makeText((Context)paramMenuItem, 2131765430, 0).show();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(202340);
        return true;
        i = 0;
        break;
        if (ax.isConnected(com.tencent.mm.sdk.platformtools.ai.getContext())) {}
        for (i = 6;; i = 0)
        {
          if (i != 6) {
            break label118;
          }
          i = 1;
          break;
        }
        label118:
        i = 0;
        break;
        label123:
        if (d.g.b.k.g(paramMenuItem.cvT(), paramMenuItem.md5))
        {
          paramMenuItem.finish();
        }
        else
        {
          localObject1 = (Context)paramMenuItem;
          paramMenuItem.getString(2131755906);
          paramMenuItem.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject1, paramMenuItem.getString(2131765434), true, (DialogInterface.OnCancelListener)FinderFriendBlackListUI.e.rpD);
          localObject1 = new LinkedList();
          Object localObject2 = ((Iterable)paramMenuItem.rps).iterator();
          Object localObject3;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            ac.d(FinderFriendBlackListUI.TAG, "added user:".concat(String.valueOf(localObject3)));
            bvb localbvb = new bvb();
            localbvb.ncR = ((String)localObject3);
            localbvb.FkY = com.tencent.mm.plugin.i.a.d.sjj;
            localbvb.FkZ = 1;
            ((LinkedList)localObject1).add(localbvb);
          }
          paramMenuItem = ((Iterable)paramMenuItem.rpt).iterator();
          while (paramMenuItem.hasNext())
          {
            localObject2 = (String)paramMenuItem.next();
            ac.d(FinderFriendBlackListUI.TAG, "deleted user:".concat(String.valueOf(localObject2)));
            localObject3 = new bvb();
            ((bvb)localObject3).ncR = ((String)localObject2);
            ((bvb)localObject3).FkY = com.tencent.mm.plugin.i.a.d.sjj;
            ((bvb)localObject3).FkZ = 2;
            ((LinkedList)localObject1).add(localObject3);
          }
          d.g.b.k.h(localObject1, "opList");
          paramMenuItem = new com.tencent.mm.plugin.finder.cgi.t((LinkedList)localObject1);
          com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)paramMenuItem);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI$listener$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference$OnContactItemClickListener;", "onItemAddClick", "", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "position", "", "onItemCancelClick", "onItemDelClick", "onItemMoreClick", "onItemNormalClick", "plugin-finder_release"})
  public static final class k
    implements ContactListExpandPreference.a
  {
    public final void a(ViewGroup paramViewGroup, View paramView, int paramInt)
    {
      AppMethodBeat.i(202342);
      d.g.b.k.h(paramViewGroup, "parent");
      d.g.b.k.h(paramView, "view");
      paramViewGroup = this.rpC.ftA;
      if (paramViewGroup == null) {
        d.g.b.k.fOy();
      }
      paramView = paramViewGroup.Xb(paramInt);
      ac.i(FinderFriendBlackListUI.access$getTAG$cp(), "roomPref del " + paramInt + " userName : " + paramView);
      paramViewGroup = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramViewGroup, "MMKernel.storage()");
      paramViewGroup = paramViewGroup.agA().get(2);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(202342);
        throw paramViewGroup;
      }
      if (d.g.b.k.g(bs.bG((String)paramViewGroup, ""), paramView))
      {
        com.tencent.mm.ui.base.h.Q((Context)this.rpC.getContext(), this.rpC.getString(2131762613), "");
        AppMethodBeat.o(202342);
        return;
      }
      paramViewGroup = this.rpC;
      ac.i(FinderFriendBlackListUI.TAG, "dealDelChatRoomMember");
      if ((paramView == null) || (d.g.b.k.g(paramView, "")))
      {
        if (d.g.b.k.g(this.rpC.cvT(), this.rpC.md5))
        {
          this.rpC.enableOptionMenu(false);
          AppMethodBeat.o(202342);
        }
      }
      else
      {
        if (paramViewGroup.rps.contains(paramView))
        {
          paramViewGroup.rps.remove(paramView);
          label236:
          paramViewGroup.rpr.remove(paramView);
          if ((paramViewGroup.rpr.size() != 0) || (paramViewGroup.ftA == null)) {
            break label363;
          }
          paramView = paramViewGroup.ftA;
          if (paramView == null) {
            d.g.b.k.fOy();
          }
          paramView.eNI();
          paramView = paramViewGroup.ftA;
          if (paramView == null) {
            d.g.b.k.fOy();
          }
          paramView.vc(true).vd(false);
          paramView = paramViewGroup.screen;
          if (paramView == null) {
            d.g.b.k.fOy();
          }
          paramView.notifyDataSetChanged();
        }
        for (;;)
        {
          paramViewGroup.DM(paramViewGroup.rpr.size());
          paramViewGroup.V(paramViewGroup.rpr);
          break;
          if (!paramViewGroup.rpr.contains(paramView)) {
            break label236;
          }
          paramViewGroup.rpt.add(paramView);
          break label236;
          label363:
          if (paramViewGroup.ftA != null)
          {
            paramView = paramViewGroup.ftA;
            if (paramView == null) {
              d.g.b.k.fOy();
            }
            paramView.vc(true).vd(true);
          }
        }
      }
      this.rpC.enableOptionMenu(true);
      AppMethodBeat.o(202342);
    }
    
    public final void b(ViewGroup paramViewGroup, View paramView, int paramInt)
    {
      AppMethodBeat.i(202344);
      d.g.b.k.h(paramViewGroup, "parent");
      d.g.b.k.h(paramView, "view");
      paramViewGroup = this.rpC.ftA;
      if (paramViewGroup == null) {
        d.g.b.k.fOy();
      }
      paramViewGroup = paramViewGroup.Xb(paramInt);
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramViewGroup);
      com.tencent.mm.br.d.b((Context)this.rpC, "profile", ".ui.ContactInfoUI", paramView);
      AppMethodBeat.o(202344);
    }
    
    public final void c(ViewGroup paramViewGroup, View paramView, int paramInt)
    {
      AppMethodBeat.i(202343);
      d.g.b.k.h(paramViewGroup, "parent");
      d.g.b.k.h(paramView, "view");
      ac.d(FinderFriendBlackListUI.access$getTAG$cp(), "roomPref add ".concat(String.valueOf(paramInt)));
      FinderFriendBlackListUI.b(this.rpC);
      AppMethodBeat.o(202343);
    }
    
    public final void d(ViewGroup paramViewGroup, View paramView)
    {
      AppMethodBeat.i(202341);
      d.g.b.k.h(paramViewGroup, "parent");
      d.g.b.k.h(paramView, "view");
      AppMethodBeat.o(202341);
    }
    
    public final void e(ViewGroup paramViewGroup, View paramView)
    {
      AppMethodBeat.i(202345);
      d.g.b.k.h(paramViewGroup, "parent");
      d.g.b.k.h(paramView, "view");
      if (this.rpC.ftA != null)
      {
        paramViewGroup = this.rpC.ftA;
        if (paramViewGroup == null) {
          d.g.b.k.fOy();
        }
        paramViewGroup.eNI();
      }
      AppMethodBeat.o(202345);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    public static final l rpE;
    
    static
    {
      AppMethodBeat.i(202347);
      rpE = new l();
      AppMethodBeat.o(202347);
    }
    
    l()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendBlackListUI
 * JD-Core Version:    0.7.0.1
 */