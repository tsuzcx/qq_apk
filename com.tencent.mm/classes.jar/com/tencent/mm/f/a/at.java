package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class at
  extends IEvent
{
  public a fwm;
  public at.b fwn;
  
  public at()
  {
    this((byte)0);
  }
  
  private at(byte paramByte)
  {
    AppMethodBeat.i(155543);
    this.fwm = new a();
    this.fwn = new at.b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155543);
  }
  
  public static final class a
  {
    public String event;
    public int position = 0;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.at
 * JD-Core Version:    0.7.0.1
 */