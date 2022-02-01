package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aby
  extends IEvent
{
  public a gbU;
  public b gbV;
  
  public aby()
  {
    this((byte)0);
  }
  
  private aby(byte paramByte)
  {
    AppMethodBeat.i(19850);
    this.gbU = new a();
    this.gbV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19850);
  }
  
  public static final class a
  {
    public int fvK;
    public String username;
  }
  
  public static final class b
  {
    public int gbW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.aby
 * JD-Core Version:    0.7.0.1
 */