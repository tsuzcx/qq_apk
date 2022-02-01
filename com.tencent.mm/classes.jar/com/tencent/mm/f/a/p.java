package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class p
  extends IEvent
{
  public a fuY;
  
  public p()
  {
    this((byte)0);
  }
  
  private p(byte paramByte)
  {
    AppMethodBeat.i(207649);
    this.fuY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(207649);
  }
  
  public static final class a
  {
    public String appId;
    public boolean fuZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.p
 * JD-Core Version:    0.7.0.1
 */