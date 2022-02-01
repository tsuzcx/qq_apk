package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vx
  extends IEvent
{
  public a ebX;
  
  public vx()
  {
    this((byte)0);
  }
  
  private vx(byte paramByte)
  {
    AppMethodBeat.i(125643);
    this.ebX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125643);
  }
  
  public static final class a
  {
    public boolean ebY;
    public boolean ebZ;
    public boolean eca;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.vx
 * JD-Core Version:    0.7.0.1
 */