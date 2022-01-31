package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.sdk.platformtools.ab;

final class URISpanHandlerSet$DeeplinkUriSpanHandler$2
  implements DialogInterface.OnClickListener
{
  URISpanHandlerSet$DeeplinkUriSpanHandler$2(URISpanHandlerSet.DeeplinkUriSpanHandler paramDeeplinkUriSpanHandler, d paramd, String paramString1, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(15646);
    paramInt = this.car.field_brandFlag;
    this.car.field_brandFlag &= 0xFFFFFFFE;
    ab.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", new Object[] { this.cas, this.cat, Integer.valueOf(paramInt), Integer.valueOf(this.car.field_brandFlag) });
    f.f(this.car);
    AppMethodBeat.o(15646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler.2
 * JD-Core Version:    0.7.0.1
 */