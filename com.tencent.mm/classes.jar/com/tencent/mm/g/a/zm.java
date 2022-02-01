package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zm
  extends IEvent
{
  public a efD;
  
  public zm()
  {
    this((byte)0);
  }
  
  private zm(byte paramByte)
  {
    AppMethodBeat.i(130929);
    this.efD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130929);
  }
  
  public static final class a
  {
    public Context context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.zm
 * JD-Core Version:    0.7.0.1
 */