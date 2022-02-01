package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.sdk.event.IEvent;

public final class ia
  extends IEvent
{
  public a dMC;
  
  public ia()
  {
    this((byte)0);
  }
  
  private ia(byte paramByte)
  {
    AppMethodBeat.i(208806);
    this.dMC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(208806);
  }
  
  public static final class a
  {
    public boolean dMD;
    public bcj dME;
    public long localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.ia
 * JD-Core Version:    0.7.0.1
 */