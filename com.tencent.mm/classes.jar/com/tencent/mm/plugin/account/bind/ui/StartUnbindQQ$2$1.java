package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.ui.base.h;

final class StartUnbindQQ$2$1
  implements DialogInterface.OnClickListener
{
  StartUnbindQQ$2$1(StartUnbindQQ.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13762);
    paramDialogInterface = new d("");
    g.Rc().a(paramDialogInterface, 0);
    paramDialogInterface = this.gwt.gws;
    StartUnbindQQ localStartUnbindQQ = this.gwt.gws;
    this.gwt.gws.getString(2131297087);
    StartUnbindQQ.a(paramDialogInterface, h.b(localStartUnbindQQ, this.gwt.gws.getString(2131303176), true, null));
    AppMethodBeat.o(13762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.2.1
 * JD-Core Version:    0.7.0.1
 */