package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.event.IEvent;

public final class tv
  extends IEvent
{
  public a fTg;
  
  public tv()
  {
    this((byte)0);
  }
  
  private tv(byte paramByte)
  {
    AppMethodBeat.i(125630);
    this.fTg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125630);
  }
  
  public static final class a
  {
    public SnsObject fIn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.tv
 * JD-Core Version:    0.7.0.1
 */