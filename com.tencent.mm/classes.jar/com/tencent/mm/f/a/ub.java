package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ub
  extends IEvent
{
  public a fTq;
  
  public ub()
  {
    this((byte)0);
  }
  
  private ub(byte paramByte)
  {
    AppMethodBeat.i(19830);
    this.fTq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19830);
  }
  
  public static final class a
  {
    public Context context;
    public String[] fuA;
    public String[] fuz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ub
 * JD-Core Version:    0.7.0.1
 */