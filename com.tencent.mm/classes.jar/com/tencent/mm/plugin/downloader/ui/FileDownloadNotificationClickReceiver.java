package com.tencent.mm.plugin.downloader.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class FileDownloadNotificationClickReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(2521);
    ab.i("MicroMsg.FileDownloadNotificationClickReceiver", "onReceive");
    ab.i("MicroMsg.FileDownloadNotificationClickReceiver", "topActivityName = ".concat(String.valueOf(bo.ch(paramContext))));
    paramIntent = paramIntent.getExtras();
    Intent localIntent = new Intent(paramContext, FileDownloadConfirmUI.class);
    localIntent.putExtras(paramIntent);
    localIntent.setFlags(268435456);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(2521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.ui.FileDownloadNotificationClickReceiver
 * JD-Core Version:    0.7.0.1
 */