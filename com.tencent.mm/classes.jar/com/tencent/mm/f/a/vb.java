package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vb
  extends IEvent
{
  public a fUp;
  
  public vb()
  {
    this((byte)0);
  }
  
  private vb(byte paramByte)
  {
    AppMethodBeat.i(19834);
    this.fUp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19834);
  }
  
  public static final class a
  {
    public String fSj;
    public int msgType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.vb
 * JD-Core Version:    0.7.0.1
 */