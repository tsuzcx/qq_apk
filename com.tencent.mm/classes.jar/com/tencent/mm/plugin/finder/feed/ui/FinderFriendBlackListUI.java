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
import com.tencent.mm.ad.c;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.b.a.hw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.storage.data.h.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.s.b;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.r.b;
import d.g.b.w;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "clickTabContextId", "", "getClickTabContextId", "()Ljava/lang/String;", "clickTabContextId$delegate", "Lkotlin/Lazy;", "contactList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contactListPref", "Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference;", "getContactListPref", "()Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference;", "setContactListPref", "(Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference;)V", "contextId", "getContextId", "contextId$delegate", "feedId", "", "getFeedId", "()J", "feedId$delegate", "fromCommentScene", "", "getFromCommentScene", "()I", "fromCommentScene$delegate", "lastAddList", "lastDelList", "listener", "Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference$OnContactItemClickListener;", "getListener", "()Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference$OnContactItemClickListener;", "setListener", "(Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference$OnContactItemClickListener;)V", "md5", "getMd5", "setMd5", "(Ljava/lang/String;)V", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "getScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "setScreen", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;)V", "sessionId", "getSessionId", "sessionId$delegate", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getTipDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTipDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "addAndRefresh", "", "addList", "checkBack", "", "checkNetworkAvailable", "checkNetworkAvailableMM", "dealAddMemberBtn", "dealDelChatRoomMember", "userName", "dealOnAddContact", "memBerList", "", "doConfirm", "doConfirmScene", "opList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModContactTypeInfo;", "genMd5", "getResourceId", "initData", "data", "initPreference", "initView", "isContactExit", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPreferenceTreeClick", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "publishEvent", "unlike", "refresh", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFriendBlackListUI
  extends MMPreference
  implements com.tencent.mm.al.g
{
  private static final int KRO = 1;
  public static final a KRP;
  static final String TAG = "Finder.FinderFriendBlackListUI";
  final ArrayList<String> KRH;
  final ArrayList<String> KRI;
  private final d.f KRJ;
  private final d.f KRK;
  private final d.f KRL;
  private final d.f KRM;
  private final d.f KRN;
  ContactListExpandPreference fpW;
  String md5;
  final ArrayList<String> qHA;
  com.tencent.mm.ui.base.preference.f screen;
  p tipDialog;
  private ContactListExpandPreference.a xFd;
  
  static
  {
    AppMethodBeat.i(198435);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(FinderFriendBlackListUI.class), "sessionId", "getSessionId()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(FinderFriendBlackListUI.class), "contextId", "getContextId()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(FinderFriendBlackListUI.class), "clickTabContextId", "getClickTabContextId()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(FinderFriendBlackListUI.class), "fromCommentScene", "getFromCommentScene()I")), (d.l.k)w.a(new d.g.b.u(w.bk(FinderFriendBlackListUI.class), "feedId", "getFeedId()J")) };
    KRP = new a((byte)0);
    TAG = "Finder.FinderFriendBlackListUI";
    KRO = 1;
    AppMethodBeat.o(198435);
  }
  
  public FinderFriendBlackListUI()
  {
    AppMethodBeat.i(198450);
    this.qHA = new ArrayList();
    this.KRH = new ArrayList();
    this.KRI = new ArrayList();
    this.md5 = "";
    this.KRJ = d.g.E((d.g.a.a)l.KRS);
    this.KRK = d.g.E((d.g.a.a)new d(this));
    this.KRL = d.g.E((d.g.a.a)new c(this));
    this.KRM = d.g.E((d.g.a.a)new g(this));
    this.KRN = d.g.E((d.g.a.a)new f(this));
    this.xFd = ((ContactListExpandPreference.a)new k(this));
    AppMethodBeat.o(198450);
  }
  
  private final String bQT()
  {
    AppMethodBeat.i(198437);
    String str = (String)this.KRK.getValue();
    AppMethodBeat.o(198437);
    return str;
  }
  
  private final String bsB()
  {
    AppMethodBeat.i(198438);
    String str = (String)this.KRL.getValue();
    AppMethodBeat.o(198438);
    return str;
  }
  
  private final boolean dOw()
  {
    AppMethodBeat.i(198447);
    if (d.g.b.k.g(fTH(), this.md5))
    {
      finish();
      AppMethodBeat.o(198447);
      return true;
    }
    if (this.tipDialog != null) {}
    for (int i = 2131764274;; i = 2131764205)
    {
      com.tencent.mm.ui.base.h.d((Context)this, getString(i), "", getString(2131764440), getString(2131755691), (DialogInterface.OnClickListener)new b(this), null);
      AppMethodBeat.o(198447);
      return false;
    }
  }
  
  private final int fTG()
  {
    AppMethodBeat.i(198439);
    int i = ((Number)this.KRM.getValue()).intValue();
    AppMethodBeat.o(198439);
    return i;
  }
  
  private final String getSessionId()
  {
    AppMethodBeat.i(198436);
    String str = (String)this.KRJ.getValue();
    AppMethodBeat.o(198436);
    return str;
  }
  
  public final void aW(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(198445);
    d.g.b.k.h(paramArrayList, "addList");
    ContactListExpandPreference localContactListExpandPreference = this.fpW;
    if (localContactListExpandPreference != null) {
      localContactListExpandPreference.dX((List)paramArrayList);
    }
    localContactListExpandPreference = this.fpW;
    if (localContactListExpandPreference != null) {
      localContactListExpandPreference.refresh();
    }
    ahl(paramArrayList.size());
    paramArrayList = this.fpW;
    if (paramArrayList != null)
    {
      paramArrayList.notifyChanged();
      AppMethodBeat.o(198445);
      return;
    }
    AppMethodBeat.o(198445);
  }
  
  public final void ahl(int paramInt)
  {
    AppMethodBeat.i(198444);
    setMMTitle(getString(2131766423, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(198444);
  }
  
  public final String fTH()
  {
    AppMethodBeat.i(198446);
    String str = bt.n((List)this.qHA, ",");
    d.g.b.k.g(str, "Util.listToString(contactList, \",\")");
    AppMethodBeat.o(198446);
    return str;
  }
  
  public final int getResourceId()
  {
    return 2131951768;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(198441);
    setBackBtn((MenuItem.OnMenuItemClickListener)new i(this));
    this.screen = getPreferenceScreen();
    Object localObject = this.screen;
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    localObject = ((com.tencent.mm.ui.base.preference.f)localObject).aKk("roominfo_contact_anchor");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference");
      AppMethodBeat.o(198441);
      throw ((Throwable)localObject);
    }
    this.fpW = ((ContactListExpandPreference)localObject);
    if (this.fpW != null)
    {
      localObject = this.fpW;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      com.tencent.mm.ui.base.preference.f localf = this.screen;
      ContactListExpandPreference localContactListExpandPreference = this.fpW;
      if (localContactListExpandPreference == null) {
        d.g.b.k.fvU();
      }
      ((ContactListExpandPreference)localObject).a(localf, localContactListExpandPreference.getKey());
      localObject = this.fpW;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      ((ContactListExpandPreference)localObject).ub(true).uc(true);
      localObject = this.fpW;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      ((ContactListExpandPreference)localObject).jd((List)this.qHA);
      localObject = this.fpW;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      ((ContactListExpandPreference)localObject).a((s.b)new h(this));
      localObject = this.fpW;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      ((ContactListExpandPreference)localObject).a(this.xFd);
    }
    addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new j(this), null, r.b.FOB);
    enableOptionMenu(false);
    AppMethodBeat.o(198441);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(198442);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(198442);
      return;
    }
    Object localObject;
    if (paramInt1 == KRO)
    {
      if (paramIntent == null)
      {
        AppMethodBeat.o(198442);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      ad.i(TAG, "onActivityResult %s", new Object[] { paramIntent });
      d.g.b.k.g(paramIntent, "userName");
      if (d.g.b.k.g(bt.nullAsNil(com.tencent.mm.model.u.aqG()), paramIntent)) {
        paramInt2 = 1;
      }
      while (paramInt2 != 0)
      {
        com.tencent.mm.ui.base.h.R((Context)this, getString(2131763804), "");
        AppMethodBeat.o(198442);
        return;
        if (this.qHA == null)
        {
          paramInt2 = 0;
        }
        else
        {
          localObject = this.qHA.iterator();
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
        AppMethodBeat.o(198442);
        throw paramIntent;
      }
      paramIntent = bt.S((String[])paramIntent);
      if (paramIntent == null)
      {
        AppMethodBeat.o(198442);
        return;
      }
      localObject = (List)paramIntent;
      String str1 = TAG;
      if (localObject != null) {}
      for (paramIntent = Integer.valueOf(((List)localObject).size());; paramIntent = Integer.valueOf(-1))
      {
        ad.i(str1, "dealOnAddContact %s", new Object[] { paramIntent });
        paramIntent = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
        d.g.b.k.g(paramIntent, "MMKernel.service(IMessengerStorage::class.java)");
        paramIntent = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramIntent).apM();
        str1 = com.tencent.mm.model.u.aqG();
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if ((!this.qHA.contains(str2)) && ((d.g.b.k.g(str1, str2) ^ true)))
          {
            af localaf = paramIntent.aHY(str2);
            d.g.b.k.g(localaf, "cstg[user]");
            if (localaf.ZJ())
            {
              this.qHA.add(str2);
              this.KRH.add(str2);
            }
          }
        }
      }
      if (this.qHA.size() > 0)
      {
        paramIntent = this.fpW;
        if (paramIntent == null) {
          d.g.b.k.fvU();
        }
        paramIntent.ub(true).uc(true);
      }
      for (;;)
      {
        ahl(this.qHA.size());
        aW(this.qHA);
        if (!d.g.b.k.g(fTH(), this.md5)) {
          break;
        }
        enableOptionMenu(false);
        AppMethodBeat.o(198442);
        return;
        paramIntent = this.fpW;
        if (paramIntent == null) {
          d.g.b.k.fvU();
        }
        paramIntent.ub(true).uc(false);
      }
      AppMethodBeat.o(198442);
      return;
      enableOptionMenu(true);
      AppMethodBeat.o(198442);
      return;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(198443);
    dOw();
    AppMethodBeat.o(198443);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198440);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(3528, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().a(3990, (com.tencent.mm.al.g)this);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.h.KXp;
    h.a.fVe().onAlive();
    initView();
    paramBundle = com.tencent.mm.plugin.finder.storage.data.h.KXp;
    paramBundle = h.a.fVe().fVd();
    d.g.b.k.h(paramBundle, "data");
    if (!paramBundle.isEmpty())
    {
      this.qHA.clear();
      this.qHA.addAll((Collection)paramBundle);
      this.md5 = fTH();
      aW(this.qHA);
    }
    ad.i(TAG, "onCreate sessionId:" + getSessionId() + " contextId:" + bQT() + " clickTabContextId:" + bsB() + " fromCommentScene:" + fTG());
    AppMethodBeat.o(198440);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198449);
    Object localObject1 = bt.n((List)this.KRH, ";");
    String str = bt.n((List)this.KRI, ";");
    dzp localdzp = new dzp();
    localdzp.sessionId = getSessionId();
    localdzp.qwV = bQT();
    localdzp.KHW = bsB();
    localdzp.qqE = fTG();
    Object localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
    long l = ((Number)this.KRN.getValue()).longValue();
    d.g.b.k.g(localObject1, "addUsernames");
    d.g.b.k.g(str, "delUsernames");
    d.g.b.k.h(localdzp, "contextObj");
    d.g.b.k.h(localObject1, "addUsernames");
    d.g.b.k.h(str, "delUsernames");
    localObject2 = new hw();
    ((hw)localObject2).aSv(localdzp.sessionId);
    ((hw)localObject2).aSw(localdzp.qwV);
    ((hw)localObject2).aSx(localdzp.KHW);
    ((hw)localObject2).zk(localdzp.qqE);
    ((hw)localObject2).aSA(c.ly(l));
    ((hw)localObject2).aSy((String)localObject1);
    ((hw)localObject2).aSz(str);
    ((hw)localObject2).aBj();
    com.tencent.mm.plugin.finder.report.b.a((com.tencent.mm.plugin.report.a)localObject2);
    com.tencent.mm.kernel.g.aeS().b(3528, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().b(3990, (com.tencent.mm.al.g)this);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.h.KXp;
    h.a.fVe().onDetach();
    if ((this.fpW != null) && (this.fpW == null)) {
      d.g.b.k.fvU();
    }
    localObject1 = this.tipDialog;
    if (localObject1 != null) {
      ((p)localObject1).dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(198449);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(198448);
    if ((paramn instanceof ao))
    {
      ad.i(TAG, "NetSceneBatchSetBlackList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        finish();
        d.g.b.k.h("", "userName");
        paramString = new hf();
        paramString.aaE.Imu = "";
        paramString.aaE.aBh = 0;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)paramString);
        AppMethodBeat.o(198448);
        return;
      }
      if (paramInt2 == -3500)
      {
        paramString = this.tipDialog;
        if (paramString != null) {
          paramString.dismiss();
        }
        t.makeText((Context)this, 2131763388, 0).show();
        AppMethodBeat.o(198448);
        return;
      }
      paramString = this.tipDialog;
      if (paramString != null) {
        paramString.dismiss();
      }
      t.makeText((Context)this, 2131766426, 0).show();
    }
    AppMethodBeat.o(198448);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI$Companion;", "", "()V", "REQUEST_CODE_SELECT_CONTACT", "", "getREQUEST_CODE_SELECT_CONTACT", "()I", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(198419);
      this.KRQ.finish();
      AppMethodBeat.o(198419);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    c(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    d(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class e
    implements DialogInterface.OnCancelListener
  {
    public static final e KRR;
    
    static
    {
      AppMethodBeat.i(198422);
      KRR = new e();
      AppMethodBeat.o(198422);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<Long>
  {
    f(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    g(FinderFriendBlackListUI paramFinderFriendBlackListUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "onItemLongClick"})
  static final class h
    implements s.b
  {
    h(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final boolean kL(int paramInt)
    {
      AppMethodBeat.i(198425);
      ContactListExpandPreference localContactListExpandPreference = this.KRQ.fpW;
      if (localContactListExpandPreference == null) {
        d.g.b.k.fvU();
      }
      if (!localContactListExpandPreference.UP(paramInt)) {
        ad.d(FinderFriendBlackListUI.access$getTAG$cp(), "onItemLongClick ".concat(String.valueOf(paramInt)));
      }
      AppMethodBeat.o(198425);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198426);
      FinderFriendBlackListUI.a(this.KRQ);
      AppMethodBeat.o(198426);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(FinderFriendBlackListUI paramFinderFriendBlackListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198427);
      paramMenuItem = this.KRQ;
      Object localObject1 = com.tencent.mm.kernel.g.afy().aeZ();
      d.g.b.k.g(localObject1, "MMKernel.process().current()");
      int i;
      if (((com.tencent.mm.kernel.b.h)localObject1).agu())
      {
        localObject1 = com.tencent.mm.kernel.g.aeS();
        d.g.b.k.g(localObject1, "MMKernel.getNetSceneQueue()");
        i = ((q)localObject1).auR();
        if ((i == 4) || (i == 6))
        {
          i = 1;
          if (i != 0) {
            break label123;
          }
          t.makeText((Context)paramMenuItem, 2131763448, 0).show();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(198427);
        return true;
        i = 0;
        break;
        if (ay.isConnected(aj.getContext())) {}
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
        if (d.g.b.k.g(paramMenuItem.fTH(), paramMenuItem.md5))
        {
          paramMenuItem.finish();
        }
        else
        {
          localObject1 = (Context)paramMenuItem;
          paramMenuItem.getString(2131755906);
          paramMenuItem.tipDialog = com.tencent.mm.ui.base.h.b((Context)localObject1, paramMenuItem.getString(2131764319), true, (DialogInterface.OnCancelListener)FinderFriendBlackListUI.e.KRR);
          localObject1 = new LinkedList();
          Object localObject2 = ((Iterable)paramMenuItem.KRH).iterator();
          Object localObject3;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            ad.d(FinderFriendBlackListUI.TAG, "added user:".concat(String.valueOf(localObject3)));
            bqk localbqk = new bqk();
            localbqk.mAQ = ((String)localObject3);
            localbqk.DOH = com.tencent.mm.plugin.i.a.l.Lmh;
            localbqk.DOI = 1;
            ((LinkedList)localObject1).add(localbqk);
          }
          paramMenuItem = ((Iterable)paramMenuItem.KRI).iterator();
          while (paramMenuItem.hasNext())
          {
            localObject2 = (String)paramMenuItem.next();
            ad.d(FinderFriendBlackListUI.TAG, "deleted user:".concat(String.valueOf(localObject2)));
            localObject3 = new bqk();
            ((bqk)localObject3).mAQ = ((String)localObject2);
            ((bqk)localObject3).DOH = com.tencent.mm.plugin.i.a.l.Lmh;
            ((bqk)localObject3).DOI = 2;
            ((LinkedList)localObject1).add(localObject3);
          }
          d.g.b.k.h(localObject1, "opList");
          paramMenuItem = new ao((LinkedList)localObject1);
          com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)paramMenuItem);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendBlackListUI$listener$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference$OnContactItemClickListener;", "onItemAddClick", "", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "position", "", "onItemCancelClick", "onItemDelClick", "onItemMoreClick", "onItemNormalClick", "plugin-finder_release"})
  public static final class k
    implements ContactListExpandPreference.a
  {
    public final void b(ViewGroup paramViewGroup, View paramView, int paramInt)
    {
      AppMethodBeat.i(198429);
      d.g.b.k.h(paramViewGroup, "parent");
      d.g.b.k.h(paramView, "view");
      paramViewGroup = this.KRQ.fpW;
      if (paramViewGroup == null) {
        d.g.b.k.fvU();
      }
      paramView = paramViewGroup.US(paramInt);
      ad.i(FinderFriendBlackListUI.access$getTAG$cp(), "roomPref del " + paramInt + " userName : " + paramView);
      paramViewGroup = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramViewGroup, "MMKernel.storage()");
      paramViewGroup = paramViewGroup.afk().get(2);
      if (paramViewGroup == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(198429);
        throw paramViewGroup;
      }
      if (d.g.b.k.g(bt.by((String)paramViewGroup, ""), paramView))
      {
        com.tencent.mm.ui.base.h.R((Context)this.KRQ.getContext(), this.KRQ.getString(2131762613), "");
        AppMethodBeat.o(198429);
        return;
      }
      paramViewGroup = this.KRQ;
      ad.i(FinderFriendBlackListUI.TAG, "dealDelChatRoomMember");
      if ((paramView == null) || (d.g.b.k.g(paramView, "")))
      {
        if (d.g.b.k.g(this.KRQ.fTH(), this.KRQ.md5))
        {
          this.KRQ.enableOptionMenu(false);
          AppMethodBeat.o(198429);
        }
      }
      else
      {
        if (paramViewGroup.KRH.contains(paramView))
        {
          paramViewGroup.KRH.remove(paramView);
          label236:
          paramViewGroup.qHA.remove(paramView);
          if ((paramViewGroup.qHA.size() != 0) || (paramViewGroup.fpW == null)) {
            break label363;
          }
          paramView = paramViewGroup.fpW;
          if (paramView == null) {
            d.g.b.k.fvU();
          }
          paramView.eyo();
          paramView = paramViewGroup.fpW;
          if (paramView == null) {
            d.g.b.k.fvU();
          }
          paramView.ub(true).uc(false);
          paramView = paramViewGroup.screen;
          if (paramView == null) {
            d.g.b.k.fvU();
          }
          paramView.notifyDataSetChanged();
        }
        for (;;)
        {
          paramViewGroup.ahl(paramViewGroup.qHA.size());
          paramViewGroup.aW(paramViewGroup.qHA);
          break;
          if (!paramViewGroup.qHA.contains(paramView)) {
            break label236;
          }
          paramViewGroup.KRI.add(paramView);
          break label236;
          label363:
          if (paramViewGroup.fpW != null)
          {
            paramView = paramViewGroup.fpW;
            if (paramView == null) {
              d.g.b.k.fvU();
            }
            paramView.ub(true).uc(true);
          }
        }
      }
      this.KRQ.enableOptionMenu(true);
      AppMethodBeat.o(198429);
    }
    
    public final void c(ViewGroup paramViewGroup, View paramView, int paramInt)
    {
      AppMethodBeat.i(198431);
      d.g.b.k.h(paramViewGroup, "parent");
      d.g.b.k.h(paramView, "view");
      paramViewGroup = this.KRQ.fpW;
      if (paramViewGroup == null) {
        d.g.b.k.fvU();
      }
      paramViewGroup = paramViewGroup.US(paramInt);
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramViewGroup);
      com.tencent.mm.bs.d.b((Context)this.KRQ, "profile", ".ui.ContactInfoUI", paramView);
      AppMethodBeat.o(198431);
    }
    
    public final void d(ViewGroup paramViewGroup, View paramView)
    {
      AppMethodBeat.i(198428);
      d.g.b.k.h(paramViewGroup, "parent");
      d.g.b.k.h(paramView, "view");
      AppMethodBeat.o(198428);
    }
    
    public final void d(ViewGroup paramViewGroup, View paramView, int paramInt)
    {
      AppMethodBeat.i(198430);
      d.g.b.k.h(paramViewGroup, "parent");
      d.g.b.k.h(paramView, "view");
      ad.d(FinderFriendBlackListUI.access$getTAG$cp(), "roomPref add ".concat(String.valueOf(paramInt)));
      FinderFriendBlackListUI.b(this.KRQ);
      AppMethodBeat.o(198430);
    }
    
    public final void e(ViewGroup paramViewGroup, View paramView)
    {
      AppMethodBeat.i(198432);
      d.g.b.k.h(paramViewGroup, "parent");
      d.g.b.k.h(paramView, "view");
      if (this.KRQ.fpW != null)
      {
        paramViewGroup = this.KRQ.fpW;
        if (paramViewGroup == null) {
          d.g.b.k.fvU();
        }
        paramViewGroup.eyo();
      }
      AppMethodBeat.o(198432);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    public static final l KRS;
    
    static
    {
      AppMethodBeat.i(198434);
      KRS = new l();
      AppMethodBeat.o(198434);
    }
    
    l()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendBlackListUI
 * JD-Core Version:    0.7.0.1
 */