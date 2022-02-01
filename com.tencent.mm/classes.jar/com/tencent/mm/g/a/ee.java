package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ee
  extends IEvent
{
  public a dHt;
  public b dHu;
  
  public ee()
  {
    this((byte)0);
  }
  
  private ee(byte paramByte)
  {
    AppMethodBeat.i(115988);
    this.dHt = new a();
    this.dHu = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115988);
  }
  
  public static final class a
  {
    public String brandName;
    public String dGL;
    public String dHv;
    public int type;
  }
  
  public static final class b
  {
    public boolean dHw;
    public String dHx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ee
 * JD-Core Version:    0.7.0.1
 */