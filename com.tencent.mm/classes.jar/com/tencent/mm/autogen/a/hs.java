package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hs
  extends IEvent
{
  public a hIO;
  public b hIP;
  
  public hs()
  {
    this((byte)0);
  }
  
  private hs(byte paramByte)
  {
    AppMethodBeat.i(106599);
    this.hIO = new a();
    this.hIP = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(106599);
  }
  
  public static final class a
  {
    public String hIQ;
  }
  
  public static final class b
  {
    public int hBJ = 0;
    public int hBK = 0;
    public int hBL = 0;
    public int hBM = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.hs
 * JD-Core Version:    0.7.0.1
 */