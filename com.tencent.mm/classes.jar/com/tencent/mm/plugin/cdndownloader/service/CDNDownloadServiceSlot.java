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

public class CDNDownloadServiceSlot
  extends Service
  implements com.tencent.mm.ipcinvoker.wx_extension.c.a
{
  private static com.tencent.mm.plugin.cdndownloader.a.b oXH;
  private static g.a oXT;
  private final a.a oXS;
  
  static
  {
    AppMethodBeat.i(120809);
    oXT = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(120800);
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
          ae.d("MicroMsg.CDNDownloadServiceSlot", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label102;
          }
          ae.i("MicroMsg.CDNDownloadServiceSlot", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(120800);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label102:
        if (paramAnonymousInt != 0)
        {
          ae.e("MicroMsg.CDNDownloadServiceSlot", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          CDNDownloadServiceSlot.W(paramAnonymousString, 4, paramAnonymousInt);
          AppMethodBeat.o(120800);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          CDNDownloadServiceSlot.x(paramAnonymousString, paramAnonymousc.field_finishedLength, paramAnonymousc.field_toltalLength);
          AppMethodBeat.o(120800);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label225;
          }
          ae.e("MicroMsg.CDNDownloadServiceSlot", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          CDNDownloadServiceSlot.W(paramAnonymousString, 4, paramAnonymousd.field_retCode);
        }
        for (;;)
        {
          AppMethodBeat.o(120800);
          return 0;
          label225:
          ae.i("MicroMsg.CDNDownloadServiceSlot", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          CDNDownloadServiceSlot.W(paramAnonymousString, 3, 0);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return new byte[0];
      }
    };
    AppMethodBeat.o(120809);
  }
  
  public CDNDownloadServiceSlot()
  {
    AppMethodBeat.i(120801);
    this.oXS = new a.a()
    {
      public final void Bd(int paramAnonymousInt)
      {
        AppMethodBeat.i(120797);
        ae.i("MicroMsg.CDNDownloadServiceSlot", "notifyNetworkChange: ".concat(String.valueOf(paramAnonymousInt)));
        if (!ak.foA()) {
          Mars.onNetworkChange();
        }
        AppMethodBeat.o(120797);
      }
      
      public final int a(CDNTaskInfo paramAnonymousCDNTaskInfo)
      {
        AppMethodBeat.i(120790);
        ae.i("MicroMsg.CDNDownloadServiceSlot", "addDownloadTask: %s filepath:%s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl, paramAnonymousCDNTaskInfo.filePath });
        com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
        localg.fLl = "task_CDNDownloadServiceSlot_1";
        localg.fLv = paramAnonymousCDNTaskInfo.fLv;
        localg.field_mediaId = paramAnonymousCDNTaskInfo.mediaId;
        localg.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
        localg.fLp = com.tencent.mm.plugin.downloader.a.c.aaQ(paramAnonymousCDNTaskInfo.downloadUrl);
        localg.fLw = com.tencent.mm.plugin.downloader.a.c.aaQ(paramAnonymousCDNTaskInfo.oXK);
        localg.fLm = CDNDownloadServiceSlot.cap();
        localg.fLq = paramAnonymousCDNTaskInfo.oXM;
        localg.fLr = paramAnonymousCDNTaskInfo.oXN;
        localg.allow_mobile_net_download = paramAnonymousCDNTaskInfo.oXO;
        localg.fLu = paramAnonymousCDNTaskInfo.oXP;
        CDNDownloadServiceSlot.b(localg, paramAnonymousCDNTaskInfo.oXL);
        int i = com.tencent.mm.plugin.cdndownloader.c.a.cai().h(localg);
        ae.i("MicroMsg.CDNDownloadServiceSlot", "addDownloadTask: ".concat(String.valueOf(i)));
        AppMethodBeat.o(120790);
        return i;
      }
      
      public final void a(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
      {
        AppMethodBeat.i(120795);
        ae.i("MicroMsg.CDNDownloadServiceSlot", "registerCallback");
        CDNDownloadServiceSlot.c(paramAnonymousb);
        AppMethodBeat.o(120795);
      }
      
      public final boolean aal(String paramAnonymousString)
      {
        AppMethodBeat.i(120792);
        com.tencent.mm.plugin.cdndownloader.c.a.cai();
        boolean bool = com.tencent.mm.plugin.cdndownloader.c.a.aao(paramAnonymousString);
        ae.i("MicroMsg.CDNDownloadServiceSlot", "pauseDownloadTask: ".concat(String.valueOf(bool)));
        AppMethodBeat.o(120792);
        return bool;
      }
      
      public final boolean aam(String paramAnonymousString)
      {
        AppMethodBeat.i(120793);
        com.tencent.mm.plugin.cdndownloader.c.a.cai().Fs(paramAnonymousString);
        ae.i("MicroMsg.CDNDownloadServiceSlot", "removeDownloadTask: true");
        AppMethodBeat.o(120793);
        return true;
      }
      
      public final CDNTaskState aan(String paramAnonymousString)
      {
        AppMethodBeat.i(120794);
        paramAnonymousString = CdnLogic.httpMultiSocketDownloadTaskState(paramAnonymousString);
        CDNTaskState localCDNTaskState = new CDNTaskState();
        if (paramAnonymousString != null)
        {
          localCDNTaskState.taskState = paramAnonymousString.taskState;
          localCDNTaskState.fileTotalSize = ((int)paramAnonymousString.fileTotalSize);
          localCDNTaskState.completeSize = ((int)paramAnonymousString.completeSize);
        }
        AppMethodBeat.o(120794);
        return localCDNTaskState;
      }
      
      public final int b(CDNTaskInfo paramAnonymousCDNTaskInfo)
      {
        AppMethodBeat.i(120791);
        ae.i("MicroMsg.CDNDownloadServiceSlot", "resumeDownloadTask: %s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl });
        com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
        localg.fLl = "task_CDNDownloadServiceSlot_2";
        localg.fLv = paramAnonymousCDNTaskInfo.fLv;
        localg.field_mediaId = paramAnonymousCDNTaskInfo.mediaId;
        localg.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
        localg.fLp = com.tencent.mm.plugin.downloader.a.c.aaQ(paramAnonymousCDNTaskInfo.downloadUrl);
        localg.fLw = com.tencent.mm.plugin.downloader.a.c.aaQ(paramAnonymousCDNTaskInfo.oXK);
        localg.fLm = CDNDownloadServiceSlot.cap();
        localg.fLq = paramAnonymousCDNTaskInfo.oXM;
        localg.fLr = paramAnonymousCDNTaskInfo.oXN;
        localg.fLu = paramAnonymousCDNTaskInfo.oXP;
        localg.allow_mobile_net_download = paramAnonymousCDNTaskInfo.oXO;
        CDNDownloadServiceSlot.b(localg, paramAnonymousCDNTaskInfo.oXL);
        int i = com.tencent.mm.plugin.cdndownloader.c.a.cai().i(localg);
        ae.i("MicroMsg.CDNDownloadServiceSlot", "resumeDownloadTask: ".concat(String.valueOf(i)));
        AppMethodBeat.o(120791);
        return i;
      }
      
      public final void b(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
      {
        AppMethodBeat.i(120796);
        CDNDownloadServiceSlot.c(null);
        AppMethodBeat.o(120796);
      }
      
      public final void caf()
      {
        AppMethodBeat.i(120798);
        if (!b.a.aic().c(CDNDownloadServiceSlot.this))
        {
          ae.i("MicroMsg.CDNDownloadServiceSlot", "addIPCTaskMarker");
          b.a.aic().a(CDNDownloadServiceSlot.this);
        }
        AppMethodBeat.o(120798);
      }
      
      public final void cag()
      {
        AppMethodBeat.i(120799);
        ae.i("MicroMsg.CDNDownloadServiceSlot", "removeIPCTaskMarker");
        b.a.aic().b(CDNDownloadServiceSlot.this);
        AppMethodBeat.o(120799);
      }
      
      public final void cah() {}
    };
    AppMethodBeat.o(120801);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(120802);
    ae.i("MicroMsg.CDNDownloadServiceSlot", "onBind");
    paramIntent = this.oXS;
    AppMethodBeat.o(120802);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(120804);
    super.onCreate();
    ae.i("MicroMsg.CDNDownloadServiceSlot", "onCreate");
    AppMethodBeat.o(120804);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120805);
    super.onDestroy();
    ae.i("MicroMsg.CDNDownloadServiceSlot", "onDestroy");
    b.a.aic().b(this);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(710L, 1L, 1L, false);
    AppMethodBeat.o(120805);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(120803);
    ae.i("MicroMsg.CDNDownloadServiceSlot", "onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(120803);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadServiceSlot
 * JD-Core Version:    0.7.0.1
 */