package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ku
  extends IEvent
{
  public a hMs;
  
  public ku()
  {
    this((byte)0);
  }
  
  private ku(byte paramByte)
  {
    AppMethodBeat.i(149861);
    this.hMs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149861);
  }
  
  public static final class a
  {
    public String appId;
    public String hDd;
    public int hMt;
    public int opType;
    public String openId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ku
 * JD-Core Version:    0.7.0.1
 */