package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class si
  extends IEvent
{
  public a dYX;
  public b dYY;
  
  public si()
  {
    this((byte)0);
  }
  
  private si(byte paramByte)
  {
    AppMethodBeat.i(149886);
    this.dYX = new a();
    this.dYY = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149886);
  }
  
  public static final class a
  {
    public Context context;
  }
  
  public static final class b
  {
    public boolean dYN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.si
 * JD-Core Version:    0.7.0.1
 */