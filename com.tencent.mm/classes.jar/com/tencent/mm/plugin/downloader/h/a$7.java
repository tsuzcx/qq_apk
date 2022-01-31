package com.tencent.mm.plugin.downloader.h;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import java.util.HashSet;

final class a$7
  implements Runnable
{
  a$7(a parama, com.tencent.mm.plugin.downloader.g.a parama1, boolean paramBoolean, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2499);
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.downloader.a.c.h(this.kYh.field_appId, new String[] { this.kYh.field_downloadUrl, this.kYh.field_secondaryUrl });
        com.tencent.mm.plugin.s.a.cae();
        m.alw(this.kYh.field_appId);
        localTMAssistantDownloadTaskInfo = this.kZJ.getClient().getDownloadTaskState(this.kYh.field_downloadUrl);
        if ((localTMAssistantDownloadTaskInfo != null) && ((localTMAssistantDownloadTaskInfo.mState == 1) || (localTMAssistantDownloadTaskInfo.mState == 2)))
        {
          ab.w("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, is running");
          AppMethodBeat.o(2499);
          return;
        }
        int i = this.kZJ.getClient().startDownloadTask(this.kYh.field_downloadUrl, this.kYh.field_secondaryUrl, this.kYh.field_fileSize, 0, "resource/tm.android.unknown", ag.cE(this.kYh.field_downloadUrl), this.kYh.field_autoDownload, this.kZJ.kZG);
        localTMAssistantDownloadTaskInfo = this.kZJ.getClient().getDownloadTaskState(this.kYh.field_downloadUrl);
        switch (i)
        {
        default: 
          AppMethodBeat.o(2499);
          return;
        }
      }
      catch (Exception localException1)
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
        ab.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %s", new Object[] { localException1.toString() });
        ab.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", localException1, "", new Object[0]);
        this.kYh.field_status = 4;
        this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVn;
        com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
        this.kZJ.kYw.d(this.kYh.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kVn, false);
        AppMethodBeat.o(2499);
        return;
      }
      this.kYh.field_status = 1;
      this.kYh.field_startTime = System.currentTimeMillis();
      this.kYh.field_filePath = localTMAssistantDownloadTaskInfo.mSavePath;
      this.kYh.field_totalSize = localTMAssistantDownloadTaskInfo.mTotalDataLen;
      this.kYh.field_status = 1;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kZF.add(Long.valueOf(this.kYh.field_downloadId));
      a.a(this.kZJ, this.kYh.field_downloadUrl, 2, 0, true);
      if (this.kYj) {
        this.kZJ.kYw.k(this.kYh.field_downloadId, this.kYh.field_filePath);
      }
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d", new Object[] { Long.valueOf(this.kYi) });
      AppMethodBeat.o(2499);
      return;
      this.kYh.field_status = 4;
      this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVw;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kYw.d(this.kYh.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kVw, false);
      AppMethodBeat.o(2499);
      return;
      this.kYh.field_status = 4;
      this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVo;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kYw.d(this.kYh.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kVo, false);
      AppMethodBeat.o(2499);
      return;
      this.kYh.field_status = 4;
      this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kYw.d(this.kYh.field_downloadId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false);
      AppMethodBeat.o(2499);
      return;
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
      com.tencent.mm.plugin.downloader.g.a locala1 = this.kYh;
      com.tencent.mm.plugin.downloader.g.a locala2 = this.kYh;
      long l = System.currentTimeMillis();
      locala2.field_finishTime = l;
      locala1.field_startTime = l;
      this.kYh.field_status = 6;
      this.kYh.field_filePath = localException1.mSavePath;
      this.kYh.field_startSize = localException1.mReceiveDataLen;
      this.kYh.field_downloadedSize = localException1.mReceiveDataLen;
      this.kYh.field_totalSize = localException1.mTotalDataLen;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kYw.iI(this.kYh.field_downloadId);
      Intent localIntent = new Intent();
      localIntent.putExtra(FileDownloadService.kYT, 1);
      localIntent.setClass(this.kZJ.mContext, FileDownloadService.class);
      localIntent.putExtra(FileDownloadService.EXTRA_ID, this.kYh.field_downloadId);
      try
      {
        com.tencent.mm.bq.d.aG(localIntent);
        this.kZJ.kZF.remove(Long.valueOf(this.kYh.field_downloadId));
        AppMethodBeat.o(2499);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.e("MicroMsg.FileDownloaderImplTMAssistant", localException2.getMessage());
        }
      }
      this.kYh.field_startTime = System.currentTimeMillis();
      this.kYh.field_status = 1;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kZF.add(Long.valueOf(this.kYh.field_downloadId));
      a.a(this.kZJ, this.kYh.field_downloadUrl, 2, 0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.a.7
 * JD-Core Version:    0.7.0.1
 */