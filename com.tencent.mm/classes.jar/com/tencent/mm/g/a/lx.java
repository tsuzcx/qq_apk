package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lx
  extends IEvent
{
  public a dRu;
  
  public lx()
  {
    this((byte)0);
  }
  
  private lx(byte paramByte)
  {
    AppMethodBeat.i(149869);
    this.dRu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149869);
  }
  
  public static final class a
  {
    public int dEO;
    public boolean dEQ = false;
    public String filePath;
    public int subType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.lx
 * JD-Core Version:    0.7.0.1
 */