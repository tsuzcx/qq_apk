package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bk
  extends IEvent
{
  public a hBw;
  
  public bk()
  {
    this((byte)0);
  }
  
  private bk(byte paramByte)
  {
    AppMethodBeat.i(369389);
    this.hBw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369389);
  }
  
  public static final class a
  {
    public String nickName;
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.bk
 * JD-Core Version:    0.7.0.1
 */