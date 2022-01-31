package com.tencent.mm.app.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.h.a.bq;
import com.tencent.mm.sdk.b.a;

final class URISpanHandlerSet$AAUriSpanHandler$1
  implements DialogInterface.OnClickListener
{
  URISpanHandlerSet$AAUriSpanHandler$1(URISpanHandlerSet.AAUriSpanHandler paramAAUriSpanHandler, String paramString1, String paramString2, long paramLong) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new bq();
    paramDialogInterface.bHO.bHP = this.byl;
    paramDialogInterface.bHO.bHQ = this.bym;
    paramDialogInterface.bHO.bHR = this.byn;
    a.udP.m(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler.1
 * JD-Core Version:    0.7.0.1
 */