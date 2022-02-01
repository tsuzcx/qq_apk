package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.preference.RoomManagerPreference;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.c.c;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.cwd;
import com.tencent.mm.protocal.protobuf.cwe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f.a;
import java.util.LinkedList;

public class ManageChatroomUI
  extends MMPreference
{
  CheckBoxPreference fPd;
  RoomManagerPreference fPe;
  Preference fPf;
  NewTipPreference fPg;
  private cwe fPh = null;
  private String fPi;
  private String fPj;
  private com.tencent.mm.ui.widget.a.g fPk = null;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  
  private cwd YQ()
  {
    AppMethodBeat.i(213503);
    if ((this.fPh != null) && (!bt.hj(this.fPh.Hoh)))
    {
      cwd localcwd = (cwd)this.fPh.Hoh.getFirst();
      AppMethodBeat.o(213503);
      return localcwd;
    }
    AppMethodBeat.o(213503);
    return null;
  }
  
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
      ad.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[] { this.fPi, Integer.valueOf(paramInt1) });
      paramIntent = new bzj();
      paramIntent.FuL = bt.nullAsNil(this.fPi);
      paramIntent.yho = paramInt1;
      paramIntent = new k.a(66, paramIntent);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(paramIntent);
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
    this.fPi = getIntent().getStringExtra("RoomInfo_Id");
    this.fPj = getIntent().getStringExtra("room_owner_name");
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
    ad.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[] { paramf });
    if (paramf.equals("room_transfer_room_ower"))
    {
      ad.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[] { this.fPi });
      paramf = bt.m(com.tencent.mm.model.q.yQ(this.fPi), ",");
      paramPreference = new Intent();
      paramPreference.putExtra("Block_list", u.aAm());
      paramPreference.putExtra("Chatroom_member_list", paramf);
      paramPreference.putExtra("from_scene", 2);
      paramPreference.putExtra("RoomInfo_Id", this.fPi);
      paramPreference.putExtra("is_show_owner", false);
      paramPreference.putExtra("title", getString(2131762700));
      paramPreference.setClass(this, TransferRoomOwnerUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(12661);
      return false;
      if (paramf.equals("allow_by_identity"))
      {
        boolean bool = this.fPd.isChecked();
        paramf = YQ();
        if ((paramf != null) && (bool))
        {
          this.fPd.oB = false;
          paramf = new f.a(getContext()).av(getString(2131766531)).aXO(bt.x(getString(2131763007), new Object[] { paramf.uiR })).afp(2131755792);
          paramf.EgK = true;
          paramf.show();
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 22L, 1L, true);
          ad.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[] { this.fPi, Boolean.valueOf(bool) });
          if (w.zl(this.fPi))
          {
            paramf = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo();
            paramPreference = bt.nullAsNil(this.fPi);
            if (bool == true) {}
            for (;;)
            {
              paramf.c(new com.tencent.mm.openim.d.q(paramPreference, i));
              this.fPd.JtB = false;
              break;
              i = 0;
            }
          }
          paramf = new bzj();
          paramf.FuL = bt.nullAsNil(this.fPi);
          if (bool == true) {}
          for (i = 2;; i = 0)
          {
            paramf.yho = i;
            paramf = new k.a(66, paramf);
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(paramf);
            break;
          }
        }
      }
      else
      {
        if (paramf.equals("room_manager"))
        {
          ad.i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", new Object[] { this.fPi });
          paramf = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.fPi);
          paramPreference = new Intent();
          if (paramf.aSH(u.aAm())) {
            paramPreference.setClass(this, SeeRoomOwnerManagerUI.class);
          }
          for (;;)
          {
            paramPreference.putExtra("RoomInfo_Id", this.fPi);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            paramPreference.setClass(this, SeeRoomManagerUI.class);
          }
        }
        if (!paramf.equals("use_wework_manager_room")) {
          break label1017;
        }
        ad.i("MicroMsg.ManageChatroomUI", "[useWeworkManagerRoom] roomId:%s", new Object[] { this.fPi });
        paramf = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.fPi);
        if (paramf != null) {
          break;
        }
        ad.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI member is null");
      }
    }
    if (paramf.field_memberCount >= com.tencent.mm.model.q.aAh())
    {
      i = 1;
      label776:
      if (paramf.Az(u.aAm())) {
        break label845;
      }
      ad.i("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：no owner");
      h.a(getContext(), getString(2131757110), "", getString(2131755792), false, null);
      if (i == 0) {
        break label1230;
      }
    }
    label845:
    label1230:
    for (i = 3;; i = 1)
    {
      ManagerRoomByWeworkUI.c(this.fPi, 1, 2, i);
      break;
      i = 0;
      break label776;
      if (i != 0)
      {
        ad.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：exceed maxnum");
        h.a(getContext(), getString(2131757108), "", getString(2131755792), false, null);
        ManagerRoomByWeworkUI.c(this.fPi, 1, 2, 2);
        break;
      }
      com.tencent.mm.plugin.newtips.a.dun().LQ(27);
      paramf = new Intent();
      paramf.setClass(this, ManagerRoomByWeworkUI.class);
      paramf.putExtra("RoomInfo_Id", this.fPi);
      paramf.putExtra("upgrade_openim_room_from_scene", 1);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahp(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break;
      label1017:
      if (!paramf.equals("room_bind_app_info")) {
        break;
      }
      paramf = YQ();
      if ((paramf == null) || ((this.fPk != null) && (this.fPk.isShowing()))) {
        break;
      }
      this.fPk = new com.tencent.mm.ui.widget.a.g(getContext(), 0, 3);
      paramPreference = LayoutInflater.from(getContext()).inflate(2131496443, null, false);
      Object localObject = (ImageView)paramPreference.findViewById(2131308341);
      com.tencent.mm.aw.a.a.aIP().loadImage(paramf.Fts, (ImageView)localObject);
      ((TextView)paramPreference.findViewById(2131308455)).setText(paramf.uiR);
      ((TextView)paramPreference.findViewById(2131308457)).setText(bt.x(getString(2131766522), new Object[] { paramf.uiR }));
      localObject = (TextView)paramPreference.findViewById(2131308461);
      ((TextView)localObject).setText(bt.x(getString(2131766865), new Object[] { paramf.uiR }));
      ((TextView)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213499);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManageChatroomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ManageChatroomUI.b(ManageChatroomUI.this).bpT();
          ManageChatroomUI.a(ManageChatroomUI.this, paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213499);
        }
      });
      this.fPk.setCustomView(paramPreference);
      this.fPk.cMW();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12659);
    Object localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.fPi);
    if ((localObject1 != null) && (this.sp == null))
    {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      localObject2 = this.sp.edit();
      if (((ab)localObject1).fpP() == 2)
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
        this.fPd = ((CheckBoxPreference)this.screen.aVD("allow_by_identity"));
        this.fPe = ((RoomManagerPreference)this.screen.aVD("room_manager"));
        this.fPf = this.screen.aVD("room_bind_app_info");
        if ((!w.zn(this.fPi)) || ((u.aBg() & 0x10) != 0))
        {
          localObject1 = this.screen;
          if (((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).ZA(this.fPi)) {
            break label644;
          }
          bool = true;
          label235:
          ((com.tencent.mm.ui.base.preference.f)localObject1).cP("room_manager", bool);
        }
        this.screen.cP("select_enable_qrcode", true);
        this.screen.cP("select_into_room_type", true);
        this.screen.cP("use_wework_manager_room", true);
        this.screen.cP("room_bind_app_info", true);
        bool = u.aAm().equals(this.fPj);
        if (!bool) {
          this.screen.cP("room_transfer_room_ower", true);
        }
        if (bool) {
          com.tencent.mm.cn.g.er(this.fPi).h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
        }
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(this.fPi);
        if (localObject1 != null)
        {
          if (!w.zl(this.fPi)) {
            break label659;
          }
          if (((ab)localObject1).fpP() != 1) {
            break label649;
          }
          bool = true;
          label412:
          ad.i("MicroMsg.ManageChatroomUI", "isChecked = %s", new Object[] { Boolean.valueOf(bool) });
          localObject2 = this.fPd;
          if ((((ab)localObject1).fpP() & 0x1) != 1) {
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
      ((CheckBoxPreference)localObject2).oB = bool;
      ad.d("MicroMsg.ManageChatroomUI", "mRoomId:%s chatroomstatus:%s", new Object[] { bt.bI(this.fPi, "null"), Integer.valueOf(((ab)localObject1).field_chatroomStatus) });
      if ((!w.zl(this.fPi)) && (com.tencent.mm.model.q.aAi()) && ((((ab)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((ab)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (com.tencent.mm.model.q.aAg()))
      {
        this.screen.cP("use_wework_manager_room", false);
        this.fPg = ((NewTipPreference)this.screen.aVD("use_wework_manager_room"));
        this.fPg.a(this.screen);
        com.tencent.mm.plugin.newtips.a.dun().h(this.fPg);
        com.tencent.mm.plugin.newtips.a.g.a(this.fPg);
      }
      this.fPd.JtB = false;
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(213498);
          ManageChatroomUI.this.finish();
          AppMethodBeat.o(213498);
          return true;
        }
      });
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
    Object localObject2 = this.fPd;
    if (((ab)localObject1).fpP() == 2) {}
    for (bool = true;; bool = false)
    {
      ((CheckBoxPreference)localObject2).oB = bool;
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