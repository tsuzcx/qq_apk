package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.af;

final class QQFriendUI$1
  implements DialogInterface.OnCancelListener
{
  QQFriendUI$1(QQFriendUI paramQQFriendUI, af paramaf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(131274);
    g.azz().a(this.khs);
    AppMethodBeat.o(131274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.QQFriendUI.1
 * JD-Core Version:    0.7.0.1
 */