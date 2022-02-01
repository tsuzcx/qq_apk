package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bcd;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/forcenotify/model/CgiGetForceNotifyInfoList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetForcePushResponse;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class c
  extends com.tencent.mm.ak.a<bcd>
{
  private final String TAG;
  
  public c()
  {
    AppMethodBeat.i(149181);
    this.TAG = "MicroMsg.CgiGetForceNotifyInfoList";
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)new bcc());
    locala.d((com.tencent.mm.bw.a)new bcd());
    locala.DN("/cgi-bin/micromsg-bin/getforcepush");
    locala.oS(691);
    locala.oU(0);
    locala.oV(0);
    c(locala.aDS());
    AppMethodBeat.o(149181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.c
 * JD-Core Version:    0.7.0.1
 */