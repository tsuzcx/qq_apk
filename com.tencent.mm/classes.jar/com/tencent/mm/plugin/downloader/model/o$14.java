package com.tencent.mm.plugin.downloader.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.pointers.PBool;

final class o$14
  implements DialogInterface.OnClickListener
{
  o$14(PBool paramPBool, a parama, o.a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(141079);
    this.kZh.value = true;
    o.a(this.kZm, this.kZi, true);
    AppMethodBeat.o(141079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o.14
 * JD-Core Version:    0.7.0.1
 */