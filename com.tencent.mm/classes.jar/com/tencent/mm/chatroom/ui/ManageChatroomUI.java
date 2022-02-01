package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.preference.RoomManagerPreference;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.al;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.openim.d.p;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.NewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.f.a;
import java.util.LinkedList;

public class ManageChatroomUI
  extends MMPreference
{
  CheckBoxPreference fRj;
  RoomManagerPreference fRk;
  Preference fRl;
  NewTipPreference fRm;
  private cwy fRn = null;
  private String fRo;
  private String fRp;
  private com.tencent.mm.ui.widget.a.g fRq = null;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp = null;
  
  private cwx YZ()
  {
    AppMethodBeat.i(217220);
    if ((this.fRn != null) && (!bu.ht(this.fRn.HHH)))
    {
      cwx localcwx = (cwx)this.fRn.HHH.getFirst();
      AppMethodBeat.o(217220);
      return localcwx;
    }
    AppMethodBeat.o(217220);
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
      ae.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[] { this.fRo, Integer.valueOf(paramInt1) });
      paramIntent = new cad();
      paramIntent.FNj = bu.nullAsNil(this.fRo);
      paramIntent.yxf = paramInt1;
      paramIntent = new k.a(66, paramIntent);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(paramIntent);
      AppMethodBeat.o(12662);
      return;
      ae.i("MicroMsg.ManageChatroomUI", "[onActivityResult] requestCode:%s", new Object[] { Integer.valueOf(2) });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12658);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.ManageChatroomUI", "[onCreate]");
    this.fRo = getIntent().getStringExtra("RoomInfo_Id");
    this.fRp = getIntent().getStringExtra("room_owner_name");
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
    ae.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[] { paramf });
    if (paramf.equals("room_transfer_room_ower"))
    {
      ae.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[] { this.fRo });
      paramf = bu.m(r.zA(this.fRo), ",");
      paramPreference = new Intent();
      paramPreference.putExtra("Block_list", v.aAC());
      paramPreference.putExtra("Chatroom_member_list", paramf);
      paramPreference.putExtra("from_scene", 2);
      paramPreference.putExtra("RoomInfo_Id", this.fRo);
      paramPreference.putExtra("is_show_owner", false);
      paramPreference.putExtra("title", getString(2131762700));
      paramPreference.setClass(this, TransferRoomOwnerUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSelectNewRoomOwnerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(12661);
      return false;
      if (paramf.equals("allow_by_identity"))
      {
        boolean bool = this.fRj.isChecked();
        paramf = YZ();
        if ((paramf != null) && (bool))
        {
          this.fRj.setChecked(false);
          paramf = new f.a(getContext()).au(getString(2131766531)).aZq(bu.x(getString(2131763007), new Object[] { paramf.uuo })).afY(2131755792);
          paramf.EyN = true;
          paramf.show();
        }
        else
        {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 22L, 1L, true);
          ae.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[] { this.fRo, Boolean.valueOf(bool) });
          if (x.zV(this.fRo))
          {
            paramf = ((l)com.tencent.mm.kernel.g.ab(l.class)).azE();
            paramPreference = bu.nullAsNil(this.fRo);
            if (bool == true) {}
            for (;;)
            {
              paramf.d(new p(paramPreference, i));
              this.fRj.JOq = false;
              break;
              i = 0;
            }
          }
          paramf = new cad();
          paramf.FNj = bu.nullAsNil(this.fRo);
          if (bool == true) {}
          for (i = 2;; i = 0)
          {
            paramf.yxf = i;
            paramf = new k.a(66, paramf);
            ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(paramf);
            break;
          }
        }
      }
      else
      {
        if (paramf.equals("room_manager"))
        {
          ae.i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", new Object[] { this.fRo });
          paramf = ((c)com.tencent.mm.kernel.g.ab(c.class)).azP().Bx(this.fRo);
          paramPreference = new Intent();
          if (paramf.aUg(v.aAC())) {
            paramPreference.setClass(this, SeeRoomOwnerManagerUI.class);
          }
          for (;;)
          {
            paramPreference.putExtra("RoomInfo_Id", this.fRo);
            paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
            com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramf.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterSeeRoomManagerUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
            paramPreference.setClass(this, SeeRoomManagerUI.class);
          }
        }
        if (!paramf.equals("use_wework_manager_room")) {
          break label1016;
        }
        ae.i("MicroMsg.ManageChatroomUI", "[useWeworkManagerRoom] roomId:%s", new Object[] { this.fRo });
        paramf = ((c)com.tencent.mm.kernel.g.ab(c.class)).azP().Bx(this.fRo);
        if (paramf != null) {
          break;
        }
        ae.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI member is null");
      }
    }
    if (paramf.field_memberCount >= r.aAx())
    {
      i = 1;
      label775:
      if (paramf.Bj(v.aAC())) {
        break label844;
      }
      ae.i("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：no owner");
      h.a(getContext(), getString(2131757110), "", getString(2131755792), false, null);
      if (i == 0) {
        break label1229;
      }
    }
    label844:
    label1229:
    for (i = 3;; i = 1)
    {
      ManagerRoomByWeworkUI.c(this.fRo, 1, 2, i);
      break;
      i = 0;
      break label775;
      if (i != 0)
      {
        ae.e("MicroMsg.ManageChatroomUI", "enterUseWeworkManagerRoomUI：exceed maxnum");
        h.a(getContext(), getString(2131757108), "", getString(2131755792), false, null);
        ManagerRoomByWeworkUI.c(this.fRo, 1, 2, 2);
        break;
      }
      com.tencent.mm.plugin.newtips.a.dxD().Mv(27);
      paramf = new Intent();
      paramf.setClass(this, ManagerRoomByWeworkUI.class);
      paramf.putExtra("RoomInfo_Id", this.fRo);
      paramf.putExtra("upgrade_openim_room_from_scene", 1);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI", "enterUseWeworkManagerRoomUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break;
      label1016:
      if (!paramf.equals("room_bind_app_info")) {
        break;
      }
      paramf = YZ();
      if ((paramf == null) || ((this.fRq != null) && (this.fRq.isShowing()))) {
        break;
      }
      this.fRq = new com.tencent.mm.ui.widget.a.g(getContext(), 0, 3);
      paramPreference = LayoutInflater.from(getContext()).inflate(2131496443, null, false);
      Object localObject = (ImageView)paramPreference.findViewById(2131308341);
      com.tencent.mm.av.a.a.aJh().loadImage(paramf.FLQ, (ImageView)localObject);
      ((TextView)paramPreference.findViewById(2131308455)).setText(paramf.uuo);
      ((TextView)paramPreference.findViewById(2131308457)).setText(bu.x(getString(2131766522), new Object[] { paramf.uuo }));
      localObject = (TextView)paramPreference.findViewById(2131308461);
      ((TextView)localObject).setText(bu.x(getString(2131766865), new Object[] { paramf.uuo }));
      ((TextView)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(217216);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ManageChatroomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ManageChatroomUI.b(ManageChatroomUI.this).bqD();
          ManageChatroomUI.a(ManageChatroomUI.this, paramf);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(217216);
        }
      });
      this.fRq.setCustomView(paramPreference);
      this.fRq.cPF();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12659);
    Object localObject1 = ((c)com.tencent.mm.kernel.g.ab(c.class)).azP().Bx(this.fRo);
    if ((localObject1 != null) && (this.sp == null))
    {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      localObject2 = this.sp.edit();
      if (((ac)localObject1).ftP() == 2)
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
        this.fRj = ((CheckBoxPreference)this.screen.aXe("allow_by_identity"));
        this.fRk = ((RoomManagerPreference)this.screen.aXe("room_manager"));
        this.fRl = this.screen.aXe("room_bind_app_info");
        if ((!x.zX(this.fRo)) || ((v.aBw() & 0x10) != 0))
        {
          localObject1 = this.screen;
          if (((c)com.tencent.mm.kernel.g.ab(c.class)).aar(this.fRo)) {
            break label644;
          }
          bool = true;
          label235:
          ((com.tencent.mm.ui.base.preference.f)localObject1).cT("room_manager", bool);
        }
        this.screen.cT("select_enable_qrcode", true);
        this.screen.cT("select_into_room_type", true);
        this.screen.cT("use_wework_manager_room", true);
        this.screen.cT("room_bind_app_info", true);
        bool = v.aAC().equals(this.fRp);
        if (!bool) {
          this.screen.cT("room_transfer_room_ower", true);
        }
        if (bool) {
          com.tencent.mm.cm.g.eu(this.fRo).h(new ManageChatroomUI.2(this)).b(new ManageChatroomUI.1(this));
        }
        localObject1 = ((c)com.tencent.mm.kernel.g.ab(c.class)).azP().Bx(this.fRo);
        if (localObject1 != null)
        {
          if (!x.zV(this.fRo)) {
            break label659;
          }
          if (((ac)localObject1).ftP() != 1) {
            break label649;
          }
          bool = true;
          label412:
          ae.i("MicroMsg.ManageChatroomUI", "isChecked = %s", new Object[] { Boolean.valueOf(bool) });
          localObject2 = this.fRj;
          if ((((ac)localObject1).ftP() & 0x1) != 1) {
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
      ae.d("MicroMsg.ManageChatroomUI", "mRoomId:%s chatroomstatus:%s", new Object[] { bu.bI(this.fRo, "null"), Integer.valueOf(((ac)localObject1).field_chatroomStatus) });
      if ((!x.zV(this.fRo)) && (r.aAy()) && ((((ac)localObject1).field_chatroomStatus & 0x20000) != 131072L) && ((((ac)localObject1).field_chatroomStatus & 0x10000) == 65536L) && (r.aAw()))
      {
        this.screen.cT("use_wework_manager_room", false);
        this.fRm = ((NewTipPreference)this.screen.aXe("use_wework_manager_room"));
        this.fRm.a(this.screen);
        com.tencent.mm.plugin.newtips.a.dxD().h(this.fRm);
        com.tencent.mm.plugin.newtips.a.g.a(this.fRm);
      }
      this.fRj.JOq = false;
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
    Object localObject2 = this.fRj;
    if (((ac)localObject1).ftP() == 2) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI
 * JD-Core Version:    0.7.0.1
 */