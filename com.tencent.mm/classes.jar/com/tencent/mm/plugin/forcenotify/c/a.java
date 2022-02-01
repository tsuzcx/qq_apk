package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cxb;
import com.tencent.mm.protocal.protobuf.cxc;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/forcenotify/model/CgiAcceptForceNotify;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ScanAppForcePushResponse;", "data", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "result", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getResult", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "setResult", "(Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class a
  extends com.tencent.mm.al.a<cxc>
{
  private final String TAG;
  
  public a(String paramString)
  {
    AppMethodBeat.i(149177);
    this.TAG = "MicroMsg.CgiAcceptForceNotify";
    b.a locala = new b.a();
    cxb localcxb = new cxb();
    localcxb.HoM = paramString;
    locala.c((com.tencent.mm.bx.a)localcxb);
    locala.d((com.tencent.mm.bx.a)new cxc());
    locala.Dl("/cgi-bin/micromsg-bin/subappforcepush");
    locala.oP(3743);
    locala.oR(0);
    locala.oS(0);
    c(locala.aDC());
    AppMethodBeat.o(149177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.a
 * JD-Core Version:    0.7.0.1
 */