package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class aam
  extends IEvent
{
  public a fZF;
  
  public aam()
  {
    this((byte)0);
  }
  
  private aam(byte paramByte)
  {
    AppMethodBeat.i(19847);
    this.fZF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19847);
  }
  
  public static final class a
  {
    public String description;
    public ca fvt;
    public String xml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.aam
 * JD-Core Version:    0.7.0.1
 */