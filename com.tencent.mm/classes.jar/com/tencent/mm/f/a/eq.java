package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class eq
  extends IEvent
{
  public a fAE;
  
  public eq()
  {
    this((byte)0);
  }
  
  private eq(byte paramByte)
  {
    AppMethodBeat.i(115993);
    this.fAE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115993);
  }
  
  public static final class a
  {
    public int fAF;
    public String fzB;
    public String fzM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.eq
 * JD-Core Version:    0.7.0.1
 */