package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uw
  extends IEvent
{
  public a ebg;
  public b ebh;
  
  public uw()
  {
    this((byte)0);
  }
  
  private uw(byte paramByte)
  {
    AppMethodBeat.i(125631);
    this.ebg = new a();
    this.ebh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125631);
  }
  
  public static final class a
  {
    public boolean ebi;
    public String ebj;
    public boolean ebk = false;
    public int type;
    public String videoPath;
  }
  
  public static final class b
  {
    public String ebj;
    public String ebl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.uw
 * JD-Core Version:    0.7.0.1
 */