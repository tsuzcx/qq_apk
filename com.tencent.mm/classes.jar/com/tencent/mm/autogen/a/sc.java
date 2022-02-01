package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.sdk.event.IEvent;

public final class sc
  extends IEvent
{
  public a hVe;
  
  public sc()
  {
    this((byte)0);
  }
  
  private sc(byte paramByte)
  {
    AppMethodBeat.i(369469);
    this.hVe = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369469);
  }
  
  public static final class a
  {
    public FinderJumpInfo hVf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.a.sc
 * JD-Core Version:    0.7.0.1
 */