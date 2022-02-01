package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aag
  extends IEvent
{
  public a fZx;
  
  public aag()
  {
    this((byte)0);
  }
  
  private aag(byte paramByte)
  {
    AppMethodBeat.i(19844);
    this.fZx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19844);
  }
  
  public static final class a
  {
    public int action;
    public int fZy;
    public String result;
    public String userCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.a.aag
 * JD-Core Version:    0.7.0.1
 */