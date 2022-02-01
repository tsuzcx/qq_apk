package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vt
  extends IEvent
{
  public a ebU;
  
  public vt()
  {
    this((byte)0);
  }
  
  private vt(byte paramByte)
  {
    AppMethodBeat.i(125642);
    this.ebU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125642);
  }
  
  public static final class a
  {
    public boolean ebV;
    public int key;
    public int value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.vt
 * JD-Core Version:    0.7.0.1
 */