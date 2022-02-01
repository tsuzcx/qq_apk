package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

final class i
  extends j
{
  av cjg;
  private Context mContext;
  DownloadManager pmX;
  CopyOnWriteArraySet<Long> pmY;
  
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(89023);
    this.cjg = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(89021);
        i locali = i.this;
        com.tencent.mm.kernel.g.ajF().ay(new i.3(locali));
        locali = i.this;
        if ((locali.pmY == null) || (locali.pmY.size() == 0)) {}
        for (int i = 1; i == 0; i = 0)
        {
          i.this.cjg.az(1000L, 1000L);
          AppMethodBeat.o(89021);
          return false;
        }
        ad.d("MicroMsg.FileDownloaderImpl23", "timer stop");
        AppMethodBeat.o(89021);
        return false;
      }
    }, false);
    this.mContext = aj.getContext();
    this.pmX = ((DownloadManager)this.mContext.getSystemService("download"));
    this.pmY = new CopyOnWriteArraySet();
    AppMethodBeat.o(89023);
  }
  
  private FileDownloadTaskInfo ul(long paramLong)
  {
    AppMethodBeat.i(89028);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    Object localObject = new DownloadManager.Query();
    ((DownloadManager.Query)localObject).setFilterById(new long[] { paramLong });
    try
    {
      localObject = this.pmX.query((DownloadManager.Query)localObject);
      if (localObject == null)
      {
        ad.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
        AppMethodBeat.o(89028);
        return localFileDownloadTaskInfo;
      }
    }
    catch (Exception localException1)
    {
      ad.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", new Object[] { localException1.toString(), Long.valueOf(paramLong) });
      AppMethodBeat.o(89028);
      return localFileDownloadTaskInfo;
    }
    int i;
    int j;
    int k;
    int m;
    int n;
    if (localException1.moveToFirst())
    {
      i = localException1.getColumnIndex("status");
      j = localException1.getColumnIndex("uri");
      k = localException1.getColumnIndex("local_uri");
      m = localException1.getColumnIndex("bytes_so_far");
      n = localException1.getColumnIndex("total_size");
      if (i == -1) {}
    }
    try
    {
      switch (localException1.getInt(i))
      {
      case 1: 
      case 2: 
        for (;;)
        {
          if (j != -1) {
            localFileDownloadTaskInfo.url = localException1.getString(j);
          }
          if (k != -1)
          {
            String str = localException1.getString(k);
            if (bt.isNullOrNil(str)) {
              break;
            }
            ad.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", new Object[] { str });
            localFileDownloadTaskInfo.path = Uri.parse(str).getPath();
            ad.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", new Object[] { localFileDownloadTaskInfo.path });
          }
          if (m != -1) {
            localFileDownloadTaskInfo.pmT = localException1.getLong(m);
          }
          if (n != -1) {
            localFileDownloadTaskInfo.nsQ = localException1.getLong(n);
          }
          localException1.close();
          ad.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localFileDownloadTaskInfo.status), localFileDownloadTaskInfo.url, localFileDownloadTaskInfo.path });
          AppMethodBeat.o(89028);
          return localFileDownloadTaskInfo;
          localFileDownloadTaskInfo.status = 1;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ad.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", new Object[] { localException2.toString() });
        localFileDownloadTaskInfo.status = 4;
        continue;
        localFileDownloadTaskInfo.status = 4;
        continue;
        localFileDownloadTaskInfo.status = 2;
        continue;
        localFileDownloadTaskInfo.status = 3;
        continue;
        ad.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
      }
    }
  }
  
  public final long a(com.tencent.mm.plugin.downloader.g.a parama)
  {
    return parama.field_downloadId;
  }
  
  public final long a(final g paramg)
  {
    AppMethodBeat.i(89024);
    if ((paramg == null) || (bt.isNullOrNil(paramg.jHX)))
    {
      ad.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
      AppMethodBeat.o(89024);
      return -1L;
    }
    if (paramg.pmA)
    {
      ad.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", new Object[] { paramg.mAppId });
      AppMethodBeat.o(89024);
      return -1L;
    }
    String str = paramg.jHX;
    Object localObject1 = "";
    Object localObject2 = d.aag(str);
    if (localObject2 != null)
    {
      localObject1 = ul(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_sysDownloadId);
      if (((FileDownloadTaskInfo)localObject1).status == 1)
      {
        l = ((FileDownloadTaskInfo)localObject1).id;
        AppMethodBeat.o(89024);
        return l;
      }
      localObject1 = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath;
      this.pmX.remove(new long[] { ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_sysDownloadId });
    }
    localObject2 = com.tencent.mm.compatible.util.g.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    if (!bt.isNullOrNil((String)localObject2))
    {
      localObject2 = new e((String)localObject2);
      if (!((e)localObject2).exists()) {
        ad.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", new Object[] { Boolean.valueOf(((e)localObject2).mkdirs()) });
      }
    }
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject1 = new e((String)localObject1);
      if (((e)localObject1).exists()) {
        ad.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((e)localObject1).delete()) });
      }
    }
    d.aae(str);
    d.aaf(paramg.mAppId);
    localObject1 = h.c(paramg);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId = System.currentTimeMillis();
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status = 0;
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloaderType = 1;
    str = ai.ee(str);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath = (com.tencent.mm.compatible.util.g.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_startTime = System.currentTimeMillis();
    d.d((com.tencent.mm.plugin.downloader.g.a)localObject1);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89020);
        if (paramg.pmz)
        {
          String str = h.aaq(this.plY.field_downloadUrl);
          this.plY.field_md5 = str;
        }
        long l = i.this.j(this.plY);
        if (l > 0L)
        {
          this.plY.field_sysDownloadId = l;
          this.plY.field_status = 1;
          d.e(this.plY);
          i.this.pmp.l(this.plY.field_downloadId, this.plY.field_filePath);
          f.ccl();
          if (f.uf(this.plY.field_downloadId))
          {
            f.ccl();
            f.K(this.plY.field_downloadId, l);
          }
          i.this.pmY.add(Long.valueOf(this.plY.field_downloadId));
          if (i.this.cjg.fkZ()) {
            i.this.cjg.az(100L, 100L);
          }
          ad.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", new Object[] { Long.valueOf(this.plY.field_downloadId), this.plY.field_downloadUrl, this.plY.field_filePath });
          AppMethodBeat.o(89020);
          return;
        }
        this.plY.field_status = 4;
        d.e(this.plY);
        i.this.pmp.c(this.plY.field_downloadId, com.tencent.mm.plugin.downloader.a.a.pjn, false);
        ad.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
        AppMethodBeat.o(89020);
      }
    });
    long l = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId;
    AppMethodBeat.o(89024);
    return l;
  }
  
  final long j(com.tencent.mm.plugin.downloader.g.a parama)
  {
    AppMethodBeat.i(89027);
    try
    {
      DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse(parama.field_downloadUrl));
      localRequest.setAllowedNetworkTypes(3);
      localRequest.setShowRunningNotification(parama.field_showNotification);
      localRequest.setVisibleInDownloadsUi(parama.field_showNotification);
      if (!bt.isNullOrNil(parama.field_fileName)) {
        localRequest.setTitle(parama.field_fileName);
      }
      e locale = new e(com.tencent.mm.vfs.i.k(parama.field_filePath, true));
      localRequest.setDestinationUri(n.a(this.mContext, locale));
      long l = this.pmX.enqueue(localRequest);
      if (l > 0L)
      {
        AppMethodBeat.o(89027);
        return l;
      }
      ad.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
      AppMethodBeat.o(89027);
      return -1L;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", new Object[] { localException.toString(), parama.field_downloadUrl });
      AppMethodBeat.o(89027);
    }
    return -1L;
  }
  
  /* Error */
  public final int tR(long paramLong)
  {
    // Byte code:
    //   0: ldc_w 410
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 416	com/tencent/mm/plugin/downloader/model/f:ccl	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   9: pop
    //   10: lload_1
    //   11: invokestatic 420	com/tencent/mm/plugin/downloader/model/f:uf	(J)Z
    //   14: ifeq +35 -> 49
    //   17: invokestatic 416	com/tencent/mm/plugin/downloader/model/f:ccl	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   20: pop
    //   21: lload_1
    //   22: invokestatic 424	com/tencent/mm/plugin/downloader/model/f:ug	(J)J
    //   25: lstore_1
    //   26: aload_0
    //   27: getfield 60	com/tencent/mm/plugin/downloader/model/i:pmX	Landroid/app/DownloadManager;
    //   30: iconst_1
    //   31: newarray long
    //   33: dup
    //   34: iconst_0
    //   35: lload_1
    //   36: lastore
    //   37: invokevirtual 251	android/app/DownloadManager:remove	([J)I
    //   40: istore_3
    //   41: ldc_w 410
    //   44: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: iload_3
    //   48: ireturn
    //   49: lload_1
    //   50: invokestatic 428	com/tencent/mm/plugin/downloader/model/d:ua	(J)Lcom/tencent/mm/plugin/downloader/g/a;
    //   53: astore 5
    //   55: aload 5
    //   57: ifnonnull +19 -> 76
    //   60: ldc 92
    //   62: ldc_w 430
    //   65: invokestatic 100	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc_w 410
    //   71: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_0
    //   77: getfield 60	com/tencent/mm/plugin/downloader/model/i:pmX	Landroid/app/DownloadManager;
    //   80: iconst_1
    //   81: newarray long
    //   83: dup
    //   84: iconst_0
    //   85: aload 5
    //   87: getfield 239	com/tencent/mm/plugin/downloader/g/a:field_sysDownloadId	J
    //   90: lastore
    //   91: invokevirtual 251	android/app/DownloadManager:remove	([J)I
    //   94: istore_3
    //   95: ldc 92
    //   97: ldc_w 432
    //   100: iconst_1
    //   101: anewarray 104	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: lload_1
    //   107: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: aastore
    //   111: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload 5
    //   116: getfield 247	com/tencent/mm/plugin/downloader/g/a:field_filePath	Ljava/lang/String;
    //   119: invokestatic 435	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   122: pop
    //   123: ldc 92
    //   125: ldc_w 437
    //   128: iconst_1
    //   129: anewarray 104	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload 5
    //   136: getfield 247	com/tencent/mm/plugin/downloader/g/a:field_filePath	Ljava/lang/String;
    //   139: aastore
    //   140: invokestatic 159	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload 5
    //   145: iconst_5
    //   146: putfield 313	com/tencent/mm/plugin/downloader/g/a:field_status	I
    //   149: aload 5
    //   151: invokestatic 439	com/tencent/mm/plugin/downloader/model/d:e	(Lcom/tencent/mm/plugin/downloader/g/a;)J
    //   154: pop2
    //   155: aload_0
    //   156: getfield 443	com/tencent/mm/plugin/downloader/model/i:pmp	Lcom/tencent/mm/plugin/downloader/model/c;
    //   159: lload_1
    //   160: invokevirtual 449	com/tencent/mm/plugin/downloader/model/c:tX	(J)V
    //   163: aload_0
    //   164: getfield 67	com/tencent/mm/plugin/downloader/model/i:pmY	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   167: lload_1
    //   168: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: invokevirtual 452	java/util/concurrent/CopyOnWriteArraySet:remove	(Ljava/lang/Object;)Z
    //   174: pop
    //   175: ldc_w 410
    //   178: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: iload_3
    //   182: ireturn
    //   183: astore 4
    //   185: iconst_0
    //   186: istore_3
    //   187: ldc 92
    //   189: ldc_w 454
    //   192: iconst_2
    //   193: anewarray 104	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: lload_1
    //   199: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload 4
    //   207: invokevirtual 108	java/lang/Exception:toString	()Ljava/lang/String;
    //   210: aastore
    //   211: invokestatic 117	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: goto -100 -> 114
    //   217: astore 4
    //   219: goto -32 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	i
    //   0	222	1	paramLong	long
    //   40	147	3	i	int
    //   183	23	4	localException1	Exception
    //   217	1	4	localException2	Exception
    //   53	97	5	locala	com.tencent.mm.plugin.downloader.g.a
    // Exception table:
    //   from	to	target	type
    //   76	95	183	java/lang/Exception
    //   95	114	217	java/lang/Exception
  }
  
  public final FileDownloadTaskInfo tS(long paramLong)
  {
    AppMethodBeat.i(89026);
    f.ccl();
    if (f.uf(paramLong))
    {
      f.ccl();
      localObject = ul(f.ug(paramLong));
      ((FileDownloadTaskInfo)localObject).id = paramLong;
      ((FileDownloadTaskInfo)localObject).duJ = 1;
      AppMethodBeat.o(89026);
      return localObject;
    }
    Object localObject = d.ua(paramLong);
    if (localObject == null)
    {
      localObject = new FileDownloadTaskInfo();
      AppMethodBeat.o(89026);
      return localObject;
    }
    if ((((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 4) || (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 2) || (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 5) || (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 3)) {
      this.pmY.remove(Long.valueOf(paramLong));
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId;
    localFileDownloadTaskInfo.url = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadUrl;
    localFileDownloadTaskInfo.status = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_status;
    localFileDownloadTaskInfo.path = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath;
    localFileDownloadTaskInfo.md5 = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_md5;
    localFileDownloadTaskInfo.pmU = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_autoDownload;
    localFileDownloadTaskInfo.duJ = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloaderType;
    localFileDownloadTaskInfo.pmT = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadedSize;
    localFileDownloadTaskInfo.nsQ = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_totalSize;
    AppMethodBeat.o(89026);
    return localFileDownloadTaskInfo;
  }
  
  public final boolean tT(long paramLong)
  {
    AppMethodBeat.i(89029);
    FileDownloadTaskInfo localFileDownloadTaskInfo = tS(paramLong);
    if (localFileDownloadTaskInfo == null)
    {
      ad.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(89029);
      return false;
    }
    this.pmY.remove(Long.valueOf(paramLong));
    if (localFileDownloadTaskInfo.status != 1)
    {
      ad.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(89029);
      return true;
    }
    int i = tR(paramLong);
    ad.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
    if (i > 0)
    {
      AppMethodBeat.o(89029);
      return true;
    }
    AppMethodBeat.o(89029);
    return false;
  }
  
  public final boolean tU(long paramLong)
  {
    AppMethodBeat.i(89030);
    com.tencent.mm.plugin.downloader.g.a locala = d.ua(paramLong);
    if (locala == null)
    {
      ad.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(89030);
      return false;
    }
    if (locala.field_downloaderType != 1)
    {
      ad.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", new Object[] { Long.valueOf(paramLong) });
      com.tencent.mm.vfs.i.deleteFile(locala.field_filePath);
      ad.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask, delete file: %s", new Object[] { locala.field_filePath });
      d.ub(paramLong);
      AppMethodBeat.o(89030);
      return false;
    }
    if (locala.field_status == 1)
    {
      ad.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(89030);
      return false;
    }
    this.pmX.remove(new long[] { locala.field_sysDownloadId });
    paramLong = j(locala);
    if (paramLong > 0L)
    {
      this.pmY.add(Long.valueOf(locala.field_downloadId));
      if (this.cjg.fkZ()) {
        this.cjg.az(100L, 100L);
      }
      locala.field_sysDownloadId = paramLong;
      locala.field_status = 1;
      d.e(locala);
      AppMethodBeat.o(89030);
      return true;
    }
    ad.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
    AppMethodBeat.o(89030);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.i
 * JD-Core Version:    0.7.0.1
 */