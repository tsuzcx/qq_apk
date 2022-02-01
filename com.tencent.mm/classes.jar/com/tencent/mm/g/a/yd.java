package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yd
  extends IEvent
{
  public a eey;
  
  public yd()
  {
    this((byte)0);
  }
  
  private yd(byte paramByte)
  {
    AppMethodBeat.i(116055);
    this.eey = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116055);
  }
  
  public static final class a
  {
    public String ecu;
    public int eeA = 0;
    public String eeq;
    public byte[] ees;
    public String eez;
    public String id;
    public int ret;
    public String source;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.yd
 * JD-Core Version:    0.7.0.1
 */