package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.mm.j.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.HashMap;

public final class j
  extends h
{
  private static final String iOS = com.tencent.mm.loader.a.b.bkH + "WebNetFile";
  private HashMap<String, Long> iOU = new HashMap();
  private f.a iPT = new j.4(this);
  private Context mContext = ae.getContext();
  
  public j(b paramb)
  {
    super(paramb);
  }
  
  public final long a(e parame)
  {
    if ((parame == null) || (bk.bl(parame.fDR)))
    {
      y.e("MicroMsg.FileWebNetDownloader", "Invalid Request");
      return -1L;
    }
    y.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", new Object[] { parame.fDR });
    Object localObject3 = parame.fDR;
    Object localObject2 = c.zK((String)localObject3);
    if (localObject2 != null)
    {
      localObject1 = dd(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId);
      y.i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + ((FileDownloadTaskInfo)localObject1).status);
      if (((FileDownloadTaskInfo)localObject1).status == 1) {
        return ((FileDownloadTaskInfo)localObject1).id;
      }
    }
    c.zI((String)localObject3);
    c.zJ(parame.mAppId);
    Object localObject1 = f.c(parame);
    ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_downloadId = System.currentTimeMillis();
    ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_downloaderType = 4;
    localObject3 = ad.bB((String)localObject3);
    ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_filePath = (iOS + "/" + (String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_filePath;
      localObject2 = ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_filePath;
      if ((localObject3 != null) && (localObject2 != null) && (!((String)localObject3).equals(localObject2)))
      {
        y.i("MicroMsg.FileWebNetDownloader", "removeLastFile, new File = %s, oldFile = %s", new Object[] { localObject3, localObject2 });
        localObject2 = new File((String)localObject2);
        if (((File)localObject2).exists()) {
          y.i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((File)localObject2).delete()) });
        }
      }
    }
    ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_startTime = System.currentTimeMillis();
    localObject2 = new File(iOS);
    if (!((File)localObject2).exists())
    {
      if (!((File)localObject2).getParentFile().exists())
      {
        localObject3 = ((File)localObject2).getParentFile();
        File localFile = new File(((File)localObject3).getAbsolutePath() + System.currentTimeMillis());
        if (localFile.mkdirs()) {
          localFile.renameTo((File)localObject3);
        }
      }
      else
      {
        y.i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((File)localObject2).mkdirs()) });
      }
    }
    else
    {
      localObject2 = new com.tencent.mm.j.f();
      ((com.tencent.mm.j.f)localObject2).dlQ = parame.fDR;
      ((com.tencent.mm.j.f)localObject2).field_mediaId = parame.fDR;
      if (parame.iPx == 2)
      {
        ((com.tencent.mm.j.f)localObject2).field_fileType = com.tencent.mm.j.a.dlz;
        ((com.tencent.mm.j.f)localObject2).dlR = 20;
        ((com.tencent.mm.j.f)localObject2).dlS = 90;
      }
      ((com.tencent.mm.j.f)localObject2).field_fullpath = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_filePath;
      ((com.tencent.mm.j.f)localObject2).dlP = this.iPT;
      boolean bool = com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject2, -1);
      y.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: " + bool);
      if (!bool) {
        break label560;
      }
      ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_status = 1;
      c.c((com.tencent.mm.plugin.downloader.f.a)localObject1);
      this.iPn.l(((com.tencent.mm.plugin.downloader.f.a)localObject1).field_downloadId, ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_filePath);
    }
    for (;;)
    {
      return ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_downloadId;
      y.e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", new Object[] { ((File)localObject3).getAbsolutePath() });
      break;
      label560:
      ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_status = 4;
      ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_errCode = com.tencent.mm.plugin.downloader.a.a.iOj;
      c.c((com.tencent.mm.plugin.downloader.f.a)localObject1);
      this.iPn.c(((com.tencent.mm.plugin.downloader.f.a)localObject1).field_downloadId, ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_errCode, false);
    }
  }
  
  public final int dc(long paramLong)
  {
    new Thread(new j.1(this, paramLong)).start();
    return 1;
  }
  
  public final FileDownloadTaskInfo dd(long paramLong)
  {
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if (locala != null)
    {
      CdnLogic.CdnTaskStateInfo localCdnTaskStateInfo = CdnLogic.httpMultiSocketDownloadTaskState(locala.field_downloadUrl);
      if ((locala.field_status != 1) || ((localCdnTaskStateInfo != null) && ((localCdnTaskStateInfo.taskState == 100) || (localCdnTaskStateInfo.taskState == 101)))) {
        break label138;
      }
    }
    label138:
    for (localFileDownloadTaskInfo.status = 0;; localFileDownloadTaskInfo.status = locala.field_status)
    {
      localFileDownloadTaskInfo.iPM = locala.field_downloadedSize;
      localFileDownloadTaskInfo.hFz = locala.field_totalSize;
      localFileDownloadTaskInfo.id = paramLong;
      localFileDownloadTaskInfo.bOz = locala.field_downloaderType;
      localFileDownloadTaskInfo.iPN = locala.field_autoDownload;
      localFileDownloadTaskInfo.path = locala.field_filePath;
      localFileDownloadTaskInfo.url = locala.field_downloadUrl;
      localFileDownloadTaskInfo.bIW = locala.field_md5;
      return localFileDownloadTaskInfo;
    }
  }
  
  public final boolean de(final long paramLong)
  {
    new Thread(new Runnable()
    {
      public final void run()
      {
        y.d("MicroMsg.FileWebNetDownloader", "pauseDownloadTask");
        FileDownloadTaskInfo localFileDownloadTaskInfo = j.this.dd(paramLong);
        if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.status == 1))
        {
          CdnLogic.pauseHttpMultiSocketDownloadTask(localFileDownloadTaskInfo.url);
          c.j(localFileDownloadTaskInfo.id, 2);
          j.this.iPn.dh(paramLong);
        }
      }
    }).start();
    return true;
  }
  
  public final boolean df(final long paramLong)
  {
    final com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if ((locala != null) && (locala.field_status == 2))
    {
      new Thread(new Runnable()
      {
        public final void run()
        {
          int i = CdnLogic.resumeHttpMultiSocketDownloadTask(locala.field_downloadUrl);
          y.i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: " + i);
          locala.field_startTime = System.currentTimeMillis();
          locala.field_startState = com.tencent.mm.plugin.downloader.a.b.iOw;
          locala.field_startSize = locala.field_downloadedSize;
          if (i == 0)
          {
            locala.field_status = 1;
            locala.field_errCode = 0;
            c.d(locala);
            j.this.iPn.m(paramLong, locala.field_filePath);
            if (locala.field_totalSize != 0L)
            {
              long l = locala.field_downloadedSize;
              l = locala.field_totalSize;
            }
            return;
          }
          locala.field_status = 4;
          locala.field_errCode = com.tencent.mm.plugin.downloader.a.a.iOk;
          c.d(locala);
          j.this.iPn.c(paramLong, locala.field_errCode, false);
        }
      }).start();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.j
 * JD-Core Version:    0.7.0.1
 */