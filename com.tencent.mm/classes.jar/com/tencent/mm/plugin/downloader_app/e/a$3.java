package com.tencent.mm.plugin.downloader_app.e;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.d;

final class a$3
  implements DialogInterface.OnClickListener
{
  a$3(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136318);
    ((d)g.E(d.class)).a(this.ldl.context, null, null);
    AppMethodBeat.o(136318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.e.a.3
 * JD-Core Version:    0.7.0.1
 */