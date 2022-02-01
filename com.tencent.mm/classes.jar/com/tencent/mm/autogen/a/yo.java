package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yo
  extends IEvent
{
  public a ibP;
  public b ibQ;
  
  public yo()
  {
    this((byte)0);
  }
  
  private yo(byte paramByte)
  {
    AppMethodBeat.i(148771);
    this.ibP = new a();
    this.ibQ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(148771);
  }
  
  public static final class a
  {
    public String ibR;
  }
  
  public static final class b
  {
    public Object result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.yo
 * JD-Core Version:    0.7.0.1
 */