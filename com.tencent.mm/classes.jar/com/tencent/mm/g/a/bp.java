package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bp
  extends IEvent
{
  public a dEN;
  
  public bp()
  {
    this((byte)0);
  }
  
  private bp(byte paramByte)
  {
    AppMethodBeat.i(149855);
    this.dEN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149855);
  }
  
  public static final class a
  {
    public int dEO;
    public int dEP;
    public boolean dEQ = false;
    public String dER;
    public String filePath;
    public int subType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.bp
 * JD-Core Version:    0.7.0.1
 */