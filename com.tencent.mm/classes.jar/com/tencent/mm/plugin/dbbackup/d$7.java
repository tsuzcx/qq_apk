package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

final class d$7
  implements k.a
{
  d$7(d paramd) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(18976);
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString))) {
      d.biU();
    }
    AppMethodBeat.o(18976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.7
 * JD-Core Version:    0.7.0.1
 */