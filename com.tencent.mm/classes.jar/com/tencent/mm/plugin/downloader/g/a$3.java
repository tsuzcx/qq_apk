package com.tencent.mm.plugin.downloader.g;

import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

final class a$3
  extends bf<FileDownloadTaskInfo>
{
  a$3(a parama, FileDownloadTaskInfo paramFileDownloadTaskInfo1, FileDownloadTaskInfo paramFileDownloadTaskInfo2, com.tencent.mm.plugin.downloader.f.a parama1)
  {
    super(500L, paramFileDownloadTaskInfo1, (byte)0);
  }
  
  private FileDownloadTaskInfo aGa()
  {
    try
    {
      localTMAssistantDownloadTaskInfo = a.a(this.iRl).getDownloadTaskState(this.iRm.url);
      if (localTMAssistantDownloadTaskInfo == null)
      {
        if (this.iRm.status == 1) {
          this.iRm.status = 0;
        }
        return this.iRm;
      }
      switch (localTMAssistantDownloadTaskInfo.mState)
      {
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
        y.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadTaskState faile: " + localException.toString());
        continue;
        this.iRm.status = 2;
        continue;
        if (this.iRm.status == 6) {
          this.iRm.status = 6;
        } else {
          this.iRm.status = 3;
        }
      }
    }
    if (this.iRm.status == 1) {}
    for (this.iRm.status = 0;; this.iRm.status = 1)
    {
      if (((this.iRm.status == 6) || (this.iRm.status == 3)) && (!e.bK(this.iRm.path))) {
        this.iRm.status = 0;
      }
      this.iRm.path = localTMAssistantDownloadTaskInfo.mSavePath;
      this.iRm.iPM = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
      this.iRm.hFz = localTMAssistantDownloadTaskInfo.mTotalDataLen;
      y.i("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadTask: appId: %s, status: %d, url: %s, path: %s", new Object[] { this.iOZ.field_appId, Integer.valueOf(this.iRm.status), this.iRm.url, this.iRm.path });
      return this.iRm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.a.3
 * JD-Core Version:    0.7.0.1
 */