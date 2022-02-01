package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;

public class FileDownloadPendingReceive
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(89005);
    Log.i("MicroMsg.FileDownloadPendingReceive", "onReceive()");
    paramIntent.setComponent(new ComponentName(paramIntent.getComponent().getPackageName(), FileDownloadService.class.getName()));
    c.startService(paramIntent);
    AppMethodBeat.o(89005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadPendingReceive
 * JD-Core Version:    0.7.0.1
 */