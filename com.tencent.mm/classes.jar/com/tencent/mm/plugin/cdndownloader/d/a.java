package com.tencent.mm.plugin.cdndownloader.d;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.cdndownloader.f.c;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Set;

public final class a
  implements com.tencent.mm.ipcinvoker.wx_extension.b.a
{
  private static a kDB;
  private static final Object kDE;
  private long kDC;
  private long kDD;
  com.tencent.mm.plugin.cdndownloader.a.a kDF;
  private Set<CDNTaskInfo> kDG;
  public b kDH;
  private ServiceConnection kDI;
  private ap kDJ;
  private com.tencent.mm.plugin.cdndownloader.a.b kDK;
  private n.a kDL;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(922);
    kDE = new Object();
    AppMethodBeat.o(922);
  }
  
  public a()
  {
    AppMethodBeat.i(900);
    this.kDC = 0L;
    this.kDD = 0L;
    this.kDG = new com.tencent.mm.plugin.cdndownloader.e.a(new a.1(this));
    this.kDI = new a.2(this);
    this.kDJ = new ap(l.PP().getLooper(), new a.3(this), true);
    this.kDK = new a.4(this);
    this.kDL = new a.5(this);
    this.mContext = ah.getContext();
    g.RM();
    g.RK().a(this.kDL);
    bfU();
    AppMethodBeat.o(900);
  }
  
  private void bfP()
  {
    AppMethodBeat.i(908);
    if (this.kDF != null) {
      try
      {
        this.kDF.bfP();
        AppMethodBeat.o(908);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ab.e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: ".concat(String.valueOf(localRemoteException)));
      }
    }
    AppMethodBeat.o(908);
  }
  
  public static a bfT()
  {
    try
    {
      AppMethodBeat.i(899);
      if (kDB == null) {
        kDB = new a();
      }
      a locala = kDB;
      AppMethodBeat.o(899);
      return locala;
    }
    finally {}
  }
  
  private void bfU()
  {
    try
    {
      AppMethodBeat.i(901);
      Intent localIntent = new Intent(this.mContext, CDNDownloadService.class);
      try
      {
        ab.i("MicroMsg.CDNDownloadClient", "bindService: ".concat(String.valueOf(this.mContext.bindService(localIntent, this.kDI, 1))));
        AppMethodBeat.o(901);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.CDNDownloadClient", "bindService: " + localException.getMessage());
          AppMethodBeat.o(901);
        }
      }
      return;
    }
    finally {}
  }
  
  private void c(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(909);
    this.kDG.add(paramCDNTaskInfo);
    com.tencent.mm.plugin.cdndownloader.f.b.a(e(paramCDNTaskInfo));
    AppMethodBeat.o(909);
  }
  
  private void d(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(910);
    this.kDG.remove(paramCDNTaskInfo);
    com.tencent.mm.plugin.cdndownloader.f.b.IT(paramCDNTaskInfo.downloadUrl);
    AppMethodBeat.o(910);
  }
  
  private static com.tencent.mm.plugin.cdndownloader.f.a e(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(911);
    com.tencent.mm.plugin.cdndownloader.f.a locala = new com.tencent.mm.plugin.cdndownloader.f.a();
    locala.field_mediaId = paramCDNTaskInfo.cBO;
    locala.field_downloadUrlHashCode = paramCDNTaskInfo.downloadUrl.hashCode();
    locala.field_downloadUrl = paramCDNTaskInfo.downloadUrl;
    locala.field_httpsUrl = paramCDNTaskInfo.kDN;
    locala.field_filePath = paramCDNTaskInfo.filePath;
    locala.field_verifyHeaders = paramCDNTaskInfo.kDO;
    locala.field_allowMobileNetDownload = Boolean.valueOf(paramCDNTaskInfo.kDR);
    locala.field_wifiAutoDownload = Boolean.valueOf(paramCDNTaskInfo.kDS);
    locala.field_game_package_download = Boolean.valueOf(paramCDNTaskInfo.edy);
    AppMethodBeat.o(911);
    return locala;
  }
  
  public final boolean IO(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(903);
        ab.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: ".concat(String.valueOf(paramString)));
        if (bo.isNullOrNil(paramString))
        {
          ab.w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
          AppMethodBeat.o(903);
          return bool1;
        }
        d(new CDNTaskInfo(paramString));
        com.tencent.mm.plugin.cdndownloader.a.a locala = this.kDF;
        if (locala == null) {}
      }
      finally
      {
        try
        {
          boolean bool2 = this.kDF.IO(paramString);
          bool1 = bool2;
          AppMethodBeat.o(903);
        }
        catch (RemoteException paramString)
        {
          ab.e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + paramString.getMessage());
        }
        paramString = finally;
      }
      ab.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
      AppMethodBeat.o(903);
    }
  }
  
  public final boolean IP(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(905);
        ab.i("MicroMsg.CDNDownloadClient", "removeDownloadTask: ".concat(String.valueOf(paramString)));
        if (bo.isNullOrNil(paramString))
        {
          ab.w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
          AppMethodBeat.o(905);
          return bool1;
        }
        d(new CDNTaskInfo(paramString));
        com.tencent.mm.plugin.cdndownloader.a.a locala = this.kDF;
        if (locala == null) {}
      }
      finally
      {
        try
        {
          boolean bool2 = this.kDF.IP(paramString);
          bool1 = bool2;
          AppMethodBeat.o(905);
        }
        catch (RemoteException paramString)
        {
          ab.e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + paramString.getMessage());
        }
        paramString = finally;
      }
      ab.i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
      AppMethodBeat.o(905);
    }
  }
  
  public final CDNTaskState IQ(String paramString)
  {
    Object localObject3 = null;
    for (;;)
    {
      CDNTaskState localCDNTaskState;
      Object localObject4;
      try
      {
        AppMethodBeat.i(906);
        ab.i("MicroMsg.CDNDownloadClient", "queryDownloadTask: ".concat(String.valueOf(paramString)));
        if (bo.isNullOrNil(paramString))
        {
          ab.w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
          AppMethodBeat.o(906);
          paramString = localObject3;
          return paramString;
        }
        if (this.kDF != null)
        {
          ab.d("MicroMsg.CDNDownloadClient", "queryDownloadTask service has connected");
          try
          {
            localCDNTaskState = this.kDF.IQ(paramString);
            if ((localCDNTaskState.taskState != 100) && (localCDNTaskState.taskState != 101)) {
              break label425;
            }
            if (this.kDG.contains(new CDNTaskInfo(paramString))) {
              break label403;
            }
            Object localObject1 = com.tencent.mm.plugin.cdndownloader.f.b.bfO();
            if (localObject1 == null) {
              break label415;
            }
            localObject4 = ((c)localObject1).rawQuery(String.format("select * from %s where %s=%s", new Object[] { "CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(paramString.hashCode()) }), new String[0]);
            if (localObject4 == null) {
              break label415;
            }
            localObject1 = null;
            if (!((Cursor)localObject4).moveToNext()) {
              break label277;
            }
            localObject1 = new com.tencent.mm.plugin.cdndownloader.f.a();
            ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).convertFrom((Cursor)localObject4);
            continue;
            if (!this.kDG.contains(new CDNTaskInfo(paramString))) {
              break label455;
            }
          }
          catch (RemoteException localRemoteException)
          {
            ab.e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + localRemoteException.getMessage());
          }
        }
        else
        {
          paramString = new CDNTaskState();
          paramString.taskState = 101;
          AppMethodBeat.o(906);
          continue;
        }
        ((Cursor)localObject4).close();
      }
      finally {}
      label277:
      label284:
      Object localObject2;
      if (localRemoteException != null)
      {
        localObject4 = new CDNTaskInfo(paramString);
        ((CDNTaskInfo)localObject4).kDN = localRemoteException.field_httpsUrl;
        ((CDNTaskInfo)localObject4).cBO = localRemoteException.field_mediaId;
        ((CDNTaskInfo)localObject4).filePath = localRemoteException.field_filePath;
        ((CDNTaskInfo)localObject4).kDO = localRemoteException.field_verifyHeaders;
        ((CDNTaskInfo)localObject4).kDR = localRemoteException.field_allowMobileNetDownload.booleanValue();
        ((CDNTaskInfo)localObject4).kDS = localRemoteException.field_wifiAutoDownload.booleanValue();
        ((CDNTaskInfo)localObject4).edy = localRemoteException.field_game_package_download.booleanValue();
        ((CDNTaskInfo)localObject4).kDP = 15;
        ((CDNTaskInfo)localObject4).kDQ = 3600;
        localObject2 = localObject4;
        label388:
        if (localObject2 != null) {
          this.kDG.add(localObject2);
        }
      }
      for (;;)
      {
        label403:
        AppMethodBeat.o(906);
        paramString = localCDNTaskState;
        break;
        label415:
        localObject2 = null;
        break label284;
        localObject2 = null;
        break label388;
        label425:
        if (this.kDG.contains(new CDNTaskInfo(paramString))) {
          localCDNTaskState.taskState = 101;
        }
      }
      label455:
      AppMethodBeat.o(906);
      paramString = localObject3;
    }
  }
  
  /* Error */
  public final CDNTaskState IS(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 907
    //   5: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 131	com/tencent/mm/plugin/cdndownloader/d/a:kDF	Lcom/tencent/mm/plugin/cdndownloader/a/a;
    //   12: ifnull +19 -> 31
    //   15: aload_0
    //   16: aload_1
    //   17: invokevirtual 510	com/tencent/mm/plugin/cdndownloader/d/a:IQ	(Ljava/lang/String;)Lcom/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState;
    //   20: astore_1
    //   21: sipush 907
    //   24: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: areturn
    //   31: invokestatic 516	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   34: invokevirtual 519	java/lang/Thread:getId	()J
    //   37: invokestatic 524	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   40: invokevirtual 527	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   43: invokevirtual 519	java/lang/Thread:getId	()J
    //   46: lcmp
    //   47: ifne +19 -> 66
    //   50: aconst_null
    //   51: astore_1
    //   52: sipush 907
    //   55: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: goto -31 -> 27
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: aload_0
    //   67: invokespecial 127	com/tencent/mm/plugin/cdndownloader/d/a:bfU	()V
    //   70: getstatic 43	com/tencent/mm/plugin/cdndownloader/d/a:kDE	Ljava/lang/Object;
    //   73: astore_2
    //   74: aload_2
    //   75: monitorenter
    //   76: aload_0
    //   77: getfield 131	com/tencent/mm/plugin/cdndownloader/d/a:kDF	Lcom/tencent/mm/plugin/cdndownloader/a/a;
    //   80: ifnonnull +48 -> 128
    //   83: ldc 144
    //   85: new 204	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 529
    //   92: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   98: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   101: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 151	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: new 534	com/tencent/mm/plugin/cdndownloader/d/a$6
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 535	com/tencent/mm/plugin/cdndownloader/d/a$6:<init>	(Lcom/tencent/mm/plugin/cdndownloader/d/a;)V
    //   115: ldc2_w 536
    //   118: invokestatic 540	com/tencent/mm/ipcinvoker/l:h	(Ljava/lang/Runnable;J)Z
    //   121: pop
    //   122: getstatic 43	com/tencent/mm/plugin/cdndownloader/d/a:kDE	Ljava/lang/Object;
    //   125: invokevirtual 543	java/lang/Object:wait	()V
    //   128: aload_2
    //   129: monitorexit
    //   130: aload_0
    //   131: aload_1
    //   132: invokevirtual 510	com/tencent/mm/plugin/cdndownloader/d/a:IQ	(Ljava/lang/String;)Lcom/tencent/mm/plugin/cdndownloader/ipc/CDNTaskState;
    //   135: astore_1
    //   136: sipush 907
    //   139: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: goto -115 -> 27
    //   145: astore_3
    //   146: aload_2
    //   147: monitorexit
    //   148: sipush 907
    //   151: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_3
    //   155: athrow
    //   156: astore_2
    //   157: ldc 144
    //   159: ldc_w 545
    //   162: iconst_2
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: invokestatic 390	java/lang/System:currentTimeMillis	()J
    //   171: invokestatic 550	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload_2
    //   178: invokevirtual 211	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   181: aastore
    //   182: invokestatic 355	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: goto -55 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	a
    //   0	188	1	paramString	String
    //   156	22	2	localException	Exception
    //   145	10	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	61	finally
    //   31	50	61	finally
    //   52	58	61	finally
    //   66	70	61	finally
    //   70	76	61	finally
    //   130	142	61	finally
    //   148	156	61	finally
    //   157	185	61	finally
    //   76	128	145	finally
    //   128	130	145	finally
    //   146	148	145	finally
    //   70	76	156	java/lang/Exception
    //   148	156	156	java/lang/Exception
  }
  
  public final int a(CDNTaskInfo paramCDNTaskInfo)
  {
    int i = -2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(902);
        if ((paramCDNTaskInfo == null) || (bo.isNullOrNil(paramCDNTaskInfo.downloadUrl)))
        {
          ab.w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
          i = -1;
          AppMethodBeat.o(902);
          return i;
        }
        ab.i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", new Object[] { paramCDNTaskInfo.filePath, paramCDNTaskInfo.downloadUrl });
        if (this.kDG.contains(paramCDNTaskInfo))
        {
          ab.i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
          AppMethodBeat.o(902);
          continue;
        }
        localObject = IQ(paramCDNTaskInfo.downloadUrl);
      }
      finally {}
      Object localObject;
      if ((localObject != null) && (((CDNTaskState)localObject).taskState == 104) && (e.cN(paramCDNTaskInfo.filePath)))
      {
        ab.i("MicroMsg.CDNDownloadClient", "addDownloadTask, has download success");
        AppMethodBeat.o(902);
        i = 1;
      }
      else
      {
        localObject = this.kDF;
        if (localObject != null)
        {
          try
          {
            i = this.kDF.a(paramCDNTaskInfo);
            this.kDK.e(paramCDNTaskInfo.cBO, 1, 0, "");
            if ((i == 0) || (i == -2)) {
              c(paramCDNTaskInfo);
            }
            AppMethodBeat.o(902);
          }
          catch (RemoteException localRemoteException)
          {
            ab.e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + localRemoteException.getMessage());
          }
        }
        else
        {
          c(paramCDNTaskInfo);
          bfU();
          AppMethodBeat.o(902);
          i = 0;
        }
      }
    }
  }
  
  public final int b(CDNTaskInfo paramCDNTaskInfo)
  {
    int i = -2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(904);
        if ((paramCDNTaskInfo == null) || (bo.isNullOrNil(paramCDNTaskInfo.downloadUrl)))
        {
          ab.w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
          i = -1;
          AppMethodBeat.o(904);
          return i;
        }
        ab.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + paramCDNTaskInfo.downloadUrl);
        if (this.kDG.contains(paramCDNTaskInfo))
        {
          ab.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, already in running");
          AppMethodBeat.o(904);
          continue;
        }
        localObject = IQ(paramCDNTaskInfo.downloadUrl);
      }
      finally {}
      Object localObject;
      if ((localObject != null) && (((CDNTaskState)localObject).taskState == 104) && (e.cN(paramCDNTaskInfo.filePath)))
      {
        ab.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, has download success");
        AppMethodBeat.o(904);
        i = 1;
      }
      else
      {
        paramCDNTaskInfo.kDT = true;
        localObject = this.kDF;
        if (localObject != null)
        {
          try
          {
            i = this.kDF.b(paramCDNTaskInfo);
            this.kDK.e(paramCDNTaskInfo.cBO, 1, 0, "");
            if ((i == 0) || (i == -2)) {
              c(paramCDNTaskInfo);
            }
            AppMethodBeat.o(904);
          }
          catch (RemoteException localRemoteException)
          {
            ab.e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + localRemoteException.getMessage());
          }
        }
        else
        {
          c(paramCDNTaskInfo);
          bfU();
          AppMethodBeat.o(904);
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a
 * JD-Core Version:    0.7.0.1
 */