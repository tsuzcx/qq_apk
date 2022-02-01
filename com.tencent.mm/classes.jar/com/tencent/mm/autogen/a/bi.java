package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bi
  extends IEvent
{
  public a hBp;
  public b hBq;
  
  public bi()
  {
    this((byte)0);
  }
  
  private bi(byte paramByte)
  {
    AppMethodBeat.i(91198);
    this.hBp = new a();
    this.hBq = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91198);
  }
  
  public static final class a
  {
    public String hBr;
    public boolean hBs;
    public boolean hBt;
    public boolean hBu;
  }
  
  public static final class b
  {
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.bi
 * JD-Core Version:    0.7.0.1
 */