package com.tencent.mm.plugin.downloader.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;

final class o$5
  implements DialogInterface.OnClickListener
{
  o$5(a parama, o.a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(141070);
    o.a(this.kYh, false, this.kZi);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(141070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.5
 * JD-Core Version:    0.7.0.1
 */