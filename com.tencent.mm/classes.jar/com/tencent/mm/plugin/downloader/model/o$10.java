package com.tencent.mm.plugin.downloader.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;

final class o$10
  implements DialogInterface.OnCancelListener
{
  o$10(PBool paramPBool, o.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(141075);
    if (this.kZk.value)
    {
      AppMethodBeat.o(141075);
      return;
    }
    this.kZi.c("cancel", null);
    AppMethodBeat.o(141075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.10
 * JD-Core Version:    0.7.0.1
 */