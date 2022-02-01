package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fp
  extends IEvent
{
  public a fBx;
  public b fBy;
  
  public fp()
  {
    this((byte)0);
  }
  
  private fp(byte paramByte)
  {
    AppMethodBeat.i(19801);
    this.fBx = new a();
    this.fBy = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19801);
  }
  
  public static final class a
  {
    public byte[] data;
    public String mac;
  }
  
  public static final class b
  {
    public boolean fzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.fp
 * JD-Core Version:    0.7.0.1
 */