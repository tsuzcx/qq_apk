package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.nc;
import com.tencent.mm.sdk.event.IListener;

public final class v
  extends IListener<nc>
{
  private static boolean fdx = false;
  private int fdy;
  private int fdz;
  
  public v(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(161231);
    this.fdy = paramInt1;
    this.fdz = paramInt2;
    this.__eventId = nc.class.getName().hashCode();
    AppMethodBeat.o(161231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.v
 * JD-Core Version:    0.7.0.1
 */