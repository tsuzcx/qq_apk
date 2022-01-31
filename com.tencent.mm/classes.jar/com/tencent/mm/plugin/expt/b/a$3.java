package com.tencent.mm.plugin.expt.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3
  implements f
{
  a$3(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(73488);
    ab.i("MicroMsg.ExptService", "scene[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramm.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof b)) {
      a.d(this.mbZ);
    }
    AppMethodBeat.o(73488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.a.3
 * JD-Core Version:    0.7.0.1
 */