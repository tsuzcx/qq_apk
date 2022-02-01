package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.sdk.b.a;

final class a$1
  implements b
{
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(210200);
    paramString1 = new kq();
    paramString1.dxE.action = 1;
    a.IbL.l(paramString1);
    AppMethodBeat.o(210200);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(210199);
    paramString1 = new kq();
    paramString1.dxE.action = 0;
    a.IbL.l(paramString1);
    AppMethodBeat.o(210199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.c.a.1
 * JD-Core Version:    0.7.0.1
 */