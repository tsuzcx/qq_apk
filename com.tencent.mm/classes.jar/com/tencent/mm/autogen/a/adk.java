package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class adk
  extends IEvent
{
  public a ihB;
  public b ihC;
  
  public adk()
  {
    this((byte)0);
  }
  
  private adk(byte paramByte)
  {
    AppMethodBeat.i(116059);
    this.ihB = new a();
    this.ihC = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116059);
  }
  
  public static final class a
  {
    public String hPj;
  }
  
  public static final class b
  {
    public boolean ihD;
    public boolean ihE;
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.adk
 * JD-Core Version:    0.7.0.1
 */