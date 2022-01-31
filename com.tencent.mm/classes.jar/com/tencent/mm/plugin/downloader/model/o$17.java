package com.tencent.mm.plugin.downloader.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$17
  implements DialogInterface.OnClickListener
{
  o$17(o.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(141082);
    paramDialogInterface.dismiss();
    this.kZi.c("network_not_wifi", null);
    AppMethodBeat.o(141082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.17
 * JD-Core Version:    0.7.0.1
 */