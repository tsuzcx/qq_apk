package com.tencent.mm.plugin.downloader.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.pointers.PBool;

final class o$8
  implements DialogInterface.OnClickListener
{
  o$8(PBool paramPBool, a parama, o.a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(141073);
    this.kZk.value = true;
    o.a(this.kYh, false, this.kZi);
    AppMethodBeat.o(141073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.8
 * JD-Core Version:    0.7.0.1
 */