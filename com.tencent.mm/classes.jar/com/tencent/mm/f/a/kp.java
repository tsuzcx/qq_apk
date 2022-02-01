package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kp
  extends IEvent
{
  public a fIe;
  public b fIf;
  
  public kp()
  {
    this((byte)0);
  }
  
  private kp(byte paramByte)
  {
    AppMethodBeat.i(149865);
    this.fIe = new a();
    this.fIf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149865);
  }
  
  public static final class a
  {
    public String userName;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.kp
 * JD-Core Version:    0.7.0.1
 */