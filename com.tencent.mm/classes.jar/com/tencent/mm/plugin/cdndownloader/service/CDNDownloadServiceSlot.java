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
import com.tencent.mm.ipcinvoker.wx_extension.c.b.a;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.ByteArrayOutputStream;

public class CDNDownloadServiceSlot
  extends Service
  implements com.tencent.mm.ipcinvoker.wx_extension.c.a
{
  private static g.a tLH;
  private static com.tencent.mm.plugin.cdndownloader.a.b tLv;
  private final a.a tLG;
  
  static
  {
    AppMethodBeat.i(120809);
    tLH = new g.a()
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
          Log.d("MicroMsg.CDNDownloadServiceSlot", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), str1, str2 });
          if (paramAnonymousInt != -21006) {
            break label102;
          }
          Log.i("MicroMsg.CDNDownloadServiceSlot", "duplicate request, ignore this request, media id is %s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(120800);
          return 0;
          str1 = paramAnonymousc.toString();
          break;
        }
        label102:
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.CDNDownloadServiceSlot", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          CDNDownloadServiceSlot.Z(paramAnonymousString, 4, paramAnonymousInt);
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
          Log.e("MicroMsg.CDNDownloadServiceSlot", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
          CDNDownloadServiceSlot.Z(paramAnonymousString, 4, paramAnonymousd.field_retCode);
        }
        for (;;)
        {
          AppMethodBeat.o(120800);
          return 0;
          label225:
          Log.i("MicroMsg.CDNDownloadServiceSlot", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          CDNDownloadServiceSlot.Z(paramAnonymousString, 3, 0);
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
    this.tLG = new a.a()
    {
      public final void Is(int paramAnonymousInt)
      {
        AppMethodBeat.i(120797);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "notifyNetworkChange: ".concat(String.valueOf(paramAnonymousInt)));
        if (!MMApplicationContext.isPushProcess()) {
          Mars.onNetworkChange();
        }
        AppMethodBeat.o(120797);
      }
      
      public final int a(CDNTaskInfo paramAnonymousCDNTaskInfo)
      {
        AppMethodBeat.i(120790);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "addDownloadTask: %s filepath:%s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl, paramAnonymousCDNTaskInfo.filePath });
        g localg = new g();
        localg.taskName = "task_CDNDownloadServiceSlot_1";
        localg.iUP = paramAnonymousCDNTaskInfo.iUP;
        localg.field_mediaId = paramAnonymousCDNTaskInfo.mediaId;
        localg.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
        localg.iUJ = com.tencent.mm.plugin.downloader.a.c.asQ(paramAnonymousCDNTaskInfo.downloadUrl);
        localg.iUQ = com.tencent.mm.plugin.downloader.a.c.asQ(paramAnonymousCDNTaskInfo.tLy);
        localg.iUG = CDNDownloadServiceSlot.cMB();
        localg.iUK = paramAnonymousCDNTaskInfo.tLA;
        localg.iUL = paramAnonymousCDNTaskInfo.tLB;
        localg.allow_mobile_net_download = paramAnonymousCDNTaskInfo.tLC;
        localg.iUO = paramAnonymousCDNTaskInfo.tLD;
        CDNDownloadServiceSlot.b(localg, paramAnonymousCDNTaskInfo.tLz);
        int i = com.tencent.mm.plugin.cdndownloader.c.a.cMu().h(localg);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "addDownloadTask: ".concat(String.valueOf(i)));
        AppMethodBeat.o(120790);
        return i;
      }
      
      public final void a(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
      {
        AppMethodBeat.i(120795);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "registerCallback");
        CDNDownloadServiceSlot.c(paramAnonymousb);
        AppMethodBeat.o(120795);
      }
      
      public final boolean asf(String paramAnonymousString)
      {
        AppMethodBeat.i(120792);
        com.tencent.mm.plugin.cdndownloader.c.a.cMu().Vz(paramAnonymousString);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "pauseDownloadTask: true");
        AppMethodBeat.o(120792);
        return true;
      }
      
      public final boolean asg(String paramAnonymousString)
      {
        AppMethodBeat.i(120793);
        com.tencent.mm.plugin.cdndownloader.c.a.cMu().asi(paramAnonymousString);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "removeDownloadTask: true");
        AppMethodBeat.o(120793);
        return true;
      }
      
      public final CDNTaskState ash(String paramAnonymousString)
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
        Log.i("MicroMsg.CDNDownloadServiceSlot", "resumeDownloadTask: %s", new Object[] { paramAnonymousCDNTaskInfo.downloadUrl });
        g localg = new g();
        localg.taskName = "task_CDNDownloadServiceSlot_2";
        localg.iUP = paramAnonymousCDNTaskInfo.iUP;
        localg.field_mediaId = paramAnonymousCDNTaskInfo.mediaId;
        localg.field_fullpath = paramAnonymousCDNTaskInfo.filePath;
        localg.iUJ = com.tencent.mm.plugin.downloader.a.c.asQ(paramAnonymousCDNTaskInfo.downloadUrl);
        localg.iUQ = com.tencent.mm.plugin.downloader.a.c.asQ(paramAnonymousCDNTaskInfo.tLy);
        localg.iUG = CDNDownloadServiceSlot.cMB();
        localg.iUK = paramAnonymousCDNTaskInfo.tLA;
        localg.iUL = paramAnonymousCDNTaskInfo.tLB;
        localg.iUO = paramAnonymousCDNTaskInfo.tLD;
        localg.allow_mobile_net_download = paramAnonymousCDNTaskInfo.tLC;
        localg.is_resume_task = true;
        CDNDownloadServiceSlot.b(localg, paramAnonymousCDNTaskInfo.tLz);
        int i = com.tencent.mm.plugin.cdndownloader.c.a.cMu().i(localg);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "resumeDownloadTask: ".concat(String.valueOf(i)));
        AppMethodBeat.o(120791);
        return i;
      }
      
      public final void b(com.tencent.mm.plugin.cdndownloader.a.b paramAnonymousb)
      {
        AppMethodBeat.i(120796);
        CDNDownloadServiceSlot.c(null);
        AppMethodBeat.o(120796);
      }
      
      public final void cMp()
      {
        AppMethodBeat.i(120798);
        if (!b.a.aFK().c(CDNDownloadServiceSlot.this))
        {
          Log.i("MicroMsg.CDNDownloadServiceSlot", "addIPCTaskMarker");
          b.a.aFK().a(CDNDownloadServiceSlot.this);
        }
        AppMethodBeat.o(120798);
      }
      
      public final void cMq()
      {
        AppMethodBeat.i(120799);
        Log.i("MicroMsg.CDNDownloadServiceSlot", "removeIPCTaskMarker");
        b.a.aFK().b(CDNDownloadServiceSlot.this);
        AppMethodBeat.o(120799);
      }
      
      public final void cMr() {}
    };
    AppMethodBeat.o(120801);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(120802);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "onBind");
    paramIntent = this.tLG;
    AppMethodBeat.o(120802);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(120804);
    super.onCreate();
    Log.i("MicroMsg.CDNDownloadServiceSlot", "onCreate");
    AppMethodBeat.o(120804);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(120805);
    super.onDestroy();
    Log.i("MicroMsg.CDNDownloadServiceSlot", "onDestroy");
    b.a.aFK().b(this);
    h.IzE.idkeyStat(710L, 1L, 1L, false);
    AppMethodBeat.o(120805);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(120803);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "onUnbind");
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(120803);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadServiceSlot
 * JD-Core Version:    0.7.0.1
 */