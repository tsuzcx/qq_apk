package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.bo;

final class a$4
  implements k.a
{
  a$4(a parama) {}
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(136653);
    paramString = paramString.split(" ");
    if ((paramString == null) || (paramString.length == 0))
    {
      AppMethodBeat.o(136653);
      return;
    }
    if (paramString[0].equals("update"))
    {
      int i = 1;
      while (i < paramString.length)
      {
        long l = bo.getLong(paramString[i], 0L);
        a.e(this.mUg).a(65554, new a.v(this.mUg, l));
        i += 1;
      }
      a.e(this.mUg).a(65556, new a.u(this.mUg, (byte)0));
    }
    AppMethodBeat.o(136653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.4
 * JD-Core Version:    0.7.0.1
 */