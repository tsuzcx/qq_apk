package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=20, fComment="checked", lastDate="20150202", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class FileDownloadReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {
      return;
    }
    paramContext = paramIntent.getAction();
    y.i("MicroMsg.FileDownloadReceiver", paramContext);
    if (bk.bl(paramContext))
    {
      y.e("MicroMsg.FileDownloadReceiver", "action is null or nill, ignore");
      return;
    }
    paramContext.equals("android.intent.action.DOWNLOAD_COMPLETE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.FileDownloadReceiver
 * JD-Core Version:    0.7.0.1
 */