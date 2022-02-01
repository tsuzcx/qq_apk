package com.tencent.mm.f.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abd
  extends IEvent
{
  public a gaP;
  public abd.b gaQ;
  
  public abd()
  {
    this((byte)0);
  }
  
  private abd(byte paramByte)
  {
    AppMethodBeat.i(153020);
    this.gaP = new a();
    this.gaQ = new abd.b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153020);
  }
  
  public static final class a
  {
    public Activity activity;
    public int gaR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.abd
 * JD-Core Version:    0.7.0.1
 */