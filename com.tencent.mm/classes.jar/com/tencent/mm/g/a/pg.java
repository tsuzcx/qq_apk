package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pg
  extends IEvent
{
  public a dVo;
  
  public pg()
  {
    this((byte)0);
  }
  
  private pg(byte paramByte)
  {
    AppMethodBeat.i(149877);
    this.dVo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149877);
  }
  
  public static final class a
  {
    public boolean pause;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.pg
 * JD-Core Version:    0.7.0.1
 */