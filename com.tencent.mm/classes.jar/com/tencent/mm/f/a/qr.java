package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qr
  extends IEvent
{
  public a fPn;
  
  public qr()
  {
    this((byte)0);
  }
  
  private qr(byte paramByte)
  {
    AppMethodBeat.i(104419);
    this.fPn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104419);
  }
  
  public static final class a
  {
    public String fPo;
    public int fPp;
    public long fPq;
    public String query;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.qr
 * JD-Core Version:    0.7.0.1
 */