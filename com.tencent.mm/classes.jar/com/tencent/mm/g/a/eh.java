package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class eh
  extends IEvent
{
  public a dHC;
  public b dHD;
  
  public eh()
  {
    this((byte)0);
  }
  
  private eh(byte paramByte)
  {
    AppMethodBeat.i(115991);
    this.dHC = new a();
    this.dHD = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115991);
  }
  
  public static final class a
  {
    public boolean dHB = false;
    public String dHE;
  }
  
  public static final class b
  {
    public boolean dHF = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.eh
 * JD-Core Version:    0.7.0.1
 */