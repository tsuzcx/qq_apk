package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.event.IEvent;

public final class iw
  extends IEvent
{
  public a fGb;
  
  public iw()
  {
    this((byte)0);
  }
  
  private iw(byte paramByte)
  {
    AppMethodBeat.i(275446);
    this.fGb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(275446);
  }
  
  public static final class a
  {
    public int bpg;
    public String errMsg;
    public bkr fGc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.iw
 * JD-Core Version:    0.7.0.1
 */