package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class j
  extends IEvent
{
  public a hyT;
  
  public j()
  {
    this((byte)0);
  }
  
  private j(byte paramByte)
  {
    AppMethodBeat.i(149846);
    this.hyT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149846);
  }
  
  public static final class a
  {
    public String errMsg;
    public boolean hyU = false;
    public long hyV;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.j
 * JD-Core Version:    0.7.0.1
 */