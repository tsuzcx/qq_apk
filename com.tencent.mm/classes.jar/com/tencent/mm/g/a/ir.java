package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ir
  extends IEvent
{
  public a dNm;
  public b dNn;
  
  public ir()
  {
    this((byte)0);
  }
  
  private ir(byte paramByte)
  {
    AppMethodBeat.i(116029);
    this.dNm = new a();
    this.dNn = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116029);
  }
  
  public static final class a
  {
    public int dNo = 0;
    public int dNp = 0;
    public long dNq = -1L;
    public long msgId = -1L;
  }
  
  public static final class b
  {
    public int dEq = 0;
    public int dEr = 0;
    public int dEs = 0;
    public int dEt = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ir
 * JD-Core Version:    0.7.0.1
 */