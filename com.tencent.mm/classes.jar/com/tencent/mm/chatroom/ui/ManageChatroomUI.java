package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.preference.RoomManagerPreference;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.d.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bdn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ManageChatroomUI
  extends MMPreference
{
  CheckBoxPreference egD;
  RoomManagerPreference egE;
  private String egF;
  private String egG;
  private f screen;
  private SharedPreferences sp = null;
  
  public int getResourceId()
  {
    return 2131165249;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(104116);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104116);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(104116);
        return;
      }
      paramInt1 = paramIntent.getIntExtra("into_room_type", -1);
      ab.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[] { this.egF, Integer.valueOf(paramInt1) });
      paramIntent = new bdn();
      paramIntent.wot = bo.nullAsNil(this.egF);
      paramIntent.qsl = paramInt1;
      paramIntent = new j.a(66, paramIntent);
      ((j)g.E(j.class)).Yz().c(paramIntent);
      AppMethodBeat.o(104116);
      return;
      ab.i("MicroMsg.ManageChatroomUI", "[onActivityResult] requestCode:%s", new Object[] { Integer.valueOf(2) });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104112);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.ManageChatroomUI", "[onCreate]");
    this.egF = getIntent().getStringExtra("RoomInfo_Id");
    this.egG = getIntent().getStringExtra("room_owner_name");
    AppMethodBeat.o(104112);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104114);
    super.onDestroy();
    AppMethodBeat.o(104114);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int i = 2;
    int j = 1;
    AppMethodBeat.i(104115);
    paramf = paramPreference.mKey;
    ab.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[] { paramf });
    if (paramf.equals("room_transfer_room_ower"))
    {
      ab.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[] { this.egF });
      paramf = bo.d(n.nt(this.egF), ",");
      paramPreference = new Intent();
      paramPreference.putExtra("Block_list", r.Zn());
      paramPreference.putExtra("Chatroom_member_list", paramf);
      paramPreference.putExtra("from_scene", 2);
      paramPreference.putExtra("RoomInfo_Id", this.egF);
      paramPreference.putExtra("is_show_owner", false);
      paramPreference.putExtra("title", getString(2131302788));
      paramPreference.setClass(this, TransferRoomOwnerUI.class);
      startActivity(paramPreference);
    }
    do
    {
      AppMethodBeat.o(104115);
      return false;
      if (paramf.equals("allow_by_identity"))
      {
        boolean bool = this.egD.isChecked();
        h.qsU.idkeyStat(219L, 22L, 1L, true);
        ab.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[] { this.egF, Boolean.valueOf(bool) });
        if (t.nK(this.egF))
        {
          paramf = ((j)g.E(j.class)).Yz();
          paramPreference = bo.nullAsNil(this.egF);
          if (bool == true) {}
          for (i = j;; i = 0)
          {
            paramf.c(new q(paramPreference, i));
            this.egD.zsk = false;
            break;
          }
        }
        paramf = new bdn();
        paramf.wot = bo.nullAsNil(this.egF);
        if (bool == true) {}
        for (;;)
        {
          paramf.qsl = i;
          paramf = new j.a(66, paramf);
          ((j)g.E(j.class)).Yz().c(paramf);
          break;
          i = 0;
        }
      }
    } while (!paramf.equals("room_manager"));
    ab.i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", new Object[] { this.egF });
    paramf = ((c)g.E(c.class)).YJ().oU(this.egF);
    paramPreference = new Intent();
    if (paramf.aqW(r.Zn())) {
      paramPreference.setClass(this, SeeRoomOwnerManagerUI.class);
    }
    for (;;)
    {
      paramPreference.putExtra("RoomInfo_Id", this.egF);
      startActivity(paramPreference);
      break;
      paramPreference.setClass(this, SeeRoomManagerUI.class);
    }
  }
  
  public void onResume()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(104113);
    Object localObject1 = ((c)g.E(c.class)).YJ().oU(this.egF);
    if ((localObject1 != null) && (this.sp == null))
    {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
      localObject2 = this.sp.edit();
      if (((u)localObject1).dwq() == 2)
      {
        bool1 = true;
        ((SharedPreferences.Editor)localObject2).putBoolean("allow_by_identity", bool1).commit();
      }
    }
    else
    {
      super.onResume();
      this.screen = getPreferenceScreen();
      if (this.screen != null)
      {
        setMMTitle(2131301521);
        this.egD = ((CheckBoxPreference)this.screen.atx("allow_by_identity"));
        this.egE = ((RoomManagerPreference)this.screen.atx("room_manager"));
        localObject1 = this.screen;
        if (((c)g.E(c.class)).IV(this.egF)) {
          break label405;
        }
        bool1 = true;
        label209:
        ((f)localObject1).cl("room_manager", bool1);
        this.screen.cl("select_enable_qrcode", true);
        this.screen.cl("select_into_room_type", true);
        if (!r.Zn().equals(this.egG)) {
          this.screen.cl("room_transfer_room_ower", true);
        }
        localObject1 = ((c)g.E(c.class)).YJ().oU(this.egF);
        if (localObject1 != null)
        {
          if (!t.nK(this.egF)) {
            break label420;
          }
          if (((u)localObject1).dwq() != 1) {
            break label410;
          }
          bool1 = true;
          label322:
          ab.i("MicroMsg.ManageChatroomUI", "isChecked = %s", new Object[] { Boolean.valueOf(bool1) });
          localObject2 = this.egD;
          if (((u)localObject1).dwq() != 1) {
            break label415;
          }
        }
      }
    }
    label405:
    label410:
    label415:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((CheckBoxPreference)localObject2).vxW = bool1;
      this.egD.zsk = false;
      setBackBtn(new ManageChatroomUI.1(this));
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(104113);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label209;
      bool1 = false;
      break label322;
    }
    label420:
    Object localObject2 = this.egD;
    if (((u)localObject1).dwq() == 2) {}
    for (bool1 = bool3;; bool1 = false)
    {
      ((CheckBoxPreference)localObject2).vxW = bool1;
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