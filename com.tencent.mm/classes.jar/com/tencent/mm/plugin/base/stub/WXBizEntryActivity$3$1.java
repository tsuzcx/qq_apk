package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WXBizEntryActivity$3$1
  implements DialogInterface.OnClickListener
{
  WXBizEntryActivity$3$1(WXBizEntryActivity.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18137);
    WXBizEntryActivity.a(this.jLJ.jLI);
    this.jLJ.jLI.finish();
    AppMethodBeat.o(18137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity.3.1
 * JD-Core Version:    0.7.0.1
 */