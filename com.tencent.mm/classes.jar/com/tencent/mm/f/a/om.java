package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class om
  extends IEvent
{
  public a fNo;
  
  public om()
  {
    this((byte)0);
  }
  
  private om(byte paramByte)
  {
    AppMethodBeat.i(252834);
    this.fNo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(252834);
  }
  
  public static final class a
  {
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.om
 * JD-Core Version:    0.7.0.1
 */