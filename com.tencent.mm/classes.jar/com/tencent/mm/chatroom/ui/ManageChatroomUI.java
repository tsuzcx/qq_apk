package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.preference.RoomManagerPreference;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.d.p;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.widget.a.f.a;
import java.util.LinkedList;

public class ManageChatroomUI
  extends MMPreference
{
  CheckBoxPreference jaF;
  RoomManagerPreference jaG;
  Preference jaH;
  NewTipPreference jaI;
  private dzo jaJ = null;
  private String jaK;
  private String jaL;
  private com.tencent.mm.ui.widget.a.g jaM = null;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  
  private dzn asN()
  {
    AppMethodBeat.i(193378);
    if ((this.jaJ != null) && (!Util.isNullOrNil(this.jaJ.Ufa)))
    {
      dzn localdzn = (dzn)this.jaJ.Ufa.getFirst();
      AppMethodBeat.o(193378);
      return localdzn;
    }
    AppMethodBeat.o(193378);
    return null;
  }
  
  public int getResourceId()
  {
    return a.k.jhF;
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
      Log.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[] { this.jaK, Integer.valueOf(paramInt1) });
      paramIntent = new cxv();
      paramIntent.RIi = Util.nullAsNil(this.jaK);
      paramIntent.Iza = paramInt1;
      paramIntent = new k.a(66, paramIntent);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(paramIntent);
      AppMethodBeat.o(12662);
      return;
      Log.i("MicroMsg.ManageChatroomUI", "[onActivityResult] requestCode:%s", new Object[] { Integer.valueOf(2) });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12658);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.ManageChatroomUI", "[onCreate]");
    this.jaK = getIntent().getStringExtra("RoomInfo_Id");
    this.jaL = getIntent().getStringExtra("room_owner_name");
    AppMethodBeat.o(12658);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12660);
    super.onDestroy();
    AppMethodBeat.o(12660);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(12661);
    paramf = paramPreference.mKey;
    Log.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[] { paramf });
    if (paramf.equals("room_transfer_room_ower"))
    {
      Log.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[] { this.jaK });
      paramf = Util.listToString(v.Ps(this.jaK), ",");
      paramPreference = new Intent();
      paramPreference.putExtra("Block_list", z.bcZ());
      paramPreference.putExtra("Chatroom_member_list", paramf);
      paramPreference.putExtra("from_scene", 2);
      paramPreference.putExtra("RoomInfo_Id", this.jaK);
      paramPreference.putExtra("is_show_owner", false);
      paramPreference.putExtra("title", getString(a.i.jgE));
      paramPreference.setClass(this, TransferRoomOwnerUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(12661);
      return false;
      if (paramf.equals("allow_by_identity"))
      {
        boolean bool = this.jaF.isChecked();
        paramf = asN();
        if ((paramf != null) && (bool))
        {
          this.jaF.setChecked(false);
          paramf = new f.a(getContext()).aR(getString(a.i.jeQ)).bBl(Util.safeFormatString(getString(a.i.jeP), new Object[] { paramf.CQz })).ayp(a.i.app_i_know);
          paramf.Qlf = true;
          paramf.show();
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 22L, 1L, true);
          Log.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[] { this.jaK, Boolean.valueOf(bool) });
          if (ab.PQ(this.jaK))
          {
            paramf = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK();
            paramPreference = Util.nullAsNil(this.jaK);
            if (bool == true) {}
            for (;;)
            {
              paramf.d(new p(paramPreference, i));
              this.jaF.WsF = false;
              break;
              i = 0;
            }
          }
          paramf = new cxv();
          paramf.RIi = Util.nullAsNil(this.jaK);
          if (bool == true) {}
          for (i = 2;; i = 0)
          {
            paramf.Iza = i;
            paramf = new k.a(66, paramf);
            ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(paramf);
            break;
          }
        }
      }
      else
      {
        if (paramf.equals("room_manager"))
        {
          Log.i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", new Object[] { this.jaK });
          paramf = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(this.jaK);
          paramPreference = new Intent();
          if (paramf.bvA(z.bcZ())) {
            paramPreference.setClass(this, SeeRoomOwnerManagerUI.class);
          }
          for (;;)
          {
            paramPreference.putExtra("RoomInfo_Id", this.jaK);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramPreference);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            paramPreference.setClass(this, SeeRoomManagerUI.class);
          }
        }
        if (!paramf.equals("use_wework_manager_room")) {
          break label1017;
        }
        Log.i("MicroMsg.ManageChatroomUI", "[useWeworkManagerRoom] roomId:%s", new Object[] { this.jaK });
        paramf = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(this.jaK);
        if (paramf != null) {
          break;
        }
        Log.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI member is null");
      }
    }
    if (paramf.field_memberCount >= v.bcU())
    {
      i = 1;
      label776:
      if (paramf.Rh(z.bcZ())) {
        break label845;
      }
      Log.i("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：no owner");
      com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.chatroom_sys_msg_room_upgrade_to_wework_no_owner), "", getString(a.i.app_i_know), false, null);
      if (i == 0) {
        break label1230;
      }
    }
    label845:
    label1230:
    for (i = 3;; i = 1)
    {
      ManagerRoomByWeworkUI.d(this.jaK, 1, 2, i);
      break;
      i = 0;
      break label776;
      if (i != 0)
      {
        Log.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：exceed maxnum");
        com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.chatroom_sys_msg_room_upgrade_to_wework_exceed_max_num), "", getString(a.i.app_i_know), false, null);
        ManagerRoomByWeworkUI.d(this.jaK, 1, 2, 2);
        break;
      }
      com.tencent.mm.plugin.newtips.a.fiO().aap(27);
      paramf = new Intent();
      paramf.setClass(this, ManagerRoomByWeworkUI.class);
      paramf.putExtra("RoomInfo_Id", this.jaK);
      paramf.putExtra("upgrade_openim_room_from_scene", 1);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break;
      label1017:
      if (!paramf.equals("room_bind_app_info")) {
        break;
      }
      paramf = asN();
      if ((paramf == null) || ((this.jaM != null) && (this.jaM.isShowing()))) {
        break;
      }
      this.jaM = new com.tencent.mm.ui.widget.a.g(getContext(), 0, 3);
      paramPreference = LayoutInflater.from(getContext()).inflate(a.f.jec, null, false);
      Object localObject = (ImageView)paramPreference.findViewById(a.e.jcP);
      com.tencent.mm.ay.a.a.bms().loadImage(paramf.RGJ, (ImageView)localObject);
      ((TextView)paramPreference.findViewById(a.e.jdA)).setText(paramf.CQz);
      ((TextView)paramPreference.findViewById(a.e.jdC)).setText(Util.safeFormatString(getString(a.i.jeN), new Object[] { paramf.CQz }));
      localObject = (TextView)paramPreference.findViewById(a.e.jdG);
      ((TextView)localObject).setText(Util.safeFormatString(getString(a.i.jeS), new Object[] { paramf.CQz }));
      ((TextView)localObject).setOnClickListener(new ManageChatroomUI.4(this, paramf));
      this.jaM.setCustomView(paramPreference);
      this.jaM.eik();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12659);
    Object localObject1 = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(this.jaK);
    if ((localObject1 != null) && (this.sp == null))
    {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      localObject2 = this.sp.edit();
      if (((ah)localObject1).hxG() == 2)
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
        setMMTitle(a.i.jft);
        this.jaF = ((CheckBoxPreference)this.screen.byG("allow_by_identity"));
        this.jaG = ((RoomManagerPreference)this.screen.byG("room_manager"));
        this.jaH = this.screen.byG("room_bind_app_info");
        if ((!ab.PT(this.jaK)) || ((z.bdV() & 0x10) != 0))
        {
          localObject1 = this.screen;
          if (((b)com.tencent.mm.kernel.h.ae(b.class)).asl(this.jaK)) {
            break label644;
          }
          bool = true;
          label235:
          ((com.tencent.mm.ui.base.preference.f)localObject1).dz("room_manager", bool);
        }
        this.screen.dz("select_enable_qrcode", true);
        this.screen.dz("select_into_room_type", true);
        this.screen.dz("use_wework_manager_room", true);
        this.screen.dz("room_bind_app_info", true);
        bool = z.bcZ().equals(this.jaL);
        if (!bool) {
          this.screen.dz("room_transfer_room_ower", true);
        }
        if (bool) {
          com.tencent.mm.cw.g.eE(this.jaK).h(new ManageChatroomUI.2(this)).b(new ManageChatroomUI.1(this));
        }
        localObject1 = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV().Rw(this.jaK);
        if (localObject1 != null)
        {
          if (!ab.PQ(this.jaK)) {
            break label659;
          }
          if (((ah)localObject1).hxG() != 1) {
            break label649;
          }
          bool = true;
          label412:
          Log.i("MicroMsg.ManageChatroomUI", "isChecked = %s", new Object[] { Boolean.valueOf(bool) });
          localObject2 = this.jaF;
          if ((((ah)localObject1).hxG() & 0x1) != 1) {
            break label654;
          }
        }
      }
    }
    label644:
    label649:
    label654:
    for (boolean bool = true;; bool = false)
    {
      ((CheckBoxPreference)localObject2).setChecked(bool);
      Log.d("MicroMsg.ManageChatroomUI", "mRoomId:%s chatroomstatus:%s", new Object[] { Util.nullAs(this.jaK, "null"), Integer.valueOf(((ah)localObject1).field_chatroomStatus) });
      if ((!ab.PQ(this.jaK)) && (v.bcV()) && ((((ah)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((ah)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (v.bcT()))
      {
        this.screen.dz("use_wework_manager_room", false);
        this.jaI = ((NewTipPreference)this.screen.byG("use_wework_manager_room"));
        this.jaI.a(this.screen);
        com.tencent.mm.plugin.newtips.a.fiO().h(this.jaI);
        com.tencent.mm.plugin.newtips.a.g.a(this.jaI);
      }
      this.jaF.WsF = false;
      setBackBtn(new ManageChatroomUI.3(this));
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(12659);
      return;
      bool = false;
      break;
      bool = false;
      break label235;
      bool = false;
      break label412;
    }
    label659:
    Object localObject2 = this.jaF;
    if (((ah)localObject1).hxG() == 2) {}
    for (bool = true;; bool = false)
    {
      ((CheckBoxPreference)localObject2).setChecked(bool);
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI
 * JD-Core Version:    0.7.0.1
 */