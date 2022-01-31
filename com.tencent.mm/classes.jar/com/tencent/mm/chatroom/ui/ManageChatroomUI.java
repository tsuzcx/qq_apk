package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mm.chatroom.ui.preference.RoomManagerPreference;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ManageChatroomUI
  extends MMPreference
{
  private SharedPreferences dnD = null;
  private f dnn;
  CheckBoxPreference dph;
  RoomManagerPreference dpi;
  private String dpj;
  private String dpk;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    int i = 2;
    paramf = paramPreference.mKey;
    y.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[] { paramf });
    if (paramf.equals("room_transfer_room_ower"))
    {
      y.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[] { this.dpj });
      paramf = bk.c(m.gK(this.dpj), ",");
      paramPreference = new Intent();
      paramPreference.putExtra("Block_list", q.Gj());
      paramPreference.putExtra("Chatroom_member_list", paramf);
      paramPreference.putExtra("from_scene", 2);
      paramPreference.putExtra("RoomInfo_Id", this.dpj);
      paramPreference.putExtra("is_show_owner", false);
      paramPreference.putExtra("title", getString(a.i.room_select_new_owner));
      paramPreference.setClass(this, TransferRoomOwnerUI.class);
      startActivity(paramPreference);
    }
    do
    {
      return false;
      if (paramf.equals("allow_by_identity"))
      {
        boolean bool = this.dph.isChecked();
        com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 22L, 1L, true);
        y.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[] { this.dpj, Boolean.valueOf(bool) });
        paramf = new awx();
        paramf.svm = bk.pm(this.dpj);
        if (bool == true) {}
        for (;;)
        {
          paramf.nFj = i;
          paramf = new i.a(66, paramf);
          ((j)g.r(j.class)).Fv().b(paramf);
          return false;
          i = 0;
        }
      }
    } while (!paramf.equals("room_manager"));
    y.i("MicroMsg.ManageChatroomUI", "[selectRoomManager] roomId:%s", new Object[] { this.dpj });
    paramf = ((c)g.r(c.class)).FF().in(this.dpj);
    paramPreference = new Intent();
    if (paramf.aaM(q.Gj())) {
      paramPreference.setClass(this, SeeRoomOwnerManagerUI.class);
    }
    for (;;)
    {
      paramPreference.putExtra("RoomInfo_Id", this.dpj);
      startActivity(paramPreference);
      return false;
      paramPreference.setClass(this, SeeRoomManagerUI.class);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
    case 1: 
      do
      {
        return;
      } while (paramIntent == null);
      paramInt1 = paramIntent.getIntExtra("into_room_type", -1);
      y.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[] { this.dpj, Integer.valueOf(paramInt1) });
      paramIntent = new awx();
      paramIntent.svm = bk.pm(this.dpj);
      paramIntent.nFj = paramInt1;
      paramIntent = new i.a(66, paramIntent);
      ((j)g.r(j.class)).Fv().b(paramIntent);
      return;
    }
    y.i("MicroMsg.ManageChatroomUI", "[onActivityResult] requestCode:%s", new Object[] { Integer.valueOf(2) });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.ManageChatroomUI", "[onCreate]");
    this.dpj = getIntent().getStringExtra("RoomInfo_Id");
    this.dpk = getIntent().getStringExtra("room_owner_name");
    this.dnn = this.vdd;
    if (this.dnn == null) {
      return;
    }
    setMMTitle(a.i.manage_chatroom_title);
    this.dph = ((CheckBoxPreference)this.dnn.add("allow_by_identity"));
    this.dpi = ((RoomManagerPreference)this.dnn.add("room_manager"));
    paramBundle = this.dnn;
    if (!((c)g.r(c.class)).zl(this.dpj)) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.bJ("room_manager", bool);
      this.dnn.bJ("select_enable_qrcode", true);
      this.dnn.bJ("select_into_room_type", true);
      if (!q.Gj().equals(this.dpk)) {
        this.dnn.bJ("room_transfer_room_ower", true);
      }
      setBackBtn(new ManageChatroomUI.1(this));
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResume()
  {
    u localu = ((c)g.r(c.class)).FF().in(this.dpj);
    SharedPreferences.Editor localEditor;
    if ((localu != null) && (this.dnD == null))
    {
      this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
      localEditor = this.dnD.edit();
      if (localu.ctQ() != 2) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      localEditor.putBoolean("allow_by_identity", bool).commit();
      super.onResume();
      this.dnn.notifyDataSetChanged();
      return;
    }
  }
  
  public final int xj()
  {
    return a.k.manage_room_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI
 * JD-Core Version:    0.7.0.1
 */