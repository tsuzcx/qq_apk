package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WXEntryActivity$2
  implements DialogInterface.OnCancelListener
{
  WXEntryActivity$2(WXEntryActivity paramWXEntryActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(18191);
    WXEntryActivity.b(this.jMo);
    this.jMo.finish();
    AppMethodBeat.o(18191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.2
 * JD-Core Version:    0.7.0.1
 */