package com.tencent.mm.plugin.downloader_app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;

final class a$6
  implements DialogInterface.OnCancelListener
{
  a$6(a parama, DialogInterface.OnCancelListener paramOnCancelListener, PBool paramPBool, String paramString) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(136010);
    if (this.kZU != null) {
      this.kZU.onCancel(paramDialogInterface);
    }
    if (!this.kZR.value) {
      com.tencent.mm.plugin.downloader_app.c.a.a(15, 1502, 1, 2, this.val$appId, "", "");
    }
    AppMethodBeat.o(136010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.6
 * JD-Core Version:    0.7.0.1
 */