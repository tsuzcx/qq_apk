package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axl;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/forcenotify/model/CgiGetForceNotifyInfoList;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/GetForcePushResponse;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class c
  extends com.tencent.mm.ak.c<axl>
{
  private final String TAG;
  
  public c()
  {
    AppMethodBeat.i(149181);
    this.TAG = "MicroMsg.CgiGetForceNotifyInfoList";
    b.a locala = new b.a();
    locala.c((a)new axk());
    locala.d((a)new axl());
    locala.Am("/cgi-bin/micromsg-bin/getforcepush");
    locala.op(691);
    locala.or(0);
    locala.os(0);
    c(locala.aAz());
    AppMethodBeat.o(149181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.c
 * JD-Core Version:    0.7.0.1
 */