package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xv
  extends IEvent
{
  public a eeg;
  
  public xv()
  {
    this((byte)0);
  }
  
  private xv(byte paramByte)
  {
    AppMethodBeat.i(94818);
    this.eeg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94818);
  }
  
  public static final class a
  {
    public long gY = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.xv
 * JD-Core Version:    0.7.0.1
 */