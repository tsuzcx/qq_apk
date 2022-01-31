package com.tencent.mm.plugin.downloader_app.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader_app.a.a.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;

final class c$15
  implements DialogInterface.OnClickListener
{
  c$15(a parama, a.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136096);
    this.kYh.field_status = 4;
    com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
    d.iV(this.kYh.field_downloadId);
    if (this.laH != null) {
      this.laH.a(a.a.kZZ, this.kYh.field_downloadId);
    }
    if (this.laH != null) {
      this.laH.a(a.a.kZZ, this.kYh.field_downloadId);
    }
    AppMethodBeat.o(136096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.15
 * JD-Core Version:    0.7.0.1
 */