package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abk
  extends IEvent
{
  public a gbg;
  public b gbh;
  
  public abk()
  {
    this((byte)0);
  }
  
  private abk(byte paramByte)
  {
    AppMethodBeat.i(91230);
    this.gbg = new a();
    this.gbh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91230);
  }
  
  public static final class a {}
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.abk
 * JD-Core Version:    0.7.0.1
 */