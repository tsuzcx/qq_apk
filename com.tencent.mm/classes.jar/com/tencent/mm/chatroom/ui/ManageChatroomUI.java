package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.preference.RoomManagerPreference;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ManageChatroomUI
  extends MMPreference
{
  CheckBoxPreference fsp;
  RoomManagerPreference fsq;
  NewTipPreference fsr;
  private String fss;
  private String fst;
  private f screen;
  private SharedPreferences sp = null;
  
  public int getResourceId()
  {
    return 2131951691;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(12662);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(12662);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(12662);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("into_room_type", -1);
      ad.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[] { this.fss, Integer.valueOf(paramInt1) });
      paramIntent = new bqd();
      paramIntent.Cxb = bt.nullAsNil(this.fss);
      paramIntent.vJA = paramInt1;
      paramIntent = new j.a(66, paramIntent);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apL().c(paramIntent);
      AppMethodBeat.o(12662);
      return;
      ad.i("MicroMsg.ManageChatroomUI", "[onActivityResult] requestCode:%s", new Object[] { Integer.valueOf(2) });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12658);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.ManageChatroomUI", "[onCreate]");
    this.fss = getIntent().getStringExtra("RoomInfo_Id");
    this.fst = getIntent().getStringExtra("room_owner_name");
    AppMethodBeat.o(12658);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12660);
    super.onDestroy();
    AppMethodBeat.o(12660);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(12661);
    paramf = paramPreference.mKey;
    ad.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[] { paramf });
    if (paramf.equals("room_transfer_room_ower"))
    {
      ad.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[] { this.fss });
      paramf = bt.n(com.tencent.mm.model.q.rW(this.fss), ",");
      paramPreference = new Intent();
      paramPreference.putExtra("Block_list", u.aqG());
      paramPreference.putExtra("Chatroom_member_list", paramf);
      paramPreference.putExtra("from_scene", 2);
      paramPreference.putExtra("RoomInfo_Id", this.fss);
      paramPreference.putExtra("is_show_owner", false);
      paramPreference.putExtra("title", getString(2131762700));
      paramPreference.setClass(this, TransferRoomOwnerUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(12661);
      return false;
      if (paramf.equals("allow_by_identity"))
      {
        boolean bool = this.fsp.isChecked();
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 22L, 1L, true);
        ad.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[] { this.fss, Boolean.valueOf(bool) });
        if (com.tencent.mm.model.w.sn(this.fss))
        {
          paramf = ((k)com.tencent.mm.kernel.g.ab(k.class)).apL();
          paramPreference = bt.nullAsNil(this.fss);
          if (bool == true) {}
          for (;;)
          {
            paramf.c(new com.tencent.mm.openim.d.q(paramPreference, i));
            this.fsp.GfV = false;
            break;
            i = 0;
          }
        }
        paramf = new bqd();
        paramf.Cxb = bt.nullAsNil(this.fss);
        if (bool == true) {}
        for (i = 2;; i = 0)
        {
          paramf.vJA = i;
          paramf = new j.a(66, paramf);
          ((k)com.tencent.mm.kernel.g.ab(k.class)).apL().c(paramf);
          break;
        }
      }
      if (paramf.equals("room_manager"))
      {
        ad.i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", new Object[] { this.fss });
        paramf = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tH(this.fss);
        paramPreference = new Intent();
        if (paramf.aHz(u.aqG())) {
          paramPreference.setClass(this, SeeRoomOwnerManagerUI.class);
        }
        for (;;)
        {
          paramPreference.putExtra("RoomInfo_Id", this.fss);
          paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          paramPreference.setClass(this, SeeRoomManagerUI.class);
        }
      }
      if (paramf.equals("use_wework_manager_room"))
      {
        ad.i("MicroMsg.ManageChatroomUI", "[useWeworkManagerRoom] roomId:%s", new Object[] { this.fss });
        paramf = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tH(this.fss);
        if (paramf != null) {
          break;
        }
        ad.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI member is null");
      }
    }
    if (paramf.field_memberCount >= com.tencent.mm.model.q.aqC())
    {
      i = 1;
      label656:
      if (paramf.ty(u.aqG())) {
        break label725;
      }
      ad.i("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：no owner");
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131757110), "", getString(2131755792), false, null);
      if (i == 0) {
        break label887;
      }
    }
    label725:
    label887:
    for (i = 3;; i = 1)
    {
      ManagerRoomByWeworkUI.c(this.fss, 1, 2, i);
      break;
      i = 0;
      break label656;
      if (i != 0)
      {
        ad.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：exceed maxnum");
        com.tencent.mm.ui.base.h.a(getContext(), getString(2131757108), "", getString(2131755792), false, null);
        ManagerRoomByWeworkUI.c(this.fss, 1, 2, 2);
        break;
      }
      com.tencent.mm.plugin.newtips.a.cWs().Ip(27);
      paramf = new Intent();
      paramf.setClass(this, ManagerRoomByWeworkUI.class);
      paramf.putExtra("RoomInfo_Id", this.fss);
      paramf.putExtra("upgrade_openim_room_from_scene", 1);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12659);
    Object localObject1 = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tH(this.fss);
    if ((localObject1 != null) && (this.sp == null))
    {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      localObject2 = this.sp.edit();
      if (((com.tencent.mm.storage.w)localObject1).eKq() == 2)
      {
        bool = true;
        ((SharedPreferences.Editor)localObject2).putBoolean("allow_by_identity", bool).commit();
      }
    }
    else
    {
      super.onResume();
      this.screen = getPreferenceScreen();
      if (this.screen != null)
      {
        setMMTitle(2131761168);
        this.fsp = ((CheckBoxPreference)this.screen.aKk("allow_by_identity"));
        this.fsq = ((RoomManagerPreference)this.screen.aKk("room_manager"));
        if ((!com.tencent.mm.model.w.sp(this.fss)) || ((u.arq() & 0x10) != 0))
        {
          localObject1 = this.screen;
          if (((c)com.tencent.mm.kernel.g.ab(c.class)).RF(this.fss)) {
            break label567;
          }
          bool = true;
          label218:
          ((f)localObject1).cE("room_manager", bool);
        }
        this.screen.cE("select_enable_qrcode", true);
        this.screen.cE("select_into_room_type", true);
        this.screen.cE("use_wework_manager_room", true);
        if (!u.aqG().equals(this.fst)) {
          this.screen.cE("room_transfer_room_ower", true);
        }
        localObject1 = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tH(this.fss);
        if (localObject1 != null)
        {
          if (!com.tencent.mm.model.w.sn(this.fss)) {
            break label582;
          }
          if (((com.tencent.mm.storage.w)localObject1).eKq() != 1) {
            break label572;
          }
          bool = true;
          label345:
          ad.i("MicroMsg.ManageChatroomUI", "isChecked = %s", new Object[] { Boolean.valueOf(bool) });
          localObject2 = this.fsp;
          if ((((com.tencent.mm.storage.w)localObject1).eKq() & 0x1) != 1) {
            break label577;
          }
        }
      }
    }
    label567:
    label572:
    label577:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBoxPreference)localObject2).lG = bool;
      ad.d("MicroMsg.ManageChatroomUI", "mRoomId:%s chatroomstatus:%s", new Object[] { bt.by(this.fss, "null"), Integer.valueOf(((com.tencent.mm.storage.w)localObject1).field_chatroomStatus) });
      if ((!com.tencent.mm.model.w.sn(this.fss)) && ((((com.tencent.mm.storage.w)localObject1).field_chatroomStatus & 0x20000) != 131072) && ((((com.tencent.mm.storage.w)localObject1).field_chatroomStatus & 0x10000) == 65536) && (com.tencent.mm.model.q.aqB()))
      {
        this.screen.cE("use_wework_manager_room", false);
        this.fsr = ((NewTipPreference)this.screen.aKk("use_wework_manager_room"));
        this.fsr.a(this.screen);
        com.tencent.mm.plugin.newtips.a.cWs().h(this.fsr);
        com.tencent.mm.plugin.newtips.a.g.a(this.fsr);
      }
      this.fsp.GfV = false;
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(12657);
          ManageChatroomUI.this.finish();
          AppMethodBeat.o(12657);
          return true;
        }
      });
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12659);
      return;
      bool = false;
      break;
      bool = false;
      break label218;
      bool = false;
      break label345;
    }
    label582:
    Object localObject2 = this.fsp;
    if (((com.tencent.mm.storage.w)localObject1).eKq() == 2) {}
    for (bool = true;; bool = false)
    {
      ((CheckBoxPreference)localObject2).lG = bool;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI
 * JD-Core Version:    0.7.0.1
 */