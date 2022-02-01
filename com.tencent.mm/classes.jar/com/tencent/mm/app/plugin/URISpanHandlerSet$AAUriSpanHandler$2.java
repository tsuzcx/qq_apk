package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.sdk.b.a;

final class URISpanHandlerSet$AAUriSpanHandler$2
  implements DialogInterface.OnClickListener
{
  URISpanHandlerSet$AAUriSpanHandler$2(URISpanHandlerSet.AAUriSpanHandler paramAAUriSpanHandler, String paramString1, String paramString2, long paramLong) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(19674);
    paramDialogInterface = new cb();
    paramDialogInterface.dnY.dnV = this.cXw;
    paramDialogInterface.dnY.dnW = this.cXx;
    paramDialogInterface.dnY.dnX = this.cXy;
    a.IvT.l(paramDialogInterface);
    AppMethodBeat.o(19674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler.2
 * JD-Core Version:    0.7.0.1
 */