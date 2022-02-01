package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hh
  extends IEvent
{
  public a fDY;
  public b fDZ;
  
  public hh()
  {
    this((byte)0);
  }
  
  private hh(byte paramByte)
  {
    AppMethodBeat.i(106599);
    this.fDY = new a();
    this.fDZ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(106599);
  }
  
  public static final class a
  {
    public String fEa;
  }
  
  public static final class b
  {
    public int fxe = 0;
    public int fxf = 0;
    public int fxg = 0;
    public int fxh = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.hh
 * JD-Core Version:    0.7.0.1
 */