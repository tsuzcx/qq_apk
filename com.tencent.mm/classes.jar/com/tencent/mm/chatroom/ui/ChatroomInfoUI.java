package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.chatroom.ui.preference.RoomCardPreference;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.h.a.kf;
import com.tencent.mm.h.a.kf.b;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.h.a.sq;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.af;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.protocal.c.ats;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@com.tencent.mm.kernel.j
public class ChatroomInfoUI
  extends MMPreference
  implements com.tencent.mm.ah.f, com.tencent.mm.bf.a, j.a, m.b
{
  private static boolean dnY = false;
  private boolean bRz;
  private String dmT;
  private CheckBoxPreference dnA;
  private Preference dnB;
  private AppBrandLoadIconPreference dnC;
  private SharedPreferences dnD = null;
  private boolean dnE;
  private boolean dnF;
  private boolean dnG = false;
  private boolean dnH = false;
  private int dnI;
  private boolean dnJ;
  private boolean dnK = false;
  private u dnL = null;
  private int dnM = -1;
  private boolean dnN = true;
  private boolean dnO = false;
  private boolean dnP = false;
  private boolean dnQ = false;
  private com.tencent.mm.pluginsdk.ui.d dnR = new com.tencent.mm.pluginsdk.ui.d(new ChatroomInfoUI.11(this));
  boolean dnS = false;
  private com.tencent.mm.sdk.b.c dnT = new ChatroomInfoUI.42(this);
  int dnU = -1;
  private com.tencent.mm.ui.base.p dnV = null;
  private String dnW = "";
  private String dnX;
  private String dnZ = null;
  private ProgressDialog dnm = null;
  private com.tencent.mm.ui.base.preference.f dnn;
  private boolean dno;
  private ad dnp;
  private RoomCardPreference dnq;
  private SignaturePreference dnr;
  private Preference dns;
  private NormalIconPreference dnt;
  private NormalIconPreference dnu;
  private ContactListExpandPreference dnv;
  private CheckBoxPreference dnw;
  private CheckBoxPreference dnx;
  private CheckBoxPreference dny;
  private SignaturePreference dnz;
  private com.tencent.mm.pluginsdk.c.b doa = new com.tencent.mm.pluginsdk.c.b()
  {
    public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.sdk.b.b paramAnonymousb)
    {
      if ((paramAnonymousb instanceof kf))
      {
        paramAnonymousb = (kf)paramAnonymousb;
        y.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramAnonymousInt1 + " errCode = " + paramAnonymousInt2 + " errMsg = " + paramAnonymousString);
        if (ChatroomInfoUI.x(ChatroomInfoUI.this) != null) {
          ChatroomInfoUI.x(ChatroomInfoUI.this).dismiss();
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
          break label155;
        }
        if (paramAnonymousInt2 == -21) {
          com.tencent.mm.ui.base.h.a(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(a.i.room_lbsroom_auto_quit), ChatroomInfoUI.this.getString(a.i.app_tip), new ChatroomInfoUI.34.1(this));
        }
      }
      else
      {
        return;
      }
      com.tencent.mm.ui.base.h.b(ChatroomInfoUI.this, ChatroomInfoUI.this.getString(a.i.room_lbsroom_member_loading_failed), ChatroomInfoUI.this.getString(a.i.app_tip), true);
      return;
      label155:
      if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (ChatroomInfoUI.m(ChatroomInfoUI.this) != null))
      {
        paramAnonymousString = ChatroomInfoUI.E(paramAnonymousb.bTl.bSX);
        paramAnonymousb = ChatroomInfoUI.m(ChatroomInfoUI.this);
        if (paramAnonymousb.sdh != null)
        {
          paramAnonymousb = paramAnonymousb.sdh.scu;
          paramAnonymousb.ab(paramAnonymousString);
          paramAnonymousb.notifyChanged();
        }
        if (ChatroomInfoUI.f(ChatroomInfoUI.this) != null) {
          ChatroomInfoUI.f(ChatroomInfoUI.this).notifyDataSetChanged();
        }
        ChatroomInfoUI.this.setMMTitle(ChatroomInfoUI.this.getResources().getQuantityString(a.g.room_lbsroom_member_title, paramAnonymousString.size(), new Object[] { Integer.valueOf(paramAnonymousString.size()) }));
      }
      ChatroomInfoUI.j(ChatroomInfoUI.this);
    }
  };
  private am dob = null;
  private int doc = 0;
  private ah handler = new ChatroomInfoUI.1(this, Looper.getMainLooper());
  private boolean isDeleteCancel = false;
  
  public static ArrayList<ad> E(List<ats> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ats localats = (ats)paramList.next();
      ad localad = new ad();
      localad.setUsername(localats.hPY);
      localad.dk(localats.hRf);
      localArrayList.add(localad);
    }
    return localArrayList;
  }
  
  private static List<String> F(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.DK()) {
      return localLinkedList;
    }
    if (paramList == null) {
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.dBe != 0) {
          paramList = localad.Bq();
        }
      }
      localLinkedList.add(paramList);
    }
    return localLinkedList;
  }
  
  private void ba(Context paramContext)
  {
    if (paramContext == null) {}
    while (!xo()) {
      return;
    }
    paramContext = new Intent();
    paramContext.putExtra("rawUrl", getString(a.i.chatroom_how_to_upgrade, new Object[] { x.cqJ() }));
    paramContext.putExtra("geta8key_username", q.Gj());
    paramContext.putExtra("showShare", false);
    com.tencent.mm.br.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramContext);
  }
  
  private void bj(boolean paramBoolean)
  {
    com.tencent.mm.model.bd.a(this.dmT, new ChatroomInfoUI.18(this));
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new com.tencent.mm.chatroom.e.a(this.dmT));
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abu(this.dmT);
    com.tencent.mm.roomsdk.a.b.YK(this.dmT).eN(this.dmT).cpz();
    com.tencent.mm.model.m.gI(this.dmT);
    if (!paramBoolean) {
      this.handler.post(new ChatroomInfoUI.36(this));
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(67108864);
    localIntent.setComponent(new ComponentName(getPackageName(), ae.cqQ() + ".ui.LauncherUI"));
    startActivity(localIntent);
    finish();
  }
  
  private void c(String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    if ((com.tencent.mm.model.s.ha(this.dmT)) && (!com.tencent.mm.model.l.gA(paramString1)))
    {
      com.tencent.mm.ui.base.h.b(this, getString(a.i.room_member_only_support_weixin), getString(a.i.app_tip), true);
      return;
    }
    if (bk.pm(q.Gj()).equals(paramString1)) {
      i = 1;
    }
    for (;;)
    {
      label57:
      if (i != 0)
      {
        com.tencent.mm.ui.base.h.b(this, getString(a.i.add_room_mem_memberExits), getString(a.i.app_tip), true);
        return;
        Object localObject = com.tencent.mm.model.m.gK(this.dmT);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          i = 0;
          label109:
          if (((Iterator)localObject).hasNext())
          {
            if (!((String)((Iterator)localObject).next()).equals(paramString1)) {
              break label221;
            }
            i = 1;
          }
        }
      }
    }
    label221:
    for (;;)
    {
      break label109;
      break label57;
      paramString1 = bk.G(paramString1.split(","));
      if (paramString1 == null) {
        break;
      }
      paramString1 = com.tencent.mm.roomsdk.a.b.YK(this.dmT).a(this.dmT, paramString1, paramString2);
      paramString1.d(new ChatroomInfoUI.23(this));
      getString(a.i.app_tip);
      paramString1.a(this, getString(paramInt), true, new ChatroomInfoUI.24(this, paramString1));
      return;
    }
  }
  
  private void d(String paramString, List<String> paramList)
  {
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
      com.tencent.mm.model.l.a(paramString, localLinkedList, getString(a.i.chatroom_sys_msg_invite_error_tip), true, paramList);
    }
  }
  
  private void eO(String paramString)
  {
    int i = this.dnn.adf(paramString);
    this.lwE.smoothScrollToPosition(i);
    new ah().postDelayed(new ChatroomInfoUI.43(this, i), 10L);
  }
  
  private int gg(int paramInt)
  {
    if (!com.tencent.mm.ui.contact.s.cHQ()) {}
    while (this.dnp == null) {
      return paramInt;
    }
    String str = this.dnp.field_username;
    if ((ad.aaU(str)) || (ad.aaV(str))) {
      return paramInt | 0x1000000;
    }
    return paramInt & 0xFEFFFFFF;
  }
  
  private void updateTitle()
  {
    if (this.bRz)
    {
      this.dnI = com.tencent.mm.model.m.gM(this.dmT);
      if (this.dnI == 0) {
        setMMTitle(getString(a.i.roominfo_name));
      }
    }
    else
    {
      return;
    }
    setMMTitle(getString(a.i.fmt_chatting_title_group, new Object[] { getString(a.i.roominfo_name), Integer.valueOf(this.dnI) }));
  }
  
  private void xi()
  {
    y.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[] { this.dmT });
    com.tencent.mm.roomsdk.a.c.a locala = com.tencent.mm.roomsdk.a.b.YK(this.dmT).eM(this.dmT);
    locala.b(new ChatroomInfoUI.41(this));
    locala.cpz();
  }
  
  private String xk()
  {
    if (this.dnL == null) {
      return "";
    }
    return this.dnL.field_selfDisplayName;
  }
  
  private void xl()
  {
    if (this.bRz)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 7L, 1L, true);
      localObject2 = com.tencent.mm.model.m.gK(this.dmT);
      localObject1 = bk.c((List)localObject2, ",");
      if (localObject2 != null) {
        this.dnI = ((List)localObject2).size();
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("titile", getString(a.i.address_title_select_contact));
      ((Intent)localObject2).putExtra("list_type", 1);
      ((Intent)localObject2).putExtra("list_attr", gg(com.tencent.mm.ui.contact.s.vMs));
      ((Intent)localObject2).putExtra("always_select_contact", (String)localObject1);
      ((Intent)localObject2).putExtra("scene", 3);
      ((Intent)localObject2).putExtra("KBlockOpenImFav", com.tencent.mm.model.s.ha(this.dmT));
      com.tencent.mm.br.d.c(this, ".ui.contact.SelectContactUI", (Intent)localObject2, 1);
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.aC(10170, "1");
    Object localObject1 = new LinkedList();
    ((List)localObject1).add(this.dmT);
    ((List)localObject1).add(q.Gj());
    localObject1 = bk.c((List)localObject1, ",");
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("titile", getString(a.i.address_title_launch_chatting));
    ((Intent)localObject2).putExtra("list_type", 0);
    ((Intent)localObject2).putExtra("list_attr", gg(com.tencent.mm.ui.contact.s.vMt));
    ((Intent)localObject2).putExtra("always_select_contact", (String)localObject1);
    com.tencent.mm.br.d.e(this, ".ui.contact.SelectContactUI", (Intent)localObject2);
  }
  
  private void xm()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 8L, 1L, true);
    Object localObject = com.tencent.mm.model.m.gK(this.dmT);
    String str = bk.c((List)localObject, ",");
    this.dnI = ((List)localObject).size();
    localObject = new Intent();
    ((Intent)localObject).putExtra("RoomInfo_Id", this.dmT);
    ((Intent)localObject).putExtra("Is_Chatroom", true);
    ((Intent)localObject).putExtra("Chatroom_member_list", str);
    ((Intent)localObject).putExtra("room_member_count", this.dnI);
    ((Intent)localObject).putExtra("Is_RoomOwner", this.dnG);
    ((Intent)localObject).putExtra("list_attr", com.tencent.mm.ui.contact.s.vMs);
    ((Intent)localObject).putExtra("room_name", this.dnp.field_username);
    ((Intent)localObject).putExtra("room_owner_name", this.dnL.field_roomowner);
    ((Intent)localObject).setClass(this, SelectDelMemberUI.class);
    startActivityForResult((Intent)localObject, 7);
  }
  
  private String xn()
  {
    Object localObject2 = null;
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dnL.field_roomowner);
    if ((localad != null) && ((int)localad.dBe > 0)) {}
    for (Object localObject1 = localad.field_conRemark;; localObject1 = null)
    {
      if (bk.bl((String)localObject1))
      {
        localObject1 = this.dnL.field_roomowner;
        if (this.dnL == null) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (bk.bl((String)localObject1))
        {
          localObject2 = localObject1;
          if (localad != null)
          {
            localObject2 = localObject1;
            if ((int)localad.dBe > 0) {
              localObject2 = localad.Bp();
            }
          }
        }
        localObject1 = localObject2;
        if (bk.bl((String)localObject2)) {
          localObject1 = this.dnL.field_roomowner;
        }
        return localObject1;
        localObject1 = this.dnL.gV((String)localObject1);
      }
    }
  }
  
  private static boolean xo()
  {
    return bk.getInt(com.tencent.mm.m.g.AA().getValue("ChatroomGlobalSwitch"), 1) == 1;
  }
  
  private void xp()
  {
    if (this.dnv != null)
    {
      if (this.bRz) {
        com.tencent.mm.kernel.g.DS().O(new ChatroomInfoUI.33(this));
      }
    }
    else {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(this.dmT);
    this.dnv.s(this.dmT, localLinkedList);
  }
  
  private void xq()
  {
    if (this.dnp != null)
    {
      Object localObject2 = xk();
      Object localObject1 = localObject2;
      if (bk.bl((String)localObject2)) {
        localObject1 = q.Gl();
      }
      if (bk.bl((String)localObject1)) {
        break label80;
      }
      SignaturePreference localSignaturePreference = this.dnz;
      localObject2 = localObject1;
      if (((String)localObject1).length() <= 0) {
        localObject2 = getString(a.i.settings_signature_empty);
      }
      localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject2));
    }
    for (;;)
    {
      if (this.dnn != null) {
        this.dnn.notifyDataSetChanged();
      }
      return;
      label80:
      this.dnz.setSummary("");
    }
  }
  
  private void xr()
  {
    if (this.dnD == null) {
      this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    boolean bool;
    if (this.bRz) {
      if (this.dnp.cCy == 0)
      {
        bool = true;
        this.dnJ = bool;
        label63:
        if (!this.dnJ) {
          break label142;
        }
        setTitleMuteIconVisibility(0);
        if (this.dnw != null) {
          this.dnD.edit().putBoolean("room_notify_new_msg", true).commit();
        }
      }
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      bool = false;
      break;
      if (this.dno) {
        break label63;
      }
      this.dnJ = this.dnp.Bj();
      break label63;
      label142:
      setTitleMuteIconVisibility(8);
      if (this.dnw != null) {
        this.dnD.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void xs()
  {
    Object localObject;
    RoomCardPreference localRoomCardPreference;
    if ((this.dnp != null) && (this.dnq != null))
    {
      localObject = com.tencent.mm.model.m.gO(this.dmT);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        break label123;
      }
      this.dnq.bHj = false;
      this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dmT);
      if (!xu()) {
        break label146;
      }
      String str = this.dnp.Bq();
      localRoomCardPreference = this.dnq;
      localObject = str;
      if (str.length() <= 0) {
        localObject = getString(a.i.settings_signature_empty);
      }
    }
    label146:
    for (localRoomCardPreference.dtD = com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject);; this.dnq.dtD = getString(a.i.room_has_no_topic))
    {
      this.dnn.notifyDataSetChanged();
      return;
      label123:
      this.dnq.bHj = true;
      this.dnq.dtE = com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject);
      break;
    }
  }
  
  private void xt()
  {
    if ((this.dnp != null) && (this.dnr != null))
    {
      this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dmT);
      if (!xu()) {
        break label103;
      }
      String str2 = this.dnp.Bq();
      SignaturePreference localSignaturePreference = this.dnr;
      String str1 = str2;
      if (str2.length() <= 0) {
        str1 = getString(a.i.settings_signature_empty);
      }
      localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, str1));
      if (this.dnn != null) {
        this.dnn.notifyDataSetChanged();
      }
    }
    return;
    label103:
    this.dnr.setSummary(getString(a.i.room_has_no_topic));
  }
  
  private boolean xu()
  {
    String str = this.dnp.field_nickname;
    return (!bk.bl(str)) && (str.length() <= 50);
  }
  
  private void xv()
  {
    boolean bool;
    Object localObject;
    if (this.dnv != null)
    {
      if (this.bRz)
      {
        xp();
        this.dnv.notifyChanged();
      }
    }
    else
    {
      bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).zl(this.dmT);
      if (xw()) {
        break label240;
      }
      this.dnn.bJ("manage_room", true);
      localObject = this.dnn;
      if (bool) {
        break label235;
      }
      bool = true;
      label75:
      ((com.tencent.mm.ui.base.preference.f)localObject).bJ("room_manager_view", bool);
      label85:
      if (((xw()) || (this.dnI < com.tencent.mm.pluginsdk.ui.applet.j.scD)) && ((!xw()) || (this.dnI < com.tencent.mm.pluginsdk.ui.applet.j.scD - 1))) {
        break label296;
      }
      this.dnn.bJ("see_room_member", false);
      this.dns.setTitle(getString(a.i.see_member_selector_btn));
    }
    for (;;)
    {
      if (com.tencent.mm.model.s.hb(this.dmT))
      {
        this.dnn.bJ("manage_room", true);
        this.dnn.bJ("room_manager_view", true);
      }
      this.dnn.notifyDataSetChanged();
      return;
      if (this.dno) {
        break;
      }
      localObject = new LinkedList();
      ((List)localObject).add(this.dmT);
      this.dnv.s(this.dmT, (List)localObject);
      break;
      label235:
      bool = false;
      break label75;
      label240:
      this.dnn.bJ("room_manager_view", true);
      if (com.tencent.mm.model.m.gM(this.dmT) > 2)
      {
        this.dnn.bJ("manage_room", false);
        break label85;
      }
      this.dnn.bJ("manage_room", true);
      break label85;
      label296:
      this.dnn.bJ("see_room_member", true);
    }
  }
  
  private boolean xw()
  {
    return (this.dnL != null) && (this.dnL.xw());
  }
  
  public final com.tencent.mm.ui.base.preference.h a(SharedPreferences paramSharedPreferences)
  {
    return new com.tencent.mm.ui.base.preference.a(this, paramSharedPreferences);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      y.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
      return;
    }
    a((String)paramObject, null);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    if (bk.bl(paramString)) {
      return;
    }
    if (!com.tencent.mm.model.s.fn(paramString))
    {
      y.d("MicroMsg.ChatroomInfoUI", "event:" + paramString + " cancel");
      return;
    }
    y.d("MicroMsg.ChatroomInfoUI", "event:" + paramString);
    if ((this.bRz) && (paramString.equals(this.dmT))) {
      com.tencent.mm.kernel.g.DS().O(new ChatroomInfoUI.37(this));
    }
    xv();
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, Preference arg2)
  {
    int j = 1;
    paramf = ???.mKey;
    if (paramf.equals("room_name"))
    {
      paramf = com.tencent.mm.m.g.AA().getValue("ChatRoomOwnerModTopic");
      if (bk.bl(paramf)) {
        break label2727;
      }
    }
    label801:
    label806:
    label2727:
    for (int i = bk.ZR(paramf);; i = 0)
    {
      if ((!bk.bl(this.dnL.field_roomowner)) && (i > 0) && (!xw()) && (i < this.dnI)) {
        com.tencent.mm.ui.base.h.a(this, getString(a.i.room_too_many_member_to_mod_topic, new Object[] { xn() }), null, getString(a.i.app_i_known), new ChatroomInfoUI.7(this));
      }
      boolean bool1;
      label577:
      label1008:
      do
      {
        do
        {
          return false;
          paramf = "";
          if (xu()) {
            paramf = this.dnp.Bq();
          }
          ??? = new Intent();
          ???.setClass(this, ModRemarkRoomNameUI.class);
          ???.putExtra("room_name", paramf);
          ???.putExtra("RoomInfo_Id", this.dmT);
          startActivityForResult(???, 4);
          com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 3L, 1L, true);
          return false;
          if (paramf.equals("room_upgrade_entry"))
          {
            ba(this);
            return false;
          }
          if (paramf.equals("room_qr_code"))
          {
            if (com.tencent.mm.model.s.hb(this.dmT))
            {
              paramf = new com.tencent.mm.h.b.a.m();
              paramf.ciU = this.dmT;
              paramf.ciV = 6L;
              paramf.QX();
            }
            com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 5L, 1L, true);
            paramf = new Intent();
            paramf.putExtra("from_userName", this.dmT);
            com.tencent.mm.br.d.b(this, "setting", ".ui.setting.SelfQRCodeUI", paramf);
            return false;
          }
          if (paramf.equals("room_card"))
          {
            bool1 = this.dnL.aaM(q.Gj());
            if ((bk.bl(com.tencent.mm.model.m.gO(this.dmT))) && (!xw()))
            {
              com.tencent.mm.ui.base.h.a(this, getString(a.i.room_card_only_can_edit_notice_by_owner), null, getString(a.i.room_card_only_can_edit_notice_by_owner_knowned), null, null, null);
              return false;
            }
            paramf = new Intent();
            paramf.setClass(this, RoomCardUI.class);
            paramf.putExtra("RoomInfo_Id", this.dmT);
            paramf.putExtra("room_name", this.dnq.dtD.toString());
            this.dnI = com.tencent.mm.model.m.gK(this.dmT).size();
            paramf.putExtra("room_member_count", this.dnI);
            paramf.putExtra("room_owner_name", xn());
            paramf.putExtra("room_notice", com.tencent.mm.model.m.gO(this.dmT));
            paramf.putExtra("room_notice_publish_time", com.tencent.mm.model.m.gQ(this.dmT));
            paramf.putExtra("room_notice_editor", com.tencent.mm.model.m.gP(this.dmT));
            paramf.putExtra("Is_RoomOwner", this.dnG);
            paramf.putExtra("Is_RoomManager", bool1);
            startActivityForResult(paramf, 6);
            return false;
          }
          if (paramf.equals("room_notify_new_msg"))
          {
            if (!this.dnJ) {
              bool1 = true;
            }
            for (;;)
            {
              this.dnJ = bool1;
              long l;
              if (this.bRz)
              {
                if (!this.dnJ) {
                  break label801;
                }
                i = 0;
                com.tencent.mm.roomsdk.a.b.YK(this.dmT).z(this.dmT, i).cpz();
                this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dmT);
                this.dnp.fq(i);
                ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(this.dmT, this.dnp);
                if (this.dnQ)
                {
                  paramf = com.tencent.mm.plugin.report.service.h.nFQ;
                  if (!this.dnJ) {
                    break label806;
                  }
                  l = 14L;
                  paramf.h(869L, l, 1L);
                }
              }
              paramf = com.tencent.mm.modelstat.b.eBD;
              ??? = this.dmT;
              bool1 = this.dnJ;
              if ((paramf.Rm()) && (paramf.cd(???)))
              {
                ??? = new IMBehavior();
                ???.opType = 1;
                ???.chattingOp = new IMBehaviorChattingOP();
                ??? = ???.chattingOp;
                if (!bool1) {
                  break label814;
                }
                i = j;
                ((IMBehaviorChattingOP)???).changeNotifyStatus = i;
              }
              synchronized (paramf.lock)
              {
                paramf.eBC.oplist_.add(???);
                xr();
                return false;
                bool1 = false;
                continue;
                i = 1;
                break label577;
                l = 15L;
                break label681;
                i = 2;
              }
            }
          }
          if (!paramf.equals("room_save_to_contact")) {
            break;
          }
          if (this.dnD == null) {
            this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
          }
          paramf = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dmT);
        } while (paramf == null);
        boolean bool2 = com.tencent.mm.n.a.gR(paramf.field_type);
        ??? = this.dnD.edit();
        if (!bool2)
        {
          bool1 = true;
          ???.putBoolean("room_save_to_contact", bool1).commit();
          if (!bool2) {
            break label1008;
          }
          paramf.AI();
          com.tencent.mm.roomsdk.a.b.YK(this.dmT).a(paramf, false);
          com.tencent.mm.ui.base.h.bC(this, getString(a.i.room_remove_from_group_card_ok));
          com.tencent.mm.modelstat.b.eBD.O(this.dmT, false);
        }
        for (;;)
        {
          this.dnn.notifyDataSetChanged();
          return false;
          bool1 = false;
          break;
          com.tencent.mm.roomsdk.a.b.YK(this.dmT).a(paramf, true);
          com.tencent.mm.ui.base.h.bC(this, getString(a.i.room_save_to_group_card_ok));
          com.tencent.mm.modelstat.b.eBD.O(this.dmT, true);
        }
        if (!paramf.equals("room_placed_to_the_top")) {
          break;
        }
        paramf = getSharedPreferences(this.dnW, 0);
      } while (this.dnp == null);
      label681:
      label814:
      if (((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abD(this.dnp.field_username))
      {
        com.tencent.mm.model.s.u(this.dnp.field_username, true);
        com.tencent.mm.modelstat.b.eBD.c(false, this.dmT, false);
      }
      for (;;)
      {
        paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abD(this.dnp.field_username)).commit();
        return false;
        com.tencent.mm.model.s.t(this.dnp.field_username, true);
        com.tencent.mm.modelstat.b.eBD.c(false, this.dmT, true);
      }
      if (paramf.equals("room_nickname"))
      {
        ??? = xk();
        paramf = ???;
        if (bk.bl(???)) {
          paramf = q.Gl();
        }
        com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(a.i.room_my_displayname), paramf, getString(a.i.room_edit_my_nick_tips), 32, new h.b()
        {
          public final boolean m(CharSequence paramAnonymousCharSequence)
          {
            if (paramAnonymousCharSequence == null) {}
            for (paramAnonymousCharSequence = "";; paramAnonymousCharSequence = paramAnonymousCharSequence.toString())
            {
              String str = com.tencent.mm.m.b.Ak();
              if ((bk.bl(str)) || (!paramAnonymousCharSequence.matches(".*[" + str + "].*"))) {
                break;
              }
              com.tencent.mm.ui.base.h.bC(ChatroomInfoUI.this.mController.uMN, ChatroomInfoUI.this.getString(a.i.invalid_input_character_toast, new Object[] { str }));
              return false;
            }
            if ((paramAnonymousCharSequence != null) && (!paramAnonymousCharSequence.equals(paramf))) {
              ChatroomInfoUI.a(ChatroomInfoUI.this, paramAnonymousCharSequence);
            }
            return true;
          }
        });
        return false;
      }
      if (paramf.equals("room_msg_show_username"))
      {
        paramf = getSharedPreferences(this.dnW, 0).edit();
        if (!this.dnE)
        {
          bool1 = true;
          paramf.putBoolean("room_msg_show_username", bool1).commit();
          if (this.dnE) {
            break label1347;
          }
        }
        label1347:
        for (bool1 = true;; bool1 = false)
        {
          this.dnE = bool1;
          this.dnK = true;
          return false;
          bool1 = false;
          break;
        }
      }
      if (paramf.equals("room_set_chatting_background"))
      {
        if (com.tencent.mm.model.s.hb(this.dmT))
        {
          paramf = new com.tencent.mm.h.b.a.m();
          paramf.ciU = this.dmT;
          paramf.ciV = 9L;
          paramf.QX();
        }
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.dnp.field_username);
        com.tencent.mm.br.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 2);
        return false;
      }
      if (paramf.equals("room_search_chatting_content"))
      {
        if (com.tencent.mm.model.s.hb(this.dmT))
        {
          paramf = new com.tencent.mm.h.b.a.m();
          paramf.ciU = this.dmT;
          paramf.ciV = 8L;
          paramf.QX();
        }
        paramf = new Intent();
        paramf.putExtra("detail_username", this.dmT);
        com.tencent.mm.plugin.fts.a.d.b(this, ".ui.FTSChattingConvUI", paramf);
        if ((this.dnL == null) || (this.dnL.MN() == null)) {
          break label2722;
        }
      }
      for (i = this.dnL.MN().size();; i = 0)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(14569, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(1) });
        return false;
        if (paramf.equals("room_clear_chatting_history"))
        {
          if (com.tencent.mm.model.s.hb(this.dmT))
          {
            paramf = new com.tencent.mm.h.b.a.m();
            paramf.ciU = this.dmT;
            paramf.ciV = 11L;
            paramf.QX();
          }
          paramf = getString(a.i.fmt_delcontactmsg_confirm_group);
          com.tencent.mm.ui.base.h.a(this.mController.uMN, paramf, "", getString(a.i.app_clear), getString(a.i.app_cancel), new ChatroomInfoUI.10(this), null, a.b.alert_btn_color_warn);
          return false;
        }
        if (paramf.equals("room_report_it"))
        {
          if (com.tencent.mm.model.s.hb(this.dmT))
          {
            paramf = new com.tencent.mm.h.b.a.m();
            paramf.ciU = this.dmT;
            paramf.ciV = 10L;
            paramf.QX();
          }
          paramf = new Intent();
          paramf.putExtra("k_username", this.dmT);
          paramf.putExtra("showShare", false);
          paramf.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(36) }));
          com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
          paramf = com.tencent.mm.modelstat.b.eBD;
          ??? = this.dmT;
          if ((!paramf.Rm()) || (!paramf.cd(???))) {
            break;
          }
          ??? = new IMBehavior();
          ((IMBehavior)???).opType = 1;
          ((IMBehavior)???).chattingOp = new IMBehaviorChattingOP();
          ((IMBehavior)???).chattingOp.expose = 1;
          synchronized (paramf.lock)
          {
            paramf.eBC.oplist_.add(???);
            return false;
          }
        }
        if (paramf.equals("room_del_quit"))
        {
          y.d("MicroMsg.ChatroomInfoUI", " quit " + this.dmT);
          paramf = new ru();
          paramf.cbq.cbs = true;
          com.tencent.mm.sdk.b.a.udP.m(paramf);
          if ((!bk.bl(this.dmT)) && (this.dmT.equals(paramf.cbr.cbu)))
          {
            bool1 = true;
            if (!bool1) {
              break label2113;
            }
            y.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.dmT);
          }
          label2113:
          while ((!this.dnG) || (this.dnL.MN().size() <= 2))
          {
            com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(a.i.del_room_mem_comfirm), "", getString(a.i.app_ok), getString(a.i.app_cancel), new ChatroomInfoUI.14(this, bool1), null, a.b.alert_btn_color_warn);
            return false;
            bool1 = false;
            break;
          }
          paramf = getString(a.i.room_owner_delete_direct);
          ??? = getString(a.i.app_cancel);
          ??? = new ChatroomInfoUI.13(this);
          com.tencent.mm.ui.base.h.a(this, "", new String[] { paramf }, ???, (h.c)???);
          return false;
        }
        if (paramf.equals("add_selector_btn"))
        {
          xl();
          return false;
        }
        if (paramf.equals("del_selector_btn"))
        {
          xm();
          return false;
        }
        if (paramf.equals("see_room_member"))
        {
          paramf = new Intent();
          paramf.setClass(this.mController.uMN, SeeRoomMemberUI.class);
          paramf.putExtra("Block_list", q.Gj());
          ??? = com.tencent.mm.model.m.gK(this.dmT);
          if (??? != null) {
            this.dnI = ???.size();
          }
          paramf.putExtra("Chatroom_member_list", bk.c(???, ","));
          paramf.putExtra("RoomInfo_Id", this.dmT);
          paramf.putExtra("room_owner_name", this.dnL.field_roomowner);
          paramf.putExtra("Is_RoomOwner", this.dnG);
          paramf.putExtra("room_member_count", this.dnI);
          paramf.putExtra("Add_address_titile", getString(a.i.room_see_room_member));
          if (this.bRz)
          {
            paramf.putExtra("Contact_Scene", 14);
            ??? = this.lwE.getChildAt(0);
            if (??? != null) {
              break label2487;
            }
          }
          label2487:
          for (i = 0;; i = -???.getTop())
          {
            paramf.putExtra("offset", i);
            paramf.putExtra("first_pos", this.lwE.getFirstVisiblePosition());
            paramf.putExtra("room_name", this.dnp.field_username);
            startActivityForResult(paramf, 5);
            this.dnU = 5;
            return false;
            if (!this.dno) {
              break;
            }
            paramf.putExtra("Contact_Scene", 44);
            if (q.gS(this.dnp.field_username)) {
              break;
            }
            paramf.putExtra("Contact_IsLBSFriend", true);
            break;
          }
        }
        if (paramf.equals("manage_room"))
        {
          paramf = new Intent();
          paramf.setClass(this.mController.uMN, ManageChatroomUI.class);
          paramf.putExtra("RoomInfo_Id", this.dmT);
          paramf.putExtra("room_owner_name", this.dnL.field_roomowner);
          startActivity(paramf);
          return false;
        }
        if (paramf.equals("chat_room_app_brand"))
        {
          if (com.tencent.mm.model.s.hb(this.dmT))
          {
            paramf = new com.tencent.mm.h.b.a.m();
            paramf.ciU = this.dmT;
            paramf.ciV = 7L;
            paramf.QX();
          }
          paramf = new Intent();
          paramf.putExtra("Chat_User", this.dmT);
          com.tencent.mm.br.d.e(this, ".ui.chatting.gallery.AppBrandHistoryListUI", paramf);
          com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 25L, 1L, true);
          return false;
        }
        if (!paramf.equals("room_manager_view")) {
          break;
        }
        paramf = new Intent();
        paramf.setClass(this.mController.uMN, SeeRoomOwnerManagerUI.class);
        paramf.putExtra("RoomInfo_Id", this.dmT);
        paramf.putExtra("room_owner_name", this.dnL.field_roomowner);
        startActivity(paramf);
        return false;
      }
    }
  }
  
  public final void i(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1.equals(this.dmT)) && (this.dnv != null)) {
      this.dnv.notifyChanged();
    }
  }
  
  protected final void initView()
  {
    this.dnn = this.vdd;
    Object localObject1;
    label91:
    boolean bool;
    if (this.bRz) {
      if (this.dnI == 0)
      {
        setMMTitle(getString(a.i.roominfo_name));
        localObject1 = null;
        if (this.dnL != null)
        {
          localObject1 = this.dnL.field_roomowner;
          this.dnI = this.dnL.MN().size();
        }
        if (!bk.bl((String)localObject1)) {
          break label1237;
        }
        this.dnF = false;
        this.dnG = false;
        this.dnH = false;
        y.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
        this.dnv = ((ContactListExpandPreference)this.dnn.add("roominfo_contact_anchor"));
        this.dnv.a(this.dnn, this.dnv.mKey);
        this.dnu = ((NormalIconPreference)this.dnn.add("del_selector_btn"));
        this.dnt = ((NormalIconPreference)this.dnn.add("add_selector_btn"));
        this.dnr = ((SignaturePreference)this.dnn.add("room_name"));
        this.dnq = ((RoomCardPreference)this.dnn.add("room_card"));
        this.dns = this.dnn.add("see_room_member");
        this.dnw = ((CheckBoxPreference)this.dnn.add("room_notify_new_msg"));
        this.dnx = ((CheckBoxPreference)this.dnn.add("room_save_to_contact"));
        this.dny = ((CheckBoxPreference)this.dnn.add("room_placed_to_the_top"));
        this.dnz = ((SignaturePreference)this.dnn.add("room_nickname"));
        this.dnB = this.dnn.add("manage_room");
        this.dnv.lS(true).lT(true).cmQ();
        bool = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).zl(this.dmT);
        if (xw()) {
          break label1262;
        }
        this.dnn.bJ("manage_room", true);
        localObject1 = this.dnn;
        if (bool) {
          break label1257;
        }
        bool = true;
        label388:
        ((com.tencent.mm.ui.base.preference.f)localObject1).bJ("room_manager_view", bool);
        label399:
        if (com.tencent.mm.model.s.hb(this.dmT)) {
          this.dnn.bJ("manage_room", true);
        }
        if (this.dnL != null)
        {
          this.dnv.WI(this.dnL.field_roomowner);
          if (!bk.bl(this.dnL.field_roomowner)) {
            this.dnv.sdh.scu.scW = true;
          }
        }
        this.dnv.cmO();
        this.dnv.cmR();
        this.dnn.bJ("add_selector_btn", true);
        this.dnn.bJ("del_selector_btn", true);
        this.dnn.bJ("room_name", false);
        this.dnn.bJ("room_qr_code", false);
        this.dnn.bJ("chatroom_info_chexboxes", true);
        this.dnn.bJ("room_card", false);
        this.dnn.bJ("room_upgrade_entry", true);
        if (((xw()) || (this.dnI < com.tencent.mm.pluginsdk.ui.applet.j.scD)) && ((!xw()) || (this.dnI < com.tencent.mm.pluginsdk.ui.applet.j.scD - 1))) {
          break label1318;
        }
        this.dnn.bJ("see_room_member", false);
        this.dns.setTitle(getString(a.i.see_member_selector_btn));
        label638:
        if (ad.aaV(this.dmT)) {
          break label1334;
        }
        this.dnn.bJ("room_openim_about", true);
        label661:
        this.dnC = ((AppBrandLoadIconPreference)this.dnn.add("chat_room_app_brand"));
        this.dnC.drJ = this.dmT;
        y.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
        if (this.dnD == null) {
          this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.dny != null)
        {
          if (this.dnp == null) {
            break label1433;
          }
          this.dnD.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abD(this.dnp.field_username)).commit();
        }
        label801:
        this.dnn.notifyDataSetChanged();
        y.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
        if (this.dnD == null) {
          this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.dnx == null) {
          break label1491;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dmT);
        if (localObject1 != null) {
          break label1460;
        }
        y.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
        label903:
        y.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
        if (this.dnD == null) {
          this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(this.dmT);
        if (localObject1 != null) {
          break label1503;
        }
        y.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
        label990:
        this.dnM = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HS(this.dmT);
        this.dnM = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().HS(this.dmT);
      }
    }
    for (;;)
    {
      if (this.dnv != null)
      {
        if ((!this.bRz) && (this.dno)) {
          this.dnv.ac(new ArrayList());
        }
        this.lwE.setOnScrollListener(this.dnR);
        this.dnv.a(this.dnR);
        this.dnv.a(new ChatroomInfoUI.45(this));
        localObject1 = this.dnv;
        localObject2 = new ChatroomInfoUI.2(this);
        if (((ContactListExpandPreference)localObject1).sdh != null) {
          ((ContactListExpandPreference)localObject1).sdh.nuB = ((View.OnClickListener)localObject2);
        }
        this.dnv.a(new ChatroomInfoUI.3(this));
      }
      setBackBtn(new ChatroomInfoUI.4(this));
      return;
      if (this.dnL != null) {
        this.dnI = this.dnL.MN().size();
      }
      setMMTitle(getString(a.i.fmt_chatting_title_group, new Object[] { getString(a.i.roominfo_name), Integer.valueOf(this.dnI) }));
      break;
      label1237:
      this.dnF = true;
      this.dnG = ((String)localObject1).equals(q.Gj());
      break label91;
      label1257:
      bool = false;
      break label388;
      label1262:
      this.dnn.bJ("room_manager_view", true);
      if (com.tencent.mm.model.m.gM(this.dmT) > 2)
      {
        this.dnn.bJ("manage_room", false);
        break label399;
      }
      this.dnn.bJ("manage_room", true);
      break label399;
      label1318:
      this.dnn.bJ("see_room_member", true);
      break label638;
      label1334:
      this.dnn.bJ("room_openim_about", false);
      localObject1 = getString(a.i.room_openim_about);
      Object localObject2 = getString(a.i.room_openim_about_href);
      int i = ((String)localObject1).lastIndexOf((String)localObject2);
      if (i < 0) {
        break label661;
      }
      int j = ((String)localObject2).length();
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setFlags(268435456);
          paramAnonymousView.setClassName(ae.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
          paramAnonymousView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/newreadtemplate?t=work_wechat/about_group");
          ae.getContext().startActivity(paramAnonymousView);
        }
      }, i, j + i, 18);
      this.dnn.add("room_openim_about").setTitle((CharSequence)localObject1);
      break label661;
      label1433:
      this.dnD.edit().putBoolean("room_placed_to_the_top", false).commit();
      break label801;
      label1460:
      this.dnD.edit().putBoolean("room_save_to_contact", com.tencent.mm.n.a.gR(((ao)localObject1).field_type)).commit();
      label1491:
      this.dnn.notifyDataSetChanged();
      break label903;
      label1503:
      this.dnE = ((u)localObject1).ctS();
      this.dnA = ((CheckBoxPreference)this.dnn.add("room_msg_show_username"));
      if (this.dnA != null) {
        this.dnD.edit().putBoolean("room_msg_show_username", this.dnE).commit();
      }
      this.dnn.notifyDataSetChanged();
      break label990;
      if (this.dno)
      {
        this.dnG = false;
        this.dnH = false;
        setMMTitle(getString(a.i.room_lbsroom_member_title_init));
        this.dnv = ((ContactListExpandPreference)this.dnn.add("roominfo_contact_anchor"));
        this.dnv.a(this.dnn, this.dnv.mKey);
        this.dnv.lS(false).lT(false);
        this.dnv.a(new ChatroomInfoUI.6(this));
        this.dnn.removeAll();
        this.dnn.a(new PreferenceCategory(this));
        this.dnn.a(this.dnv);
        localObject1 = this.dmT;
        localObject2 = new kf();
        ((kf)localObject2).bTk.bRo = ((String)localObject1);
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
        getString(a.i.app_tip);
        this.dnm = com.tencent.mm.ui.base.h.b(this, getString(a.i.room_lbsroom_member_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            ChatroomInfoUI.a(this.dox);
          }
        });
        this.dnn.notifyDataSetChanged();
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  Object localObject;
                  do
                  {
                    do
                    {
                      return;
                    } while (paramIntent == null);
                    paramIntent = paramIntent.getStringExtra("Select_Contact");
                    localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(this.dmT);
                  } while (localObject == null);
                  if ((((u)localObject).ctQ() == 2) && (!xw()))
                  {
                    localObject = new e.a(this).aeG(getString(a.i.request_to_owner_tip));
                    ((e.a)localObject).wnv = getString(a.i.app_send);
                    localObject = ((e.a)localObject).nY(true).l(Boolean.valueOf(true));
                    ((e.a)localObject).wnw = getString(a.i.app_cancel);
                    ((e.a)localObject).aeH(getString(a.i.reason_invite_hint)).c(new ChatroomInfoUI.44(this, paramIntent)).show();
                    return;
                  }
                  c(paramIntent, null, a.i.adding_room_mem);
                  return;
                } while (paramIntent == null);
                paramIntent = paramIntent.getStringExtra("Select_Contact");
              } while ((paramIntent == null) || (paramIntent.equals("")));
              paramIntent = bk.G(paramIntent.split(","));
              paramIntent = com.tencent.mm.roomsdk.a.b.YK(this.dmT).a(this.dmT, paramIntent, 0);
              paramIntent.b(new ChatroomInfoUI.19(this));
              paramIntent.c(new ChatroomInfoUI.20(this));
              getString(a.i.app_tip);
              paramIntent.a(this, getString(a.i.room_del_member), true, new ChatroomInfoUI.21(this, paramIntent));
              return;
            } while (paramInt2 != -1);
            finish();
            return;
          } while (paramInt2 != -1);
          paramIntent = paramIntent.getStringExtra("room_name");
        } while (bk.bl(paramIntent));
        com.tencent.mm.sdk.b.a.udP.m(new sq());
        this.dnp.dk(paramIntent);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().U(this.dnp);
        xt();
        return;
      } while (paramInt2 != 0);
      this.dnU = -1;
      return;
    } while (paramInt2 != -1);
    xs();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.dnv.notifyChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.DO().dJT.a(480, this);
    com.tencent.mm.pluginsdk.c.b.a(kf.class.getName(), this.doa);
    paramBundle = this.dnT.cqo();
    Assert.assertNotNull(this);
    keep(paramBundle);
    com.tencent.mm.kernel.g.DP().Dz().a(this);
    ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().c(this);
    if (com.tencent.mm.bf.g.eEV != null) {
      com.tencent.mm.bf.g.eEV.a(this);
    }
    this.dmT = getIntent().getStringExtra("RoomInfo_Id");
    this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dmT);
    this.dnN = true;
    this.bRz = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.dno = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.dnO = getIntent().getBooleanExtra("fromChatting", false);
    this.dnP = getIntent().getBooleanExtra("isShowSetMuteAnimation", false);
    this.dnW = (getPackageName() + "_preferences");
    if (this.bRz)
    {
      this.dnL = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(this.dmT);
      this.dnH = this.dnL.aaM(q.Gj());
    }
    initView();
    if (this.bRz)
    {
      paramBundle = new ChatroomInfoUI.22(this);
      if (this.dnL != null) {
        break label318;
      }
      am.a.dVy.a(this.dmT, "", paramBundle);
    }
    label318:
    while (System.currentTimeMillis() - this.dnL.field_modifytime < 86400000L) {
      return;
    }
    com.tencent.mm.kernel.g.DS().O(new ChatroomInfoUI.32(this, paramBundle));
  }
  
  public void onDestroy()
  {
    if (com.tencent.mm.bf.g.eEV != null) {
      com.tencent.mm.bf.g.eEV.a(this);
    }
    com.tencent.mm.kernel.g.DP().Dz().b(this);
    com.tencent.mm.ui.g.a.dismiss();
    com.tencent.mm.kernel.g.DO().dJT.b(480, this);
    com.tencent.mm.sdk.b.a.udP.d(this.dnT);
    com.tencent.mm.pluginsdk.c.b.b(kf.class.getName(), this.doa);
    if (com.tencent.mm.kernel.g.DK())
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().b(this);
      ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().d(this);
    }
    if (com.tencent.mm.bf.g.eEV != null) {
      com.tencent.mm.bf.g.eEV.b(this);
    }
    if (this.dnC != null) {
      AppBrandLoadIconPreference.onDestroy();
    }
    if (this.dob != null) {
      this.dob.stopTimer();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((!this.dnK) || (!this.bRz) || (this.dnL == null)) {
      return;
    }
    com.tencent.mm.model.m.a(this.dmT, this.dnL, this.dnE);
  }
  
  public void onResume()
  {
    super.onResume();
    this.dnn.notifyDataSetChanged();
    Object localObject;
    boolean bool;
    if (this.dnL != null)
    {
      localObject = this.dnL.ctT();
      if (localObject != null)
      {
        bool = com.tencent.mm.model.m.G(this.dnL.field_chatroomname, ((com.tencent.mm.k.a.a.a)localObject).dtJ);
        y.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[] { this.dnL.field_chatroomname, Integer.valueOf(((com.tencent.mm.k.a.a.a)localObject).dtJ), Integer.valueOf(this.dnL.field_chatroomVersion), this.dnL.field_roomowner });
      }
    }
    for (;;)
    {
      if ((com.tencent.mm.model.m.gF(this.dmT)) || (bool)) {
        xi();
      }
      xs();
      updateTitle();
      xr();
      if (this.bRz)
      {
        xt();
        xq();
      }
      if (this.dnN)
      {
        xp();
        this.dnN = false;
      }
      localObject = getIntent().getStringExtra("need_matte_high_light_item");
      if (!this.dnS)
      {
        if (!bk.bl((String)localObject)) {
          eO((String)localObject);
        }
        this.dnS = true;
      }
      if ((!bk.bl((String)localObject)) && (((String)localObject).equals("room_notify_new_notice")) && (!this.dnS))
      {
        eO("room_card");
        this.dnS = true;
      }
      y.d("MicroMsg.ChatroomInfoUI", "showSetMuteAnimation isShowSetMuteAnimation[%b]", new Object[] { Boolean.valueOf(this.dnP) });
      if (this.dnP)
      {
        this.dnP = false;
        ai.l(new ChatroomInfoUI.38(this), 50L);
      }
      return;
      bool = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    y.d("MicroMsg.ChatroomInfoUI", "pre is " + this.dnI);
    this.dnI = com.tencent.mm.model.m.gM(this.dmT);
    y.d("MicroMsg.ChatroomInfoUI", "now is " + this.dnI);
    if (this.dnm != null) {
      this.dnm.dismiss();
    }
  }
  
  public final int xj()
  {
    return a.k.roominfo_pref;
  }
  
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      ChatroomInfoUI.bk(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */