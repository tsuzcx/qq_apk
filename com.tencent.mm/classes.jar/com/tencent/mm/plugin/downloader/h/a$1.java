package com.tencent.mm.plugin.downloader.h;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import java.util.HashSet;

final class a$1
  implements Runnable
{
  a$1(a parama, com.tencent.mm.plugin.downloader.g.a parama1) {}
  
  public final void run()
  {
    AppMethodBeat.i(2490);
    for (;;)
    {
      try
      {
        com.tencent.mm.plugin.downloader.a.c.h(this.kYh.field_appId, new String[] { this.kYh.field_downloadUrl, this.kYh.field_secondaryUrl });
        com.tencent.mm.plugin.s.a.cae();
        m.alw(this.kYh.field_appId);
        i = this.kZJ.getClient().startDownloadTask(this.kYh.field_downloadUrl, this.kYh.field_secondaryUrl, this.kYh.field_fileSize, 0, "resource/tm.android.unknown", ag.cE(this.kYh.field_downloadUrl), this.kYh.field_autoDownload, this.kZJ.kZG);
        switch (i)
        {
        default: 
          AppMethodBeat.o(2490);
          return;
        }
      }
      catch (Exception localException3)
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
        Object localObject;
        com.tencent.mm.plugin.downloader.g.a locala1;
        com.tencent.mm.plugin.downloader.g.a locala2;
        long l;
        int i = -1;
        continue;
      }
      try
      {
        localTMAssistantDownloadTaskInfo = this.kZJ.getClient().getDownloadTaskState(this.kYh.field_downloadUrl);
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "Task Info from TMAssistant: URL: %s, PATH: %s, fileLen: %d, receiveLen: %d", new Object[] { this.kYh.field_downloadUrl, localTMAssistantDownloadTaskInfo.mSavePath, Long.valueOf(e.avI(localTMAssistantDownloadTaskInfo.mSavePath)), Long.valueOf(localTMAssistantDownloadTaskInfo.mReceiveDataLen) });
        this.kYh.field_status = 1;
        this.kYh.field_startTime = System.currentTimeMillis();
        this.kYh.field_startSize = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        this.kYh.field_filePath = localTMAssistantDownloadTaskInfo.mSavePath;
        this.kYh.field_downloadedSize = localTMAssistantDownloadTaskInfo.mReceiveDataLen;
        this.kYh.field_totalSize = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
        this.kZJ.kZF.add(Long.valueOf(this.kYh.field_downloadId));
        a.a(this.kZJ, this.kYh.field_downloadUrl, localTMAssistantDownloadTaskInfo.mState, 0, true);
        this.kZJ.kYw.j(this.kYh.field_downloadId, localTMAssistantDownloadTaskInfo.mSavePath);
        ab.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask: id: %d, url: %s, path: %s", new Object[] { Long.valueOf(this.kYh.field_downloadId), this.kYh.field_downloadUrl, this.kYh.field_filePath });
        AppMethodBeat.o(2490);
        return;
      }
      catch (Exception localException1) {}
      ab.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", new Object[] { localException1.getMessage() });
      this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVm;
      this.kYh.field_status = 4;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      ab.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", new Object[] { Integer.valueOf(i), this.kYh.field_downloadUrl });
      this.kZJ.kYw.d(this.kYh.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kVm, false);
      AppMethodBeat.o(2490);
      return;
      this.kYh.field_status = 4;
      this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVw;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kYw.d(this.kYh.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kVw, false);
      AppMethodBeat.o(2490);
      return;
      this.kYh.field_status = 4;
      this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.kVo;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kYw.d(this.kYh.field_downloadId, com.tencent.mm.plugin.downloader.a.a.kVo, false);
      AppMethodBeat.o(2490);
      return;
      this.kYh.field_status = 4;
      this.kYh.field_errCode = com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kYw.d(this.kYh.field_downloadId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false);
      AppMethodBeat.o(2490);
      return;
      ab.i("MicroMsg.FileDownloaderImplTMAssistant", "file has existed");
      localObject = this.kZJ.getClient().getDownloadTaskState(this.kYh.field_downloadUrl);
      locala1 = this.kYh;
      locala2 = this.kYh;
      l = System.currentTimeMillis();
      locala2.field_finishTime = l;
      locala1.field_startTime = l;
      this.kYh.field_status = 6;
      this.kYh.field_filePath = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
      this.kYh.field_startSize = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
      this.kYh.field_downloadedSize = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
      this.kYh.field_totalSize = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kYw.iI(this.kYh.field_downloadId);
      localObject = new Intent();
      ((Intent)localObject).putExtra(FileDownloadService.kYT, 1);
      ((Intent)localObject).setClass(this.kZJ.mContext, FileDownloadService.class);
      ((Intent)localObject).putExtra(FileDownloadService.EXTRA_ID, this.kYh.field_downloadId);
      try
      {
        com.tencent.mm.bq.d.aG((Intent)localObject);
        this.kZJ.kZF.remove(Long.valueOf(this.kYh.field_downloadId));
        AppMethodBeat.o(2490);
        return;
      }
      catch (Exception localException2)
      {
        ab.e("MicroMsg.FileDownloaderImplTMAssistant", localException2.getMessage());
        continue;
      }
      this.kYh.field_startTime = System.currentTimeMillis();
      this.kYh.field_status = 1;
      com.tencent.mm.plugin.downloader.model.d.e(this.kYh);
      this.kZJ.kZF.add(Long.valueOf(this.kYh.field_downloadId));
      a.a(this.kZJ, this.kYh.field_downloadUrl, 2, 0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.a.1
 * JD-Core Version:    0.7.0.1
 */