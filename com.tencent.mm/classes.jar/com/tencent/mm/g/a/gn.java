package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gn
  extends IEvent
{
  public a dKu;
  
  public gn()
  {
    this((byte)0);
  }
  
  private gn(byte paramByte)
  {
    AppMethodBeat.i(91204);
    this.dKu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91204);
  }
  
  public static final class a
  {
    public String dDL;
    public String dDM;
    public int dDN;
    public int dKv;
    public boolean isKinda = false;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.gn
 * JD-Core Version:    0.7.0.1
 */