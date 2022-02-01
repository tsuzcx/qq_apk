package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fk
  extends IEvent
{
  public a fBq;
  public b fBr;
  
  public fk()
  {
    this((byte)0);
  }
  
  private fk(byte paramByte)
  {
    AppMethodBeat.i(19796);
    this.fBq = new a();
    this.fBr = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19796);
  }
  
  public static final class a
  {
    public boolean fzN = false;
    public String mac;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.fk
 * JD-Core Version:    0.7.0.1
 */