package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ri
  extends IEvent
{
  public a fQt;
  public b fQu;
  
  public ri()
  {
    this((byte)0);
  }
  
  private ri(byte paramByte)
  {
    AppMethodBeat.i(149881);
    this.fQt = new a();
    this.fQu = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149881);
  }
  
  public static final class a
  {
    public String fQv;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ri
 * JD-Core Version:    0.7.0.1
 */