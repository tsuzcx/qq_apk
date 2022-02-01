package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ja
  extends IEvent
{
  public a fGl;
  
  public ja()
  {
    this((byte)0);
  }
  
  private ja(byte paramByte)
  {
    AppMethodBeat.i(209088);
    this.fGl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(209088);
  }
  
  public static final class a
  {
    public String fGm;
    public boolean fGn;
    public int fGo;
    public int opType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ja
 * JD-Core Version:    0.7.0.1
 */