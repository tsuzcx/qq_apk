package com.tencent.mm.plugin.downloader.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class FileDownloadNotificationClickReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    y.i("MicroMsg.FileDownloadNotificationClickReceiver", "onReceive");
    Object localObject = bk.bC(paramContext);
    y.i("MicroMsg.FileDownloadNotificationClickReceiver", "topActivityName = " + (String)localObject);
    paramIntent = paramIntent.getExtras();
    localObject = new Intent(paramContext, FileDownloadConfirmUI.class);
    ((Intent)localObject).putExtras(paramIntent);
    ((Intent)localObject).setFlags(268435456);
    paramContext.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.ui.FileDownloadNotificationClickReceiver
 * JD-Core Version:    0.7.0.1
 */