package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ha
  extends IEvent
{
  public a dLj;
  public b dLk;
  
  public ha()
  {
    this((byte)0);
  }
  
  private ha(byte paramByte)
  {
    AppMethodBeat.i(106599);
    this.dLj = new a();
    this.dLk = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(106599);
  }
  
  public static final class a
  {
    public String dLl;
  }
  
  public static final class b
  {
    public int dEq = 0;
    public int dEr = 0;
    public int dEs = 0;
    public int dEt = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ha
 * JD-Core Version:    0.7.0.1
 */