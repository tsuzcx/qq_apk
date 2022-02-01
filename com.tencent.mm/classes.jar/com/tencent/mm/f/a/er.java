package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class er
  extends IEvent
{
  public a fAG;
  
  public er()
  {
    this((byte)0);
  }
  
  private er(byte paramByte)
  {
    AppMethodBeat.i(115994);
    this.fAG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115994);
  }
  
  public static final class a
  {
    public byte[] data;
    public String fzB;
    public String fzM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.er
 * JD-Core Version:    0.7.0.1
 */