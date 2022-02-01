package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yv
  extends IEvent
{
  public a ibZ;
  
  public yv()
  {
    this((byte)0);
  }
  
  private yv(byte paramByte)
  {
    AppMethodBeat.i(125643);
    this.ibZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125643);
  }
  
  public static final class a
  {
    public boolean ica;
    public boolean icb;
    public boolean icc;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.yv
 * JD-Core Version:    0.7.0.1
 */