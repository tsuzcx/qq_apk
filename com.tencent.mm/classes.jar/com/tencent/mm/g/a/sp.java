package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class sp
  extends IEvent
{
  public a dZg;
  
  public sp()
  {
    this((byte)0);
  }
  
  private sp(byte paramByte)
  {
    AppMethodBeat.i(19829);
    this.dZg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19829);
  }
  
  public static final class a
  {
    public ca dCM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.sp
 * JD-Core Version:    0.7.0.1
 */