package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.br.d;
import com.tencent.mm.bv.a;
import com.tencent.mm.chatroom.e.b;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.awz;
import com.tencent.mm.protocal.c.axa;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.d;

@Deprecated
public class RoomInfoDetailUI
  extends MMPreference
  implements j.a
{
  private boolean bRz;
  private String dmT;
  private boolean dnK = false;
  private String dnW;
  private f dnn;
  private ad dnp;
  private SignaturePreference dnr;
  private CheckBoxPreference dnw;
  private int dqc;
  private CheckBoxPreference dqd;
  private CheckBoxPreference dqe;
  private boolean isDeleteCancel = false;
  
  private boolean xG()
  {
    return (((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(this.dmT).field_chatroomdataflag & 0x2) == 0;
  }
  
  private void xH()
  {
    if ((this.dnp != null) && (this.dnr != null))
    {
      Object localObject2 = xk();
      Object localObject1 = localObject2;
      if (bk.bl((String)localObject2)) {
        localObject1 = q.Gl();
      }
      if (!bk.bl((String)localObject1))
      {
        SignaturePreference localSignaturePreference = this.dnr;
        localObject2 = localObject1;
        if (((String)localObject1).length() <= 0) {
          localObject2 = getString(a.i.settings_signature_empty);
        }
        localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject2));
      }
    }
    else
    {
      return;
    }
    this.dnr.setSummary("");
  }
  
  private String xk()
  {
    u localu = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(this.dmT);
    if (localu == null) {
      return "";
    }
    return localu.field_selfDisplayName;
  }
  
  private void xr()
  {
    boolean bool = true;
    if (!this.bRz) {
      return;
    }
    Object localObject = getSharedPreferences(this.dnW, 0);
    if (this.dqc == 0)
    {
      setTitleMuteIconVisibility(0);
      if (this.dnw != null)
      {
        this.dnw.rHo = true;
        ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", true).commit();
      }
      if (this.dqe != null) {
        this.dqe.rHo = xG();
      }
      localObject = this.dnn;
      if (this.dqc != 1) {
        break label160;
      }
    }
    for (;;)
    {
      ((f)localObject).bJ("room_show_msg_count", bool);
      return;
      if (this.dqc != 1) {
        break;
      }
      setTitleMuteIconVisibility(8);
      if (this.dnw == null) {
        break;
      }
      this.dnw.rHo = false;
      ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", false).commit();
      break;
      label160:
      bool = false;
    }
  }
  
  public final void a(String paramString, l paraml) {}
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    paramPreference = paramPreference.mKey;
    y.d("MicroMsg.RoomInfoDetailUI", "click key : %s", new Object[] { paramPreference });
    String str;
    if (paramPreference.equals("room_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, e.d.class);
      paramf.putExtra("Contact_mode_name_type", 4);
      str = q.Gj();
      paramf.putExtra("Contact_Nick", xk());
      paramf.putExtra("Contact_User", str);
      paramf.putExtra("MMActivity.OverrideEnterAnimation", a.a.fast_faded_in);
      paramf.putExtra("MMActivity.OverrideExitAnimation", a.a.push_down_out);
      this.mController.uMN.startActivityForResult(paramf, 2);
    }
    int i;
    if (paramPreference.equals("room_msg_show_username"))
    {
      paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(this.dmT);
      if (!paramf.ctS())
      {
        bool1 = true;
        paramf.mB(bool1);
        this.dnK = true;
      }
    }
    else
    {
      if (paramPreference.equals("room_msg_notify"))
      {
        if (this.dqc != 0) {
          break label803;
        }
        i = 1;
        label186:
        this.dqc = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new b(this.dmT, this.dqc));
        this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dmT);
        this.dnp.fq(this.dqc);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(this.dmT, this.dnp);
        xr();
        this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dmT);
        this.dnn.notifyDataSetChanged();
      }
      if (paramPreference.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.dnp.field_username);
        d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 1);
      }
      if (paramPreference.equals("room_clear_chatting_history"))
      {
        if (!this.bRz) {
          break label808;
        }
        paramf = getString(a.i.fmt_delcontactmsg_confirm_group);
        label410:
        str = getString(a.i.room_clear_chatting_history);
        RoomInfoDetailUI.2 local2 = new RoomInfoDetailUI.2(this);
        com.tencent.mm.ui.base.h.a(this, paramf, new String[] { str }, null, local2);
      }
      if (paramPreference.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.dnW, 0);
        if (this.dnp != null)
        {
          if (!((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abD(this.dnp.field_username)) {
            break label833;
          }
          com.tencent.mm.model.s.u(this.dnp.field_username, true);
          label514:
          paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().abD(this.dnp.field_username)).commit();
        }
      }
      if ("room_show_msg_count".equals(paramPreference))
      {
        boolean bool3 = xG();
        y.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool3) });
        if (bool3) {
          break label847;
        }
        bool1 = true;
        label611:
        paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(this.dmT);
        if (!bool1) {
          break label853;
        }
        paramf.gS(0);
        label644:
        y.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[] { Boolean.valueOf(bool1) });
        ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().c(paramf, new String[0]);
        paramf = q.Gj();
        paramPreference = new axa();
        paramPreference.svm = this.dmT;
        paramPreference.hPY = paramf;
        paramPreference.ttm = 2;
        if (!bool1) {
          break label861;
        }
        i = 2;
        label725:
        paramPreference.nFj = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new i.a(49, paramPreference));
        if (this.dqe != null)
        {
          paramf = this.dqe;
          if (bool3) {
            break label866;
          }
        }
      }
    }
    label803:
    label808:
    label833:
    label847:
    label853:
    label861:
    label866:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramf.rHo = bool1;
      this.dnn.notifyDataSetChanged();
      return false;
      bool1 = false;
      break;
      i = 0;
      break label186;
      paramf = getString(a.i.fmt_delcontactmsg_confirm, new Object[] { this.dnp.Bq() });
      break label410;
      com.tencent.mm.model.s.t(this.dnp.field_username, true);
      break label514;
      bool1 = false;
      break label611;
      paramf.gS(2);
      break label644;
      i = 1;
      break label725;
    }
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.roominfo_detail_name);
    this.dnn = this.vdd;
    this.dnW = (getPackageName() + "_preferences");
    this.bRz = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.dmT = getIntent().getStringExtra("RoomInfo_Id");
    if (this.dmT == null) {
      this.dmT = getIntent().getStringExtra("Single_Chat_Talker");
    }
    this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.dmT);
    if (this.bRz)
    {
      this.dqc = this.dnp.cCy;
      this.dnr = ((SignaturePreference)this.dnn.add("room_name"));
      this.dnw = ((CheckBoxPreference)this.dnn.add("room_msg_notify"));
      this.dqe = ((CheckBoxPreference)this.dnn.add("room_show_msg_count"));
      this.dqd = ((CheckBoxPreference)this.dnn.add("room_msg_show_username"));
      this.dqe.vdK = false;
    }
    for (;;)
    {
      setBackBtn(new RoomInfoDetailUI.1(this));
      return;
      this.dqc = 1;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    String str1;
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt1)
          {
          default: 
            return;
          }
        } while (paramInt2 != -1);
        setResult(-1);
        finish();
        return;
      } while (paramIntent == null);
      str1 = bk.aM(paramIntent.getStringExtra("Contact_Nick"), "");
    } while (bk.bl(str1));
    String str2 = q.Gj();
    paramIntent = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(this.dmT);
    if (paramIntent == null) {
      paramIntent = new u();
    }
    for (;;)
    {
      paramIntent.field_chatroomname = this.dmT;
      paramIntent.field_selfDisplayName = str1;
      ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().c(paramIntent, new String[0]);
      paramIntent = new awz();
      paramIntent.svm = this.dmT;
      paramIntent.hPY = str2;
      paramIntent.sLC = bk.pm(str1);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new i.a(48, paramIntent));
      xH();
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject;
    if (this.dnK)
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().in(this.dmT);
      ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().c((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      String str = q.Gj();
      boolean bool = ((u)localObject).ctS();
      localObject = new axa();
      ((axa)localObject).svm = this.dmT;
      ((axa)localObject).hPY = str;
      ((axa)localObject).ttm = 1;
      if (!bool) {
        break label143;
      }
    }
    label143:
    for (int i = 1;; i = 0)
    {
      ((axa)localObject).nFj = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new i.a(49, (a)localObject));
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    xr();
    xH();
    SharedPreferences localSharedPreferences;
    if ((this.dnp != null) && (this.dqd != null))
    {
      u localu = ((com.tencent.mm.plugin.chatroom.a.c)g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().io(this.dmT);
      localSharedPreferences = getSharedPreferences(this.dnW, 0);
      if (!localu.ctS()) {
        break label105;
      }
      this.dqd.rHo = true;
      localSharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      label105:
      this.dqd.rHo = false;
      localSharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
    }
  }
  
  public final int xj()
  {
    return a.k.roominfo_detail_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI
 * JD-Core Version:    0.7.0.1
 */