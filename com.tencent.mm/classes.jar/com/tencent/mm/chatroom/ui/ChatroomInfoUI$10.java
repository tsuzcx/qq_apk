package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;

final class ChatroomInfoUI$10
  implements DialogInterface.OnClickListener
{
  ChatroomInfoUI$10(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(103973);
    com.tencent.mm.plugin.report.service.h.qsU.e(14553, new Object[] { Integer.valueOf(3), Integer.valueOf(2), ChatroomInfoUI.b(this.efA) });
    ChatroomInfoUI.bK(false);
    paramDialogInterface = this.efA;
    this.efA.getString(2131297087);
    p localp = com.tencent.mm.ui.base.h.b(paramDialogInterface, this.efA.getString(2131297112), true, new ChatroomInfoUI.a());
    if (!ChatroomInfoUI.JQ()) {}
    for (paramDialogInterface = f.amZ(ChatroomInfoUI.o(this.efA).field_username);; paramDialogInterface = null)
    {
      if (!bo.isNullOrNil(paramDialogInterface))
      {
        localp.dismiss();
        com.tencent.mm.ui.base.h.a(this.efA, false, this.efA.getString(2131305019, new Object[] { paramDialogInterface }), null, this.efA.getString(2131300537), this.efA.getString(2131298413), new ChatroomInfoUI.10.1(this), new ChatroomInfoUI.10.2(this, localp), -1, 2131689667);
        AppMethodBeat.o(103973);
        return;
      }
      ChatroomInfoUI.a(this.efA, localp);
      AppMethodBeat.o(103973);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.10
 * JD-Core Version:    0.7.0.1
 */