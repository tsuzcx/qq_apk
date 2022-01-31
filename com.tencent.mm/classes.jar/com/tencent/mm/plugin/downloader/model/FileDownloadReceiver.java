package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@JgClassChecked(author=20, fComment="checked", lastDate="20150202", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class FileDownloadReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(2440);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(2440);
      return;
    }
    paramContext = paramIntent.getAction();
    ab.i("MicroMsg.FileDownloadReceiver", paramContext);
    if (bo.isNullOrNil(paramContext))
    {
      ab.e("MicroMsg.FileDownloadReceiver", "action is null or nill, ignore");
      AppMethodBeat.o(2440);
      return;
    }
    paramContext.equals("android.intent.action.DOWNLOAD_COMPLETE");
    AppMethodBeat.o(2440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadReceiver
 * JD-Core Version:    0.7.0.1
 */