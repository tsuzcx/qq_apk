package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.dqq;
import com.tencent.mm.protocal.protobuf.dqr;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/model/CgiAcceptForceNotify;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ScanAppForcePushResponse;", "data", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "result", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getResult", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "setResult", "(Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class a
  extends c<dqr>
{
  private final String TAG;
  
  public a(String paramString)
  {
    AppMethodBeat.i(149177);
    this.TAG = "MicroMsg.CgiAcceptForceNotify";
    d.a locala = new d.a();
    dqq localdqq = new dqq();
    localdqq.MTz = paramString;
    locala.c((com.tencent.mm.bw.a)localdqq);
    locala.d((com.tencent.mm.bw.a)new dqr());
    locala.MB("/cgi-bin/micromsg-bin/subappforcepush");
    locala.sG(3743);
    locala.sI(0);
    locala.sJ(0);
    c(locala.aXF());
    AppMethodBeat.o(149177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.a
 * JD-Core Version:    0.7.0.1
 */