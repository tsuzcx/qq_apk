package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import com.tencent.mm.plugin.downloader.c.c;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.sdk.platformtools.bk;

final class d$1$1$1
  implements Runnable
{
  d$1$1$1(d.1.1 param1) {}
  
  public final void run()
  {
    PendingIntent localPendingIntent = null;
    if (this.iPt.iPs.iOZ.field_fileType == 1) {
      localPendingIntent = d.G(this.iPt.iPs.iOZ.field_filePath, this.iPt.iPs.iOZ.field_md5, this.iPt.iPs.iOZ.field_appId);
    }
    if ((this.iPt.iPs.iOZ.field_showNotification) && (bk.bl(this.iPt.iPs.iOZ.field_fileName))) {
      d.b(this.iPt.iPs.iOZ.field_appId, this.iPt.iPs.val$context.getString(c.c.file_downloader_download_finished), "", localPendingIntent);
    }
    for (;;)
    {
      if ((this.iPt.iPs.iOZ.field_autoInstall) && (this.iPt.iPs.iOZ.field_fileType == 1)) {
        d.e(this.iPt.iPs.iOZ);
      }
      d.a(this.iPt.iPs.iPr).c(this.iPt.iPs.iPa, this.iPt.iPs.iOZ.field_filePath, this.iPt.iPs.iPf);
      return;
      if ((this.iPt.iPs.iOZ.field_showNotification) && (!bk.bl(this.iPt.iPs.iOZ.field_fileName))) {
        d.b(this.iPt.iPs.iOZ.field_appId, this.iPt.iPs.iOZ.field_fileName, this.iPt.iPs.val$context.getString(c.c.file_downloader_download_finished), localPendingIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.d.1.1.1
 * JD-Core Version:    0.7.0.1
 */