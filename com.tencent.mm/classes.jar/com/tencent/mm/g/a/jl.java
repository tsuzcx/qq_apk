package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jl
  extends IEvent
{
  public a dOk;
  public b dOl;
  
  public jl()
  {
    this((byte)0);
  }
  
  private jl(byte paramByte)
  {
    AppMethodBeat.i(155368);
    this.dOk = new a();
    this.dOl = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155368);
  }
  
  public static final class a
  {
    public String dOm;
  }
  
  public static final class b
  {
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.jl
 * JD-Core Version:    0.7.0.1
 */