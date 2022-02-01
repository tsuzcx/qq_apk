package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rl
  extends IEvent
{
  public a dYc;
  
  public rl()
  {
    this((byte)0);
  }
  
  private rl(byte paramByte)
  {
    AppMethodBeat.i(177635);
    this.dYc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(177635);
  }
  
  public static final class a
  {
    public Activity activity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.rl
 * JD-Core Version:    0.7.0.1
 */