package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aam
  extends IEvent
{
  public a ehm;
  
  public aam()
  {
    this((byte)0);
  }
  
  private aam(byte paramByte)
  {
    AppMethodBeat.i(192280);
    this.ehm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(192280);
  }
  
  public static final class a
  {
    public int ehn;
    public boolean eho;
    public int ehp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.aam
 * JD-Core Version:    0.7.0.1
 */