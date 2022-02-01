package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class he
  extends IEvent
{
  public a dLG;
  
  public he()
  {
    this((byte)0);
  }
  
  private he(byte paramByte)
  {
    AppMethodBeat.i(241571);
    this.dLG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(241571);
  }
  
  public static final class a
  {
    public boolean dLH;
    public long feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.he
 * JD-Core Version:    0.7.0.1
 */