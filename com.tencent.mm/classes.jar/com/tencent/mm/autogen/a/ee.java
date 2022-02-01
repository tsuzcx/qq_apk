package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ee
  extends IEvent
{
  public a hDW;
  
  public ee()
  {
    this((byte)0);
  }
  
  private ee(byte paramByte)
  {
    AppMethodBeat.i(104416);
    this.hDW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104416);
  }
  
  public static final class a
  {
    public String hDX;
    public String productId;
    public int progress = 0;
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ee
 * JD-Core Version:    0.7.0.1
 */