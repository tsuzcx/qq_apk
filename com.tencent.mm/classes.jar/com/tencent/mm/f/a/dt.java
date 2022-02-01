package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dt
  extends IEvent
{
  public a fzk;
  public b fzl;
  
  public dt()
  {
    this((byte)0);
  }
  
  private dt(byte paramByte)
  {
    AppMethodBeat.i(104415);
    this.fzk = new a();
    this.fzl = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104415);
  }
  
  public static final class a
  {
    public int type;
  }
  
  public static final class b
  {
    public boolean fzm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.dt
 * JD-Core Version:    0.7.0.1
 */