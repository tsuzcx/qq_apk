package com.tencent.mm.f.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class al
  extends IEvent
{
  public a fvR;
  
  public al()
  {
    this((byte)0);
  }
  
  private al(byte paramByte)
  {
    AppMethodBeat.i(149851);
    this.fvR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149851);
  }
  
  public static final class a
  {
    public Activity activity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.al
 * JD-Core Version:    0.7.0.1
 */