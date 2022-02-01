package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ff
  extends IEvent
{
  public a fBc;
  public b fBd;
  
  public ff()
  {
    this((byte)0);
  }
  
  private ff(byte paramByte)
  {
    AppMethodBeat.i(116008);
    this.fBc = new a();
    this.fBd = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116008);
  }
  
  public static final class a
  {
    public String data;
    public String fAg;
    public String fBe;
    public boolean fBf;
    public String fzB;
    public String fzF;
    public long msgId;
  }
  
  public static final class b
  {
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.ff
 * JD-Core Version:    0.7.0.1
 */