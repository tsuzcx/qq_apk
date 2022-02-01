package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abj
  extends IEvent
{
  public a gbe;
  public b gbf;
  
  public abj()
  {
    this((byte)0);
  }
  
  private abj(byte paramByte)
  {
    AppMethodBeat.i(91229);
    this.gbe = new a();
    this.gbf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91229);
  }
  
  public static final class a {}
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.abj
 * JD-Core Version:    0.7.0.1
 */