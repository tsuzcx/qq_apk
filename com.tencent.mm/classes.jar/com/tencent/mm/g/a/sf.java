package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sf
  extends IEvent
{
  public a dYO;
  public b dYP;
  
  public sf()
  {
    this((byte)0);
  }
  
  private sf(byte paramByte)
  {
    AppMethodBeat.i(149884);
    this.dYO = new a();
    this.dYP = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149884);
  }
  
  public static final class a
  {
    public Context context;
    public int dYQ;
    public Bundle extras;
  }
  
  public static final class b
  {
    public boolean dYN;
    public Bundle extras;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.sf
 * JD-Core Version:    0.7.0.1
 */