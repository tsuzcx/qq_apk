package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.p;

final class RoomInfoDetailUI$2
  implements h.c
{
  RoomInfoDetailUI$2(RoomInfoDetailUI paramRoomInfoDetailUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    RoomInfoDetailUI.a(this.dqf, false);
    Object localObject = this.dqf;
    this.dqf.getString(a.i.app_tip);
    p localp = h.b((Context)localObject, this.dqf.getString(a.i.app_waiting), true, new RoomInfoDetailUI.2.1(this));
    if (!RoomInfoDetailUI.a(this.dqf)) {}
    for (localObject = e.Xe(RoomInfoDetailUI.b(this.dqf).field_username);; localObject = null)
    {
      if (!bk.bl((String)localObject))
      {
        localp.dismiss();
        h.a(this.dqf, false, this.dqf.getString(a.i.wallet_clear_chatting_history_note, new Object[] { localObject }), null, this.dqf.getString(a.i.goto_conversation), this.dqf.getString(a.i.clear_chat_history), new RoomInfoDetailUI.2.2(this), new RoomInfoDetailUI.2.3(this, localp), -1, a.b.alert_btn_color_warn);
        return;
      }
      RoomInfoDetailUI.a(this.dqf, localp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomInfoDetailUI.2
 * JD-Core Version:    0.7.0.1
 */