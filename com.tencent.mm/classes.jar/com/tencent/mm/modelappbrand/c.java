package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.protocal.protobuf.bzh;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class c
{
  public static final a iIo;
  
  static
  {
    AppMethodBeat.i(201280);
    iIo = new a((byte)0);
    AppMethodBeat.o(201280);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-compat_release"})
  public static final class a
  {
    public static d aXF()
    {
      AppMethodBeat.i(201279);
      Object localObject = new d.a();
      ((d.a)localObject).c((a)new bzg());
      ((d.a)localObject).d((a)new bzh());
      ((d.a)localObject).MB("/cgi-bin/mmbiz-bin/wxaapp/getwxamsgconfig");
      ((d.a)localObject).sG(357);
      ((d.a)localObject).sI(0);
      ((d.a)localObject).sJ(0);
      localObject = ((d.a)localObject).aXF();
      p.g(localObject, "builder.buildInstance()");
      AppMethodBeat.o(201279);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.c
 * JD-Core Version:    0.7.0.1
 */