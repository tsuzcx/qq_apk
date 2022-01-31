package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;

public class FileDownloadPendingReceive
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(2439);
    ab.i("MicroMsg.FileDownloadPendingReceive", "onReceive()");
    paramIntent.setComponent(new ComponentName(paramIntent.getComponent().getPackageName(), FileDownloadService.class.getName()));
    d.aG(paramIntent);
    AppMethodBeat.o(2439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadPendingReceive
 * JD-Core Version:    0.7.0.1
 */