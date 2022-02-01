package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abt
  extends IEvent
{
  public a gbD;
  
  public abt()
  {
    this((byte)0);
  }
  
  private abt(byte paramByte)
  {
    AppMethodBeat.i(240920);
    this.gbD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(240920);
  }
  
  public static final class a
  {
    public int fXY;
    public boolean gbE;
    public int gbF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.abt
 * JD-Core Version:    0.7.0.1
 */