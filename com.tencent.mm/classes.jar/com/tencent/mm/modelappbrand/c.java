package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.bly;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class c
{
  public static final a hKp;
  
  static
  {
    AppMethodBeat.i(220341);
    hKp = new a((byte)0);
    AppMethodBeat.o(220341);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-compat_release"})
  public static final class a
  {
    public static b aDC()
    {
      AppMethodBeat.i(220340);
      Object localObject = new b.a();
      ((b.a)localObject).c((a)new blx());
      ((b.a)localObject).d((a)new bly());
      ((b.a)localObject).Dl("/cgi-bin/mmbiz-bin/wxaapp/getwxamsgconfig");
      ((b.a)localObject).oP(357);
      ((b.a)localObject).oR(0);
      ((b.a)localObject).oS(0);
      localObject = ((b.a)localObject).aDC();
      p.g(localObject, "builder.buildInstance()");
      AppMethodBeat.o(220340);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.c
 * JD-Core Version:    0.7.0.1
 */