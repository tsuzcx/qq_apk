package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bb
  extends IEvent
{
  public a dEk;
  
  public bb()
  {
    this((byte)0);
  }
  
  private bb(byte paramByte)
  {
    AppMethodBeat.i(115971);
    this.dEk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115971);
  }
  
  public static final class a
  {
    public int index;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.bb
 * JD-Core Version:    0.7.0.1
 */