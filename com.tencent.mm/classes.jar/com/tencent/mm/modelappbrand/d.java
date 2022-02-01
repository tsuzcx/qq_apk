package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.crx;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class d
{
  public static final a gRy;
  
  static
  {
    AppMethodBeat.i(190253);
    gRy = new a((byte)0);
    AppMethodBeat.o(190253);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/modelappbrand/CgiSetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "req", "Lcom/tencent/mm/protocal/protobuf/SetWxaMsgConfigRequest;", "plugin-compat_release"})
  public static final class a
  {
    public static b a(crw paramcrw)
    {
      AppMethodBeat.i(190252);
      k.h(paramcrw, "req");
      b.a locala = new b.a();
      locala.d((a)new crx());
      locala.wg("/cgi-bin/mmbiz-bin/wxaapp/setwxamsgconfig");
      locala.nB(3872);
      locala.nD(0);
      locala.nE(0);
      locala.c((a)paramcrw);
      paramcrw = locala.atI();
      k.g(paramcrw, "builder.buildInstance()");
      AppMethodBeat.o(190252);
      return paramcrw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.d
 * JD-Core Version:    0.7.0.1
 */