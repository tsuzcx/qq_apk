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
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.chatroom.d.v;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;

public class TransferRoomOwnerUI
  extends SelectMemberUI
  implements f
{
  private com.tencent.mm.ui.base.p fQJ;
  private boolean fUI;
  
  protected final void Zj()
  {
    AppMethodBeat.i(13006);
    super.Zj();
    this.fUI = getIntent().getBooleanExtra("quit_room", false);
    AppMethodBeat.o(13006);
  }
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13009);
    super.a(paramView, paramInt, paramLong);
    paramView = this.fTn.lj(paramInt);
    if ((paramView == null) || (paramView.contact == null))
    {
      ad.e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
      AppMethodBeat.o(13009);
      return;
    }
    Object localObject2 = paramView.contact;
    String str = ((aw)localObject2).field_username;
    if (!bt.isNullOrNil(((aw)localObject2).field_conRemark))
    {
      paramView = ((aw)localObject2).field_conRemark;
      if (!bt.isNullOrNil(paramView)) {
        break label288;
      }
    }
    label288:
    for (Object localObject1 = ((am)localObject2).adu();; localObject1 = paramView)
    {
      paramView = (View)localObject1;
      if (!com.tencent.mm.o.b.lM(((aw)localObject2).field_type))
      {
        cf localcf = ((l)g.ab(l.class)).azq().aqz(((aw)localObject2).field_username);
        paramView = (View)localObject1;
        if (localcf != null)
        {
          paramView = (View)localObject1;
          if (!bt.isNullOrNil(localcf.field_conRemark)) {
            paramView = localcf.field_conRemark;
          }
        }
      }
      localObject2 = com.tencent.mm.openim.room.a.a.H((am)localObject2);
      localObject1 = paramView;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramView + localObject2;
      }
      if (!this.fUI) {}
      for (paramView = getString(2131762711, new Object[] { localObject1 });; paramView = getString(2131762675, new Object[] { localObject1 }))
      {
        h.a(this, paramView, "", new TransferRoomOwnerUI.1(this, str), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(13009);
        return;
        paramView = a(this.fLO, ((aw)localObject2).field_username);
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13005);
    super.onCreate(paramBundle);
    if (w.zl(this.fPi))
    {
      g.ajB().gAO.a(811, this);
      AppMethodBeat.o(13005);
      return;
    }
    g.ajB().gAO.a(990, this);
    AppMethodBeat.o(13005);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13007);
    super.onDestroy();
    if ((this.fQJ != null) && (this.fQJ.isShowing())) {
      this.fQJ.dismiss();
    }
    if (w.zl(this.fPi))
    {
      g.ajB().gAO.b(811, this);
      AppMethodBeat.o(13007);
      return;
    }
    g.ajB().gAO.b(990, this);
    AppMethodBeat.o(13007);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(13008);
    if ((this.fQJ != null) && (this.fQJ.isShowing())) {
      this.fQJ.dismiss();
    }
    if ((paramn.getType() == 990) || (paramn.getType() == 811))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (w.zl(this.fPi)) {
          ad.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((com.tencent.mm.openim.b.p)paramn).username });
        }
        for (;;)
        {
          t.makeText(this, 2131762709, 1).show();
          paramn = new Intent(getContext(), ChatroomInfoUI.class);
          paramn.putExtra("RoomInfo_Id", this.fPi);
          paramn.putExtra("Chat_User", this.fPi);
          paramn.putExtra("Is_Chatroom", true);
          paramn.setFlags(67108864);
          paramString = getContext();
          paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahp(), "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramn.mq(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.TransferRoomOwnerUI
 * JD-Core Version:    0.7.0.1
 */