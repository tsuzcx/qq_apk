package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class e
  extends IEvent
{
  public a fut;
  
  public e()
  {
    this((byte)0);
  }
  
  private e(byte paramByte)
  {
    AppMethodBeat.i(140984);
    this.fut = new a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.e
 * JD-Core Version:    0.7.0.1
 */