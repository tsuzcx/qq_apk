package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tf
  extends IEvent
{
  public a hWN;
  
  public tf()
  {
    this((byte)0);
  }
  
  private tf(byte paramByte)
  {
    AppMethodBeat.i(91213);
    this.hWN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91213);
  }
  
  public static final class a
  {
    public String content;
    public String hQQ;
    public String hWO;
    public String toUser;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.tf
 * JD-Core Version:    0.7.0.1
 */