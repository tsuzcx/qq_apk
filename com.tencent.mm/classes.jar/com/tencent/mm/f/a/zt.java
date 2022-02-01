package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.sdk.event.IEvent;

public final class zt
  extends IEvent
{
  public a fZa;
  
  public zt()
  {
    this((byte)0);
  }
  
  private zt(byte paramByte)
  {
    AppMethodBeat.i(134107);
    this.fZa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(134107);
  }
  
  public static final class a
  {
    public diz fZb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.zt
 * JD-Core Version:    0.7.0.1
 */