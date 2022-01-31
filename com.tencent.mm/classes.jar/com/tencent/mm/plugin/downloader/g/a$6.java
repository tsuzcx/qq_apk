package com.tencent.mm.plugin.downloader.g;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

final class a$6
  implements Runnable
{
  a$6(a parama, com.tencent.mm.plugin.downloader.f.a parama1, long paramLong) {}
  
  public final void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = a.a(this.iRl).getDownloadTaskState(this.iOZ.field_downloadUrl);
      if ((localTMAssistantDownloadTaskInfo.mState != 1) && (localTMAssistantDownloadTaskInfo.mState != 2)) {
        return;
      }
      a.a(this.iRl).pauseDownloadTask(this.iOZ.field_downloadUrl);
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d ", new Object[] { Long.valueOf(this.iPa) });
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %s", new Object[] { localException.toString() });
      y.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.a.6
 * JD-Core Version:    0.7.0.1
 */