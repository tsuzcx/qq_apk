package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.b.a;
import java.util.Map;

final class e$10
  implements Runnable
{
  e$10(e parame, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(50567);
    h localh = (h)this.fzs.fyM.get(this.Cq);
    if (localh != null)
    {
      lu locallu = new lu();
      locallu.cBN.cut = 3;
      locallu.cBN.retCode = 0;
      locallu.cBN.cBO = this.Cq;
      locallu.cBN.offset = this.fzv;
      locallu.cBN.length = this.fzw;
      a.ymk.l(locallu);
      if ((this.fzv == 0) && (this.fzw >= localh.edI)) {
        e.a(u.vr(localh.filename), localh.edI, localh.edH);
      }
    }
    AppMethodBeat.o(50567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.al.e.10
 * JD-Core Version:    0.7.0.1
 */