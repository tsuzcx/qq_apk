package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.sdk.b.b;

public final class fz
  extends b
{
  public a drt;
  
  public fz()
  {
    this((byte)0);
  }
  
  private fz(byte paramByte)
  {
    AppMethodBeat.i(116022);
    this.drt = new a();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(116022);
  }
  
  public static final class a
  {
    public boolean dru;
    public boolean drv;
    public int drw;
    public bo.a drx;
    public int type;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.fz
 * JD-Core Version:    0.7.0.1
 */