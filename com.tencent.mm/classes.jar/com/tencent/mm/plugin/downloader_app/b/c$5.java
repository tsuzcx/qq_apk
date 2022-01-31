package com.tencent.mm.plugin.downloader_app.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader_app.a.a.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;

final class c$5
  implements DialogInterface.OnClickListener
{
  c$5(a parama, a.b paramb, long paramLong) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136089);
    paramDialogInterface = this.kYh;
    this.kYh.field_downloadInWifi = false;
    paramDialogInterface.field_reserveInWifi = false;
    com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
    if (this.kYh.field_status == 0) {
      d.JX(this.kYh.field_appId);
    }
    if (this.laH != null) {
      this.laH.a(a.a.lab, this.kXZ);
    }
    AppMethodBeat.o(136089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.5
 * JD-Core Version:    0.7.0.1
 */