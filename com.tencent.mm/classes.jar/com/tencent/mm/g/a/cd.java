package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cd
  extends IEvent
{
  public a dFn;
  
  public cd()
  {
    this((byte)0);
  }
  
  private cd(byte paramByte)
  {
    AppMethodBeat.i(91200);
    this.dFn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91200);
  }
  
  public static final class a
  {
    public String dFk;
    public String dFl;
    public long dFm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.cd
 * JD-Core Version:    0.7.0.1
 */