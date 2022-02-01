package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fo
  extends IEvent
{
  public a fBv;
  public b fBw;
  
  public fo()
  {
    this((byte)0);
  }
  
  private fo(byte paramByte)
  {
    AppMethodBeat.i(19800);
    this.fBv = new a();
    this.fBw = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19800);
  }
  
  public static final class a
  {
    public boolean fzN = false;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.fo
 * JD-Core Version:    0.7.0.1
 */