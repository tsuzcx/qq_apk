package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gl
  extends IEvent
{
  public a fCE;
  public b fCF;
  
  public gl()
  {
    this((byte)0);
  }
  
  private gl(byte paramByte)
  {
    AppMethodBeat.i(116808);
    this.fCE = new a();
    this.fCF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116808);
  }
  
  public static final class a
  {
    public long aZE;
    public int action;
    public long fCG;
    public long fCH;
  }
  
  public static final class b
  {
    public String config;
    public boolean fCI = false;
    public int fCJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.gl
 * JD-Core Version:    0.7.0.1
 */