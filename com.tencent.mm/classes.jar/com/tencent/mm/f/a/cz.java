package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cz
  extends IEvent
{
  public a fyF;
  
  public cz()
  {
    this((byte)0);
  }
  
  private cz(byte paramByte)
  {
    AppMethodBeat.i(42652);
    this.fyF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42652);
  }
  
  public static final class a
  {
    public long msgId;
    public int msgType;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.cz
 * JD-Core Version:    0.7.0.1
 */