package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;

public class TransferRoomOwnerUI
  extends SelectMemberUI
  implements f
{
  private com.tencent.mm.ui.base.p ehb;
  private boolean ele;
  
  protected final void Kj()
  {
    AppMethodBeat.i(104464);
    super.Kj();
    this.ele = getIntent().getBooleanExtra("quit_room", false);
    AppMethodBeat.o(104464);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(104467);
    super.a(paramView, paramInt, paramLong);
    paramView = this.ejE.iD(paramInt);
    if ((paramView == null) || (paramView.contact == null))
    {
      ab.e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
      AppMethodBeat.o(104467);
      return;
    }
    Object localObject2 = paramView.contact;
    String str = ((aq)localObject2).field_username;
    if (!bo.isNullOrNil(((aq)localObject2).field_conRemark))
    {
      paramView = ((aq)localObject2).field_conRemark;
      if (!bo.isNullOrNil(paramView)) {
        break label285;
      }
    }
    label285:
    for (Object localObject1 = ((ad)localObject2).Oe();; localObject1 = paramView)
    {
      paramView = (View)localObject1;
      if (!com.tencent.mm.n.a.je(((aq)localObject2).field_type))
      {
        bv localbv = ((j)g.E(j.class)).YB().TM(((aq)localObject2).field_username);
        paramView = (View)localObject1;
        if (localbv != null)
        {
          paramView = (View)localObject1;
          if (!bo.isNullOrNil(localbv.field_conRemark)) {
            paramView = localbv.field_conRemark;
          }
        }
      }
      localObject2 = com.tencent.mm.openim.room.a.a.A((ad)localObject2);
      localObject1 = paramView;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramView + localObject2;
      }
      if (!this.ele) {}
      for (paramView = getString(2131302799, new Object[] { localObject1 });; paramView = getString(2131302764, new Object[] { localObject1 }))
      {
        h.a(this, paramView, "", new TransferRoomOwnerUI.1(this, str), new TransferRoomOwnerUI.2(this));
        AppMethodBeat.o(104467);
        return;
        paramView = a(this.efi, ((aq)localObject2).field_username);
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104463);
    super.onCreate(paramBundle);
    if (com.tencent.mm.model.t.nK(this.egF))
    {
      g.RK().eHt.a(811, this);
      AppMethodBeat.o(104463);
      return;
    }
    g.RK().eHt.a(990, this);
    AppMethodBeat.o(104463);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104465);
    super.onDestroy();
    if ((this.ehb != null) && (this.ehb.isShowing())) {
      this.ehb.dismiss();
    }
    if (com.tencent.mm.model.t.nK(this.egF))
    {
      g.RK().eHt.b(811, this);
      AppMethodBeat.o(104465);
      return;
    }
    g.RK().eHt.b(990, this);
    AppMethodBeat.o(104465);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(104466);
    if ((this.ehb != null) && (this.ehb.isShowing())) {
      this.ehb.dismiss();
    }
    if ((paramm.getType() == 990) || (paramm.getType() == 811))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (com.tencent.mm.model.t.nK(this.egF)) {
          ab.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((com.tencent.mm.openim.b.p)paramm).username });
        }
        for (;;)
        {
          com.tencent.mm.ui.base.t.makeText(this, 2131302797, 1).show();
          paramString = new Intent(getContext(), ChatroomInfoUI.class);
          paramString.putExtra("RoomInfo_Id", this.egF);
          paramString.putExtra("Chat_User", this.egF);
          paramString.putExtra("Is_Chatroom", true);
          paramString.setFlags(67108864);
          getContext().startActivity(paramString);
          finish();
          AppMethodBeat.o(104466);
          return;
          ab.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((com.tencent.mm.chatroom.c.p)paramm).username });
        }
      }
      com.tencent.mm.ui.base.t.makeText(this, 2131302796, 1).show();
      ab.w("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer failed: %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(104466);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.TransferRoomOwnerUI
 * JD-Core Version:    0.7.0.1
 */