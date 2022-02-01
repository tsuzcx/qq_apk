package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hz;
import com.tencent.mm.sdk.event.IEvent;

public final class abj
  extends IEvent
{
  public a ieX;
  
  public abj()
  {
    this((byte)0);
  }
  
  private abj(byte paramByte)
  {
    AppMethodBeat.i(369348);
    this.ieX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369348);
  }
  
  public static final class a
  {
    public long commentId = 0L;
    public long feedId;
    public long hJY = 0L;
    public hz ieY;
    public int opType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abj
 * JD-Core Version:    0.7.0.1
 */