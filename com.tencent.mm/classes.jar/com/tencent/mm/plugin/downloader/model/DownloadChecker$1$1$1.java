package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.sdk.platformtools.ah;

final class DownloadChecker$1$1$1
  implements DialogInterface.OnClickListener
{
  DownloadChecker$1$1$1(DownloadChecker.1.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(2340);
    if (((IPCLong)f.a("com.tencent.mm", this.kXM.kXK, DownloadChecker.a.class)).value > 0L) {
      Toast.makeText(ah.getContext(), ah.getContext().getString(2131299883), 0).show();
    }
    paramDialogInterface.dismiss();
    AppMethodBeat.o(2340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.DownloadChecker.1.1.1
 * JD-Core Version:    0.7.0.1
 */