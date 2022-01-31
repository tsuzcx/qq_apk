package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.al;

public final class y
  extends o.a
{
  public final void reportKV(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(72652);
    g.RO().ac(new y.1(this, paramBoolean1, paramLong, paramString, paramBoolean2));
    AppMethodBeat.o(72652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.network.y
 * JD-Core Version:    0.7.0.1
 */