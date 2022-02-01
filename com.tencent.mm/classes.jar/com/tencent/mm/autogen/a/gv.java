package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.sdk.event.IEvent;

public final class gv
  extends IEvent
{
  public a hHo;
  
  public gv()
  {
    this((byte)0);
  }
  
  private gv(byte paramByte)
  {
    AppMethodBeat.i(116022);
    this.hHo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116022);
  }
  
  public static final class a
  {
    public boolean hHp;
    public boolean hHq;
    public int hHr;
    public bw.a hHs;
    public int type;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gv
 * JD-Core Version:    0.7.0.1
 */