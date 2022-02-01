package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bl
  extends IEvent
{
  public a dEG;
  
  public bl()
  {
    this((byte)0);
  }
  
  private bl(byte paramByte)
  {
    AppMethodBeat.i(114790);
    this.dEG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114790);
  }
  
  public static final class a
  {
    public boolean isStarted = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.bl
 * JD-Core Version:    0.7.0.1
 */