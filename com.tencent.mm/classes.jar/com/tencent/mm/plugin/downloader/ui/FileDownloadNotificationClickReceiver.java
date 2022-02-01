package com.tencent.mm.plugin.downloader.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class FileDownloadNotificationClickReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(89129);
    Log.i("MicroMsg.FileDownloadNotificationClickReceiver", "onReceive");
    Log.i("MicroMsg.FileDownloadNotificationClickReceiver", "topActivityName = ".concat(String.valueOf(Util.getTopActivityName(paramContext))));
    paramIntent = paramIntent.getExtras();
    Intent localIntent = new Intent(paramContext, FileDownloadConfirmUI.class);
    localIntent.putExtras(paramIntent);
    localIntent.setFlags(268435456);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/downloader/ui/FileDownloadNotificationClickReceiver", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/downloader/ui/FileDownloadNotificationClickReceiver", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(89129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.ui.FileDownloadNotificationClickReceiver
 * JD-Core Version:    0.7.0.1
 */