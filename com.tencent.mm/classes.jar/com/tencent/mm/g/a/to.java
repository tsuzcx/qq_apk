package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class to
  extends IEvent
{
  public a dZY;
  
  public to()
  {
    this((byte)0);
  }
  
  private to(byte paramByte)
  {
    AppMethodBeat.i(120831);
    this.dZY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(120831);
  }
  
  public static final class a
  {
    public int dEb;
    public String filePath;
    public int scene = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.to
 * JD-Core Version:    0.7.0.1
 */