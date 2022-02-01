package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class c
  extends IEvent
{
  public a fuq;
  
  public c()
  {
    this((byte)0);
  }
  
  private c(byte paramByte)
  {
    AppMethodBeat.i(131787);
    this.fuq = new a();
    this.order = true;
    this.callback = null;
    AppMethodBeat.o(131787);
  }
  
  public static final class a
  {
    public int errCode;
    public String errMsg;
    public int errType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.c
 * JD-Core Version:    0.7.0.1
 */