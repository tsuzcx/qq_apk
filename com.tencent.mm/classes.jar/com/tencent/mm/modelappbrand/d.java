package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.dwr;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class d
{
  public static final a iIp;
  
  static
  {
    AppMethodBeat.i(201282);
    iIp = new a((byte)0);
    AppMethodBeat.o(201282);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "req", "Lcom/tencent/mm/protocal/protobuf/SetWxaMsgConfigRequest;", "plugin-compat_release"})
  public static final class a
  {
    public static com.tencent.mm.ak.d a(dwq paramdwq)
    {
      AppMethodBeat.i(201281);
      p.h(paramdwq, "req");
      com.tencent.mm.ak.d.a locala = new com.tencent.mm.ak.d.a();
      locala.d((a)new dwr());
      locala.MB("/cgi-bin/mmbiz-bin/wxaapp/setwxamsgconfig");
      locala.sG(3872);
      locala.sI(0);
      locala.sJ(0);
      locala.c((a)paramdwq);
      paramdwq = locala.aXF();
      p.g(paramdwq, "builder.buildInstance()");
      AppMethodBeat.o(201281);
      return paramdwq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.d
 * JD-Core Version:    0.7.0.1
 */