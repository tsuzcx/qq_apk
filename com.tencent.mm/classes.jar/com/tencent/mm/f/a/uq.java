package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uq
  extends IEvent
{
  public a fTT;
  
  public uq()
  {
    this((byte)0);
  }
  
  private uq(byte paramByte)
  {
    AppMethodBeat.i(120831);
    this.fTT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(120831);
  }
  
  public static final class a
  {
    public String filePath;
    public int fwM;
    public int scene = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.uq
 * JD-Core Version:    0.7.0.1
 */