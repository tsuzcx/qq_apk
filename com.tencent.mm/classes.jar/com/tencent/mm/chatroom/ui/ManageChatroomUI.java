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
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ManageChatroomUI
  extends MMPreference
{
  CheckBoxPreference fvW;
  RoomManagerPreference fvX;
  NewTipPreference fvY;
  private String fvZ;
  private String fwa;
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
      ac.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[] { this.fvZ, Integer.valueOf(paramInt1) });
      paramIntent = new buu();
      paramIntent.DPx = bs.nullAsNil(this.fvZ);
      paramIntent.wTE = paramInt1;
      paramIntent = new j.a(66, paramIntent);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(paramIntent);
      AppMethodBeat.o(12662);
      return;
      ac.i("MicroMsg.ManageChatroomUI", "[onActivityResult] requestCode:%s", new Object[] { Integer.valueOf(2) });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12658);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.ManageChatroomUI", "[onCreate]");
    this.fvZ = getIntent().getStringExtra("RoomInfo_Id");
    this.fwa = getIntent().getStringExtra("room_owner_name");
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
    ac.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[] { paramf });
    if (paramf.equals("room_transfer_room_ower"))
    {
      ac.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[] { this.fvZ });
      paramf = bs.n(com.tencent.mm.model.q.vZ(this.fvZ), ",");
      paramPreference = new Intent();
      paramPreference.putExtra("Block_list", u.axw());
      paramPreference.putExtra("Chatroom_member_list", paramf);
      paramPreference.putExtra("from_scene", 2);
      paramPreference.putExtra("RoomInfo_Id", this.fvZ);
      paramPreference.putExtra("is_show_owner", false);
      paramPreference.putExtra("title", getString(2131762700));
      paramPreference.setClass(this, TransferRoomOwnerUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(12661);
      return false;
      if (paramf.equals("allow_by_identity"))
      {
        boolean bool = this.fvW.isChecked();
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 22L, 1L, true);
        ac.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[] { this.fvZ, Boolean.valueOf(bool) });
        if (w.wq(this.fvZ))
        {
          paramf = ((k)com.tencent.mm.kernel.g.ab(k.class)).awA();
          paramPreference = bs.nullAsNil(this.fvZ);
          if (bool == true) {}
          for (;;)
          {
            paramf.c(new com.tencent.mm.openim.d.q(paramPreference, i));
            this.fvW.HFK = false;
            break;
            i = 0;
          }
        }
        paramf = new buu();
        paramf.DPx = bs.nullAsNil(this.fvZ);
        if (bool == true) {}
        for (i = 2;; i = 0)
        {
          paramf.wTE = i;
          paramf = new j.a(66, paramf);
          ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(paramf);
          break;
        }
      }
      if (paramf.equals("room_manager"))
      {
        ac.i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", new Object[] { this.fvZ });
        paramf = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xN(this.fvZ);
        paramPreference = new Intent();
        if (paramf.aMU(u.axw())) {
          paramPreference.setClass(this, SeeRoomOwnerManagerUI.class);
        }
        for (;;)
        {
          paramPreference.putExtra("RoomInfo_Id", this.fvZ);
          paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramPreference);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramf.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break;
          paramPreference.setClass(this, SeeRoomManagerUI.class);
        }
      }
      if (paramf.equals("use_wework_manager_room"))
      {
        ac.i("MicroMsg.ManageChatroomUI", "[useWeworkManagerRoom] roomId:%s", new Object[] { this.fvZ });
        paramf = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xN(this.fvZ);
        if (paramf != null) {
          break;
        }
        ac.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI member is null");
      }
    }
    if (paramf.field_memberCount >= com.tencent.mm.model.q.axs())
    {
      i = 1;
      label656:
      if (paramf.xB(u.axw())) {
        break label725;
      }
      ac.i("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：no owner");
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131757110), "", getString(2131755792), false, null);
      if (i == 0) {
        break label887;
      }
    }
    label725:
    label887:
    for (i = 3;; i = 1)
    {
      ManagerRoomByWeworkUI.c(this.fvZ, 1, 2, i);
      break;
      i = 0;
      break label656;
      if (i != 0)
      {
        ac.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：exceed maxnum");
        com.tencent.mm.ui.base.h.a(getContext(), getString(2131757108), "", getString(2131755792), false, null);
        ManagerRoomByWeworkUI.c(this.fvZ, 1, 2, 2);
        break;
      }
      com.tencent.mm.plugin.newtips.a.dkb().Ko(27);
      paramf = new Intent();
      paramf.setClass(this, ManagerRoomByWeworkUI.class);
      paramf.putExtra("RoomInfo_Id", this.fvZ);
      paramf.putExtra("upgrade_openim_room_from_scene", 1);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12659);
    Object localObject1 = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xN(this.fvZ);
    if ((localObject1 != null) && (this.sp == null))
    {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      localObject2 = this.sp.edit();
      if (((x)localObject1).eZN() == 2)
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
        this.fvW = ((CheckBoxPreference)this.screen.aPN("allow_by_identity"));
        this.fvX = ((RoomManagerPreference)this.screen.aPN("room_manager"));
        if ((!w.ws(this.fvZ)) || ((u.ayg() & 0x10) != 0))
        {
          localObject1 = this.screen;
          if (((c)com.tencent.mm.kernel.g.ab(c.class)).VR(this.fvZ)) {
            break label571;
          }
          bool = true;
          label218:
          ((f)localObject1).cK("room_manager", bool);
        }
        this.screen.cK("select_enable_qrcode", true);
        this.screen.cK("select_into_room_type", true);
        this.screen.cK("use_wework_manager_room", true);
        if (!u.axw().equals(this.fwa)) {
          this.screen.cK("room_transfer_room_ower", true);
        }
        localObject1 = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xN(this.fvZ);
        if (localObject1 != null)
        {
          if (!w.wq(this.fvZ)) {
            break label586;
          }
          if (((x)localObject1).eZN() != 1) {
            break label576;
          }
          bool = true;
          label345:
          ac.i("MicroMsg.ManageChatroomUI", "isChecked = %s", new Object[] { Boolean.valueOf(bool) });
          localObject2 = this.fvW;
          if ((((x)localObject1).eZN() & 0x1) != 1) {
            break label581;
          }
        }
      }
    }
    label571:
    label576:
    label581:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBoxPreference)localObject2).mF = bool;
      ac.d("MicroMsg.ManageChatroomUI", "mRoomId:%s chatroomstatus:%s", new Object[] { bs.bG(this.fvZ, "null"), Integer.valueOf(((x)localObject1).field_chatroomStatus) });
      if ((!w.wq(this.fvZ)) && ((((x)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((x)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (com.tencent.mm.model.q.axr()))
      {
        this.screen.cK("use_wework_manager_room", false);
        this.fvY = ((NewTipPreference)this.screen.aPN("use_wework_manager_room"));
        this.fvY.a(this.screen);
        com.tencent.mm.plugin.newtips.a.dkb().h(this.fvY);
        com.tencent.mm.plugin.newtips.a.g.a(this.fvY);
      }
      this.fvW.HFK = false;
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
    label586:
    Object localObject2 = this.fvW;
    if (((x)localObject1).eZN() == 2) {}
    for (bool = true;; bool = false)
    {
      ((CheckBoxPreference)localObject2).mF = bool;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI
 * JD-Core Version:    0.7.0.1
 */