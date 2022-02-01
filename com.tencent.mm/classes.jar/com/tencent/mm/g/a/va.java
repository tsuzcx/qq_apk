package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class va
  extends IEvent
{
  public a ebs;
  
  public va()
  {
    this((byte)0);
  }
  
  private va(byte paramByte)
  {
    AppMethodBeat.i(94814);
    this.ebs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94814);
  }
  
  public static final class a
  {
    public boolean enable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.va
 * JD-Core Version:    0.7.0.1
 */