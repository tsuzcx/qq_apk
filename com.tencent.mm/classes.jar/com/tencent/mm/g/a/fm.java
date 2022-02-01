package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fm
  extends IEvent
{
  public a dIM;
  
  public fm()
  {
    this((byte)0);
  }
  
  private fm(byte paramByte)
  {
    AppMethodBeat.i(116014);
    this.dIM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116014);
  }
  
  public static final class a
  {
    public String brandName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.fm
 * JD-Core Version:    0.7.0.1
 */