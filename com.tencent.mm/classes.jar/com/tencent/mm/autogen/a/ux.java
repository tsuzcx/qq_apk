package com.tencent.mm.autogen.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ux
  extends IEvent
{
  public a hYM;
  public b hYN;
  
  public ux()
  {
    this((byte)0);
  }
  
  private ux(byte paramByte)
  {
    AppMethodBeat.i(149885);
    this.hYM = new a();
    this.hYN = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149885);
  }
  
  public static final class a
  {
    public Context context;
    public Bundle extras;
    public int hYH;
  }
  
  public static final class b
  {
    public Bundle extras;
    public boolean hYE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ux
 * JD-Core Version:    0.7.0.1
 */