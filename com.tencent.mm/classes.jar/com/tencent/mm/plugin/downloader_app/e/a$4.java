package com.tencent.mm.plugin.downloader_app.e;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.d;

final class a$4
  implements DialogInterface.OnClickListener
{
  a$4(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136319);
    g.E(d.class);
    this.ldl.s(this.ldl.context, false);
    AppMethodBeat.o(136319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.e.a.4
 * JD-Core Version:    0.7.0.1
 */