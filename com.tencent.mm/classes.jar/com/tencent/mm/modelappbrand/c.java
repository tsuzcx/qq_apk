package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.protocal.protobuf.bdy;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class c
{
  public static final a gRx;
  
  static
  {
    AppMethodBeat.i(190251);
    gRx = new a((byte)0);
    AppMethodBeat.o(190251);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-compat_release"})
  public static final class a
  {
    public static b atI()
    {
      AppMethodBeat.i(190250);
      Object localObject = new b.a();
      ((b.a)localObject).c((a)new bdx());
      ((b.a)localObject).d((a)new bdy());
      ((b.a)localObject).wg("/cgi-bin/mmbiz-bin/wxaapp/getwxamsgconfig");
      ((b.a)localObject).nB(357);
      ((b.a)localObject).nD(0);
      ((b.a)localObject).nE(0);
      localObject = ((b.a)localObject).atI();
      k.g(localObject, "builder.buildInstance()");
      AppMethodBeat.o(190250);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.c
 * JD-Core Version:    0.7.0.1
 */