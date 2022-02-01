package com.tencent.mm.autogen.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ut
  extends IEvent
{
  public a hYw;
  
  public ut()
  {
    this((byte)0);
  }
  
  private ut(byte paramByte)
  {
    AppMethodBeat.i(91217);
    this.hYw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91217);
  }
  
  public static final class a
  {
    public Context context;
    public Intent intent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ut
 * JD-Core Version:    0.7.0.1
 */