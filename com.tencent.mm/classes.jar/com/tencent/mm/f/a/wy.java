package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wy
  extends IEvent
{
  public a fVW;
  
  public wy()
  {
    this((byte)0);
  }
  
  private wy(byte paramByte)
  {
    AppMethodBeat.i(125642);
    this.fVW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125642);
  }
  
  public static final class a
  {
    public boolean fVX;
    public int key;
    public int value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wy
 * JD-Core Version:    0.7.0.1
 */