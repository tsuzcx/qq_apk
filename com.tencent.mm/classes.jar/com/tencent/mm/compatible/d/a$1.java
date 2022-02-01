package com.tencent.mm.compatible.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class a$1
  implements a.a
{
  public final void c(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(261320);
    Log.w("MicroMsg.ReportDelegate", "hy: dummy reportKV, do nothing");
    AppMethodBeat.o(261320);
  }
  
  public final void w(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(155626);
    Log.w("MicroMsg.ReportDelegate", "hy: dummy reportIDKey, do nothing");
    AppMethodBeat.o(155626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.d.a.1
 * JD-Core Version:    0.7.0.1
 */