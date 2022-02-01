package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mj
  extends IEvent
{
  public a fKt;
  
  public mj()
  {
    this((byte)0);
  }
  
  private mj(byte paramByte)
  {
    AppMethodBeat.i(89747);
    this.fKt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89747);
  }
  
  public static final class a
  {
    public String fKu;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.mj
 * JD-Core Version:    0.7.0.1
 */