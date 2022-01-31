package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.Map;

final class e$9
  implements Runnable
{
  e$9(e parame, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(50566);
    Object localObject = (h)this.fzs.fyM.get(this.Cq);
    if (localObject != null)
    {
      if (((h)localObject).edQ != null) {
        ((h)localObject).edQ.m(this.Cq, this.fzv, this.fzw);
      }
      localObject = new lu();
      ((lu)localObject).cBN.cut = 2;
      ((lu)localObject).cBN.retCode = 0;
      ((lu)localObject).cBN.cBO = this.Cq;
      ((lu)localObject).cBN.offset = this.fzv;
      ((lu)localObject).cBN.length = this.fzw;
      a.ymk.l((b)localObject);
    }
    AppMethodBeat.o(50566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.al.e.9
 * JD-Core Version:    0.7.0.1
 */