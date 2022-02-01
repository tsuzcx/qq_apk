package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.bmq;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class c
{
  public static final a hNi;
  
  static
  {
    AppMethodBeat.i(200316);
    hNi = new a((byte)0);
    AppMethodBeat.o(200316);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-compat_release"})
  public static final class a
  {
    public static b aDS()
    {
      AppMethodBeat.i(200315);
      Object localObject = new b.a();
      ((b.a)localObject).c((a)new bmp());
      ((b.a)localObject).d((a)new bmq());
      ((b.a)localObject).DN("/cgi-bin/mmbiz-bin/wxaapp/getwxamsgconfig");
      ((b.a)localObject).oS(357);
      ((b.a)localObject).oU(0);
      ((b.a)localObject).oV(0);
      localObject = ((b.a)localObject).aDS();
      p.g(localObject, "builder.buildInstance()");
      AppMethodBeat.o(200315);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.c
 * JD-Core Version:    0.7.0.1
 */