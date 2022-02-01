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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.chatroom.d.v;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;

public class TransferRoomOwnerUI
  extends SelectMemberUI
  implements com.tencent.mm.al.g
{
  private com.tencent.mm.ui.base.p ftP;
  private boolean fxO;
  
  protected final void VS()
  {
    AppMethodBeat.i(13006);
    super.VS();
    this.fxO = getIntent().getBooleanExtra("quit_room", false);
    AppMethodBeat.o(13006);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13009);
    super.a(paramView, paramInt, paramLong);
    paramView = this.fwq.kQ(paramInt);
    if ((paramView == null) || (paramView.contact == null))
    {
      ad.e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
      AppMethodBeat.o(13009);
      return;
    }
    Object localObject2 = paramView.contact;
    final String str = ((au)localObject2).field_username;
    if (!bt.isNullOrNil(((au)localObject2).field_conRemark))
    {
      paramView = ((au)localObject2).field_conRemark;
      if (!bt.isNullOrNil(paramView)) {
        break label288;
      }
    }
    label288:
    for (Object localObject1 = ((af)localObject2).ZW();; localObject1 = paramView)
    {
      paramView = (View)localObject1;
      if (!com.tencent.mm.n.b.ls(((au)localObject2).field_type))
      {
        bw localbw = ((k)com.tencent.mm.kernel.g.ab(k.class)).apN().agQ(((au)localObject2).field_username);
        paramView = (View)localObject1;
        if (localbw != null)
        {
          paramView = (View)localObject1;
          if (!bt.isNullOrNil(localbw.field_conRemark)) {
            paramView = localbw.field_conRemark;
          }
        }
      }
      localObject2 = com.tencent.mm.openim.room.a.a.G((af)localObject2);
      localObject1 = paramView;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramView + localObject2;
      }
      if (!this.fxO) {}
      for (paramView = getString(2131762711, new Object[] { localObject1 });; paramView = getString(2131762675, new Object[] { localObject1 }))
      {
        h.a(this, paramView, "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(13004);
            if (w.sn(TransferRoomOwnerUI.this.fss)) {}
            for (paramAnonymousDialogInterface = new com.tencent.mm.openim.b.p(TransferRoomOwnerUI.this.fss, str);; paramAnonymousDialogInterface = new v(TransferRoomOwnerUI.this.fss, str))
            {
              com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousDialogInterface, 0);
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
        paramView = a(this.fql, ((au)localObject2).field_username);
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13005);
    super.onCreate(paramBundle);
    if (w.sn(this.fss))
    {
      com.tencent.mm.kernel.g.afA().gcy.a(811, this);
      AppMethodBeat.o(13005);
      return;
    }
    com.tencent.mm.kernel.g.afA().gcy.a(990, this);
    AppMethodBeat.o(13005);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13007);
    super.onDestroy();
    if ((this.ftP != null) && (this.ftP.isShowing())) {
      this.ftP.dismiss();
    }
    if (w.sn(this.fss))
    {
      com.tencent.mm.kernel.g.afA().gcy.b(811, this);
      AppMethodBeat.o(13007);
      return;
    }
    com.tencent.mm.kernel.g.afA().gcy.b(990, this);
    AppMethodBeat.o(13007);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(13008);
    if ((this.ftP != null) && (this.ftP.isShowing())) {
      this.ftP.dismiss();
    }
    if ((paramn.getType() == 990) || (paramn.getType() == 811))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (w.sn(this.fss)) {
          ad.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((com.tencent.mm.openim.b.p)paramn).username });
        }
        for (;;)
        {
          t.makeText(this, 2131762709, 1).show();
          paramn = new Intent(getContext(), ChatroomInfoUI.class);
          paramn.putExtra("RoomInfo_Id", this.fss);
          paramn.putExtra("Chat_User", this.fss);
          paramn.putExtra("Is_Chatroom", true);
          paramn.setFlags(67108864);
          paramString = getContext();
          paramn = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.adn(), "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramn.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(13008);
          return;
          ad.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((v)paramn).username });
        }
      }
      t.makeText(this, 2131762708, 1).show();
      ad.w("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer failed: %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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