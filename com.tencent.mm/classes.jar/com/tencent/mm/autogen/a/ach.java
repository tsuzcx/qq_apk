package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ach
  extends IEvent
{
  public a ifK;
  
  public ach()
  {
    this((byte)0);
  }
  
  private ach(byte paramByte)
  {
    AppMethodBeat.i(19845);
    this.ifK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19845);
  }
  
  public static final class a
  {
    public boolean ifL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ach
 * JD-Core Version:    0.7.0.1
 */