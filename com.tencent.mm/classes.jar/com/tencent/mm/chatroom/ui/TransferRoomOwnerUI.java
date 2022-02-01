package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.v;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;

public class TransferRoomOwnerUI
  extends SelectMemberUI
  implements f
{
  private com.tencent.mm.ui.base.p fSP;
  private boolean fWO;
  
  protected final void Zs()
  {
    AppMethodBeat.i(13006);
    super.Zs();
    this.fWO = getIntent().getBooleanExtra("quit_room", false);
    AppMethodBeat.o(13006);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13009);
    super.a(paramView, paramInt, paramLong);
    paramView = this.fVt.ll(paramInt);
    if ((paramView == null) || (paramView.contact == null))
    {
      ae.e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
      AppMethodBeat.o(13009);
      return;
    }
    Object localObject2 = paramView.contact;
    final String str = ((aw)localObject2).field_username;
    if (!bu.isNullOrNil(((aw)localObject2).field_conRemark))
    {
      paramView = ((aw)localObject2).field_conRemark;
      if (!bu.isNullOrNil(paramView)) {
        break label288;
      }
    }
    label288:
    for (Object localObject1 = ((an)localObject2).adF();; localObject1 = paramView)
    {
      paramView = (View)localObject1;
      if (!c.lO(((aw)localObject2).field_type))
      {
        cg localcg = ((l)g.ab(l.class)).azG().arE(((aw)localObject2).field_username);
        paramView = (View)localObject1;
        if (localcg != null)
        {
          paramView = (View)localObject1;
          if (!bu.isNullOrNil(localcg.field_conRemark)) {
            paramView = localcg.field_conRemark;
          }
        }
      }
      localObject2 = com.tencent.mm.openim.room.a.a.O((an)localObject2);
      localObject1 = paramView;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramView + localObject2;
      }
      if (!this.fWO) {}
      for (paramView = getString(2131762711, new Object[] { localObject1 });; paramView = getString(2131762675, new Object[] { localObject1 }))
      {
        h.a(this, paramView, "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(13004);
            if (x.zV(TransferRoomOwnerUI.this.fRo)) {}
            for (paramAnonymousDialogInterface = new com.tencent.mm.openim.b.p(TransferRoomOwnerUI.this.fRo, str);; paramAnonymousDialogInterface = new v(TransferRoomOwnerUI.this.fRo, str))
            {
              g.ajQ().gDv.a(paramAnonymousDialogInterface, 0);
              paramAnonymousDialogInterface = TransferRoomOwnerUI.this;
              TransferRoomOwnerUI localTransferRoomOwnerUI = TransferRoomOwnerUI.this;
              TransferRoomOwnerUI.this.getString(2131755906);
              TransferRoomOwnerUI.a(paramAnonymousDialogInterface, h.b(localTransferRoomOwnerUI, TransferRoomOwnerUI.this.getString(2131762712), false, null));
              AppMethodBeat.o(13004);
              return;
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(13009);
        return;
        paramView = a(this.fNS, ((aw)localObject2).field_username);
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13005);
    super.onCreate(paramBundle);
    if (x.zV(this.fRo))
    {
      g.ajQ().gDv.a(811, this);
      AppMethodBeat.o(13005);
      return;
    }
    g.ajQ().gDv.a(990, this);
    AppMethodBeat.o(13005);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13007);
    super.onDestroy();
    if ((this.fSP != null) && (this.fSP.isShowing())) {
      this.fSP.dismiss();
    }
    if (x.zV(this.fRo))
    {
      g.ajQ().gDv.b(811, this);
      AppMethodBeat.o(13007);
      return;
    }
    g.ajQ().gDv.b(990, this);
    AppMethodBeat.o(13007);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(13008);
    if ((this.fSP != null) && (this.fSP.isShowing())) {
      this.fSP.dismiss();
    }
    if ((paramn.getType() == 990) || (paramn.getType() == 811))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (x.zV(this.fRo)) {
          ae.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((com.tencent.mm.openim.b.p)paramn).username });
        }
        for (;;)
        {
          t.makeText(this, 2131762709, 1).show();
          paramn = new Intent(getContext(), ChatroomInfoUI.class);
          paramn.putExtra("RoomInfo_Id", this.fRo);
          paramn.putExtra("Chat_User", this.fRo);
          paramn.putExtra("Is_Chatroom", true);
          paramn.setFlags(67108864);
          paramString = getContext();
          paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahE(), "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramn.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(13008);
          return;
          ae.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((v)paramn).username });
        }
      }
      t.makeText(this, 2131762708, 1).show();
      ae.w("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer failed: %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    AppMethodBeat.o(13008);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.TransferRoomOwnerUI
 * JD-Core Version:    0.7.0.1
 */