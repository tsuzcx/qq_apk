package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.sdk.event.IEvent;

public final class ym
  extends IEvent
{
  public a eeL;
  
  public ym()
  {
    this((byte)0);
  }
  
  private ym(byte paramByte)
  {
    AppMethodBeat.i(134107);
    this.eeL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(134107);
  }
  
  public static final class a
  {
    public czl eeM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.ym
 * JD-Core Version:    0.7.0.1
 */