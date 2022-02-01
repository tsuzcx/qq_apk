package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

final class i
  extends j
{
  MTimerHandler cts;
  private Context mContext;
  DownloadManager uil;
  CopyOnWriteArraySet<Long> uim;
  
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(89023);
    this.cts = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(89021);
        i locali = i.this;
        com.tencent.mm.kernel.h.aHJ().postToWorker(new i.3(locali));
        locali = i.this;
        if ((locali.uim == null) || (locali.uim.size() == 0)) {}
        for (int i = 1; i == 0; i = 0)
        {
          i.this.cts.startTimer(1000L);
          AppMethodBeat.o(89021);
          return false;
        }
        Log.d("MicroMsg.FileDownloaderImpl23", "timer stop");
        AppMethodBeat.o(89021);
        return false;
      }
    }, false);
    this.mContext = MMApplicationContext.getContext();
    this.uil = ((DownloadManager)this.mContext.getSystemService("download"));
    this.uim = new CopyOnWriteArraySet();
    AppMethodBeat.o(89023);
  }
  
  private FileDownloadTaskInfo IP(long paramLong)
  {
    AppMethodBeat.i(89028);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    Object localObject = new DownloadManager.Query();
    ((DownloadManager.Query)localObject).setFilterById(new long[] { paramLong });
    try
    {
      localObject = this.uil.query((DownloadManager.Query)localObject);
      if (localObject == null)
      {
        Log.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
        AppMethodBeat.o(89028);
        return localFileDownloadTaskInfo;
      }
    }
    catch (Exception localException1)
    {
      Log.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", new Object[] { localException1.toString(), Long.valueOf(paramLong) });
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
            if (Util.isNullOrNil(str)) {
              break;
            }
            Log.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", new Object[] { str });
            localFileDownloadTaskInfo.path = Uri.parse(str).getPath();
            Log.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", new Object[] { localFileDownloadTaskInfo.path });
          }
          if (m != -1) {
            localFileDownloadTaskInfo.uih = localException1.getLong(m);
          }
          if (n != -1) {
            localFileDownloadTaskInfo.rKZ = localException1.getLong(n);
          }
          localException1.close();
          Log.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localFileDownloadTaskInfo.status), localFileDownloadTaskInfo.url, localFileDownloadTaskInfo.path });
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
        Log.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", new Object[] { localException2.toString() });
        localFileDownloadTaskInfo.status = 4;
        continue;
        localFileDownloadTaskInfo.status = 4;
        continue;
        localFileDownloadTaskInfo.status = 2;
        continue;
        localFileDownloadTaskInfo.status = 3;
        continue;
        Log.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
      }
    }
  }
  
  /* Error */
  public final int Iw(long paramLong)
  {
    // Byte code:
    //   0: ldc 204
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 210	com/tencent/mm/plugin/downloader/model/f:cPZ	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   8: pop
    //   9: lload_1
    //   10: invokestatic 214	com/tencent/mm/plugin/downloader/model/f:IK	(J)Z
    //   13: ifeq +34 -> 47
    //   16: invokestatic 210	com/tencent/mm/plugin/downloader/model/f:cPZ	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   19: pop
    //   20: lload_1
    //   21: invokestatic 218	com/tencent/mm/plugin/downloader/model/f:IL	(J)J
    //   24: lstore_1
    //   25: aload_0
    //   26: getfield 60	com/tencent/mm/plugin/downloader/model/i:uil	Landroid/app/DownloadManager;
    //   29: iconst_1
    //   30: newarray long
    //   32: dup
    //   33: iconst_0
    //   34: lload_1
    //   35: lastore
    //   36: invokevirtual 222	android/app/DownloadManager:remove	([J)I
    //   39: istore_3
    //   40: ldc 204
    //   42: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iload_3
    //   46: ireturn
    //   47: lload_1
    //   48: invokestatic 228	com/tencent/mm/plugin/downloader/model/d:IF	(J)Lcom/tencent/mm/plugin/downloader/g/a;
    //   51: astore 5
    //   53: aload 5
    //   55: ifnonnull +17 -> 72
    //   58: ldc 92
    //   60: ldc 230
    //   62: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: ldc 204
    //   67: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 60	com/tencent/mm/plugin/downloader/model/i:uil	Landroid/app/DownloadManager;
    //   76: iconst_1
    //   77: newarray long
    //   79: dup
    //   80: iconst_0
    //   81: aload 5
    //   83: getfield 235	com/tencent/mm/plugin/downloader/g/a:field_sysDownloadId	J
    //   86: lastore
    //   87: invokevirtual 222	android/app/DownloadManager:remove	([J)I
    //   90: istore_3
    //   91: ldc 92
    //   93: ldc 237
    //   95: iconst_1
    //   96: anewarray 104	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: lload_1
    //   102: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   105: aastore
    //   106: invokestatic 159	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload 5
    //   111: getfield 240	com/tencent/mm/plugin/downloader/g/a:field_filePath	Ljava/lang/String;
    //   114: invokestatic 245	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   117: pop
    //   118: ldc 92
    //   120: ldc 247
    //   122: iconst_1
    //   123: anewarray 104	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload 5
    //   130: getfield 240	com/tencent/mm/plugin/downloader/g/a:field_filePath	Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 159	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload 5
    //   139: iconst_5
    //   140: putfield 250	com/tencent/mm/plugin/downloader/g/a:field_status	I
    //   143: aload 5
    //   145: invokestatic 253	com/tencent/mm/plugin/downloader/model/d:e	(Lcom/tencent/mm/plugin/downloader/g/a;)J
    //   148: pop2
    //   149: aload_0
    //   150: getfield 257	com/tencent/mm/plugin/downloader/model/i:uhy	Lcom/tencent/mm/plugin/downloader/model/c;
    //   153: lload_1
    //   154: invokevirtual 263	com/tencent/mm/plugin/downloader/model/c:IC	(J)V
    //   157: aload_0
    //   158: getfield 67	com/tencent/mm/plugin/downloader/model/i:uim	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   161: lload_1
    //   162: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   165: invokevirtual 266	java/util/concurrent/CopyOnWriteArraySet:remove	(Ljava/lang/Object;)Z
    //   168: pop
    //   169: ldc 204
    //   171: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: iload_3
    //   175: ireturn
    //   176: astore 4
    //   178: iconst_0
    //   179: istore_3
    //   180: ldc 92
    //   182: ldc_w 268
    //   185: iconst_2
    //   186: anewarray 104	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: lload_1
    //   192: invokestatic 114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload 4
    //   200: invokevirtual 108	java/lang/Exception:toString	()Ljava/lang/String;
    //   203: aastore
    //   204: invokestatic 117	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: goto -98 -> 109
    //   210: astore 4
    //   212: goto -32 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	i
    //   0	215	1	paramLong	long
    //   39	141	3	i	int
    //   176	23	4	localException1	Exception
    //   210	1	4	localException2	Exception
    //   51	93	5	locala	com.tencent.mm.plugin.downloader.g.a
    // Exception table:
    //   from	to	target	type
    //   72	91	176	java/lang/Exception
    //   91	109	210	java/lang/Exception
  }
  
  public final FileDownloadTaskInfo Ix(long paramLong)
  {
    AppMethodBeat.i(89026);
    f.cPZ();
    if (f.IK(paramLong))
    {
      f.cPZ();
      localObject = IP(f.IL(paramLong));
      ((FileDownloadTaskInfo)localObject).id = paramLong;
      ((FileDownloadTaskInfo)localObject).fGH = 1;
      AppMethodBeat.o(89026);
      return localObject;
    }
    Object localObject = d.IF(paramLong);
    if (localObject == null)
    {
      localObject = new FileDownloadTaskInfo();
      AppMethodBeat.o(89026);
      return localObject;
    }
    if ((((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 4) || (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 2) || (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 5) || (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status == 3)) {
      this.uim.remove(Long.valueOf(paramLong));
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId;
    localFileDownloadTaskInfo.url = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadUrl;
    localFileDownloadTaskInfo.status = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_status;
    localFileDownloadTaskInfo.path = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath;
    localFileDownloadTaskInfo.md5 = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_md5;
    localFileDownloadTaskInfo.uii = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_autoDownload;
    localFileDownloadTaskInfo.fGH = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloaderType;
    localFileDownloadTaskInfo.uih = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadedSize;
    localFileDownloadTaskInfo.rKZ = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_totalSize;
    AppMethodBeat.o(89026);
    return localFileDownloadTaskInfo;
  }
  
  public final boolean Iy(long paramLong)
  {
    AppMethodBeat.i(89029);
    FileDownloadTaskInfo localFileDownloadTaskInfo = Ix(paramLong);
    if (localFileDownloadTaskInfo == null)
    {
      Log.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(89029);
      return false;
    }
    this.uim.remove(Long.valueOf(paramLong));
    if (localFileDownloadTaskInfo.status != 1)
    {
      Log.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(89029);
      return true;
    }
    int i = Iw(paramLong);
    Log.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
    if (i > 0)
    {
      AppMethodBeat.o(89029);
      return true;
    }
    AppMethodBeat.o(89029);
    return false;
  }
  
  public final boolean Iz(long paramLong)
  {
    AppMethodBeat.i(89030);
    com.tencent.mm.plugin.downloader.g.a locala = d.IF(paramLong);
    if (locala == null)
    {
      Log.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(89030);
      return false;
    }
    if (locala.field_downloaderType != 1)
    {
      Log.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", new Object[] { Long.valueOf(paramLong) });
      u.deleteFile(locala.field_filePath);
      Log.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask, delete file: %s", new Object[] { locala.field_filePath });
      d.IG(paramLong);
      AppMethodBeat.o(89030);
      return false;
    }
    if (locala.field_status == 1)
    {
      Log.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(89030);
      return false;
    }
    this.uil.remove(new long[] { locala.field_sysDownloadId });
    paramLong = j(locala);
    if (paramLong > 0L)
    {
      this.uim.add(Long.valueOf(locala.field_downloadId));
      if (this.cts.stopped()) {
        this.cts.startTimer(100L);
      }
      locala.field_sysDownloadId = paramLong;
      locala.field_status = 1;
      d.e(locala);
      AppMethodBeat.o(89030);
      return true;
    }
    Log.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
    AppMethodBeat.o(89030);
    return false;
  }
  
  public final long a(com.tencent.mm.plugin.downloader.g.a parama)
  {
    return parama.field_downloadId;
  }
  
  public final long a(final g paramg)
  {
    AppMethodBeat.i(89024);
    if ((paramg == null) || (Util.isNullOrNil(paramg.nGR)))
    {
      Log.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
      AppMethodBeat.o(89024);
      return -1L;
    }
    if (paramg.uhJ)
    {
      Log.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", new Object[] { paramg.mAppId });
      AppMethodBeat.o(89024);
      return -1L;
    }
    String str = paramg.nGR;
    Object localObject1 = "";
    Object localObject2 = d.asX(str);
    if (localObject2 != null)
    {
      localObject1 = IP(((com.tencent.mm.plugin.downloader.g.a)localObject2).field_sysDownloadId);
      if (((FileDownloadTaskInfo)localObject1).status == 1)
      {
        l = ((FileDownloadTaskInfo)localObject1).id;
        AppMethodBeat.o(89024);
        return l;
      }
      localObject1 = ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_filePath;
      this.uil.remove(new long[] { ((com.tencent.mm.plugin.downloader.g.a)localObject2).field_sysDownloadId });
    }
    localObject2 = com.tencent.mm.compatible.util.g.KU(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    if (!Util.isNullOrNil((String)localObject2))
    {
      localObject2 = new q((String)localObject2);
      if (!((q)localObject2).ifE()) {
        Log.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", new Object[] { Boolean.valueOf(((q)localObject2).ifK()) });
      }
    }
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject1 = new q((String)localObject1);
      if (((q)localObject1).ifE()) {
        Log.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((q)localObject1).cFq()) });
      }
    }
    d.asV(str);
    d.asW(paramg.mAppId);
    localObject1 = h.c(paramg);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloadId = System.currentTimeMillis();
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status = 0;
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_downloaderType = 1;
    str = MD5Util.getMD5String(str);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath = (com.tencent.mm.compatible.util.g.KU(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str);
    ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_startTime = System.currentTimeMillis();
    d.d((com.tencent.mm.plugin.downloader.g.a)localObject1);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89020);
        if (paramg.uhI)
        {
          String str = h.ati(this.uhi.field_downloadUrl);
          this.uhi.field_md5 = str;
        }
        long l = i.this.j(this.uhi);
        if (l > 0L)
        {
          this.uhi.field_sysDownloadId = l;
          this.uhi.field_status = 1;
          d.e(this.uhi);
          i.this.uhy.o(this.uhi.field_downloadId, this.uhi.field_filePath);
          f.cPZ();
          if (f.IK(this.uhi.field_downloadId))
          {
            f.cPZ();
            f.P(this.uhi.field_downloadId, l);
          }
          i.this.uim.add(Long.valueOf(this.uhi.field_downloadId));
          if (i.this.cts.stopped()) {
            i.this.cts.startTimer(100L);
          }
          Log.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", new Object[] { Long.valueOf(this.uhi.field_downloadId), this.uhi.field_downloadUrl, this.uhi.field_filePath });
          AppMethodBeat.o(89020);
          return;
        }
        this.uhi.field_status = 4;
        d.e(this.uhi);
        i.this.uhy.c(this.uhi.field_downloadId, com.tencent.mm.plugin.downloader.a.a.uez, false);
        Log.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
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
      if (!Util.isNullOrNil(parama.field_fileName)) {
        localRequest.setTitle(parama.field_fileName);
      }
      q localq = new q(u.n(parama.field_filePath, true));
      localRequest.setDestinationUri(FileProviderHelper.getUriForFile(this.mContext, localq));
      long l = this.uil.enqueue(localRequest);
      if (l > 0L)
      {
        AppMethodBeat.o(89027);
        return l;
      }
      Log.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
      AppMethodBeat.o(89027);
      return -1L;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", new Object[] { localException.toString(), parama.field_downloadUrl });
      AppMethodBeat.o(89027);
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.i
 * JD-Core Version:    0.7.0.1
 */