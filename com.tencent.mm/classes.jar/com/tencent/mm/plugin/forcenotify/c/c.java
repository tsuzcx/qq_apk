package com.tencent.mm.plugin.forcenotify.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.akp;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/model/CgiGetForceNotifyInfoList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetForcePushResponse;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class c
  extends com.tencent.mm.ai.a<akp>
{
  private final String TAG;
  
  public c()
  {
    AppMethodBeat.i(51052);
    this.TAG = "MicroMsg.CgiGetForceNotifyInfoList";
    b.a locala = new b.a();
    locala.a((com.tencent.mm.bv.a)new ako());
    locala.b((com.tencent.mm.bv.a)new akp());
    locala.rl("/cgi-bin/micromsg-bin/getforcepush");
    locala.kT(691);
    locala.kU(0);
    locala.kV(0);
    a(locala.ado());
    AppMethodBeat.o(51052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.c
 * JD-Core Version:    0.7.0.1
 */