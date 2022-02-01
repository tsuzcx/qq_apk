package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mg
  extends IEvent
{
  public a hOp;
  public b hOq;
  
  public mg()
  {
    this((byte)0);
  }
  
  private mg(byte paramByte)
  {
    AppMethodBeat.i(93325);
    this.hOp = new a();
    this.hOq = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93325);
  }
  
  public static final class a
  {
    public Context context;
    public int enterScene = 0;
    public int scene = 0;
  }
  
  public static final class b
  {
    public String hOr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.mg
 * JD-Core Version:    0.7.0.1
 */