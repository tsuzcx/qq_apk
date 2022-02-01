package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nh
  extends IEvent
{
  public a hPE;
  
  public nh()
  {
    this((byte)0);
  }
  
  private nh(byte paramByte)
  {
    AppMethodBeat.i(128845);
    this.hPE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(128845);
  }
  
  public static final class a
  {
    public String appid;
    public int hGE;
    public String returnKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.nh
 * JD-Core Version:    0.7.0.1
 */