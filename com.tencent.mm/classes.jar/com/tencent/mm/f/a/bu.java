package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bu
  extends IEvent
{
  public a fxB;
  
  public bu()
  {
    this((byte)0);
  }
  
  private bu(byte paramByte)
  {
    AppMethodBeat.i(149855);
    this.fxB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149855);
  }
  
  public static final class a
  {
    public String filePath;
    public int fxC;
    public int fxD;
    public boolean fxE = false;
    public String fxF;
    public int subType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.bu
 * JD-Core Version:    0.7.0.1
 */