package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

final class g
  extends h
{
  am fjC = new am(new g.2(this), false);
  DownloadManager iPP = (DownloadManager)this.mContext.getSystemService("download");
  CopyOnWriteArraySet<Long> iPQ = new CopyOnWriteArraySet();
  private Context mContext = ae.getContext();
  
  public g(b paramb)
  {
    super(paramb);
  }
  
  private FileDownloadTaskInfo dq(long paramLong)
  {
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    Object localObject = new DownloadManager.Query();
    ((DownloadManager.Query)localObject).setFilterById(new long[] { paramLong });
    try
    {
      localObject = this.iPP.query((DownloadManager.Query)localObject);
      if (localObject == null)
      {
        y.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
        return localFileDownloadTaskInfo;
      }
    }
    catch (Exception localException1)
    {
      y.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", new Object[] { localException1.toString(), Long.valueOf(paramLong) });
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
            if (bk.bl(str)) {
              break;
            }
            y.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", new Object[] { str });
            localFileDownloadTaskInfo.path = Uri.parse(str).getPath();
            y.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", new Object[] { localFileDownloadTaskInfo.path });
          }
          if (m != -1) {
            localFileDownloadTaskInfo.iPM = localException1.getLong(m);
          }
          if (n != -1) {
            localFileDownloadTaskInfo.hFz = localException1.getLong(n);
          }
          localException1.close();
          y.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localFileDownloadTaskInfo.status), localFileDownloadTaskInfo.url, localFileDownloadTaskInfo.path });
          return localFileDownloadTaskInfo;
          localFileDownloadTaskInfo.status = 1;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        y.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", new Object[] { localException2.toString() });
        localFileDownloadTaskInfo.status = 4;
        continue;
        localFileDownloadTaskInfo.status = 4;
        continue;
        localFileDownloadTaskInfo.status = 2;
        continue;
        localFileDownloadTaskInfo.status = 3;
        continue;
        y.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
      }
    }
  }
  
  public final long a(e parame)
  {
    if ((parame == null) || (bk.bl(parame.fDR)))
    {
      y.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
      return -1L;
    }
    if (parame.iPA)
    {
      y.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", new Object[] { parame.mAppId });
      return -1L;
    }
    String str = parame.fDR;
    Object localObject1 = "";
    Object localObject2 = c.zK(str);
    if (localObject2 != null)
    {
      localObject1 = dq(((a)localObject2).field_sysDownloadId);
      if (((FileDownloadTaskInfo)localObject1).status == 1) {
        return ((FileDownloadTaskInfo)localObject1).id;
      }
      localObject1 = ((a)localObject2).field_filePath;
      this.iPP.remove(new long[] { ((a)localObject2).field_sysDownloadId });
    }
    localObject2 = com.tencent.mm.compatible.util.h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    if (!bk.bl((String)localObject2))
    {
      localObject2 = new com.tencent.mm.vfs.b((String)localObject2);
      if (!((com.tencent.mm.vfs.b)localObject2).exists()) {
        y.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", new Object[] { Boolean.valueOf(((com.tencent.mm.vfs.b)localObject2).mkdirs()) });
      }
    }
    if (!bk.bl((String)localObject1))
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists()) {
        y.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", new Object[] { Boolean.valueOf(((File)localObject1).delete()) });
      }
    }
    c.zI(str);
    c.zJ(parame.mAppId);
    localObject1 = f.c(parame);
    ((a)localObject1).field_downloadId = System.currentTimeMillis();
    ((a)localObject1).field_status = 0;
    ((a)localObject1).field_downloaderType = 1;
    str = ad.bB(str);
    ((a)localObject1).field_filePath = (com.tencent.mm.compatible.util.h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str);
    ((a)localObject1).field_startTime = System.currentTimeMillis();
    c.c((a)localObject1);
    com.tencent.mm.kernel.g.DS().O(new g.1(this, parame, (a)localObject1));
    return ((a)localObject1).field_downloadId;
  }
  
  /* Error */
  public final int dc(long paramLong)
  {
    // Byte code:
    //   0: invokestatic 349	com/tencent/mm/plugin/downloader/model/d:aFP	()Lcom/tencent/mm/plugin/downloader/model/d;
    //   3: pop
    //   4: lload_1
    //   5: invokestatic 353	com/tencent/mm/plugin/downloader/model/d:dm	(J)Z
    //   8: ifeq +27 -> 35
    //   11: invokestatic 349	com/tencent/mm/plugin/downloader/model/d:aFP	()Lcom/tencent/mm/plugin/downloader/model/d;
    //   14: pop
    //   15: lload_1
    //   16: invokestatic 357	com/tencent/mm/plugin/downloader/model/d:dn	(J)J
    //   19: lstore_1
    //   20: aload_0
    //   21: getfield 49	com/tencent/mm/plugin/downloader/model/g:iPP	Landroid/app/DownloadManager;
    //   24: iconst_1
    //   25: newarray long
    //   27: dup
    //   28: iconst_0
    //   29: lload_1
    //   30: lastore
    //   31: invokevirtual 232	android/app/DownloadManager:remove	([J)I
    //   34: ireturn
    //   35: lload_1
    //   36: invokestatic 361	com/tencent/mm/plugin/downloader/model/c:dk	(J)Lcom/tencent/mm/plugin/downloader/f/a;
    //   39: astore 5
    //   41: aload 5
    //   43: ifnonnull +13 -> 56
    //   46: ldc 77
    //   48: ldc_w 363
    //   51: invokestatic 85	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: iconst_0
    //   55: ireturn
    //   56: aload_0
    //   57: getfield 49	com/tencent/mm/plugin/downloader/model/g:iPP	Landroid/app/DownloadManager;
    //   60: iconst_1
    //   61: newarray long
    //   63: dup
    //   64: iconst_0
    //   65: aload 5
    //   67: getfield 220	com/tencent/mm/plugin/downloader/f/a:field_sysDownloadId	J
    //   70: lastore
    //   71: invokevirtual 232	android/app/DownloadManager:remove	([J)I
    //   74: istore_3
    //   75: ldc 77
    //   77: ldc_w 365
    //   80: iconst_1
    //   81: anewarray 89	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: lload_1
    //   87: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   90: aastore
    //   91: invokestatic 145	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload 5
    //   96: getfield 228	com/tencent/mm/plugin/downloader/f/a:field_filePath	Ljava/lang/String;
    //   99: invokestatic 370	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   102: pop
    //   103: ldc 77
    //   105: ldc_w 372
    //   108: iconst_1
    //   109: anewarray 89	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload 5
    //   116: getfield 228	com/tencent/mm/plugin/downloader/f/a:field_filePath	Ljava/lang/String;
    //   119: aastore
    //   120: invokestatic 145	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload 5
    //   125: iconst_5
    //   126: putfield 299	com/tencent/mm/plugin/downloader/f/a:field_status	I
    //   129: aload 5
    //   131: invokestatic 375	com/tencent/mm/plugin/downloader/model/c:d	(Lcom/tencent/mm/plugin/downloader/f/a;)J
    //   134: pop2
    //   135: aload_0
    //   136: getfield 379	com/tencent/mm/plugin/downloader/model/g:iPn	Lcom/tencent/mm/plugin/downloader/model/b;
    //   139: lload_1
    //   140: invokevirtual 385	com/tencent/mm/plugin/downloader/model/b:dg	(J)V
    //   143: aload_0
    //   144: getfield 56	com/tencent/mm/plugin/downloader/model/g:iPQ	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   147: lload_1
    //   148: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   151: invokevirtual 388	java/util/concurrent/CopyOnWriteArraySet:remove	(Ljava/lang/Object;)Z
    //   154: pop
    //   155: iload_3
    //   156: ireturn
    //   157: astore 4
    //   159: iconst_0
    //   160: istore_3
    //   161: ldc 77
    //   163: ldc_w 390
    //   166: iconst_2
    //   167: anewarray 89	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: lload_1
    //   173: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: aload 4
    //   181: invokevirtual 93	java/lang/Exception:toString	()Ljava/lang/String;
    //   184: aastore
    //   185: invokestatic 102	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: goto -94 -> 94
    //   191: astore 4
    //   193: goto -32 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	g
    //   0	196	1	paramLong	long
    //   74	87	3	i	int
    //   157	23	4	localException1	Exception
    //   191	1	4	localException2	Exception
    //   39	91	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   56	75	157	java/lang/Exception
    //   75	94	191	java/lang/Exception
  }
  
  public final FileDownloadTaskInfo dd(long paramLong)
  {
    d.aFP();
    if (d.dm(paramLong))
    {
      d.aFP();
      localObject = dq(d.dn(paramLong));
      ((FileDownloadTaskInfo)localObject).id = paramLong;
      ((FileDownloadTaskInfo)localObject).bOz = 1;
      return localObject;
    }
    Object localObject = c.dk(paramLong);
    if (localObject == null) {
      return new FileDownloadTaskInfo();
    }
    if ((((a)localObject).field_status == 4) || (((a)localObject).field_status == 2) || (((a)localObject).field_status == 5) || (((a)localObject).field_status == 3)) {
      this.iPQ.remove(Long.valueOf(paramLong));
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = new FileDownloadTaskInfo();
    localFileDownloadTaskInfo.id = ((a)localObject).field_downloadId;
    localFileDownloadTaskInfo.url = ((a)localObject).field_downloadUrl;
    localFileDownloadTaskInfo.status = ((a)localObject).field_status;
    localFileDownloadTaskInfo.path = ((a)localObject).field_filePath;
    localFileDownloadTaskInfo.bIW = ((a)localObject).field_md5;
    localFileDownloadTaskInfo.iPN = ((a)localObject).field_autoDownload;
    localFileDownloadTaskInfo.bOz = ((a)localObject).field_downloaderType;
    localFileDownloadTaskInfo.iPM = ((a)localObject).field_downloadedSize;
    localFileDownloadTaskInfo.hFz = ((a)localObject).field_totalSize;
    return localFileDownloadTaskInfo;
  }
  
  public final boolean de(long paramLong)
  {
    FileDownloadTaskInfo localFileDownloadTaskInfo = dd(paramLong);
    if (localFileDownloadTaskInfo == null) {
      y.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
    }
    int i;
    do
    {
      return false;
      this.iPQ.remove(Long.valueOf(paramLong));
      if (localFileDownloadTaskInfo.status != 1)
      {
        y.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", new Object[] { Long.valueOf(paramLong) });
        return true;
      }
      i = dc(paramLong);
      y.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
    } while (i <= 0);
    return true;
  }
  
  public final boolean df(long paramLong)
  {
    a locala = c.dk(paramLong);
    if (locala == null)
    {
      y.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    if (locala.field_downloaderType != 1)
    {
      y.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", new Object[] { Long.valueOf(paramLong) });
      com.tencent.mm.vfs.e.deleteFile(locala.field_filePath);
      y.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask, delete file: %s", new Object[] { locala.field_filePath });
      c.dl(paramLong);
      return false;
    }
    if (locala.field_status == 1)
    {
      y.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", new Object[] { Long.valueOf(paramLong) });
      return false;
    }
    this.iPP.remove(new long[] { locala.field_sysDownloadId });
    paramLong = f(locala);
    if (paramLong > 0L)
    {
      this.iPQ.add(Long.valueOf(locala.field_downloadId));
      if (this.fjC.crl()) {
        this.fjC.S(100L, 100L);
      }
      locala.field_sysDownloadId = paramLong;
      locala.field_status = 1;
      c.d(locala);
      return true;
    }
    y.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
    return false;
  }
  
  final long f(a parama)
  {
    try
    {
      DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse(parama.field_downloadUrl));
      localRequest.setAllowedNetworkTypes(3);
      localRequest.setShowRunningNotification(parama.field_showNotification);
      localRequest.setVisibleInDownloadsUi(parama.field_showNotification);
      if (!bk.bl(parama.field_fileName)) {
        localRequest.setTitle(parama.field_fileName);
      }
      localRequest.setDestinationUri(com.tencent.mm.vfs.e.aeP(parama.field_filePath));
      long l = this.iPP.enqueue(localRequest);
      if (l > 0L) {
        return l;
      }
      y.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
      return -1L;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", new Object[] { localException.toString(), parama.field_downloadUrl });
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.g
 * JD-Core Version:    0.7.0.1
 */