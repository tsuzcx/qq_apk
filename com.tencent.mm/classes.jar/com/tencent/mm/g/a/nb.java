package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nb
  extends IEvent
{
  public a dSL;
  public b dSM;
  
  public nb()
  {
    this((byte)0);
  }
  
  private nb(byte paramByte)
  {
    AppMethodBeat.i(155373);
    this.dSL = new a();
    this.dSM = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155373);
  }
  
  public static final class a
  {
    public Activity dKq;
    public Runnable dSN;
  }
  
  public static final class b
  {
    public boolean dFE = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.nb
 * JD-Core Version:    0.7.0.1
 */