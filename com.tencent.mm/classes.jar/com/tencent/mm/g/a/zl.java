package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.sdk.event.IEvent;

public final class zl
  extends IEvent
{
  public a efC;
  
  public zl()
  {
    this((byte)0);
  }
  
  private zl(byte paramByte)
  {
    AppMethodBeat.i(256165);
    this.efC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(256165);
  }
  
  public static final class a
  {
    public ckj efB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.zl
 * JD-Core Version:    0.7.0.1
 */