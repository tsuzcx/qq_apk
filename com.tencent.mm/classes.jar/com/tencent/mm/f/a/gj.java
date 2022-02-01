package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gj
  extends IEvent
{
  public a fCw;
  public b fCx;
  
  public gj()
  {
    this((byte)0);
  }
  
  private gj(byte paramByte)
  {
    AppMethodBeat.i(116021);
    this.fCw = new a();
    this.fCx = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116021);
  }
  
  public static final class a
  {
    public int duration;
    public Runnable fhn;
    public String filePath;
    public int op;
  }
  
  public static final class b
  {
    public int fCy;
    public boolean fyl = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.gj
 * JD-Core Version:    0.7.0.1
 */