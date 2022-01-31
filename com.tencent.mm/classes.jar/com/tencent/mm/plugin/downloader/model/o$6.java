package com.tencent.mm.plugin.downloader.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$6
  implements DialogInterface.OnClickListener
{
  o$6(o.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(141071);
    paramDialogInterface.dismiss();
    this.kZi.c("fail_network_not_wifi", null);
    AppMethodBeat.o(141071);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.6
 * JD-Core Version:    0.7.0.1
 */