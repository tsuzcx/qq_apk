package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ra
  extends IEvent
{
  public a fPR;
  public b fPS;
  
  public ra()
  {
    this((byte)0);
  }
  
  private ra(byte paramByte)
  {
    AppMethodBeat.i(155374);
    this.fPR = new a();
    this.fPS = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155374);
  }
  
  public static final class a
  {
    public String fPT;
    public String fPU;
    public String fPV;
    public int fPW = 0;
    public int fPX = 0;
    public int opType = 0;
  }
  
  public static final class b
  {
    public boolean fyl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ra
 * JD-Core Version:    0.7.0.1
 */