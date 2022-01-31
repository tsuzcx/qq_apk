package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class f$2
  implements Runnable
{
  f$2(f paramf, a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(2408);
    PendingIntent localPendingIntent = null;
    if (this.kYh.field_fileType == 1) {
      localPendingIntent = f.a(this.kYh.field_filePath, this.kYh);
    }
    if ((this.kYh.field_showNotification) && (bo.isNullOrNil(this.kYh.field_fileName))) {
      f.b(this.kYh.field_appId, ah.getContext().getString(2131299870), "", localPendingIntent);
    }
    for (;;)
    {
      if ((this.kYh.field_autoInstall) && (this.kYh.field_fileType == 1) && (!this.kYh.field_reserveInWifi)) {
        f.g(this.kYh);
      }
      f.a(this.kYA).c(this.kYh.field_downloadId, this.kYh.field_filePath, this.kYn);
      AppMethodBeat.o(2408);
      return;
      if ((this.kYh.field_showNotification) && (!bo.isNullOrNil(this.kYh.field_fileName))) {
        f.b(this.kYh.field_appId, this.kYh.field_fileName, ah.getContext().getString(2131299870), localPendingIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f.2
 * JD-Core Version:    0.7.0.1
 */