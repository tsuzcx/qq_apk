package com.tencent.mm.plugin.cdndownloader.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.a.b.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.cdndownloader.service.CDNDownloadServiceSlot;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.Set;

public final class a
  implements com.tencent.mm.ipcinvoker.wx_extension.c.a
{
  private static a wOB;
  private static final Object wOE;
  private Context mContext;
  private long wOC;
  private long wOD;
  com.tencent.mm.plugin.cdndownloader.a.a wOF;
  private Set<CDNTaskInfo> wOG;
  public b wOH;
  private ServiceConnection wOI;
  private MTimerHandler wOJ;
  private com.tencent.mm.plugin.cdndownloader.a.b wOK;
  private p.a wOL;
  
  static
  {
    AppMethodBeat.i(120754);
    wOE = new Object();
    AppMethodBeat.o(120754);
  }
  
  public a()
  {
    AppMethodBeat.i(120733);
    this.wOC = 0L;
    this.wOD = 0L;
    this.wOG = new com.tencent.mm.plugin.cdndownloader.e.a(new com.tencent.mm.plugin.cdndownloader.e.b()
    {
      public final void clear()
      {
        AppMethodBeat.i(120725);
        Log.i("MicroMsg.CDNDownloadClient", "notify clear");
        a.d(a.this);
        a.e(a.this);
        AppMethodBeat.o(120725);
      }
      
      public final void dqb()
      {
        AppMethodBeat.i(120723);
        Log.i("MicroMsg.CDNDownloadClient", "notify add");
        a.a(a.this);
        a.b(a.this);
        AppMethodBeat.o(120723);
      }
      
      public final void remove()
      {
        AppMethodBeat.i(120724);
        Log.i("MicroMsg.CDNDownloadClient", "notify remove");
        if (a.c(a.this).size() == 0)
        {
          a.d(a.this);
          a.e(a.this);
        }
        AppMethodBeat.o(120724);
      }
    });
    this.wOI = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(120726);
        Log.i("MicroMsg.CDNDownloadClient", "onServiceConnected");
        a.a(a.this, a.a.A(paramAnonymousIBinder));
        a.f(a.this);
        a.g(a.this);
        try
        {
          synchronized (a.wOE)
          {
            a.wOE.notifyAll();
            AppMethodBeat.o(120726);
            return;
          }
          return;
        }
        catch (Exception ???)
        {
          AppMethodBeat.o(120726);
        }
      }
      
      public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        AppMethodBeat.i(120727);
        Log.i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
        if (a.c(a.this).size() != 0)
        {
          paramAnonymousComponentName = a.c(a.this).iterator();
          while (paramAnonymousComponentName.hasNext()) {
            ((CDNTaskInfo)paramAnonymousComponentName.next()).wOT = true;
          }
        }
        AppMethodBeat.o(120727);
      }
    };
    this.wOJ = new MTimerHandler(s.aYy().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(120728);
        Log.d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
        if (a.c(a.this).size() == 0)
        {
          AppMethodBeat.o(120728);
          return false;
        }
        if (a.h(a.this) != null) {}
        try
        {
          Log.d("MicroMsg.CDNDownloadClient", "checkActive");
          a.h(a.this).dpV();
          AppMethodBeat.o(120728);
          return true;
        }
        catch (RemoteException localRemoteException)
        {
          Log.e("MicroMsg.CDNDownloadClient", "check process active false");
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(710L, 3L, 1L, false);
          if (a.i(a.this))
          {
            a.a(a.this, System.currentTimeMillis());
            localIterator = a.c(a.this).iterator();
            while (localIterator.hasNext()) {
              ((CDNTaskInfo)localIterator.next()).wOT = true;
            }
            a.j(a.this);
            AppMethodBeat.o(120728);
            return true;
          }
          Log.i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(710L, 4L, 1L, false);
          Iterator localIterator = a.c(a.this).iterator();
          while (localIterator.hasNext())
          {
            CDNTaskInfo localCDNTaskInfo = (CDNTaskInfo)localIterator.next();
            a.k(a.this).h(localCDNTaskInfo.downloadUrl, 4, com.tencent.mm.plugin.downloader.a.a.xks, null);
          }
          a.l(a.this);
          AppMethodBeat.o(120728);
        }
        return false;
      }
    }, true);
    this.wOK = new b.a()
    {
      public final void g(String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        AppMethodBeat.i(120729);
        Log.i("MicroMsg.CDNDownloadClient", "onDownloadStateChange, mediaId = %s, state = %d, errCode = %d, errMsg = %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString2 });
        if (paramAnonymousInt1 != 1) {
          a.a(a.this, new CDNTaskInfo(paramAnonymousString1));
        }
        if (a.k(a.this) != null) {
          a.k(a.this).h(paramAnonymousString1, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString2);
        }
        AppMethodBeat.o(120729);
      }
      
      public final void z(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(120730);
        Log.d("MicroMsg.CDNDownloadClient", "onDownloadProgressChange, mediaId = %s, receiveLen = %d, totalLen = %d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        if (a.k(a.this) != null) {
          a.k(a.this).A(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(120730);
      }
    };
    this.wOL = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(120731);
        a locala = a.this;
        Log.i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: ".concat(String.valueOf(paramAnonymousInt)));
        if (locala.wOF != null) {
          try
          {
            locala.wOF.IV(paramAnonymousInt);
            AppMethodBeat.o(120731);
            return;
          }
          catch (RemoteException localRemoteException) {}
        }
        AppMethodBeat.o(120731);
      }
    };
    this.mContext = MMApplicationContext.getContext();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().a(this.wOL);
    dqa();
    AppMethodBeat.o(120733);
  }
  
  private void c(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120741);
    this.wOG.add(paramCDNTaskInfo);
    com.tencent.mm.plugin.cdndownloader.f.b.a(e(paramCDNTaskInfo));
    AppMethodBeat.o(120741);
  }
  
  private void d(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120742);
    this.wOG.remove(paramCDNTaskInfo);
    com.tencent.mm.plugin.cdndownloader.f.b.alN(paramCDNTaskInfo.downloadUrl);
    AppMethodBeat.o(120742);
  }
  
  private void dpT()
  {
    AppMethodBeat.i(120740);
    if (this.wOF != null) {
      try
      {
        this.wOF.dpT();
        AppMethodBeat.o(120740);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: ".concat(String.valueOf(localRemoteException)));
      }
    }
    AppMethodBeat.o(120740);
  }
  
  public static a dpZ()
  {
    try
    {
      AppMethodBeat.i(120732);
      if (wOB == null) {
        wOB = new a();
      }
      a locala = wOB;
      AppMethodBeat.o(120732);
      return locala;
    }
    finally {}
  }
  
  private void dqa()
  {
    try
    {
      AppMethodBeat.i(120734);
      Intent localIntent = new Intent(this.mContext, CDNDownloadServiceSlot.class);
      try
      {
        Log.i("MicroMsg.CDNDownloadClient", "bindService: ".concat(String.valueOf(this.mContext.bindService(localIntent, this.wOI, 1))));
        AppMethodBeat.o(120734);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.CDNDownloadClient", "bindService: " + localException.getMessage());
          AppMethodBeat.o(120734);
        }
      }
      return;
    }
    finally {}
  }
  
  private static com.tencent.mm.plugin.cdndownloader.f.a e(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120743);
    com.tencent.mm.plugin.cdndownloader.f.a locala = new com.tencent.mm.plugin.cdndownloader.f.a();
    locala.field_mediaId = paramCDNTaskInfo.mediaId;
    locala.field_downloadUrlHashCode = paramCDNTaskInfo.downloadUrl.hashCode();
    locala.field_downloadUrl = paramCDNTaskInfo.downloadUrl;
    locala.field_httpsUrl = paramCDNTaskInfo.wON;
    locala.field_filePath = paramCDNTaskInfo.filePath;
    locala.field_verifyHeaders = paramCDNTaskInfo.wOO;
    locala.field_allowMobileNetDownload = Boolean.valueOf(paramCDNTaskInfo.wOR);
    locala.field_wifiAutoDownload = Boolean.valueOf(paramCDNTaskInfo.wOS);
    locala.field_game_package_download = Boolean.valueOf(paramCDNTaskInfo.lwU);
    AppMethodBeat.o(120743);
    return locala;
  }
  
  public final int a(CDNTaskInfo paramCDNTaskInfo)
  {
    int i = -2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(120735);
        if ((paramCDNTaskInfo == null) || (Util.isNullOrNil(paramCDNTaskInfo.downloadUrl)))
        {
          Log.w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
          i = -1;
          AppMethodBeat.o(120735);
          return i;
        }
        Log.i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", new Object[] { paramCDNTaskInfo.filePath, paramCDNTaskInfo.downloadUrl });
        if (this.wOG.contains(paramCDNTaskInfo))
        {
          Log.i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
          AppMethodBeat.o(120735);
          continue;
        }
        localObject = alL(paramCDNTaskInfo.downloadUrl);
      }
      finally {}
      Object localObject;
      if ((localObject != null) && (((CDNTaskState)localObject).taskState == 104) && (y.ZC(paramCDNTaskInfo.filePath)))
      {
        Log.i("MicroMsg.CDNDownloadClient", "addDownloadTask, has download success");
        AppMethodBeat.o(120735);
        i = 1;
      }
      else
      {
        localObject = this.wOF;
        if (localObject != null)
        {
          try
          {
            i = this.wOF.a(paramCDNTaskInfo);
            this.wOK.g(paramCDNTaskInfo.mediaId, 1, 0, "");
            if ((i == 0) || (i == -2)) {
              c(paramCDNTaskInfo);
            }
            AppMethodBeat.o(120735);
          }
          catch (RemoteException localRemoteException)
          {
            Log.e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + localRemoteException.getMessage());
          }
        }
        else
        {
          c(paramCDNTaskInfo);
          dqa();
          AppMethodBeat.o(120735);
          i = 0;
        }
      }
    }
  }
  
  public final boolean alJ(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(120736);
        Log.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: ".concat(String.valueOf(paramString)));
        if (Util.isNullOrNil(paramString))
        {
          Log.w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
          AppMethodBeat.o(120736);
          return bool1;
        }
        d(new CDNTaskInfo(paramString));
        com.tencent.mm.plugin.cdndownloader.a.a locala = this.wOF;
        if (locala == null) {}
      }
      finally
      {
        try
        {
          boolean bool2 = this.wOF.alJ(paramString);
          bool1 = bool2;
          AppMethodBeat.o(120736);
        }
        catch (RemoteException paramString)
        {
          Log.e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + paramString.getMessage());
        }
        paramString = finally;
      }
      Log.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
      AppMethodBeat.o(120736);
    }
  }
  
  public final boolean alK(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(120738);
        Log.i("MicroMsg.CDNDownloadClient", "removeDownloadTask: ".concat(String.valueOf(paramString)));
        if (Util.isNullOrNil(paramString))
        {
          Log.w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
          AppMethodBeat.o(120738);
          return bool1;
        }
        d(new CDNTaskInfo(paramString));
        com.tencent.mm.plugin.cdndownloader.a.a locala = this.wOF;
        if (locala == null) {}
      }
      finally
      {
        try
        {
          boolean bool2 = this.wOF.alK(paramString);
          bool1 = bool2;
          AppMethodBeat.o(120738);
        }
        catch (RemoteException paramString)
        {
          Log.e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + paramString.getMessage());
        }
        paramString = finally;
      }
      Log.i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
      AppMethodBeat.o(120738);
    }
  }
  
  public final CDNTaskState alL(String paramString)
  {
    Object localObject3 = null;
    for (;;)
    {
      CDNTaskState localCDNTaskState;
      try
      {
        AppMethodBeat.i(120739);
        Log.i("MicroMsg.CDNDownloadClient", "queryDownloadTask: ".concat(String.valueOf(paramString)));
        if (Util.isNullOrNil(paramString))
        {
          Log.w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
          AppMethodBeat.o(120739);
          paramString = localObject3;
          return paramString;
        }
        Object localObject4;
        if (this.wOF != null)
        {
          Log.d("MicroMsg.CDNDownloadClient", "queryDownloadTask service has connected");
          try
          {
            localCDNTaskState = this.wOF.alL(paramString);
            if ((localCDNTaskState.taskState != 100) && (localCDNTaskState.taskState != 101)) {
              break label420;
            }
            if (!this.wOG.contains(new CDNTaskInfo(paramString)))
            {
              localObject1 = com.tencent.mm.plugin.cdndownloader.f.b.dpS();
              if (localObject1 == null) {
                break label461;
              }
              localObject4 = ((com.tencent.mm.plugin.cdndownloader.f.c)localObject1).rawQuery(String.format("select * from %s where %s=%s", new Object[] { "CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(paramString.hashCode()) }), new String[0]);
              if (localObject4 != null) {
                continue;
              }
              localObject1 = null;
              if (localObject1 == null) {
                break label466;
              }
              localObject4 = new CDNTaskInfo(paramString);
              ((CDNTaskInfo)localObject4).wON = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_httpsUrl;
              ((CDNTaskInfo)localObject4).mediaId = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_mediaId;
              ((CDNTaskInfo)localObject4).filePath = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_filePath;
              ((CDNTaskInfo)localObject4).wOO = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_verifyHeaders;
              ((CDNTaskInfo)localObject4).wOR = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_allowMobileNetDownload.booleanValue();
              ((CDNTaskInfo)localObject4).wOS = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_wifiAutoDownload.booleanValue();
              ((CDNTaskInfo)localObject4).lwU = ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).field_game_package_download.booleanValue();
              ((CDNTaskInfo)localObject4).wOP = 15;
              ((CDNTaskInfo)localObject4).wOQ = 3600;
              localObject1 = localObject4;
              if (localObject1 != null) {
                this.wOG.add(localObject1);
              }
            }
            AppMethodBeat.o(120739);
            paramString = localCDNTaskState;
            continue;
            Object localObject1 = null;
            if (!((Cursor)localObject4).moveToNext()) {
              break label410;
            }
            localObject1 = new com.tencent.mm.plugin.cdndownloader.f.a();
            ((com.tencent.mm.plugin.cdndownloader.f.a)localObject1).convertFrom((Cursor)localObject4);
            continue;
            if (!this.wOG.contains(new CDNTaskInfo(paramString))) {
              break label450;
            }
          }
          catch (RemoteException localRemoteException)
          {
            Log.e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + localRemoteException.getMessage());
          }
        }
        paramString = new CDNTaskState();
        paramString.taskState = 101;
        AppMethodBeat.o(120739);
        continue;
        ((Cursor)localObject4).close();
      }
      finally {}
      label410:
      continue;
      label420:
      if (this.wOG.contains(new CDNTaskInfo(paramString)))
      {
        localCDNTaskState.taskState = 101;
        continue;
        label450:
        AppMethodBeat.o(120739);
        paramString = localObject3;
        continue;
        label461:
        Object localObject2 = null;
        continue;
        label466:
        localObject2 = null;
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
        AppMethodBeat.i(120737);
        if ((paramCDNTaskInfo == null) || (Util.isNullOrNil(paramCDNTaskInfo.downloadUrl)))
        {
          Log.w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
          i = -1;
          AppMethodBeat.o(120737);
          return i;
        }
        Log.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + paramCDNTaskInfo.downloadUrl);
        if (this.wOG.contains(paramCDNTaskInfo))
        {
          Log.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, already in running");
          AppMethodBeat.o(120737);
          continue;
        }
        localObject = alL(paramCDNTaskInfo.downloadUrl);
      }
      finally {}
      Object localObject;
      if ((localObject != null) && (((CDNTaskState)localObject).taskState == 104) && (y.ZC(paramCDNTaskInfo.filePath)))
      {
        Log.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, has download success");
        AppMethodBeat.o(120737);
        i = 1;
      }
      else
      {
        paramCDNTaskInfo.wOT = true;
        localObject = this.wOF;
        if (localObject != null)
        {
          try
          {
            i = this.wOF.b(paramCDNTaskInfo);
            this.wOK.g(paramCDNTaskInfo.mediaId, 1, 0, "");
            if ((i == 0) || (i == -2)) {
              c(paramCDNTaskInfo);
            }
            AppMethodBeat.o(120737);
          }
          catch (RemoteException localRemoteException)
          {
            Log.e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + localRemoteException.getMessage());
          }
        }
        else
        {
          c(paramCDNTaskInfo);
          dqa();
          AppMethodBeat.o(120737);
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