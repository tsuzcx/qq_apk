package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nr
  extends IEvent
{
  public a hQd;
  public b hQe;
  
  public nr()
  {
    this((byte)0);
  }
  
  private nr(byte paramByte)
  {
    AppMethodBeat.i(89748);
    this.hQd = new a();
    this.hQe = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89748);
  }
  
  public static final class a
  {
    public int hHC = 0;
    public String hQf;
    public int hQg = 0;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.nr
 * JD-Core Version:    0.7.0.1
 */