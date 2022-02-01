package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.event.IEvent;

public final class su
  extends IEvent
{
  public a dZn;
  
  public su()
  {
    this((byte)0);
  }
  
  private su(byte paramByte)
  {
    AppMethodBeat.i(125630);
    this.dZn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125630);
  }
  
  public static final class a
  {
    public SnsObject dPc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.su
 * JD-Core Version:    0.7.0.1
 */