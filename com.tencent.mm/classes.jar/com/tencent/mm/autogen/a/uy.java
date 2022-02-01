package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uy
  extends IEvent
{
  public a hYO;
  public b hYP;
  
  public uy()
  {
    this((byte)0);
  }
  
  private uy(byte paramByte)
  {
    AppMethodBeat.i(149886);
    this.hYO = new a();
    this.hYP = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149886);
  }
  
  public static final class a
  {
    public Context context;
  }
  
  public static final class b
  {
    public boolean hYE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.uy
 * JD-Core Version:    0.7.0.1
 */