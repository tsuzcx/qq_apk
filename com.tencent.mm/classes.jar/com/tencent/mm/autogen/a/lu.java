package com.tencent.mm.autogen.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lu
  extends IEvent
{
  public a hNG;
  public b hNH;
  
  public lu()
  {
    this((byte)0);
  }
  
  private lu(byte paramByte)
  {
    AppMethodBeat.i(155370);
    this.hNG = new a();
    this.hNH = new b();
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
    public String hNI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.lu
 * JD-Core Version:    0.7.0.1
 */