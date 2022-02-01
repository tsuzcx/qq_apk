package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jj
  extends IEvent
{
  public a hKV;
  
  public jj()
  {
    this((byte)0);
  }
  
  private jj(byte paramByte)
  {
    AppMethodBeat.i(369473);
    this.hKV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369473);
  }
  
  public static final class a
  {
    public long feedId;
    public int hKW;
    public int hKX;
    public String mediaId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.a.jj
 * JD-Core Version:    0.7.0.1
 */