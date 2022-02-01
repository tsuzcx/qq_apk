package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class acq
  extends IEvent
{
  public a iga;
  
  public acq()
  {
    this((byte)0);
  }
  
  private acq(byte paramByte)
  {
    AppMethodBeat.i(130929);
    this.iga = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130929);
  }
  
  public static final class a
  {
    public Context context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.acq
 * JD-Core Version:    0.7.0.1
 */