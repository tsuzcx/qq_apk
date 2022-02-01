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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.Set;

public final class a
  implements com.tencent.mm.ipcinvoker.wx_extension.c.a
{
  private static final Object oXB;
  private static a oXy;
  private Context mContext;
  private long oXA;
  com.tencent.mm.plugin.cdndownloader.a.a oXC;
  private Set<CDNTaskInfo> oXD;
  public b oXE;
  private ServiceConnection oXF;
  private aw oXG;
  private com.tencent.mm.plugin.cdndownloader.a.b oXH;
  private n.a oXI;
  private long oXz;
  
  static
  {
    AppMethodBeat.i(120754);
    oXB = new Object();
    AppMethodBeat.o(120754);
  }
  
  public a()
  {
    AppMethodBeat.i(120733);
    this.oXz = 0L;
    this.oXA = 0L;
    this.oXD = new com.tencent.mm.plugin.cdndownloader.e.a(new com.tencent.mm.plugin.cdndownloader.e.b()
    {
      public final void cal()
      {
        AppMethodBeat.i(120723);
        ae.i("MicroMsg.CDNDownloadClient", "notify add");
        a.a(a.this);
        a.b(a.this);
        AppMethodBeat.o(120723);
      }
      
      public final void clear()
      {
        AppMethodBeat.i(120725);
        ae.i("MicroMsg.CDNDownloadClient", "notify clear");
        a.d(a.this);
        a.e(a.this);
        AppMethodBeat.o(120725);
      }
      
      public final void remove()
      {
        AppMethodBeat.i(120724);
        ae.i("MicroMsg.CDNDownloadClient", "notify remove");
        if (a.c(a.this).size() == 0)
        {
          a.d(a.this);
          a.e(a.this);
        }
        AppMethodBeat.o(120724);
      }
    });
    this.oXF = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
      {
        AppMethodBeat.i(120726);
        ae.i("MicroMsg.CDNDownloadClient", "onServiceConnected");
        a.a(a.this, a.a.u(paramAnonymousIBinder));
        a.f(a.this);
        a.g(a.this);
        try
        {
          synchronized (a.oXB)
          {
            a.oXB.notifyAll();
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
        ae.i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
        if (a.c(a.this).size() != 0)
        {
          paramAnonymousComponentName = a.c(a.this).iterator();
          while (paramAnonymousComponentName.hasNext()) {
            ((CDNTaskInfo)paramAnonymousComponentName.next()).oXQ = true;
          }
        }
        AppMethodBeat.o(120727);
      }
    };
    this.oXG = new aw(p.ahT().getLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(120728);
        ae.d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
        if (a.c(a.this).size() == 0)
        {
          AppMethodBeat.o(120728);
          return false;
        }
        if (a.h(a.this) != null) {}
        try
        {
          ae.d("MicroMsg.CDNDownloadClient", "checkActive");
          a.h(a.this).cah();
          AppMethodBeat.o(120728);
          return true;
        }
        catch (RemoteException localRemoteException)
        {
          ae.e("MicroMsg.CDNDownloadClient", "check process active false");
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 3L, 1L, false);
          if (a.i(a.this))
          {
            a.a(a.this, System.currentTimeMillis());
            localIterator = a.c(a.this).iterator();
            while (localIterator.hasNext()) {
              ((CDNTaskInfo)localIterator.next()).oXQ = true;
            }
            a.j(a.this);
            AppMethodBeat.o(120728);
            return true;
          }
          ae.i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 4L, 1L, false);
          Iterator localIterator = a.c(a.this).iterator();
          while (localIterator.hasNext())
          {
            CDNTaskInfo localCDNTaskInfo = (CDNTaskInfo)localIterator.next();
            a.k(a.this).g(localCDNTaskInfo.downloadUrl, 4, com.tencent.mm.plugin.downloader.a.a.ppJ, null);
          }
          a.l(a.this);
          AppMethodBeat.o(120728);
        }
        return false;
      }
    }, true);
    this.oXH = new b.a()
    {
      public final void f(String paramAnonymousString1, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        AppMethodBeat.i(120729);
        ae.i("MicroMsg.CDNDownloadClient", "onDownloadStateChange, mediaId = %s, state = %d, errCode = %d, errMsg = %s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString2 });
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
        ae.d("MicroMsg.CDNDownloadClient", "onDownloadProgressChange, mediaId = %s, receiveLen = %d, totalLen = %d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        if (a.k(a.this) != null) {
          a.k(a.this).w(paramAnonymousString, paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(120730);
      }
    };
    this.oXI = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(120731);
        a locala = a.this;
        ae.i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: ".concat(String.valueOf(paramAnonymousInt)));
        if (locala.oXC != null) {
          try
          {
            locala.oXC.Bd(paramAnonymousInt);
            AppMethodBeat.o(120731);
            return;
          }
          catch (RemoteException localRemoteException) {}
        }
        AppMethodBeat.o(120731);
      }
    };
    this.mContext = ak.getContext();
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().a(this.oXI);
    cak();
    AppMethodBeat.o(120733);
  }
  
  private void c(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120741);
    this.oXD.add(paramCDNTaskInfo);
    com.tencent.mm.plugin.cdndownloader.f.b.a(e(paramCDNTaskInfo));
    AppMethodBeat.o(120741);
  }
  
  private void caf()
  {
    AppMethodBeat.i(120740);
    if (this.oXC != null) {
      try
      {
        this.oXC.caf();
        AppMethodBeat.o(120740);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ae.e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: ".concat(String.valueOf(localRemoteException)));
      }
    }
    AppMethodBeat.o(120740);
  }
  
  public static a caj()
  {
    try
    {
      AppMethodBeat.i(120732);
      if (oXy == null) {
        oXy = new a();
      }
      a locala = oXy;
      AppMethodBeat.o(120732);
      return locala;
    }
    finally {}
  }
  
  private void cak()
  {
    try
    {
      AppMethodBeat.i(120734);
      Intent localIntent = new Intent(this.mContext, CDNDownloadServiceSlot.class);
      try
      {
        ae.i("MicroMsg.CDNDownloadClient", "bindService: ".concat(String.valueOf(this.mContext.bindService(localIntent, this.oXF, 1))));
        AppMethodBeat.o(120734);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.CDNDownloadClient", "bindService: " + localException.getMessage());
          AppMethodBeat.o(120734);
        }
      }
      return;
    }
    finally {}
  }
  
  private void d(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120742);
    this.oXD.remove(paramCDNTaskInfo);
    com.tencent.mm.plugin.cdndownloader.f.b.aap(paramCDNTaskInfo.downloadUrl);
    AppMethodBeat.o(120742);
  }
  
  private static com.tencent.mm.plugin.cdndownloader.f.a e(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120743);
    com.tencent.mm.plugin.cdndownloader.f.a locala = new com.tencent.mm.plugin.cdndownloader.f.a();
    locala.field_mediaId = paramCDNTaskInfo.mediaId;
    locala.field_downloadUrlHashCode = paramCDNTaskInfo.downloadUrl.hashCode();
    locala.field_downloadUrl = paramCDNTaskInfo.downloadUrl;
    locala.field_httpsUrl = paramCDNTaskInfo.oXK;
    locala.field_filePath = paramCDNTaskInfo.filePath;
    locala.field_verifyHeaders = paramCDNTaskInfo.oXL;
    locala.field_allowMobileNetDownload = Boolean.valueOf(paramCDNTaskInfo.oXO);
    locala.field_wifiAutoDownload = Boolean.valueOf(paramCDNTaskInfo.oXP);
    locala.field_game_package_download = Boolean.valueOf(paramCDNTaskInfo.fLv);
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
        if ((paramCDNTaskInfo == null) || (bu.isNullOrNil(paramCDNTaskInfo.downloadUrl)))
        {
          ae.w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
          i = -1;
          AppMethodBeat.o(120735);
          return i;
        }
        ae.i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", new Object[] { paramCDNTaskInfo.filePath, paramCDNTaskInfo.downloadUrl });
        if (this.oXD.contains(paramCDNTaskInfo))
        {
          ae.i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
          AppMethodBeat.o(120735);
          continue;
        }
        localObject = aan(paramCDNTaskInfo.downloadUrl);
      }
      finally {}
      Object localObject;
      if ((localObject != null) && (((CDNTaskState)localObject).taskState == 104) && (o.fB(paramCDNTaskInfo.filePath)))
      {
        ae.i("MicroMsg.CDNDownloadClient", "addDownloadTask, has download success");
        AppMethodBeat.o(120735);
        i = 1;
      }
      else
      {
        localObject = this.oXC;
        if (localObject != null)
        {
          try
          {
            i = this.oXC.a(paramCDNTaskInfo);
            this.oXH.f(paramCDNTaskInfo.mediaId, 1, 0, "");
            if ((i == 0) || (i == -2)) {
              c(paramCDNTaskInfo);
            }
            AppMethodBeat.o(120735);
          }
          catch (RemoteException localRemoteException)
          {
            ae.e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + localRemoteException.getMessage());
          }
        }
        else
        {
          c(paramCDNTaskInfo);
          cak();
          AppMethodBeat.o(120735);
          i = 0;
        }
      }
    }
  }
  
  public final boolean aal(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(120736);
        ae.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: ".concat(String.valueOf(paramString)));
        if (bu.isNullOrNil(paramString))
        {
          ae.w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
          AppMethodBeat.o(120736);
          return bool1;
        }
        d(new CDNTaskInfo(paramString));
        com.tencent.mm.plugin.cdndownloader.a.a locala = this.oXC;
        if (locala == null) {}
      }
      finally
      {
        try
        {
          boolean bool2 = this.oXC.aal(paramString);
          bool1 = bool2;
          AppMethodBeat.o(120736);
        }
        catch (RemoteException paramString)
        {
          ae.e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + paramString.getMessage());
        }
        paramString = finally;
      }
      ae.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
      AppMethodBeat.o(120736);
    }
  }
  
  public final boolean aam(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(120738);
        ae.i("MicroMsg.CDNDownloadClient", "removeDownloadTask: ".concat(String.valueOf(paramString)));
        if (bu.isNullOrNil(paramString))
        {
          ae.w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
          AppMethodBeat.o(120738);
          return bool1;
        }
        d(new CDNTaskInfo(paramString));
        com.tencent.mm.plugin.cdndownloader.a.a locala = this.oXC;
        if (locala == null) {}
      }
      finally
      {
        try
        {
          boolean bool2 = this.oXC.aam(paramString);
          bool1 = bool2;
          AppMethodBeat.o(120738);
        }
        catch (RemoteException paramString)
        {
          ae.e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + paramString.getMessage());
        }
        paramString = finally;
      }
      ae.i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
      AppMethodBeat.o(120738);
    }
  }
  
  public final CDNTaskState aan(String paramString)
  {
    Object localObject3 = null;
    for (;;)
    {
      CDNTaskState localCDNTaskState;
      Object localObject4;
      try
      {
        AppMethodBeat.i(120739);
        ae.i("MicroMsg.CDNDownloadClient", "queryDownloadTask: ".concat(String.valueOf(paramString)));
        if (bu.isNullOrNil(paramString))
        {
          ae.w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
          AppMethodBeat.o(120739);
          paramString = localObject3;
          return paramString;
        }
        if (this.oXC != null)
        {
          ae.d("MicroMsg.CDNDownloadClient", "queryDownloadTask service has connected");
          try
          {
            localCDNTaskState = this.oXC.aan(paramString);
            if ((localCDNTaskState.taskState != 100) && (localCDNTaskState.taskState != 101)) {
              break label425;
            }
            if (this.oXD.contains(new CDNTaskInfo(paramString))) {
              break label403;
            }
            Object localObject1 = com.tencent.mm.plugin.cdndownloader.f.b.cae();
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
            if (!this.oXD.contains(new CDNTaskInfo(paramString))) {
              break label455;
            }
          }
          catch (RemoteException localRemoteException)
          {
            ae.e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + localRemoteException.getMessage());
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
        ((CDNTaskInfo)localObject4).oXK = localRemoteException.field_httpsUrl;
        ((CDNTaskInfo)localObject4).mediaId = localRemoteException.field_mediaId;
        ((CDNTaskInfo)localObject4).filePath = localRemoteException.field_filePath;
        ((CDNTaskInfo)localObject4).oXL = localRemoteException.field_verifyHeaders;
        ((CDNTaskInfo)localObject4).oXO = localRemoteException.field_allowMobileNetDownload.booleanValue();
        ((CDNTaskInfo)localObject4).oXP = localRemoteException.field_wifiAutoDownload.booleanValue();
        ((CDNTaskInfo)localObject4).fLv = localRemoteException.field_game_package_download.booleanValue();
        ((CDNTaskInfo)localObject4).oXM = 15;
        ((CDNTaskInfo)localObject4).oXN = 3600;
        localObject2 = localObject4;
        label388:
        if (localObject2 != null) {
          this.oXD.add(localObject2);
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
        if (this.oXD.contains(new CDNTaskInfo(paramString))) {
          localCDNTaskState.taskState = 101;
        }
      }
      label455:
      AppMethodBeat.o(120739);
      paramString = localObject3;
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
        if ((paramCDNTaskInfo == null) || (bu.isNullOrNil(paramCDNTaskInfo.downloadUrl)))
        {
          ae.w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
          i = -1;
          AppMethodBeat.o(120737);
          return i;
        }
        ae.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + paramCDNTaskInfo.downloadUrl);
        if (this.oXD.contains(paramCDNTaskInfo))
        {
          ae.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, already in running");
          AppMethodBeat.o(120737);
          continue;
        }
        localObject = aan(paramCDNTaskInfo.downloadUrl);
      }
      finally {}
      Object localObject;
      if ((localObject != null) && (((CDNTaskState)localObject).taskState == 104) && (o.fB(paramCDNTaskInfo.filePath)))
      {
        ae.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, has download success");
        AppMethodBeat.o(120737);
        i = 1;
      }
      else
      {
        paramCDNTaskInfo.oXQ = true;
        localObject = this.oXC;
        if (localObject != null)
        {
          try
          {
            i = this.oXC.b(paramCDNTaskInfo);
            this.oXH.f(paramCDNTaskInfo.mediaId, 1, 0, "");
            if ((i == 0) || (i == -2)) {
              c(paramCDNTaskInfo);
            }
            AppMethodBeat.o(120737);
          }
          catch (RemoteException localRemoteException)
          {
            ae.e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + localRemoteException.getMessage());
          }
        }
        else
        {
          c(paramCDNTaskInfo);
          cak();
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