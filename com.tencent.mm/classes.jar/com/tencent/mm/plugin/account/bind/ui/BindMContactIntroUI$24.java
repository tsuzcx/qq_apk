package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.ui.base.h;

final class BindMContactIntroUI$24
  implements DialogInterface.OnClickListener
{
  BindMContactIntroUI$24(BindMContactIntroUI paramBindMContactIntroUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13434);
    if ((BindMContactIntroUI.e(this.gtw) == null) || (BindMContactIntroUI.e(this.gtw).equals("")))
    {
      AppMethodBeat.o(13434);
      return;
    }
    paramDialogInterface = new y(y.gxY);
    g.Rc().a(paramDialogInterface, 0);
    paramDialogInterface = this.gtw;
    BindMContactIntroUI localBindMContactIntroUI = this.gtw;
    this.gtw.getString(2131297087);
    BindMContactIntroUI.a(paramDialogInterface, h.b(localBindMContactIntroUI, this.gtw.getString(2131296987), true, new BindMContactIntroUI.24.1(this)));
    AppMethodBeat.o(13434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.24
 * JD-Core Version:    0.7.0.1
 */