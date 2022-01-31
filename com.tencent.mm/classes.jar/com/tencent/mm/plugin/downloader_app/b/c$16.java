package com.tencent.mm.plugin.downloader_app.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;

final class c$16
  implements DialogInterface.OnClickListener
{
  c$16(a parama, a.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136097);
    d.JV(this.kYh.field_appId);
    c.a(this.kYh, false, this.laH);
    AppMethodBeat.o(136097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.16
 * JD-Core Version:    0.7.0.1
 */