package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jo
  extends IEvent
{
  public a fGO;
  
  public jo()
  {
    this((byte)0);
  }
  
  private jo(byte paramByte)
  {
    AppMethodBeat.i(89644);
    this.fGO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89644);
  }
  
  public static final class a
  {
    public String event;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.jo
 * JD-Core Version:    0.7.0.1
 */