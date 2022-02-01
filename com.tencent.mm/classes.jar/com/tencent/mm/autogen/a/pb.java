package com.tencent.mm.autogen.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pb
  extends IEvent
{
  public a hRT;
  public b hRU;
  
  public pb()
  {
    this((byte)0);
  }
  
  private pb(byte paramByte)
  {
    AppMethodBeat.i(155373);
    this.hRT = new a();
    this.hRU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155373);
  }
  
  public static final class a
  {
    public Activity hHU;
    public Runnable hRV;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pb
 * JD-Core Version:    0.7.0.1
 */