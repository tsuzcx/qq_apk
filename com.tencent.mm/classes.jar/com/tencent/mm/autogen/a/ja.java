package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ja
  extends IEvent
{
  public a hKF;
  
  public ja()
  {
    this((byte)0);
  }
  
  private ja(byte paramByte)
  {
    AppMethodBeat.i(369460);
    this.hKF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369460);
  }
  
  public static final class a
  {
    public String liveId;
    public int source;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ja
 * JD-Core Version:    0.7.0.1
 */