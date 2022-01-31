package com.tencent.mm.plugin.downloader_app.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.c.a;

final class c$3
  implements DialogInterface.OnClickListener
{
  c$3(i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136087);
    if (this.laI != null) {
      a.a(10, a.uc(this.laI.type), this.laI.position, 4, this.laI.appId, "", "");
    }
    paramDialogInterface.dismiss();
    AppMethodBeat.o(136087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.3
 * JD-Core Version:    0.7.0.1
 */