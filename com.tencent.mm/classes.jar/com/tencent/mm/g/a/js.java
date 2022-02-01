package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class js
  extends IEvent
{
  public a dOC;
  
  public js()
  {
    this((byte)0);
  }
  
  private js(byte paramByte)
  {
    AppMethodBeat.i(94811);
    this.dOC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94811);
  }
  
  public static final class a
  {
    public String dOD;
    public int state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.js
 * JD-Core Version:    0.7.0.1
 */