package com.tencent.mm.plugin.cdndownloader.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.mm.ipcinvoker.wx_extension.b.b.a;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public class CDNDownloadService
  extends Service
  implements com.tencent.mm.ipcinvoker.wx_extension.b.a
{
  private static com.tencent.mm.plugin.cdndownloader.a.b iAE;
  private static f.a iAQ = new f.a()
  {
    public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.j.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
    {
      String str1;
      String str2;
      if (paramAnonymousc == null)
      {
        str1 = "null";
        if (paramAnonymousd != null) {
          break label82;
        }
        str2 = "null";
        label17:
        y.d("MicroMsg.CDNDownloadService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
        if (paramAnonymousInt != -21006) {
          break label92;
        }
        y.i("MicroMsg.CDNDownloadService", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
      }
      label82:
      label92:
      do
      {
        return 0;
        str1 = paramAnonymousc.toString();
        break;
        str2 = paramAnonymousd.toString();
        break label17;
        if (paramAnonymousInt != 0)
        {
          y.e("MicroMsg.CDNDownloadService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          CDNDownloadService.K(paramAnonymousString, 4, paramAnonymousInt);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          CDNDownloadService.n(paramAnonymousString, paramAnonymousc.field_finishedLength, paramAnonymousc.field_toltalLength);
          return 0;
        }
      } while (paramAnonymousd == null);
      if (paramAnonymousd.field_retCode != 0)
      {
        y.e("MicroMsg.CDNDownloadService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
        CDNDownloadService.K(paramAnonymousString, 4, paramAnonymousd.field_retCode);
        return 0;
      }
      y.i("MicroMsg.CDNDownloadService", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
      CDNDownloadService.K(paramAnonymousString, 3, 0);
      return 0;
    }
    
    public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
    
    public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
    {
      return new byte[0];
    }
  };
  private final a.a iAP = new a.a()
  {
    public final int a(CDNTaskInfo paramAnonymousCDNTaskInfo)
    {
      y.i("MicroMsg.CDNDownloadService", "addDownloadTask: %s filepath:%s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl, paramAnonymousCDNTaskInfo.filePath });
      f localf = new f();
      localf.dlW = paramAnonymousCDNTaskInfo.dlW;
      localf.field_mediaId = paramAnonymousCDNTaskInfo.bUi;
      localf.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
      localf.dlQ = paramAnonymousCDNTaskInfo.downloadUrl;
      localf.dlX = paramAnonymousCDNTaskInfo.iAH;
      localf.dlP = CDNDownloadService.aDC();
      localf.dlR = paramAnonymousCDNTaskInfo.iAJ;
      localf.dlS = paramAnonymousCDNTaskInfo.iAK;
      localf.allow_mobile_net_download = paramAnonymousCDNTaskInfo.iAL;
      localf.dlV = paramAnonymousCDNTaskInfo.iAM;
      CDNDownloadService.a(localf, paramAnonymousCDNTaskInfo.iAI);
      int i = com.tencent.mm.plugin.cdndownloader.c.a.aDv().d(localf);
      y.i("MicroMsg.CDNDownloadService", "addDownloadTask: " + i);
      return i;
    }
    
    public final void a(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
    {
      y.i("MicroMsg.CDNDownloadService", "registerCallback");
      CDNDownloadService.c(paramAnonymousb);
    }
    
    public final void aDs()
    {
      if (!b.a.Cg().c(CDNDownloadService.this))
      {
        y.i("MicroMsg.CDNDownloadService", "addIPCTaskMarker");
        b.a.Cg().a(CDNDownloadService.this);
      }
    }
    
    public final void aDt()
    {
      y.i("MicroMsg.CDNDownloadService", "removeIPCTaskMarker");
      b.a.Cg().b(CDNDownloadService.this);
    }
    
    public final void aDu() {}
    
    public final int b(CDNTaskInfo paramAnonymousCDNTaskInfo)
    {
      y.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: %s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl });
      f localf = new f();
      localf.dlW = paramAnonymousCDNTaskInfo.dlW;
      localf.field_mediaId = paramAnonymousCDNTaskInfo.bUi;
      localf.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
      localf.dlQ = paramAnonymousCDNTaskInfo.downloadUrl;
      localf.dlX = paramAnonymousCDNTaskInfo.iAH;
      localf.dlP = CDNDownloadService.aDC();
      localf.dlR = paramAnonymousCDNTaskInfo.iAJ;
      localf.dlS = paramAnonymousCDNTaskInfo.iAK;
      localf.dlV = paramAnonymousCDNTaskInfo.iAM;
      localf.allow_mobile_net_download = paramAnonymousCDNTaskInfo.iAL;
      CDNDownloadService.a(localf, paramAnonymousCDNTaskInfo.iAI);
      paramAnonymousCDNTaskInfo = com.tencent.mm.plugin.cdndownloader.c.a.aDv();
      int i;
      if (paramAnonymousCDNTaskInfo.eiI.containsKey(localf.field_mediaId))
      {
        i = CdnLogic.resumeHttpMultiSocketDownloadTask(localf.field_mediaId);
        y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task resume mediaid:%s, ret:%d", new Object[] { localf.field_mediaId, Integer.valueOf(i) });
      }
      for (;;)
      {
        y.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: " + i);
        return i;
        y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra resumeRecvTask task add new mediaid:%s", new Object[] { localf.field_mediaId });
        i = paramAnonymousCDNTaskInfo.d(localf);
      }
    }
    
    public final void b(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
    {
      CDNDownloadService.c(null);
    }
    
    public final void pi(int paramAnonymousInt)
    {
      y.i("MicroMsg.CDNDownloadService", "notifyNetworkChange: " + paramAnonymousInt);
      BaseEvent.onNetworkChange();
    }
    
    public final boolean zf(String paramAnonymousString)
    {
      com.tencent.mm.plugin.cdndownloader.c.a.aDv();
      boolean bool = com.tencent.mm.plugin.cdndownloader.c.a.zi(paramAnonymousString);
      y.i("MicroMsg.CDNDownloadService", "pauseDownloadTask: " + bool);
      return bool;
    }
    
    public final boolean zg(String paramAnonymousString)
    {
      com.tencent.mm.plugin.cdndownloader.c.a locala = com.tencent.mm.plugin.cdndownloader.c.a.aDv();
      f localf = (f)locala.eiI.remove(paramAnonymousString);
      if (localf != null)
      {
        if ((localf.field_fileType != com.tencent.mm.j.a.dlx) && (localf.field_fileType != com.tencent.mm.j.a.dlz)) {
          break label157;
        }
        locala.Ne();
        com.tencent.mm.ak.a.lI(paramAnonymousString);
      }
      for (;;)
      {
        h.nFQ.f(10769, new Object[] { Integer.valueOf(com.tencent.mm.ak.c.ejc), Integer.valueOf(localf.field_fileType), Long.valueOf(bk.UY() - localf.field_startTime) });
        locala.eiH.remove(paramAnonymousString);
        locala.eiJ.remove(paramAnonymousString);
        y.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", new Object[] { paramAnonymousString, localf, Integer.valueOf(0) });
        y.i("MicroMsg.CDNDownloadService", "removeDownloadTask: true");
        return true;
        label157:
        if (localf.dlW)
        {
          locala.Ne();
          com.tencent.mm.ak.a.lJ(paramAnonymousString);
        }
        else
        {
          locala.Ne();
          com.tencent.mm.ak.a.lE(paramAnonymousString);
        }
      }
    }
    
    public final CDNTaskState zh(String paramAnonymousString)
    {
      paramAnonymousString = CdnLogic.httpMultiSocketDownloadTaskState(paramAnonymousString);
      CDNTaskState localCDNTaskState = new CDNTaskState();
      if (paramAnonymousString != null)
      {
        localCDNTaskState.taskState = paramAnonymousString.taskState;
        localCDNTaskState.fileTotalSize = paramAnonymousString.fileTotalSize;
        localCDNTaskState.completeSize = paramAnonymousString.completeSize;
      }
      return localCDNTaskState;
    }
  };
  
  public IBinder onBind(Intent paramIntent)
  {
    y.i("MicroMsg.CDNDownloadService", "onBind");
    return this.iAP;
  }
  
  public void onCreate()
  {
    super.onCreate();
    y.i("MicroMsg.CDNDownloadService", "onCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.CDNDownloadService", "onDestroy");
    b.a.Cg().b(this);
    h.nFQ.a(710L, 1L, 1L, false);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    y.i("MicroMsg.CDNDownloadService", "onUnbind");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService
 * JD-Core Version:    0.7.0.1
 */