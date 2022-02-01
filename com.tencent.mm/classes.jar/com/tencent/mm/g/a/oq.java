package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class oq
  extends IEvent
{
  public a dUF;
  
  public oq()
  {
    this((byte)0);
  }
  
  private oq(byte paramByte)
  {
    AppMethodBeat.i(126680);
    this.dUF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(126680);
  }
  
  public static final class a
  {
    public int dKy;
    public long dUG;
    public boolean dUH = false;
    public int length;
    public String mediaId;
    public int offset;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.oq
 * JD-Core Version:    0.7.0.1
 */