package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gi
  extends IEvent
{
  public a dKe;
  
  public gi()
  {
    this((byte)0);
  }
  
  private gi(byte paramByte)
  {
    AppMethodBeat.i(116026);
    this.dKe = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116026);
  }
  
  public static final class a
  {
    public int dKf;
    public String fileName;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.gi
 * JD-Core Version:    0.7.0.1
 */