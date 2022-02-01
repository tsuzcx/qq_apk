package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.crv;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/forcenotify/model/CgiGetForceNotifyAcceptInfo;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/ScanAppForcePushResponse;", "data", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "result", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getResult", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "setResult", "(Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class b
  extends c<crv>
{
  private final String TAG;
  
  public b(String paramString)
  {
    AppMethodBeat.i(149179);
    this.TAG = "MicroMsg.CgiGetForceNotifyInfoList";
    b.a locala = new b.a();
    cru localcru = new cru();
    localcru.FEx = paramString;
    locala.c((a)localcru);
    locala.d((a)new crv());
    locala.Am("/cgi-bin/micromsg-bin/scanappforcepush");
    locala.op(3538);
    locala.or(0);
    locala.os(0);
    c(locala.aAz());
    AppMethodBeat.o(149179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.b
 * JD-Core Version:    0.7.0.1
 */