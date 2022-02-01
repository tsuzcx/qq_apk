package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gm
  extends IEvent
{
  public a dKr;
  
  public gm()
  {
    this((byte)0);
  }
  
  private gm(byte paramByte)
  {
    AppMethodBeat.i(163527);
    this.dKr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(163527);
  }
  
  public static final class a
  {
    public Activity dKq;
    public String dKs;
    public int dKt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.gm
 * JD-Core Version:    0.7.0.1
 */