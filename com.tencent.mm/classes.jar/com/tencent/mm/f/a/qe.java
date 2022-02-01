package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qe
  extends IEvent
{
  public a fOR;
  
  public qe()
  {
    this((byte)0);
  }
  
  private qe(byte paramByte)
  {
    AppMethodBeat.i(149877);
    this.fOR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149877);
  }
  
  public static final class a
  {
    public boolean pause;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.qe
 * JD-Core Version:    0.7.0.1
 */