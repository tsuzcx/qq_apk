package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jg
  extends IEvent
{
  public a dNY;
  public b dNZ;
  
  public jg()
  {
    this((byte)0);
  }
  
  private jg(byte paramByte)
  {
    AppMethodBeat.i(123477);
    this.dNY = new a();
    this.dNZ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(123477);
  }
  
  public static final class a
  {
    public String url;
  }
  
  public static final class b
  {
    public String dNI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.jg
 * JD-Core Version:    0.7.0.1
 */