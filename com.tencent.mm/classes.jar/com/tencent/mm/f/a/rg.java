package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rg
  extends IEvent
{
  public a fQn;
  
  public rg()
  {
    this((byte)0);
  }
  
  private rg(byte paramByte)
  {
    AppMethodBeat.i(240937);
    this.fQn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(240937);
  }
  
  public static final class a
  {
    public String fQk;
    public long fQo;
    public long fQp;
    public String fzr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.rg
 * JD-Core Version:    0.7.0.1
 */