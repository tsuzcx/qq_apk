package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nf
  extends IEvent
{
  public a dTf;
  
  public nf()
  {
    this((byte)0);
  }
  
  private nf(byte paramByte)
  {
    AppMethodBeat.i(116461);
    this.dTf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116461);
  }
  
  public static final class a
  {
    public String chatroomName;
    public boolean dSQ = false;
    public int dTg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.nf
 * JD-Core Version:    0.7.0.1
 */