package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.ad;

public class FileDownloadPendingReceive
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(89005);
    ad.i("MicroMsg.FileDownloadPendingReceive", "onReceive()");
    paramIntent.setComponent(new ComponentName(paramIntent.getComponent().getPackageName(), FileDownloadService.class.getName()));
    d.aY(paramIntent);
    AppMethodBeat.o(89005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadPendingReceive
 * JD-Core Version:    0.7.0.1
 */