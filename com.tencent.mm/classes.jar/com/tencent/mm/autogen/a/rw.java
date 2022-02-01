package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rw
  extends IEvent
{
  public a hUY;
  public b hUZ;
  
  public rw()
  {
    this((byte)0);
  }
  
  private rw(byte paramByte)
  {
    AppMethodBeat.i(130032);
    this.hUY = new a();
    this.hUZ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130032);
  }
  
  public static final class a
  {
    public int type;
  }
  
  public static final class b
  {
    public boolean hUX = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.a.rw
 * JD-Core Version:    0.7.0.1
 */