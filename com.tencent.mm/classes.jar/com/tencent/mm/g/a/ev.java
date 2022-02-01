package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class ev
  extends IEvent
{
  public a dIf;
  public b dIg;
  
  public ev()
  {
    this((byte)0);
  }
  
  private ev(byte paramByte)
  {
    AppMethodBeat.i(116005);
    this.dIf = new a();
    this.dIg = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116005);
  }
  
  public static final class a
  {
    public List dHs;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.ev
 * JD-Core Version:    0.7.0.1
 */