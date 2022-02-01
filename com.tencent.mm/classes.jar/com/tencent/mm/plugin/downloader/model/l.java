package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import com.tencent.f.i;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public final class l
  extends j
{
  private static final String qIb;
  private Context mContext;
  private HashMap<String, Long> qId;
  private g.a qJm;
  
  static
  {
    AppMethodBeat.i(89045);
    qIb = com.tencent.mm.loader.j.b.aKJ() + "WebNetFile";
    AppMethodBeat.o(89045);
  }
  
  public l(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(89037);
    this.qJm = new g.a()
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
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    this.mContext = MMApplicationContext.getContext();
    this.qId = new HashMap();
    AppMethodBeat.o(89037);
  }
  
  public final int Cn(final long paramLong)
  {
    AppMethodBeat.i(89040);
    com.tencent.f.h.RTc.ba(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89033);
        com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
        if (locala == null)
        {
          AppMethodBeat.o(89033);
          return;
        }
        f.baQ().Oc(locala.field_downloadUrl);
        if (locala.field_status != 5)
        {
          locala.field_status = 5;
          d.e(locala);
          l.this.qIy.Ct(paramLong);
        }
        AppMethodBeat.o(89033);
      }
    });
    AppMethodBeat.o(89040);
    return 1;
  }
  
  public final FileDownloadTaskInfo Co(long paramLong)
  {
    AppMethodBeat.i(89039);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    if (locala != null)
    {
      CdnLogic.CdnTaskStateInfo localCdnTaskStateInfo = CdnLogic.httpMultiSocketDownloadTaskState(locala.field_downloadUrl);
      if ((locala.field_status != 1) || ((localCdnTaskStateInfo != null) && ((localCdnTaskStateInfo.taskState == 100) || (localCdnTaskStateInfo.taskState == 101)))) {
        break label148;
      }
    }
    label148:
    for (localFileDownloadTaskInfo.status = 0;; localFileDownloadTaskInfo.status = locala.field_status)
    {
      localFileDownloadTaskInfo.qJe = locala.field_downloadedSize;
      localFileDownloadTaskInfo.oJj = locala.field_totalSize;
      localFileDownloadTaskInfo.id = paramLong;
      localFileDownloadTaskInfo.dNv = locala.field_downloaderType;
      localFileDownloadTaskInfo.qJf = locala.field_autoDownload;
      localFileDownloadTaskInfo.path = locala.field_filePath;
      localFileDownloadTaskInfo.url = locala.field_downloadUrl;
      localFileDownloadTaskInfo.md5 = locala.field_md5;
      AppMethodBeat.o(89039);
      return localFileDownloadTaskInfo;
    }
  }
  
  public final boolean Cp(final long paramLong)
  {
    AppMethodBeat.i(89041);
    com.tencent.f.h.RTc.ba(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89034);
        Log.d("MicroMsg.FileWebNetDownloader", "pauseDownloadTask");
        Object localObject = l.this.Co(paramLong);
        if ((localObject != null) && (((FileDownloadTaskInfo)localObject).status == 1))
        {
          CdnLogic.pauseHttpMultiSocketDownloadTask(((FileDownloadTaskInfo)localObject).url);
          localObject = d.Cw(paramLong);
          if (localObject != null)
          {
            ((com.tencent.mm.plugin.downloader.g.a)localObject).field_status = 2;
            d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
          }
          l.this.qIy.Cu(paramLong);
        }
        AppMethodBeat.o(89034);
      }
    });
    AppMethodBeat.o(89041);
    return true;
  }
  
  public final boolean Cq(final long paramLong)
  {
    AppMethodBeat.i(89042);
    final com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    if ((locala != null) && (locala.field_status == 2))
    {
      com.tencent.f.h.RTc.ba(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89035);
          int i = CdnLogic.resumeHttpMultiSocketDownloadTask(locala.field_downloadUrl);
          Log.i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: ".concat(String.valueOf(i)));
          locala.field_startTime = System.currentTimeMillis();
          locala.field_startState = com.tencent.mm.plugin.downloader.a.b.qFz;
          locala.field_startSize = locala.field_downloadedSize;
          if (i == 0)
          {
            locala.field_status = 1;
            locala.field_errCode = 0;
            d.e(locala);
            l.this.qIy.n(paramLong, locala.field_filePath);
            AppMethodBeat.o(89035);
            return;
          }
          locala.field_status = 4;
          locala.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFn;
          d.e(locala);
          l.this.qIy.c(paramLong, locala.field_errCode, false);
          AppMethodBeat.o(89035);
        }
      });
      AppMethodBeat.o(89042);
      return true;
    }
    AppMethodBeat.o(89042);
    return false;
  }
  
  public final long a(com.tencent.mm.plugin.downloader.g.a parama)
  {
    return 0L;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(89038);
    if ((paramg == null) || (Util.isNullOrNil(paramg.kMX)))
    {
      Log.e("MicroMsg.FileWebNetDownloader", "Invalid Request");
      AppMethodBeat.o(89038);
      return -1L;
    }
    Log.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", new Object[] { paramg.kMX });
    Object localObject3 = paramg.kMX;
    Object localObject2 = d.ale((String)localObject3);
    long l;
    if (localObject2 != null)
    {
      localObject1 = Co(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_downloadId);
      Log.i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + ((FileDownloadTaskInfo)localObject1).status);
      if (((FileDownloadTaskInfo)localObject1).status == 1)
      {
        l = ((FileDownloadTaskInfo)localObject1).id;
        AppMethodBeat.o(89038);
        return l;
      }
    }
    d.alc((String)localObject3);
    d.ald(paramg.mAppId);
    Object localObject1 = h.c(paramg);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId = System.currentTimeMillis();
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloaderType = 4;
    localObject3 = MD5Util.getMD5String((String)localObject3);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath = (qIb + "/" + (String)localObject3);
    if (localObject2 != null)
    {
      localObject3 = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath;
      localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath;
      if ((localObject3 != null) && (localObject2 != null) && (!((String)localObject3).equals(localObject2)))
      {
        Log.i("MicroMsg.FileWebNetDownloader", "removeLastFile, new File = %s, oldFile = %s", new Object[] { localObject3, localObject2 });
        localObject2 = new o((String)localObject2);
        if (((o)localObject2).exists()) {
          Log.i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((o)localObject2).delete()) });
        }
      }
    }
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_startTime = System.currentTimeMillis();
    localObject2 = new o(qIb);
    if (!((o)localObject2).exists())
    {
      if (!((o)localObject2).heq().exists())
      {
        localObject3 = ((o)localObject2).heq();
        o localo = new o(aa.z(((o)localObject3).her()) + System.currentTimeMillis());
        if (localo.mkdirs()) {
          localo.am((o)localObject3);
        }
      }
      else
      {
        Log.i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", new Object[] { Boolean.valueOf(((o)localObject2).mkdirs()) });
      }
    }
    else
    {
      localObject2 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject2).taskName = "task_FileWebNetDownloader";
      ((com.tencent.mm.i.g)localObject2).gqB = paramg.kMX;
      ((com.tencent.mm.i.g)localObject2).field_mediaId = paramg.kMX;
      if (paramg.qIG == 2)
      {
        ((com.tencent.mm.i.g)localObject2).field_fileType = com.tencent.mm.i.a.gqc;
        ((com.tencent.mm.i.g)localObject2).gqC = 20;
        if (!paramg.qIV) {
          break label625;
        }
        ((com.tencent.mm.i.g)localObject2).gqD = 900;
      }
      label505:
      ((com.tencent.mm.i.g)localObject2).field_fullpath = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath;
      ((com.tencent.mm.i.g)localObject2).gqy = this.qJm;
      boolean bool = f.baQ().b((com.tencent.mm.i.g)localObject2, -1);
      Log.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: ".concat(String.valueOf(bool)));
      if (!bool) {
        break label635;
      }
      ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status = 1;
      d.d((com.tencent.mm.plugin.downloader.g.a)localObject1);
      this.qIy.m(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath);
    }
    for (;;)
    {
      l = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId;
      AppMethodBeat.o(89038);
      return l;
      Log.e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", new Object[] { aa.z(((o)localObject3).her()) });
      break;
      label625:
      ((com.tencent.mm.i.g)localObject2).gqD = 90;
      break label505;
      label635:
      ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status = 4;
      ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_errCode = com.tencent.mm.plugin.downloader.a.a.qFm;
      d.d((com.tencent.mm.plugin.downloader.g.a)localObject1);
      this.qIy.c(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId, ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_errCode, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.l
 * JD-Core Version:    0.7.0.1
 */