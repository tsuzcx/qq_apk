package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.czn;

final class q$3$1
  implements f
{
  q$3$1(q.3 param3) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(129355);
    if ((paramm != null) && ((paramm.getReqResp() instanceof com.tencent.mm.ai.b)))
    {
      paramString = (czn)((com.tencent.mm.ai.b)paramm.getReqResp()).fsW.fta;
      paramInt1 = q.a(this.gUw.gUt);
      paramInt2 = paramString.version;
      paramString = new q.3.1.1(this);
      ba.a(al.D("@LibraryAppId", paramInt1, paramInt2), paramString);
    }
    g.RK().eHt.b(1168, this);
    AppMethodBeat.o(129355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.q.3.1
 * JD-Core Version:    0.7.0.1
 */