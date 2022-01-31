package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class RoomRightUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private ProgressDialog dnm = null;
  private com.tencent.mm.ui.base.preference.f dnn;
  private String dqh = "";
  private int dqi = 0;
  
  private void b(LinkedList<String> paramLinkedList)
  {
    if (paramLinkedList.size() > 0) {}
    String str;
    int i;
    LinkedList localLinkedList;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      str = ae.getContext().getString(a.i.chatroom_sys_msg_invite_split);
      paramLinkedList.size();
      i = a.i.room_right_need_vertify;
      localLinkedList = new LinkedList();
      if (!g.DK()) {
        break;
      }
      Iterator localIterator = paramLinkedList.iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(r.gV((String)localIterator.next()));
      }
    }
    h.a(this, getString(i, new Object[] { bk.c(localLinkedList, str) }), getString(a.i.app_tip), new RoomRightUI.3(this, paramLinkedList));
  }
  
  private void xI()
  {
    int i = bk.a((Integer)g.DP().Dz().get(135175, null), 0);
    Object localObject1 = this.dnn.add("settings_room_size");
    if ((localObject1 != null) && (i > 0))
    {
      ((Preference)localObject1).setSummary(getResources().getQuantityString(a.g.room_size_count, i, new Object[] { Integer.valueOf(i) }));
      ((Preference)localObject1).setEnabled(false);
    }
    Object localObject2;
    label266:
    label352:
    do
    {
      break label266;
      this.dnn.add("room_right_max_tip").setTitle(getString(a.i.room_right_max_tip, new Object[] { Integer.valueOf(i) }));
      int j = bk.a((Integer)g.DP().Dz().get(135176, null), 0);
      localObject1 = (RoomGrantPreference)this.dnn.add("settings_room_grant");
      if ((localObject1 != null) && (j <= 0)) {
        this.dnn.c((Preference)localObject1);
      }
      Preference localPreference;
      for (;;)
      {
        localPreference = this.dnn.add("room_right_tip");
        localObject2 = this.dnn.add("room_right_grant_tip");
        if (j > 0) {
          break label352;
        }
        if (localPreference != null) {
          this.dnn.c(localPreference);
        }
        if (localObject2 != null) {
          this.dnn.c((Preference)localObject2);
        }
        localObject2 = this.dnn.add("room_grant_to_friend");
        if (localObject2 != null) {
          this.dnn.c((Preference)localObject2);
        }
        if (localObject1 != null) {
          this.dnn.c((Preference)localObject1);
        }
        return;
        if (localObject1 == null) {
          break;
        }
        this.dnn.c((Preference)localObject1);
        break;
        if (localObject1 != null)
        {
          ((RoomGrantPreference)localObject1).setEnabled(false);
          localObject2 = getString(a.i.room_right_room_size_num, new Object[] { Integer.valueOf(j) });
          ((RoomGrantPreference)localObject1).dqb = ((String)localObject2);
          if (((RoomGrantPreference)localObject1).dqa != null) {
            ((RoomGrantPreference)localObject1).dqa.setText((CharSequence)localObject2);
          }
        }
      }
      localObject1 = getString(a.i.room_right_tip, new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if (localPreference != null) {
        localPreference.setTitle((CharSequence)localObject1);
      }
      localObject1 = getString(a.i.room_right_grant_tip, new Object[] { Integer.valueOf(this.dqi) });
    } while (localObject2 == null);
    ((Preference)localObject2).setTitle((CharSequence)localObject1);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    if (paramPreference.mKey.equals("room_grant_to_friend"))
    {
      paramf = new Intent();
      paramf.setClassName(ae.getPackageName(), ae.getPackageName() + ".ui.contact.SelectContactUI");
      paramf.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
      paramf.putExtra("List_Type", 4);
      paramf.putExtra("select_contact_pick_result", true);
      paramPreference = new LinkedList();
      paramPreference.add("officialaccounts");
      paramf.putExtra("Block_list", bk.c(paramPreference, ","));
      paramf.putExtra("Add_SendCard", true);
      paramf.putExtra("is_multi_select", false);
      startActivityForResult(paramf, 1);
    }
    return false;
  }
  
  protected final void initView()
  {
    this.dnn = this.vdd;
    setMMTitle(a.i.settings_room_size);
    setBackBtn(new RoomRightUI.1(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
    if ((paramInt2 != -1) || (paramIntent == null)) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      y.d("MicroMsg.RoomRightUI", "pick user %s", new Object[] { paramIntent });
    } while (bk.bl(paramIntent));
    this.dqh = paramIntent;
    paramIntent = this.dqh;
    Object localObject = ((j)g.r(j.class)).Fw().abl(paramIntent);
    localObject = getString(a.i.room_grant_to_conf, new Object[] { ((a)localObject).Bq(), Integer.valueOf(this.dqi) });
    h.a(this.mController.uMN, (String)localObject, "", new RoomRightUI.2(this, paramIntent), null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dqi = bk.a((Integer)g.DP().Dz().get(135177, null), 0);
    g.DO().dJT.a(339, this);
    g.DO().dJT.a(30, this);
    g.DP().Dz().o(135184, Boolean.valueOf(false));
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g.DO().dJT.b(339, this);
    g.DO().dJT.b(30, this);
  }
  
  public void onResume()
  {
    super.onResume();
    xI();
    this.dnn.notifyDataSetChanged();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null) {
      this.dnm.dismiss();
    }
    if (paramm.getType() != 339) {
      return;
    }
    paramString = ((j)g.r(j.class)).Fw().abl(this.dqh);
    if ((paramString == null) || ((int)paramString.dBe == 0)) {}
    for (paramString = this.dqh;; paramString = paramString.Bq())
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label175;
      }
      h.b(this, getString(a.i.room_grant_to_friend_ok, new Object[] { paramString }), getString(a.i.app_tip), true);
      if (this.dnn == null) {
        break;
      }
      xI();
      this.dnn.notifyDataSetChanged();
      return;
    }
    label175:
    if (paramInt2 == -251)
    {
      h.b(this, getString(a.i.room_grant_to_friend_error, new Object[] { paramString, Integer.valueOf(this.dqi) }), getString(a.i.app_tip), true);
      return;
    }
    if (paramInt2 == -44)
    {
      paramString = new LinkedList();
      paramString.add(this.dqh);
      b(paramString);
      return;
    }
    if (paramInt2 == -22)
    {
      h.b(this, getString(a.i.room_grant_to_friend_error_black, new Object[] { paramString }), getString(a.i.app_tip), true);
      return;
    }
    Toast.makeText(this, "err :" + paramInt1 + " ," + paramInt2, 0).show();
  }
  
  public final int xj()
  {
    return a.k.room_right_ui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomRightUI
 * JD-Core Version:    0.7.0.1
 */