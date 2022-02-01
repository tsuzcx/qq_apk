package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.d.v;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.b.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;

public class TransferRoomOwnerUI
  extends SelectMemberUI
  implements i
{
  private s jhZ;
  private boolean jma;
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13009);
    super.a(paramView, paramInt, paramLong);
    paramView = this.jkE.qC(paramInt);
    if ((paramView == null) || (paramView.contact == null))
    {
      Log.e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
      AppMethodBeat.o(13009);
      return;
    }
    Object localObject2 = paramView.contact;
    final String str = ((ax)localObject2).field_username;
    if (!Util.isNullOrNil(((ax)localObject2).field_conRemark))
    {
      paramView = ((ax)localObject2).field_conRemark;
      if (!Util.isNullOrNil(paramView)) {
        break label290;
      }
    }
    label290:
    for (Object localObject1 = ((as)localObject2).ayr();; localObject1 = paramView)
    {
      paramView = (View)localObject1;
      if (!d.rk(((ax)localObject2).field_type))
      {
        co localco = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbM().aPj(((ax)localObject2).field_username);
        paramView = (View)localObject1;
        if (localco != null)
        {
          paramView = (View)localObject1;
          if (!Util.isNullOrNil(localco.field_conRemark)) {
            paramView = localco.field_conRemark;
          }
        }
      }
      localObject2 = com.tencent.mm.openim.room.a.a.V((as)localObject2);
      localObject1 = paramView;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramView + localObject2;
      }
      if (!this.jma) {}
      for (paramView = getString(a.i.jgI, new Object[] { localObject1 });; paramView = getString(a.i.jgs, new Object[] { localObject1 }))
      {
        com.tencent.mm.ui.base.h.a(this, paramView, "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(13004);
            if (ab.PQ(TransferRoomOwnerUI.this.jaK)) {}
            for (paramAnonymousDialogInterface = new p(TransferRoomOwnerUI.this.jaK, str);; paramAnonymousDialogInterface = new v(TransferRoomOwnerUI.this.jaK, str))
            {
              com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousDialogInterface, 0);
              paramAnonymousDialogInterface = TransferRoomOwnerUI.this;
              TransferRoomOwnerUI localTransferRoomOwnerUI = TransferRoomOwnerUI.this;
              TransferRoomOwnerUI.this.getString(a.i.app_tip);
              TransferRoomOwnerUI.a(paramAnonymousDialogInterface, com.tencent.mm.ui.base.h.a(localTransferRoomOwnerUI, TransferRoomOwnerUI.this.getString(a.i.jgJ), false, null));
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
        paramView = a(this.iXp, ((ax)localObject2).field_username);
        break;
      }
    }
  }
  
  protected final void atg()
  {
    AppMethodBeat.i(13006);
    super.atg();
    this.jma = getIntent().getBooleanExtra("quit_room", false);
    AppMethodBeat.o(13006);
  }
  
  protected final boolean ati()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13005);
    super.onCreate(paramBundle);
    if (ab.PQ(this.jaK))
    {
      com.tencent.mm.kernel.h.aHF().kcd.a(811, this);
      AppMethodBeat.o(13005);
      return;
    }
    com.tencent.mm.kernel.h.aHF().kcd.a(990, this);
    AppMethodBeat.o(13005);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13007);
    super.onDestroy();
    if ((this.jhZ != null) && (this.jhZ.isShowing())) {
      this.jhZ.dismiss();
    }
    if (ab.PQ(this.jaK))
    {
      com.tencent.mm.kernel.h.aHF().kcd.b(811, this);
      AppMethodBeat.o(13007);
      return;
    }
    com.tencent.mm.kernel.h.aHF().kcd.b(990, this);
    AppMethodBeat.o(13007);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(13008);
    if ((this.jhZ != null) && (this.jhZ.isShowing())) {
      this.jhZ.dismiss();
    }
    if ((paramq.getType() == 990) || (paramq.getType() == 811))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (ab.PQ(this.jaK)) {
          Log.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((p)paramq).username });
        }
        for (;;)
        {
          w.makeText(this, a.i.jgH, 1).show();
          paramq = new Intent(getContext(), ChatroomInfoUI.class);
          paramq.putExtra("RoomInfo_Id", this.jaK);
          paramq.putExtra("Chat_User", this.jaK);
          paramq.putExtra("Is_Chatroom", true);
          paramq.setFlags(67108864);
          paramString = getContext();
          paramq = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, paramq.aFh(), "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramq.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(13008);
          return;
          Log.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((v)paramq).username });
        }
      }
      w.makeText(this, a.i.jgG, 1).show();
      Log.w("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer failed: %d %d %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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