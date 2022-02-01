package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lu
  extends IEvent
{
  public a dRh;
  public b dRi;
  
  public lu()
  {
    this((byte)0);
  }
  
  private lu(byte paramByte)
  {
    AppMethodBeat.i(89748);
    this.dRh = new a();
    this.dRi = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89748);
  }
  
  public static final class a
  {
    public int dJY = 0;
    public String dRj;
    public int dRk = 0;
  }
  
  public static final class b
  {
    public boolean dFE = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.lu
 * JD-Core Version:    0.7.0.1
 */