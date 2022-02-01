package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nk
  extends IEvent
{
  public a fLN;
  
  public nk()
  {
    this((byte)0);
  }
  
  private nk(byte paramByte)
  {
    AppMethodBeat.i(247798);
    this.fLN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(247798);
  }
  
  public static final class a
  {
    public int fLO;
    public String id;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.nk
 * JD-Core Version:    0.7.0.1
 */