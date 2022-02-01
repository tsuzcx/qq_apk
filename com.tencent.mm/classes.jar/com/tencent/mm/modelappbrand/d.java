package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.dct;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class d
{
  public static final a hKq;
  
  static
  {
    AppMethodBeat.i(220343);
    hKq = new a((byte)0);
    AppMethodBeat.o(220343);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "req", "Lcom/tencent/mm/protocal/protobuf/SetWxaMsgConfigRequest;", "plugin-compat_release"})
  public static final class a
  {
    public static b a(dcs paramdcs)
    {
      AppMethodBeat.i(220342);
      p.h(paramdcs, "req");
      b.a locala = new b.a();
      locala.d((a)new dct());
      locala.Dl("/cgi-bin/mmbiz-bin/wxaapp/setwxamsgconfig");
      locala.oP(3872);
      locala.oR(0);
      locala.oS(0);
      locala.c((a)paramdcs);
      paramdcs = locala.aDC();
      p.g(paramdcs, "builder.buildInstance()");
      AppMethodBeat.o(220342);
      return paramdcs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.d
 * JD-Core Version:    0.7.0.1
 */