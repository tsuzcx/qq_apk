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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.f.k;

@Deprecated
public class RoomInfoDetailUI
  extends MMPreference
  implements MStorage.IOnStorageChange
{
  private as contact;
  private boolean fKN;
  private String iYF;
  private CheckBoxPreference iYg;
  private boolean iYt = false;
  private boolean isDeleteCancel = false;
  private CheckBoxPreference jiA;
  private int jix;
  private SignaturePreference jiy;
  private CheckBoxPreference jiz;
  private String roomId;
  private f screen;
  
  private boolean asV()
  {
    AppMethodBeat.i(12746);
    if ((((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(this.roomId).field_chatroomdataflag & 0x2) == 0)
    {
      AppMethodBeat.o(12746);
      return true;
    }
    AppMethodBeat.o(12746);
    return false;
  }
  
  private String asW()
  {
    AppMethodBeat.i(12747);
    Object localObject = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(this.roomId);
    if (localObject == null)
    {
      AppMethodBeat.o(12747);
      return "";
    }
    localObject = ((ah)localObject).field_selfDisplayName;
    AppMethodBeat.o(12747);
    return localObject;
  }
  
  private void asX()
  {
    AppMethodBeat.i(12748);
    if ((this.contact != null) && (this.jiy != null))
    {
      Object localObject2 = asW();
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = z.bdb();
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        SignaturePreference localSignaturePreference = this.jiy;
        localObject2 = localObject1;
        if (((String)localObject1).length() <= 0) {
          localObject2 = getString(a.i.settings_signature_empty);
        }
        localSignaturePreference.aF(l.c(this, (CharSequence)localObject2));
        AppMethodBeat.o(12748);
        return;
      }
      this.jiy.aF("");
    }
    AppMethodBeat.o(12748);
  }
  
  private void asz()
  {
    boolean bool = true;
    AppMethodBeat.i(12749);
    if (!this.fKN)
    {
      AppMethodBeat.o(12749);
      return;
    }
    Object localObject = getSharedPreferences(this.iYF, 0);
    if (this.jix == 0)
    {
      setTitleMuteIconVisibility(0);
      if (this.iYg != null)
      {
        this.iYg.setChecked(true);
        ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", true).commit();
      }
      if (this.jiA != null) {
        this.jiA.setChecked(asV());
      }
      localObject = this.screen;
      if (this.jix != 1) {
        break label179;
      }
    }
    for (;;)
    {
      ((f)localObject).dz("room_show_msg_count", bool);
      AppMethodBeat.o(12749);
      return;
      if (this.jix != 1) {
        break;
      }
      setTitleMuteIconVisibility(8);
      if (this.iYg == null) {
        break;
      }
      this.iYg.setChecked(false);
      ((SharedPreferences)localObject).edit().putBoolean("room_msg_notify", false).commit();
      break;
      label179:
      bool = false;
    }
  }
  
  public int getResourceId()
  {
    return a.k.jhH;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12743);
    setMMTitle(a.i.jgY);
    this.screen = getPreferenceScreen();
    this.iYF = (getPackageName() + "_preferences");
    this.fKN = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.roomId = getIntent().getStringExtra("RoomInfo_Id");
    if (this.roomId == null) {
      this.roomId = getIntent().getStringExtra("Single_Chat_Talker");
    }
    this.contact = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.roomId);
    if (this.fKN)
    {
      this.jix = this.contact.hDj;
      this.jiy = ((SignaturePreference)this.screen.byG("room_name"));
      this.iYg = ((CheckBoxPreference)this.screen.byG("room_msg_notify"));
      this.jiA = ((CheckBoxPreference)this.screen.byG("room_show_msg_count"));
      this.jiz = ((CheckBoxPreference)this.screen.byG("room_msg_show_username"));
      this.jiA.WsF = false;
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
      this.jix = 1;
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
    String str2 = z.bcZ();
    paramIntent = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(this.roomId);
    if (paramIntent == null) {
      paramIntent = new ah();
    }
    for (;;)
    {
      paramIntent.field_chatroomname = this.roomId;
      paramIntent.field_selfDisplayName = str1;
      ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().update(paramIntent, new String[0]);
      paramIntent = new cxx();
      paramIntent.RIi = this.roomId;
      paramIntent.UserName = str2;
      paramIntent.SjH = Util.nullAsNil(str1);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(48, paramIntent));
      asX();
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
    if (this.iYt)
    {
      localObject = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(this.roomId);
      ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().update((IAutoDBItem)localObject, new String[0]);
      String str = z.bcZ();
      boolean bool = ((ah)localObject).hxI();
      localObject = new cxy();
      ((cxy)localObject).RIi = this.roomId;
      ((cxy)localObject).UserName = str;
      ((cxy)localObject).TGd = 1;
      if (!bool) {
        break label155;
      }
    }
    label155:
    for (int i = 1;; i = 0)
    {
      ((cxy)localObject).Iza = i;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(49, (com.tencent.mm.cd.a)localObject));
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
      paramf.setClass(this, f.k.class);
      paramf.putExtra("Contact_mode_name_type", 4);
      str = z.bcZ();
      paramf.putExtra("Contact_Nick", asW());
      paramf.putExtra("Contact_User", str);
      paramf.putExtra("MMActivity.OverrideEnterAnimation", a.a.fast_faded_in);
      paramf.putExtra("MMActivity.OverrideExitAnimation", a.a.push_down_out);
      getContext().startActivityForResult(paramf, 2);
    }
    int i;
    if (paramPreference.equals("room_msg_show_username"))
    {
      paramf = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(this.roomId);
      if (!paramf.hxI())
      {
        bool1 = true;
        paramf.ET(bool1);
        this.iYt = true;
      }
    }
    else
    {
      if (paramPreference.equals("room_msg_notify"))
      {
        if (this.jix != 0) {
          break label823;
        }
        i = 1;
        label198:
        this.jix = i;
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new com.tencent.mm.chatroom.f.a(this.roomId, this.jix));
        this.contact = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.roomId);
        this.contact.pA(this.jix);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().c(this.roomId, this.contact);
        asz();
        this.contact = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.roomId);
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
        if (!this.fKN) {
          break label828;
        }
        paramf = getString(a.i.jfp);
        label422:
        str = getString(a.i.jfS);
        h.d local2 = new h.d()
        {
          public final void qy(int paramAnonymousInt)
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
            final s locals = com.tencent.mm.ui.base.h.a((Context)localObject, RoomInfoDetailUI.this.getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(12735);
                RoomInfoDetailUI.a(RoomInfoDetailUI.this, true);
                AppMethodBeat.o(12735);
              }
            });
            if (!RoomInfoDetailUI.a(RoomInfoDetailUI.this)) {}
            for (localObject = d.bsh(RoomInfoDetailUI.b(RoomInfoDetailUI.this).field_username);; localObject = null)
            {
              if (!Util.isNullOrNil((String)localObject))
              {
                locals.dismiss();
                com.tencent.mm.ui.base.h.a(RoomInfoDetailUI.this, false, RoomInfoDetailUI.this.getString(a.i.eVx, new Object[] { localObject }), null, RoomInfoDetailUI.this.getString(a.i.goto_conversation), RoomInfoDetailUI.this.getString(a.i.exI), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(12736);
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, true);
                    paramAnonymous2DialogInterface = new Intent();
                    paramAnonymous2DialogInterface.putExtra("Chat_User", RoomInfoDetailUI.b(RoomInfoDetailUI.this).field_username);
                    paramAnonymous2DialogInterface.addFlags(67108864);
                    c.f(RoomInfoDetailUI.this, ".ui.chatting.ChattingUI", paramAnonymous2DialogInterface);
                    AppMethodBeat.o(12736);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(12737);
                    locals.show();
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, false);
                    RoomInfoDetailUI.a(RoomInfoDetailUI.this, locals);
                    AppMethodBeat.o(12737);
                  }
                }, -1, a.b.alert_btn_color_warn);
                AppMethodBeat.o(12738);
                return;
              }
              RoomInfoDetailUI.a(RoomInfoDetailUI.this, locals);
              break;
            }
          }
        };
        com.tencent.mm.ui.base.h.a(this, paramf, new String[] { str }, null, local2);
      }
      if (paramPreference.equals("room_placed_to_the_top"))
      {
        paramf = getSharedPreferences(this.iYF, 0);
        if (this.contact != null)
        {
          if (!((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwF(this.contact.field_username)) {
            break label853;
          }
          ab.H(this.contact.field_username, true);
          label526:
          paramf.edit().putBoolean("room_placed_to_the_top", ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwF(this.contact.field_username)).commit();
        }
      }
      if ("room_show_msg_count".equals(paramPreference))
      {
        boolean bool3 = asV();
        Log.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool3) });
        if (bool3) {
          break label867;
        }
        bool1 = true;
        label624:
        paramf = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(this.roomId);
        if (!bool1) {
          break label873;
        }
        paramf.rl(0);
        label657:
        Log.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[] { Boolean.valueOf(bool1) });
        ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().update(paramf, new String[0]);
        paramf = z.bcZ();
        paramPreference = new cxy();
        paramPreference.RIi = this.roomId;
        paramPreference.UserName = paramf;
        paramPreference.TGd = 2;
        if (!bool1) {
          break label881;
        }
        i = 2;
        label739:
        paramPreference.Iza = i;
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(49, paramPreference));
        if (this.jiA != null)
        {
          paramf = this.jiA;
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
      paramf = getString(a.i.eFx, new Object[] { this.contact.ays() });
      break label422;
      ab.G(this.contact.field_username, true);
      break label526;
      bool1 = false;
      break label624;
      paramf.rl(2);
      break label657;
      i = 1;
      break label739;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12742);
    super.onResume();
    asz();
    asX();
    SharedPreferences localSharedPreferences;
    if ((this.contact != null) && (this.jiz != null))
    {
      ah localah = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rx(this.roomId);
      localSharedPreferences = getSharedPreferences(this.iYF, 0);
      if (!localah.hxI()) {
        break label117;
      }
      this.jiz.setChecked(true);
      localSharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12742);
      return;
      label117:
      this.jiz.setChecked(false);
      localSharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI
 * JD-Core Version:    0.7.0.1
 */