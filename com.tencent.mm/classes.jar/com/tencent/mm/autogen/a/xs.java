package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xs
  extends IEvent
{
  public a ibg;
  
  public xs()
  {
    this((byte)0);
  }
  
  private xs(byte paramByte)
  {
    AppMethodBeat.i(19836);
    this.ibg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19836);
  }
  
  public static final class a
  {
    public byte[] data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.xs
 * JD-Core Version:    0.7.0.1
 */