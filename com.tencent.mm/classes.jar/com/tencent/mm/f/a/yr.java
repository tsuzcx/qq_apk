package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yr
  extends IEvent
{
  public a fXR;
  
  public yr()
  {
    this((byte)0);
  }
  
  private yr(byte paramByte)
  {
    AppMethodBeat.i(131795);
    this.fXR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131795);
  }
  
  public static final class a
  {
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.yr
 * JD-Core Version:    0.7.0.1
 */