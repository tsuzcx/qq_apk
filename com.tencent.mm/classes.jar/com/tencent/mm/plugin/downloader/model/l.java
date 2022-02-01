package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.i;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public final class l
  extends j
{
  private static final String xnh;
  private Context mContext;
  private HashMap<String, Long> xnj;
  private g.a xou;
  
  static
  {
    AppMethodBeat.i(89045);
    xnh = com.tencent.mm.loader.i.b.bmz() + "WebNetFile";
    AppMethodBeat.o(89045);
  }
  
  public l(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(89037);
    this.xou = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
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
          Log.d("MicroMsg.FileWebNetDownloader", "on webnet callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label102;
          }
          Log.i("MicroMsg.FileWebNetDownloader", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(89036);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label102:
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.FileWebNetDownloader", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
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
          Log.e("MicroMsg.FileWebNetDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          l.a(l.this, paramAnonymousString, 4, paramAnonymousd.field_retCode);
        }
        for (;;)
        {
          AppMethodBeat.o(89036);
          return 0;
          label237:
          Log.i("MicroMsg.FileWebNetDownloader", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          l.a(l.this, paramAnonymousString, 3, 0);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.mContext = MMApplicationContext.getContext();
    this.xnj = new HashMap();
    AppMethodBeat.o(89037);
  }
  
  public final long a(com.tencent.mm.plugin.downloader.f.a parama)
  {
    return 0L;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(89038);
    if ((paramg == null) || (Util.isNullOrNil(paramg.qGJ)))
    {
      Log.e("MicroMsg.FileWebNetDownloader", "Invalid Request");
      AppMethodBeat.o(89038);
      return -1L;
    }
    Log.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", new Object[] { paramg.qGJ });
    Object localObject3 = paramg.qGJ;
    Object localObject2 = d.amM((String)localObject3);
    long l;
    if (localObject2 != null)
    {
      localObject1 = kS(((com.tencent.mm.plugin.downloader.f.a)localObject2).field_downloadId);
      Log.i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + ((FileDownloadTaskInfo)localObject1).status);
      if (((FileDownloadTaskInfo)localObject1).status == 1)
      {
        l = ((FileDownloadTaskInfo)localObject1).id;
        AppMethodBeat.o(89038);
        return l;
      }
    }
    d.amK((String)localObject3);
    d.amL(paramg.mAppId);
    Object localObject1 = h.c(paramg);
    ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_downloadId = System.currentTimeMillis();
    ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_downloaderType = 4;
    localObject3 = MD5Util.getMD5String((String)localObject3);
    ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_filePath = (xnh + "/" + (String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_filePath;
      localObject2 = ((com.tencent.mm.plugin.downloader.f.a)localObject2).field_filePath;
      if ((localObject3 != null) && (localObject2 != null) && (!((String)localObject3).equals(localObject2)))
      {
        Log.i("MicroMsg.FileWebNetDownloader", "removeLastFile, new File = %s, oldFile = %s", new Object[] { localObject3, localObject2 });
        localObject2 = new u((String)localObject2);
        if (((u)localObject2).jKS()) {
          Log.i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((u)localObject2).diJ()) });
        }
      }
    }
    ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_startTime = System.currentTimeMillis();
    localObject2 = new u(xnh);
    if (!((u)localObject2).jKS())
    {
      if (!((u)localObject2).jKP().jKS())
      {
        localObject3 = ((u)localObject2).jKP();
        u localu = new u(ah.v(((u)localObject3).jKT()) + System.currentTimeMillis());
        if (localu.jKY()) {
          localu.am((u)localObject3);
        }
      }
      else
      {
        Log.i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((u)localObject2).jKY()) });
      }
    }
    else
    {
      localObject2 = new com.tencent.mm.g.g();
      ((com.tencent.mm.g.g)localObject2).taskName = "task_FileWebNetDownloader";
      ((com.tencent.mm.g.g)localObject2).lwO = paramg.qGJ;
      ((com.tencent.mm.g.g)localObject2).field_mediaId = paramg.qGJ;
      if (paramg.xnM == 2)
      {
        ((com.tencent.mm.g.g)localObject2).field_fileType = com.tencent.mm.g.a.lwp;
        ((com.tencent.mm.g.g)localObject2).lwP = 20;
        if (!paramg.xob) {
          break label618;
        }
        ((com.tencent.mm.g.g)localObject2).lwQ = 900;
      }
      label499:
      ((com.tencent.mm.g.g)localObject2).field_fullpath = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_filePath;
      ((com.tencent.mm.g.g)localObject2).lwL = this.xou;
      boolean bool = k.bHW().b((com.tencent.mm.g.g)localObject2, -1);
      Log.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: ".concat(String.valueOf(bool)));
      if (!bool) {
        break label628;
      }
      ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_status = 1;
      d.d((com.tencent.mm.plugin.downloader.f.a)localObject1);
      this.xnE.x(((com.tencent.mm.plugin.downloader.f.a)localObject1).field_downloadId, ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_filePath);
    }
    for (;;)
    {
      l = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_downloadId;
      AppMethodBeat.o(89038);
      return l;
      Log.e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", new Object[] { ah.v(((u)localObject3).jKT()) });
      break;
      label618:
      ((com.tencent.mm.g.g)localObject2).lwQ = 90;
      break label499;
      label628:
      ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_status = 4;
      ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_errCode = com.tencent.mm.plugin.downloader.a.a.xkq;
      d.d((com.tencent.mm.plugin.downloader.f.a)localObject1);
      this.xnE.d(((com.tencent.mm.plugin.downloader.f.a)localObject1).field_downloadId, ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_errCode, false);
    }
  }
  
  public final int kR(final long paramLong)
  {
    AppMethodBeat.i(89040);
    com.tencent.threadpool.h.ahAA.bp(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89033);
        com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
        if (locala == null)
        {
          AppMethodBeat.o(89033);
          return;
        }
        k.bHW().Nz(locala.field_downloadUrl);
        if (locala.field_status != 5)
        {
          locala.field_status = 5;
          d.e(locala);
          l.this.xnE.kX(paramLong);
        }
        AppMethodBeat.o(89033);
      }
    });
    AppMethodBeat.o(89040);
    return 1;
  }
  
  public final FileDownloadTaskInfo kS(long paramLong)
  {
    AppMethodBeat.i(89039);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
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
      localFileDownloadTaskInfo.xom = locala.field_downloadedSize;
      localFileDownloadTaskInfo.uWn = locala.field_totalSize;
      localFileDownloadTaskInfo.id = paramLong;
      localFileDownloadTaskInfo.hMd = locala.field_downloaderType;
      localFileDownloadTaskInfo.xon = locala.field_autoDownload;
      localFileDownloadTaskInfo.path = locala.field_filePath;
      localFileDownloadTaskInfo.url = locala.field_downloadUrl;
      localFileDownloadTaskInfo.md5 = locala.field_md5;
      AppMethodBeat.o(89039);
      return localFileDownloadTaskInfo;
    }
  }
  
  public final boolean kT(final long paramLong)
  {
    AppMethodBeat.i(89041);
    com.tencent.threadpool.h.ahAA.bp(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89034);
        Log.d("MicroMsg.FileWebNetDownloader", "pauseDownloadTask");
        Object localObject = l.this.kS(paramLong);
        if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 1))
        {
          CdnLogic.pauseHttpMultiSocketDownloadTask(((FileDownloadTaskInfo)localObject).url);
          localObject = d.la(paramLong);
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.downloader.f.a)localObject).field_status = 2;
            d.e((com.tencent.mm.plugin.downloader.f.a)localObject);
          }
          l.this.xnE.kY(paramLong);
        }
        AppMethodBeat.o(89034);
      }
    });
    AppMethodBeat.o(89041);
    return true;
  }
  
  public final boolean kU(final long paramLong)
  {
    AppMethodBeat.i(89042);
    final com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if ((locala != null) && (locala.field_status == 2))
    {
      com.tencent.threadpool.h.ahAA.bp(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89035);
          int i = CdnLogic.resumeHttpMultiSocketDownloadTask(locala.field_downloadUrl);
          Log.i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: ".concat(String.valueOf(i)));
          locala.field_startTime = System.currentTimeMillis();
          locala.field_startState = com.tencent.mm.plugin.downloader.a.b.xkD;
          locala.field_startSize = locala.field_downloadedSize;
          if (i == 0)
          {
            locala.field_status = 1;
            locala.field_errCode = 0;
            d.e(locala);
            l.this.xnE.y(paramLong, locala.field_filePath);
            AppMethodBeat.o(89035);
            return;
          }
          locala.field_status = 4;
          locala.field_errCode = com.tencent.mm.plugin.downloader.a.a.xkr;
          d.e(locala);
          l.this.xnE.d(paramLong, locala.field_errCode, false);
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