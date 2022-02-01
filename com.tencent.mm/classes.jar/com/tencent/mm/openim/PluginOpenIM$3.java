package com.tencent.mm.openim;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.openim.b.j;
import com.tencent.mm.sdk.b.a;

final class PluginOpenIM$3
  implements f
{
  PluginOpenIM$3(PluginOpenIM paramPluginOpenIM) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(151167);
    if ((paramn instanceof j))
    {
      paramString = (j)paramn;
      paramn = new oh();
      paramn.dDk.dDl = paramString.dDl;
      a.IvT.l(paramn);
    }
    AppMethodBeat.o(151167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.PluginOpenIM.3
 * JD-Core Version:    0.7.0.1
 */