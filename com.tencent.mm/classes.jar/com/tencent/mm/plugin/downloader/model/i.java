package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

final class i
  extends j
{
  ap bAz;
  DownloadManager kZb;
  CopyOnWriteArraySet<Long> kZc;
  private Context mContext;
  
  public i(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(2455);
    this.bAz = new ap(new i.2(this), false);
    this.mContext = ah.getContext();
    this.kZb = ((DownloadManager)this.mContext.getSystemService("download"));
    this.kZc = new CopyOnWriteArraySet();
    AppMethodBeat.o(2455);
  }
  
  private FileDownloadTaskInfo iT(long paramLong)
  {
    AppMethodBeat.i(2460);
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    Object localObject = new DownloadManager.Query();
    ((DownloadManager.Query)localObject).setFilterById(new long[] { paramLong });
    try
    {
      localObject = this.kZb.query((DownloadManager.Query)localObject);
      if (localObject == null)
      {
        ab.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
        AppMethodBeat.o(2460);
        return localFileDownloadTaskInfo;
      }
    }
    catch (Exception localException1)
    {
      ab.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", new Object[] { localException1.toString(), Long.valueOf(paramLong) });
      AppMethodBeat.o(2460);
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
            if (bo.isNullOrNil(str)) {
              break;
            }
            ab.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", new Object[] { str });
            localFileDownloadTaskInfo.path = Uri.parse(str).getPath();
            ab.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", new Object[] { localFileDownloadTaskInfo.path });
          }
          if (m != -1) {
            localFileDownloadTaskInfo.kYX = localException1.getLong(m);
          }
          if (n != -1) {
            localFileDownloadTaskInfo.jyU = localException1.getLong(n);
          }
          localException1.close();
          ab.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localFileDownloadTaskInfo.status), localFileDownloadTaskInfo.url, localFileDownloadTaskInfo.path });
          AppMethodBeat.o(2460);
          return localFileDownloadTaskInfo;
          localFileDownloadTaskInfo.status = 1;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        ab.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", new Object[] { localException2.toString() });
        localFileDownloadTaskInfo.status = 4;
        continue;
        localFileDownloadTaskInfo.status = 4;
        continue;
        localFileDownloadTaskInfo.status = 2;
        continue;
        localFileDownloadTaskInfo.status = 3;
        continue;
        ab.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
      }
    }
  }
  
  public final long a(a parama)
  {
    return parama.field_downloadId;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(2456);
    if ((paramg == null) || (bo.isNullOrNil(paramg.gWh)))
    {
      ab.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
      AppMethodBeat.o(2456);
      return -1L;
    }
    if (paramg.kYH)
    {
      ab.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", new Object[] { paramg.mAppId });
      AppMethodBeat.o(2456);
      return -1L;
    }
    String str = paramg.gWh;
    Object localObject1 = "";
    Object localObject2 = d.JG(str);
    if (localObject2 != null)
    {
      localObject1 = iT(((a)localObject2).field_sysDownloadId);
      if (((FileDownloadTaskInfo)localObject1).status == 1)
      {
        l = ((FileDownloadTaskInfo)localObject1).id;
        AppMethodBeat.o(2456);
        return l;
      }
      localObject1 = ((a)localObject2).field_filePath;
      this.kZb.remove(new long[] { ((a)localObject2).field_sysDownloadId });
    }
    localObject2 = com.tencent.mm.compatible.util.h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    if (!bo.isNullOrNil((String)localObject2))
    {
      localObject2 = new b((String)localObject2);
      if (!((b)localObject2).exists()) {
        ab.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", new Object[] { Boolean.valueOf(((b)localObject2).mkdirs()) });
      }
    }
    if (!bo.isNullOrNil((String)localObject1))
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists()) {
        ab.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((File)localObject1).delete()) });
      }
    }
    d.JE(str);
    d.JF(paramg.mAppId);
    localObject1 = h.c(paramg);
    ((a)localObject1).field_downloadId = System.currentTimeMillis();
    ((a)localObject1).field_status = 0;
    ((a)localObject1).field_downloaderType = 1;
    str = ag.cE(str);
    ((a)localObject1).field_filePath = (com.tencent.mm.compatible.util.h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str);
    ((a)localObject1).field_startTime = System.currentTimeMillis();
    d.d((a)localObject1);
    com.tencent.mm.kernel.g.RO().ac(new i.1(this, paramg, (a)localObject1));
    long l = ((a)localObject1).field_downloadId;
    AppMethodBeat.o(2456);
    return l;
  }
  
  final long h(a parama)
  {
    AppMethodBeat.i(2459);
    try
    {
      DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse(parama.field_downloadUrl));
      localRequest.setAllowedNetworkTypes(3);
      localRequest.setShowRunningNotification(parama.field_showNotification);
      localRequest.setVisibleInDownloadsUi(parama.field_showNotification);
      if (!bo.isNullOrNil(parama.field_fileName)) {
        localRequest.setTitle(parama.field_fileName);
      }
      localRequest.setDestinationUri(e.avH(parama.field_filePath));
      long l = this.kZb.enqueue(localRequest);
      if (l > 0L)
      {
        AppMethodBeat.o(2459);
        return l;
      }
      ab.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
      AppMethodBeat.o(2459);
      return -1L;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", new Object[] { localException.toString(), parama.field_downloadUrl });
      AppMethodBeat.o(2459);
    }
    return -1L;
  }
  
  public final FileDownloadTaskInfo iA(long paramLong)
  {
    AppMethodBeat.i(2458);
    f.bjl();
    if (f.iO(paramLong))
    {
      f.bjl();
      localObject = iT(f.iP(paramLong));
      ((FileDownloadTaskInfo)localObject).id = paramLong;
      ((FileDownloadTaskInfo)localObject).cvQ = 1;
      AppMethodBeat.o(2458);
      return localObject;
    }
    Object localObject = d.iJ(paramLong);
    if (localObject == null)
    {
      localObject = new FileDownloadTaskInfo();
      AppMethodBeat.o(2458);
      return localObject;
    }
    if ((((a)localObject).field_status == 4) || (((a)localObject).field_status == 2) || (((a)localObject).field_status == 5) || (((a)localObject).field_status == 3)) {
      this.kZc.remove(Long.valueOf(paramLong));
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = ((a)localObject).field_downloadId;
    localFileDownloadTaskInfo.url = ((a)localObject).field_downloadUrl;
    localFileDownloadTaskInfo.status = ((a)localObject).field_status;
    localFileDownloadTaskInfo.path = ((a)localObject).field_filePath;
    localFileDownloadTaskInfo.cqq = ((a)localObject).field_md5;
    localFileDownloadTaskInfo.kYY = ((a)localObject).field_autoDownload;
    localFileDownloadTaskInfo.cvQ = ((a)localObject).field_downloaderType;
    localFileDownloadTaskInfo.kYX = ((a)localObject).field_downloadedSize;
    localFileDownloadTaskInfo.jyU = ((a)localObject).field_totalSize;
    AppMethodBeat.o(2458);
    return localFileDownloadTaskInfo;
  }
  
  public final boolean iB(long paramLong)
  {
    AppMethodBeat.i(2461);
    FileDownloadTaskInfo localFileDownloadTaskInfo = iA(paramLong);
    if (localFileDownloadTaskInfo == null)
    {
      ab.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(2461);
      return false;
    }
    this.kZc.remove(Long.valueOf(paramLong));
    if (localFileDownloadTaskInfo.status != 1)
    {
      ab.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(2461);
      return true;
    }
    int i = iz(paramLong);
    ab.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
    if (i > 0)
    {
      AppMethodBeat.o(2461);
      return true;
    }
    AppMethodBeat.o(2461);
    return false;
  }
  
  public final boolean iC(long paramLong)
  {
    AppMethodBeat.i(2462);
    a locala = d.iJ(paramLong);
    if (locala == null)
    {
      ab.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(2462);
      return false;
    }
    if (locala.field_downloaderType != 1)
    {
      ab.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", new Object[] { Long.valueOf(paramLong) });
      e.deleteFile(locala.field_filePath);
      ab.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask, delete file: %s", new Object[] { locala.field_filePath });
      d.iK(paramLong);
      AppMethodBeat.o(2462);
      return false;
    }
    if (locala.field_status == 1)
    {
      ab.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(2462);
      return false;
    }
    this.kZb.remove(new long[] { locala.field_sysDownloadId });
    paramLong = h(locala);
    if (paramLong > 0L)
    {
      this.kZc.add(Long.valueOf(locala.field_downloadId));
      if (this.bAz.dtj()) {
        this.bAz.ag(100L, 100L);
      }
      locala.field_sysDownloadId = paramLong;
      locala.field_status = 1;
      d.e(locala);
      AppMethodBeat.o(2462);
      return true;
    }
    ab.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
    AppMethodBeat.o(2462);
    return false;
  }
  
  /* Error */
  public final int iz(long paramLong)
  {
    // Byte code:
    //   0: sipush 2457
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 404	com/tencent/mm/plugin/downloader/model/f:bjl	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   9: pop
    //   10: lload_1
    //   11: invokestatic 408	com/tencent/mm/plugin/downloader/model/f:iO	(J)Z
    //   14: ifeq +35 -> 49
    //   17: invokestatic 404	com/tencent/mm/plugin/downloader/model/f:bjl	()Lcom/tencent/mm/plugin/downloader/model/f;
    //   20: pop
    //   21: lload_1
    //   22: invokestatic 412	com/tencent/mm/plugin/downloader/model/f:iP	(J)J
    //   25: lstore_1
    //   26: aload_0
    //   27: getfield 55	com/tencent/mm/plugin/downloader/model/i:kZb	Landroid/app/DownloadManager;
    //   30: iconst_1
    //   31: newarray long
    //   33: dup
    //   34: iconst_0
    //   35: lload_1
    //   36: lastore
    //   37: invokevirtual 244	android/app/DownloadManager:remove	([J)I
    //   40: istore_3
    //   41: sipush 2457
    //   44: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: iload_3
    //   48: ireturn
    //   49: lload_1
    //   50: invokestatic 419	com/tencent/mm/plugin/downloader/model/d:iJ	(J)Lcom/tencent/mm/plugin/downloader/g/a;
    //   53: astore 5
    //   55: aload 5
    //   57: ifnonnull +19 -> 76
    //   60: ldc 86
    //   62: ldc_w 490
    //   65: invokestatic 94	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: sipush 2457
    //   71: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_0
    //   77: getfield 55	com/tencent/mm/plugin/downloader/model/i:kZb	Landroid/app/DownloadManager;
    //   80: iconst_1
    //   81: newarray long
    //   83: dup
    //   84: iconst_0
    //   85: aload 5
    //   87: getfield 232	com/tencent/mm/plugin/downloader/g/a:field_sysDownloadId	J
    //   90: lastore
    //   91: invokevirtual 244	android/app/DownloadManager:remove	([J)I
    //   94: istore_3
    //   95: ldc 86
    //   97: ldc_w 492
    //   100: iconst_1
    //   101: anewarray 98	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: lload_1
    //   107: invokestatic 108	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: aastore
    //   111: invokestatic 153	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload 5
    //   116: getfield 240	com/tencent/mm/plugin/downloader/g/a:field_filePath	Ljava/lang/String;
    //   119: invokestatic 461	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   122: pop
    //   123: ldc 86
    //   125: ldc_w 494
    //   128: iconst_1
    //   129: anewarray 98	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload 5
    //   136: getfield 240	com/tencent/mm/plugin/downloader/g/a:field_filePath	Ljava/lang/String;
    //   139: aastore
    //   140: invokestatic 153	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload 5
    //   145: iconst_5
    //   146: putfield 308	com/tencent/mm/plugin/downloader/g/a:field_status	I
    //   149: aload 5
    //   151: invokestatic 484	com/tencent/mm/plugin/downloader/model/d:e	(Lcom/tencent/mm/plugin/downloader/g/a;)J
    //   154: pop2
    //   155: aload_0
    //   156: getfield 498	com/tencent/mm/plugin/downloader/model/i:kYw	Lcom/tencent/mm/plugin/downloader/model/c;
    //   159: lload_1
    //   160: invokevirtual 504	com/tencent/mm/plugin/downloader/model/c:iF	(J)V
    //   163: aload_0
    //   164: getfield 62	com/tencent/mm/plugin/downloader/model/i:kZc	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   167: lload_1
    //   168: invokestatic 108	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   171: invokevirtual 422	java/util/concurrent/CopyOnWriteArraySet:remove	(Ljava/lang/Object;)Z
    //   174: pop
    //   175: sipush 2457
    //   178: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: iload_3
    //   182: ireturn
    //   183: astore 4
    //   185: iconst_0
    //   186: istore_3
    //   187: ldc 86
    //   189: ldc_w 506
    //   192: iconst_2
    //   193: anewarray 98	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: lload_1
    //   199: invokestatic 108	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload 4
    //   207: invokevirtual 102	java/lang/Exception:toString	()Ljava/lang/String;
    //   210: aastore
    //   211: invokestatic 111	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   53	97	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   76	95	183	java/lang/Exception
    //   95	114	217	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.i
 * JD-Core Version:    0.7.0.1
 */