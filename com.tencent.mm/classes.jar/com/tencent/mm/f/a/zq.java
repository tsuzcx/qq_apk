package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zq
  extends IEvent
{
  public a fYV;
  
  public zq()
  {
    this((byte)0);
  }
  
  private zq(byte paramByte)
  {
    AppMethodBeat.i(207487);
    this.fYV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(207487);
  }
  
  public static final class a
  {
    public String appId;
    public boolean fuZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.zq
 * JD-Core Version:    0.7.0.1
 */