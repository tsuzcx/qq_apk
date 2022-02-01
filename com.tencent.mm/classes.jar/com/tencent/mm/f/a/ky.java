package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ky
  extends IEvent
{
  public a fIC;
  public b fID;
  
  public ky()
  {
    this((byte)0);
  }
  
  private ky(byte paramByte)
  {
    AppMethodBeat.i(153017);
    this.fIC = new a();
    this.fID = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153017);
  }
  
  public static final class a
  {
    public String fIE;
  }
  
  public static final class b
  {
    public String fIF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ky
 * JD-Core Version:    0.7.0.1
 */