package com.tencent.mm.plugin.downloader_app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;

final class a$5
  implements DialogInterface.OnClickListener
{
  a$5(a parama, DialogInterface.OnClickListener paramOnClickListener, PBool paramPBool, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136009);
    if (this.kZT != null) {
      this.kZT.onClick(paramDialogInterface, paramInt);
    }
    this.kZR.value = true;
    com.tencent.mm.plugin.downloader_app.c.a.a(15, 1502, 1, 3, this.val$appId, "", "");
    AppMethodBeat.o(136009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.5
 * JD-Core Version:    0.7.0.1
 */