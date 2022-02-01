package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kv
  extends IEvent
{
  public a dPV;
  
  public kv()
  {
    this((byte)0);
  }
  
  private kv(byte paramByte)
  {
    AppMethodBeat.i(114792);
    this.dPV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114792);
  }
  
  public static final class a
  {
    public Context dPW;
    public long dPX;
    public boolean dPY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.kv
 * JD-Core Version:    0.7.0.1
 */