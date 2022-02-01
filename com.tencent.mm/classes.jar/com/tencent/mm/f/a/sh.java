package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sh
  extends IEvent
{
  public a fRP;
  
  public sh()
  {
    this((byte)0);
  }
  
  private sh(byte paramByte)
  {
    AppMethodBeat.i(114406);
    this.fRP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114406);
  }
  
  public static final class a
  {
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.sh
 * JD-Core Version:    0.7.0.1
 */