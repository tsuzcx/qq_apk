package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WXBizEntryActivity$7$1
  implements DialogInterface.OnClickListener
{
  WXBizEntryActivity$7$1(WXBizEntryActivity.7 param7) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18145);
    WXBizEntryActivity.c(this.jLQ.jLI);
    this.jLQ.jLI.finish();
    AppMethodBeat.o(18145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity.7.1
 * JD-Core Version:    0.7.0.1
 */