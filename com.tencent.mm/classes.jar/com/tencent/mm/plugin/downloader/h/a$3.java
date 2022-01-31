package com.tencent.mm.plugin.downloader.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

final class a$3
  extends bj<TMAssistantDownloadTaskInfo>
{
  a$3(a parama, String paramString)
  {
    super(500L, null, (byte)0);
  }
  
  private TMAssistantDownloadTaskInfo bjC()
  {
    AppMethodBeat.i(2492);
    Object localObject = null;
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.kZJ.getClient().getDownloadTaskState(this.val$url);
      localObject = localTMAssistantDownloadTaskInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadStateSync faile: " + localException.toString());
      }
    }
    AppMethodBeat.o(2492);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.a.3
 * JD-Core Version:    0.7.0.1
 */