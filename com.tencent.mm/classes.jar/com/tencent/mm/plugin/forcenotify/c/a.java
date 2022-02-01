package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.cmn;
import com.tencent.mm.protocal.protobuf.cmo;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/forcenotify/model/CgiAcceptForceNotify;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/ScanAppForcePushResponse;", "data", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "result", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "getResult", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "setResult", "(Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class a
  extends c<cmo>
{
  private final String TAG;
  
  public a(String paramString)
  {
    AppMethodBeat.i(149177);
    this.TAG = "MicroMsg.CgiAcceptForceNotify";
    b.a locala = new b.a();
    cmn localcmn = new cmn();
    localcmn.Ehy = paramString;
    locala.c((com.tencent.mm.bx.a)localcmn);
    locala.d((com.tencent.mm.bx.a)new cmo());
    locala.wg("/cgi-bin/micromsg-bin/subappforcepush");
    locala.nB(3743);
    locala.nD(0);
    locala.nE(0);
    c(locala.atI());
    AppMethodBeat.o(149177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.a
 * JD-Core Version:    0.7.0.1
 */