package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class zf
  extends IEvent
{
  public a efq;
  
  public zf()
  {
    this((byte)0);
  }
  
  private zf(byte paramByte)
  {
    AppMethodBeat.i(19847);
    this.efq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19847);
  }
  
  public static final class a
  {
    public ca dCM;
    public String description;
    public String xml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.zf
 * JD-Core Version:    0.7.0.1
 */