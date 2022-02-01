package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class io
  extends IEvent
{
  public a dNh;
  public b dNi;
  
  public io()
  {
    this((byte)0);
  }
  
  private io(byte paramByte)
  {
    AppMethodBeat.i(19811);
    this.dNh = new a();
    this.dNi = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19811);
  }
  
  public static final class a
  {
    public Intent intent;
  }
  
  public static final class b
  {
    public int dIZ = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.io
 * JD-Core Version:    0.7.0.1
 */