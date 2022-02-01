package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ka
  extends IEvent
{
  public a dOV;
  public b dOW;
  
  public ka()
  {
    this((byte)0);
  }
  
  private ka(byte paramByte)
  {
    AppMethodBeat.i(155370);
    this.dOV = new a();
    this.dOW = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155370);
  }
  
  public static final class a
  {
    public Context context;
  }
  
  public static final class b
  {
    public String dOX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ka
 * JD-Core Version:    0.7.0.1
 */