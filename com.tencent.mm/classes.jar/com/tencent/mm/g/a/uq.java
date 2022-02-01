package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uq
  extends IEvent
{
  public a eaT;
  
  public uq()
  {
    this((byte)0);
  }
  
  private uq(byte paramByte)
  {
    AppMethodBeat.i(223488);
    this.eaT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(223488);
  }
  
  public static final class a
  {
    public String action;
    public Intent intent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.uq
 * JD-Core Version:    0.7.0.1
 */