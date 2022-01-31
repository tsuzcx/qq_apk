package com.tencent.mm.plugin.downloader.g;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import java.util.HashSet;

final class a$1
  implements Runnable
{
  a$1(a parama, com.tencent.mm.plugin.downloader.f.a parama1) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        i = a.a(this.iRl).startDownloadTask(this.iOZ.field_downloadUrl, this.iOZ.field_secondaryUrl, this.iOZ.field_fileSize, 0, "resource/tm.android.unknown", ad.bB(this.iOZ.field_downloadUrl), this.iOZ.field_autoDownload, this.iRl.iRi);
        switch (i)
        {
        default: 
          return;
        }
      }
      catch (Exception localException3)
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
        Object localObject;
        com.tencent.mm.plugin.downloader.f.a locala1;
        com.tencent.mm.plugin.downloader.f.a locala2;
        long l;
        int i = -1;
        continue;
      }
      try
      {
        localTMAssistantDownloadTaskInfo = a.a(this.iRl).getDownloadTaskState(this.iOZ.field_downloadUrl);
        y.i("MicroMsg.FileDownloaderImplTMAssistant", "Task Info from TMAssistant: URL: %s, PATH: %s, fileLen: %d, receiveLen: %d", new Object[] { this.iOZ.field_downloadUrl, localTMAssistantDownloadTaskInfo.mSavePath, Long.valueOf(e.aeQ(localTMAssistantDownloadTaskInfo.mSavePath)), Long.valueOf(localTMAssistantDownloadTaskInfo.mReceiveDataLen) });
        this.iOZ.field_status = 1;
        this.iOZ.field_startTime = System.currentTimeMillis();
        this.iOZ.field_startSize = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        this.iOZ.field_filePath = localTMAssistantDownloadTaskInfo.mSavePath;
        this.iOZ.field_downloadedSize = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        this.iOZ.field_totalSize = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        c.d(this.iOZ);
        this.iRl.iRh.add(Long.valueOf(this.iOZ.field_downloadId));
        a.a(this.iRl, this.iOZ.field_downloadUrl, localTMAssistantDownloadTaskInfo.mState, 0, true);
        this.iRl.iPn.l(this.iOZ.field_downloadId, localTMAssistantDownloadTaskInfo.mSavePath);
        y.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask: id: %d, url: %s, path: %s", new Object[] { Long.valueOf(this.iOZ.field_downloadId), this.iOZ.field_downloadUrl, this.iOZ.field_filePath });
        return;
      }
      catch (Exception localException1) {}
    }
    y.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", new Object[] { localException1.getMessage() });
    this.iOZ.field_errCode = com.tencent.mm.plugin.downloader.a.a.iOg;
    this.iOZ.field_status = 4;
    c.d(this.iOZ);
    y.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", new Object[] { Integer.valueOf(i), this.iOZ.field_downloadUrl });
    this.iRl.iPn.c(this.iOZ.field_downloadId, com.tencent.mm.plugin.downloader.a.a.iOg, false);
    return;
    this.iOZ.field_status = 4;
    this.iOZ.field_errCode = com.tencent.mm.plugin.downloader.a.a.iOq;
    c.d(this.iOZ);
    this.iRl.iPn.c(this.iOZ.field_downloadId, com.tencent.mm.plugin.downloader.a.a.iOq, false);
    return;
    this.iOZ.field_status = 4;
    this.iOZ.field_errCode = com.tencent.mm.plugin.downloader.a.a.iOi;
    c.d(this.iOZ);
    this.iRl.iPn.c(this.iOZ.field_downloadId, com.tencent.mm.plugin.downloader.a.a.iOi, false);
    return;
    this.iOZ.field_status = 4;
    this.iOZ.field_errCode = com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID;
    c.d(this.iOZ);
    c.d(this.iOZ);
    this.iRl.iPn.c(this.iOZ.field_downloadId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false);
    return;
    y.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
    localObject = a.a(this.iRl).getDownloadTaskState(this.iOZ.field_downloadUrl);
    locala1 = this.iOZ;
    locala2 = this.iOZ;
    l = System.currentTimeMillis();
    locala2.field_finishTime = l;
    locala1.field_startTime = l;
    this.iOZ.field_status = 6;
    this.iOZ.field_filePath = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
    this.iOZ.field_startSize = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
    this.iOZ.field_downloadedSize = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
    this.iOZ.field_totalSize = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
    c.d(this.iOZ);
    this.iRl.iPn.dj(this.iOZ.field_downloadId);
    localObject = new Intent();
    ((Intent)localObject).putExtra(FileDownloadService.iPI, 1);
    ((Intent)localObject).setClass(this.iRl.mContext, FileDownloadService.class);
    ((Intent)localObject).putExtra(FileDownloadService.EXTRA_ID, this.iOZ.field_downloadId);
    try
    {
      this.iRl.mContext.startService((Intent)localObject);
      this.iRl.iRh.remove(Long.valueOf(this.iOZ.field_downloadId));
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.e("MicroMsg.FileDownloaderImplTMAssistant", localException2.getMessage());
      }
    }
    this.iOZ.field_startTime = System.currentTimeMillis();
    this.iOZ.field_status = 1;
    c.d(this.iOZ);
    this.iRl.iRh.add(Long.valueOf(this.iOZ.field_downloadId));
    a.a(this.iRl, this.iOZ.field_downloadUrl, 2, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.a.1
 * JD-Core Version:    0.7.0.1
 */