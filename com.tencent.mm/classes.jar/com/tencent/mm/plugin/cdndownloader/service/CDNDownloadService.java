package com.tencent.mm.plugin.cdndownloader.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mars.Mars;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.wx_extension.c.b.a;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.ByteArrayOutputStream;

public class CDNDownloadService
  extends Service
  implements com.tencent.mm.ipcinvoker.wx_extension.c.a
{
  private static com.tencent.mm.plugin.cdndownloader.a.b oXH;
  private static g.a oXT;
  private final a.a oXS;
  
  static
  {
    AppMethodBeat.i(120789);
    oXT = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
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
          ae.d("MicroMsg.CDNDownloadService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label102;
          }
          ae.i("MicroMsg.CDNDownloadService", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(120780);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label102:
        if (paramAnonymousInt != 0)
        {
          ae.e("MicroMsg.CDNDownloadService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          CDNDownloadService.W(paramAnonymousString, 4, paramAnonymousInt);
          AppMethodBeat.o(120780);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          CDNDownloadService.x(paramAnonymousString, paramAnonymousc.field_finishedLength, paramAnonymousc.field_toltalLength);
          AppMethodBeat.o(120780);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label225;
          }
          ae.e("MicroMsg.CDNDownloadService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          CDNDownloadService.W(paramAnonymousString, 4, paramAnonymousd.field_retCode);
        }
        for (;;)
        {
          AppMethodBeat.o(120780);
          return 0;
          label225:
          ae.i("MicroMsg.CDNDownloadService", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          CDNDownloadService.W(paramAnonymousString, 3, 0);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    AppMethodBeat.o(120789);
  }
  
  public CDNDownloadService()
  {
    AppMethodBeat.i(120781);
    this.oXS = new a.a()
    {
      public final void Bd(int paramAnonymousInt)
      {
        AppMethodBeat.i(120777);
        ae.i("MicroMsg.CDNDownloadService", "notifyNetworkChange: ".concat(String.valueOf(paramAnonymousInt)));
        if (!ak.foA()) {
          Mars.onNetworkChange();
        }
        AppMethodBeat.o(120777);
      }
      
      public final int a(CDNTaskInfo paramAnonymousCDNTaskInfo)
      {
        AppMethodBeat.i(120770);
        ae.i("MicroMsg.CDNDownloadService", "addDownloadTask: %s filepath:%s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl, paramAnonymousCDNTaskInfo.filePath });
        com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
        localg.fLl = "task_CDNDownloadService_1";
        localg.fLv = paramAnonymousCDNTaskInfo.fLv;
        localg.field_mediaId = paramAnonymousCDNTaskInfo.mediaId;
        localg.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
        localg.fLp = com.tencent.mm.plugin.downloader.a.c.aaQ(paramAnonymousCDNTaskInfo.downloadUrl);
        localg.fLw = com.tencent.mm.plugin.downloader.a.c.aaQ(paramAnonymousCDNTaskInfo.oXK);
        localg.fLm = CDNDownloadService.cap();
        localg.fLq = paramAnonymousCDNTaskInfo.oXM;
        localg.fLr = paramAnonymousCDNTaskInfo.oXN;
        localg.allow_mobile_net_download = paramAnonymousCDNTaskInfo.oXO;
        localg.fLu = paramAnonymousCDNTaskInfo.oXP;
        CDNDownloadService.a(localg, paramAnonymousCDNTaskInfo.oXL);
        int i = com.tencent.mm.plugin.cdndownloader.c.a.cai().h(localg);
        ae.i("MicroMsg.CDNDownloadService", "addDownloadTask: ".concat(String.valueOf(i)));
        AppMethodBeat.o(120770);
        return i;
      }
      
      public final void a(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
      {
        AppMethodBeat.i(120775);
        ae.i("MicroMsg.CDNDownloadService", "registerCallback");
        CDNDownloadService.c(paramAnonymousb);
        AppMethodBeat.o(120775);
      }
      
      public final boolean aal(String paramAnonymousString)
      {
        AppMethodBeat.i(120772);
        com.tencent.mm.plugin.cdndownloader.c.a.cai();
        boolean bool = com.tencent.mm.plugin.cdndownloader.c.a.aao(paramAnonymousString);
        ae.i("MicroMsg.CDNDownloadService", "pauseDownloadTask: ".concat(String.valueOf(bool)));
        AppMethodBeat.o(120772);
        return bool;
      }
      
      public final boolean aam(String paramAnonymousString)
      {
        AppMethodBeat.i(120773);
        com.tencent.mm.plugin.cdndownloader.c.a.cai().Fs(paramAnonymousString);
        ae.i("MicroMsg.CDNDownloadService", "removeDownloadTask: true");
        AppMethodBeat.o(120773);
        return true;
      }
      
      public final CDNTaskState aan(String paramAnonymousString)
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
        ae.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: %s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl });
        com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
        localg.fLl = "task_CDNDownloadService_2";
        localg.fLv = paramAnonymousCDNTaskInfo.fLv;
        localg.field_mediaId = paramAnonymousCDNTaskInfo.mediaId;
        localg.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
        localg.fLp = com.tencent.mm.plugin.downloader.a.c.aaQ(paramAnonymousCDNTaskInfo.downloadUrl);
        localg.fLw = com.tencent.mm.plugin.downloader.a.c.aaQ(paramAnonymousCDNTaskInfo.oXK);
        localg.fLm = CDNDownloadService.cap();
        localg.fLq = paramAnonymousCDNTaskInfo.oXM;
        localg.fLr = paramAnonymousCDNTaskInfo.oXN;
        localg.fLu = paramAnonymousCDNTaskInfo.oXP;
        localg.allow_mobile_net_download = paramAnonymousCDNTaskInfo.oXO;
        CDNDownloadService.a(localg, paramAnonymousCDNTaskInfo.oXL);
        int i = com.tencent.mm.plugin.cdndownloader.c.a.cai().i(localg);
        ae.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: ".concat(String.valueOf(i)));
        AppMethodBeat.o(120771);
        return i;
      }
      
      public final void b(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
      {
        AppMethodBeat.i(120776);
        CDNDownloadService.c(null);
        AppMethodBeat.o(120776);
      }
      
      public final void caf()
      {
        AppMethodBeat.i(120778);
        if (!b.a.aic().c(CDNDownloadService.this))
        {
          ae.i("MicroMsg.CDNDownloadService", "addIPCTaskMarker");
          b.a.aic().a(CDNDownloadService.this);
        }
        AppMethodBeat.o(120778);
      }
      
      public final void cag()
      {
        AppMethodBeat.i(120779);
        ae.i("MicroMsg.CDNDownloadService", "removeIPCTaskMarker");
        b.a.aic().b(CDNDownloadService.this);
        AppMethodBeat.o(120779);
      }
      
      public final void cah() {}
    };
    AppMethodBeat.o(120781);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(120782);
    ae.i("MicroMsg.CDNDownloadService", "onBind");
    paramIntent = this.oXS;
    AppMethodBeat.o(120782);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(120784);
    super.onCreate();
    ae.i("MicroMsg.CDNDownloadService", "onCreate");
    AppMethodBeat.o(120784);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120785);
    super.onDestroy();
    ae.i("MicroMsg.CDNDownloadService", "onDestroy");
    b.a.aic().b(this);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 1L, 1L, false);
    AppMethodBeat.o(120785);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(120783);
    ae.i("MicroMsg.CDNDownloadService", "onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(120783);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService
 * JD-Core Version:    0.7.0.1
 */