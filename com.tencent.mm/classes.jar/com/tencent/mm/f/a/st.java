package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class st
  extends IEvent
{
  public a fSf;
  
  public st()
  {
    this((byte)0);
  }
  
  private st(byte paramByte)
  {
    AppMethodBeat.i(249941);
    this.fSf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(249941);
  }
  
  public static final class a
  {
    public int fSg = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.st
 * JD-Core Version:    0.7.0.1
 */