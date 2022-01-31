package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class TransferRoomOwnerUI
  extends SelectMemberUI
  implements f
{
  private com.tencent.mm.ui.base.p dpF;
  private boolean dtA;
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    super.a(paramView, paramInt, paramLong);
    paramView = this.drW.go(paramInt);
    if ((paramView == null) || (paramView.dnp == null))
    {
      y.e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
      return;
    }
    Object localObject2 = paramView.dnp;
    String str = ((ao)localObject2).field_username;
    if (!bk.bl(((ao)localObject2).field_conRemark))
    {
      paramView = ((ao)localObject2).field_conRemark;
      if (!bk.bl(paramView)) {
        break label233;
      }
      paramView = ((ad)localObject2).Bp();
    }
    label233:
    for (;;)
    {
      Object localObject1 = paramView;
      if (!a.gR(((ao)localObject2).field_type))
      {
        localObject2 = ((j)g.r(j.class)).Fx().Id(((ao)localObject2).field_username);
        localObject1 = paramView;
        if (localObject2 != null)
        {
          localObject1 = paramView;
          if (!bk.bl(((bv)localObject2).field_conRemark)) {
            localObject1 = ((bv)localObject2).field_conRemark;
          }
        }
      }
      if (!this.dtA) {}
      for (paramView = getString(a.i.room_transfer_sure_room_ower, new Object[] { localObject1 });; paramView = getString(a.i.room_quit_and_select_new_owner_confirm, new Object[] { localObject1 }))
      {
        h.a(this, paramView, "", new TransferRoomOwnerUI.1(this, str), new TransferRoomOwnerUI.2(this));
        return;
        paramView = a(this.dnL, ((ao)localObject2).field_username);
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.DO().dJT.a(990, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.dpF != null) && (this.dpF.isShowing())) {
      this.dpF.dismiss();
    }
    g.DO().dJT.b(990, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((this.dpF != null) && (this.dpF.isShowing())) {
      this.dpF.dismiss();
    }
    if (paramm.getType() == 990)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        y.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((com.tencent.mm.chatroom.c.p)paramm).username });
        com.tencent.mm.ui.base.s.makeText(this, a.i.room_transfer_owner_successfully, 1).show();
        paramString = new Intent(this.mController.uMN, ChatroomInfoUI.class);
        paramString.putExtra("RoomInfo_Id", this.dpj);
        paramString.putExtra("Chat_User", this.dpj);
        paramString.putExtra("Is_Chatroom", true);
        paramString.setFlags(67108864);
        this.mController.uMN.startActivity(paramString);
        finish();
      }
    }
    else {
      return;
    }
    com.tencent.mm.ui.base.s.makeText(this, a.i.room_transfer_owner_failed, 1).show();
    y.w("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer failed: %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
  
  protected final void xR()
  {
    super.xR();
    this.dtA = getIntent().getBooleanExtra("quit_room", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.TransferRoomOwnerUI
 * JD-Core Version:    0.7.0.1
 */