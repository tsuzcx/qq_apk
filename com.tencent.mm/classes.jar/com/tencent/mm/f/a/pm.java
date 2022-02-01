package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pm
  extends IEvent
{
  public a fOf;
  
  public pm()
  {
    this((byte)0);
  }
  
  private pm(byte paramByte)
  {
    AppMethodBeat.i(121051);
    this.fOf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121051);
  }
  
  public static final class a
  {
    public int fOg;
    public String fuO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.pm
 * JD-Core Version:    0.7.0.1
 */