package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xy
  extends IEvent
{
  public a eem;
  
  public xy()
  {
    this((byte)0);
  }
  
  private xy(byte paramByte)
  {
    AppMethodBeat.i(140990);
    this.eem = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140990);
  }
  
  public static final class a
  {
    public String className;
    public int een = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.xy
 * JD-Core Version:    0.7.0.1
 */