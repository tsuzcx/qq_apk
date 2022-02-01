package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.crv;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/forcenotify/model/CgiAcceptForceNotify;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/ScanAppForcePushResponse;", "data", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "result", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getResult", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "setResult", "(Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class a
  extends c<crv>
{
  private final String TAG;
  
  public a(String paramString)
  {
    AppMethodBeat.i(149177);
    this.TAG = "MicroMsg.CgiAcceptForceNotify";
    b.a locala = new b.a();
    cru localcru = new cru();
    localcru.FEx = paramString;
    locala.c((com.tencent.mm.bw.a)localcru);
    locala.d((com.tencent.mm.bw.a)new crv());
    locala.Am("/cgi-bin/micromsg-bin/subappforcepush");
    locala.op(3743);
    locala.or(0);
    locala.os(0);
    c(locala.aAz());
    AppMethodBeat.o(149177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.a
 * JD-Core Version:    0.7.0.1
 */