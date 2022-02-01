package com.tencent.mm.network;

import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bo;

final class t$10
  extends bo<Object>
{
  t$10(t paramt, Object paramObject, boolean paramBoolean)
  {
    super(3000L, paramObject, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(132782);
    Mars.onForeground(this.hLu);
    a.ep(this.hLu);
    b.eh(this.hLu);
    AppMethodBeat.o(132782);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.t.10
 * JD-Core Version:    0.7.0.1
 */