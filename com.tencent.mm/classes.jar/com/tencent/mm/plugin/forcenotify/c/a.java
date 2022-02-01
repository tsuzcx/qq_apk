package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/forcenotify/model/CgiAcceptForceNotify;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ScanAppForcePushResponse;", "data", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "result", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getResult", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "setResult", "(Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class a
  extends com.tencent.mm.ak.a<cxw>
{
  private final String TAG;
  
  public a(String paramString)
  {
    AppMethodBeat.i(149177);
    this.TAG = "MicroMsg.CgiAcceptForceNotify";
    b.a locala = new b.a();
    cxv localcxv = new cxv();
    localcxv.HIo = paramString;
    locala.c((com.tencent.mm.bw.a)localcxv);
    locala.d((com.tencent.mm.bw.a)new cxw());
    locala.DN("/cgi-bin/micromsg-bin/subappforcepush");
    locala.oS(3743);
    locala.oU(0);
    locala.oV(0);
    c(locala.aDS());
    AppMethodBeat.o(149177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.a
 * JD-Core Version:    0.7.0.1
 */