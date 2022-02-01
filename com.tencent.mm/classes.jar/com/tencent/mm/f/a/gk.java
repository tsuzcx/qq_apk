package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.sdk.event.IEvent;

public final class gk
  extends IEvent
{
  public a fCz;
  
  public gk()
  {
    this((byte)0);
  }
  
  private gk(byte paramByte)
  {
    AppMethodBeat.i(116022);
    this.fCz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116022);
  }
  
  public static final class a
  {
    public boolean fCA;
    public boolean fCB;
    public int fCC;
    public bv.a fCD;
    public int type;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.gk
 * JD-Core Version:    0.7.0.1
 */