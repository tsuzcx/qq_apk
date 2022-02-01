package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mr
  extends IEvent
{
  public a dSi;
  
  public mr()
  {
    this((byte)0);
  }
  
  private mr(byte paramByte)
  {
    AppMethodBeat.i(19820);
    this.dSi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19820);
  }
  
  public static final class a
  {
    public int dSj;
    public int dSk;
    public int dSl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.mr
 * JD-Core Version:    0.7.0.1
 */