package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class am
  extends IEvent
{
  public a dDo;
  public b dDp;
  
  public am()
  {
    this((byte)0);
  }
  
  private am(byte paramByte)
  {
    AppMethodBeat.i(42651);
    this.dDo = new a();
    this.dDp = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42651);
  }
  
  public static final class a
  {
    public int dDq = 0;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.am
 * JD-Core Version:    0.7.0.1
 */