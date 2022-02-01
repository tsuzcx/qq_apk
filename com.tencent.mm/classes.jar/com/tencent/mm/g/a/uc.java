package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uc
  extends IEvent
{
  public a eav;
  
  public uc()
  {
    this((byte)0);
  }
  
  private uc(byte paramByte)
  {
    AppMethodBeat.i(194250);
    this.eav = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(194250);
  }
  
  public static final class a
  {
    public long eaw;
    public String sessionId;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.uc
 * JD-Core Version:    0.7.0.1
 */