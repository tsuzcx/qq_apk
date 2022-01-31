package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.md;
import com.tencent.mm.openim.b.j;
import com.tencent.mm.sdk.b.a;

final class PluginOpenIM$3
  implements f
{
  PluginOpenIM$3(PluginOpenIM paramPluginOpenIM) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(78824);
    if ((paramm instanceof j))
    {
      paramString = (j)paramm;
      paramm = new md();
      paramm.cCj.cCk = paramString.cCk;
      a.ymk.l(paramm);
    }
    AppMethodBeat.o(78824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM.3
 * JD-Core Version:    0.7.0.1
 */