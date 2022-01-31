package com.tencent.mm.plugin.downloader_app.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.a.a.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;

final class c$1
  implements DialogInterface.OnClickListener
{
  c$1(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136085);
    paramDialogInterface = com.tencent.mm.plugin.downloader.model.d.JD(this.laG.appId);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.field_status = 4;
      com.tencent.mm.plugin.downloader.model.d.e(paramDialogInterface);
    }
    for (;;)
    {
      d.iV(paramDialogInterface.field_downloadId);
      if (this.laH != null) {
        this.laH.a(a.a.kZZ, paramDialogInterface.field_downloadId);
      }
      AppMethodBeat.o(136085);
      return;
      paramDialogInterface = new com.tencent.mm.plugin.downloader.g.a();
      paramDialogInterface.field_downloadId = System.currentTimeMillis();
      paramDialogInterface.field_appId = this.laG.appId;
      paramDialogInterface.field_downloadUrl = this.laG.downloadUrl;
      paramDialogInterface.field_status = 4;
      com.tencent.mm.plugin.downloader.model.d.d(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.1
 * JD-Core Version:    0.7.0.1
 */