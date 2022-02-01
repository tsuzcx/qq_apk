package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pa
  extends IEvent
{
  public a hRS;
  
  public pa()
  {
    this((byte)0);
  }
  
  private pa(byte paramByte)
  {
    AppMethodBeat.i(43442);
    this.hRS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(43442);
  }
  
  public static final class a
  {
    public String businessType;
    public int errCode;
    public String hRR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pa
 * JD-Core Version:    0.7.0.1
 */