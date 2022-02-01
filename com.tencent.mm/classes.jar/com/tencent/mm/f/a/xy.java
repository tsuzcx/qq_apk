package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xy
  extends IEvent
{
  public a fXk;
  
  public xy()
  {
    this((byte)0);
  }
  
  private xy(byte paramByte)
  {
    AppMethodBeat.i(19837);
    this.fXk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19837);
  }
  
  public static final class a
  {
    public String fVa;
    public String fXl;
    public int fXm;
    public String nickName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.xy
 * JD-Core Version:    0.7.0.1
 */