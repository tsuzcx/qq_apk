package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kb
  extends IEvent
{
  public a fHv;
  public b fHw;
  
  public kb()
  {
    this((byte)0);
  }
  
  private kb(byte paramByte)
  {
    AppMethodBeat.i(155368);
    this.fHv = new a();
    this.fHw = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155368);
  }
  
  public static final class a
  {
    public String fHx;
  }
  
  public static final class b
  {
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.kb
 * JD-Core Version:    0.7.0.1
 */