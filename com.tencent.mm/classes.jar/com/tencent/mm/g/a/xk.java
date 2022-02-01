package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xk
  extends IEvent
{
  public a edE;
  
  public xk()
  {
    this((byte)0);
  }
  
  private xk(byte paramByte)
  {
    AppMethodBeat.i(91221);
    this.edE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91221);
  }
  
  public static final class a
  {
    public boolean edF;
    public boolean edG = false;
    public int edH = 0;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.xk
 * JD-Core Version:    0.7.0.1
 */