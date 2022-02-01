package com.tencent.mm.autogen.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tz
  extends IEvent
{
  public a hXO;
  
  public tz()
  {
    this((byte)0);
  }
  
  private tz(byte paramByte)
  {
    AppMethodBeat.i(177635);
    this.hXO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(177635);
  }
  
  public static final class a
  {
    public Activity activity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.tz
 * JD-Core Version:    0.7.0.1
 */