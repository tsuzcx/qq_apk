package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.sdk.event.IListener;

public final class v
  extends IListener<ml>
{
  private static boolean dlS = false;
  private int dlT;
  private int dlU;
  
  public v(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(161231);
    this.dlT = paramInt1;
    this.dlU = paramInt2;
    this.__eventId = ml.class.getName().hashCode();
    AppMethodBeat.o(161231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.v
 * JD-Core Version:    0.7.0.1
 */