package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.f;
import com.tencent.mm.sdk.platformtools.y;

final class URISpanHandlerSet$DeeplinkUriSpanHandler$1
  implements DialogInterface.OnClickListener
{
  URISpanHandlerSet$DeeplinkUriSpanHandler$1(URISpanHandlerSet.DeeplinkUriSpanHandler paramDeeplinkUriSpanHandler, d paramd, String paramString1, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = this.byp.field_brandFlag;
    this.byp.field_brandFlag |= 0x1;
    y.i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", new Object[] { this.byq, this.byr, Integer.valueOf(paramInt), Integer.valueOf(this.byp.field_brandFlag) });
    f.f(this.byp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler.1
 * JD-Core Version:    0.7.0.1
 */