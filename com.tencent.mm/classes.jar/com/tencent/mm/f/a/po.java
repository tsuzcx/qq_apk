package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class po
  extends IEvent
{
  public a fOk;
  
  public po()
  {
    this((byte)0);
  }
  
  private po(byte paramByte)
  {
    AppMethodBeat.i(116038);
    this.fOk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116038);
  }
  
  public static final class a
  {
    public int bnA;
    public int fAF;
    public String fKT;
    public String fzB;
    public int op = 0;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.po
 * JD-Core Version:    0.7.0.1
 */