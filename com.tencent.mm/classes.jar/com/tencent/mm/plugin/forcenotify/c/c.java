package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.protocal.protobuf.bbn;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/forcenotify/model/CgiGetForceNotifyInfoList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetForcePushResponse;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class c
  extends com.tencent.mm.al.a<bbn>
{
  private final String TAG;
  
  public c()
  {
    AppMethodBeat.i(149181);
    this.TAG = "MicroMsg.CgiGetForceNotifyInfoList";
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bx.a)new bbm());
    locala.d((com.tencent.mm.bx.a)new bbn());
    locala.Dl("/cgi-bin/micromsg-bin/getforcepush");
    locala.oP(691);
    locala.oR(0);
    locala.oS(0);
    c(locala.aDC());
    AppMethodBeat.o(149181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.c
 * JD-Core Version:    0.7.0.1
 */