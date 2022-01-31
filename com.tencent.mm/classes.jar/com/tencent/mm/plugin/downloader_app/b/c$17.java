package com.tencent.mm.plugin.downloader_app.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.a.a.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;

final class c$17
  implements DialogInterface.OnClickListener
{
  c$17(a parama, a.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136098);
    if ((!this.kYh.field_reserveInWifi) || (!this.kYh.field_downloadInWifi))
    {
      paramDialogInterface = this.kYh;
      this.kYh.field_downloadInWifi = true;
      paramDialogInterface.field_reserveInWifi = true;
      d.e(this.kYh);
    }
    this.laH.a(a.a.laa, this.kYh.field_downloadId);
    AppMethodBeat.o(136098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.17
 * JD-Core Version:    0.7.0.1
 */