package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.event.IEvent;

public final class qi
  extends IEvent
{
  public a hTw;
  
  public qi()
  {
    this((byte)0);
  }
  
  private qi(byte paramByte)
  {
    AppMethodBeat.i(369338);
    this.hTw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369338);
  }
  
  public static final class a
  {
    public bxh hTx;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.qi
 * JD-Core Version:    0.7.0.1
 */