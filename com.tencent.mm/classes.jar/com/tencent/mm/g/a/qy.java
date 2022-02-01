package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qy
  extends IEvent
{
  public a dXy;
  
  public qy()
  {
    this((byte)0);
  }
  
  private qy(byte paramByte)
  {
    AppMethodBeat.i(116041);
    this.dXy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116041);
  }
  
  public static final class a
  {
    public String filePath;
    public String result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.qy
 * JD-Core Version:    0.7.0.1
 */