package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qt
  extends IEvent
{
  public a fPz;
  
  public qt()
  {
    this((byte)0);
  }
  
  private qt(byte paramByte)
  {
    AppMethodBeat.i(117615);
    this.fPz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117615);
  }
  
  public static final class a
  {
    public int scene;
    public String sessionId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.qt
 * JD-Core Version:    0.7.0.1
 */