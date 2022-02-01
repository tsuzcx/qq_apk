package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cl
  extends IEvent
{
  public a fxZ;
  public b fya;
  
  public cl()
  {
    this((byte)0);
  }
  
  private cl(byte paramByte)
  {
    AppMethodBeat.i(43440);
    this.fxZ = new a();
    this.fya = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(43440);
  }
  
  public static final class a
  {
    public String username;
  }
  
  public static final class b
  {
    public String appId;
    public String[] cxM;
    public String nickname;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.cl
 * JD-Core Version:    0.7.0.1
 */