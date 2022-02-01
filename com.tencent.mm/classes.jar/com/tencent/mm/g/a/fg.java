package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fg
  extends IEvent
{
  public a dID;
  
  public fg()
  {
    this((byte)0);
  }
  
  private fg(byte paramByte)
  {
    AppMethodBeat.i(19799);
    this.dID = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19799);
  }
  
  public static final class a
  {
    public boolean brW;
    public String dIx;
    public String mac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.fg
 * JD-Core Version:    0.7.0.1
 */