package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aav
  extends IEvent
{
  public a ieu;
  
  public aav()
  {
    this((byte)0);
  }
  
  private aav(byte paramByte)
  {
    AppMethodBeat.i(369317);
    this.ieu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369317);
  }
  
  public static final class a
  {
    public long costTime;
    public int hJx;
    public int iev;
    public int iew;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aav
 * JD-Core Version:    0.7.0.1
 */