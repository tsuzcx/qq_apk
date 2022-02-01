package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mu
  extends IEvent
{
  public a fKS;
  
  public mu()
  {
    this((byte)0);
  }
  
  private mu(byte paramByte)
  {
    AppMethodBeat.i(19818);
    this.fKS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19818);
  }
  
  public static final class a
  {
    public String fKT;
    public int opType;
    public int viewId = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.mu
 * JD-Core Version:    0.7.0.1
 */