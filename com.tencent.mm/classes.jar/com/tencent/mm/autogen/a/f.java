package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class f
  extends IEvent
{
  public a hyL;
  
  public f()
  {
    this((byte)0);
  }
  
  private f(byte paramByte)
  {
    AppMethodBeat.i(140984);
    this.hyL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140984);
  }
  
  public static final class a
  {
    public boolean active;
    public String className;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.f
 * JD-Core Version:    0.7.0.1
 */