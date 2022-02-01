package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class mk
  extends b
{
  public a dAW;
  public b dAX;
  
  public mk()
  {
    this((byte)0);
  }
  
  private mk(byte paramByte)
  {
    AppMethodBeat.i(155373);
    this.dAW = new a();
    this.dAX = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(155373);
  }
  
  public static final class a
  {
    public Runnable dAY;
    public Activity dtg;
  }
  
  public static final class b
  {
    public boolean doq = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.mk
 * JD-Core Version:    0.7.0.1
 */