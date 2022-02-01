package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class id
  extends IEvent
{
  public a fFj;
  
  public id()
  {
    this((byte)0);
  }
  
  private id(byte paramByte)
  {
    AppMethodBeat.i(207827);
    this.fFj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(207827);
  }
  
  public static final class a
  {
    public int action;
    public long commentId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.id
 * JD-Core Version:    0.7.0.1
 */