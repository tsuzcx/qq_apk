package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vf
  extends IEvent
{
  public a fUs;
  
  public vf()
  {
    this((byte)0);
  }
  
  private vf(byte paramByte)
  {
    AppMethodBeat.i(262454);
    this.fUs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(262454);
  }
  
  public static final class a
  {
    public long fUt;
    public String sessionId;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.vf
 * JD-Core Version:    0.7.0.1
 */