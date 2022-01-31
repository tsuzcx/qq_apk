package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import java.util.HashMap;

final class a$3
  implements k.a
{
  a$3(a parama) {}
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(136652);
    if ((paramString.equals("*")) || (paramString.equals("chatroomname")))
    {
      AppMethodBeat.o(136652);
      return;
    }
    if (!a.b(this.mUg).containsKey(paramString)) {
      a.e(this.mUg).a(65556, new a.h(this.mUg, paramString));
    }
    AppMethodBeat.o(136652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.3
 * JD-Core Version:    0.7.0.1
 */