package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pf
  extends IEvent
{
  public a hSl;
  
  public pf()
  {
    this((byte)0);
  }
  
  private pf(byte paramByte)
  {
    AppMethodBeat.i(116461);
    this.hSl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116461);
  }
  
  public static final class a
  {
    public String chatroomName;
    public boolean hRY = false;
    public int hSm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pf
 * JD-Core Version:    0.7.0.1
 */