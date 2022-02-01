package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@JgClassChecked(author=20, fComment="checked", lastDate="20150202", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class FileDownloadReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(89006);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(89006);
      return;
    }
    paramContext = paramIntent.getAction();
    Log.i("MicroMsg.FileDownloadReceiver", paramContext);
    if (Util.isNullOrNil(paramContext))
    {
      Log.e("MicroMsg.FileDownloadReceiver", "action is null or nill, ignore");
      AppMethodBeat.o(89006);
      return;
    }
    paramContext.equals("android.intent.action.DOWNLOAD_COMPLETE");
    AppMethodBeat.o(89006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadReceiver
 * JD-Core Version:    0.7.0.1
 */