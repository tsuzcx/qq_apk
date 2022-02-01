package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ax
  extends IEvent
{
  public a dDY;
  
  public ax()
  {
    this((byte)0);
  }
  
  private ax(byte paramByte)
  {
    AppMethodBeat.i(115970);
    this.dDY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115970);
  }
  
  public static final class a
  {
    public long dDZ;
    public String filePath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ax
 * JD-Core Version:    0.7.0.1
 */