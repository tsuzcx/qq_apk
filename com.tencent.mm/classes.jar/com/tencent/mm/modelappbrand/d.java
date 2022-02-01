package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.ddm;
import com.tencent.mm.protocal.protobuf.ddn;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class d
{
  public static final a hNj;
  
  static
  {
    AppMethodBeat.i(200318);
    hNj = new a((byte)0);
    AppMethodBeat.o(200318);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "req", "Lcom/tencent/mm/protocal/protobuf/SetWxaMsgConfigRequest;", "plugin-compat_release"})
  public static final class a
  {
    public static b a(ddm paramddm)
    {
      AppMethodBeat.i(200317);
      p.h(paramddm, "req");
      b.a locala = new b.a();
      locala.d((a)new ddn());
      locala.DN("/cgi-bin/mmbiz-bin/wxaapp/setwxamsgconfig");
      locala.oS(3872);
      locala.oU(0);
      locala.oV(0);
      locala.c((a)paramddm);
      paramddm = locala.aDS();
      p.g(paramddm, "builder.buildInstance()");
      AppMethodBeat.o(200317);
      return paramddm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.d
 * JD-Core Version:    0.7.0.1
 */