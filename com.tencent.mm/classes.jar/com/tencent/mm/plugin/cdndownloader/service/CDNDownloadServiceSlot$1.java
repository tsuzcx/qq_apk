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

final class CDNDownloadServiceSlot$1
  extends a.a
{
  CDNDownloadServiceSlot$1(CDNDownloadServiceSlot paramCDNDownloadServiceSlot) {}
  
  public final void EL(int paramInt)
  {
    AppMethodBeat.i(120797);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "notifyNetworkChange: ".concat(String.valueOf(paramInt)));
    if (!MMApplicationContext.isPushProcess()) {
      Mars.onNetworkChange();
    }
    AppMethodBeat.o(120797);
  }
  
  public final int a(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120790);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "addDownloadTask: %s filepath:%s", new Object[] { paramCDNTaskInfo.downloadUrl, paramCDNTaskInfo.filePath });
    g localg = new g();
    localg.taskName = "task_CDNDownloadServiceSlot_1";
    localg.gqH = paramCDNTaskInfo.gqH;
    localg.field_mediaId = paramCDNTaskInfo.mediaId;
    localg.field_fullpath = paramCDNTaskInfo.filePath;
    localg.gqB = c.akX(paramCDNTaskInfo.downloadUrl);
    localg.gqI = c.akX(paramCDNTaskInfo.qmH);
    localg.gqy = CDNDownloadServiceSlot.cyg();
    localg.gqC = paramCDNTaskInfo.qmJ;
    localg.gqD = paramCDNTaskInfo.qmK;
    localg.allow_mobile_net_download = paramCDNTaskInfo.qmL;
    localg.gqG = paramCDNTaskInfo.qmM;
    CDNDownloadServiceSlot.b(localg, paramCDNTaskInfo.qmI);
    int i = a.cxZ().h(localg);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "addDownloadTask: ".concat(String.valueOf(i)));
    AppMethodBeat.o(120790);
    return i;
  }
  
  public final void a(com.tencent.mm.plugin.cdndownloader.a.b paramb)
  {
    AppMethodBeat.i(120795);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "registerCallback");
    CDNDownloadServiceSlot.c(paramb);
    AppMethodBeat.o(120795);
  }
  
  public final boolean akr(String paramString)
  {
    AppMethodBeat.i(120792);
    a.cxZ().Oc(paramString);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "pauseDownloadTask: true");
    AppMethodBeat.o(120792);
    return true;
  }
  
  public final boolean aks(String paramString)
  {
    AppMethodBeat.i(120793);
    a.cxZ().aku(paramString);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "removeDownloadTask: true");
    AppMethodBeat.o(120793);
    return true;
  }
  
  public final CDNTaskState akt(String paramString)
  {
    AppMethodBeat.i(120794);
    paramString = CdnLogic.httpMultiSocketDownloadTaskState(paramString);
    CDNTaskState localCDNTaskState = new CDNTaskState();
    if (paramString != null)
    {
      localCDNTaskState.taskState = paramString.taskState;
      localCDNTaskState.fileTotalSize = ((int)paramString.fileTotalSize);
      localCDNTaskState.completeSize = ((int)paramString.completeSize);
    }
    AppMethodBeat.o(120794);
    return localCDNTaskState;
  }
  
  public final int b(CDNTaskInfo paramCDNTaskInfo)
  {
    AppMethodBeat.i(120791);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "resumeDownloadTask: %s", new Object[] { paramCDNTaskInfo.downloadUrl });
    g localg = new g();
    localg.taskName = "task_CDNDownloadServiceSlot_2";
    localg.gqH = paramCDNTaskInfo.gqH;
    localg.field_mediaId = paramCDNTaskInfo.mediaId;
    localg.field_fullpath = paramCDNTaskInfo.filePath;
    localg.gqB = c.akX(paramCDNTaskInfo.downloadUrl);
    localg.gqI = c.akX(paramCDNTaskInfo.qmH);
    localg.gqy = CDNDownloadServiceSlot.cyg();
    localg.gqC = paramCDNTaskInfo.qmJ;
    localg.gqD = paramCDNTaskInfo.qmK;
    localg.gqG = paramCDNTaskInfo.qmM;
    localg.allow_mobile_net_download = paramCDNTaskInfo.qmL;
    localg.is_resume_task = true;
    CDNDownloadServiceSlot.b(localg, paramCDNTaskInfo.qmI);
    int i = a.cxZ().i(localg);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "resumeDownloadTask: ".concat(String.valueOf(i)));
    AppMethodBeat.o(120791);
    return i;
  }
  
  public final void b(com.tencent.mm.plugin.cdndownloader.a.b paramb)
  {
    AppMethodBeat.i(120796);
    CDNDownloadServiceSlot.c(null);
    AppMethodBeat.o(120796);
  }
  
  public final void cxU()
  {
    AppMethodBeat.i(120798);
    if (!b.a.ayr().c(this.qmS))
    {
      Log.i("MicroMsg.CDNDownloadServiceSlot", "addIPCTaskMarker");
      b.a.ayr().a(this.qmS);
    }
    AppMethodBeat.o(120798);
  }
  
  public final void cxV()
  {
    AppMethodBeat.i(120799);
    Log.i("MicroMsg.CDNDownloadServiceSlot", "removeIPCTaskMarker");
    b.a.ayr().b(this.qmS);
    AppMethodBeat.o(120799);
  }
  
  public final void cxW() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.service.CDNDownloadServiceSlot.1
 * JD-Core Version:    0.7.0.1
 */