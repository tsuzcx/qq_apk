package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ht
  extends IEvent
{
  public a fEK;
  
  public ht()
  {
    this((byte)0);
  }
  
  private ht(byte paramByte)
  {
    AppMethodBeat.i(276018);
    this.fEK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(276018);
  }
  
  public static final class a
  {
    public long id;
    public int stickyTime;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ht
 * JD-Core Version:    0.7.0.1
 */