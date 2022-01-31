package com.tencent.mm.plugin.downloader.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;

final class o$4
  implements DialogInterface.OnCancelListener
{
  o$4(PBool paramPBool, o.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(141069);
    if (this.kZh.value)
    {
      AppMethodBeat.o(141069);
      return;
    }
    this.kZi.c("cancel", null);
    AppMethodBeat.o(141069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.4
 * JD-Core Version:    0.7.0.1
 */