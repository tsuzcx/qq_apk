package com.tencent.mm.plugin.downloader_app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;

final class a$3
  implements DialogInterface.OnCancelListener
{
  a$3(a parama, DialogInterface.OnCancelListener paramOnCancelListener, PBool paramPBool, String paramString) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(136007);
    if (this.kZU != null) {
      this.kZU.onCancel(paramDialogInterface);
    }
    if (!this.kZR.value) {
      com.tencent.mm.plugin.downloader_app.c.a.a(15, 1501, 1, 2, this.val$appId, "", "");
    }
    AppMethodBeat.o(136007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.3
 * JD-Core Version:    0.7.0.1
 */