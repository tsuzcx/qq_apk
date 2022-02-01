package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.egq;
import com.tencent.mm.protocal.protobuf.egr;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class d
{
  public static final a lyr;
  
  static
  {
    AppMethodBeat.i(207459);
    lyr = new a((byte)0);
    AppMethodBeat.o(207459);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "req", "Lcom/tencent/mm/protocal/protobuf/SetWxaMsgConfigRequest;", "plugin-compat_release"})
  public static final class a
  {
    public static com.tencent.mm.an.d a(egq paramegq)
    {
      AppMethodBeat.i(207491);
      p.k(paramegq, "req");
      com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
      locala.d((a)new egr());
      locala.TW("/cgi-bin/mmbiz-bin/wxaapp/setwxamsgconfig");
      locala.vD(3872);
      locala.vF(0);
      locala.vG(0);
      locala.c((a)paramegq);
      paramegq = locala.bgN();
      p.j(paramegq, "builder.buildInstance()");
      AppMethodBeat.o(207491);
      return paramegq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.d
 * JD-Core Version:    0.7.0.1
 */