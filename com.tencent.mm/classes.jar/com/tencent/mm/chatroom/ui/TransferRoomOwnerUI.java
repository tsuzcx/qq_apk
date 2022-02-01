package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public class TransferRoomOwnerUI
  extends SelectMemberUI
  implements com.tencent.mm.am.h
{
  private boolean cqN;
  private w lKp;
  
  protected final void aNn()
  {
    AppMethodBeat.i(13006);
    super.aNn();
    this.cqN = getIntent().getBooleanExtra("quit_room", false);
    AppMethodBeat.o(13006);
  }
  
  protected final boolean aNp()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13005);
    super.onCreate(paramBundle);
    if (au.bwF(this.lyn))
    {
      com.tencent.mm.kernel.h.baD().mCm.a(811, this);
      AppMethodBeat.o(13005);
      return;
    }
    com.tencent.mm.kernel.h.baD().mCm.a(990, this);
    AppMethodBeat.o(13005);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13007);
    super.onDestroy();
    if ((this.lKp != null) && (this.lKp.isShowing())) {
      this.lKp.dismiss();
    }
    if (au.bwF(this.lyn))
    {
      com.tencent.mm.kernel.h.baD().mCm.b(811, this);
      AppMethodBeat.o(13007);
      return;
    }
    com.tencent.mm.kernel.h.baD().mCm.b(990, this);
    AppMethodBeat.o(13007);
  }
  
  protected final void onItemClick(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13009);
    super.onItemClick(paramView, paramInt, paramLong);
    paramView = this.lNi.qF(paramInt);
    if ((paramView == null) || (paramView.contact == null))
    {
      Log.e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
      AppMethodBeat.o(13009);
      return;
    }
    Object localObject2 = paramView.contact;
    final String str = ((az)localObject2).field_username;
    if (!Util.isNullOrNil(((az)localObject2).field_conRemark))
    {
      paramView = ((az)localObject2).field_conRemark;
      if (!Util.isNullOrNil(paramView)) {
        break label290;
      }
    }
    label290:
    for (Object localObject1 = ((au)localObject2).aSU();; localObject1 = paramView)
    {
      paramView = (View)localObject1;
      if (!d.rs(((az)localObject2).field_type))
      {
        cr localcr = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMi(((az)localObject2).field_username);
        paramView = (View)localObject1;
        if (localcr != null)
        {
          paramView = (View)localObject1;
          if (!Util.isNullOrNil(localcr.field_conRemark)) {
            paramView = localcr.field_conRemark;
          }
        }
      }
      localObject2 = com.tencent.mm.openim.room.a.a.X((au)localObject2);
      localObject1 = paramView;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramView + localObject2;
      }
      if (!this.cqN) {}
      for (paramView = getString(a.i.lIY, new Object[] { localObject1 });; paramView = getString(a.i.lIF, new Object[] { localObject1 }))
      {
        k.a(this, paramView, "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(13004);
            if (au.bwF(TransferRoomOwnerUI.this.lyn)) {}
            for (paramAnonymousDialogInterface = new com.tencent.mm.openim.model.s(TransferRoomOwnerUI.this.lyn, str);; paramAnonymousDialogInterface = new y(TransferRoomOwnerUI.this.lyn, str))
            {
              com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousDialogInterface, 0);
              paramAnonymousDialogInterface = TransferRoomOwnerUI.this;
              TransferRoomOwnerUI localTransferRoomOwnerUI = TransferRoomOwnerUI.this;
              TransferRoomOwnerUI.this.getString(a.i.app_tip);
              TransferRoomOwnerUI.a(paramAnonymousDialogInterface, k.a(localTransferRoomOwnerUI, TransferRoomOwnerUI.this.getString(a.i.lIZ), false, null));
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
        paramView = a(this.lzy, ((az)localObject2).field_username);
        break;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(13008);
    if ((this.lKp != null) && (this.lKp.isShowing())) {
      this.lKp.dismiss();
    }
    if ((paramp.getType() == 990) || (paramp.getType() == 811))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (au.bwF(this.lyn)) {
          Log.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((com.tencent.mm.openim.model.s)paramp).username });
        }
        for (;;)
        {
          aa.makeText(this, a.i.lIX, 1).show();
          paramp = new Intent(getContext(), ChatroomInfoUI.class);
          paramp.putExtra("RoomInfo_Id", this.lyn);
          paramp.putExtra("Chat_User", this.lyn);
          paramp.putExtra("Is_Chatroom", true);
          paramp.setFlags(67108864);
          paramString = getContext();
          paramp = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, paramp.aYi(), "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramp.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(13008);
          return;
          Log.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((y)paramp).username });
        }
      }
      aa.makeText(this, a.i.lIW, 1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.TransferRoomOwnerUI
 * JD-Core Version:    0.7.0.1
 */