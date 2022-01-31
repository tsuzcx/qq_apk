package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WXPayEntryActivity$1
  implements DialogInterface.OnClickListener
{
  WXPayEntryActivity$1(WXPayEntryActivity paramWXPayEntryActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(153524);
    this.jMu.finish();
    AppMethodBeat.o(153524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXPayEntryActivity.1
 * JD-Core Version:    0.7.0.1
 */