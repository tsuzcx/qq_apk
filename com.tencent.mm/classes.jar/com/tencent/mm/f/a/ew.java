package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ew
  extends IEvent
{
  public a fAO;
  
  public ew()
  {
    this((byte)0);
  }
  
  private ew(byte paramByte)
  {
    AppMethodBeat.i(115999);
    this.fAO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115999);
  }
  
  public static final class a
  {
    public String fzB;
    public boolean fzJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.ew
 * JD-Core Version:    0.7.0.1
 */