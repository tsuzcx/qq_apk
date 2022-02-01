package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ws
  extends IEvent
{
  public a fVM;
  
  public ws()
  {
    this((byte)0);
  }
  
  private ws(byte paramByte)
  {
    AppMethodBeat.i(125637);
    this.fVM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125637);
  }
  
  public static final class a
  {
    public String fAg;
    public String fLp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ws
 * JD-Core Version:    0.7.0.1
 */