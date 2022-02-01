package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ex
  extends IEvent
{
  public a fAP;
  
  public ex()
  {
    this((byte)0);
  }
  
  private ex(byte paramByte)
  {
    AppMethodBeat.i(116000);
    this.fAP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116000);
  }
  
  public static final class a
  {
    public byte[] data;
    public String fzB;
    public String fzM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.ex
 * JD-Core Version:    0.7.0.1
 */