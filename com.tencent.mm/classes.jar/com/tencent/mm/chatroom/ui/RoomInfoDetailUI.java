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
import com.tencent.mm.bx.a;
import com.tencent.mm.chatroom.f.b;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.bqf;
import com.tencent.mm.protocal.protobuf.bqg;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
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
  private af contact;
  private boolean dph;
  private CheckBoxPreference fpX;
  private boolean fqk = false;
  private String fqx;
  private int fun;
  private SignaturePreference fuo;
  private CheckBoxPreference fup;
  private CheckBoxPreference fuq;
  private boolean isDeleteCancel = false;
  private String roomId;
  private f screen;
  
  private boolean VG()
  {
    AppMethodBeat.i(12746);
    if ((((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId).field_chatroomdataflag & 0x2) == 0)
    {
      AppMethodBeat.o(12746);
      return true;
    }
    AppMethodBeat.o(12746);
    return false;
  }
  
  private String VH()
  {
    AppMethodBeat.i(12747);
    Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
    if (localObject == null)
    {
      AppMethodBeat.o(12747);
      return "";
    }
    localObject = ((com.tencent.mm.storage.w)localObject).field_selfDisplayName;
    AppMethodBeat.o(12747);
    return localObject;
  }
  
  private void VI()
  {
    AppMethodBeat.i(12748);
    if ((this.contact != null) && (this.fuo != null))
    {
      Object localObject2 = VH();
      Object localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = u.aqI();
      }
      if (!bt.isNullOrNil((String)localObject1))
      {
        SignaturePreference localSignaturePreference = this.fuo;
        localObject2 = localObject1;
        if (((String)localObject1).length() <= 0) {
          localObject2 = getString(2131763409);
        }
        localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject2));
        AppMethodBeat.o(12748);
        return;
      }
      this.fuo.setSummary("");
    }
    AppMethodBeat.o(12748);
  }
  
  private void Vk()
  {
    boolean bool = true;
    AppMethodBeat.i(12749);
    if (!this.dph)
    {
      AppMethodBeat.o(12749);
      return;
    }
    Object localObject = getSharedPreferences(this.fqx, 0);
    if (this.fun == 0)
    {
      setTitleMuteIconVisibility(0);
      if (this.fpX != null)
      {
        this.fpX.lG = true;
        ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", true).commit();
      }
      if (this.fuq != null) {
        this.fuq.lG = VG();
      }
      localObject = this.screen;
      if (this.fun != 1) {
        break label179;
      }
    }
    for (;;)
    {
      ((f)localObject).cE("room_show_msg_count", bool);
      AppMethodBeat.o(12749);
      return;
      if (this.fun != 1) {
        break;
      }
      setTitleMuteIconVisibility(8);
      if (this.fpX == null) {
        break;
      }
      this.fpX.lG = false;
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
    this.fqx = (getPackageName() + "_preferences");
    this.dph = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    if (this.roomId == null) {
      this.roomId = getIntent().getStringExtra("Single_Chat_Talker");
    }
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
    if (this.dph)
    {
      this.fun = this.contact.evx;
      this.fuo = ((SignaturePreference)this.screen.aKk("room_name"));
      this.fpX = ((CheckBoxPreference)this.screen.aKk("room_msg_notify"));
      this.fuq = ((CheckBoxPreference)this.screen.aKk("room_show_msg_count"));
      this.fup = ((CheckBoxPreference)this.screen.aKk("room_msg_show_username"));
      this.fuq.GfV = false;
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
      this.fun = 1;
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
      str1 = bt.by(paramIntent.getStringExtra("Contact_Nick"), "");
    } while (bt.isNullOrNil(str1));
    String str2 = u.aqG();
    paramIntent = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
    if (paramIntent == null) {
      paramIntent = new com.tencent.mm.storage.w();
    }
    for (;;)
    {
      paramIntent.field_chatroomname = this.roomId;
      paramIntent.field_selfDisplayName = str1;
      ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().update(paramIntent, new String[0]);
      paramIntent = new bqf();
      paramIntent.Cxb = this.roomId;
      paramIntent.mAQ = str2;
      paramIntent.CVu = bt.nullAsNil(str1);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(48, paramIntent));
      VI();
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
    if (this.fqk)
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
      ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      String str = u.aqG();
      boolean bool = ((com.tencent.mm.storage.w)localObject).eKs();
      localObject = new bqg();
      ((bqg)localObject).Cxb = this.roomId;
      ((bqg)localObject).mAQ = str;
      ((bqg)localObject).DOl = 1;
      if (!bool) {
        break label154;
      }
    }
    label154:
    for (int i = 1;; i = 0)
    {
      ((bqg)localObject).vJA = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(49, (a)localObject));
      AppMethodBeat.o(12745);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    AppMethodBeat.i(12744);
    paramPreference = paramPreference.mKey;
    ad.d("MicroMsg.RoomInfoDetailUI", "click key : %s", new Object[] { paramPreference });
    String str;
    if (paramPreference.equals("room_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, e.h.class);
      paramf.putExtra("Contact_mode_name_type", 4);
      str = u.aqG();
      paramf.putExtra("Contact_Nick", VH());
      paramf.putExtra("Contact_User", str);
      paramf.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
      paramf.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
      getContext().startActivityForResult(paramf, 2);
    }
    int i;
    if (paramPreference.equals("room_msg_show_username"))
    {
      paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
      if (!paramf.eKs())
      {
        bool1 = true;
        paramf.va(bool1);
        this.fqk = true;
      }
    }
    else
    {
      if (paramPreference.equals("room_msg_notify"))
      {
        if (this.fun != 0) {
          break label816;
        }
        i = 1;
        label198:
        this.fun = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new b(this.roomId, this.fun));
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
        this.contact.jM(this.fun);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(this.roomId, this.contact);
        Vk();
        this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.roomId);
        this.screen.notifyDataSetChanged();
      }
      if (paramPreference.equals("room_set_chatting_background"))
      {
        paramf = new Intent();
        paramf.putExtra("isApplyToAll", false);
        paramf.putExtra("username", this.contact.field_username);
        com.tencent.mm.bs.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", paramf, 1);
      }
      if (paramPreference.equals("room_clear_chatting_history"))
      {
        if (!this.dph) {
          break label821;
        }
        paramf = getString(2131759504);
        label418:
        str = getString(2131762591);
        h.c local2 = new h.c()
        {
          public final void kM(int paramAnonymousInt)
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
            for (localObject = com.tencent.mm.pluginsdk.wallet.d.aCU(RoomInfoDetailUI.b(RoomInfoDetailUI.this).field_username);; localObject = null)
            {
              if (!bt.isNullOrNil((String)localObject))
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
                    com.tencent.mm.bs.d.e(RoomInfoDetailUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
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
        paramf = getSharedPreferences(this.fqx, 0);
        if (this.contact != null)
        {
          if (!((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIv(this.contact.field_username)) {
            break label846;
          }
          com.tencent.mm.model.w.D(this.contact.field_username, true);
          label521:
          paramf.edit().putBoolean("room_placed_to_the_top", ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().aIv(this.contact.field_username)).commit();
        }
      }
      if ("room_show_msg_count".equals(paramPreference))
      {
        boolean bool3 = VG();
        ad.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool3) });
        if (bool3) {
          break label860;
        }
        bool1 = true;
        label618:
        paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.roomId);
        if (!bool1) {
          break label866;
        }
        paramf.lt(0);
        label651:
        ad.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[] { Boolean.valueOf(bool1) });
        ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().update(paramf, new String[0]);
        paramf = u.aqG();
        paramPreference = new bqg();
        paramPreference.Cxb = this.roomId;
        paramPreference.mAQ = paramf;
        paramPreference.DOl = 2;
        if (!bool1) {
          break label874;
        }
        i = 2;
        label733:
        paramPreference.vJA = i;
        ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(49, paramPreference));
        if (this.fuq != null)
        {
          paramf = this.fuq;
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
      paramf.lG = bool1;
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12744);
      return false;
      bool1 = false;
      break;
      i = 0;
      break label198;
      paramf = getString(2131759503, new Object[] { this.contact.ZX() });
      break label418;
      com.tencent.mm.model.w.C(this.contact.field_username, true);
      break label521;
      bool1 = false;
      break label618;
      paramf.lt(2);
      break label651;
      i = 1;
      break label733;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12742);
    super.onResume();
    Vk();
    VI();
    SharedPreferences localSharedPreferences;
    if ((this.contact != null) && (this.fup != null))
    {
      com.tencent.mm.storage.w localw = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tI(this.roomId);
      localSharedPreferences = getSharedPreferences(this.fqx, 0);
      if (!localw.eKs()) {
        break label117;
      }
      this.fup.lG = true;
      localSharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12742);
      return;
      label117:
      this.fup.lG = false;
      localSharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI
 * JD-Core Version:    0.7.0.1
 */