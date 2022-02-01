package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hz
  extends IEvent
{
  public a fFb;
  
  public hz()
  {
    this((byte)0);
  }
  
  private hz(byte paramByte)
  {
    AppMethodBeat.i(266069);
    this.fFb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(266069);
  }
  
  public static final class a
  {
    public Long fFc;
    public int position;
    public int type;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.hz
 * JD-Core Version:    0.7.0.1
 */