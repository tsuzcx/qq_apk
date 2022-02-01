package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aau
  extends IEvent
{
  public a ehJ;
  
  public aau()
  {
    this((byte)0);
  }
  
  private aau(byte paramByte)
  {
    AppMethodBeat.i(77799);
    this.ehJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(77799);
  }
  
  public static final class a
  {
    public String ehK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.aau
 * JD-Core Version:    0.7.0.1
 */