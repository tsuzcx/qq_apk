package com.tencent.mm.g.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gl
  extends IEvent
{
  public a dKn;
  
  public gl()
  {
    this((byte)0);
  }
  
  private gl(byte paramByte)
  {
    AppMethodBeat.i(63288);
    this.dKn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63288);
  }
  
  public static final class a
  {
    public String dKo;
    public int dKp = 0;
    public Activity dKq;
    public int mRequestCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.gl
 * JD-Core Version:    0.7.0.1
 */