package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jm
  extends IEvent
{
  public a fGK;
  public b fGL;
  
  public jm()
  {
    this((byte)0);
  }
  
  private jm(byte paramByte)
  {
    AppMethodBeat.i(89643);
    this.fGK = new a();
    this.fGL = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89643);
  }
  
  public static final class a
  {
    public int Vh = 0;
    public String param;
  }
  
  public static final class b
  {
    public String fGM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.jm
 * JD-Core Version:    0.7.0.1
 */