package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class v
  extends IEvent
{
  public a dCL;
  
  public v()
  {
    this((byte)0);
  }
  
  private v(byte paramByte)
  {
    AppMethodBeat.i(19787);
    this.dCL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19787);
  }
  
  public static final class a
  {
    public ca dCM;
    public k.b dCN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.v
 * JD-Core Version:    0.7.0.1
 */