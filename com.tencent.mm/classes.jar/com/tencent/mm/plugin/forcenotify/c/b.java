package com.tencent.mm.plugin.forcenotify.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bwl;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/model/CgiGetForceNotifyAcceptInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ScanAppForcePushResponse;", "data", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "result", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getResult", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "setResult", "(Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class b
  extends com.tencent.mm.ai.a<bwl>
{
  private final String TAG;
  
  public b(String paramString)
  {
    AppMethodBeat.i(140598);
    this.TAG = "MicroMsg.CgiGetForceNotifyInfoList";
    b.a locala = new b.a();
    bwk localbwk = new bwk();
    localbwk.xJP = paramString;
    locala.a((com.tencent.mm.bv.a)localbwk);
    locala.b((com.tencent.mm.bv.a)new bwl());
    locala.rl("/cgi-bin/micromsg-bin/scanappforcepush");
    locala.kT(3538);
    locala.kU(0);
    locala.kV(0);
    a(locala.ado());
    AppMethodBeat.o(140598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.b
 * JD-Core Version:    0.7.0.1
 */