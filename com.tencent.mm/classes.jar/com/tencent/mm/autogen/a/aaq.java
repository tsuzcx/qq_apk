package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaq
  extends IEvent
{
  public a ieg;
  public b ieh;
  
  public aaq()
  {
    this((byte)0);
  }
  
  private aaq(byte paramByte)
  {
    AppMethodBeat.i(149891);
    this.ieg = new a();
    this.ieh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149891);
  }
  
  public static final class a
  {
    public boolean iei = false;
    public boolean iej = false;
  }
  
  public static final class b
  {
    public String iek;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aaq
 * JD-Core Version:    0.7.0.1
 */