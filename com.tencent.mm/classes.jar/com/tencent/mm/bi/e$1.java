package com.tencent.mm.bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.d;

final class e$1
  implements ao.b.a
{
  e$1(e parame, bi.d paramd) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16631);
    aw.aaz();
    ab.d("MicroMsg.VerifyMessageExtension", String.valueOf(c.YA().arw(this.fUW.yOx)));
    paramString = new jh();
    paramString.cyK.cyL = this.fUW.yOx;
    paramString.cyK.type = 1;
    a.ymk.l(paramString);
    AppMethodBeat.o(16631);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bi.e.1
 * JD-Core Version:    0.7.0.1
 */