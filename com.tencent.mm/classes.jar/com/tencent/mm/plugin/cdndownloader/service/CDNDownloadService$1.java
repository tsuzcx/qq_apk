package com.tencent.mm.plugin.cdndownloader.service;

import com.tencent.mars.Mars;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import com.tencent.mm.ipcinvoker.wx_extension.c.b.a;
import com.tencent.mm.plugin.cdndownloader.a.a.a;
import com.tencent.mm.plugin.cdndownloader.c.a;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class CDNDownloadService$1
  extends a.a
{
  CDNDownloadService$1(CDNDownloadService paramCDNDownloadService) {}
  
  public final void EL(int paramInt)
  {
    AppMethodBeat.i(120777);
    Log.i("MicroMsg.CDNDownloadService", "notifyNetworkChange: ".concat(String.valueOf(paramInt)));
    if (!MMApplicationContext.isPushProcess()) {
      Mars.onNetworkChange();
    }
    AppMethodBeat.o(120777);
  }
  
  public final int a(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120770);
    Log.i("MicroMsg.CDNDownloadService", "addDownloadTask: %s filepath:%s", new Object[] { paramCDNTaskInfo.downloadUrl, paramCDNTaskInfo.filePath });
    g localg = new g();
    localg.taskName = "task_CDNDownloadService_1";
    localg.gqH = paramCDNTaskInfo.gqH;
    localg.field_mediaId = paramCDNTaskInfo.mediaId;
    localg.field_fullpath = paramCDNTaskInfo.filePath;
    localg.gqB = c.akX(paramCDNTaskInfo.downloadUrl);
    localg.gqI = c.akX(paramCDNTaskInfo.qmH);
    localg.gqy = CDNDownloadService.cyg();
    localg.gqC = paramCDNTaskInfo.qmJ;
    localg.gqD = paramCDNTaskInfo.qmK;
    localg.allow_mobile_net_download = paramCDNTaskInfo.qmL;
    localg.gqG = paramCDNTaskInfo.qmM;
    CDNDownloadService.a(localg, paramCDNTaskInfo.qmI);
    int i = a.cxZ().h(localg);
    Log.i("MicroMsg.CDNDownloadService", "addDownloadTask: ".concat(String.valueOf(i)));
    AppMethodBeat.o(120770);
    return i;
  }
  
  public final void a(com.tencent.mm.plugin.cdndownloader.a.b paramb)
  {
    AppMethodBeat.i(120775);
    Log.i("MicroMsg.CDNDownloadService", "registerCallback");
    CDNDownloadService.c(paramb);
    AppMethodBeat.o(120775);
  }
  
  public final boolean akr(String paramString)
  {
    AppMethodBeat.i(120772);
    a.cxZ().Oc(paramString);
    Log.i("MicroMsg.CDNDownloadService", "pauseDownloadTask: true");
    AppMethodBeat.o(120772);
    return true;
  }
  
  public final boolean aks(String paramString)
  {
    AppMethodBeat.i(120773);
    a.cxZ().aku(paramString);
    Log.i("MicroMsg.CDNDownloadService", "removeDownloadTask: true");
    AppMethodBeat.o(120773);
    return true;
  }
  
  public final CDNTaskState akt(String paramString)
  {
    AppMethodBeat.i(120774);
    paramString = CdnLogic.httpMultiSocketDownloadTaskState(paramString);
    CDNTaskState localCDNTaskState = new CDNTaskState();
    if (paramString != null)
    {
      localCDNTaskState.taskState = paramString.taskState;
      localCDNTaskState.fileTotalSize = ((int)paramString.fileTotalSize);
      localCDNTaskState.completeSize = ((int)paramString.completeSize);
    }
    AppMethodBeat.o(120774);
    return localCDNTaskState;
  }
  
  public final int b(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120771);
    Log.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: %s", new Object[] { paramCDNTaskInfo.downloadUrl });
    g localg = new g();
    localg.taskName = "task_CDNDownloadService_2";
    localg.gqH = paramCDNTaskInfo.gqH;
    localg.field_mediaId = paramCDNTaskInfo.mediaId;
    localg.field_fullpath = paramCDNTaskInfo.filePath;
    localg.gqB = c.akX(paramCDNTaskInfo.downloadUrl);
    localg.gqI = c.akX(paramCDNTaskInfo.qmH);
    localg.gqy = CDNDownloadService.cyg();
    localg.gqC = paramCDNTaskInfo.qmJ;
    localg.gqD = paramCDNTaskInfo.qmK;
    localg.gqG = paramCDNTaskInfo.qmM;
    localg.allow_mobile_net_download = paramCDNTaskInfo.qmL;
    localg.is_resume_task = true;
    CDNDownloadService.a(localg, paramCDNTaskInfo.qmI);
    int i = a.cxZ().i(localg);
    Log.i("MicroMsg.CDNDownloadService", "resumeDownloadTask: ".concat(String.valueOf(i)));
    AppMethodBeat.o(120771);
    return i;
  }
  
  public final void b(com.tencent.mm.plugin.cdndownloader.a.b paramb)
  {
    AppMethodBeat.i(120776);
    CDNDownloadService.c(null);
    AppMethodBeat.o(120776);
  }
  
  public final void cxU()
  {
    AppMethodBeat.i(120778);
    if (!b.a.ayr().c(this.qmR))
    {
      Log.i("MicroMsg.CDNDownloadService", "addIPCTaskMarker");
      b.a.ayr().a(this.qmR);
    }
    AppMethodBeat.o(120778);
  }
  
  public final void cxV()
  {
    AppMethodBeat.i(120779);
    Log.i("MicroMsg.CDNDownloadService", "removeIPCTaskMarker");
    b.a.ayr().b(this.qmR);
    AppMethodBeat.o(120779);
  }
  
  public final void cxW() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadService.1
 * JD-Core Version:    0.7.0.1
 */