package com.tencent.mm.plugin.cdndownloader.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mars.Mars;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.ipcinvoker.wx_extension.b.b.a;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.io.ByteArrayOutputStream;

public class CDNDownloadService
  extends Service
  implements com.tencent.mm.ipcinvoker.wx_extension.b.a
{
  private static com.tencent.mm.plugin.cdndownloader.a.b nKK;
  private static g.a nKW;
  private final a.a nKV;
  
  static
  {
    AppMethodBeat.i(120789);
    nKW = new g.a()
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
          ad.d("MicroMsg.CDNDownloadService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label102;
          }
          ad.i("MicroMsg.CDNDownloadService", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(120780);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label102:
        if (paramAnonymousInt != 0)
        {
          ad.e("MicroMsg.CDNDownloadService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          CDNDownloadService.V(paramAnonymousString, 4, paramAnonymousInt);
          AppMethodBeat.o(120780);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          CDNDownloadService.z(paramAnonymousString, paramAnonymousc.field_finishedLength, paramAnonymousc.field_toltalLength);
          AppMethodBeat.o(120780);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label225;
          }
          ad.e("MicroMsg.CDNDownloadService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          CDNDownloadService.V(paramAnonymousString, 4, paramAnonymousd.field_retCode);
        }
        for (;;)
        {
          AppMethodBeat.o(120780);
          return 0;
          label225:
          ad.i("MicroMsg.CDNDownloadService", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          CDNDownloadService.V(paramAnonymousString, 3, 0);
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
    this.nKV = new a.a()
    {
      public final boolean RA(String paramAnonymousString)
      {
        AppMethodBeat.i(120773);
        com.tencent.mm.plugin.cdndownloader.c.a.bNd().xL(paramAnonymousString);
        ad.i("MicroMsg.CDNDownloadService", "removeDownloadTask: true");
        AppMethodBeat.o(120773);
        return true;
      }
      
      public final CDNTaskState RB(String paramAnonymousString)
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
      
      public final boolean Rz(String paramAnonymousString)
      {
        AppMethodBeat.i(120772);
        com.tencent.mm.plugin.cdndownloader.c.a.bNd();
        boolean bool = com.tencent.mm.plugin.cdndownloader.c.a.RC(paramAnonymousString);
        ad.i("MicroMsg.CDNDownloadService", "pauseDownloadTask: ".concat(String.valueOf(bool)));
        AppMethodBeat.o(120772);
        return bool;
      }
      
      public final int a(CDNTaskInfo paramAnonymousCDNTaskInfo)
      {
        AppMethodBeat.i(120770);
        ad.i("MicroMsg.CDNDownloadService", "addDownloadTask: %s filepath:%s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl, paramAnonymousCDNTaskInfo.filePath });
        g localg = new g();
        localg.fnQ = paramAnonymousCDNTaskInfo.fnQ;
        localg.field_mediaId = paramAnonymousCDNTaskInfo.mediaId;
        localg.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
        localg.fnK = com.tencent.mm.plugin.downloader.a.c.Sg(paramAnonymousCDNTaskInfo.downloadUrl);
        localg.fnR = com.tencent.mm.plugin.downloader.a.c.Sg(paramAnonymousCDNTaskInfo.nKN);
        localg.fnH = CDNDownloadService.bNk();
        localg.fnL = paramAnonymousCDNTaskInfo.nKP;
        localg.fnM = paramAnonymousCDNTaskInfo.nKQ;
        localg.allow_mobile_net_download = paramAnonymousCDNTaskInfo.nKR;
        localg.fnP = paramAnonymousCDNTaskInfo.nKS;
        CDNDownloadService.a(localg, paramAnonymousCDNTaskInfo.nKO);
        int i = com.tencent.mm.plugin.cdndownloader.c.a.bNd().f(localg);
        ad.i("MicroMsg.CDNDownloadService", "addDownloadTask: ".concat(String.valueOf(i)));
        AppMethodBeat.o(120770);
        return i;
      }
      
      public final void a(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
      {
        AppMethodBeat.i(120775);
        ad.i("MicroMsg.CDNDownloadService", "registerCallback");
        CDNDownloadService.c(paramAnonymousb);
        AppMethodBeat.o(120775);
      }
      
      public final int b(CDNTaskInfo paramAnonymousCDNTaskInfo)
      {
        AppMethodBeat.i(120771);
        ad.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: %s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl });
        g localg = new g();
        localg.fnQ = paramAnonymousCDNTaskInfo.fnQ;
        localg.field_mediaId = paramAnonymousCDNTaskInfo.mediaId;
        localg.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
        localg.fnK = com.tencent.mm.plugin.downloader.a.c.Sg(paramAnonymousCDNTaskInfo.downloadUrl);
        localg.fnR = com.tencent.mm.plugin.downloader.a.c.Sg(paramAnonymousCDNTaskInfo.nKN);
        localg.fnH = CDNDownloadService.bNk();
        localg.fnL = paramAnonymousCDNTaskInfo.nKP;
        localg.fnM = paramAnonymousCDNTaskInfo.nKQ;
        localg.fnP = paramAnonymousCDNTaskInfo.nKS;
        localg.allow_mobile_net_download = paramAnonymousCDNTaskInfo.nKR;
        CDNDownloadService.a(localg, paramAnonymousCDNTaskInfo.nKO);
        int i = com.tencent.mm.plugin.cdndownloader.c.a.bNd().g(localg);
        ad.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: ".concat(String.valueOf(i)));
        AppMethodBeat.o(120771);
        return i;
      }
      
      public final void b(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
      {
        AppMethodBeat.i(120776);
        CDNDownloadService.c(null);
        AppMethodBeat.o(120776);
      }
      
      public final void bNa()
      {
        AppMethodBeat.i(120778);
        if (!b.a.adL().c(CDNDownloadService.this))
        {
          ad.i("MicroMsg.CDNDownloadService", "addIPCTaskMarker");
          b.a.adL().a(CDNDownloadService.this);
        }
        AppMethodBeat.o(120778);
      }
      
      public final void bNb()
      {
        AppMethodBeat.i(120779);
        ad.i("MicroMsg.CDNDownloadService", "removeIPCTaskMarker");
        b.a.adL().b(CDNDownloadService.this);
        AppMethodBeat.o(120779);
      }
      
      public final void bNc() {}
      
      public final void zr(int paramAnonymousInt)
      {
        AppMethodBeat.i(120777);
        ad.i("MicroMsg.CDNDownloadService", "notifyNetworkChange: ".concat(String.valueOf(paramAnonymousInt)));
        if (!aj.eFH()) {
          Mars.onNetworkChange();
        }
        AppMethodBeat.o(120777);
      }
    };
    AppMethodBeat.o(120781);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(120782);
    ad.i("MicroMsg.CDNDownloadService", "onBind");
    paramIntent = this.nKV;
    AppMethodBeat.o(120782);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(120784);
    super.onCreate();
    ad.i("MicroMsg.CDNDownloadService", "onCreate");
    AppMethodBeat.o(120784);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120785);
    super.onDestroy();
    ad.i("MicroMsg.CDNDownloadService", "onDestroy");
    b.a.adL().b(this);
    h.vKh.idkeyStat(710L, 1L, 1L, false);
    AppMethodBeat.o(120785);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(120783);
    ad.i("MicroMsg.CDNDownloadService", "onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(120783);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService
 * JD-Core Version:    0.7.0.1
 */