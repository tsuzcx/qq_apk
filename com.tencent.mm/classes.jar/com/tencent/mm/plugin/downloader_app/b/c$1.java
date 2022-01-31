package com.tencent.mm.plugin.downloader_app.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.downloader.model.c;

final class c$1
  implements DialogInterface.OnClickListener
{
  c$1(a parama, c.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = c.zH(this.iRW.appId);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.field_status = 4;
      c.d(paramDialogInterface);
    }
    for (;;)
    {
      d.zY(this.iRW.appId);
      if (this.iRX != null) {
        this.iRX.a(c.a.iSa, paramDialogInterface.field_downloadId);
      }
      return;
      paramDialogInterface = new com.tencent.mm.plugin.downloader.f.a();
      paramDialogInterface.field_downloadId = System.currentTimeMillis();
      paramDialogInterface.field_appId = this.iRW.appId;
      paramDialogInterface.field_status = 4;
      c.c(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c.1
 * JD-Core Version:    0.7.0.1
 */