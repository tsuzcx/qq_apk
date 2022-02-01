package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aw
  extends IEvent
{
  public a dDW;
  
  public aw()
  {
    this((byte)0);
  }
  
  private aw(byte paramByte)
  {
    AppMethodBeat.i(115969);
    this.dDW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115969);
  }
  
  public static final class a
  {
    public Activity activity;
    public String dDX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.aw
 * JD-Core Version:    0.7.0.1
 */