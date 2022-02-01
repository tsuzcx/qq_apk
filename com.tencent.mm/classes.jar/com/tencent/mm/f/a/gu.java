package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gu
  extends IEvent
{
  public a fDj;
  
  public gu()
  {
    this((byte)0);
  }
  
  private gu(byte paramByte)
  {
    AppMethodBeat.i(91204);
    this.fDj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91204);
  }
  
  public static final class a
  {
    public int fDk;
    public String fwv;
    public String fww;
    public int fwx;
    public boolean isKinda = false;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.gu
 * JD-Core Version:    0.7.0.1
 */