package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mq
  extends b
{
  public a dAz;
  
  public mq()
  {
    this((byte)0);
  }
  
  private mq(byte paramByte)
  {
    AppMethodBeat.i(149875);
    this.dAz = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(149875);
  }
  
  public static final class a
  {
    public b dAA;
    public int errCode = 0;
    public String errMsg;
    public int errType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.mq
 * JD-Core Version:    0.7.0.1
 */