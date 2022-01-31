package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.preference.RoomCardPreference;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.ks.b;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.widget.b.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@com.tencent.mm.kernel.i
public class ChatroomInfoUI
  extends MMPreference
  implements com.tencent.mm.ai.f, com.tencent.mm.bg.a, k.a, n.b
{
  private static boolean efv = false;
  private ad contact;
  private boolean czb;
  private ProgressDialog eeN;
  private boolean eeO;
  private RoomCardPreference eeP;
  private Preference eeQ;
  private Preference eeR;
  private NormalIconPreference eeS;
  private NormalIconPreference eeT;
  private ContactListExpandPreference eeU;
  private CheckBoxPreference eeV;
  private CheckBoxPreference eeW;
  private CheckBoxPreference eeX;
  private KeyValuePreference eeY;
  private CheckBoxPreference eeZ;
  private String eeu;
  private Preference efa;
  private boolean efb;
  private boolean efc;
  private boolean efd;
  private boolean efe;
  private int eff;
  private boolean efg;
  private boolean efh;
  private u efi;
  private int efj;
  private boolean efk;
  private boolean efl;
  private boolean efm;
  private boolean efn;
  private com.tencent.mm.pluginsdk.ui.d efo;
  boolean efp;
  private com.tencent.mm.sdk.b.c efq;
  int efr;
  private com.tencent.mm.ui.base.p efs;
  private String eft;
  private String efu;
  private String efw;
  private com.tencent.mm.pluginsdk.c.b efx;
  private ap efy;
  private int efz;
  private ak handler;
  private boolean isDeleteCancel;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  
  public ChatroomInfoUI()
  {
    AppMethodBeat.i(104016);
    this.eeN = null;
    this.handler = new ChatroomInfoUI.1(this, Looper.getMainLooper());
    this.sp = null;
    this.efd = false;
    this.efe = false;
    this.efh = false;
    this.efi = null;
    this.efj = -1;
    this.efk = true;
    this.efl = false;
    this.efm = false;
    this.efn = false;
    this.efo = new com.tencent.mm.pluginsdk.ui.d(new ChatroomInfoUI.11(this));
    this.efp = false;
    this.efq = new ChatroomInfoUI.42(this);
    this.efr = -1;
    this.efs = null;
    this.eft = "";
    this.efw = null;
    this.efx = new com.tencent.mm.pluginsdk.c.b()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.sdk.b.b paramAnonymousb)
      {
        AppMethodBeat.i(104002);
        if ((paramAnonymousb instanceof ks))
        {
          paramAnonymousb = (ks)paramAnonymousb;
          ab.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramAnonymousInt1 + " errCode = " + paramAnonymousInt2 + " errMsg = " + paramAnonymousString);
          if (ChatroomInfoUI.x(ChatroomInfoUI.this) != null) {
            ChatroomInfoUI.x(ChatroomInfoUI.this).dismiss();
          }
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            if (paramAnonymousInt2 == -21)
            {
              com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(2131302715), ChatroomInfoUI.this.getString(2131297087), new ChatroomInfoUI.34.1(this));
              AppMethodBeat.o(104002);
              return;
            }
            com.tencent.mm.ui.base.h.b(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(2131302717), ChatroomInfoUI.this.getString(2131297087), true);
            AppMethodBeat.o(104002);
            return;
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (ChatroomInfoUI.m(ChatroomInfoUI.this) != null))
          {
            paramAnonymousString = ChatroomInfoUI.L(paramAnonymousb.cAQ.cAC);
            paramAnonymousb = ChatroomInfoUI.m(ChatroomInfoUI.this);
            if (paramAnonymousb.vUk != null)
            {
              paramAnonymousb = paramAnonymousb.vUk.vTA;
              paramAnonymousb.ai(paramAnonymousString);
              paramAnonymousb.Kc();
            }
            if (ChatroomInfoUI.f(ChatroomInfoUI.this) != null) {
              ChatroomInfoUI.f(ChatroomInfoUI.this).notifyDataSetChanged();
            }
            ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(2131361817, paramAnonymousString.size(), new Object[] { Integer.valueOf(paramAnonymousString.size()) }));
          }
          ChatroomInfoUI.j(ChatroomInfoUI.this);
        }
        AppMethodBeat.o(104002);
      }
    };
    this.isDeleteCancel = false;
    this.efy = null;
    this.efz = 0;
    AppMethodBeat.o(104016);
  }
  
  private void JA()
  {
    AppMethodBeat.i(104018);
    ab.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[] { this.eeu });
    com.tencent.mm.roomsdk.a.c.a locala = com.tencent.mm.roomsdk.a.b.aoI(this.eeu).kT(this.eeu);
    locala.b(new com.tencent.mm.roomsdk.a.b.b() {});
    locala.drn();
    AppMethodBeat.o(104018);
  }
  
  private String JB()
  {
    if (this.efi == null) {
      return "";
    }
    return this.efi.field_selfDisplayName;
  }
  
  private void JC()
  {
    AppMethodBeat.i(104028);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 7L, 1L, true);
    Object localObject = com.tencent.mm.model.n.nt(this.eeu);
    String str = bo.d((List)localObject, ",");
    if (localObject != null) {
      this.eff = ((List)localObject).size();
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("titile", getString(2131296502));
    ((Intent)localObject).putExtra("list_type", 1);
    ((Intent)localObject).putExtra("list_attr", iv(com.tencent.mm.ui.contact.t.AdU));
    ((Intent)localObject).putExtra("always_select_contact", str);
    ((Intent)localObject).putExtra("scene", 3);
    if (!ad.arg(this.contact.field_username)) {
      ((Intent)localObject).putExtra("without_openim", true);
    }
    ((Intent)localObject).putExtra("KBlockOpenImFav", com.tencent.mm.model.t.nJ(this.eeu));
    com.tencent.mm.bq.d.b(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
    AppMethodBeat.o(104028);
  }
  
  private void JD()
  {
    AppMethodBeat.i(104029);
    if (this.czb)
    {
      JC();
      AppMethodBeat.o(104029);
      return;
    }
    JN();
    AppMethodBeat.o(104029);
  }
  
  private void JE()
  {
    AppMethodBeat.i(104031);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 8L, 1L, true);
    Object localObject = com.tencent.mm.model.n.nt(this.eeu);
    String str = bo.d((List)localObject, ",");
    this.eff = ((List)localObject).size();
    localObject = new Intent();
    ((Intent)localObject).putExtra("RoomInfo_Id", this.eeu);
    ((Intent)localObject).putExtra("Is_Chatroom", true);
    ((Intent)localObject).putExtra("Chatroom_member_list", str);
    ((Intent)localObject).putExtra("room_member_count", this.eff);
    ((Intent)localObject).putExtra("Is_RoomOwner", this.efd);
    ((Intent)localObject).putExtra("list_attr", com.tencent.mm.ui.contact.t.AdU);
    ((Intent)localObject).putExtra("room_name", this.contact.field_username);
    ((Intent)localObject).putExtra("room_owner_name", this.efi.field_roomowner);
    ((Intent)localObject).setClass(this, SelectDelMemberUI.class);
    startActivityForResult((Intent)localObject, 7);
    AppMethodBeat.o(104031);
  }
  
  private String JF()
  {
    AppMethodBeat.i(104034);
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.efi.field_roomowner);
    if ((localad != null) && ((int)localad.euF > 0)) {}
    for (Object localObject2 = localad.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = kW(this.efi.field_roomowner);
      }
      localObject2 = localObject1;
      if (bo.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localad != null)
        {
          localObject2 = localObject1;
          if ((int)localad.euF > 0) {
            localObject2 = localad.Oe();
          }
        }
      }
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = this.efi.field_roomowner;
      }
      AppMethodBeat.o(104034);
      return localObject1;
    }
  }
  
  private static boolean JG()
  {
    AppMethodBeat.i(104035);
    if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(104035);
      return true;
    }
    AppMethodBeat.o(104035);
    return false;
  }
  
  private void JH()
  {
    AppMethodBeat.i(104039);
    if (this.eeU != null)
    {
      if (this.czb)
      {
        com.tencent.mm.kernel.g.RO().ac(new ChatroomInfoUI.33(this));
        AppMethodBeat.o(104039);
        return;
      }
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this.eeu);
      this.eeU.v(this.eeu, localLinkedList);
    }
    AppMethodBeat.o(104039);
  }
  
  private void JI()
  {
    AppMethodBeat.i(104040);
    if (this.contact != null)
    {
      Object localObject2 = JB();
      Object localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = r.Zp();
      }
      if (bo.isNullOrNil((String)localObject1)) {
        break label116;
      }
      this.eeY.dEM();
      this.eeY.zrB = com.tencent.mm.cb.a.ao(getContext(), 2131427873);
      KeyValuePreference localKeyValuePreference = this.eeY;
      localObject2 = localObject1;
      if (((String)localObject1).length() <= 0) {
        localObject2 = getString(2131303427);
      }
      localKeyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject2));
    }
    for (;;)
    {
      if (this.screen != null) {
        this.screen.notifyDataSetChanged();
      }
      AppMethodBeat.o(104040);
      return;
      label116:
      this.eeY.setSummary("");
    }
  }
  
  private void JJ()
  {
    AppMethodBeat.i(104041);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    boolean bool;
    if (this.czb) {
      if (this.contact.dqK == 0)
      {
        bool = true;
        this.efg = bool;
        label69:
        if (!this.efg) {
          break label154;
        }
        setTitleMuteIconVisibility(0);
        if (this.eeV != null) {
          this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
        }
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(104041);
      return;
      bool = false;
      break;
      if (this.eeO) {
        break label69;
      }
      this.efg = this.contact.DP();
      break label69;
      label154:
      setTitleMuteIconVisibility(8);
      if (this.eeV != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void JK()
  {
    AppMethodBeat.i(104042);
    Object localObject;
    RoomCardPreference localRoomCardPreference;
    if ((this.contact != null) && (this.eeP != null))
    {
      localObject = com.tencent.mm.model.n.nx(this.eeu);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label136;
      }
      this.eeP.coy = false;
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eeu);
      if (!JM()) {
        break label159;
      }
      String str = this.contact.Of();
      localRoomCardPreference = this.eeP;
      localObject = str;
      if (str.length() <= 0) {
        localObject = getString(2131303427);
      }
    }
    label136:
    label159:
    for (localRoomCardPreference.elh = com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject);; this.eeP.elh = getString(2131302711))
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(104042);
      return;
      this.eeP.coy = true;
      this.eeP.eli = com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject);
      break;
    }
  }
  
  private void JL()
  {
    AppMethodBeat.i(104043);
    if ((this.contact != null) && (this.eeQ != null))
    {
      this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eeu);
      if (JM())
      {
        String str2 = this.contact.Of();
        Preference localPreference = this.eeQ;
        String str1 = str2;
        if (str2.length() <= 0) {
          str1 = getString(2131303427);
        }
        localPreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, str1));
        if (this.screen != null) {
          this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(104043);
        return;
      }
      this.eeQ.setSummary(getString(2131302711));
    }
    AppMethodBeat.o(104043);
  }
  
  private boolean JM()
  {
    AppMethodBeat.i(104044);
    String str = this.contact.field_nickname;
    if ((!bo.isNullOrNil(str)) && (str.length() <= 50))
    {
      AppMethodBeat.o(104044);
      return true;
    }
    AppMethodBeat.o(104044);
    return false;
  }
  
  private void JN()
  {
    AppMethodBeat.i(104046);
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(10170, "1");
    Object localObject = new LinkedList();
    ((List)localObject).add(this.eeu);
    ((List)localObject).add(r.Zn());
    localObject = bo.d((List)localObject, ",");
    Intent localIntent = new Intent();
    localIntent.putExtra("titile", getString(2131296500));
    localIntent.putExtra("list_type", 0);
    localIntent.putExtra("list_attr", iv(com.tencent.mm.ui.contact.t.AdV));
    localIntent.putExtra("always_select_contact", (String)localObject);
    com.tencent.mm.bq.d.f(this, ".ui.contact.SelectContactUI", localIntent);
    AppMethodBeat.o(104046);
  }
  
  private void JO()
  {
    AppMethodBeat.i(104050);
    boolean bool;
    Object localObject;
    if (this.eeU != null)
    {
      if (this.czb)
      {
        JH();
        this.eeU.notifyChanged();
      }
    }
    else
    {
      bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).IV(this.eeu);
      if (JP()) {
        break label259;
      }
      this.screen.cl("manage_room", true);
      localObject = this.screen;
      if (bool) {
        break label254;
      }
      bool = true;
      label81:
      ((com.tencent.mm.ui.base.preference.f)localObject).cl("room_manager_view", bool);
      label91:
      if (((JP()) || (this.eff < com.tencent.mm.pluginsdk.ui.applet.j.MAX_COUNT)) && ((!JP()) || (this.eff < com.tencent.mm.pluginsdk.ui.applet.j.MAX_COUNT - 1))) {
        break label315;
      }
      this.screen.cl("see_room_member", false);
      this.eeR.setTitle(getString(2131303031));
      label154:
      if (com.tencent.mm.model.t.nK(this.eeu))
      {
        if (!JP()) {
          break label331;
        }
        this.screen.cl("manage_room", false);
      }
    }
    for (;;)
    {
      this.screen.cl("room_manager_view", true);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(104050);
      return;
      if (this.eeO) {
        break;
      }
      localObject = new LinkedList();
      ((List)localObject).add(this.eeu);
      this.eeU.v(this.eeu, (List)localObject);
      break;
      label254:
      bool = false;
      break label81;
      label259:
      this.screen.cl("room_manager_view", true);
      if (com.tencent.mm.model.n.nv(this.eeu) > 2)
      {
        this.screen.cl("manage_room", false);
        break label91;
      }
      this.screen.cl("manage_room", true);
      break label91;
      label315:
      this.screen.cl("see_room_member", true);
      break label154;
      label331:
      this.screen.cl("manage_room", true);
    }
  }
  
  private boolean JP()
  {
    AppMethodBeat.i(104055);
    if ((this.efi != null) && (this.efi.JP()))
    {
      AppMethodBeat.o(104055);
      return true;
    }
    AppMethodBeat.o(104055);
    return false;
  }
  
  public static ArrayList<ad> L(List<azx> paramList)
  {
    AppMethodBeat.i(104045);
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      AppMethodBeat.o(104045);
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      azx localazx = (azx)paramList.next();
      ad localad = new ad();
      localad.setUsername(localazx.jJA);
      localad.jp(localazx.jKG);
      localArrayList.add(localad);
    }
    AppMethodBeat.o(104045);
    return localArrayList;
  }
  
  private static List<String> M(List<String> paramList)
  {
    AppMethodBeat.i(104048);
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(104048);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(104048);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.euF != 0) {
          paramList = localad.Of();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(104048);
    return localLinkedList;
  }
  
  private void bD(Context paramContext)
  {
    AppMethodBeat.i(104036);
    if (paramContext == null)
    {
      AppMethodBeat.o(104036);
      return;
    }
    if (JG())
    {
      paramContext = new Intent();
      paramContext.putExtra("rawUrl", getString(2131298131, new Object[] { aa.dsG() }));
      paramContext.putExtra("geta8key_username", r.Zn());
      paramContext.putExtra("showShare", false);
      com.tencent.mm.bq.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramContext);
    }
    AppMethodBeat.o(104036);
  }
  
  private void bJ(boolean paramBoolean)
  {
    AppMethodBeat.i(104027);
    bf.a(this.eeu, new ChatroomInfoUI.18(this));
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yz().c(new com.tencent.mm.chatroom.e.a(this.eeu));
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arF(this.eeu);
    com.tencent.mm.roomsdk.a.b.aoI(this.eeu).kU(this.eeu).drn();
    com.tencent.mm.model.n.nr(this.eeu);
    if (!paramBoolean) {
      this.handler.post(new ChatroomInfoUI.36(this));
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.setComponent(new ComponentName(getPackageName(), ah.dsO() + ".ui.LauncherUI"));
    startActivity(localIntent);
    finish();
    AppMethodBeat.o(104027);
  }
  
  private void d(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(104037);
    if ((paramList != null) && (paramList.size() > 0))
    {
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramList.size())
      {
        localLinkedList.add(paramList.get(i));
        i += 1;
      }
      paramList = "weixin://findfriend/verifycontact/" + paramString + "/";
      com.tencent.mm.model.m.a(paramString, localLinkedList, getString(2131298139), true, paramList);
    }
    AppMethodBeat.o(104037);
  }
  
  private void e(final String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(104032);
    if ((com.tencent.mm.model.t.nJ(this.eeu)) && (!com.tencent.mm.model.m.ni(paramString1)))
    {
      com.tencent.mm.ui.base.h.b(this, getString(2131302733), getString(2131297087), true);
      AppMethodBeat.o(104032);
      return;
    }
    if (kX(paramString1))
    {
      com.tencent.mm.ui.base.h.b(this, getString(2131296426), getString(2131297087), true);
      AppMethodBeat.o(104032);
      return;
    }
    paramString1 = bo.P(paramString1.split(","));
    if (paramString1 == null)
    {
      AppMethodBeat.o(104032);
      return;
    }
    paramString1 = com.tencent.mm.roomsdk.a.b.aoI(this.eeu).a(this.eeu, paramString1, paramString2);
    paramString1.d(new ChatroomInfoUI.23(this));
    getString(2131297087);
    paramString1.a(this, getString(paramInt), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(103990);
        paramString1.cancel();
        AppMethodBeat.o(103990);
      }
    });
    AppMethodBeat.o(104032);
  }
  
  private int iv(int paramInt)
  {
    AppMethodBeat.i(104030);
    if (!com.tencent.mm.ui.contact.t.dMi())
    {
      AppMethodBeat.o(104030);
      return paramInt;
    }
    if (this.contact != null)
    {
      String str = this.contact.field_username;
      if ((ad.arf(str)) || (ad.arg(str)))
      {
        AppMethodBeat.o(104030);
        return paramInt | 0x1000000;
      }
      AppMethodBeat.o(104030);
      return paramInt & 0xFEFFFFFF;
    }
    AppMethodBeat.o(104030);
    return paramInt;
  }
  
  private void kV(String paramString)
  {
    AppMethodBeat.i(104021);
    int i = this.screen.atz(paramString);
    getListView().smoothScrollToPosition(i);
    new ak().postDelayed(new ChatroomInfoUI.43(this, i), 10L);
    AppMethodBeat.o(104021);
  }
  
  private String kW(String paramString)
  {
    AppMethodBeat.i(104033);
    if (this.efi == null)
    {
      AppMethodBeat.o(104033);
      return null;
    }
    paramString = this.efi.nE(paramString);
    AppMethodBeat.o(104033);
    return paramString;
  }
  
  private boolean kX(String paramString)
  {
    AppMethodBeat.i(104047);
    if (bo.nullAsNil(r.Zn()).equals(paramString))
    {
      AppMethodBeat.o(104047);
      return true;
    }
    Object localObject = com.tencent.mm.model.n.nt(this.eeu);
    if (localObject == null)
    {
      AppMethodBeat.o(104047);
      return false;
    }
    localObject = ((List)localObject).iterator();
    boolean bool = false;
    if (((Iterator)localObject).hasNext())
    {
      if (!((String)((Iterator)localObject).next()).equals(paramString)) {
        break label94;
      }
      bool = true;
    }
    label94:
    for (;;)
    {
      break;
      AppMethodBeat.o(104047);
      return bool;
    }
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(104038);
    if (this.czb)
    {
      this.eff = com.tencent.mm.model.n.nv(this.eeu);
      if (this.eff == 0)
      {
        setMMTitle(getString(2131302817));
        AppMethodBeat.o(104038);
        return;
      }
      setMMTitle(getString(2131300029, new Object[] { getString(2131302817), Integer.valueOf(this.eff) }));
    }
    AppMethodBeat.o(104038);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(104051);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(104051);
      return;
    }
    a((String)paramObject, null);
    AppMethodBeat.o(104051);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(104052);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(104052);
      return;
    }
    if (!com.tencent.mm.model.t.lA(paramString))
    {
      ab.d("MicroMsg.ChatroomInfoUI", "event:" + paramString + " cancel");
      AppMethodBeat.o(104052);
      return;
    }
    ab.d("MicroMsg.ChatroomInfoUI", "event:".concat(String.valueOf(paramString)));
    if ((this.czb) && (paramString.equals(this.eeu))) {
      com.tencent.mm.kernel.g.RO().ac(new ChatroomInfoUI.37(this));
    }
    JO();
    AppMethodBeat.o(104052);
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(104054);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(104054);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return 2131165264;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104025);
    this.screen = getPreferenceScreen();
    Object localObject1;
    label97:
    boolean bool;
    if (this.czb) {
      if (this.eff == 0)
      {
        setMMTitle(getString(2131302817));
        localObject1 = null;
        if (this.efi != null)
        {
          localObject1 = this.efi.field_roomowner;
          this.eff = this.efi.afx().size();
        }
        if (!bo.isNullOrNil((String)localObject1)) {
          break label1234;
        }
        this.efc = false;
        this.efd = false;
        this.efe = false;
        ab.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
        this.eeU = ((ContactListExpandPreference)this.screen.atx("roominfo_contact_anchor"));
        this.eeU.a(this.screen, this.eeU.mKey);
        this.eeT = ((NormalIconPreference)this.screen.atx("del_selector_btn"));
        this.eeS = ((NormalIconPreference)this.screen.atx("add_selector_btn"));
        this.eeQ = this.screen.atx("room_name");
        this.eeP = ((RoomCardPreference)this.screen.atx("room_card"));
        this.eeR = this.screen.atx("see_room_member");
        this.eeV = ((CheckBoxPreference)this.screen.atx("room_notify_new_msg"));
        this.eeW = ((CheckBoxPreference)this.screen.atx("room_save_to_contact"));
        this.eeX = ((CheckBoxPreference)this.screen.atx("room_placed_to_the_top"));
        this.eeY = ((KeyValuePreference)this.screen.atx("room_nickname"));
        this.efa = this.screen.atx("manage_room");
        this.eeU.pf(true).pg(true).dnI();
        bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).IV(this.eeu);
        if (JP()) {
          break label1259;
        }
        this.screen.cl("manage_room", true);
        localObject1 = this.screen;
        if (bool) {
          break label1254;
        }
        bool = true;
        label390:
        ((com.tencent.mm.ui.base.preference.f)localObject1).cl("room_manager_view", bool);
        label401:
        if (com.tencent.mm.model.t.nK(this.eeu))
        {
          if (!JP()) {
            break label1315;
          }
          this.screen.cl("manage_room", false);
        }
        label431:
        if (this.efi != null)
        {
          this.eeU.amp(this.efi.field_roomowner);
          if (!bo.isNullOrNil(this.efi.field_roomowner)) {
            this.eeU.vUk.vTA.vUa = true;
          }
        }
        this.eeU.dnH();
        this.eeU.dnB();
        this.screen.cl("add_selector_btn", true);
        this.screen.cl("del_selector_btn", true);
        this.screen.cl("room_name", false);
        this.screen.cl("room_qr_code", false);
        this.screen.cl("chatroom_info_chexboxes", true);
        this.screen.cl("room_card", false);
        this.screen.cl("room_upgrade_entry", true);
        this.screen.cl("chat_room_story_videos", true);
        if (((JP()) || (this.eff < com.tencent.mm.pluginsdk.ui.applet.j.MAX_COUNT)) && ((!JP()) || (this.eff < com.tencent.mm.pluginsdk.ui.applet.j.MAX_COUNT - 1))) {
          break label1331;
        }
        this.screen.cl("see_room_member", false);
        this.eeR.setTitle(getString(2131303031));
        label660:
        if (ad.arg(this.eeu)) {
          break label1347;
        }
        this.screen.cl("room_openim_about", true);
        label683:
        ab.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.eeX != null)
        {
          if (this.contact == null) {
            break label1459;
          }
          this.sp.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arP(this.contact.field_username)).commit();
        }
        label793:
        this.screen.notifyDataSetChanged();
        ab.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.eeW == null) {
          break label1517;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eeu);
        if (localObject1 != null) {
          break label1486;
        }
        ab.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
        label894:
        ab.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
        if (this.sp == null) {
          this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.eeu);
        if (localObject1 != null) {
          break label1529;
        }
        ab.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
        label979:
        this.efj = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().TB(this.eeu);
        this.efj = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().TB(this.eeu);
      }
    }
    for (;;)
    {
      if (this.eeU != null)
      {
        if ((!this.czb) && (this.eeO)) {
          this.eeU.ah(new ArrayList());
        }
        getListView().setOnScrollListener(this.efo);
        this.eeU.a(this.efo);
        this.eeU.a(new ChatroomInfoUI.45(this));
        localObject1 = this.eeU;
        localObject2 = new ChatroomInfoUI.2(this);
        if (((ContactListExpandPreference)localObject1).vUk != null) {
          ((ContactListExpandPreference)localObject1).vUk.qaq = ((View.OnClickListener)localObject2);
        }
        this.eeU.a(new ChatroomInfoUI.3(this));
      }
      setBackBtn(new ChatroomInfoUI.4(this));
      AppMethodBeat.o(104025);
      return;
      if (this.efi != null) {
        this.eff = this.efi.afx().size();
      }
      setMMTitle(getString(2131300029, new Object[] { getString(2131302817), Integer.valueOf(this.eff) }));
      break;
      label1234:
      this.efc = true;
      this.efd = ((String)localObject1).equals(r.Zn());
      break label97;
      label1254:
      bool = false;
      break label390;
      label1259:
      this.screen.cl("room_manager_view", true);
      if (com.tencent.mm.model.n.nv(this.eeu) > 2)
      {
        this.screen.cl("manage_room", false);
        break label401;
      }
      this.screen.cl("manage_room", true);
      break label401;
      label1315:
      this.screen.cl("manage_room", true);
      break label431;
      label1331:
      this.screen.cl("see_room_member", true);
      break label660;
      label1347:
      this.screen.cl("chatroom_bottom_pc", true);
      this.screen.cl("room_openim_about", false);
      localObject1 = getString(2131302752);
      Object localObject2 = getString(2131302753);
      int i = ((String)localObject1).lastIndexOf((String)localObject2);
      if (i < 0) {
        break label683;
      }
      int j = ((String)localObject2).length();
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).setSpan(new ChatroomInfoUI.5(this), i, j + i, 18);
      this.screen.atx("room_openim_about").setTitle((CharSequence)localObject1);
      break label683;
      label1459:
      this.sp.edit().putBoolean("room_placed_to_the_top", false).commit();
      break label793;
      label1486:
      this.sp.edit().putBoolean("room_save_to_contact", com.tencent.mm.n.a.je(((aq)localObject1).field_type)).commit();
      label1517:
      this.screen.notifyDataSetChanged();
      break label894;
      label1529:
      this.efb = ((u)localObject1).dws();
      this.eeZ = ((CheckBoxPreference)this.screen.atx("room_msg_show_username"));
      if (this.eeZ != null) {
        this.sp.edit().putBoolean("room_msg_show_username", this.efb).commit();
      }
      this.screen.notifyDataSetChanged();
      break label979;
      if (this.eeO)
      {
        this.efd = false;
        this.efe = false;
        setMMTitle(getString(2131302718));
        this.eeU = ((ContactListExpandPreference)this.screen.atx("roominfo_contact_anchor"));
        this.eeU.a(this.screen, this.eeU.mKey);
        this.eeU.pf(false).pg(false);
        this.eeU.a(new ChatroomInfoUI.6(this));
        this.screen.removeAll();
        this.screen.b(new PreferenceCategory(this));
        this.screen.b(this.eeU);
        localObject1 = this.eeu;
        localObject2 = new ks();
        ((ks)localObject2).cAP.cyQ = ((String)localObject1);
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
        getString(2131297087);
        this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131302716), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(104003);
            ChatroomInfoUI.a(this.efU);
            AppMethodBeat.o(104003);
          }
        });
        this.screen.notifyDataSetChanged();
      }
    }
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(104053);
    if ((paramString1.equals(this.eeu)) && (this.eeU != null)) {
      this.eeU.notifyChanged();
    }
    AppMethodBeat.o(104053);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(104024);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104024);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(104024);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.eeu);
      if (localObject == null) {
        break;
      }
      paramInt1 = ((u)localObject).dwq();
      if (((paramInt1 == 2) || (paramInt1 == 1)) && (!JP()))
      {
        localObject = new e.a(this).avu(getString(2131302647));
        ((e.a)localObject).AHs = getString(2131297067);
        localObject = ((e.a)localObject).rI(true).n(Boolean.TRUE);
        ((e.a)localObject).AHt = getString(2131296888);
        ((e.a)localObject).avw(getString(2131302327)).c(new ChatroomInfoUI.44(this, paramIntent)).show();
        AppMethodBeat.o(104024);
        return;
      }
      e(paramIntent, null, 2131296440);
      AppMethodBeat.o(104024);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(104024);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if ((paramIntent == null) || (paramIntent.equals("")))
      {
        AppMethodBeat.o(104024);
        return;
      }
      paramIntent = bo.P(paramIntent.split(","));
      paramIntent = com.tencent.mm.roomsdk.a.b.aoI(this.eeu).a(this.eeu, paramIntent, 0);
      paramIntent.b(new ChatroomInfoUI.19(this));
      paramIntent.c(new ChatroomInfoUI.20(this));
      getString(2131297087);
      paramIntent.a(this, getString(2131302684), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(103985);
          paramIntent.cancel();
          AppMethodBeat.o(103985);
        }
      });
      AppMethodBeat.o(104024);
      return;
      if (paramInt2 != -1) {
        break;
      }
      finish();
      AppMethodBeat.o(104024);
      return;
      if (paramInt2 != -1) {
        break;
      }
      paramIntent = paramIntent.getStringExtra("room_name");
      if (!bo.isNullOrNil(paramIntent))
      {
        com.tencent.mm.sdk.b.a.ymk.l(new uj());
        this.contact.jp(paramIntent);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().X(this.contact);
        JL();
      }
      AppMethodBeat.o(104024);
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.efr = -1;
      AppMethodBeat.o(104024);
      return;
      if (paramInt2 == -1) {
        JK();
      }
    }
    AppMethodBeat.o(104024);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(104020);
    super.onConfigurationChanged(paramConfiguration);
    this.eeU.notifyChanged();
    AppMethodBeat.o(104020);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104017);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.RK().eHt.a(480, this);
    com.tencent.mm.pluginsdk.c.b.a(ks.class.getName(), this.efx);
    paramBundle = this.efq.alive();
    Assert.assertNotNull(this);
    keep(paramBundle);
    com.tencent.mm.kernel.g.RL().Ru().a(this);
    ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().add(this);
    if (com.tencent.mm.bg.g.fUM != null) {
      com.tencent.mm.bg.g.fUM.a(this);
    }
    this.eeu = getIntent().getStringExtra("RoomInfo_Id");
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eeu);
    this.efk = true;
    this.czb = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.eeO = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.efl = getIntent().getBooleanExtra("fromChatting", false);
    this.efm = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
    this.eft = (getPackageName() + "_preferences");
    if (this.czb)
    {
      this.efi = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.eeu);
      if (this.efi != null) {
        this.efe = this.efi.aqW(r.Zn());
      }
    }
    initView();
    if (this.czb)
    {
      paramBundle = new ao.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(103988);
          if ((paramAnonymousBoolean) && (ChatroomInfoUI.b(ChatroomInfoUI.this).equals(paramAnonymousString))) {
            com.tencent.mm.kernel.g.RO().ac(new ChatroomInfoUI.22.1(this, paramAnonymousString));
          }
          AppMethodBeat.o(103988);
        }
      };
      if (this.efi == null)
      {
        ao.a.flI.a(this.eeu, "", paramBundle);
        AppMethodBeat.o(104017);
        return;
      }
      if (System.currentTimeMillis() - this.efi.field_modifytime >= 86400000L) {
        com.tencent.mm.kernel.g.RO().ac(new ChatroomInfoUI.32(this, paramBundle));
      }
    }
    AppMethodBeat.o(104017);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104023);
    if (com.tencent.mm.bg.g.fUM != null) {
      com.tencent.mm.bg.g.fUM.a(this);
    }
    com.tencent.mm.kernel.g.RL().Ru().b(this);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.kernel.g.RK().eHt.b(480, this);
    com.tencent.mm.sdk.b.a.ymk.d(this.efq);
    com.tencent.mm.pluginsdk.c.b.b(ks.class.getName(), this.efx);
    if (com.tencent.mm.kernel.g.RG())
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().b(this);
      ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().remove(this);
    }
    if (com.tencent.mm.bg.g.fUM != null) {
      com.tencent.mm.bg.g.fUM.b(this);
    }
    if (this.efy != null) {
      this.efy.stopTimer();
    }
    super.onDestroy();
    AppMethodBeat.o(104023);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104022);
    super.onPause();
    if ((this.efh) && (this.czb))
    {
      if (this.efi == null)
      {
        AppMethodBeat.o(104022);
        return;
      }
      com.tencent.mm.model.n.a(this.eeu, this.efi, this.efb);
    }
    AppMethodBeat.o(104022);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference arg2)
  {
    int j = 1;
    AppMethodBeat.i(104026);
    paramf = ???.mKey;
    if (paramf.equals("room_name"))
    {
      paramf = com.tencent.mm.m.g.Nq().getValue("ChatRoomOwnerModTopic");
      if (bo.isNullOrNil(paramf)) {
        break label2769;
      }
    }
    label573:
    label2764:
    label2769:
    for (int i = bo.apV(paramf);; i = 0)
    {
      if ((!bo.isNullOrNil(this.efi.field_roomowner)) && (i > 0) && (!JP()) && (i < this.eff)) {
        com.tencent.mm.ui.base.h.a(this, getString(2131302794, new Object[] { JF() }), null, getString(2131296977), new ChatroomInfoUI.7(this));
      }
      boolean bool1;
      for (;;)
      {
        AppMethodBeat.o(104026);
        return false;
        paramf = "";
        if (JM()) {
          paramf = this.contact.Of();
        }
        ??? = new Intent();
        ???.setClass(this, ModRemarkRoomNameUI.class);
        ???.putExtra("room_name", paramf);
        ???.putExtra("RoomInfo_Id", this.eeu);
        startActivityForResult(???, 4);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 3L, 1L, true);
        continue;
        if (paramf.equals("room_upgrade_entry"))
        {
          bD(this);
        }
        else if (paramf.equals("room_qr_code"))
        {
          if (com.tencent.mm.model.t.nK(this.eeu))
          {
            paramf = new v();
            paramf.fq(this.eeu);
            paramf.cTE = 6L;
            paramf.ake();
          }
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 5L, 1L, true);
          paramf = new Intent();
          paramf.putExtra("from_userName", this.eeu);
          com.tencent.mm.bq.d.b(this, "setting", ".ui.setting.SelfQRCodeUI", paramf);
        }
        else if (paramf.equals("room_card"))
        {
          bool1 = this.efi.aqW(r.Zn());
          if ((bo.isNullOrNil(com.tencent.mm.model.n.nx(this.eeu))) && (!JP()))
          {
            com.tencent.mm.ui.base.h.d(this, getString(2131302672), null, getString(2131302673), null, null, null);
          }
          else
          {
            paramf = new Intent();
            paramf.setClass(this, RoomCardUI.class);
            paramf.putExtra("RoomInfo_Id", this.eeu);
            paramf.putExtra("room_name", this.eeP.elh.toString());
            this.eff = com.tencent.mm.model.n.nt(this.eeu).size();
            paramf.putExtra("room_member_count", this.eff);
            paramf.putExtra("room_owner_name", JF());
            paramf.putExtra("room_notice", com.tencent.mm.model.n.nx(this.eeu));
            paramf.putExtra("room_notice_publish_time", com.tencent.mm.model.n.nz(this.eeu));
            paramf.putExtra("room_notice_editor", com.tencent.mm.model.n.ny(this.eeu));
            paramf.putExtra("Is_RoomOwner", this.efd);
            paramf.putExtra("Is_RoomManager", bool1);
            startActivityForResult(paramf, 6);
          }
        }
        else
        {
          if (paramf.equals("room_notify_new_msg"))
          {
            if (!this.efg)
            {
              bool1 = true;
              this.efg = bool1;
              if (this.czb)
              {
                if (!this.efg) {
                  break label818;
                }
                i = 0;
                label595:
                com.tencent.mm.roomsdk.a.b.aoI(this.eeu).E(this.eeu, i).drn();
                this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eeu);
                this.contact.hB(i);
                ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().b(this.eeu, this.contact);
                if (this.efn)
                {
                  paramf = com.tencent.mm.plugin.report.service.h.qsU;
                  if (!this.efg) {
                    break label823;
                  }
                  i = 14;
                  paramf.cT(869, i);
                }
              }
              paramf = com.tencent.mm.modelstat.b.fRu;
              ??? = this.eeu;
              bool1 = this.efg;
              if ((paramf.aku()) && (paramf.jdMethod_do(???)))
              {
                ??? = new IMBehavior();
                ???.opType = 1;
                ???.chattingOp = new IMBehaviorChattingOP();
                ??? = ???.chattingOp;
                if (!bool1) {
                  break label829;
                }
                i = j;
                ((IMBehaviorChattingOP)???).changeNotifyStatus = i;
              }
            }
            synchronized (paramf.lock)
            {
              paramf.fRt.oplist_.add(???);
              JJ();
              continue;
              bool1 = false;
              break label573;
              i = 1;
              break label595;
              i = 15;
              break label699;
              i = 2;
            }
          }
          if (paramf.equals("room_save_to_contact"))
          {
            if (this.sp == null) {
              this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            paramf = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eeu);
            if (paramf != null)
            {
              boolean bool2 = com.tencent.mm.n.a.je(paramf.field_type);
              ??? = this.sp.edit();
              if (!bool2)
              {
                bool1 = true;
                ???.putBoolean("room_save_to_contact", bool1).commit();
                if (!bool2) {
                  break label1031;
                }
                paramf.Ny();
                com.tencent.mm.roomsdk.a.b.aoI(this.eeu).a(paramf, false);
                com.tencent.mm.ui.base.h.bO(this, getString(2131302765));
                com.tencent.mm.modelstat.b.fRu.S(this.eeu, false);
              }
              for (;;)
              {
                this.screen.notifyDataSetChanged();
                break;
                bool1 = false;
                break label950;
                com.tencent.mm.roomsdk.a.b.aoI(this.eeu).a(paramf, true);
                com.tencent.mm.ui.base.h.bO(this, getString(2131302781));
                com.tencent.mm.modelstat.b.fRu.S(this.eeu, true);
              }
            }
          }
          else if (paramf.equals("room_placed_to_the_top"))
          {
            paramf = getSharedPreferences(this.eft, 0);
            if (this.contact != null)
            {
              if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arP(this.contact.field_username))
              {
                com.tencent.mm.model.t.y(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.fRu.c(false, this.eeu, false);
              }
              for (;;)
              {
                paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arP(this.contact.field_username)).commit();
                break;
                com.tencent.mm.model.t.x(this.contact.field_username, true);
                com.tencent.mm.modelstat.b.fRu.c(false, this.eeu, true);
              }
            }
          }
          else if (paramf.equals("room_nickname"))
          {
            ??? = JB();
            paramf = ???;
            if (bo.isNullOrNil(???)) {
              paramf = r.Zp();
            }
            com.tencent.mm.ui.base.h.a(getContext(), getString(2131302740), paramf, getString(2131302704), 32, new ChatroomInfoUI.8(this, paramf));
          }
          else
          {
            if (paramf.equals("room_msg_show_username"))
            {
              paramf = getSharedPreferences(this.eft, 0).edit();
              if (!this.efb)
              {
                bool1 = true;
                paramf.putBoolean("room_msg_show_username", bool1).commit();
                if (this.efb) {
                  break label1372;
                }
              }
              label1372:
              for (bool1 = true;; bool1 = false)
              {
                this.efb = bool1;
                this.efh = true;
                break;
                bool1 = false;
                break label1325;
              }
            }
            if (!paramf.equals("room_set_chatting_background")) {
              break;
            }
            if (com.tencent.mm.model.t.nK(this.eeu))
            {
              paramf = new v();
              paramf.fq(this.eeu);
              paramf.cTE = 9L;
              paramf.ake();
            }
            paramf = new Intent();
            paramf.putExtra("isApplyToAll", false);
            paramf.putExtra("username", this.contact.field_username);
            com.tencent.mm.bq.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
          }
        }
      }
      if (paramf.equals("room_search_chatting_content"))
      {
        if (com.tencent.mm.model.t.nK(this.eeu))
        {
          paramf = new v();
          paramf.fq(this.eeu);
          paramf.cTE = 8L;
          paramf.ake();
        }
        paramf = new Intent();
        paramf.putExtra("detail_username", this.eeu);
        com.tencent.mm.plugin.fts.a.d.c(this, ".ui.FTSChattingConvUI", paramf);
        if ((this.efi == null) || (this.efi.afx() == null)) {
          break label2764;
        }
      }
      for (i = this.efi.afx().size();; i = 0)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.qsU.e(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1) });
          break;
          if (paramf.equals("room_clear_chatting_history"))
          {
            if (com.tencent.mm.model.t.nK(this.eeu))
            {
              paramf = new v();
              paramf.fq(this.eeu);
              paramf.cTE = 11L;
              paramf.ake();
            }
            paramf = getString(2131300037);
            com.tencent.mm.ui.base.h.a(getContext(), paramf, "", getString(2131296891), getString(2131296888), new ChatroomInfoUI.10(this), null, 2131689667);
            break;
          }
          if (paramf.equals("room_report_it"))
          {
            if (com.tencent.mm.model.t.nK(this.eeu))
            {
              paramf = new v();
              paramf.fq(this.eeu);
              paramf.cTE = 10L;
              paramf.ake();
            }
            paramf = new Intent();
            paramf.putExtra("k_username", this.eeu);
            paramf.putExtra("showShare", false);
            paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(36) }));
            com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
            paramf = com.tencent.mm.modelstat.b.fRu;
            ??? = this.eeu;
            if ((!paramf.aku()) || (!paramf.jdMethod_do(???))) {
              break;
            }
            ??? = new IMBehavior();
            ((IMBehavior)???).opType = 1;
            ((IMBehavior)???).chattingOp = new IMBehaviorChattingOP();
            ((IMBehavior)???).chattingOp.expose = 1;
            synchronized (paramf.lock)
            {
              paramf.fRt.oplist_.add(???);
            }
          }
        }
        if (paramf.equals("room_del_quit"))
        {
          ab.d("MicroMsg.ChatroomInfoUI", " quit " + this.eeu);
          paramf = new tl();
          paramf.cJT.cJV = true;
          com.tencent.mm.sdk.b.a.ymk.l(paramf);
          if ((!bo.isNullOrNil(this.eeu)) && (this.eeu.equals(paramf.cJU.cJX)))
          {
            bool1 = true;
            if (!bool1) {
              break label2145;
            }
            ab.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.eeu);
          }
          label2145:
          while ((!this.efd) || (this.efi.afx().size() <= 2))
          {
            com.tencent.mm.ui.base.h.a(getContext(), getString(2131298940), "", getString(2131297018), getString(2131296888), new ChatroomInfoUI.14(this, bool1), null, 2131689667);
            break;
            bool1 = false;
            break label2061;
          }
          paramf = getString(2131302754);
          ??? = getString(2131296888);
          ??? = new ChatroomInfoUI.13(this);
          com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, ???, (h.c)???);
          break;
        }
        if (paramf.equals("add_selector_btn"))
        {
          JD();
          break;
        }
        if (paramf.equals("del_selector_btn"))
        {
          JE();
          break;
        }
        if (paramf.equals("see_room_member"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomMemberUI.class);
          paramf.putExtra("Block_list", r.Zn());
          ??? = com.tencent.mm.model.n.nt(this.eeu);
          if (??? != null) {
            this.eff = ???.size();
          }
          paramf.putExtra("Chatroom_member_list", bo.d(???, ","));
          paramf.putExtra("RoomInfo_Id", this.eeu);
          paramf.putExtra("room_owner_name", this.efi.field_roomowner);
          paramf.putExtra("Is_RoomOwner", this.efd);
          paramf.putExtra("room_member_count", this.eff);
          paramf.putExtra("Add_address_titile", getString(2131302785));
          if (this.czb)
          {
            paramf.putExtra("Contact_Scene", 14);
            label2410:
            ??? = getListView().getChildAt(0);
            if (??? != null) {
              break label2520;
            }
          }
          label2520:
          for (i = 0;; i = -???.getTop())
          {
            paramf.putExtra("offset", i);
            paramf.putExtra("first_pos", getListView().getFirstVisiblePosition());
            paramf.putExtra("room_name", this.contact.field_username);
            startActivityForResult(paramf, 5);
            this.efr = 5;
            break;
            if (!this.eeO) {
              break label2410;
            }
            paramf.putExtra("Contact_Scene", 44);
            if (r.nB(this.contact.field_username)) {
              break label2410;
            }
            paramf.putExtra("Contact_IsLBSFriend", true);
            break label2410;
          }
        }
        if (paramf.equals("manage_room"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), ManageChatroomUI.class);
          paramf.putExtra("RoomInfo_Id", this.eeu);
          paramf.putExtra("room_owner_name", this.efi.field_roomowner);
          startActivity(paramf);
          break;
        }
        if (paramf.equals("chat_room_app_brand"))
        {
          if (com.tencent.mm.model.t.nK(this.eeu))
          {
            paramf = new v();
            paramf.fq(this.eeu);
            paramf.cTE = 7L;
            paramf.ake();
          }
          paramf = new Intent();
          paramf.putExtra("Chat_User", this.eeu);
          com.tencent.mm.bq.d.f(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 25L, 1L, true);
          break;
        }
        if (paramf.equals("room_manager_view"))
        {
          paramf = new Intent();
          paramf.setClass(getContext(), SeeRoomOwnerManagerUI.class);
          paramf.putExtra("RoomInfo_Id", this.eeu);
          paramf.putExtra("room_owner_name", this.efi.field_roomowner);
          startActivity(paramf);
          break;
        }
        paramf.equals("chat_room_story_videos");
        break;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104019);
    super.onResume();
    this.screen.notifyDataSetChanged();
    Object localObject;
    boolean bool;
    if (this.efi != null)
    {
      localObject = this.efi.dwt();
      if (localObject != null)
      {
        bool = com.tencent.mm.model.n.N(this.efi.field_chatroomname, ((com.tencent.mm.j.a.a.a)localObject).elw);
        ab.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[] { this.efi.field_chatroomname, Integer.valueOf(((com.tencent.mm.j.a.a.a)localObject).elw), Integer.valueOf(this.efi.field_chatroomVersion), this.efi.field_roomowner });
      }
    }
    for (;;)
    {
      if ((com.tencent.mm.model.n.no(this.eeu)) || (bool)) {
        JA();
      }
      JK();
      updateTitle();
      JJ();
      if (this.czb)
      {
        JL();
        JI();
      }
      if (this.efk)
      {
        JH();
        this.efk = false;
      }
      localObject = getIntent().getStringExtra("need_matte_high_light_item");
      if (!this.efp)
      {
        if (!bo.isNullOrNil((String)localObject)) {
          kV((String)localObject);
        }
        this.efp = true;
      }
      if ((!bo.isNullOrNil((String)localObject)) && (((String)localObject).equals("room_notify_new_notice")) && (!this.efp))
      {
        kV("room_card");
        this.efp = true;
      }
      ab.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[] { Boolean.valueOf(this.efm) });
      if (this.efm)
      {
        this.efm = false;
        al.p(new ChatroomInfoUI.38(this), 50L);
      }
      AppMethodBeat.o(104019);
      return;
      bool = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(104049);
    ab.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    ab.d("MicroMsg.ChatroomInfoUI", "pre is " + this.eff);
    this.eff = com.tencent.mm.model.n.nv(this.eeu);
    ab.d("MicroMsg.ChatroomInfoUI", "now is " + this.eff);
    if (this.eeN != null) {
      this.eeN.dismiss();
    }
    AppMethodBeat.o(104049);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */