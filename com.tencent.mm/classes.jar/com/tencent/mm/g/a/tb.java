package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tb
  extends IEvent
{
  public a dZx;
  
  public tb()
  {
    this((byte)0);
  }
  
  private tb(byte paramByte)
  {
    AppMethodBeat.i(19831);
    this.dZx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19831);
  }
  
  public static final class a
  {
    public Context context;
    public String[] dBX;
    public String[] selectionArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.tb
 * JD-Core Version:    0.7.0.1
 */