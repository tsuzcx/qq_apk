package com.tencent.mm.plugin.cdndownloader.d;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.cdndownloader.f.c;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

public final class a
  implements com.tencent.mm.ipcinvoker.wx_extension.b.a
{
  private static a iAv;
  private static final Object iAy = new Object();
  private Set<CDNTaskInfo> iAA = new com.tencent.mm.plugin.cdndownloader.e.a(new a.1(this));
  public b iAB;
  private ServiceConnection iAC = new a.2(this);
  private am iAD = new am(com.tencent.mm.cg.a.cxw().getLooper(), new a.3(this), true);
  private com.tencent.mm.plugin.cdndownloader.a.b iAE = new a.4(this);
  private n.a iAF = new a.5(this);
  private long iAw = 0L;
  private long iAx = 0L;
  com.tencent.mm.plugin.cdndownloader.a.a iAz;
  private Context mContext = ae.getContext();
  
  public a()
  {
    g.DQ();
    g.DO().a(this.iAF);
    aDx();
  }
  
  private void aDs()
  {
    if (this.iAz != null) {}
    try
    {
      this.iAz.aDs();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: " + localRemoteException);
    }
  }
  
  public static a aDw()
  {
    try
    {
      if (iAv == null) {
        iAv = new a();
      }
      a locala = iAv;
      return locala;
    }
    finally {}
  }
  
  /* Error */
  private void aDx()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 169	android/content/Intent
    //   5: dup
    //   6: aload_0
    //   7: getfield 99	com/tencent/mm/plugin/cdndownloader/d/a:mContext	Landroid/content/Context;
    //   10: ldc 171
    //   12: invokespecial 174	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   15: astore_2
    //   16: aload_0
    //   17: getfield 99	com/tencent/mm/plugin/cdndownloader/d/a:mContext	Landroid/content/Context;
    //   20: aload_2
    //   21: aload_0
    //   22: getfield 59	com/tencent/mm/plugin/cdndownloader/d/a:iAC	Landroid/content/ServiceConnection;
    //   25: iconst_1
    //   26: invokevirtual 180	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   29: istore_1
    //   30: ldc 139
    //   32: new 141	java/lang/StringBuilder
    //   35: dup
    //   36: ldc 182
    //   38: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   41: iload_1
    //   42: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 188	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: astore_2
    //   55: ldc 139
    //   57: new 141	java/lang/StringBuilder
    //   60: dup
    //   61: ldc 182
    //   63: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   66: aload_2
    //   67: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   70: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 160	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: goto -28 -> 51
    //   82: astore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	a
    //   29	13	1	bool	boolean
    //   15	6	2	localIntent	android.content.Intent
    //   54	13	2	localException	java.lang.Exception
    //   82	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	51	54	java/lang/Exception
    //   2	16	82	finally
    //   16	51	82	finally
    //   55	79	82	finally
  }
  
  private void c(CDNTaskInfo paramCDNTaskInfo)
  {
    this.iAA.add(paramCDNTaskInfo);
    com.tencent.mm.plugin.cdndownloader.f.a locala = new com.tencent.mm.plugin.cdndownloader.f.a();
    locala.field_mediaId = paramCDNTaskInfo.bUi;
    locala.field_downloadUrlHashCode = paramCDNTaskInfo.downloadUrl.hashCode();
    locala.field_downloadUrl = paramCDNTaskInfo.downloadUrl;
    locala.field_httpsUrl = paramCDNTaskInfo.iAH;
    locala.field_filePath = paramCDNTaskInfo.filePath;
    locala.field_verifyHeaders = paramCDNTaskInfo.iAI;
    locala.field_allowMobileNetDownload = Boolean.valueOf(paramCDNTaskInfo.iAL);
    locala.field_wifiAutoDownload = Boolean.valueOf(paramCDNTaskInfo.iAM);
    locala.field_game_package_download = Boolean.valueOf(paramCDNTaskInfo.dlW);
    paramCDNTaskInfo = com.tencent.mm.plugin.cdndownloader.f.b.aDr();
    if (paramCDNTaskInfo != null)
    {
      boolean bool = paramCDNTaskInfo.b(locala);
      y.i("MicroMsg.CdnDownloadInfoDBHelp", "insert: " + bool);
    }
  }
  
  private void d(CDNTaskInfo paramCDNTaskInfo)
  {
    this.iAA.remove(paramCDNTaskInfo);
    paramCDNTaskInfo = paramCDNTaskInfo.downloadUrl;
    c localc = com.tencent.mm.plugin.cdndownloader.f.b.aDr();
    if (localc != null)
    {
      boolean bool = localc.gk("CdnDownloadInfo", String.format("delete from %s where %s=%s", new Object[] { "CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(paramCDNTaskInfo.hashCode()) }));
      y.i("MicroMsg.CdnDownloadInfoDBHelp", "removeDownloadInfoByDownloadUrl: " + bool);
    }
  }
  
  public final int a(CDNTaskInfo paramCDNTaskInfo)
  {
    if ((paramCDNTaskInfo == null) || (bk.bl(paramCDNTaskInfo.downloadUrl)))
    {
      y.w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
      return -1;
    }
    y.i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", new Object[] { paramCDNTaskInfo.filePath, paramCDNTaskInfo.downloadUrl });
    if (this.iAA.contains(paramCDNTaskInfo))
    {
      y.i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
      return -2;
    }
    CDNTaskState localCDNTaskState = zh(paramCDNTaskInfo.downloadUrl);
    if ((localCDNTaskState != null) && (localCDNTaskState.taskState == 104) && (e.bK(paramCDNTaskInfo.filePath)))
    {
      y.i("MicroMsg.CDNDownloadClient", "addDownloadTask, has download success");
      return 1;
    }
    if (this.iAz != null) {
      try
      {
        int i = this.iAz.a(paramCDNTaskInfo);
        this.iAE.e(paramCDNTaskInfo.bUi, 1, 0, "");
        if ((i == 0) || (i == -2)) {
          c(paramCDNTaskInfo);
        }
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        y.e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + localRemoteException.getMessage());
      }
    }
    c(paramCDNTaskInfo);
    aDx();
    return 0;
  }
  
  public final int b(CDNTaskInfo paramCDNTaskInfo)
  {
    if ((paramCDNTaskInfo == null) || (bk.bl(paramCDNTaskInfo.downloadUrl)))
    {
      y.w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
      return -1;
    }
    y.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + paramCDNTaskInfo.downloadUrl);
    if (this.iAA.contains(paramCDNTaskInfo))
    {
      y.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, already in running");
      return -2;
    }
    CDNTaskState localCDNTaskState = zh(paramCDNTaskInfo.downloadUrl);
    if ((localCDNTaskState != null) && (localCDNTaskState.taskState == 104) && (e.bK(paramCDNTaskInfo.filePath)))
    {
      y.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, has download success");
      return 1;
    }
    paramCDNTaskInfo.iAN = true;
    if (this.iAz != null) {
      try
      {
        int i = this.iAz.b(paramCDNTaskInfo);
        this.iAE.e(paramCDNTaskInfo.bUi, 1, 0, "");
        if ((i == 0) || (i == -2)) {
          c(paramCDNTaskInfo);
        }
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        y.e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + localRemoteException.getMessage());
      }
    }
    c(paramCDNTaskInfo);
    aDx();
    return 0;
  }
  
  public final boolean zf(String paramString)
  {
    y.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: " + paramString);
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
      return false;
    }
    d(new CDNTaskInfo(paramString));
    if (this.iAz != null) {
      try
      {
        boolean bool = this.iAz.zf(paramString);
        return bool;
      }
      catch (RemoteException paramString)
      {
        y.e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + paramString.getMessage());
      }
    }
    y.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
    return false;
  }
  
  public final boolean zg(String paramString)
  {
    y.i("MicroMsg.CDNDownloadClient", "removeDownloadTask: " + paramString);
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
      return false;
    }
    d(new CDNTaskInfo(paramString));
    if (this.iAz != null) {
      try
      {
        boolean bool = this.iAz.zg(paramString);
        return bool;
      }
      catch (RemoteException paramString)
      {
        y.e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + paramString.getMessage());
      }
    }
    y.i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
    return false;
  }
  
  public final CDNTaskState zh(String paramString)
  {
    y.i("MicroMsg.CDNDownloadClient", "queryDownloadTask: " + paramString);
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
      return null;
    }
    if (this.iAz != null) {
      y.d("MicroMsg.CDNDownloadClient", "queryDownloadTask service has connected");
    }
    for (;;)
    {
      CDNTaskState localCDNTaskState;
      try
      {
        localCDNTaskState = this.iAz.zh(paramString);
        if ((localCDNTaskState.taskState == 100) || (localCDNTaskState.taskState == 101))
        {
          if (!this.iAA.contains(new CDNTaskInfo(paramString)))
          {
            Object localObject1 = com.tencent.mm.plugin.cdndownloader.f.b.aDr();
            if (localObject1 == null) {
              break label326;
            }
            localObject1 = ((c)localObject1).zk(paramString);
            if (localObject1 == null) {
              break label331;
            }
            CDNTaskInfo localCDNTaskInfo = new CDNTaskInfo(paramString);
            localCDNTaskInfo.iAH = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_httpsUrl;
            localCDNTaskInfo.bUi = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_mediaId;
            localCDNTaskInfo.filePath = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_filePath;
            localCDNTaskInfo.iAI = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_verifyHeaders;
            localCDNTaskInfo.iAL = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_allowMobileNetDownload.booleanValue();
            localCDNTaskInfo.iAM = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_wifiAutoDownload.booleanValue();
            localCDNTaskInfo.dlW = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_game_package_download.booleanValue();
            localCDNTaskInfo.iAJ = 15;
            localCDNTaskInfo.iAK = 3600;
            localObject1 = localCDNTaskInfo;
            if (localObject1 != null) {
              this.iAA.add(localObject1);
            }
          }
        }
        else if (this.iAA.contains(new CDNTaskInfo(paramString))) {
          localCDNTaskState.taskState = 101;
        }
      }
      catch (RemoteException localRemoteException)
      {
        y.e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + localRemoteException.getMessage());
      }
      if (!this.iAA.contains(new CDNTaskInfo(paramString))) {
        break;
      }
      paramString = new CDNTaskState();
      paramString.taskState = 101;
      return paramString;
      return localCDNTaskState;
      label326:
      Object localObject2 = null;
      continue;
      label331:
      localObject2 = null;
    }
  }
  
  /* Error */
  public final CDNTaskState zj(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 124	com/tencent/mm/plugin/cdndownloader/d/a:iAz	Lcom/tencent/mm/plugin/cdndownloader/a/a;
    //   4: ifnull +9 -> 13
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 437	com/tencent/mm/plugin/cdndownloader/d/a:zh	(Ljava/lang/String;)Lcom/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState;
    //   12: areturn
    //   13: invokestatic 518	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 521	java/lang/Thread:getId	()J
    //   19: invokestatic 526	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   22: invokevirtual 529	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   25: invokevirtual 521	java/lang/Thread:getId	()J
    //   28: lcmp
    //   29: ifne +5 -> 34
    //   32: aconst_null
    //   33: areturn
    //   34: aload_0
    //   35: invokespecial 118	com/tencent/mm/plugin/cdndownloader/d/a:aDx	()V
    //   38: getstatic 37	com/tencent/mm/plugin/cdndownloader/d/a:iAy	Ljava/lang/Object;
    //   41: astore_2
    //   42: aload_2
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield 124	com/tencent/mm/plugin/cdndownloader/d/a:iAz	Lcom/tencent/mm/plugin/cdndownloader/a/a;
    //   48: ifnonnull +48 -> 96
    //   51: ldc 139
    //   53: new 141	java/lang/StringBuilder
    //   56: dup
    //   57: ldc_w 531
    //   60: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: invokestatic 402	java/lang/System:currentTimeMillis	()J
    //   66: invokevirtual 534	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 188	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: new 536	com/tencent/mm/plugin/cdndownloader/d/a$6
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 537	com/tencent/mm/plugin/cdndownloader/d/a$6:<init>	(Lcom/tencent/mm/plugin/cdndownloader/d/a;)V
    //   83: ldc2_w 538
    //   86: invokestatic 542	com/tencent/mm/cg/a:e	(Ljava/lang/Runnable;J)Z
    //   89: pop
    //   90: getstatic 37	com/tencent/mm/plugin/cdndownloader/d/a:iAy	Ljava/lang/Object;
    //   93: invokevirtual 545	java/lang/Object:wait	()V
    //   96: aload_2
    //   97: monitorexit
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 437	com/tencent/mm/plugin/cdndownloader/d/a:zh	(Ljava/lang/String;)Lcom/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState;
    //   103: areturn
    //   104: astore_3
    //   105: aload_2
    //   106: monitorexit
    //   107: aload_3
    //   108: athrow
    //   109: astore_2
    //   110: ldc 139
    //   112: ldc_w 547
    //   115: iconst_2
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: invokestatic 402	java/lang/System:currentTimeMillis	()J
    //   124: invokestatic 552	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aastore
    //   128: dup
    //   129: iconst_1
    //   130: aload_2
    //   131: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   134: aastore
    //   135: invokestatic 368	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: goto -40 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	a
    //   0	141	1	paramString	String
    //   109	22	2	localException	java.lang.Exception
    //   104	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	96	104	finally
    //   96	98	104	finally
    //   105	107	104	finally
    //   38	44	109	java/lang/Exception
    //   107	109	109	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a
 * JD-Core Version:    0.7.0.1
 */