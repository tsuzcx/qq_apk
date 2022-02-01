package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.e.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public final class l
  extends j
{
  private static final String psw;
  private Context mContext;
  private HashMap<String, Long> psy;
  private g.a ptI;
  
  static
  {
    AppMethodBeat.i(89045);
    psw = com.tencent.mm.loader.j.b.asj() + "WebNetFile";
    AppMethodBeat.o(89045);
  }
  
  public l(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(89037);
    this.ptI = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(89036);
        String str1;
        if (paramAnonymousc == null)
        {
          str1 = "null";
          if (paramAnonymousd != null) {
            break label92;
          }
        }
        label92:
        for (String str2 = "null";; str2 = paramAnonymousd.toString())
        {
          ae.d("MicroMsg.FileWebNetDownloader", "on webnet callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label102;
          }
          ae.i("MicroMsg.FileWebNetDownloader", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(89036);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label102:
        if (paramAnonymousInt != 0)
        {
          ae.e("MicroMsg.FileWebNetDownloader", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          l.a(l.this, paramAnonymousString, 4, paramAnonymousInt);
          AppMethodBeat.o(89036);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          l.a(l.this, paramAnonymousString, paramAnonymousc.field_finishedLength, paramAnonymousc.field_toltalLength);
          AppMethodBeat.o(89036);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label237;
          }
          ae.e("MicroMsg.FileWebNetDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          l.a(l.this, paramAnonymousString, 4, paramAnonymousd.field_retCode);
        }
        for (;;)
        {
          AppMethodBeat.o(89036);
          return 0;
          label237:
          ae.i("MicroMsg.FileWebNetDownloader", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          l.a(l.this, paramAnonymousString, 3, 0);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.mContext = ak.getContext();
    this.psy = new HashMap();
    AppMethodBeat.o(89037);
  }
  
  public final long a(com.tencent.mm.plugin.downloader.g.a parama)
  {
    return 0L;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(89038);
    if ((paramg == null) || (bu.isNullOrNil(paramg.jKY)))
    {
      ae.e("MicroMsg.FileWebNetDownloader", "Invalid Request");
      AppMethodBeat.o(89038);
      return -1L;
    }
    ae.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", new Object[] { paramg.jKY });
    Object localObject3 = paramg.jKY;
    Object localObject2 = d.aaX((String)localObject3);
    long l;
    if (localObject2 != null)
    {
      localObject1 = uj(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
      ae.i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + ((FileDownloadTaskInfo)localObject1).status);
      if (((FileDownloadTaskInfo)localObject1).status == 1)
      {
        l = ((FileDownloadTaskInfo)localObject1).id;
        AppMethodBeat.o(89038);
        return l;
      }
    }
    d.aaV((String)localObject3);
    d.aaW(paramg.mAppId);
    Object localObject1 = h.c(paramg);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId = System.currentTimeMillis();
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloaderType = 4;
    localObject3 = aj.ej((String)localObject3);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath = (psw + "/" + (String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath;
      localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath;
      if ((localObject3 != null) && (localObject2 != null) && (!((String)localObject3).equals(localObject2)))
      {
        ae.i("MicroMsg.FileWebNetDownloader", "removeLastFile, new File = %s, oldFile = %s", new Object[] { localObject3, localObject2 });
        localObject2 = new k((String)localObject2);
        if (((k)localObject2).exists()) {
          ae.i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((k)localObject2).delete()) });
        }
      }
    }
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_startTime = System.currentTimeMillis();
    localObject2 = new k(psw);
    if (!((k)localObject2).exists())
    {
      if (!((k)localObject2).fTg().exists())
      {
        localObject3 = ((k)localObject2).fTg();
        k localk = new k(w.B(((k)localObject3).fTh()) + System.currentTimeMillis());
        if (localk.mkdirs()) {
          localk.ag((k)localObject3);
        }
      }
      else
      {
        ae.i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((k)localObject2).mkdirs()) });
      }
    }
    else
    {
      localObject2 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject2).fLl = "task_FileWebNetDownloader";
      ((com.tencent.mm.i.g)localObject2).fLp = paramg.jKY;
      ((com.tencent.mm.i.g)localObject2).field_mediaId = paramg.jKY;
      if (paramg.ptc == 2)
      {
        ((com.tencent.mm.i.g)localObject2).field_fileType = com.tencent.mm.i.a.fKQ;
        ((com.tencent.mm.i.g)localObject2).fLq = 20;
        if (!paramg.ptt) {
          break label618;
        }
        ((com.tencent.mm.i.g)localObject2).fLr = 900;
      }
      label499:
      ((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath;
      ((com.tencent.mm.i.g)localObject2).fLm = this.ptI;
      boolean bool = f.aGZ().b((com.tencent.mm.i.g)localObject2, -1);
      ae.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: ".concat(String.valueOf(bool)));
      if (!bool) {
        break label628;
      }
      ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status = 1;
      d.d((com.tencent.mm.plugin.downloader.g.a)localObject1);
      this.psU.l(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath);
    }
    for (;;)
    {
      l = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId;
      AppMethodBeat.o(89038);
      return l;
      ae.e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", new Object[] { w.B(((k)localObject3).fTh()) });
      break;
      label618:
      ((com.tencent.mm.i.g)localObject2).fLr = 90;
      break label499;
      label628:
      ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status = 4;
      ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_errCode = com.tencent.mm.plugin.downloader.a.a.ppH;
      d.d((com.tencent.mm.plugin.downloader.g.a)localObject1);
      this.psU.c(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_errCode, false);
    }
  }
  
  public final int ui(final long paramLong)
  {
    AppMethodBeat.i(89040);
    com.tencent.e.h.MqF.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89033);
        com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
        if (locala == null)
        {
          AppMethodBeat.o(89033);
          return;
        }
        f.aGZ().Fs(locala.field_downloadUrl);
        if (locala.field_status != 5)
        {
          locala.field_status = 5;
          d.e(locala);
          l.this.psU.uo(paramLong);
        }
        AppMethodBeat.o(89033);
      }
    });
    AppMethodBeat.o(89040);
    return 1;
  }
  
  public final FileDownloadTaskInfo uj(long paramLong)
  {
    AppMethodBeat.i(89039);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
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
      localFileDownloadTaskInfo.ptA = locala.field_downloadedSize;
      localFileDownloadTaskInfo.nyl = locala.field_totalSize;
      localFileDownloadTaskInfo.id = paramLong;
      localFileDownloadTaskInfo.dvO = locala.field_downloaderType;
      localFileDownloadTaskInfo.ptB = locala.field_autoDownload;
      localFileDownloadTaskInfo.path = locala.field_filePath;
      localFileDownloadTaskInfo.url = locala.field_downloadUrl;
      localFileDownloadTaskInfo.md5 = locala.field_md5;
      AppMethodBeat.o(89039);
      return localFileDownloadTaskInfo;
    }
  }
  
  public final boolean uk(final long paramLong)
  {
    AppMethodBeat.i(89041);
    com.tencent.e.h.MqF.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89034);
        ae.d("MicroMsg.FileWebNetDownloader", "pauseDownloadTask");
        Object localObject = l.this.uj(paramLong);
        if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 1))
        {
          CdnLogic.pauseHttpMultiSocketDownloadTask(((FileDownloadTaskInfo)localObject).url);
          localObject = d.ur(paramLong);
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.downloader.g.a)localObject).field_status = 2;
            d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
          }
          l.this.psU.up(paramLong);
        }
        AppMethodBeat.o(89034);
      }
    });
    AppMethodBeat.o(89041);
    return true;
  }
  
  public final boolean ul(final long paramLong)
  {
    AppMethodBeat.i(89042);
    final com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    if ((locala != null) && (locala.field_status == 2))
    {
      com.tencent.e.h.MqF.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89035);
          int i = CdnLogic.resumeHttpMultiSocketDownloadTask(locala.field_downloadUrl);
          ae.i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: ".concat(String.valueOf(i)));
          locala.field_startTime = System.currentTimeMillis();
          locala.field_startState = com.tencent.mm.plugin.downloader.a.b.ppU;
          locala.field_startSize = locala.field_downloadedSize;
          if (i == 0)
          {
            locala.field_status = 1;
            locala.field_errCode = 0;
            d.e(locala);
            l.this.psU.m(paramLong, locala.field_filePath);
            AppMethodBeat.o(89035);
            return;
          }
          locala.field_status = 4;
          locala.field_errCode = com.tencent.mm.plugin.downloader.a.a.ppI;
          d.e(locala);
          l.this.psU.c(paramLong, locala.field_errCode, false);
          AppMethodBeat.o(89035);
        }
      });
      AppMethodBeat.o(89042);
      return true;
    }
    AppMethodBeat.o(89042);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.l
 * JD-Core Version:    0.7.0.1
 */