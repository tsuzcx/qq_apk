package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ui
  extends IEvent
{
  public a eaH;
  
  public ui()
  {
    this((byte)0);
  }
  
  private ui(byte paramByte)
  {
    AppMethodBeat.i(194253);
    this.eaH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(194253);
  }
  
  public static final class a
  {
    public String dNA;
    public long eaB;
    public Boolean eaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ui
 * JD-Core Version:    0.7.0.1
 */