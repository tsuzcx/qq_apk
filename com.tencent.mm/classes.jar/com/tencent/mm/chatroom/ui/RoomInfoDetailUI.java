package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.e.j;

@Deprecated
public class RoomInfoDetailUI
  extends MMPreference
  implements MStorage.IOnStorageChange
{
  private as contact;
  private boolean dRx;
  private CheckBoxPreference gtV;
  private boolean gui = false;
  private String guu;
  private int gyu;
  private SignaturePreference gyv;
  private CheckBoxPreference gyw;
  private CheckBoxPreference gyx;
  private boolean isDeleteCancel = false;
  private String roomId;
  private f screen;
  
  private boolean amU()
  {
    AppMethodBeat.i(12746);
    if ((((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId).field_chatroomdataflag & 0x2) == 0)
    {
      AppMethodBeat.o(12746);
      return true;
    }
    AppMethodBeat.o(12746);
    return false;
  }
  
  private String amV()
  {
    AppMethodBeat.i(12747);
    Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId);
    if (localObject == null)
    {
      AppMethodBeat.o(12747);
      return "";
    }
    localObject = ((ah)localObject).field_selfDisplayName;
    AppMethodBeat.o(12747);
    return localObject;
  }
  
  private void amW()
  {
    AppMethodBeat.i(12748);
    if ((this.contact != null) && (this.gyv != null))
    {
      Object localObject2 = amV();
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = z.aUa();
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        SignaturePreference localSignaturePreference = this.gyv;
        localObject2 = localObject1;
        if (((String)localObject1).length() <= 0) {
          localObject2 = getString(2131765591);
        }
        localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject2));
        AppMethodBeat.o(12748);
        return;
      }
      this.gyv.setSummary("");
    }
    AppMethodBeat.o(12748);
  }
  
  private void amy()
  {
    boolean bool = true;
    AppMethodBeat.i(12749);
    if (!this.dRx)
    {
      AppMethodBeat.o(12749);
      return;
    }
    Object localObject = getSharedPreferences(this.guu, 0);
    if (this.gyu == 0)
    {
      setTitleMuteIconVisibility(0);
      if (this.gtV != null)
      {
        this.gtV.setChecked(true);
        ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", true).commit();
      }
      if (this.gyx != null) {
        this.gyx.setChecked(amU());
      }
      localObject = this.screen;
      if (this.gyu != 1) {
        break label179;
      }
    }
    for (;;)
    {
      ((f)localObject).jdMethod_do("room_show_msg_count", bool);
      AppMethodBeat.o(12749);
      return;
      if (this.gyu != 1) {
        break;
      }
      setTitleMuteIconVisibility(8);
      if (this.gtV == null) {
        break;
      }
      this.gtV.setChecked(false);
      ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", false).commit();
      break;
      label179:
      bool = false;
    }
  }
  
  public int getResourceId()
  {
    return 2132017251;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12743);
    setMMTitle(2131764811);
    this.screen = getPreferenceScreen();
    this.guu = (getPackageName() + "_preferences");
    this.dRx = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    if (this.roomId == null) {
      this.roomId = getIntent().getStringExtra("Single_Chat_Talker");
    }
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
    if (this.dRx)
    {
      this.gyu = this.contact.fuH;
      this.gyv = ((SignaturePreference)this.screen.bmg("room_name"));
      this.gtV = ((CheckBoxPreference)this.screen.bmg("room_msg_notify"));
      this.gyx = ((CheckBoxPreference)this.screen.bmg("room_show_msg_count"));
      this.gyw = ((CheckBoxPreference)this.screen.bmg("room_msg_show_username"));
      this.gyx.OZw = false;
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(12734);
          RoomInfoDetailUI.this.finish();
          AppMethodBeat.o(12734);
          return true;
        }
      });
      AppMethodBeat.o(12743);
      return;
      this.gyu = 1;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(12750);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(12750);
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
        AppMethodBeat.o(12750);
        return;
      } while (paramInt2 != -1);
      setResult(-1);
      finish();
      AppMethodBeat.o(12750);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(12750);
        return;
      }
      str1 = Util.nullAs(paramIntent.getStringExtra("Contact_Nick"), "");
    } while (Util.isNullOrNil(str1));
    String str2 = z.aTY();
    paramIntent = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId);
    if (paramIntent == null) {
      paramIntent = new ah();
    }
    for (;;)
    {
      paramIntent.field_chatroomname = this.roomId;
      paramIntent.field_selfDisplayName = str1;
      ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().update(paramIntent, new String[0]);
      paramIntent = new cph();
      paramIntent.KGO = this.roomId;
      paramIntent.UserName = str2;
      paramIntent.Liq = Util.nullAsNil(str1);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(48, paramIntent));
      amW();
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12741);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(12741);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData) {}
  
  public void onPause()
  {
    AppMethodBeat.i(12745);
    super.onPause();
    Object localObject;
    if (this.gui)
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId);
      ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().update((IAutoDBItem)localObject, new String[0]);
      String str = z.aTY();
      boolean bool = ((ah)localObject).gBx();
      localObject = new cpi();
      ((cpi)localObject).KGO = this.roomId;
      ((cpi)localObject).UserName = str;
      ((cpi)localObject).Mvf = 1;
      if (!bool) {
        break label154;
      }
    }
    label154:
    for (int i = 1;; i = 0)
    {
      ((cpi)localObject).Cyb = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(49, (com.tencent.mm.bw.a)localObject));
      AppMethodBeat.o(12745);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    AppMethodBeat.i(12744);
    paramPreference = paramPreference.mKey;
    Log.d("MicroMsg.RoomInfoDetailUI", "click key : %s", new Object[] { paramPreference });
    String str;
    if (paramPreference.equals("room_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, e.j.class);
      paramf.putExtra("Contact_mode_name_type", 4);
      str = z.aTY();
      paramf.putExtra("Contact_Nick", amV());
      paramf.putExtra("Contact_User", str);
      paramf.putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
      paramf.putExtra("MMActivity.OverrideExitAnimation", 2130772130);
      getContext().startActivityForResult(paramf, 2);
    }
    int i;
    if (paramPreference.equals("room_msg_show_username"))
    {
      paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId);
      if (!paramf.gBx())
      {
        bool1 = true;
        paramf.AL(bool1);
        this.gui = true;
      }
    }
    else
    {
      if (paramPreference.equals("room_msg_notify"))
      {
        if (this.gyu != 0) {
          break label816;
        }
        i = 1;
        label198:
        this.gyu = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new com.tencent.mm.chatroom.f.a(this.roomId, this.gyu));
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
        this.contact.nm(this.gyu);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().c(this.roomId, this.contact);
        amy();
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.roomId);
        this.screen.notifyDataSetChanged();
      }
      if (paramPreference.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.contact.field_username);
        com.tencent.mm.br.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 1);
      }
      if (paramPreference.equals("room_clear_chatting_history"))
      {
        if (!this.dRx) {
          break label821;
        }
        paramf = getString(2131760819);
        label418:
        str = getString(2131764671);
        h.d local2 = new h.d()
        {
          public final void oj(int paramAnonymousInt)
          {
            AppMethodBeat.i(12738);
            switch (paramAnonymousInt)
            {
            default: 
              AppMethodBeat.o(12738);
              return;
            }
            RoomInfoDetailUI.a(RoomInfoDetailUI.this, false);
            Object localObject = RoomInfoDetailUI.this;
            RoomInfoDetailUI.this.getString(2131755998);
            final q localq = h.a((Context)localObject, RoomInfoDetailUI.this.getString(2131756029), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(12735);
                RoomInfoDetailUI.a(RoomInfoDetailUI.this, true);
                AppMethodBeat.o(12735);
              }
            });
            if (!RoomInfoDetailUI.a(RoomInfoDetailUI.this)) {}
            for (localObject = d.bfO(RoomInfoDetailUI.b(RoomInfoDetailUI.this).field_username);; localObject = null)
            {
              if (!Util.isNullOrNil((String)localObject))
              {
                localq.dismiss();
                h.a(RoomInfoDetailUI.this, false, RoomInfoDetailUI.this.getString(2131767654, new Object[] { localObject }), null, RoomInfoDetailUI.this.getString(2131761460), RoomInfoDetailUI.this.getString(2131757641), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(12736);
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, true);
                    paramAnonymous2DialogInterface = new Intent();
                    paramAnonymous2DialogInterface.putExtra("Chat_User", RoomInfoDetailUI.b(RoomInfoDetailUI.this).field_username);
                    paramAnonymous2DialogInterface.addFlags(67108864);
                    com.tencent.mm.br.c.f(RoomInfoDetailUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                    AppMethodBeat.o(12736);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(12737);
                    localq.show();
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, false);
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, localq);
                    AppMethodBeat.o(12737);
                  }
                }, -1, 2131099922);
                AppMethodBeat.o(12738);
                return;
              }
              RoomInfoDetailUI.a(RoomInfoDetailUI.this, localq);
              break;
            }
          }
        };
        h.a(this, paramf, new String[] { str }, null, local2);
      }
      if (paramPreference.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.guu, 0);
        if (this.contact != null)
        {
          if (!((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkg(this.contact.field_username)) {
            break label846;
          }
          ab.F(this.contact.field_username, true);
          label521:
          paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkg(this.contact.field_username)).commit();
        }
      }
      if ("room_show_msg_count".equals(paramPreference))
      {
        boolean bool3 = amU();
        Log.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool3) });
        if (bool3) {
          break label860;
        }
        bool1 = true;
        label618:
        paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.roomId);
        if (!bool1) {
          break label866;
        }
        paramf.oS(0);
        label651:
        Log.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[] { Boolean.valueOf(bool1) });
        ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().update(paramf, new String[0]);
        paramf = z.aTY();
        paramPreference = new cpi();
        paramPreference.KGO = this.roomId;
        paramPreference.UserName = paramf;
        paramPreference.Mvf = 2;
        if (!bool1) {
          break label874;
        }
        i = 2;
        label733:
        paramPreference.Cyb = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(49, paramPreference));
        if (this.gyx != null)
        {
          paramf = this.gyx;
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
      paramf.setChecked(bool1);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12744);
      return false;
      bool1 = false;
      break;
      i = 0;
      break label198;
      paramf = getString(2131760818, new Object[] { this.contact.arJ() });
      break label418;
      ab.E(this.contact.field_username, true);
      break label521;
      bool1 = false;
      break label618;
      paramf.oS(2);
      break label651;
      i = 1;
      break label733;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12742);
    super.onResume();
    amy();
    amW();
    SharedPreferences localSharedPreferences;
    if ((this.contact != null) && (this.gyw != null))
    {
      ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(this.roomId);
      localSharedPreferences = getSharedPreferences(this.guu, 0);
      if (!localah.gBx()) {
        break label117;
      }
      this.gyw.setChecked(true);
      localSharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12742);
      return;
      label117:
      this.gyw.setChecked(false);
      localSharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI
 * JD-Core Version:    0.7.0.1
 */