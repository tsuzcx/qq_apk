package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;

public final class l
  extends j
{
  private static final String kYa;
  private HashMap<String, Long> kYc;
  private g.a kZf;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(2477);
    kYa = com.tencent.mm.loader.j.b.eQz + "WebNetFile";
    AppMethodBeat.o(2477);
  }
  
  public l(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(2469);
    this.kZf = new l.4(this);
    this.mContext = ah.getContext();
    this.kYc = new HashMap();
    AppMethodBeat.o(2469);
  }
  
  public final long a(com.tencent.mm.plugin.downloader.g.a parama)
  {
    return 0L;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(2470);
    if ((paramg == null) || (bo.isNullOrNil(paramg.gWh)))
    {
      ab.e("MicroMsg.FileWebNetDownloader", "Invalid Request");
      AppMethodBeat.o(2470);
      return -1L;
    }
    ab.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", new Object[] { paramg.gWh });
    Object localObject3 = paramg.gWh;
    Object localObject2 = d.JG((String)localObject3);
    long l;
    if (localObject2 != null)
    {
      localObject1 = iA(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
      ab.i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + ((FileDownloadTaskInfo)localObject1).status);
      if (((FileDownloadTaskInfo)localObject1).status == 1)
      {
        l = ((FileDownloadTaskInfo)localObject1).id;
        AppMethodBeat.o(2470);
        return l;
      }
    }
    d.JE((String)localObject3);
    d.JF(paramg.mAppId);
    Object localObject1 = h.c(paramg);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId = System.currentTimeMillis();
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloaderType = 4;
    localObject3 = ag.cE((String)localObject3);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath = (kYa + "/" + (String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath;
      localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath;
      if ((localObject3 != null) && (localObject2 != null) && (!((String)localObject3).equals(localObject2)))
      {
        ab.i("MicroMsg.FileWebNetDownloader", "removeLastFile, new File = %s, oldFile = %s", new Object[] { localObject3, localObject2 });
        localObject2 = new File((String)localObject2);
        if (((File)localObject2).exists()) {
          ab.i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((File)localObject2).delete()) });
        }
      }
    }
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_startTime = System.currentTimeMillis();
    localObject2 = new File(kYa);
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
        ab.i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((File)localObject2).mkdirs()) });
      }
    }
    else
    {
      localObject2 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject2).eds = paramg.gWh;
      ((com.tencent.mm.i.g)localObject2).field_mediaId = paramg.gWh;
      if (paramg.kYE == 2)
      {
        ((com.tencent.mm.i.g)localObject2).field_fileType = com.tencent.mm.i.a.ecU;
        ((com.tencent.mm.i.g)localObject2).edt = 20;
        ((com.tencent.mm.i.g)localObject2).edu = 90;
      }
      ((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath;
      ((com.tencent.mm.i.g)localObject2).edp = this.kZf;
      boolean bool = f.afO().b((com.tencent.mm.i.g)localObject2, -1);
      ab.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: ".concat(String.valueOf(bool)));
      if (!bool) {
        break label600;
      }
      ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status = 1;
      d.d((com.tencent.mm.plugin.downloader.g.a)localObject1);
      this.kYw.j(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath);
    }
    for (;;)
    {
      l = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId;
      AppMethodBeat.o(2470);
      return l;
      ab.e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", new Object[] { ((File)localObject3).getAbsolutePath() });
      break;
      label600:
      ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status = 4;
      ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_errCode = com.tencent.mm.plugin.downloader.a.a.kVp;
      d.d((com.tencent.mm.plugin.downloader.g.a)localObject1);
      this.kYw.d(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_errCode, false);
    }
  }
  
  public final FileDownloadTaskInfo iA(long paramLong)
  {
    AppMethodBeat.i(2471);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if (locala != null)
    {
      CdnLogic.CdnTaskStateInfo localCdnTaskStateInfo = CdnLogic.httpMultiSocketDownloadTaskState(locala.field_downloadUrl);
      if ((locala.field_status != 1) || ((localCdnTaskStateInfo != null) && ((localCdnTaskStateInfo.taskState == 100) || (localCdnTaskStateInfo.taskState == 101)))) {
        break label150;
      }
    }
    label150:
    for (localFileDownloadTaskInfo.status = 0;; localFileDownloadTaskInfo.status = locala.field_status)
    {
      localFileDownloadTaskInfo.kYX = locala.field_downloadedSize;
      localFileDownloadTaskInfo.jyU = locala.field_totalSize;
      localFileDownloadTaskInfo.id = paramLong;
      localFileDownloadTaskInfo.cvQ = locala.field_downloaderType;
      localFileDownloadTaskInfo.kYY = locala.field_autoDownload;
      localFileDownloadTaskInfo.path = locala.field_filePath;
      localFileDownloadTaskInfo.url = locala.field_downloadUrl;
      localFileDownloadTaskInfo.cqq = locala.field_md5;
      AppMethodBeat.o(2471);
      return localFileDownloadTaskInfo;
    }
  }
  
  public final boolean iB(final long paramLong)
  {
    AppMethodBeat.i(2473);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(2466);
        ab.d("MicroMsg.FileWebNetDownloader", "pauseDownloadTask");
        Object localObject = l.this.iA(paramLong);
        if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 1))
        {
          CdnLogic.pauseHttpMultiSocketDownloadTask(((FileDownloadTaskInfo)localObject).url);
          localObject = d.iJ(paramLong);
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.downloader.g.a)localObject).field_status = 2;
            d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
          }
          l.this.kYw.iG(paramLong);
        }
        AppMethodBeat.o(2466);
      }
    }).start();
    AppMethodBeat.o(2473);
    return true;
  }
  
  public final boolean iC(long paramLong)
  {
    AppMethodBeat.i(2474);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if ((locala != null) && (locala.field_status == 2))
    {
      new Thread(new l.3(this, locala, paramLong)).start();
      AppMethodBeat.o(2474);
      return true;
    }
    AppMethodBeat.o(2474);
    return false;
  }
  
  public final int iz(long paramLong)
  {
    AppMethodBeat.i(2472);
    new Thread(new l.1(this, paramLong)).start();
    AppMethodBeat.o(2472);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.l
 * JD-Core Version:    0.7.0.1
 */