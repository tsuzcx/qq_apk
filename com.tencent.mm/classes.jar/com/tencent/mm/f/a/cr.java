package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cr
  extends IEvent
{
  public a fyp;
  
  public cr()
  {
    this((byte)0);
  }
  
  private cr(byte paramByte)
  {
    AppMethodBeat.i(93322);
    this.fyp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93322);
  }
  
  public static final class a
  {
    public int resultCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.cr
 * JD-Core Version:    0.7.0.1
 */