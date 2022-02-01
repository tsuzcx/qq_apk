package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ie
  extends IEvent
{
  public a hJA;
  
  public ie()
  {
    this((byte)0);
  }
  
  private ie(byte paramByte)
  {
    AppMethodBeat.i(369434);
    this.hJA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369434);
  }
  
  public static final class a
  {
    public long id;
    public int stickyTime;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ie
 * JD-Core Version:    0.7.0.1
 */