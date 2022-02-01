package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qu
  extends IEvent
{
  public a hTR;
  
  public qu()
  {
    this((byte)0);
  }
  
  private qu(byte paramByte)
  {
    AppMethodBeat.i(131793);
    this.hTR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131793);
  }
  
  public static final class a
  {
    public int action = 0;
    public long hTS;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.qu
 * JD-Core Version:    0.7.0.1
 */