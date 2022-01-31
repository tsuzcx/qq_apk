package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.sdk.b.a;

final class URISpanHandlerSet$AAUriSpanHandler$1
  implements DialogInterface.OnClickListener
{
  URISpanHandlerSet$AAUriSpanHandler$1(URISpanHandlerSet.AAUriSpanHandler paramAAUriSpanHandler, String paramString1, String paramString2, long paramLong) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(15628);
    paramDialogInterface = new bs();
    paramDialogInterface.cpd.cpe = this.can;
    paramDialogInterface.cpd.cpf = this.cao;
    paramDialogInterface.cpd.cpg = this.cap;
    a.ymk.l(paramDialogInterface);
    AppMethodBeat.o(15628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler.1
 * JD-Core Version:    0.7.0.1
 */