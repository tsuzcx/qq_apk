package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sw
  extends IEvent
{
  public a fSi;
  
  public sw()
  {
    this((byte)0);
  }
  
  private sw(byte paramByte)
  {
    AppMethodBeat.i(116043);
    this.fSi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116043);
  }
  
  public static final class a
  {
    public String appId;
    public String fSj;
    public String mediaTagName;
    public String pkgName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.sw
 * JD-Core Version:    0.7.0.1
 */