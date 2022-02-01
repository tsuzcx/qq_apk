package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.cxg;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class d
{
  public static final a hrY;
  
  static
  {
    AppMethodBeat.i(209766);
    hrY = new a((byte)0);
    AppMethodBeat.o(209766);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "req", "Lcom/tencent/mm/protocal/protobuf/SetWxaMsgConfigRequest;", "plugin-compat_release"})
  public static final class a
  {
    public static b a(cxf paramcxf)
    {
      AppMethodBeat.i(209765);
      k.h(paramcxf, "req");
      b.a locala = new b.a();
      locala.d((a)new cxg());
      locala.Am("/cgi-bin/mmbiz-bin/wxaapp/setwxamsgconfig");
      locala.op(3872);
      locala.or(0);
      locala.os(0);
      locala.c((a)paramcxf);
      paramcxf = locala.aAz();
      k.g(paramcxf, "builder.buildInstance()");
      AppMethodBeat.o(209765);
      return paramcxf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.d
 * JD-Core Version:    0.7.0.1
 */