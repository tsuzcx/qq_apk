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
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.a.b.a;
import com.tencent.mm.plugin.cdndownloader.f.c;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.cdndownloader.service.CDNDownloadServiceSlot;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.Set;

public final class a
  implements com.tencent.mm.ipcinvoker.wx_extension.b.a
{
  private static a oQW;
  private static final Object oQZ;
  private Context mContext;
  private long oQX;
  private long oQY;
  com.tencent.mm.plugin.cdndownloader.a.a oRa;
  private Set<CDNTaskInfo> oRb;
  public b oRc;
  private ServiceConnection oRd;
  private av oRe;
  private com.tencent.mm.plugin.cdndownloader.a.b oRf;
  private n.a oRg;
  
  static
  {
    AppMethodBeat.i(120754);
    oQZ = new Object();
    AppMethodBeat.o(120754);
  }
  
  public a()
  {
    AppMethodBeat.i(120733);
    this.oQX = 0L;
    this.oQY = 0L;
    this.oRb = new com.tencent.mm.plugin.cdndownloader.e.a(new com.tencent.mm.plugin.cdndownloader.e.b()
    {
      public final void bYW()
      {
        AppMethodBeat.i(120723);
        ad.i("MicroMsg.CDNDownloadClient", "notify add");
        a.a(a.this);
        a.b(a.this);
        AppMethodBeat.o(120723);
      }
      
      public final void clear()
      {
        AppMethodBeat.i(120725);
        ad.i("MicroMsg.CDNDownloadClient", "notify clear");
        a.d(a.this);
        a.e(a.this);
        AppMethodBeat.o(120725);
      }
      
      public final void remove()
      {
        AppMethodBeat.i(120724);
        ad.i("MicroMsg.CDNDownloadClient", "notify remove");
        if (a.c(a.this).size() == 0)
        {
          a.d(a.this);
          a.e(a.this);
        }
        AppMethodBeat.o(120724);
      }
    });
    this.oRd = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(120726);
        ad.i("MicroMsg.CDNDownloadClient", "onServiceConnected");
        a.a(a.this, a.a.t(paramAnonymousIBinder));
        a.f(a.this);
        a.g(a.this);
        try
        {
          synchronized (a.oQZ)
          {
            a.oQZ.notifyAll();
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
        ad.i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
        if (a.c(a.this).size() != 0)
        {
          paramAnonymousComponentName = a.c(a.this).iterator();
          while (paramAnonymousComponentName.hasNext()) {
            ((CDNTaskInfo)paramAnonymousComponentName.next()).oRo = true;
          }
        }
        AppMethodBeat.o(120727);
      }
    };
    this.oRe = new av(p.ahE().getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(120728);
        ad.d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
        if (a.c(a.this).size() == 0)
        {
          AppMethodBeat.o(120728);
          return false;
        }
        if (a.h(a.this) != null) {}
        try
        {
          ad.d("MicroMsg.CDNDownloadClient", "checkActive");
          a.h(a.this).bYS();
          AppMethodBeat.o(120728);
          return true;
        }
        catch (RemoteException localRemoteException)
        {
          ad.e("MicroMsg.CDNDownloadClient", "check process active false");
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(710L, 3L, 1L, false);
          if (a.i(a.this))
          {
            a.a(a.this, System.currentTimeMillis());
            localIterator = a.c(a.this).iterator();
            while (localIterator.hasNext()) {
              ((CDNTaskInfo)localIterator.next()).oRo = true;
            }
            a.j(a.this);
            AppMethodBeat.o(120728);
            return true;
          }
          ad.i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(710L, 4L, 1L, false);
          Iterator localIterator = a.c(a.this).iterator();
          while (localIterator.hasNext())
          {
            CDNTaskInfo localCDNTaskInfo = (CDNTaskInfo)localIterator.next();
            a.k(a.this).g(localCDNTaskInfo.downloadUrl, 4, com.tencent.mm.plugin.downloader.a.a.pje, null);
          }
          a.l(a.this);
          AppMethodBeat.o(120728);
        }
        return false;
      }
    }, true);
    this.oRf = new b.a()
    {
      public final void f(String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        AppMethodBeat.i(120729);
        ad.i("MicroMsg.CDNDownloadClient", "onDownloadStateChange, mediaId = %s, state = %d, errCode = %d, errMsg = %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString2 });
        if (paramAnonymousInt1 != 1) {
          a.a(a.this, new CDNTaskInfo(paramAnonymousString1));
        }
        if (a.k(a.this) != null) {
          a.k(a.this).g(paramAnonymousString1, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString2);
        }
        AppMethodBeat.o(120729);
      }
      
      public final void v(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(120730);
        ad.d("MicroMsg.CDNDownloadClient", "onDownloadProgressChange, mediaId = %s, receiveLen = %d, totalLen = %d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        if (a.k(a.this) != null) {
          a.k(a.this).w(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(120730);
      }
    };
    this.oRg = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(120731);
        a locala = a.this;
        ad.i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: ".concat(String.valueOf(paramAnonymousInt)));
        if (locala.oRa != null) {
          try
          {
            locala.oRa.AR(paramAnonymousInt);
            AppMethodBeat.o(120731);
            return;
          }
          catch (RemoteException localRemoteException) {}
        }
        AppMethodBeat.o(120731);
      }
    };
    this.mContext = aj.getContext();
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().a(this.oRg);
    bYV();
    AppMethodBeat.o(120733);
  }
  
  private void bYQ()
  {
    AppMethodBeat.i(120740);
    if (this.oRa != null) {
      try
      {
        this.oRa.bYQ();
        AppMethodBeat.o(120740);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ad.e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: ".concat(String.valueOf(localRemoteException)));
      }
    }
    AppMethodBeat.o(120740);
  }
  
  public static a bYU()
  {
    try
    {
      AppMethodBeat.i(120732);
      if (oQW == null) {
        oQW = new a();
      }
      a locala = oQW;
      AppMethodBeat.o(120732);
      return locala;
    }
    finally {}
  }
  
  private void bYV()
  {
    try
    {
      AppMethodBeat.i(120734);
      Intent localIntent = new Intent(this.mContext, CDNDownloadServiceSlot.class);
      try
      {
        ad.i("MicroMsg.CDNDownloadClient", "bindService: ".concat(String.valueOf(this.mContext.bindService(localIntent, this.oRd, 1))));
        AppMethodBeat.o(120734);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.CDNDownloadClient", "bindService: " + localException.getMessage());
          AppMethodBeat.o(120734);
        }
      }
      return;
    }
    finally {}
  }
  
  private void c(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120741);
    this.oRb.add(paramCDNTaskInfo);
    com.tencent.mm.plugin.cdndownloader.f.b.a(e(paramCDNTaskInfo));
    AppMethodBeat.o(120741);
  }
  
  private void d(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120742);
    this.oRb.remove(paramCDNTaskInfo);
    com.tencent.mm.plugin.cdndownloader.f.b.Zy(paramCDNTaskInfo.downloadUrl);
    AppMethodBeat.o(120742);
  }
  
  private static com.tencent.mm.plugin.cdndownloader.f.a e(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120743);
    com.tencent.mm.plugin.cdndownloader.f.a locala = new com.tencent.mm.plugin.cdndownloader.f.a();
    locala.field_mediaId = paramCDNTaskInfo.mediaId;
    locala.field_downloadUrlHashCode = paramCDNTaskInfo.downloadUrl.hashCode();
    locala.field_downloadUrl = paramCDNTaskInfo.downloadUrl;
    locala.field_httpsUrl = paramCDNTaskInfo.oRi;
    locala.field_filePath = paramCDNTaskInfo.filePath;
    locala.field_verifyHeaders = paramCDNTaskInfo.oRj;
    locala.field_allowMobileNetDownload = Boolean.valueOf(paramCDNTaskInfo.oRm);
    locala.field_wifiAutoDownload = Boolean.valueOf(paramCDNTaskInfo.oRn);
    locala.field_game_package_download = Boolean.valueOf(paramCDNTaskInfo.fJs);
    AppMethodBeat.o(120743);
    return locala;
  }
  
  public final boolean Zu(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(120736);
        ad.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: ".concat(String.valueOf(paramString)));
        if (bt.isNullOrNil(paramString))
        {
          ad.w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
          AppMethodBeat.o(120736);
          return bool1;
        }
        d(new CDNTaskInfo(paramString));
        com.tencent.mm.plugin.cdndownloader.a.a locala = this.oRa;
        if (locala == null) {}
      }
      finally
      {
        try
        {
          boolean bool2 = this.oRa.Zu(paramString);
          bool1 = bool2;
          AppMethodBeat.o(120736);
        }
        catch (RemoteException paramString)
        {
          ad.e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + paramString.getMessage());
        }
        paramString = finally;
      }
      ad.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
      AppMethodBeat.o(120736);
    }
  }
  
  public final boolean Zv(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(120738);
        ad.i("MicroMsg.CDNDownloadClient", "removeDownloadTask: ".concat(String.valueOf(paramString)));
        if (bt.isNullOrNil(paramString))
        {
          ad.w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
          AppMethodBeat.o(120738);
          return bool1;
        }
        d(new CDNTaskInfo(paramString));
        com.tencent.mm.plugin.cdndownloader.a.a locala = this.oRa;
        if (locala == null) {}
      }
      finally
      {
        try
        {
          boolean bool2 = this.oRa.Zv(paramString);
          bool1 = bool2;
          AppMethodBeat.o(120738);
        }
        catch (RemoteException paramString)
        {
          ad.e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + paramString.getMessage());
        }
        paramString = finally;
      }
      ad.i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
      AppMethodBeat.o(120738);
    }
  }
  
  public final CDNTaskState Zw(String paramString)
  {
    Object localObject3 = null;
    for (;;)
    {
      CDNTaskState localCDNTaskState;
      Object localObject4;
      try
      {
        AppMethodBeat.i(120739);
        ad.i("MicroMsg.CDNDownloadClient", "queryDownloadTask: ".concat(String.valueOf(paramString)));
        if (bt.isNullOrNil(paramString))
        {
          ad.w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
          AppMethodBeat.o(120739);
          paramString = localObject3;
          return paramString;
        }
        if (this.oRa != null)
        {
          ad.d("MicroMsg.CDNDownloadClient", "queryDownloadTask service has connected");
          try
          {
            localCDNTaskState = this.oRa.Zw(paramString);
            if ((localCDNTaskState.taskState != 100) && (localCDNTaskState.taskState != 101)) {
              break label425;
            }
            if (this.oRb.contains(new CDNTaskInfo(paramString))) {
              break label403;
            }
            Object localObject1 = com.tencent.mm.plugin.cdndownloader.f.b.bYP();
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
            if (!this.oRb.contains(new CDNTaskInfo(paramString))) {
              break label455;
            }
          }
          catch (RemoteException localRemoteException)
          {
            ad.e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + localRemoteException.getMessage());
          }
        }
        else
        {
          paramString = new CDNTaskState();
          paramString.taskState = 101;
          AppMethodBeat.o(120739);
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
        ((CDNTaskInfo)localObject4).oRi = localRemoteException.field_httpsUrl;
        ((CDNTaskInfo)localObject4).mediaId = localRemoteException.field_mediaId;
        ((CDNTaskInfo)localObject4).filePath = localRemoteException.field_filePath;
        ((CDNTaskInfo)localObject4).oRj = localRemoteException.field_verifyHeaders;
        ((CDNTaskInfo)localObject4).oRm = localRemoteException.field_allowMobileNetDownload.booleanValue();
        ((CDNTaskInfo)localObject4).oRn = localRemoteException.field_wifiAutoDownload.booleanValue();
        ((CDNTaskInfo)localObject4).fJs = localRemoteException.field_game_package_download.booleanValue();
        ((CDNTaskInfo)localObject4).oRk = 15;
        ((CDNTaskInfo)localObject4).oRl = 3600;
        localObject2 = localObject4;
        label388:
        if (localObject2 != null) {
          this.oRb.add(localObject2);
        }
      }
      for (;;)
      {
        label403:
        AppMethodBeat.o(120739);
        paramString = localCDNTaskState;
        break;
        label415:
        localObject2 = null;
        break label284;
        localObject2 = null;
        break label388;
        label425:
        if (this.oRb.contains(new CDNTaskInfo(paramString))) {
          localCDNTaskState.taskState = 101;
        }
      }
      label455:
      AppMethodBeat.o(120739);
      paramString = localObject3;
    }
  }
  
  public final int a(CDNTaskInfo paramCDNTaskInfo)
  {
    int i = -2;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(120735);
        if ((paramCDNTaskInfo == null) || (bt.isNullOrNil(paramCDNTaskInfo.downloadUrl)))
        {
          ad.w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
          i = -1;
          AppMethodBeat.o(120735);
          return i;
        }
        ad.i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", new Object[] { paramCDNTaskInfo.filePath, paramCDNTaskInfo.downloadUrl });
        if (this.oRb.contains(paramCDNTaskInfo))
        {
          ad.i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
          AppMethodBeat.o(120735);
          continue;
        }
        localObject = Zw(paramCDNTaskInfo.downloadUrl);
      }
      finally {}
      Object localObject;
      if ((localObject != null) && (((CDNTaskState)localObject).taskState == 104) && (i.fv(paramCDNTaskInfo.filePath)))
      {
        ad.i("MicroMsg.CDNDownloadClient", "addDownloadTask, has download success");
        AppMethodBeat.o(120735);
        i = 1;
      }
      else
      {
        localObject = this.oRa;
        if (localObject != null)
        {
          try
          {
            i = this.oRa.a(paramCDNTaskInfo);
            this.oRf.f(paramCDNTaskInfo.mediaId, 1, 0, "");
            if ((i == 0) || (i == -2)) {
              c(paramCDNTaskInfo);
            }
            AppMethodBeat.o(120735);
          }
          catch (RemoteException localRemoteException)
          {
            ad.e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + localRemoteException.getMessage());
          }
        }
        else
        {
          c(paramCDNTaskInfo);
          bYV();
          AppMethodBeat.o(120735);
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
        AppMethodBeat.i(120737);
        if ((paramCDNTaskInfo == null) || (bt.isNullOrNil(paramCDNTaskInfo.downloadUrl)))
        {
          ad.w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
          i = -1;
          AppMethodBeat.o(120737);
          return i;
        }
        ad.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + paramCDNTaskInfo.downloadUrl);
        if (this.oRb.contains(paramCDNTaskInfo))
        {
          ad.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, already in running");
          AppMethodBeat.o(120737);
          continue;
        }
        localObject = Zw(paramCDNTaskInfo.downloadUrl);
      }
      finally {}
      Object localObject;
      if ((localObject != null) && (((CDNTaskState)localObject).taskState == 104) && (i.fv(paramCDNTaskInfo.filePath)))
      {
        ad.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, has download success");
        AppMethodBeat.o(120737);
        i = 1;
      }
      else
      {
        paramCDNTaskInfo.oRo = true;
        localObject = this.oRa;
        if (localObject != null)
        {
          try
          {
            i = this.oRa.b(paramCDNTaskInfo);
            this.oRf.f(paramCDNTaskInfo.mediaId, 1, 0, "");
            if ((i == 0) || (i == -2)) {
              c(paramCDNTaskInfo);
            }
            AppMethodBeat.o(120737);
          }
          catch (RemoteException localRemoteException)
          {
            ad.e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + localRemoteException.getMessage());
          }
        }
        else
        {
          c(paramCDNTaskInfo);
          bYV();
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