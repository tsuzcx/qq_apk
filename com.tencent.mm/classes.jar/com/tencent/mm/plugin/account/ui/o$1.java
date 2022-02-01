package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.friend.a.z;

final class o$1
  implements DialogInterface.OnCancelListener
{
  o$1(o paramo, z paramz) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(128416);
    h.aGY().a(this.mTi);
    h.aGY().b(132, this.ngx);
    AppMethodBeat.o(128416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.1
 * JD-Core Version:    0.7.0.1
 */