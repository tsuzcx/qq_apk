package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ay
  extends IEvent
{
  public a hAK;
  public ay.b hAL;
  
  public ay()
  {
    this((byte)0);
  }
  
  private ay(byte paramByte)
  {
    AppMethodBeat.i(155543);
    this.hAK = new a();
    this.hAL = new ay.b();
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
 * Qualified Name:     com.tencent.mm.autogen.a.ay
 * JD-Core Version:    0.7.0.1
 */