package com.tencent.mm.autogen.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xj
  extends IEvent
{
  public a iaN;
  
  public xj()
  {
    this((byte)0);
  }
  
  private xj(byte paramByte)
  {
    AppMethodBeat.i(369327);
    this.iaN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369327);
  }
  
  public static final class a
  {
    public String action;
    public Intent intent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.xj
 * JD-Core Version:    0.7.0.1
 */