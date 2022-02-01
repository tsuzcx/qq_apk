package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.as;

public final class nh
  extends IEvent
{
  public a fLD;
  
  public nh()
  {
    this((byte)0);
  }
  
  private nh(byte paramByte)
  {
    AppMethodBeat.i(42653);
    this.fLD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42653);
  }
  
  public static final class a
  {
    public as fLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.nh
 * JD-Core Version:    0.7.0.1
 */