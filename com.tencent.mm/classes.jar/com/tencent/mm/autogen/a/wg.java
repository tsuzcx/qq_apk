package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wg
  extends IEvent
{
  public a hZR;
  
  public wg()
  {
    this((byte)0);
  }
  
  private wg(byte paramByte)
  {
    AppMethodBeat.i(120831);
    this.hZR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(120831);
  }
  
  public static final class a
  {
    public String filePath;
    public int hBm;
    public int scene = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.wg
 * JD-Core Version:    0.7.0.1
 */