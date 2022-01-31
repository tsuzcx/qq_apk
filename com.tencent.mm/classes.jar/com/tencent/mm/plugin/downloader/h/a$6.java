package com.tencent.mm.plugin.downloader.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

final class a$6
  implements Runnable
{
  a$6(a parama, com.tencent.mm.plugin.downloader.g.a parama1, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2498);
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.kZJ.getClient().getDownloadTaskState(this.kYh.field_downloadUrl);
      if (localTMAssistantDownloadTaskInfo.mState != 1)
      {
        int i = localTMAssistantDownloadTaskInfo.mState;
        if (i != 2)
        {
          AppMethodBeat.o(2498);
          return;
        }
      }
      this.kZJ.getClient().pauseDownloadTask(this.kYh.field_downloadUrl);
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d ", new Object[] { Long.valueOf(this.kYi) });
      AppMethodBeat.o(2498);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %s", new Object[] { localException.toString() });
      ab.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", localException, "", new Object[0]);
      AppMethodBeat.o(2498);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.a.6
 * JD-Core Version:    0.7.0.1
 */