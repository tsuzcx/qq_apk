package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lx
  extends IEvent
{
  public a fJN;
  
  public lx()
  {
    this((byte)0);
  }
  
  private lx(byte paramByte)
  {
    AppMethodBeat.i(19816);
    this.fJN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19816);
  }
  
  public static final class a
  {
    public String url;
    public String wording;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.lx
 * JD-Core Version:    0.7.0.1
 */