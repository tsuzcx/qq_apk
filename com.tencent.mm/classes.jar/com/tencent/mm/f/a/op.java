package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class op
  extends IEvent
{
  public a fNr;
  public b fNs;
  
  public op()
  {
    this((byte)0);
  }
  
  private op(byte paramByte)
  {
    AppMethodBeat.i(110275);
    this.fNr = new a();
    this.fNs = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(110275);
  }
  
  public static final class a
  {
    public boolean fNt = false;
    public String key;
    public int type = 0;
    public String username;
  }
  
  public static final class b
  {
    public long fNu;
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.op
 * JD-Core Version:    0.7.0.1
 */