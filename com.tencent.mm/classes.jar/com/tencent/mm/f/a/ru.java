package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.sdk.event.IEvent;

public final class ru
  extends IEvent
{
  public a fQX;
  
  public ru()
  {
    this((byte)0);
  }
  
  private ru(byte paramByte)
  {
    AppMethodBeat.i(91215);
    this.fQX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91215);
  }
  
  public static final class a
  {
    public String fJG;
    public k.b fQY;
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ru
 * JD-Core Version:    0.7.0.1
 */