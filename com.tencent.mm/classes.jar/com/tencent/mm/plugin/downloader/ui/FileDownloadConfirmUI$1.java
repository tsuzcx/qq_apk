package com.tencent.mm.plugin.downloader.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ab;

final class FileDownloadConfirmUI$1
  implements DialogInterface.OnClickListener
{
  FileDownloadConfirmUI$1(FileDownloadConfirmUI paramFileDownloadConfirmUI, long paramLong) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(2516);
    f.bjl().iz(this.kYi);
    ab.i("MicroMsg.FileDownloadConfirmUI", "Remove task: %d", new Object[] { Long.valueOf(this.kYi) });
    AppMethodBeat.o(2516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI.1
 * JD-Core Version:    0.7.0.1
 */