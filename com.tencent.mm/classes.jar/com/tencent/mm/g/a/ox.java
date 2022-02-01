package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ox
  extends IEvent
{
  public a dUX;
  
  public ox()
  {
    this((byte)0);
  }
  
  private ox(byte paramByte)
  {
    AppMethodBeat.i(89648);
    this.dUX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89648);
  }
  
  public static final class a
  {
    public Context context;
    public int dUY;
    public String extraInfo;
    public int jumpType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ox
 * JD-Core Version:    0.7.0.1
 */