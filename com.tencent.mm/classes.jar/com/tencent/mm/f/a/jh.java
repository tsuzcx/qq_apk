package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jh
  extends IEvent
{
  public a fGy;
  public b fGz;
  
  public jh()
  {
    this((byte)0);
  }
  
  private jh(byte paramByte)
  {
    AppMethodBeat.i(116029);
    this.fGy = new a();
    this.fGz = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116029);
  }
  
  public static final class a
  {
    public int fGA = 0;
    public int fGB = 0;
    public long fGC = -1L;
    public long msgId = -1L;
  }
  
  public static final class b
  {
    public int fxe = 0;
    public int fxf = 0;
    public int fxg = 0;
    public int fxh = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.jh
 * JD-Core Version:    0.7.0.1
 */