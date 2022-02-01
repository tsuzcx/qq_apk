package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ch;
import com.tencent.mm.sdk.event.IEvent;

public final class im
  extends IEvent
{
  public a hJX;
  
  public im()
  {
    this((byte)0);
  }
  
  private im(byte paramByte)
  {
    AppMethodBeat.i(168881);
    this.hJX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168881);
  }
  
  public static final class a
  {
    public long commentId = 0L;
    public long feedId;
    public long hJY = 0L;
    public ch hJZ;
    public int opType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.im
 * JD-Core Version:    0.7.0.1
 */