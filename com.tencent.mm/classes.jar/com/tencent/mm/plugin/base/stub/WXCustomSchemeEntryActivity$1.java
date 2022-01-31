package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WXCustomSchemeEntryActivity$1
  implements DialogInterface.OnClickListener
{
  WXCustomSchemeEntryActivity$1(WXCustomSchemeEntryActivity paramWXCustomSchemeEntryActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(153501);
    this.jMj.finish();
    AppMethodBeat.o(153501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity.1
 * JD-Core Version:    0.7.0.1
 */