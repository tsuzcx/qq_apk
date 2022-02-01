package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.event.IEvent;

public final class jh
  extends IEvent
{
  public a hKS;
  
  public jh()
  {
    this((byte)0);
  }
  
  private jh(byte paramByte)
  {
    AppMethodBeat.i(369470);
    this.hKS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369470);
  }
  
  public static final class a
  {
    public boolean hKT;
    public bvl hKU;
    public long localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.jh
 * JD-Core Version:    0.7.0.1
 */