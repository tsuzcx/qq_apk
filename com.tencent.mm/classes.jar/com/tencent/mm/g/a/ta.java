package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ta
  extends IEvent
{
  public a dZw;
  
  public ta()
  {
    this((byte)0);
  }
  
  private ta(byte paramByte)
  {
    AppMethodBeat.i(19830);
    this.dZw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19830);
  }
  
  public static final class a
  {
    public Context context;
    public String[] dBX;
    public String[] selectionArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ta
 * JD-Core Version:    0.7.0.1
 */