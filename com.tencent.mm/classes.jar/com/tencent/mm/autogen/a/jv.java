package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.sdk.event.IEvent;

public final class jv
  extends IEvent
{
  public a hLs;
  
  public jv()
  {
    this((byte)0);
  }
  
  private jv(byte paramByte)
  {
    AppMethodBeat.i(369446);
    this.hLs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369446);
  }
  
  public static final class a
  {
    public String errMsg;
    public bxv hLt;
    public int responseCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.jv
 * JD-Core Version:    0.7.0.1
 */