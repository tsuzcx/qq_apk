package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class adg
  extends IEvent
{
  public a iho;
  public b ihp;
  
  public adg()
  {
    this((byte)0);
  }
  
  private adg(byte paramByte)
  {
    AppMethodBeat.i(91229);
    this.iho = new a();
    this.ihp = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91229);
  }
  
  public static final class a {}
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.adg
 * JD-Core Version:    0.7.0.1
 */