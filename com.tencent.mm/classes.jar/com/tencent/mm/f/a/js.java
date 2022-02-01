package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class js
  extends IEvent
{
  public a fGV;
  
  public js()
  {
    this((byte)0);
  }
  
  private js(byte paramByte)
  {
    AppMethodBeat.i(149861);
    this.fGV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149861);
  }
  
  public static final class a
  {
    public String appId;
    public int fGW;
    public String fyu;
    public int opType;
    public String openId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.js
 * JD-Core Version:    0.7.0.1
 */