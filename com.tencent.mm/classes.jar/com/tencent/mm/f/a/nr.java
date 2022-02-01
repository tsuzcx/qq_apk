package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nr
  extends IEvent
{
  public a fMg;
  
  public nr()
  {
    this((byte)0);
  }
  
  private nr(byte paramByte)
  {
    AppMethodBeat.i(149874);
    this.fMg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149874);
  }
  
  public static final class a
  {
    public String businessType;
    public int errCode;
    public String fMh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.nr
 * JD-Core Version:    0.7.0.1
 */