package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IEvent;

public final class ih
  extends IEvent
{
  public a dMT;
  
  public ih()
  {
    this((byte)0);
  }
  
  private ih(byte paramByte)
  {
    AppMethodBeat.i(208811);
    this.dMT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(208811);
  }
  
  public static final class a
  {
    public bds dMU;
    public String errMsg;
    public int responseCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.ih
 * JD-Core Version:    0.7.0.1
 */