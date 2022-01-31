package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.clr;

final class WXBizEntryActivity$5$1
  implements DialogInterface.OnClickListener
{
  WXBizEntryActivity$5$1(WXBizEntryActivity.5 param5, clr paramclr) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18141);
    WXBizEntryActivity.a(this.jLN.jLI, this.jLN.jLL, this.jLM.xVH);
    this.jLN.jLI.finish();
    AppMethodBeat.o(18141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity.5.1
 * JD-Core Version:    0.7.0.1
 */