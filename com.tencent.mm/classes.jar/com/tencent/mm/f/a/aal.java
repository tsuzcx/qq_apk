package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aal
  extends IEvent
{
  public a fZE;
  
  public aal()
  {
    this((byte)0);
  }
  
  private aal(byte paramByte)
  {
    AppMethodBeat.i(19846);
    this.fZE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19846);
  }
  
  public static final class a
  {
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.aal
 * JD-Core Version:    0.7.0.1
 */