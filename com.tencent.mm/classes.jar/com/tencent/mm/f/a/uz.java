package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uz
  extends IEvent
{
  public a fUn;
  
  public uz()
  {
    this((byte)0);
  }
  
  private uz(byte paramByte)
  {
    AppMethodBeat.i(116048);
    this.fUn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116048);
  }
  
  public static final class a
  {
    public String content;
    public String fcD;
    public int flags;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.uz
 * JD-Core Version:    0.7.0.1
 */