package com.tencent.mm.plugin.cdndownloader.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mars.Mars;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g;
import com.tencent.mm.g.g.a;
import com.tencent.mm.ipcinvoker.wx_extension.c.b.a;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.ByteArrayOutputStream;

public class CDNDownloadService
  extends Service
  implements com.tencent.mm.ipcinvoker.wx_extension.c.a
{
  private static com.tencent.mm.plugin.cdndownloader.a.b wOK;
  private static g.a wOW;
  private final a.a wOV;
  
  static
  {
    AppMethodBeat.i(120789);
    wOW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(120780);
        String str1;
        if (paramAnonymousc == null)
        {
          str1 = "null";
          if (paramAnonymousd != null) {
            break label92;
          }
        }
        label92:
        for (String str2 = "null";; str2 = paramAnonymousd.toString())
        {
          Log.d("MicroMsg.CDNDownloadService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label102;
          }
          Log.i("MicroMsg.CDNDownloadService", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(120780);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label102:
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.CDNDownloadService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          CDNDownloadService.ad(paramAnonymousString, 4, paramAnonymousInt);
          AppMethodBeat.o(120780);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          CDNDownloadService.B(paramAnonymousString, paramAnonymousc.field_finishedLength, paramAnonymousc.field_toltalLength);
          AppMethodBeat.o(120780);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label225;
          }
          Log.e("MicroMsg.CDNDownloadService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          CDNDownloadService.ad(paramAnonymousString, 4, paramAnonymousd.field_retCode);
        }
        for (;;)
        {
          AppMethodBeat.o(120780);
          return 0;
          label225:
          Log.i("MicroMsg.CDNDownloadService", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          CDNDownloadService.ad(paramAnonymousString, 3, 0);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    AppMethodBeat.o(120789);
  }
  
  public CDNDownloadService()
  {
    AppMethodBeat.i(120781);
    this.wOV = new a.a()
    {
      public final void IV(int paramAnonymousInt)
      {
        AppMethodBeat.i(120777);
        Log.i("MicroMsg.CDNDownloadService", "notifyNetworkChange: ".concat(String.valueOf(paramAnonymousInt)));
        if (!MMApplicationContext.isPushProcess()) {
          Mars.onNetworkChange();
        }
        AppMethodBeat.o(120777);
      }
      
      public final int a(CDNTaskInfo paramAnonymousCDNTaskInfo)
      {
        AppMethodBeat.i(120770);
        Log.i("MicroMsg.CDNDownloadService", "addDownloadTask: %s filepath:%s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl, paramAnonymousCDNTaskInfo.filePath });
        g localg = new g();
        localg.taskName = "task_CDNDownloadService_1";
        localg.lwU = paramAnonymousCDNTaskInfo.lwU;
        localg.field_mediaId = paramAnonymousCDNTaskInfo.mediaId;
        localg.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
        localg.lwO = com.tencent.mm.plugin.downloader.a.c.amF(paramAnonymousCDNTaskInfo.downloadUrl);
        localg.lwV = com.tencent.mm.plugin.downloader.a.c.amF(paramAnonymousCDNTaskInfo.wON);
        localg.lwL = CDNDownloadService.dqf();
        localg.lwP = paramAnonymousCDNTaskInfo.wOP;
        localg.lwQ = paramAnonymousCDNTaskInfo.wOQ;
        localg.allow_mobile_net_download = paramAnonymousCDNTaskInfo.wOR;
        localg.lwT = paramAnonymousCDNTaskInfo.wOS;
        CDNDownloadService.a(localg, paramAnonymousCDNTaskInfo.wOO);
        int i = com.tencent.mm.plugin.cdndownloader.c.a.dpY().i(localg);
        Log.i("MicroMsg.CDNDownloadService", "addDownloadTask: ".concat(String.valueOf(i)));
        AppMethodBeat.o(120770);
        return i;
      }
      
      public final void a(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
      {
        AppMethodBeat.i(120775);
        Log.i("MicroMsg.CDNDownloadService", "registerCallback");
        CDNDownloadService.c(paramAnonymousb);
        AppMethodBeat.o(120775);
      }
      
      public final boolean alJ(String paramAnonymousString)
      {
        AppMethodBeat.i(120772);
        boolean bool = com.tencent.mm.plugin.cdndownloader.c.a.dpY().Nz(paramAnonymousString);
        Log.i("MicroMsg.CDNDownloadService", "pauseDownloadTask: ".concat(String.valueOf(bool)));
        AppMethodBeat.o(120772);
        return bool;
      }
      
      public final boolean alK(String paramAnonymousString)
      {
        AppMethodBeat.i(120773);
        boolean bool = com.tencent.mm.plugin.cdndownloader.c.a.dpY().alM(paramAnonymousString);
        Log.i("MicroMsg.CDNDownloadService", "removeDownloadTask: ".concat(String.valueOf(bool)));
        AppMethodBeat.o(120773);
        return bool;
      }
      
      public final CDNTaskState alL(String paramAnonymousString)
      {
        AppMethodBeat.i(120774);
        paramAnonymousString = CdnLogic.httpMultiSocketDownloadTaskState(paramAnonymousString);
        CDNTaskState localCDNTaskState = new CDNTaskState();
        if (paramAnonymousString != null)
        {
          localCDNTaskState.taskState = paramAnonymousString.taskState;
          localCDNTaskState.fileTotalSize = ((int)paramAnonymousString.fileTotalSize);
          localCDNTaskState.completeSize = ((int)paramAnonymousString.completeSize);
        }
        AppMethodBeat.o(120774);
        return localCDNTaskState;
      }
      
      public final int b(CDNTaskInfo paramAnonymousCDNTaskInfo)
      {
        AppMethodBeat.i(120771);
        Log.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: %s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl });
        g localg = new g();
        localg.taskName = "task_CDNDownloadService_2";
        localg.lwU = paramAnonymousCDNTaskInfo.lwU;
        localg.field_mediaId = paramAnonymousCDNTaskInfo.mediaId;
        localg.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
        localg.lwO = com.tencent.mm.plugin.downloader.a.c.amF(paramAnonymousCDNTaskInfo.downloadUrl);
        localg.lwV = com.tencent.mm.plugin.downloader.a.c.amF(paramAnonymousCDNTaskInfo.wON);
        localg.lwL = CDNDownloadService.dqf();
        localg.lwP = paramAnonymousCDNTaskInfo.wOP;
        localg.lwQ = paramAnonymousCDNTaskInfo.wOQ;
        localg.lwT = paramAnonymousCDNTaskInfo.wOS;
        localg.allow_mobile_net_download = paramAnonymousCDNTaskInfo.wOR;
        localg.is_resume_task = true;
        CDNDownloadService.a(localg, paramAnonymousCDNTaskInfo.wOO);
        int i = com.tencent.mm.plugin.cdndownloader.c.a.dpY().j(localg);
        Log.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: ".concat(String.valueOf(i)));
        AppMethodBeat.o(120771);
        return i;
      }
      
      public final void b(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
      {
        AppMethodBeat.i(120776);
        CDNDownloadService.c(null);
        AppMethodBeat.o(120776);
      }
      
      public final void dpT()
      {
        AppMethodBeat.i(120778);
        if (!b.a.aYK().c(CDNDownloadService.this))
        {
          Log.i("MicroMsg.CDNDownloadService", "addIPCTaskMarker");
          b.a.aYK().a(CDNDownloadService.this);
        }
        AppMethodBeat.o(120778);
      }
      
      public final void dpU()
      {
        AppMethodBeat.i(120779);
        Log.i("MicroMsg.CDNDownloadService", "removeIPCTaskMarker");
        b.a.aYK().b(CDNDownloadService.this);
        AppMethodBeat.o(120779);
      }
      
      public final void dpV() {}
    };
    AppMethodBeat.o(120781);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(120782);
    Log.i("MicroMsg.CDNDownloadService", "onBind");
    paramIntent = this.wOV;
    AppMethodBeat.o(120782);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(120784);
    super.onCreate();
    Log.i("MicroMsg.CDNDownloadService", "onCreate");
    AppMethodBeat.o(120784);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120785);
    super.onDestroy();
    Log.i("MicroMsg.CDNDownloadService", "onDestroy");
    b.a.aYK().b(this);
    h.OAn.idkeyStat(710L, 1L, 1L, false);
    AppMethodBeat.o(120785);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(120783);
    Log.i("MicroMsg.CDNDownloadService", "onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(120783);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService
 * JD-Core Version:    0.7.0.1
 */