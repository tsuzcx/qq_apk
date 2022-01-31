package com.tencent.mm.plugin.downloader_app.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.a.a.b;

final class c$12
  implements DialogInterface.OnClickListener
{
  c$12(a parama, a.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136094);
    d.JV(this.laG.appId);
    this.laG.kYZ = false;
    c.a(this.laG, this.laH);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(136094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.12
 * JD-Core Version:    0.7.0.1
 */