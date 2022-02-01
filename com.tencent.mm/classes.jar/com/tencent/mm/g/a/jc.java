package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jc
  extends IEvent
{
  public a dNK;
  
  public jc()
  {
    this((byte)0);
  }
  
  private jc(byte paramByte)
  {
    AppMethodBeat.i(149861);
    this.dNK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149861);
  }
  
  public static final class a
  {
    public String appId;
    public String dFN;
    public int dNL;
    public int opType;
    public String openId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.jc
 * JD-Core Version:    0.7.0.1
 */