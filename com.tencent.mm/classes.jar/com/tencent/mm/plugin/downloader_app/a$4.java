package com.tencent.mm.plugin.downloader_app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;

final class a$4
  implements DialogInterface.OnClickListener
{
  a$4(a parama, PBool paramPBool, DialogInterface.OnClickListener paramOnClickListener, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136008);
    this.kZR.value = true;
    if (this.kZQ != null) {
      this.kZQ.onClick(paramDialogInterface, paramInt);
    }
    this.kZR.value = true;
    com.tencent.mm.plugin.downloader_app.c.a.a(15, 1502, 1, 23, this.val$appId, "", "");
    AppMethodBeat.o(136008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.4
 * JD-Core Version:    0.7.0.1
 */