package com.tencent.mm.plugin.downloader.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.pointers.PBool;

final class o$3
  implements DialogInterface.OnClickListener
{
  o$3(PBool paramPBool, a parama, o.a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(141068);
    this.kZh.value = true;
    o.a(this.kYh, true, this.kZi);
    AppMethodBeat.o(141068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.3
 * JD-Core Version:    0.7.0.1
 */