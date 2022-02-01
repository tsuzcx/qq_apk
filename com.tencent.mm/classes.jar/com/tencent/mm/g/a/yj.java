package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yj
  extends IEvent
{
  public a eeG;
  
  public yj()
  {
    this((byte)0);
  }
  
  private yj(byte paramByte)
  {
    AppMethodBeat.i(201284);
    this.eeG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(201284);
  }
  
  public static final class a
  {
    public String appId;
    public boolean dCs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.yj
 * JD-Core Version:    0.7.0.1
 */