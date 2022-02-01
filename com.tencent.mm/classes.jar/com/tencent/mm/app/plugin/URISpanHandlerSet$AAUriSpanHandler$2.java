package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cq;

final class URISpanHandlerSet$AAUriSpanHandler$2
  implements DialogInterface.OnClickListener
{
  URISpanHandlerSet$AAUriSpanHandler$2(URISpanHandlerSet.AAUriSpanHandler paramAAUriSpanHandler, String paramString1, String paramString2, long paramLong) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(19674);
    paramDialogInterface = new cq();
    paramDialogInterface.hCA.hCx = this.hkM;
    paramDialogInterface.hCA.hCy = this.hkN;
    paramDialogInterface.hCA.hCz = this.hkO;
    paramDialogInterface.publish();
    AppMethodBeat.o(19674);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler.2
 * JD-Core Version:    0.7.0.1
 */