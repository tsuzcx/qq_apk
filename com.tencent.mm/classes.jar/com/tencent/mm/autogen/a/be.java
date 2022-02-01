package com.tencent.mm.autogen.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class be
  extends IEvent
{
  public a hBh;
  
  public be()
  {
    this((byte)0);
  }
  
  private be(byte paramByte)
  {
    AppMethodBeat.i(115969);
    this.hBh = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115969);
  }
  
  public static final class a
  {
    public Activity activity;
    public String hBi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.be
 * JD-Core Version:    0.7.0.1
 */