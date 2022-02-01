package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wi
  extends IEvent
{
  public a ect;
  
  public wi()
  {
    this((byte)0);
  }
  
  private wi(byte paramByte)
  {
    AppMethodBeat.i(125647);
    this.ect = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125647);
  }
  
  public static final class a
  {
    public String ecu;
    public String id;
    public String result;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.wi
 * JD-Core Version:    0.7.0.1
 */