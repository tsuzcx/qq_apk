package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wo
  extends IEvent
{
  public a ecC;
  public b ecD;
  
  public wo()
  {
    this((byte)0);
  }
  
  private wo(byte paramByte)
  {
    AppMethodBeat.i(127410);
    this.ecC = new a();
    this.ecD = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127410);
  }
  
  public static final class a
  {
    public boolean ecE;
    public String ecF;
    public cz ecG;
    public String url;
  }
  
  public static final class b
  {
    public boolean dFE = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.wo
 * JD-Core Version:    0.7.0.1
 */