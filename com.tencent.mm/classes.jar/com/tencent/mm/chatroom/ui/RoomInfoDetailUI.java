package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.bv.a;
import com.tencent.mm.chatroom.e.b;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.f;

@Deprecated
public class RoomInfoDetailUI
  extends MMPreference
  implements k.a
{
  private ad contact;
  private boolean czb;
  private CheckBoxPreference eeV;
  private String eeu;
  private boolean efh = false;
  private String eft;
  private SignaturePreference ehA;
  private CheckBoxPreference ehB;
  private CheckBoxPreference ehC;
  private int ehz;
  private boolean isDeleteCancel = false;
  private f screen;
  
  private String JB()
  {
    AppMethodBeat.i(104199);
    Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.eeu);
    if (localObject == null)
    {
      AppMethodBeat.o(104199);
      return "";
    }
    localObject = ((u)localObject).field_selfDisplayName;
    AppMethodBeat.o(104199);
    return localObject;
  }
  
  private void JJ()
  {
    boolean bool = true;
    AppMethodBeat.i(104201);
    if (!this.czb)
    {
      AppMethodBeat.o(104201);
      return;
    }
    Object localObject = getSharedPreferences(this.eft, 0);
    if (this.ehz == 0)
    {
      setTitleMuteIconVisibility(0);
      if (this.eeV != null)
      {
        this.eeV.vxW = true;
        ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", true).commit();
      }
      if (this.ehC != null) {
        this.ehC.vxW = JY();
      }
      localObject = this.screen;
      if (this.ehz != 1) {
        break label175;
      }
    }
    for (;;)
    {
      ((f)localObject).cl("room_show_msg_count", bool);
      AppMethodBeat.o(104201);
      return;
      if (this.ehz != 1) {
        break;
      }
      setTitleMuteIconVisibility(8);
      if (this.eeV == null) {
        break;
      }
      this.eeV.vxW = false;
      ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", false).commit();
      break;
      label175:
      bool = false;
    }
  }
  
  private boolean JY()
  {
    AppMethodBeat.i(104198);
    if ((((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.eeu).field_chatroomdataflag & 0x2) == 0)
    {
      AppMethodBeat.o(104198);
      return true;
    }
    AppMethodBeat.o(104198);
    return false;
  }
  
  private void JZ()
  {
    AppMethodBeat.i(104200);
    if ((this.contact != null) && (this.ehA != null))
    {
      Object localObject2 = JB();
      Object localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = r.Zp();
      }
      if (!bo.isNullOrNil((String)localObject1))
      {
        SignaturePreference localSignaturePreference = this.ehA;
        localObject2 = localObject1;
        if (((String)localObject1).length() <= 0) {
          localObject2 = getString(2131303427);
        }
        localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject2));
        AppMethodBeat.o(104200);
        return;
      }
      this.ehA.setSummary("");
    }
    AppMethodBeat.o(104200);
  }
  
  public final void a(String paramString, m paramm) {}
  
  public int getResourceId()
  {
    return 2131165263;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104194);
    setMMTitle(2131302816);
    this.screen = getPreferenceScreen();
    this.eft = (getPackageName() + "_preferences");
    this.czb = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.eeu = getIntent().getStringExtra("RoomInfo_Id");
    if (this.eeu == null) {
      this.eeu = getIntent().getStringExtra("Single_Chat_Talker");
    }
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eeu);
    if (this.czb)
    {
      this.ehz = this.contact.dqK;
      this.ehA = ((SignaturePreference)this.screen.atx("room_name"));
      this.eeV = ((CheckBoxPreference)this.screen.atx("room_msg_notify"));
      this.ehC = ((CheckBoxPreference)this.screen.atx("room_show_msg_count"));
      this.ehB = ((CheckBoxPreference)this.screen.atx("room_msg_show_username"));
      this.ehC.zsk = false;
    }
    for (;;)
    {
      setBackBtn(new RoomInfoDetailUI.1(this));
      AppMethodBeat.o(104194);
      return;
      this.ehz = 1;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(104202);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(104202);
      return;
    }
    switch (paramInt1)
    {
    }
    String str1;
    do
    {
      do
      {
        AppMethodBeat.o(104202);
        return;
      } while (paramInt2 != -1);
      setResult(-1);
      finish();
      AppMethodBeat.o(104202);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(104202);
        return;
      }
      str1 = bo.bf(paramIntent.getStringExtra("Contact_Nick"), "");
    } while (bo.isNullOrNil(str1));
    String str2 = r.Zn();
    paramIntent = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.eeu);
    if (paramIntent == null) {
      paramIntent = new u();
    }
    for (;;)
    {
      paramIntent.field_chatroomname = this.eeu;
      paramIntent.field_selfDisplayName = str1;
      ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().update(paramIntent, new String[0]);
      paramIntent = new bdp();
      paramIntent.wot = this.eeu;
      paramIntent.jJA = str2;
      paramIntent.wJp = bo.nullAsNil(str1);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yz().c(new j.a(48, paramIntent));
      JZ();
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104192);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(104192);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104197);
    super.onPause();
    Object localObject;
    if (this.efh)
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.eeu);
      ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      String str = r.Zn();
      boolean bool = ((u)localObject).dws();
      localObject = new bdq();
      ((bdq)localObject).wot = this.eeu;
      ((bdq)localObject).jJA = str;
      ((bdq)localObject).xtm = 1;
      if (!bool) {
        break label154;
      }
    }
    label154:
    for (int i = 1;; i = 0)
    {
      ((bdq)localObject).qsl = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yz().c(new j.a(49, (a)localObject));
      AppMethodBeat.o(104197);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    AppMethodBeat.i(104196);
    paramPreference = paramPreference.mKey;
    ab.d("MicroMsg.RoomInfoDetailUI", "click key : %s", new Object[] { paramPreference });
    String str;
    if (paramPreference.equals("room_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, e.f.class);
      paramf.putExtra("Contact_mode_name_type", 4);
      str = r.Zn();
      paramf.putExtra("Contact_Nick", JB());
      paramf.putExtra("Contact_User", str);
      paramf.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
      paramf.putExtra("MMActivity.OverrideExitAnimation", 2131034228);
      getContext().startActivityForResult(paramf, 2);
    }
    int i;
    if (paramPreference.equals("room_msg_show_username"))
    {
      paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.eeu);
      if (!paramf.dws())
      {
        bool1 = true;
        paramf.pS(bool1);
        this.efh = true;
      }
    }
    else
    {
      if (paramPreference.equals("room_msg_notify"))
      {
        if (this.ehz != 0) {
          break label816;
        }
        i = 1;
        label198:
        this.ehz = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yz().c(new b(this.eeu, this.ehz));
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eeu);
        this.contact.hB(this.ehz);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().b(this.eeu, this.contact);
        JJ();
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.eeu);
        this.screen.notifyDataSetChanged();
      }
      if (paramPreference.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.contact.field_username);
        d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 1);
      }
      if (paramPreference.equals("room_clear_chatting_history"))
      {
        if (!this.czb) {
          break label821;
        }
        paramf = getString(2131300037);
        label418:
        str = getString(2131302680);
        RoomInfoDetailUI.2 local2 = new RoomInfoDetailUI.2(this);
        h.a(this, paramf, new String[] { str }, null, local2);
      }
      if (paramPreference.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.eft, 0);
        if (this.contact != null)
        {
          if (!((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arP(this.contact.field_username)) {
            break label846;
          }
          t.y(this.contact.field_username, true);
          label521:
          paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arP(this.contact.field_username)).commit();
        }
      }
      if ("room_show_msg_count".equals(paramPreference))
      {
        boolean bool3 = JY();
        ab.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool3) });
        if (bool3) {
          break label860;
        }
        bool1 = true;
        label618:
        paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oU(this.eeu);
        if (!bool1) {
          break label866;
        }
        paramf.jf(0);
        label651:
        ab.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[] { Boolean.valueOf(bool1) });
        ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().update(paramf, new String[0]);
        paramf = r.Zn();
        paramPreference = new bdq();
        paramPreference.wot = this.eeu;
        paramPreference.jJA = paramf;
        paramPreference.xtm = 2;
        if (!bool1) {
          break label874;
        }
        i = 2;
        label733:
        paramPreference.qsl = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yz().c(new j.a(49, paramPreference));
        if (this.ehC != null)
        {
          paramf = this.ehC;
          if (bool3) {
            break label879;
          }
        }
      }
    }
    label816:
    label821:
    label846:
    label860:
    label866:
    label874:
    label879:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramf.vxW = bool1;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(104196);
      return false;
      bool1 = false;
      break;
      i = 0;
      break label198;
      paramf = getString(2131300036, new Object[] { this.contact.Of() });
      break label418;
      t.x(this.contact.field_username, true);
      break label521;
      bool1 = false;
      break label618;
      paramf.jf(2);
      break label651;
      i = 1;
      break label733;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104193);
    super.onResume();
    JJ();
    JZ();
    SharedPreferences localSharedPreferences;
    if ((this.contact != null) && (this.ehB != null))
    {
      u localu = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oV(this.eeu);
      localSharedPreferences = getSharedPreferences(this.eft, 0);
      if (!localu.dws()) {
        break label117;
      }
      this.ehB.vxW = true;
      localSharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(104193);
      return;
      label117:
      this.ehB.vxW = false;
      localSharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI
 * JD-Core Version:    0.7.0.1
 */