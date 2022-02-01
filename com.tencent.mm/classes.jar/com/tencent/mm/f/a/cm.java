package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cm
  extends IEvent
{
  public a fyb;
  
  public cm()
  {
    this((byte)0);
  }
  
  private cm(byte paramByte)
  {
    AppMethodBeat.i(91201);
    this.fyb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91201);
  }
  
  public static final class a
  {
    public long delay;
    public int fee;
    public String fyc;
    public String fyd;
    public String fye;
    public String fyf;
    public String fyg;
    public boolean fyh = true;
    public int source;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.cm
 * JD-Core Version:    0.7.0.1
 */