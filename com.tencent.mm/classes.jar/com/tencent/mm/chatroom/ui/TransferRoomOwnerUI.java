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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.chatroom.d.v;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.openim.b.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;

public class TransferRoomOwnerUI
  extends SelectMemberUI
  implements i
{
  private boolean gBU;
  private com.tencent.mm.ui.base.q gxX;
  
  protected final void a(View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(13009);
    super.a(paramView, paramInt, paramLong);
    paramView = this.gAA.on(paramInt);
    if ((paramView == null) || (paramView.contact == null))
    {
      Log.e("MicroMsg.TransferRoomOwnerUI", "null == item || null == item.contact");
      AppMethodBeat.o(13009);
      return;
    }
    Object localObject2 = paramView.contact;
    String str = ((ax)localObject2).field_username;
    if (!Util.isNullOrNil(((ax)localObject2).field_conRemark))
    {
      paramView = ((ax)localObject2).field_conRemark;
      if (!Util.isNullOrNil(paramView)) {
        break label288;
      }
    }
    label288:
    for (Object localObject1 = ((as)localObject2).arI();; localObject1 = paramView)
    {
      paramView = (View)localObject1;
      if (!c.oR(((ax)localObject2).field_type))
      {
        cn localcn = ((l)g.af(l.class)).aSO().aEZ(((ax)localObject2).field_username);
        paramView = (View)localObject1;
        if (localcn != null)
        {
          paramView = (View)localObject1;
          if (!Util.isNullOrNil(localcn.field_conRemark)) {
            paramView = localcn.field_conRemark;
          }
        }
      }
      localObject2 = com.tencent.mm.openim.room.a.a.O((as)localObject2);
      localObject1 = paramView;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramView + localObject2;
      }
      if (!this.gBU) {}
      for (paramView = getString(2131764794, new Object[] { localObject1 });; paramView = getString(2131764758, new Object[] { localObject1 }))
      {
        h.a(this, paramView, "", new TransferRoomOwnerUI.1(this, str), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(13009);
        return;
        paramView = a(this.gtd, ((ax)localObject2).field_username);
        break;
      }
    }
  }
  
  protected final void anf()
  {
    AppMethodBeat.i(13006);
    super.anf();
    this.gBU = getIntent().getBooleanExtra("quit_room", false);
    AppMethodBeat.o(13006);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13005);
    super.onCreate(paramBundle);
    if (ab.Iy(this.gwx))
    {
      g.aAg().hqi.a(811, this);
      AppMethodBeat.o(13005);
      return;
    }
    g.aAg().hqi.a(990, this);
    AppMethodBeat.o(13005);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13007);
    super.onDestroy();
    if ((this.gxX != null) && (this.gxX.isShowing())) {
      this.gxX.dismiss();
    }
    if (ab.Iy(this.gwx))
    {
      g.aAg().hqi.b(811, this);
      AppMethodBeat.o(13007);
      return;
    }
    g.aAg().hqi.b(990, this);
    AppMethodBeat.o(13007);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(13008);
    if ((this.gxX != null) && (this.gxX.isShowing())) {
      this.gxX.dismiss();
    }
    if ((paramq.getType() == 990) || (paramq.getType() == 811))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (ab.Iy(this.gwx)) {
          Log.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((p)paramq).username });
        }
        for (;;)
        {
          u.makeText(this, 2131764792, 1).show();
          paramq = new Intent(getContext(), ChatroomInfoUI.class);
          paramq.putExtra("RoomInfo_Id", this.gwx);
          paramq.putExtra("Chat_User", this.gwx);
          paramq.putExtra("Is_Chatroom", true);
          paramq.setFlags(67108864);
          paramString = getContext();
          paramq = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramq.axQ(), "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramq.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/chatroom/ui/TransferRoomOwnerUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          finish();
          AppMethodBeat.o(13008);
          return;
          Log.i("MicroMsg.TransferRoomOwnerUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[] { ((v)paramq).username });
        }
      }
      u.makeText(this, 2131764791, 1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.TransferRoomOwnerUI
 * JD-Core Version:    0.7.0.1
 */