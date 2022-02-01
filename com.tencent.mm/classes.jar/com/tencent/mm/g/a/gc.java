package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gc
  extends IEvent
{
  public a dJH;
  public b dJI;
  
  public gc()
  {
    this((byte)0);
  }
  
  private gc(byte paramByte)
  {
    AppMethodBeat.i(116021);
    this.dJH = new a();
    this.dJI = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116021);
  }
  
  public static final class a
  {
    public Runnable doJ;
    public int duration;
    public String filePath;
    public int op;
  }
  
  public static final class b
  {
    public boolean dFE = false;
    public int dJJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.gc
 * JD-Core Version:    0.7.0.1
 */