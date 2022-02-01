package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fg
  extends IEvent
{
  public a fBg;
  public b fBh;
  
  public fg()
  {
    this((byte)0);
  }
  
  private fg(byte paramByte)
  {
    AppMethodBeat.i(116009);
    this.fBg = new a();
    this.fBh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116009);
  }
  
  public static final class a
  {
    public String fBi;
    public String fzB;
    public int progress;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.fg
 * JD-Core Version:    0.7.0.1
 */