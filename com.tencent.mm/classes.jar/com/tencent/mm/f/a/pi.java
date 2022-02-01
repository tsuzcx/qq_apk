package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pi
  extends IEvent
{
  public a fNZ;
  
  public pi()
  {
    this((byte)0);
  }
  
  private pi(byte paramByte)
  {
    AppMethodBeat.i(131793);
    this.fNZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131793);
  }
  
  public static final class a
  {
    public int action = 0;
    public long fOa;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.pi
 * JD-Core Version:    0.7.0.1
 */