package com.tencent.mm.plugin.downloader_app.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;

final class c$2
  implements DialogInterface.OnClickListener
{
  c$2(a parama, a.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136086);
    d.JV(this.kYh.field_appId);
    c.a(this.kYh, false, this.laH);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(136086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.2
 * JD-Core Version:    0.7.0.1
 */