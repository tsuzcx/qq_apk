package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.bhp;
import com.tencent.mm.protocal.protobuf.bhq;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class c
{
  public static final a hrX;
  
  static
  {
    AppMethodBeat.i(209764);
    hrX = new a((byte)0);
    AppMethodBeat.o(209764);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-compat_release"})
  public static final class a
  {
    public static b aAz()
    {
      AppMethodBeat.i(209763);
      Object localObject = new b.a();
      ((b.a)localObject).c((a)new bhp());
      ((b.a)localObject).d((a)new bhq());
      ((b.a)localObject).Am("/cgi-bin/mmbiz-bin/wxaapp/getwxamsgconfig");
      ((b.a)localObject).op(357);
      ((b.a)localObject).or(0);
      ((b.a)localObject).os(0);
      localObject = ((b.a)localObject).aAz();
      k.g(localObject, "builder.buildInstance()");
      AppMethodBeat.o(209763);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.c
 * JD-Core Version:    0.7.0.1
 */