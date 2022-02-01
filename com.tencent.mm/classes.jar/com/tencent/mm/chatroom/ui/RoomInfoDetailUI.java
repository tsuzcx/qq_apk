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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.cag;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
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
  implements com.tencent.mm.sdk.e.k.a
{
  private an contact;
  private boolean dzK;
  private CheckBoxPreference fOL;
  private boolean fOY = false;
  private String fPk;
  private int fTn;
  private SignaturePreference fTo;
  private CheckBoxPreference fTp;
  private CheckBoxPreference fTq;
  private boolean isDeleteCancel = false;
  private String roomId;
  private f screen;
  
  private void YL()
  {
    boolean bool = true;
    AppMethodBeat.i(12749);
    if (!this.dzK)
    {
      AppMethodBeat.o(12749);
      return;
    }
    Object localObject = getSharedPreferences(this.fPk, 0);
    if (this.fTn == 0)
    {
      setTitleMuteIconVisibility(0);
      if (this.fOL != null)
      {
        this.fOL.setChecked(true);
        ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", true).commit();
      }
      if (this.fTq != null) {
        this.fTq.setChecked(Zh());
      }
      localObject = this.screen;
      if (this.fTn != 1) {
        break label179;
      }
    }
    for (;;)
    {
      ((f)localObject).cT("room_show_msg_count", bool);
      AppMethodBeat.o(12749);
      return;
      if (this.fTn != 1) {
        break;
      }
      setTitleMuteIconVisibility(8);
      if (this.fOL == null) {
        break;
      }
      this.fOL.setChecked(false);
      ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", false).commit();
      break;
      label179:
      bool = false;
    }
  }
  
  private boolean Zh()
  {
    AppMethodBeat.i(12746);
    if ((((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId).field_chatroomdataflag & 0x2) == 0)
    {
      AppMethodBeat.o(12746);
      return true;
    }
    AppMethodBeat.o(12746);
    return false;
  }
  
  private String Zi()
  {
    AppMethodBeat.i(12747);
    Object localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
    if (localObject == null)
    {
      AppMethodBeat.o(12747);
      return "";
    }
    localObject = ((ac)localObject).field_selfDisplayName;
    AppMethodBeat.o(12747);
    return localObject;
  }
  
  private void Zj()
  {
    AppMethodBeat.i(12748);
    if ((this.contact != null) && (this.fTo != null))
    {
      Object localObject2 = Zi();
      Object localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = v.aAE();
      }
      if (!bu.isNullOrNil((String)localObject1))
      {
        SignaturePreference localSignaturePreference = this.fTo;
        localObject2 = localObject1;
        if (((String)localObject1).length() <= 0) {
          localObject2 = getString(2131763409);
        }
        localSignaturePreference.setSummary(k.c(this, (CharSequence)localObject2));
        AppMethodBeat.o(12748);
        return;
      }
      this.fTo.setSummary("");
    }
    AppMethodBeat.o(12748);
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
    this.fPk = (getPackageName() + "_preferences");
    this.dzK = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    if (this.roomId == null) {
      this.roomId = getIntent().getStringExtra("Single_Chat_Talker");
    }
    this.contact = ((l)g.ab(l.class)).azF().BH(this.roomId);
    if (this.dzK)
    {
      this.fTn = this.contact.eRd;
      this.fTo = ((SignaturePreference)this.screen.aXe("room_name"));
      this.fOL = ((CheckBoxPreference)this.screen.aXe("room_msg_notify"));
      this.fTq = ((CheckBoxPreference)this.screen.aXe("room_show_msg_count"));
      this.fTp = ((CheckBoxPreference)this.screen.aXe("room_msg_show_username"));
      this.fTq.JOq = false;
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
      this.fTn = 1;
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
      str1 = bu.bI(paramIntent.getStringExtra("Contact_Nick"), "");
    } while (bu.isNullOrNil(str1));
    String str2 = v.aAC();
    paramIntent = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
    if (paramIntent == null) {
      paramIntent = new ac();
    }
    for (;;)
    {
      paramIntent.field_chatroomname = this.roomId;
      paramIntent.field_selfDisplayName = str1;
      ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().update(paramIntent, new String[0]);
      paramIntent = new caf();
      paramIntent.FNj = this.roomId;
      paramIntent.nIJ = str2;
      paramIntent.GnM = bu.nullAsNil(str1);
      ((l)g.ab(l.class)).azE().d(new com.tencent.mm.plugin.messenger.foundation.a.a.k.a(48, paramIntent));
      Zj();
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
    if (this.fOY)
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
      ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().update((com.tencent.mm.sdk.e.c)localObject, new String[0]);
      String str = v.aAC();
      boolean bool = ((ac)localObject).ftR();
      localObject = new cag();
      ((cag)localObject).FNj = this.roomId;
      ((cag)localObject).nIJ = str;
      ((cag)localObject).HnL = 1;
      if (!bool) {
        break label154;
      }
    }
    label154:
    for (int i = 1;; i = 0)
    {
      ((cag)localObject).yxf = i;
      ((l)g.ab(l.class)).azE().d(new com.tencent.mm.plugin.messenger.foundation.a.a.k.a(49, (com.tencent.mm.bw.a)localObject));
      AppMethodBeat.o(12745);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    AppMethodBeat.i(12744);
    paramPreference = paramPreference.mKey;
    ae.d("MicroMsg.RoomInfoDetailUI", "click key : %s", new Object[] { paramPreference });
    String str;
    if (paramPreference.equals("room_name"))
    {
      paramf = new Intent();
      paramf.setClass(this, e.h.class);
      paramf.putExtra("Contact_mode_name_type", 4);
      str = v.aAC();
      paramf.putExtra("Contact_Nick", Zi());
      paramf.putExtra("Contact_User", str);
      paramf.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
      paramf.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
      getContext().startActivityForResult(paramf, 2);
    }
    int i;
    if (paramPreference.equals("room_msg_show_username"))
    {
      paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
      if (!paramf.ftR())
      {
        bool1 = true;
        paramf.wX(bool1);
        this.fOY = true;
      }
    }
    else
    {
      if (paramPreference.equals("room_msg_notify"))
      {
        if (this.fTn != 0) {
          break label816;
        }
        i = 1;
        label198:
        this.fTn = i;
        ((l)g.ab(l.class)).azE().d(new com.tencent.mm.chatroom.f.a(this.roomId, this.fTn));
        this.contact = ((l)g.ab(l.class)).azF().BH(this.roomId);
        this.contact.kk(this.fTn);
        ((l)g.ab(l.class)).azF().c(this.roomId, this.contact);
        YL();
        this.contact = ((l)g.ab(l.class)).azF().BH(this.roomId);
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
        if (!this.dzK) {
          break label821;
        }
        paramf = getString(2131759504);
        label418:
        str = getString(2131762591);
        h.c local2 = new h.c()
        {
          public final void lh(int paramAnonymousInt)
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
            for (localObject = com.tencent.mm.pluginsdk.wallet.d.aPl(RoomInfoDetailUI.b(RoomInfoDetailUI.this).field_username);; localObject = null)
            {
              if (!bu.isNullOrNil((String)localObject))
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
                    com.tencent.mm.br.d.f(RoomInfoDetailUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
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
        paramf = getSharedPreferences(this.fPk, 0);
        if (this.contact != null)
        {
          if (!((l)g.ab(l.class)).azL().aVi(this.contact.field_username)) {
            break label846;
          }
          x.E(this.contact.field_username, true);
          label521:
          paramf.edit().putBoolean("room_placed_to_the_top", ((l)g.ab(l.class)).azL().aVi(this.contact.field_username)).commit();
        }
      }
      if ("room_show_msg_count".equals(paramPreference))
      {
        boolean bool3 = Zh();
        ae.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool3) });
        if (bool3) {
          break label860;
        }
        bool1 = true;
        label618:
        paramf = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.roomId);
        if (!bool1) {
          break label866;
        }
        paramf.lP(0);
        label651:
        ae.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[] { Boolean.valueOf(bool1) });
        ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().update(paramf, new String[0]);
        paramf = v.aAC();
        paramPreference = new cag();
        paramPreference.FNj = this.roomId;
        paramPreference.nIJ = paramf;
        paramPreference.HnL = 2;
        if (!bool1) {
          break label874;
        }
        i = 2;
        label733:
        paramPreference.yxf = i;
        ((l)g.ab(l.class)).azE().d(new com.tencent.mm.plugin.messenger.foundation.a.a.k.a(49, paramPreference));
        if (this.fTq != null)
        {
          paramf = this.fTq;
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
      paramf = getString(2131759503, new Object[] { this.contact.adG() });
      break label418;
      x.D(this.contact.field_username, true);
      break label521;
      bool1 = false;
      break label618;
      paramf.lP(2);
      break label651;
      i = 1;
      break label733;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12742);
    super.onResume();
    YL();
    Zj();
    SharedPreferences localSharedPreferences;
    if ((this.contact != null) && (this.fTp != null))
    {
      ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().By(this.roomId);
      localSharedPreferences = getSharedPreferences(this.fPk, 0);
      if (!localac.ftR()) {
        break label117;
      }
      this.fTp.setChecked(true);
      localSharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12742);
      return;
      label117:
      this.fTp.setChecked(false);
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