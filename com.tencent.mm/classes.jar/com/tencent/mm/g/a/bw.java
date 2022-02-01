package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bw
  extends IEvent
{
  public a dFg;
  
  public bw()
  {
    this((byte)0);
  }
  
  private bw(byte paramByte)
  {
    AppMethodBeat.i(19793);
    this.dFg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19793);
  }
  
  public static final class a
  {
    public Context context;
    public String[] dBX;
    public String[] selectionArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.bw
 * JD-Core Version:    0.7.0.1
 */