package com.tencent.mm.plugin.downloader.g;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import java.util.HashSet;

final class a$7
  implements Runnable
{
  a$7(a parama, com.tencent.mm.plugin.downloader.f.a parama1, boolean paramBoolean, long paramLong) {}
  
  public final void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = a.a(this.iRl).getDownloadTaskState(this.iOZ.field_downloadUrl);
      if ((localTMAssistantDownloadTaskInfo != null) && ((localTMAssistantDownloadTaskInfo.mState == 1) || (localTMAssistantDownloadTaskInfo.mState == 2)))
      {
        y.w("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, is running");
        return;
      }
      int i = a.a(this.iRl).startDownloadTask(this.iOZ.field_downloadUrl, this.iOZ.field_secondaryUrl, this.iOZ.field_fileSize, 0, "resource/tm.android.unknown", ad.bB(this.iOZ.field_downloadUrl), this.iOZ.field_autoDownload, this.iRl.iRi);
      localTMAssistantDownloadTaskInfo = a.a(this.iRl).getDownloadTaskState(this.iOZ.field_downloadUrl);
      switch (i)
      {
      case 0: 
        this.iOZ.field_status = 1;
        this.iOZ.field_startTime = System.currentTimeMillis();
        this.iOZ.field_filePath = localTMAssistantDownloadTaskInfo.mSavePath;
        this.iOZ.field_totalSize = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        this.iOZ.field_status = 1;
        c.d(this.iOZ);
        this.iRl.iRh.add(Long.valueOf(this.iOZ.field_downloadId));
        a.a(this.iRl, this.iOZ.field_downloadUrl, 2, 0, true);
        if (this.iPb) {
          this.iRl.iPn.m(this.iOZ.field_downloadId, this.iOZ.field_filePath);
        }
        y.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d", new Object[] { Long.valueOf(this.iPa) });
        return;
      }
    }
    catch (Exception localException1)
    {
      y.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %s", new Object[] { localException1.toString() });
      y.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", localException1, "", new Object[0]);
      this.iOZ.field_status = 4;
      this.iOZ.field_errCode = com.tencent.mm.plugin.downloader.a.a.iOh;
      c.d(this.iOZ);
      this.iRl.iPn.c(this.iOZ.field_downloadId, com.tencent.mm.plugin.downloader.a.a.iOh, false);
      return;
    }
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
    this.iRl.iPn.c(this.iOZ.field_downloadId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false);
    return;
    y.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
    com.tencent.mm.plugin.downloader.f.a locala1 = this.iOZ;
    com.tencent.mm.plugin.downloader.f.a locala2 = this.iOZ;
    long l = System.currentTimeMillis();
    locala2.field_finishTime = l;
    locala1.field_startTime = l;
    this.iOZ.field_status = 6;
    this.iOZ.field_filePath = localException1.mSavePath;
    this.iOZ.field_startSize = localException1.mReceiveDataLen;
    this.iOZ.field_downloadedSize = localException1.mReceiveDataLen;
    this.iOZ.field_totalSize = localException1.mTotalDataLen;
    c.d(this.iOZ);
    this.iRl.iPn.dj(this.iOZ.field_downloadId);
    Intent localIntent = new Intent();
    localIntent.putExtra(FileDownloadService.iPI, 1);
    localIntent.setClass(this.iRl.mContext, FileDownloadService.class);
    localIntent.putExtra(FileDownloadService.EXTRA_ID, this.iOZ.field_downloadId);
    try
    {
      this.iRl.mContext.startService(localIntent);
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
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.g.a.7
 * JD-Core Version:    0.7.0.1
 */