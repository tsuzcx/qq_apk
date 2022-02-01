package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class on
  extends IEvent
{
  public a fNp;
  
  public on()
  {
    this((byte)0);
  }
  
  private on(byte paramByte)
  {
    AppMethodBeat.i(125622);
    this.fNp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125622);
  }
  
  public static final class a
  {
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.on
 * JD-Core Version:    0.7.0.1
 */