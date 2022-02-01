package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class df
  extends IEvent
{
  public a fyV;
  
  public df()
  {
    this((byte)0);
  }
  
  private df(byte paramByte)
  {
    AppMethodBeat.i(241019);
    this.fyV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(241019);
  }
  
  public static final class a
  {
    public int action;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.df
 * JD-Core Version:    0.7.0.1
 */