package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.sdk.b.a;

final class URISpanHandlerSet$AAUriSpanHandler$1
  implements DialogInterface.OnClickListener
{
  URISpanHandlerSet$AAUriSpanHandler$1(URISpanHandlerSet.AAUriSpanHandler paramAAUriSpanHandler, String paramString1, String paramString2, long paramLong) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(19673);
    paramDialogInterface = new ca();
    paramDialogInterface.dnU.dnV = this.cXw;
    paramDialogInterface.dnU.dnW = this.cXx;
    paramDialogInterface.dnU.dnX = this.cXy;
    a.IvT.l(paramDialogInterface);
    AppMethodBeat.o(19673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler.1
 * JD-Core Version:    0.7.0.1
 */