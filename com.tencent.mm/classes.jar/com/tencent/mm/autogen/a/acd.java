package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class acd
  extends IEvent
{
  public a ifE;
  
  public acd()
  {
    this((byte)0);
  }
  
  private acd(byte paramByte)
  {
    AppMethodBeat.i(19844);
    this.ifE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19844);
  }
  
  public static final class a
  {
    public int action;
    public int ifF;
    public String ifG;
    public String result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.a.acd
 * JD-Core Version:    0.7.0.1
 */