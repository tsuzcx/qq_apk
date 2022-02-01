package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ki
  extends IEvent
{
  public a hLU;
  public b hLV;
  
  public ki()
  {
    this((byte)0);
  }
  
  private ki(byte paramByte)
  {
    AppMethodBeat.i(116029);
    this.hLU = new a();
    this.hLV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116029);
  }
  
  public static final class a
  {
    public int hLW = 0;
    public int hLX = 0;
    public long hLY = -1L;
    public long msgId = -1L;
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
 * Qualified Name:     com.tencent.mm.autogen.a.ki
 * JD-Core Version:    0.7.0.1
 */