package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.chb;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"})
public final class c
{
  public static final a lyq;
  
  static
  {
    AppMethodBeat.i(207745);
    lyq = new a((byte)0);
    AppMethodBeat.o(207745);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-compat_release"})
  public static final class a
  {
    public static d bgN()
    {
      AppMethodBeat.i(207513);
      Object localObject = new d.a();
      ((d.a)localObject).c((a)new cha());
      ((d.a)localObject).d((a)new chb());
      ((d.a)localObject).TW("/cgi-bin/mmbiz-bin/wxaapp/getwxamsgconfig");
      ((d.a)localObject).vD(357);
      ((d.a)localObject).vF(0);
      ((d.a)localObject).vG(0);
      localObject = ((d.a)localObject).bgN();
      p.j(localObject, "builder.buildInstance()");
      AppMethodBeat.o(207513);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.c
 * JD-Core Version:    0.7.0.1
 */