package com.tencent.mm.plugin.downloader.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;

final class o$15
  implements DialogInterface.OnCancelListener
{
  o$15(PBool paramPBool, o.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(141080);
    if (this.kZh.value)
    {
      AppMethodBeat.o(141080);
      return;
    }
    this.kZi.c("cancel", null);
    AppMethodBeat.o(141080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.15
 * JD-Core Version:    0.7.0.1
 */