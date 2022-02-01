package com.tencent.mm.plugin.expt.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ae;

final class a$3
  implements f
{
  a$3(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(122319);
    ae.i("MicroMsg.ExptService", "scene[%d] errType[%d] errCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramn.hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramn instanceof b)) {
      a.f(this.riD);
    }
    AppMethodBeat.o(122319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.f.a.3
 * JD-Core Version:    0.7.0.1
 */