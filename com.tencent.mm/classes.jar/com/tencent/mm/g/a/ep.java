package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ep
  extends IEvent
{
  public a dHX;
  
  public ep()
  {
    this((byte)0);
  }
  
  private ep(byte paramByte)
  {
    AppMethodBeat.i(115999);
    this.dHX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115999);
  }
  
  public static final class a
  {
    public String dGL;
    public boolean dGT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.ep
 * JD-Core Version:    0.7.0.1
 */