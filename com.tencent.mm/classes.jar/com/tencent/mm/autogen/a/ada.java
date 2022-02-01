package com.tencent.mm.autogen.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ada
  extends IEvent
{
  public a igZ;
  public ada.b iha;
  
  public ada()
  {
    this((byte)0);
  }
  
  private ada(byte paramByte)
  {
    AppMethodBeat.i(153020);
    this.igZ = new a();
    this.iha = new ada.b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153020);
  }
  
  public static final class a
  {
    public Activity activity;
    public int ihb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ada
 * JD-Core Version:    0.7.0.1
 */