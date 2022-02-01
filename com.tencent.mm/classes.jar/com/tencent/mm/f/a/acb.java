package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class acb
  extends IEvent
{
  public a gbZ;
  
  public acb()
  {
    this((byte)0);
  }
  
  private acb(byte paramByte)
  {
    AppMethodBeat.i(205489);
    this.gbZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(205489);
  }
  
  public static final class a
  {
    public String bjh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.acb
 * JD-Core Version:    0.7.0.1
 */