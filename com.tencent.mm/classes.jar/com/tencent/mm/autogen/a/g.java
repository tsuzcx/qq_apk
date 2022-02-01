package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class g
  extends IEvent
{
  public a hyM;
  
  public g()
  {
    this((byte)0);
  }
  
  private g(byte paramByte)
  {
    AppMethodBeat.i(369401);
    this.hyM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369401);
  }
  
  public static final class a
  {
    public long hyN;
    public long id;
    public long localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.g
 * JD-Core Version:    0.7.0.1
 */