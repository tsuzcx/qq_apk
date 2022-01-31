package com.tencent.mm.plugin.downloader_app.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.c;

final class c$9
  implements DialogInterface.OnClickListener
{
  c$9(a parama, c.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.iOZ.field_status = 4;
    c.d(this.iOZ);
    d.zY(this.iOZ.field_appId);
    if (this.iRX != null) {
      this.iRX.a(c.a.iSa, this.iOZ.field_downloadId);
    }
    if (this.iRX != null) {
      this.iRX.a(c.a.iSa, this.iOZ.field_downloadId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.9
 * JD-Core Version:    0.7.0.1
 */