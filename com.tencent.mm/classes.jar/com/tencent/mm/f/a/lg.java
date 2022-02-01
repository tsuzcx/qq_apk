package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lg
  extends IEvent
{
  public a fIX;
  
  public lg()
  {
    this((byte)0);
  }
  
  private lg(byte paramByte)
  {
    AppMethodBeat.i(121032);
    this.fIX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121032);
  }
  
  public static final class a
  {
    public String fIY;
    public String fIZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.lg
 * JD-Core Version:    0.7.0.1
 */