package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.cxb;
import com.tencent.mm.protocal.protobuf.cxc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig;", "", "()V", "Companion", "plugin-compat_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a opR;
  
  static
  {
    AppMethodBeat.i(233810);
    opR = new a((byte)0);
    AppMethodBeat.o(233810);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/modelappbrand/CgiGetNotifyConfig$Companion;", "", "()V", "buildInstance", "Lcom/tencent/mm/modelbase/CommReqResp;", "plugin-compat_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static c bEF()
    {
      AppMethodBeat.i(233807);
      Object localObject = new c.a();
      ((c.a)localObject).otE = ((a)new cxb());
      ((c.a)localObject).otF = ((a)new cxc());
      ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxamsgconfig";
      ((c.a)localObject).funcId = 357;
      ((c.a)localObject).otG = 0;
      ((c.a)localObject).respCmdId = 0;
      localObject = ((c.a)localObject).bEF();
      s.s(localObject, "builder.buildInstance()");
      AppMethodBeat.o(233807);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.d
 * JD-Core Version:    0.7.0.1
 */