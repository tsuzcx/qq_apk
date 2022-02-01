package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pj
  extends IEvent
{
  public a hSA;
  public b hSB;
  
  public pj()
  {
    this((byte)0);
  }
  
  private pj(byte paramByte)
  {
    AppMethodBeat.i(116462);
    this.hSA = new a();
    this.hSB = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116462);
  }
  
  public static final class a
  {
    public String chatroomName;
    public boolean hRY = false;
    public String hSC;
  }
  
  public static final class b
  {
    public int errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pj
 * JD-Core Version:    0.7.0.1
 */