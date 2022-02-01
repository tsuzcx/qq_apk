package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.preference.RoomManagerPreference;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.d.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f.a;
import java.util.LinkedList;

public class ManageChatroomUI
  extends MMPreference
{
  CheckBoxPreference gws;
  RoomManagerPreference gwt;
  Preference gwu;
  NewTipPreference gwv;
  private dps gww = null;
  private String gwx;
  private String gwy;
  private com.tencent.mm.ui.widget.a.g gwz = null;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  
  private dpr amM()
  {
    AppMethodBeat.i(194134);
    if ((this.gww != null) && (!Util.isNullOrNil(this.gww.MSS)))
    {
      dpr localdpr = (dpr)this.gww.MSS.getFirst();
      AppMethodBeat.o(194134);
      return localdpr;
    }
    AppMethodBeat.o(194134);
    return null;
  }
  
  public int getResourceId()
  {
    return 2132017235;
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
      Log.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[] { this.gwx, Integer.valueOf(paramInt1) });
      paramIntent = new cpf();
      paramIntent.KGO = Util.nullAsNil(this.gwx);
      paramIntent.Cyb = paramInt1;
      paramIntent = new k.a(66, paramIntent);
      ((l)com.tencent.mm.kernel.g.af(l.class)).aSM().d(paramIntent);
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
    this.gwx = getIntent().getStringExtra("RoomInfo_Id");
    this.gwy = getIntent().getStringExtra("room_owner_name");
    AppMethodBeat.o(12658);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12660);
    super.onDestroy();
    AppMethodBeat.o(12660);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int i = 1;
    AppMethodBeat.i(12661);
    paramf = paramPreference.mKey;
    Log.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[] { paramf });
    if (paramf.equals("room_transfer_room_ower"))
    {
      Log.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[] { this.gwx });
      paramf = Util.listToString(v.Ic(this.gwx), ",");
      paramPreference = new Intent();
      paramPreference.putExtra("Block_list", z.aTY());
      paramPreference.putExtra("Chatroom_member_list", paramf);
      paramPreference.putExtra("from_scene", 2);
      paramPreference.putExtra("RoomInfo_Id", this.gwx);
      paramPreference.putExtra("is_show_owner", false);
      paramPreference.putExtra("title", getString(2131764783));
      paramPreference.setClass(this, TransferRoomOwnerUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(12661);
      return false;
      if (paramf.equals("allow_by_identity"))
      {
        boolean bool = this.gws.isChecked();
        paramf = amM();
        if ((paramf != null) && (bool))
        {
          this.gws.setChecked(false);
          paramf = new f.a(getContext()).aC(getString(2131757238)).bow(Util.safeFormatString(getString(2131757237), new Object[] { paramf.xMq })).apa(2131755873);
          paramf.JnN = true;
          paramf.show();
        }
        else
        {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 22L, 1L, true);
          Log.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[] { this.gwx, Boolean.valueOf(bool) });
          if (ab.Iy(this.gwx))
          {
            paramf = ((l)com.tencent.mm.kernel.g.af(l.class)).aSM();
            paramPreference = Util.nullAsNil(this.gwx);
            if (bool == true) {}
            for (;;)
            {
              paramf.d(new p(paramPreference, i));
              this.gws.OZw = false;
              break;
              i = 0;
            }
          }
          paramf = new cpf();
          paramf.KGO = Util.nullAsNil(this.gwx);
          if (bool == true) {}
          for (i = 2;; i = 0)
          {
            paramf.Cyb = i;
            paramf = new k.a(66, paramf);
            ((l)com.tencent.mm.kernel.g.af(l.class)).aSM().d(paramf);
            break;
          }
        }
      }
      else
      {
        if (paramf.equals("room_manager"))
        {
          Log.i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", new Object[] { this.gwx });
          paramf = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.gwx);
          paramPreference = new Intent();
          if (paramf.bjf(z.aTY())) {
            paramPreference.setClass(this, SeeRoomOwnerManagerUI.class);
          }
          for (;;)
          {
            paramPreference.putExtra("RoomInfo_Id", this.gwx);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            paramPreference.setClass(this, SeeRoomManagerUI.class);
          }
        }
        if (!paramf.equals("use_wework_manager_room")) {
          break label1017;
        }
        Log.i("MicroMsg.ManageChatroomUI", "[useWeworkManagerRoom] roomId:%s", new Object[] { this.gwx });
        paramf = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.gwx);
        if (paramf != null) {
          break;
        }
        Log.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI member is null");
      }
    }
    if (paramf.field_memberCount >= v.aTT())
    {
      i = 1;
      label776:
      if (paramf.JO(z.aTY())) {
        break label845;
      }
      Log.i("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：no owner");
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131757314), "", getString(2131755873), false, null);
      if (i == 0) {
        break label1230;
      }
    }
    label845:
    label1230:
    for (i = 3;; i = 1)
    {
      ManagerRoomByWeworkUI.c(this.gwx, 1, 2, i);
      break;
      i = 0;
      break label776;
      if (i != 0)
      {
        Log.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：exceed maxnum");
        com.tencent.mm.ui.base.h.a(getContext(), getString(2131757312), "", getString(2131755873), false, null);
        ManagerRoomByWeworkUI.c(this.gwx, 1, 2, 2);
        break;
      }
      com.tencent.mm.plugin.newtips.a.exl().TC(27);
      paramf = new Intent();
      paramf.setClass(this, ManagerRoomByWeworkUI.class);
      paramf.putExtra("RoomInfo_Id", this.gwx);
      paramf.putExtra("upgrade_openim_room_from_scene", 1);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break;
      label1017:
      if (!paramf.equals("room_bind_app_info")) {
        break;
      }
      paramf = amM();
      if ((paramf == null) || ((this.gwz != null) && (this.gwz.isShowing()))) {
        break;
      }
      this.gwz = new com.tencent.mm.ui.widget.a.g(getContext(), 0, 3);
      paramPreference = LayoutInflater.from(getContext()).inflate(2131493846, null, false);
      Object localObject = (ImageView)paramPreference.findViewById(2131302875);
      com.tencent.mm.av.a.a.bdb().loadImage(paramf.KFs, (ImageView)localObject);
      ((TextView)paramPreference.findViewById(2131309453)).setText(paramf.xMq);
      ((TextView)paramPreference.findViewById(2131309455)).setText(Util.safeFormatString(getString(2131757233), new Object[] { paramf.xMq }));
      localObject = (TextView)paramPreference.findViewById(2131309543);
      ((TextView)localObject).setText(Util.safeFormatString(getString(2131757242), new Object[] { paramf.xMq }));
      ((TextView)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194130);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManageChatroomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          ManageChatroomUI.b(ManageChatroomUI.this).bMo();
          ManageChatroomUI.a(ManageChatroomUI.this, paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194130);
        }
      });
      this.gwz.setCustomView(paramPreference);
      this.gwz.dGm();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12659);
    Object localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.gwx);
    if ((localObject1 != null) && (this.sp == null))
    {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      localObject2 = this.sp.edit();
      if (((ah)localObject1).gBv() == 2)
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
        setMMTitle(2131762955);
        this.gws = ((CheckBoxPreference)this.screen.bmg("allow_by_identity"));
        this.gwt = ((RoomManagerPreference)this.screen.bmg("room_manager"));
        this.gwu = this.screen.bmg("room_bind_app_info");
        if ((!ab.IB(this.gwx)) || ((z.aUT() & 0x10) != 0))
        {
          localObject1 = this.screen;
          if (((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).akx(this.gwx)) {
            break label644;
          }
          bool = true;
          label235:
          ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("room_manager", bool);
        }
        this.screen.jdMethod_do("select_enable_qrcode", true);
        this.screen.jdMethod_do("select_into_room_type", true);
        this.screen.jdMethod_do("use_wework_manager_room", true);
        this.screen.jdMethod_do("room_bind_app_info", true);
        bool = z.aTY().equals(this.gwy);
        if (!bool) {
          this.screen.jdMethod_do("room_transfer_room_ower", true);
        }
        if (bool) {
          com.tencent.mm.co.g.ey(this.gwx).h(new ManageChatroomUI.2(this)).b(new com.tencent.mm.vending.c.a() {});
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.gwx);
        if (localObject1 != null)
        {
          if (!ab.Iy(this.gwx)) {
            break label659;
          }
          if (((ah)localObject1).gBv() != 1) {
            break label649;
          }
          bool = true;
          label412:
          Log.i("MicroMsg.ManageChatroomUI", "isChecked = %s", new Object[] { Boolean.valueOf(bool) });
          localObject2 = this.gws;
          if ((((ah)localObject1).gBv() & 0x1) != 1) {
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
      Log.d("MicroMsg.ManageChatroomUI", "mRoomId:%s chatroomstatus:%s", new Object[] { Util.nullAs(this.gwx, "null"), Integer.valueOf(((ah)localObject1).field_chatroomStatus) });
      if ((!ab.Iy(this.gwx)) && (v.aTU()) && ((((ah)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((ah)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (v.aTS()))
      {
        this.screen.jdMethod_do("use_wework_manager_room", false);
        this.gwv = ((NewTipPreference)this.screen.bmg("use_wework_manager_room"));
        this.gwv.a(this.screen);
        com.tencent.mm.plugin.newtips.a.exl().h(this.gwv);
        com.tencent.mm.plugin.newtips.a.g.a(this.gwv);
      }
      this.gws.OZw = false;
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
    Object localObject2 = this.gws;
    if (((ah)localObject1).gBv() == 2) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI
 * JD-Core Version:    0.7.0.1
 */