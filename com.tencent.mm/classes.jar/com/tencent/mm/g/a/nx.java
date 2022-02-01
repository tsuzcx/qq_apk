package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nx
  extends IEvent
{
  public a dTZ;
  
  public nx()
  {
    this((byte)0);
  }
  
  private nx(byte paramByte)
  {
    AppMethodBeat.i(42654);
    this.dTZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42654);
  }
  
  public static final class a
  {
    public String nickName;
    public int type;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.nx
 * JD-Core Version:    0.7.0.1
 */