package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.sdk.event.IEvent;

public final class fz
  extends IEvent
{
  public a dJA;
  public b dJB;
  
  public fz()
  {
    this((byte)0);
  }
  
  private fz(byte paramByte)
  {
    AppMethodBeat.i(116019);
    this.dJA = new a();
    this.dJB = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116019);
  }
  
  public static final class a
  {
    public boolean dJC = false;
    public k.a dJD;
    public k.b dJE;
    public boolean dtE;
    public String fileName;
    public int op;
  }
  
  public static final class b
  {
    public boolean dFE = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.fz
 * JD-Core Version:    0.7.0.1
 */