package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jt
  extends IEvent
{
  public a fGX;
  public b fGY;
  
  public jt()
  {
    this((byte)0);
  }
  
  private jt(byte paramByte)
  {
    AppMethodBeat.i(91206);
    this.fGX = new a();
    this.fGY = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91206);
  }
  
  public static final class a
  {
    public boolean fGZ = false;
    public int fHa = 0;
    public String fHb;
  }
  
  public static final class b
  {
    public String fHc;
    public String fHd;
    public boolean isSuccess = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.jt
 * JD-Core Version:    0.7.0.1
 */