package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dj
  extends IEvent
{
  public a hDo;
  
  public dj()
  {
    this((byte)0);
  }
  
  private dj(byte paramByte)
  {
    AppMethodBeat.i(42652);
    this.hDo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42652);
  }
  
  public static final class a
  {
    public long msgId;
    public int msgType;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.dj
 * JD-Core Version:    0.7.0.1
 */