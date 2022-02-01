package com.tencent.mm.autogen.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uv
  extends IEvent
{
  public a hYF;
  public b hYG;
  
  public uv()
  {
    this((byte)0);
  }
  
  private uv(byte paramByte)
  {
    AppMethodBeat.i(149884);
    this.hYF = new a();
    this.hYG = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149884);
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
 * Qualified Name:     com.tencent.mm.autogen.a.uv
 * JD-Core Version:    0.7.0.1
 */