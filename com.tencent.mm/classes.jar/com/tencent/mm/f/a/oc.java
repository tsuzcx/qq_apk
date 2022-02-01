package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class oc
  extends IEvent
{
  public a fMT;
  
  public oc()
  {
    this((byte)0);
  }
  
  private oc(byte paramByte)
  {
    AppMethodBeat.i(131792);
    this.fMT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131792);
  }
  
  public static final class a
  {
    public int fMU = 0;
    public boolean fMV = false;
    public String fMW;
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.oc
 * JD-Core Version:    0.7.0.1
 */