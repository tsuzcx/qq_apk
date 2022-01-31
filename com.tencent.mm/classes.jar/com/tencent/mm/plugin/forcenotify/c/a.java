package com.tencent.mm.plugin.forcenotify.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bwl;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/model/CgiAcceptForceNotify;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ScanAppForcePushResponse;", "data", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "result", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getResult", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "setResult", "(Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class a
  extends com.tencent.mm.ai.a<bwl>
{
  private final String TAG;
  
  public a(String paramString)
  {
    AppMethodBeat.i(140596);
    this.TAG = "MicroMsg.CgiAcceptForceNotify";
    b.a locala = new b.a();
    bwk localbwk = new bwk();
    localbwk.xJP = paramString;
    locala.a((com.tencent.mm.bv.a)localbwk);
    locala.b((com.tencent.mm.bv.a)new bwl());
    locala.rl("/cgi-bin/micromsg-bin/subappforcepush");
    locala.kT(3743);
    locala.kU(0);
    locala.kV(0);
    a(locala.ado());
    AppMethodBeat.o(140596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.a
 * JD-Core Version:    0.7.0.1
 */