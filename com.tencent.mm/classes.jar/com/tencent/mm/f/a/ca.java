package com.tencent.mm.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ca
  extends IEvent
{
  public a fxO;
  
  public ca()
  {
    this((byte)0);
  }
  
  private ca(byte paramByte)
  {
    AppMethodBeat.i(19793);
    this.fxO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19793);
  }
  
  public static final class a
  {
    public Context context;
    public String[] fuA;
    public String[] fuz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ca
 * JD-Core Version:    0.7.0.1
 */