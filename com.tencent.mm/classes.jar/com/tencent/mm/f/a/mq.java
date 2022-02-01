package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mq
  extends IEvent
{
  public a fKP;
  
  public mq()
  {
    this((byte)0);
  }
  
  private mq(byte paramByte)
  {
    AppMethodBeat.i(155372);
    this.fKP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155372);
  }
  
  public static final class a
  {
    public String content;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.mq
 * JD-Core Version:    0.7.0.1
 */