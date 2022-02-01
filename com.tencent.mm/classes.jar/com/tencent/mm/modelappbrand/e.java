package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.faq;
import com.tencent.mm.protocal.protobuf.far;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a opS;
  
  static
  {
    AppMethodBeat.i(233809);
    opS = new a((byte)0);
    AppMethodBeat.o(233809);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "req", "Lcom/tencent/mm/protocal/protobuf/SetWxaMsgConfigRequest;", "plugin-compat_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static c a(faq paramfaq)
    {
      AppMethodBeat.i(233821);
      s.u(paramfaq, "req");
      c.a locala = new c.a();
      locala.otF = ((a)new far());
      locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/setwxamsgconfig";
      locala.funcId = 3872;
      locala.otG = 0;
      locala.respCmdId = 0;
      locala.otE = ((a)paramfaq);
      paramfaq = locala.bEF();
      s.s(paramfaq, "builder.buildInstance()");
      AppMethodBeat.o(233821);
      return paramfaq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.e
 * JD-Core Version:    0.7.0.1
 */