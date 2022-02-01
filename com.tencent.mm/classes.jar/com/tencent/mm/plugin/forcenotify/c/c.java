package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.bnp;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/model/CgiGetForceNotifyInfoList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetForcePushResponse;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-force-notify_release"})
public final class c
  extends com.tencent.mm.ak.c<bnp>
{
  private final String TAG;
  
  public c()
  {
    AppMethodBeat.i(149181);
    this.TAG = "MicroMsg.CgiGetForceNotifyInfoList";
    d.a locala = new d.a();
    locala.c((a)new bno());
    locala.d((a)new bnp());
    locala.MB("/cgi-bin/micromsg-bin/getforcepush");
    locala.sG(691);
    locala.sI(0);
    locala.sJ(0);
    c(locala.aXF());
    AppMethodBeat.o(149181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.c.c
 * JD-Core Version:    0.7.0.1
 */