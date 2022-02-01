package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.br.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dpd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.l;

@Deprecated
public class RoomInfoDetailUI
  extends MMPreference
  implements MStorage.IOnStorageChange
{
  private au contact;
  private boolean hQu;
  private boolean isDeleteCancel = false;
  private boolean lAk = false;
  private String lAv;
  private int lKR;
  private SignaturePreference lKS;
  private CheckBoxPreference lKT;
  private CheckBoxPreference lKU;
  private CheckBoxPreference lzY;
  private String roomId;
  private f screen;
  
  private boolean aMW()
  {
    AppMethodBeat.i(12746);
    if ((((b)h.ax(b.class)).bzK().Ju(this.roomId).field_chatroomdataflag & 0x2) == 0)
    {
      AppMethodBeat.o(12746);
      return true;
    }
    AppMethodBeat.o(12746);
    return false;
  }
  
  private String aMX()
  {
    AppMethodBeat.i(12747);
    Object localObject = ((b)h.ax(b.class)).bzK().Ju(this.roomId);
    if (localObject == null)
    {
      AppMethodBeat.o(12747);
      return "";
    }
    localObject = ((aj)localObject).field_selfDisplayName;
    AppMethodBeat.o(12747);
    return localObject;
  }
  
  private void aMY()
  {
    AppMethodBeat.i(12748);
    if ((this.contact != null) && (this.lKS != null))
    {
      Object localObject2 = aMX();
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = z.bAO();
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        SignaturePreference localSignaturePreference = this.lKS;
        localObject2 = localObject1;
        if (((String)localObject1).length() <= 0) {
          localObject2 = getString(a.i.settings_signature_empty);
        }
        localSignaturePreference.aS(p.b(this, (CharSequence)localObject2));
        AppMethodBeat.o(12748);
        return;
      }
      this.lKS.aS("");
    }
    AppMethodBeat.o(12748);
  }
  
  private void aMp()
  {
    boolean bool = true;
    AppMethodBeat.i(12749);
    if (!this.hQu)
    {
      AppMethodBeat.o(12749);
      return;
    }
    Object localObject = getSharedPreferences(this.lAv, 0);
    if (this.lKR == 0)
    {
      setTitleMuteIconVisibility(0);
      if (this.lzY != null)
      {
        this.lzY.setChecked(true);
        ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", true).commit();
      }
      if (this.lKU != null) {
        this.lKU.setChecked(aMW());
      }
      localObject = this.screen;
      if (this.lKR != 1) {
        break label179;
      }
    }
    for (;;)
    {
      ((f)localObject).eh("room_show_msg_count", bool);
      AppMethodBeat.o(12749);
      return;
      if (this.lKR != 1) {
        break;
      }
      setTitleMuteIconVisibility(8);
      if (this.lzY == null) {
        break;
      }
      this.lzY.setChecked(false);
      ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", false).commit();
      break;
      label179:
      bool = false;
    }
  }
  
  public int getResourceId()
  {
    return a.k.lJX;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12743);
    setMMTitle(a.i.lJo);
    this.screen = getPreferenceScreen();
    this.lAv = (getPackageName() + "_preferences");
    this.hQu = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    if (this.roomId == null) {
      this.roomId = getIntent().getStringExtra("Single_Chat_Talker");
    }
    this.contact = ((n)h.ax(n.class)).bzA().JE(this.roomId);
    if (this.hQu)
    {
      this.lKR = this.contact.kaf;
      this.lKS = ((SignaturePreference)this.screen.bAi("room_name"));
      this.lzY = ((CheckBoxPreference)this.screen.bAi("room_msg_notify"));
      this.lKU = ((CheckBoxPreference)this.screen.bAi("room_show_msg_count"));
      this.lKT = ((CheckBoxPreference)this.screen.bAi("room_msg_show_username"));
      this.lKU.adZV = false;
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
      this.lKR = 1;
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
    String str2 = z.bAM();
    paramIntent = ((b)h.ax(b.class)).bzK().Ju(this.roomId);
    if (paramIntent == null) {
      paramIntent = new aj();
    }
    for (;;)
    {
      paramIntent.field_chatroomname = this.roomId;
      paramIntent.field_selfDisplayName = str1;
      ((b)h.ax(b.class)).bzK().update(paramIntent, new String[0]);
      paramIntent = new dpc();
      paramIntent.YFk = this.roomId;
      paramIntent.UserName = str2;
      paramIntent.ZhN = Util.nullAsNil(str1);
      ((n)h.ax(n.class)).bzz().d(new k.a(48, paramIntent));
      aMY();
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
    if (this.lAk)
    {
      localObject = ((b)h.ax(b.class)).bzK().Ju(this.roomId);
      ((b)h.ax(b.class)).bzK().update((IAutoDBItem)localObject, new String[0]);
      String str = z.bAM();
      boolean bool = ((aj)localObject).iZn();
      localObject = new dpd();
      ((dpd)localObject).YFk = this.roomId;
      ((dpd)localObject).UserName = str;
      ((dpd)localObject).aaVJ = 1;
      if (!bool) {
        break label155;
      }
    }
    label155:
    for (int i = 1;; i = 0)
    {
      ((dpd)localObject).OzH = i;
      ((n)h.ax(n.class)).bzz().d(new k.a(49, (com.tencent.mm.bx.a)localObject));
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
      paramf.setClass(this, f.l.class);
      paramf.putExtra("Contact_mode_name_type", 4);
      str = z.bAM();
      paramf.putExtra("Contact_Nick", aMX());
      paramf.putExtra("Contact_User", str);
      paramf.putExtra("MMActivity.OverrideEnterAnimation", a.a.fast_faded_in);
      paramf.putExtra("MMActivity.OverrideExitAnimation", a.a.push_down_out);
      getContext().startActivityForResult(paramf, 2);
    }
    int i;
    if (paramPreference.equals("room_msg_show_username"))
    {
      paramf = ((b)h.ax(b.class)).bzK().Ju(this.roomId);
      if (!paramf.iZn())
      {
        bool1 = true;
        paramf.KD(bool1);
        this.lAk = true;
      }
    }
    else
    {
      if (paramPreference.equals("room_msg_notify"))
      {
        if (this.lKR != 0) {
          break label823;
        }
        i = 1;
        label198:
        this.lKR = i;
        ((n)h.ax(n.class)).bzz().d(new com.tencent.mm.chatroom.f.a(this.roomId, this.lKR));
        this.contact = ((n)h.ax(n.class)).bzA().JE(this.roomId);
        this.contact.pz(this.lKR);
        ((n)h.ax(n.class)).bzA().d(this.roomId, this.contact);
        aMp();
        this.contact = ((n)h.ax(n.class)).bzA().JE(this.roomId);
        this.screen.notifyDataSetChanged();
      }
      if (paramPreference.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.contact.field_username);
        c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 1);
      }
      if (paramPreference.equals("room_clear_chatting_history"))
      {
        if (!this.hQu) {
          break label828;
        }
        paramf = getString(a.i.lHA);
        label422:
        str = getString(a.i.lIe);
        k.d local2 = new k.d()
        {
          public final void qz(int paramAnonymousInt)
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
            RoomInfoDetailUI.this.getString(a.i.app_tip);
            final w localw = k.a((Context)localObject, RoomInfoDetailUI.this.getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(12735);
                RoomInfoDetailUI.a(RoomInfoDetailUI.this, true);
                AppMethodBeat.o(12735);
              }
            });
            if (!RoomInfoDetailUI.a(RoomInfoDetailUI.this)) {}
            for (localObject = d.brY(RoomInfoDetailUI.b(RoomInfoDetailUI.this).field_username);; localObject = null)
            {
              if (!Util.isNullOrNil((String)localObject))
              {
                localw.dismiss();
                k.a(RoomInfoDetailUI.this, false, RoomInfoDetailUI.this.getString(a.i.gYD, new Object[] { localObject }), null, RoomInfoDetailUI.this.getString(a.i.goto_conversation), RoomInfoDetailUI.this.getString(a.i.gAs), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(12736);
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, true);
                    paramAnonymous2DialogInterface = new Intent();
                    paramAnonymous2DialogInterface.putExtra("Chat_User", RoomInfoDetailUI.b(RoomInfoDetailUI.this).field_username);
                    paramAnonymous2DialogInterface.addFlags(67108864);
                    c.g(RoomInfoDetailUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                    AppMethodBeat.o(12736);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(12737);
                    localw.show();
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, false);
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, localw);
                    AppMethodBeat.o(12737);
                  }
                }, -1, a.b.alert_btn_color_warn);
                AppMethodBeat.o(12738);
                return;
              }
              RoomInfoDetailUI.a(RoomInfoDetailUI.this, localw);
              break;
            }
          }
        };
        k.a(this, paramf, new String[] { str }, null, local2);
      }
      if (paramPreference.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.lAv, 0);
        if (this.contact != null)
        {
          if (!((n)h.ax(n.class)).bzG().bxV(this.contact.field_username)) {
            break label853;
          }
          ab.L(this.contact.field_username, true);
          label526:
          paramf.edit().putBoolean("room_placed_to_the_top", ((n)h.ax(n.class)).bzG().bxV(this.contact.field_username)).commit();
        }
      }
      if ("room_show_msg_count".equals(paramPreference))
      {
        boolean bool3 = aMW();
        Log.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool3) });
        if (bool3) {
          break label867;
        }
        bool1 = true;
        label624:
        paramf = ((b)h.ax(b.class)).bzK().Ju(this.roomId);
        if (!bool1) {
          break label873;
        }
        paramf.rt(0);
        label657:
        Log.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[] { Boolean.valueOf(bool1) });
        ((b)h.ax(b.class)).bzK().update(paramf, new String[0]);
        paramf = z.bAM();
        paramPreference = new dpd();
        paramPreference.YFk = this.roomId;
        paramPreference.UserName = paramf;
        paramPreference.aaVJ = 2;
        if (!bool1) {
          break label881;
        }
        i = 2;
        label739:
        paramPreference.OzH = i;
        ((n)h.ax(n.class)).bzz().d(new k.a(49, paramPreference));
        if (this.lKU != null)
        {
          paramf = this.lKU;
          if (bool3) {
            break label886;
          }
        }
      }
    }
    label823:
    label828:
    label853:
    label867:
    label873:
    label881:
    label886:
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
      paramf = getString(a.i.gIr, new Object[] { this.contact.aSV() });
      break label422;
      ab.K(this.contact.field_username, true);
      break label526;
      bool1 = false;
      break label624;
      paramf.rt(2);
      break label657;
      i = 1;
      break label739;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12742);
    super.onResume();
    aMp();
    aMY();
    SharedPreferences localSharedPreferences;
    if ((this.contact != null) && (this.lKT != null))
    {
      aj localaj = ((b)h.ax(b.class)).bzK().Jv(this.roomId);
      localSharedPreferences = getSharedPreferences(this.lAv, 0);
      if (!localaj.iZn()) {
        break label117;
      }
      this.lKT.setChecked(true);
      localSharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12742);
      return;
      label117:
      this.lKT.setChecked(false);
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