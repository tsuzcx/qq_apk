package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hm
  extends IEvent
{
  public a dLV;
  
  public hm()
  {
    this((byte)0);
  }
  
  private hm(byte paramByte)
  {
    AppMethodBeat.i(208802);
    this.dLV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(208802);
  }
  
  public static final class a
  {
    public long id;
    public int stickyTime;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hm
 * JD-Core Version:    0.7.0.1
 */