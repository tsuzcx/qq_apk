package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tr
  extends IEvent
{
  public a eae;
  
  public tr()
  {
    this((byte)0);
  }
  
  private tr(byte paramByte)
  {
    AppMethodBeat.i(200180);
    this.eae = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(200180);
  }
  
  public static final class a
  {
    public String dkU;
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.tr
 * JD-Core Version:    0.7.0.1
 */