package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bp
  extends IEvent
{
  public a fxr;
  public b fxs;
  
  public bp()
  {
    this((byte)0);
  }
  
  private bp(byte paramByte)
  {
    AppMethodBeat.i(117354);
    this.fxr = new a();
    this.fxs = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117354);
  }
  
  public static final class a {}
  
  public static final class b
  {
    public boolean fxt;
    public String msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.bp
 * JD-Core Version:    0.7.0.1
 */