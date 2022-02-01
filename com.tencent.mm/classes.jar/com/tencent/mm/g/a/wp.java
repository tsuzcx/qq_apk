package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wp
  extends IEvent
{
  public a ecH;
  
  public wp()
  {
    this((byte)0);
  }
  
  private wp(byte paramByte)
  {
    AppMethodBeat.i(116809);
    this.ecH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116809);
  }
  
  public static final class a
  {
    public int action = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.wp
 * JD-Core Version:    0.7.0.1
 */