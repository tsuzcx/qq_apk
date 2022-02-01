package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ko
  extends IEvent
{
  public a dPG;
  
  public ko()
  {
    this((byte)0);
  }
  
  private ko(byte paramByte)
  {
    AppMethodBeat.i(130754);
    this.dPG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130754);
  }
  
  public static final class a
  {
    public int keycode = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.ko
 * JD-Core Version:    0.7.0.1
 */