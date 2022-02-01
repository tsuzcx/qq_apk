package com.tencent.mm.g.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sh
  extends IEvent
{
  public a dYV;
  public b dYW;
  
  public sh()
  {
    this((byte)0);
  }
  
  private sh(byte paramByte)
  {
    AppMethodBeat.i(149885);
    this.dYV = new a();
    this.dYW = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149885);
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
 * Qualified Name:     com.tencent.mm.g.a.sh
 * JD-Core Version:    0.7.0.1
 */