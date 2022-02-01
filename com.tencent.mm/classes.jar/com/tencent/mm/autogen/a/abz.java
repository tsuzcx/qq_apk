package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abz
  extends IEvent
{
  public a ify;
  public b ifz;
  
  public abz()
  {
    this((byte)0);
  }
  
  private abz(byte paramByte)
  {
    AppMethodBeat.i(121052);
    this.ify = new a();
    this.ifz = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121052);
  }
  
  public static final class a
  {
    public int action;
    public String hzi;
    public int option;
  }
  
  public static final class b
  {
    public boolean ifA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abz
 * JD-Core Version:    0.7.0.1
 */