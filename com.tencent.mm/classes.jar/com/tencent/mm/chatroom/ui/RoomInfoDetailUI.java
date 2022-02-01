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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.buw;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.h;

@Deprecated
public class RoomInfoDetailUI
  extends MMPreference
  implements k.a
{
  private ai contact;
  private boolean dmR;
  private CheckBoxPreference ftB;
  private boolean ftO = false;
  private String fub;
  private int fxU;
  private SignaturePreference fxV;
  private CheckBoxPreference fxW;
  private CheckBoxPreference fxX;
  private boolean isDeleteCancel = false;
  private String roomId;
  private f screen;
  
  private boolean WE()
  {
    AppMethodBeat.i(12746);
    if ((((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId).field_chatroomdataflag & 0x2) == 0)
    {
      AppMethodBeat.o(12746);
      return true;
    }
    AppMethodBeat.o(12746);
    return false;
  }
  
  private String WF()
  {
    AppMethodBeat.i(12747);
    Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
    if (localObject == null)
    {
      AppMethodBeat.o(12747);
      return "";
    }
    localObject = ((x)localObject).field_selfDisplayName;
    AppMethodBeat.o(12747);
    return localObject;
  }
  
  private void WG()
  {
    AppMethodBeat.i(12748);
    if ((this.contact != null) && (this.fxV != null))
    {
      Object localObject2 = WF();
      Object localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        localObject1 = u.axy();
      }
      if (!bs.isNullOrNil((String)localObject1))
      {
        SignaturePreference localSignaturePreference = this.fxV;
        localObject2 = localObject1;
        if (((String)localObject1).length() <= 0) {
          localObject2 = getString(2131763409);
        }
        localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject2));
        AppMethodBeat.o(12748);
        return;
      }
      this.fxV.setSummary("");
    }
    AppMethodBeat.o(12748);
  }
  
  private void Wj()
  {
    boolean bool = true;
    AppMethodBeat.i(12749);
    if (!this.dmR)
    {
      AppMethodBeat.o(12749);
      return;
    }
    Object localObject = getSharedPreferences(this.fub, 0);
    if (this.fxU == 0)
    {
      setTitleMuteIconVisibility(0);
      if (this.ftB != null)
      {
        this.ftB.mF = true;
        ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", true).commit();
      }
      if (this.fxX != null) {
        this.fxX.mF = WE();
      }
      localObject = this.screen;
      if (this.fxU != 1) {
        break label179;
      }
    }
    for (;;)
    {
      ((f)localObject).cK("room_show_msg_count", bool);
      AppMethodBeat.o(12749);
      return;
      if (this.fxU != 1) {
        break;
      }
      setTitleMuteIconVisibility(8);
      if (this.ftB == null) {
        break;
      }
      this.ftB.mF = false;
      ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", false).commit();
      break;
      label179:
      bool = false;
    }
  }
  
  public final void a(String paramString, m paramm) {}
  
  public int getResourceId()
  {
    return 2131951706;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12743);
    setMMTitle(2131762728);
    this.screen = getPreferenceScreen();
    this.fub = (getPackageName() + "_preferences");
    this.dmR = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    if (this.roomId == null) {
      this.roomId = getIntent().getStringExtra("Single_Chat_Talker");
    }
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
    if (this.dmR)
    {
      this.fxU = this.contact.exT;
      this.fxV = ((SignaturePreference)this.screen.aPN("room_name"));
      this.ftB = ((CheckBoxPreference)this.screen.aPN("room_msg_notify"));
      this.fxX = ((CheckBoxPreference)this.screen.aPN("room_show_msg_count"));
      this.fxW = ((CheckBoxPreference)this.screen.aPN("room_msg_show_username"));
      this.fxX.HFK = false;
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
      this.fxU = 1;
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
      str1 = bs.bG(paramIntent.getStringExtra("Contact_Nick"), "");
    } while (bs.isNullOrNil(str1));
    String str2 = u.axw();
    paramIntent = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
    if (paramIntent == null) {
      paramIntent = new x();
    }
    for (;;)
    {
      paramIntent.field_chatroomname = this.roomId;
      paramIntent.field_selfDisplayName = str1;
      ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().update(paramIntent, new String[0]);
      paramIntent = new buw();
      paramIntent.DPx = this.roomId;
      paramIntent.ncR = str2;
      paramIntent.Eoe = bs.nullAsNil(str1);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(48, paramIntent));
      WG();
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
  
  public void onPause()
  {
    AppMethodBeat.i(12745);
    super.onPause();
    Object localObject;
    if (this.ftO)
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
      ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      String str = u.axw();
      boolean bool = ((x)localObject).eZP();
      localObject = new bux();
      ((bux)localObject).DPx = this.roomId;
      ((bux)localObject).ncR = str;
      ((bux)localObject).FkC = 1;
      if (!bool) {
        break label154;
      }
    }
    label154:
    for (int i = 1;; i = 0)
    {
      ((bux)localObject).wTE = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(49, (com.tencent.mm.bw.a)localObject));
      AppMethodBeat.o(12745);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    AppMethodBeat.i(12744);
    paramPreference = paramPreference.mKey;
    ac.d("MicroMsg.RoomInfoDetailUI", "click key : %s", new Object[] { paramPreference });
    String str;
    if (paramPreference.equals("room_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, e.h.class);
      paramf.putExtra("Contact_mode_name_type", 4);
      str = u.axw();
      paramf.putExtra("Contact_Nick", WF());
      paramf.putExtra("Contact_User", str);
      paramf.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
      paramf.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
      getContext().startActivityForResult(paramf, 2);
    }
    int i;
    if (paramPreference.equals("room_msg_show_username"))
    {
      paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
      if (!paramf.eZP())
      {
        bool1 = true;
        paramf.wc(bool1);
        this.ftO = true;
      }
    }
    else
    {
      if (paramPreference.equals("room_msg_notify"))
      {
        if (this.fxU != 0) {
          break label816;
        }
        i = 1;
        label198:
        this.fxU = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new com.tencent.mm.chatroom.f.a(this.roomId, this.fxU));
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
        this.contact.jK(this.fxU);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(this.roomId, this.contact);
        Wj();
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.roomId);
        this.screen.notifyDataSetChanged();
      }
      if (paramPreference.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.contact.field_username);
        com.tencent.mm.br.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 1);
      }
      if (paramPreference.equals("room_clear_chatting_history"))
      {
        if (!this.dmR) {
          break label821;
        }
        paramf = getString(2131759504);
        label418:
        str = getString(2131762591);
        h.c local2 = new h.c()
        {
          public final void kG(int paramAnonymousInt)
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
            RoomInfoDetailUI.this.getString(2131755906);
            final p localp = h.b((Context)localObject, RoomInfoDetailUI.this.getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(12735);
                RoomInfoDetailUI.a(RoomInfoDetailUI.this, true);
                AppMethodBeat.o(12735);
              }
            });
            if (!RoomInfoDetailUI.a(RoomInfoDetailUI.this)) {}
            for (localObject = com.tencent.mm.pluginsdk.wallet.d.aIl(RoomInfoDetailUI.b(RoomInfoDetailUI.this).field_username);; localObject = null)
            {
              if (!bs.isNullOrNil((String)localObject))
              {
                localp.dismiss();
                h.a(RoomInfoDetailUI.this, false, RoomInfoDetailUI.this.getString(2131765211, new Object[] { localObject }), null, RoomInfoDetailUI.this.getString(2131760081), RoomInfoDetailUI.this.getString(2131757424), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(12736);
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, true);
                    paramAnonymous2DialogInterface = new Intent();
                    paramAnonymous2DialogInterface.putExtra("Chat_User", RoomInfoDetailUI.b(RoomInfoDetailUI.this).field_username);
                    paramAnonymous2DialogInterface.addFlags(67108864);
                    com.tencent.mm.br.d.e(RoomInfoDetailUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                    AppMethodBeat.o(12736);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(12737);
                    localp.show();
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, false);
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, localp);
                    AppMethodBeat.o(12737);
                  }
                }, -1, 2131099904);
                AppMethodBeat.o(12738);
                return;
              }
              RoomInfoDetailUI.a(RoomInfoDetailUI.this, localp);
              break;
            }
          }
        };
        h.a(this, paramf, new String[] { str }, null, local2);
      }
      if (paramPreference.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.fub, 0);
        if (this.contact != null)
        {
          if (!((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNQ(this.contact.field_username)) {
            break label846;
          }
          w.E(this.contact.field_username, true);
          label521:
          paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().aNQ(this.contact.field_username)).commit();
        }
      }
      if ("room_show_msg_count".equals(paramPreference))
      {
        boolean bool3 = WE();
        ac.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool3) });
        if (bool3) {
          break label860;
        }
        bool1 = true;
        label618:
        paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.roomId);
        if (!bool1) {
          break label866;
        }
        paramf.lo(0);
        label651:
        ac.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[] { Boolean.valueOf(bool1) });
        ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().update(paramf, new String[0]);
        paramf = u.axw();
        paramPreference = new bux();
        paramPreference.DPx = this.roomId;
        paramPreference.ncR = paramf;
        paramPreference.FkC = 2;
        if (!bool1) {
          break label874;
        }
        i = 2;
        label733:
        paramPreference.wTE = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(49, paramPreference));
        if (this.fxX != null)
        {
          paramf = this.fxX;
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
      paramf.mF = bool1;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12744);
      return false;
      bool1 = false;
      break;
      i = 0;
      break label198;
      paramf = getString(2131759503, new Object[] { this.contact.aaS() });
      break label418;
      w.D(this.contact.field_username, true);
      break label521;
      bool1 = false;
      break label618;
      paramf.lo(2);
      break label651;
      i = 1;
      break label733;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12742);
    super.onResume();
    Wj();
    WG();
    SharedPreferences localSharedPreferences;
    if ((this.contact != null) && (this.fxW != null))
    {
      x localx = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xO(this.roomId);
      localSharedPreferences = getSharedPreferences(this.fub, 0);
      if (!localx.eZP()) {
        break label117;
      }
      this.fxW.mF = true;
      localSharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12742);
      return;
      label117:
      this.fxW.mF = false;
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