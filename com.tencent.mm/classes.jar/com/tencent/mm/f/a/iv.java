package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.event.IEvent;

public final class iv
  extends IEvent
{
  public a fFZ;
  
  public iv()
  {
    this((byte)0);
  }
  
  private iv(byte paramByte)
  {
    AppMethodBeat.i(242697);
    this.fFZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(242697);
  }
  
  public static final class a
  {
    public bkr fGa;
    public int index;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.iv
 * JD-Core Version:    0.7.0.1
 */