package com.tencent.mm.autogen.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ao
  extends IEvent
{
  public a hAm;
  
  public ao()
  {
    this((byte)0);
  }
  
  private ao(byte paramByte)
  {
    AppMethodBeat.i(149851);
    this.hAm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149851);
  }
  
  public static final class a
  {
    public Activity activity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ao
 * JD-Core Version:    0.7.0.1
 */